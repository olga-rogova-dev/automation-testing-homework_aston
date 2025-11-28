package src.main.lesson4.task2;

public abstract class AbstractShape implements Shape {
    private final String fillColor;
    private final String borderColor;

    public AbstractShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public void printInfo(String name) {
        System.out.println(name + ":");
        System.out.println("площадь  = " + getSquare());
        System.out.println("периметр = " + getPerimeter());
        System.out.println("цвет заливки = " + fillColor);
        System.out.println("цвет границы = " + borderColor);
    }
}