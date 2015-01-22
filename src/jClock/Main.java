package jClock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);//not using this yet
	static String input = "";
	public static void main(String[] args){
		getTime();
	}
	
	static void getTime(){
	input = "red";	
		while(input.equals("end") == false ){	
		    Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
			String formattedDate = sdf.format(date);
			System.out.println(formattedDate); // 12/01/2011 4:48:16 PM
			input = "asd";
		}
		
	}	
}
