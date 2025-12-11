package lesson7_testng;

public class FactorialCalculator {

    public long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n должно быть >= 0");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public void printFactorial(int n) {
        long factorial = calculateFactorial(n);
        System.out.println("Факториал " + n + " = " + factorial);
    }
}