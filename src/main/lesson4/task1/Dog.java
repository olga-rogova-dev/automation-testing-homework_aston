package src.main.lesson4.task1;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            super.run(distance);
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м., так как ограничение 500 м");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println(name + " не смог проплыть " + distance + " м., так как ограничение 10 м");
        }
    }
}