package custom.objects;

public class Product {

    public String name;
    public String price;

    public Product(String name, String price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public String getPrice(){
        return this.price;
    }

}
