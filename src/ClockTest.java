import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;


public class ClockTest{
	DateFormat df = new SimpleDateFormat("hh:mm:ss a");
	
	public void testDigitalTime(DateFormat df){		
		assertNotNull(Clock.digitalTime(df));
	}
	
	//Whether the user pressed an int or any other type is already checked.
	@Test
	public void testCheckUserInput(){		
		assertEquals(true, Clock.checkUserInput(3));
		assertEquals(true, Clock.checkUserInput(2));
		assertEquals(true, Clock.checkUserInput(1));
		assertEquals(false,Clock.checkUserInput(5));
		assertEquals(false,Clock.checkUserInput(-9));
		assertEquals(false,Clock.checkUserInput(98));
		assertEquals(false,Clock.checkUserInput(04));
		assertEquals(false, Clock.checkUserInput(0));
		assertEquals(false, Clock.checkUserInput(4));
	}
	
	@Test
	public void testGetTimeElapsed(){
		assertNotNull(Clock.getTimeElapsed());
	}

	@Test
	public void testCheckAlarmTime(){		
		assertEquals(false,Clock.checkAlarmTime("a", "12", "11", "a"));
		assertNotNull(Clock.checkAlarmTime("a", "12", "11", ""));
		assertEquals(false,Clock.checkAlarmTime("3", "61", "12", "am"));
		assertEquals(false,Clock.checkAlarmTime("123", "1", "12", "PM"));
		assertEquals(false,Clock.checkAlarmTime("ka", "12", "-123", "AM"));
		assertEquals(false,Clock.checkAlarmTime("1", "2", "3", "GM"));
		assertEquals(false,Clock.checkAlarmTime("12", "0", "4", "lol"));	
		assertEquals(true,Clock.checkAlarmTime("2", "12", "11", "AM"));
		assertEquals(true,Clock.checkAlarmTime("12", "1", "59", "am"));
		assertEquals(true,Clock.checkAlarmTime("1", "5", "0", "PM"));
		assertEquals(true,Clock.checkAlarmTime("9", "0", "12", "pm"));
	}
	
	@Test
	public void testConcatenaTime(){
		assertEquals("01:00:12PM",Clock.concatenateTime("1", "0", "12", "pm"));
		assertEquals("12:12:12PM",Clock.concatenateTime("12", "12", "12", "pM"));
		assertEquals("01:01:10AM",Clock.concatenateTime("1", "01", "10", "am"));
		assertEquals("00:02:13AM",Clock.concatenateTime("00", "2", "13", "AM"));
		assertEquals("01:59:10AM",Clock.concatenateTime("1", "59", "10", "Am"));
		assertEquals("01:05:12PM",Clock.concatenateTime("1", "05", "12", "pm"));
		assertEquals("12:12:02AM",Clock.concatenateTime("12", "12", "2", "AM"));
		assertEquals("08:01:01AM",Clock.concatenateTime("8", "01", "1", "am"));
		assertEquals("09:12:13AM",Clock.concatenateTime("09", "12", "13", "aM"));
		assertEquals("07:55:39PM",Clock.concatenateTime("7", "55", "39", "pm"));
	}
}



