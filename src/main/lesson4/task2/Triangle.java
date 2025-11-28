package src.main.lesson4.task2;

public class Triangle extends AbstractShape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c,
                    String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return trianglePerimeter(a, b, c);
    }

    @Override
    public double getSquare() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

}