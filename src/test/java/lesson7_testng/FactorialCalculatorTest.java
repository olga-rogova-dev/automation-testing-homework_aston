package lesson7_testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialCalculatorTest {

    private FactorialCalculator calculator;

    @BeforeMethod
    void setUp() {
        calculator = new FactorialCalculator();
    }

    @DataProvider
    public Object[][] factorialValues() {
        return new Object[][]{{0, 1L}, {1, 1L}, {5, 120L}};
    }

    @Test(dataProvider = "factorialValues")
    public void factorial_forSeveralValues_isCorrect(int n, long expected) {
        long result = calculator.calculateFactorial(n);
        assertEquals(result, expected);
    }

    @DataProvider
    public Object[][] negativeValues() {
        return new Object[][]{{-1}, {-5}, {-10}};
    }

    @Test(
            dataProvider = "negativeValues",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "n должно быть >= 0"
    )
    public void factorial_forNegativeValues_throwsException(int n) {
        calculator.calculateFactorial(n);
    }
}