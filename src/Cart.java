import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import Products.*;
import Products.Products;

public class Cart {
    private Map<Products, Integer> items;
    private double total;

    public Cart() {
        items = new HashMap<>();
    }

    public Map<Products, Integer> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setItems(Map<Products, Integer> items) {
        this.items = items;
    }

    public void add(Products product, int quantity) {
        int inStock = product.getQuantity();
        LocalDate timeNow = LocalDate.now();
        if (product instanceof expirableProducts eproduct){
            if(eproduct.isExpired())
            throw new IllegalStateException(product.getName() + " has expired you can't order it");
        }
        if (product instanceof shippableExpirableProducts e){
            if(e.isExpired())
                throw new IllegalStateException(product.getName() + " has expired you can't order it");
        }
        if (quantity < 0) {
            System.out.println("Product quantity can\'t be less than 0");
        } else if (quantity < inStock) {
            items.put(product, quantity);
            setTotal(this.total + (quantity * product.getPrice()));
        } else {
            String ex=String.format("Items in stock is %d you shouldn't order more than this\n", inStock);
            throw new IllegalStateException(ex);

        }
    }

}
