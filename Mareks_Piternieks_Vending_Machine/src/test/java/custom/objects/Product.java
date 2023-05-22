package custom.objects;

public class Product {
    private int available;
    private Money price;
    private String name;

    public Product(int available, Money price, String name) {
        this.available = available;
        this.price = price;
        this.name = name;
    }

    public int getAvailable() {
        return available;
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
