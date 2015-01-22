import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Clock {
	public Clock(){
		final int WIDTH = 480;
		final int HEIGHT = 640;
	}
	
	public static void main(String[] args) {
		String last = "";
		DateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm:ss a");
		while(!stopTime()){
			if(!digitalTime(df).equals(last)){
				last = digitalTime(df);
				System.out.println(last);
			}
		}
	}
	public static String digitalTime(DateFormat df){
		Calendar calobj = Calendar.getInstance();
		return df.format(calobj.getTime());
	}
	
	public static boolean stopTime(){
		return false;	
	}
	public static boolean alarm(){
		return true;
	}

};
