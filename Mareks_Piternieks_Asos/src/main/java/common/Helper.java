package common;

import custom.objects.Product;

public class Helper {
    public static boolean compareProductArrays(Product[] products, Product[] checkProducts) {
        if (products.length != checkProducts.length) {
            return false;
        }

        for (Product product : products) {
            boolean foundMatch = false;
            for (Product checkProduct : checkProducts) {
                if (product.getName().equals(checkProduct.getName()) &&
                        product.getPrice().equals(checkProduct.getPrice())) {
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch) {
                return false;
            }
        }

        return true;
    }

    public static float calculateTotalPrice(Product[] products) {
        float totalPrice = 0.0f;

        for (Product product : products) {
            String priceWithSymbol = product.getPrice();
            String priceWithoutSymbol = priceWithSymbol.replace("€", "");
            float priceValue = Float.parseFloat(priceWithoutSymbol);
            totalPrice += priceValue;
        }

        return totalPrice;
    }
}
