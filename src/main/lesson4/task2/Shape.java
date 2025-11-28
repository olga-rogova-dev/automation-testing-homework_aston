package src.main.lesson4.task2;

public interface Shape {
    double PI = 3.14159;

    double getSquare();

    double getPerimeter();

    default double rectanglePerimeter(double width, double height) {
        return 2 * (width + height);
    }

    default double trianglePerimeter(double a, double b, double c) {
        return a + b + c;

    }

    default double circlePerimeter(double radius) {
        return 2 * PI * radius;
    }
}