package lesson7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Тесты TriangleSquareCalculator")
public class TriangleSquareCalculatorTest {

    private TriangleSquareCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new TriangleSquareCalculator();
    }

    @DisplayName("Площадь треугольника при корректных основании и высоте считается правильно")
    @Test
    void calculateSquare_validBaseAndHeight_returnsArea() {
        double area = calc.calculateSquare(3.0, 4.0);

        assertEquals(6.0, area);
    }

    @DisplayName("Ноль основания/высоты выбрасывает IllegalArgumentException с сообщением")
    @Test
    void calculateSquare_zeroOrNegative_throwsExceptionWithMessage() {
        IllegalArgumentException ex1 = assertThrows(
                IllegalArgumentException.class,
                () -> calc.calculateSquare(0.0, 4.0));

        assertEquals("Основание и высота должны быть > 0", ex1.getMessage());
    }

    @DisplayName("Отрицательная высота выбрасывает IllegalArgumentException с сообщением")
    @Test
    void calculateSquare_negativeHeight_throwsExceptionWithMessage() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calc.calculateSquare(3.0, -1.0));

        assertEquals("Основание и высота должны быть > 0", ex.getMessage());
    }
}