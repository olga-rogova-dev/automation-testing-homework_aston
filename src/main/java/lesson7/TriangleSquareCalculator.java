package lesson7;

public class TriangleSquareCalculator {

    public double calculateSquare(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть > 0");
        }
        return (base * height) / 2.0;
    }

    public void printSquare(double base, double height) {
        double square = calculateSquare(base, height);
        System.out.println("Площадь треугольника при основании "
                + base + " и высоте " + height + " = " + square);
    }
}