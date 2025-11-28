package src.main.lesson4.task1;

public class Counter {
    private int count;

    public void increment() {
        count++;
    }

    public void print(String label) {
        System.out.println(label + ": " + count);
    }
}