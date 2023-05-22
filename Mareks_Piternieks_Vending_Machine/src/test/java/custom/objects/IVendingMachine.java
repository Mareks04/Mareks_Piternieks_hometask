package custom.objects;

public interface IVendingMachine {
    String getManufacturer();
    Money getAmount();
    void setAmount(Money amount);
    Product[] getProducts();
    void setProducts(Product[] products);
    Money insertCoin(Money amount);
    Money returnMoney();
    Product buy(int productNumber);
}
