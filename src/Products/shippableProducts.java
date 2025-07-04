package Products;

import Products.Products;
import interfaces.*;
public class shippableProducts extends Products implements shippable{
    private double weight;

    public shippableProducts() {

    }
    public shippableProducts(double weight) {
        this.weight = weight;
    }

    public shippableProducts(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
