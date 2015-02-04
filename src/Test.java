import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
	
public class Test{
	DateFormat df = new SimpleDateFormat("hh:mm:ss a");
	public void testDigitalTime(DateFormat df){		
		assertNotNull(Clock.digitalTime(df));
	}
	public void testStopTime(){		
		assertEquals(false, Clock.stopTime());
	}
	public void testCheckUserInput(){	
		assertEquals(false, Clock.checkUserInput(0));
		assertEquals(false, Clock.checkUserInput(4));
		assertEquals(true, Clock.checkUserInput(3));
		assertEquals(true, Clock.checkUserInput(2));
		assertEquals(true, Clock.checkUserInput(1));
	}
}
