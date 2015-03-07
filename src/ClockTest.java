import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;


public class ClockTest {

	DateFormat df = new SimpleDateFormat("hh:mm:ss a");
	/*@Test
	public void testDigitalTime(DateFormat df){		
		assertNotNull(Clock.digitalTime(df));
	}*/
	
	@Test
	public void testCheckUserInput(){	
		assertEquals(false, Clock.checkUserInput(0));
		assertEquals(false, Clock.checkUserInput(4));
		assertEquals(true, Clock.checkUserInput(3));
		assertEquals(true, Clock.checkUserInput(2));
		assertEquals(true, Clock.checkUserInput(1));
		assertEquals(false,Clock.checkUserInput(5));
		assertEquals(false,Clock.checkUserInput(-9));
		assertEquals(false,Clock.checkUserInput(98));
		assertEquals(false,Clock.checkUserInput(04));
		assertEquals(Clock.checkUserInput(3),Clock.checkUserInput(2));
	}
	@Test
	public void testToContinue(){
		assertNotNull(Clock.toContinue());
		assertEquals(true,Clock.toContinue());
		assertNotEquals(false,Clock.toContinue());
	}
	@Test
	public void testGetTimeElapsed(){
		assertNotNull(Clock.getTimeElapsed());
		assertEquals(Clock.getTimeElapsed(),Clock.getTimeElapsed());
	}

}
