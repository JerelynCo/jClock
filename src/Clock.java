/** 
 * @author Jerelyn Co, Marion Ivan Tan
 * @version 1.0
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/*

/*
 * Class Clock will display the digital time.
 */

public class Clock {
	/*
	 * @return String "Time: " and the formatted time from method digital time
	 * @param args For console's use
	 */
	static String last = "";
	static DateFormat df = new SimpleDateFormat("hh:mm:ssa");
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Menu: Type in the number of feature to use");
		System.out.println("(1)\tDigital Time \n(2)\tStopwatch \n(3)\tSet Alarm");
		int ans = scan.nextInt();
		
		while(ans>3){
			System.out.println("Error. Please input again");
			ans = scan.nextInt();
		}
		switch(ans){
			case 1:
				clock();
			case 2:
				//Stop watch
				break;
			case 3: 
				alarmClock();
		}
		scan.close();
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
	 *stopTime will be used in the main to determine whether the application has to stop or not 
	 * @return boolean to stop time
	 */
	public static boolean stopTime(){
		return false;	
	}

	/*
	 * @return prevents printing the same time
	 */
	public static void time(){
		if(!digitalTime(df).equals(last)){
			last = digitalTime(df);
			System.out.println("Time: " + last);
		}
	}
	/*
	 * @return prints the time
	 */
	public static void clock(){
		while(!stopTime()){
			time();
		}
	}
	/*
	 *alarm will be used in the main to determine whether the application has to stop or not 
	 * @return boolean true if the alarm is successfully set
	 */
	public static void alarmClock(){
		String setTime = scan.next();
		scan.close();
		while(setTime.equalsIgnoreCase(last)==false){
			time();
		}
		while(true){
			System.out.println("Alarm!");
		}
	}
};
