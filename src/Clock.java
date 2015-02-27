/** 
 * @author Jerelyn Co, Marion Ivan Tan
 * @version 1.0
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Class Clock will display the digital time.
 */
public class Clock {
	static String last = "";
	static DateFormat df = new SimpleDateFormat("hh:mm:ssa");
	static Scanner scan = new Scanner(System.in);
	
	/** 
	 * @param args For console's use
	 */
	public static void main(String[] args) {
        int ans = 0;
		do{
			System.out.println("Menu: Type in the number of feature to use");
			System.out.println("(1)\tDigital Time \n(2)\tStopwatch \n(3)\tSet Alarm");

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
	/*
	 * @return String formatted time to display at main
	 * @param df Format for the time
	 */
	public static String digitalTime(DateFormat df){
		Calendar calobj = Calendar.getInstance();
		return df.format(calobj.getTime());
	}
	/*
	 *checkString checks if the previous string is equal to the current string 
	 * @return boolean true or false
	 */
	public static boolean checkString(String time){
		return digitalTime(df).equals(time);	
	}
	/**
	 * @return prevents printing the same time
	 */
	public static void time(){
		if(!checkString(last)){
			last = digitalTime(df);
			System.out.println("Time: " + last);
		}
	}
	/**
	 * @return prints the time
	 */
	public static void clock(){
		while(true){
			time();
		}
	}
	/**
	 *alarm will be used in the main to determine whether the application has to stop or not 
	 * @return boolean true if the alarm is successfully set
	 */
	public static void alarmClock(){
		System.out.println("**Alarm mode**");
		System.out.println("Set Alarm in HH:MM:SSa format:");
		String setTime = scan.next();
		scan.close();
		while(setTime.equalsIgnoreCase(last)==false){
			time();
		}
		while(true){
			System.out.println("Alarm!");
		}
	}
	static long startTime;
	static long stopTime;
	/**
	 *stopwatch will be the method where the user can start and stop the stopwatch mode 
	 */
	public static void stopwatch(){		
		int counter = 0;
		System.out.println("**Press s to stop and/or stop**");
		do{
			String toggle = scan.next();
			if(toggle.equals("s")){
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
				System.out.println("Try again");
			}
			toggle = ""; //empties toggle string
		}while(toContinue());
	}
	/**
	 * the elapsed time in long
	 * @return time
	 */
	public static long getTimeElapsed(){
		return (System.currentTimeMillis() - startTime);
	}
	/**
	 * it is the condition the while loop looks at whether to continue or not
	 * @return true
	 */
	public static boolean toContinue(){
		return true;
	}
};

