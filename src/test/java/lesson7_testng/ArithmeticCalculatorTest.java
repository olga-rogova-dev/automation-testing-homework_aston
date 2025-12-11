package lesson7_testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArithmeticCalculatorTest {

    private ArithmeticCalculator calc;

    @BeforeMethod
    void setUp() {
        calc = new ArithmeticCalculator();
    }

    @Test
    public void add_subtract_multiply_returnCorrectResults() {
        assertEquals(calc.add(10, 3), 13);
        assertEquals(calc.subtract(10, 3), 7);
        assertEquals(calc.multiply(10, 3), 30);
    }

    @Test
    public void divide_validArguments_returnsQuotient() {
        double result = calc.divide(10, 3);
        assertEquals(result, 3.3333333, 1e-6);
    }

    @Test
    public void divide_positiveResult_isGreaterThanZero() {
        double result = calc.divide(10, 3);
        assertTrue(result > 0);
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Деление на ноль запрещено"
    )
    public void divide_byZero_throwsExceptionWithMessage() {
        calc.divide(10, 0);
    }
}