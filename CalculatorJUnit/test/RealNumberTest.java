import calculatorjunit.RealNumber;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class RealNumberTest {
    
    @Test
    public void testAddRealNumber(){
        RealNumber test = new RealNumber();
        double result = test.addRealNumber( 5.3,  2.3);
        assertEquals(7.6, result, 0.0);
    }

    @Test
    public void testAddRealNumberInteger(){
        RealNumber test = new RealNumber();
        double result = test.addRealNumber(5,  2);
        assertEquals(7, result, 0.0);
    }

    @Test
    public void testAddRealNumberZero(){
        RealNumber test = new RealNumber();
        double r = test.addRealNumber( 0.0,  0.0);
        assertEquals(0.0, r, 0.0);
    }

    @Test
    public void testAddRealNumberNegative(){
        RealNumber test = new RealNumber();
        double result = test.addRealNumber( -2.2,  -3.2);
        assertEquals(-5.4, result, 0.0);
    }

    @Test
    public void testSubtractRealNumber(){
        RealNumber test = new RealNumber();
        double result = test.subtractRealNumber( 5.5,  2.2);
        assertEquals(3.3, result, 0.0);
    }

    @Test
    public void testSubtractRealNumber2(){
        RealNumber test = new RealNumber();
        double result = test.subtractRealNumber( 50,  20);
        assertEquals(30, result, 0.0);
    }

    @Test
    public void testSubtractRealNumberZero(){
        RealNumber test = new RealNumber();
        double result = test.subtractRealNumber( 0.0,  2.2);
        assertEquals(-2.2, result, 0.0);
    }

    @Test
    public void testSubtractRealNumberZero2(){
        RealNumber test = new RealNumber();
        double result = test.subtractRealNumber( 3.3,  0.0);
        assertEquals(3.3, result, 0.0);
    }

    @Test
    public void testSubtractRealNumberNegative(){
        RealNumber test = new RealNumber();
        double result = test.subtractRealNumber( -10.0,  -3.0);
        assertEquals(-7, result, 0.0);
    }

    @Test
    public void testMultiplyRealNumber(){
        RealNumber test = new RealNumber();
        double result = test.multiplyRealNumber( 5.2,  2.2);
        assertEquals(11.440000000000001, result, 0.0);
    }

    @Test
    public void testMultiplyRealNumberZero(){
        RealNumber test = new RealNumber();
        double result = test.multiplyRealNumber( 0.0,  2.2);
        assertEquals(0.0, result, 0.0);
    }

    @Test
    public void testMultiplyRealNumberZero2(){
        RealNumber test = new RealNumber();
        double result = test.multiplyRealNumber( 2.2,  0.0);
        assertEquals(0.0, result, 0.0);
    }

    @Test
    public void testMultiplyRealNumber3(){
        RealNumber test = new RealNumber();
        double result = test.multiplyRealNumber( 0.0,  0.0);
        assertEquals(0.0, result, 0.0);
    }

    @Test
    public void testMultiplyRealNumber4(){
        RealNumber test = new RealNumber();
        double result = test.multiplyRealNumber( -5,   -2.5);
        assertEquals(12.5, result, 0.0);
    }
    
    @Test
    public void testMultiplyRealNumberNegative(){
        RealNumber test = new RealNumber();
        double result = test.multiplyRealNumber( 5,   -2.5);
        assertEquals(-12.5, result, 0.0);
    }

    @Test
    public void testDivideRealNumber(){
        RealNumber test = new RealNumber();
        double result = test.divideRealNumber( 10.0,  2.0);
        assertEquals(5.0, result, 0.0);
    }

    @Test
    public void testDivideRealNumberRemainder(){
        RealNumber test = new RealNumber();
        double result = test.divideRealNumber( 5,  2.0);
        assertEquals(2.5, result, 0.0);
    }

    @Test
    public void testDivideRealNumberZero(){
        RealNumber test = new RealNumber();
        double result = test.divideRealNumber( 0.0,  2.0);
        assertEquals(0.0, result, 0.0);
    }

    @Test
    public void testDivideRealNumberNegative(){
        RealNumber test = new RealNumber();
        double result = test.divideRealNumber( -10,  -3);
        assertEquals(3.3333333333333335, result, 0.0);
    }

    @Test
    public void testDivideRealNumberNegative2(){
        RealNumber test = new RealNumber();
        double result = test.divideRealNumber( 10,  -3);
        assertEquals(-3.3333333333333335, result, 0.0);
    }

    @Test
    public void testDivideRealNumberZero2(){
        RealNumber test = new RealNumber();
        try {
            test.divideRealNumber(2,0);
        }
        catch (IllegalArgumentException ex) {
            assertEquals("Niedozwolone dzielenie przez 0",ex.getMessage());
        }
    }

    @Test
    public void testSquareRealNumber(){
        RealNumber test = new RealNumber();
        double result = test.squareRealNumber(16);
        assertEquals(4.0, result, 0.0);
    }

    @Test
    public void testSquareRealNumberOne(){
        RealNumber t = new RealNumber();
        double result = t.squareRealNumber(1);
        assertEquals(1, result, 0.0);
    }

    @Test
    public void testSquareRealNumberFractions(){
        RealNumber test = new RealNumber();
        double result = test.squareRealNumber(0.25);
        assertEquals(0.5, result, 0.0);
    }

    @Test
    public void testSquareRealNumberZero(){
        RealNumber test = new RealNumber();
        double result = test.squareRealNumber(0);
        assertEquals(0.0, result, 0.0);
    }

    @Test
    public void testSquareRealNumberNegative(){
        RealNumber test = new RealNumber();

        try {
            test.squareRealNumber(-16);
        } catch(IllegalArgumentException ex){
            assertEquals("Liczba pierwiastkowana 'a' nie moze być ujemna", ex.getMessage());
        }
    }

    @Test
    public void testPowerRealNumberNegativePower(){
        RealNumber test = new RealNumber();
        double result = test.powerRealNumber(2,-1);
        assertEquals(0.5, result, 0.0);
    }

    @Test
    public void testPowerRealNumber(){
        RealNumber test = new RealNumber();
        double result = test.powerRealNumber(2,1);
        assertEquals(2, result, 0.0);
    }

    @Test
    public void testPowerRealNumber2() {
        RealNumber test = new RealNumber();
        double result = test.powerRealNumber(2, 2);
        assertEquals(4, result, 0.0);
    }

    @Test
    public void testPowerRealNumberNegativeBase() {
        RealNumber test = new RealNumber();
        double result = test.powerRealNumber(-2, 2);
        assertEquals(4, result, 0.0);
    }

    @Test
    public void testPowerRealNumberZero(){
        RealNumber test = new RealNumber();
        double result = test.powerRealNumber(0,0);
        assertEquals(1.0, result, 0.0);
    }

    @Test
    public void testPowerRealNumberZero2(){
        RealNumber test = new RealNumber();
        double result = test.powerRealNumber(3,0);
        assertEquals(1.0, result, 0.0);
    }

    @Test
    public void testPowerRealNumberZero3(){
        RealNumber test = new RealNumber();
        double result = test.powerRealNumber(0,2);
        assertEquals(0.0, result, 0.0);
    }
    
    @Test
    public void testPowerRealNumberBaseFractions(){
        RealNumber test = new RealNumber();
        double result = test.powerRealNumber(0.5,2);
        assertEquals(0.25, result, 0.0);
    }
    
    @Test
    public void testPowerRealNumberPowerFractions(){
        RealNumber test = new RealNumber();
        double result = test.powerRealNumber(2,0.5);
        assertEquals(1.4142135623730951, result, 0.0);
    }
}
