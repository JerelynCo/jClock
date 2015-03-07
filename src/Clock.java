/** 
 * @author Jerelyn Co, Marion Ivan Tan
 * @version 6.0
 * @date March 7, 2015
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


/**
 * Class that has three functionalities: Digital Time, Stopwatch, and Alarm Clock.
 */
public class Clock {
	static String last = "";
	static DateFormat df = new SimpleDateFormat("hh:mm:ssa");
	static Scanner scan = new Scanner(System.in);
	
	/** 
	 * Main loop for the class
	 * @param args For console's use
	 */
	public static void main(String[] args) {
        int ans = 0;
		do{
			System.out.println("Menu: Type in the number of feature to use");
			System.out.println("(1)\tDigital Time \n(2)\tStopwatch \n(3)\tSet Alarm");
			//User input has to be an integer
			while(!scan.hasNextInt()){
				System.out.println("Enter an integer");
				System.out.println("Menu: Type in the number of feature to use");
				System.out.println("(1)\tDigital Time \n(2)\tStopwatch \n(3)\tSet Alarm");
				scan.next();
			}
			ans = scan.nextInt();
		}while(!checkUserInput(ans));
		
		switch(ans){
			case 1:
				System.out.println("**Clock mode**");
				clock();
			case 2:
				System.out.println("**Stopwatch mode**");
				stopwatch();
				break;
			case 3: 
				System.out.println("**Alarm clock mode**");
				alarmClock();
		}
		scan.close();
	}
	/**
	 * Checks whether the user's int input is valid
	 * @return boolean to check whether the user pressed the right number
	 * @param ans number to be tested
	 */
	public static boolean checkUserInput(int ans){
		//check if the input matches the menu number
		if(ans > 0 && ans < 4){
			return true;
		}
		else{
			System.out.println("Error. Please input again");
			return false;
		}
	}
	/**
	 * Gives the digital time for the clock feature
	 * @return String formatted time to display at main
	 * @param df Format for the time
	 */
	public static String digitalTime(DateFormat df){
		Calendar calobj = Calendar.getInstance();
		return df.format(calobj.getTime());
	}
	/**
	 *Checks if the previous string is equal to the current string 
	 * @return boolean true or false
	 */
	public static boolean checkString(String time){
		return digitalTime(df).equals(time);	
	}
	/**
	 * Displays time in the console
	 * @return prevents printing the same time
	 */
	public static void time(){
		if(!checkString(last)){
			last = digitalTime(df);
			System.out.println("Time: " + last);
		}
	}
	/**
	 * Displays time for the use of alarm clock feature
	 * @return prints the time
	 */
	public static void clock(){
		while(true){
			time();
		}
	}
	/**
	 *Used in the main to determine whether the application has to stop or not 
	 * @return boolean true if the alarm is successfully set
	 */
	public static void alarmClock(){
		System.out.println("**Alarm mode**");
		String hour;
		String minute;
		String second;
		String meridiem;
		do{
			System.out.println("Enter Hour");
			hour = scan.next();
			System.out.println("Enter Minute");
			minute = scan.next();
			System.out.println("Enter Second");
			second = scan.next();
			System.out.println("Enter AM/PM");
			meridiem = scan.next();
		}while(!checkAlarmTime(hour, minute, second, meridiem));
		
		scan.close();
		while(concatenateTime(hour, minute, second, meridiem).equals(last)==false){
			time();
		}
		while(true){
			System.out.println("Alarm!");
		}
		
	}
	static long startTime;
	/**
	 * The method where the user can start and stop the stopwatch feature
	 */
	public static void stopwatch(){		
		int counter = 0;
		System.out.println("**Press s to stop and/or stop**");
		do{
			String toggle = scan.next();
			if(toggle.equalsIgnoreCase("s")){
				counter++;
				if(counter%2!=0){
					System.out.println("Stopwatch Started");
					startTime = System.currentTimeMillis();
				}
				else{
					System.out.println("Stopwatch Stopped");
					if(getTimeElapsed() < 1000){
						System.out.println(getTimeElapsed() + "ms");
					}
					else if(getTimeElapsed() > 1000 && getTimeElapsed() < 60000){
						System.out.println(getTimeElapsed()/1000 + "s" + getTimeElapsed()%1000 + "ms");
					}
					else if(getTimeElapsed() >= 60000){
						System.out.println(getTimeElapsed()/60000 +"m" + (getTimeElapsed()%60000)/1000 + "s" + getTimeElapsed()%1000 + "ms");
					}
				}
			}
			else{
				System.out.println("Try again; Press s to start and stop");
			}
			toggle = ""; //empties toggle string
		}while(true);
	}
	/**
	 * The time elapsed for the stopwatch feature
	 * @return the elapsed time in long
	 */
	public static long getTimeElapsed(){
		return System.currentTimeMillis() - startTime;
	}

	/**
	 * Checks the format of the alarm time set by the user
	 * @param hour the hour of the alarm time
	 * @param minute the minute of the alarm time
	 * @param second the second of the alarm time
	 * @param meridiem the meridiem of the alarm time
	 * @return true if the format of the user's alarm time is valid, false if otherwise
	 */
	public static boolean checkAlarmTime(String hour, String minute, String second, String meridiem){
		try{
			if((Integer.parseInt(hour)>=0 && Integer.parseInt(hour)<=12)
					&& (Integer.parseInt(minute)>=0 && Integer.parseInt(minute)<=59)
					&& (Integer.parseInt(second)>=0 && Integer.parseInt(second)<=59)
					&& (meridiem.equalsIgnoreCase("PM")|| meridiem.equalsIgnoreCase("AM"))){
				return true;
			}
			else{
				return false;
			}
		}
		catch(NumberFormatException nfe){
			return false;
		}
	}
	/**
	 * Concatenates the time components for string checking of the alarm time
	 * @param hour the hour of the alarm time
	 * @param minute the minute of the alarm time
	 * @param second the second of the alarm time
	 * @param meridiem the meridiem of the alarm time
	 * @return the concatenated string for the alarm time checking
	 */
	public static String concatenateTime(String hour, String minute, String second, String meridiem){
		String zeroH = "";
		String zeroM = "";
		String zeroS = "";
		if(hour.length()==1)
			zeroH = "0";
		if(minute.length()==1)
			zeroM = "0";
		if(second.length()==1)
			zeroS = "0";
		return zeroH+hour+":"+zeroM+minute+":"+zeroS+second+meridiem.toUpperCase();		
	}
};

