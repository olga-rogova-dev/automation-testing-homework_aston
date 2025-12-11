package lesson7_testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleSquareCalculatorTest {

    private TriangleSquareCalculator calc;

    @BeforeMethod
    void setUp() {
        calc = new TriangleSquareCalculator();
    }

    @Test
    public void calculateSquare_validBaseAndHeight_returnsArea() {
        double square = calc.calculateSquare(3.0, 4.0);
        assertEquals(square, 6.0);
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Основание и высота должны быть > 0"
    )
    public void calculateSquare_zeroBase_throwsExceptionWithMessage() {
        calc.calculateSquare(0.0, 4.0);
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Основание и высота должны быть > 0"
    )
    public void calculateSquare_negativeHeight_throwsExceptionWithMessage() {
        calc.calculateSquare(3.0, -1.0);
    }
}