package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testUnknownNumbers(){
    	assertEquals(37, Calculator.add("1,2,3,0,0,3,4,6,7,2,5,4"));
    }

    @Test
    public void testTwoDelimiters(){
    	assertEquals(10, Calculator.add("1\n2,3\n4"));
    }

    @Test
    public void testOnlyNewLineDelimiters(){
    	assertEquals(10, Calculator.add("1\n2\n3\n4"));
    }

    @Test
    public void testCustomDelimiters(){
    	assertEquals(3, Calculator.add("//p\n1p2"));
    }

    @Test
    public void testNegativeNumberException(){
    	assertEquals(-1, Calculator.add("-3,3"));
    }

    @Test
    public void testNumbersToHigh(){
    	assertEquals(3, Calculator.add("1001,3"));
    }

    @Test
    public void testLarge (){
    	assertEquals(3, Calculator.add("1001,3"));
    }

    @Test
    public void testLongCustomDelimiter (){
    	assertEquals(6, Calculator.add("//Del\n1Del2Del3"));
    }


}