package custom.objects;

public class VendingMachine implements IVendingMachine{
    private String manufacturer;
    private Money amount;
    private Product[] products;

    public VendingMachine(String manufacturer, Money amount, Product[] products) {
        this.manufacturer = manufacturer;
        this.amount = amount;
        this.products = products;
    }
    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public Money getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Money amount) {
        this.amount = amount;
    }

    @Override
    public Product[] getProducts() {
        return products;
    }

    @Override
    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public Money insertCoin(Money amount) {
        return amount;
    }

    @Override
    public Money returnMoney() {
        // Return all inserted coins back to the user and update the amount
        // Return the returned amount
        return new Money(1, 0);
    }

    @Override
    public Product buy(int productNumber) {
        return new Product(2, new Money(1, 50), "Snickers");
        // Buy the product with the specified product number
        // Update the available quantity and amount accordingly
        // Return the bought product
    }
}
