package src.main.lesson4.task1;

public class Cat extends Animal {
    private int bowl;
    private int satiety;
    private boolean full;

    public Cat(String name, int bowl) {
        super(name);
        this.bowl = bowl;
        this.satiety = 0;
        this.full = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м., так как ограничение 200 м");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void printInitialFood() {
        System.out.println(name + ": начальное количество еды в личной миске = " + bowl);
    }

    private void updateFull() {
        full = satiety > 0;
    }

    public void eat(int portion) {
        if (portion > bowl) {
            System.out.println(name + " попытался съесть " + portion
                    + " ед., но в миске только " + bowl + " ед.");
        } else {
            bowl -= portion;
            satiety += portion;
            System.out.println(name + " съел " + portion + " ед. В миске осталось: " + bowl);
        }
        updateFull();

    }

    public void addFood(int food) {
        bowl += food;
        System.out.println("В миску добавлено " + food + " ед. Теперь в миске: " + bowl);
    }

    public void eatFromBowl(Bowl bowlObj, int portion) {
        if (bowlObj.getFood() == 0) {
            System.out.println(name + " хотел поесть, но общая миска пустая");
            return;
        }

        if (bowlObj.takeFood(portion)) {
            satiety += portion;
            System.out.println(name + " съел " + portion + " ед. сытость = " + satiety
                    + ", в общей миске осталось " + bowlObj.getFood());
        } else {
            int rest = bowlObj.getFood();
            if (rest > 0) {
                bowlObj.takeFood(rest);
                satiety += rest;
                System.out.println(name + " хотел съесть " + portion + " ед., но съел только "
                        + rest + " ед. сытость = " + satiety + ", в общей миске осталось 0");
            }
        }
        updateFull();
    }

    public boolean isFull() {
        return full;
    }

    public void printSatiety() {
        System.out.println(name + ": сытость = " + full);
    }

}