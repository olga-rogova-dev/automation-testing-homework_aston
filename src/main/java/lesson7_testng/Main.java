package lesson7_testng;

public class Main {

    public static void main(String[] args) {

        FactorialCalculator factorialCalculator = new FactorialCalculator();
        factorialCalculator.printFactorial(5);

        TriangleSquareCalculator triangleAreaCalculator = new TriangleSquareCalculator();
        triangleAreaCalculator.printSquare(3.0, 4.0);

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        arithmeticCalculator.printAllOperations(10, 3);

        NumberComparator numberComparator = new NumberComparator();
        numberComparator.printComparison(7, 9);
    }
}