package lesson7_testng;

public class ArithmeticCalculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Деление на ноль запрещено");
        }
        return (double) a / b;
    }

    public void printAllOperations(int a, int b) {
        System.out.println("Сложение: " + a + " + " + b + " = " + add(a, b));
        System.out.println("Вычитание: " + a + " - " + b + " = " + subtract(a, b));
        System.out.println("Умножение: " + a + " * " + b + " = " + multiply(a, b));
        System.out.println("Деление: " + a + " / " + b + " = " + divide(a, b));
    }
}