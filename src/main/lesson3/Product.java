package src.main.lesson3;

public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private double price;
    private String countryOfOrigin;
    private boolean isBookedByCustomer;

    public Product(
            String name,
            String productionDate,
            String manufacturer,
            String countryOfOrigin,
            double price,
            boolean isBookedByCustomer
    ) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.countryOfOrigin = countryOfOrigin;
        this.isBookedByCustomer = isBookedByCustomer;
    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " руб");
        System.out.println("Забронировано покупателем: " + (isBookedByCustomer ? "Да" : "Нет"));
    }
}