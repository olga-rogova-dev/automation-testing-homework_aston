package src.main.lesson3;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 55999, true);
        productsArray[1] = new Product("Apple iPhone 17 Pro 256GB", "12.09.2025", "Apple Inc.", "USA", 159990, true);
        productsArray[2] = new Product("Cartier Love Bracelet Yellow Gold", "01.04.2023", "Cartier", "France", 510000, false);
        productsArray[3] = new Product("Chanel Classic Flap Bag Medium", "25.08.2024", "Chanel", "France", 499000, true);
        productsArray[4] = new Product("Atlant XM 6026 Refrigerator", "05.03.2025", "Atlant", "Belarus", 45000, false);

        productsArray[0].printInfo();
        productsArray[1].printInfo();
        productsArray[2].printInfo();
        productsArray[3].printInfo();
        productsArray[4].printInfo();
        System.out.println();

        Park.Attraction goKarts = new Park().new Attraction("Go-Karts", "10:00–20:00", 350);
        Park.Attraction carousel = new Park().new Attraction("Carousel", "09:00–21:00", 300);
        Park.Attraction rollerCoaster = new Park().new Attraction("Roller Coaster", "11:00–22:00", 500);

        goKarts.printInfo();
        carousel.printInfo();
        rollerCoaster.printInfo();
    }
}