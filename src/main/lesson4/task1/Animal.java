package src.main.lesson4.task1;

public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал(а) " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл(а) " + distance + " м.");
    }
}