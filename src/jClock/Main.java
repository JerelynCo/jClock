package jClock;

//import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String input = "";
	static boolean stop = false;
	//static KeyEvent event;
	public static void main(String[] args){
		getTime();
	}
	
	static void getTime(){
	
		while(true ){	
		    Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
			String formattedDate = sdf.format(date);
			System.out.println(formattedDate); // 12/01/2011 4:48:16 PM
		}
	}

}

/*static void keyPressed(KeyEvent e) {

int key = e.getKeyCode();
if (key == KeyEvent.VK_LEFT) {
    stop = true;
}
else{
	stop = false;
}
}

static void keyReleased(KeyEvent e) {
   
int key = e.getKeyCode();
if (key == KeyEvent.VK_LEFT) {
    stop = true;
}

input = scanner.next();
			if(scanner.hasNext()==true){
				stop = true;
			}
			else{
				stop = false;
			}
*/