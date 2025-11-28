package src.main.lesson4;

import src.main.lesson4.task1.Bowl;
import src.main.lesson4.task1.Cat;
import src.main.lesson4.task1.Counter;
import src.main.lesson4.task1.Dog;
import src.main.lesson4.task2.Circle;
import src.main.lesson4.task2.Rectangle;
import src.main.lesson4.task2.Triangle;

public class Main {
    public static void main(String[] args) {
        Counter animalsCounter = new Counter();
        Counter dogsCounter = new Counter();
        Counter catsCounter = new Counter();

        Dog dog = new Dog("Бобик");
        animalsCounter.increment();
        dogsCounter.increment();

        Cat cat = new Cat("Барсик", 10);
        animalsCounter.increment();
        catsCounter.increment();

        Dog dog2 = new Dog("Шарик");
        animalsCounter.increment();
        dogsCounter.increment();

        Cat cat2 = new Cat("Мурзик", 10);
        animalsCounter.increment();
        catsCounter.increment();

        Circle circle = new Circle(7, "красный", "чёрный");
        Rectangle rectangle = new Rectangle(8, 10, "синий", "зелёный");
        Triangle triangle = new Triangle(3, 4, 5, "жёлтый", "чёрный");

        dog.run(150);
        dog.run(600);
        dog.swim(5);
        dog.swim(15);

        dog2.run(130);
        dog2.run(800);
        dog2.swim(7);
        dog2.swim(17);

        cat.run(150);
        cat.run(250);
        cat.swim(4);
        cat.printInitialFood();
        cat.eat(15);
        cat.eat(8);
        cat.addFood(15);
        cat.eat(9);
        cat.printSatiety();

        cat2.printInitialFood();
        cat2.eat(17);
        cat2.eat(4);
        cat2.addFood(20);
        cat2.eat(10);
        cat2.printSatiety();

        Bowl commonBowl = new Bowl(20);
        commonBowl.printInitialFood();
        Cat[] cats = {cat, cat2};

        cats[0].eatFromBowl(commonBowl, 7);
        cats[1].eatFromBowl(commonBowl, 7);

        commonBowl.addFood(10);
        commonBowl.feedNotFullCats(cats, 5);

        animalsCounter.print("Всего животных");
        dogsCounter.print("Собак");
        catsCounter.print("Котов");
        System.out.println();

        circle.printInfo("Круг");
        rectangle.printInfo("Прямоугольник");
        triangle.printInfo("Треугольник");
    }
}