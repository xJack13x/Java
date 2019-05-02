import calculatorjunit.IntegerNumber;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jacek
 */
public class IntegerNumberTest {
    
    @Test
    public void testAdd(){
        IntegerNumber test = new IntegerNumber();
        int result = test.addNumber(5,2);
        assertEquals(7, result);
    }
    
    @Test
    public void testAddZero(){
        IntegerNumber test = new IntegerNumber();
        int result = test.addNumber(0,0);
        assertEquals(0, result);
    }

    @Test
    public void testAddNegativeNumber(){
        IntegerNumber test = new IntegerNumber();
        int result = test.addNumber(-1,-2);
        assertEquals(-3, result);
    }

    @Test
    public void testAddNegativeNumber2(){
        IntegerNumber test = new IntegerNumber();
        int result = test.addNumber(1,-2);
        assertEquals(-1, result);
    }

    @Test
    public void testSubtractNumberZero(){
        IntegerNumber test = new IntegerNumber();
        int result = test.subtractNumber(5,2);
        assertEquals(3, result);
    }

    @Test
    public void testSubtractNumberZero2(){
        IntegerNumber test = new IntegerNumber();
        int result = test.subtractNumber(0,2);
        assertEquals(-2, result);
    }

    @Test
    public void testSubtractNumberZero3(){
        IntegerNumber test = new IntegerNumber();
        int result = test.subtractNumber(1,0);
        assertEquals(1, result);
    }

    @Test
    public void testSubtractNumberNegative(){
        IntegerNumber test = new IntegerNumber();
        int result = test.subtractNumber(-3,-2);
        assertEquals(-1, result);
    }

    @Test
    public void testSubtractNumberNegative2(){
        IntegerNumber test = new IntegerNumber();
        int result = test.subtractNumber(3,-2);
        assertEquals(5, result);
    }
    
    @Test
    public void testMultiplyNumber(){
        IntegerNumber test = new IntegerNumber();
        int result = test.multiplyNumber(5,2);
        assertEquals(10, result);
    }
    @Test
    public void testMultiplyNumberZero(){
        IntegerNumber test = new IntegerNumber();
        int result = test.multiplyNumber(0,2);
        assertEquals(0, result);
    }


    @Test
    public void testMultiplyNumberZero2(){
        IntegerNumber test = new IntegerNumber();
        int result = test.multiplyNumber(2,0);
        assertEquals(0, result);
    }


    @Test
    public void testMultiplyNumberZero3(){
        IntegerNumber test = new IntegerNumber();
        int result = test.multiplyNumber(0,0);
        assertEquals(0, result);
    }


    @Test
    public void testMultiplyNumberNegative(){
        IntegerNumber test = new IntegerNumber();
        int result = test.multiplyNumber(-2,-3);
        assertEquals(6, result);
    }


    @Test
    public void testMultiplyNumberNegative2(){
        IntegerNumber test = new IntegerNumber();
        int result = test.multiplyNumber(2,-3);
        assertEquals(-6, result);
    }

    @Test
    public void testDivideNumber(){
        IntegerNumber test = new IntegerNumber();
        int result = test.divideNumber(5,5);
        assertEquals(1, result);
    }

    @Test
    public void testDivideNumber2(){
        IntegerNumber test = new IntegerNumber();
        int result = test.divideNumber(0,5);
        assertEquals(0, result);
    }

    @Test
    public void testDivideNumberRemainder(){
        IntegerNumber test = new IntegerNumber();
        int result = test.divideNumber(5,2);
        assertEquals(2, result);
    }

    @Test
    public void testDivideNumberResultZero(){
        IntegerNumber test = new IntegerNumber();
        int result = test.divideNumber(2,5);
        assertEquals(0, result);
    }

    @Test
    public void testDivideNumberZero(){
        IntegerNumber test = new IntegerNumber();

        try {
            IntegerNumber.divideNumber(2,0);
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Niedozwolone dzielenie przez 0",ex.getMessage());

        }
    }

    @Test
    public void testDivideNumberNegative(){
        IntegerNumber test = new IntegerNumber();
        int result = test.divideNumber(6,-2);
        assertEquals(-3, result);
    }

    @Test
    public void testDivideNumberNegative2(){
        IntegerNumber test = new IntegerNumber();
        int result = test.divideNumber(-6,-2);
        assertEquals(3, result);
    }

    @Test
    public void testFactorialNumberZero(){
        IntegerNumber test = new IntegerNumber();

        assertEquals(1,IntegerNumber.factorialNumber(0));

    }

    @Test
    public void testFactorialNumberOne(){
        IntegerNumber test = new IntegerNumber();
        int result = (int) test.factorialNumber(1);
        assertEquals(1, result);
    }
    
    @Test
    public void testFactorialNumberZero2(){
        IntegerNumber test = new IntegerNumber();
        int result = (int) test.factorialNumber(4);
        assertEquals(24, result);
    }  
}
