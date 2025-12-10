package lesson7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Тесты FactorialCalculator")
public class FactorialCalculatorTest {

    private FactorialCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new FactorialCalculator();
    }

    @DisplayName("Факториал для нескольких значений считается корректно")
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "5, 120"})
    void factorial_forSeveralValues_isCorrect(int n, long expected) {
        long result = calculator.calculateFactorial(n);
        assertEquals(expected, result);
    }

    @DisplayName("Отрицательные значения вызывают IllegalArgumentException")
    @ParameterizedTest
    @CsvSource({"-1", "-5", "-10"})
    void factorial_forNegativeValues_throwsException(int n) {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateFactorial(n)
        );
        assertEquals("n должно быть >= 0", ex.getMessage());
    }
}