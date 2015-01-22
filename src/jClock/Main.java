package jClock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String[] args){
		getTime();
	}
	
	static void getTime(){
		
		//for(int i = 0; i<100; i++){	
		    Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
			String formattedDate = sdf.format(date);
			System.out.println(formattedDate); // 12/01/2011 4:48:16 PM
		//}
	}	
}
