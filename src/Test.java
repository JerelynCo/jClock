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
		assertEquals(false,Clock.checkString("25:00:00AM"));
		assertEquals(false,Clock.checkString("13:70:00AM"));
		assertEquals(false,Clock.checkString("13:00:89AM"));
		assertEquals(false,Clock.checkString("13:70:61AM"));
		assertEquals(false,Clock.checkString("13:70:61AN"));
		assertEquals(false,Clock.checkString("13:00:00GM"));
		assertEquals(false,Clock.checkString("25:70:61GM"));
		assertEquals(Clock.checkString("13:70:61AM"),Clock.checkString("25:70:61GM"));
	}
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
	public void testToContinue(){
		assertNotNull(Clock.toContinue());
		assertEquals(true,Clock.toContinue());
		assertNotEquals(false,Clock.toContinue());
	}
	public void testGetTimeElapsed(){
		assertNotNull(Clock.getTimeElapsed());
		assertEquals(Clock.getTimeElapsed(),Clock.getTimeElapsed());
	}
}