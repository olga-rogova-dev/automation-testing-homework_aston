package src.main.lesson4.task2;

public class Circle extends AbstractShape {
    private double radius;

    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return circlePerimeter(radius);
    }
}