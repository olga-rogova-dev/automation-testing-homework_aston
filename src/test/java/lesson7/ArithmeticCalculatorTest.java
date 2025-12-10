package lesson7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты ArithmeticCalculator")
public class ArithmeticCalculatorTest {

    private ArithmeticCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new ArithmeticCalculator();
    }

    @DisplayName("Сложение, вычитание и умножение возвращают корректный результат")
    @Test
    void add_subtract_multiply_returnCorrectResults() {
        assertAll(
                () -> assertEquals(13, calc.add(10, 3)),
                () -> assertEquals(7, calc.subtract(10, 3)),
                () -> assertEquals(30, calc.multiply(10, 3))
        );
    }

    @DisplayName("Деление с корректными аргументами возвращает частное")
    @Test
    void divide_validArguments_returnsQuotient() {
        double result = calc.divide(10, 3);
        assertEquals(3.3333333, result, 1e-6);
    }

    @DisplayName("Результат деления положительный")
    @Test
    void divide_positiveResult_isGreaterThanZero() {
        double result = calc.divide(10, 3);
        assertTrue(result > 0);
    }

    @DisplayName("Деление на ноль выбрасывает IllegalArgumentException с сообщением")
    @Test
    void divide_byZero_throwsExceptionWithMessage() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calc.divide(10, 0)
        );

        assertEquals("Деление на ноль запрещено", ex.getMessage());
    }
}