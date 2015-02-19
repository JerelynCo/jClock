import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
	
public class Test{
	DateFormat df = new SimpleDateFormat("hh:mm:ss a");
	public void testDigitalTime(DateFormat df){		
		assertNotNull(Clock.digitalTime(df));
	}
	public void testCheckString(){		
		assertNotNull(Clock.checkString("12:00:00AM"));
		assertNotNull(Clock.checkString("01:12:00PM"));
		assertEquals(false,Clock.checkString("12:00:00AM"));

	}
	public void testCheckUserInput(){	
		assertEquals(false, Clock.checkUserInput(0));
		assertEquals(false, Clock.checkUserInput(4));
		assertEquals(true, Clock.checkUserInput(3));
		assertEquals(true, Clock.checkUserInput(2));
		assertEquals(true, Clock.checkUserInput(1));
	}
	public void testToContinue(){
		assertNotNull(Clock.toContinue());
		assertEquals(true,Clock.toContinue());
	}
	public void testGetTimeElapsed(){
		assertNotNull(Clock.toContinue());
	}
}