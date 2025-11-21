package lesson2;

import static lesson2.Homework.*;

public class Main {
    public static void main(String[] args) {
        printThreeWords();

        checkSumSign();

        printColor();

        compareNumbers();

        System.out.println(checkSumTwoNumber(2, 4));

        printSign(-8);

        System.out.println(isNegative(8));

        printStringMultipleTimes("Привет", 3);

        System.out.println(isLeapYear(2025));

        invertArray();

        fillArray();

        multiplyLessThanSix();

        fillDiagonal(5);

        generateIntArray(4, 1);
    }
}