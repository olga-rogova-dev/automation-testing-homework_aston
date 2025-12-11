package lesson7_testng;

public class NumberComparator {

    public String compare(double a, double b) {
        if (a % 1 != 0 || b % 1 != 0) {
            throw new IllegalArgumentException("Допускаются только целые числа");
        }
        if (a > b) {
            return "первое число больше второго";
        } else if (a < b) {
            return "первое число меньше второго";
        } else {
            return "числа равны";
        }
    }

    public void printComparison(int x, int y) {
        String result = compare(x, y);
        System.out.println("Сравнение " + x + " и " + y + ": " + result);
    }
}