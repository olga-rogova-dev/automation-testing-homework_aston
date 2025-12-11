package lesson7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Тесты NumberComparator")
public class NumberComparatorTest {

    private NumberComparator cmp;

    @BeforeEach
    void setUp() {
        cmp = new NumberComparator();
    }

    @DisplayName("Первое число больше второго для целых чисел")
    @Test
    void compare_firstGreater_forIntegers() {
        String result = cmp.compare(5.0, 3.0);

        assertEquals("первое число больше второго", result);
    }

    @DisplayName("Первое число меньше второго для целых чисел")
    @Test
    void compare_firstLess_forIntegers() {
        String result = cmp.compare(3.0, 5.0);

        assertEquals("первое число меньше второго", result);
    }

    @DisplayName("Равные числа возвращают сообщение о равенстве")
    @Test
    void compare_equal_forIntegers() {
        String result = cmp.compare(4.0, 4.0);

        assertEquals("числа равны", result);
    }

    @DisplayName("Дробные числа вызывают IllegalArgumentException с сообщением")
    @Test
    void compare_fractional_throwsExceptionWithMessage() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> cmp.compare(1.5, 2.0)
        );

        assertEquals("Допускаются только целые числа", ex.getMessage());
    }
}