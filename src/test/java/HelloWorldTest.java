import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.After;

import java.io.*;
import java.util.Locale;

public class HelloWorldTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@Before
	public void setUp() {
    	System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	public void testMainMethod() {
    	HelloWorld.main(new String[] {"arg1", "arg2", "arg3"});
        
    	Assert.assertEquals("The main() method should print out \"Hello, World!\" \nCheck carefully!" 
			    + "One missing/extra character like a space can fail this test case\n"
			    ,"Hello, World!\n", outputStreamCaptor.toString());
	}
	
	@Test
	public void testpPrintStarPiramidMethod() {
    	HelloWorld.printStarPiramid();
        
    	Assert.assertEquals( "The printStarPiramid() method should print out \n" +
			    "\"    *\"\n" +
        		    "\"   ***\"\n" +
         		    "\"  *****\"\n" +
        		    "\" *******\"\n" +
        		    "\"*********\"\n \nCheck carefully! " +
			    "One missing/extra character like space can make this test case failed\n",
			    "    *\n" +
        		    "   ***\n" +
         		    "  *****\n" +
        		    " *******\n" +
        		    "*********\n"
			    ,outputStreamCaptor.toString());
	}
	
	@Test
	public void testPrintFaceMethod() {
    	HelloWorld.printFace();
        
    	Assert.assertEquals( "The printFace() method should print out \n" +
			    "\" +\"\"\"\"\"+ \"\n" +
        		    "\"[| o o |]\"\n" +
         		    "\" |  ^  | \"\n" +
        		    "\" | '-' | \"\n" +
        		    "\" +-----+ \"\n \nCheck carefully! " +
			    "One missing/extra character like space can make this test case failed\n",
			   " +\"\"\"\"\"+ \n" +
        		   "[| o o |]\n" +
         		   " |  ^  | \n" +
        		   " | '-' | \n" +
        		   " +-----+ \n"
			    , outputStreamCaptor.toString());
	}
	
	
	@After
	public void tearDown() {
    	System.setOut(standardOut);
	}
}
