package src.main.lesson4.task2;

public class Rectangle extends AbstractShape {
    private double width;
    private double height;

    public Rectangle(double width, double height,
                     String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getSquare() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return rectanglePerimeter(width, height);
    }

}