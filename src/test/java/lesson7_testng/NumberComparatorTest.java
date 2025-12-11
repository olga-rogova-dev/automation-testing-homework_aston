package lesson7_testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberComparatorTest {

    private NumberComparator cmp;

    @BeforeMethod
    void setUp() {
        cmp = new NumberComparator();
    }

    @Test
    public void compare_firstGreater_forIntegers() {
        String result = cmp.compare(5.0, 3.0);
        assertEquals(result, "первое число больше второго");
    }

    @Test
    public void compare_firstLess_forIntegers() {
        String result = cmp.compare(3.0, 5.0);
        assertEquals(result, "первое число меньше второго");
    }

    @Test
    public void compare_equal_forIntegers() {
        String result = cmp.compare(4.0, 4.0);
        assertEquals(result, "числа равны");
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Допускаются только целые числа"
    )
    public void compare_fractional_throwsExceptionWithMessage() {
        cmp.compare(1.5, 2.0);
    }
}