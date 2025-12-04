package scr.main.lesson5;

import static scr.main.lesson5.ArrayValidator.checkArraySizeAndData;

public class Main {
    public static void main(String[] args) {

        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "1", "12"},
                {"13", "14", "5", "16"}
        };
        String[][] wrongSizeArrayRow = {
                {"1", "2", "3", "4", "5"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArrayCol = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
                {"17", "18", "19", "20"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "оаллла", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = checkArraySizeAndData(correctArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Произошло исключение MyArraySizeException");
            System.out.println("Размер массива некорректный: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Произошло исключение MyArrayDataException");
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        try {
            int result = checkArraySizeAndData(wrongSizeArrayRow);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Произошло исключение MyArraySizeException");
            System.out.println("Размер массива некорректный: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Произошло исключение MyArrayDataException");
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        try {
            int result = checkArraySizeAndData(wrongSizeArrayCol);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Произошло исключение MyArraySizeException");
            System.out.println("Размер массива некорректный: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Произошло исключение MyArrayDataException");
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        try {
            int result = checkArraySizeAndData(wrongDataArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Произошло исключение MyArraySizeException");
            System.out.println("Размер массива некорректный: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Произошло исключение MyArrayDataException");
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        int[] numbers = {64, 77, 7, 54};

        try {
            System.out.println("Попытка обратиться к элементу с индексом выходящий за пределы массива");
            int value = numbers[6];
            System.out.println("Это сообщение не будет выведено");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Произошло исключение ArrayIndexOutOfBoundsException");
            System.out.println("Сообщение: " + e.getMessage());
        }
        System.out.println("Завершение работы программы");
    }
}