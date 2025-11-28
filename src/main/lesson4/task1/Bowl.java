package src.main.lesson4.task1;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int amount) {
        food += amount;
        System.out.println("В миску добавлено " + amount + " ед. Теперь в миске: " + food);
    }

    public boolean takeFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void feedNotFullCats(Cat[] cats, int portion) {
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eatFromBowl(this, portion);
            }
        }
    }

    public void printInitialFood() {
        System.out.println("Общая миска: начальное количество еды = " + food);
    }
}