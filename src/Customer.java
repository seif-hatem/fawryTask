import java.util.HashMap;
import java.util.Map;
import interfaces.*;
import Products.*;

public class Customer {
    private Cart cart;
    private double balance;
    public Customer(){
        cart=new Cart();
    }
    public Customer( double balance) {
        cart=new Cart();
        this.balance = balance;
    }
    public Customer(Cart cart, double balance) {
        this.cart = cart;
        this.balance = balance;
    }
    public void addToCart(Products product, int quantity){
        cart.add(product,quantity);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void decrementBalance(double balance){
        this.balance-=balance;
    }
    public void incrementBalance(double balance){
        this.balance+=balance;
    }
    public void clearCart(){
        cart=new Cart();
    }
    void checkout() {
        Map<Products, Integer> items = cart.getItems();
        double total = 0;
        double shippingTotal = 0;
        double amount = 0;
        double shippmentWeight=0;
        if (items.isEmpty()){
            throw new IllegalStateException("No items in cart to order");
        }
        System.out.println("** Checkout receipt **");
        String finalS = "";
        for (Map.Entry<Products, Integer> item : items.entrySet()) {
            double productTotal = item.getKey().getPrice() * item.getValue();
            total += productTotal;
            amount += total;

            if (item.getKey() instanceof shippableProducts  ) {
                shippingTotal += 10;
                amount += 10;
                double w=((shippableProducts) item.getKey()).getWeight()*item.getValue();
                shippmentWeight+= w;
                String line = String.format("%dX %s\t", item.getValue(), item.getKey().getName());
                if(w>=1000){
                    line+=(w/1000)+"kg\n";
                }
                else{
                    line+=w+"g\n";
                }
                
                finalS += line;
            }
            if (item.getKey() instanceof shippableExpirableProducts  ) {
                shippingTotal += 10;
                amount += 10;
                double w= ((shippableExpirableProducts) item.getKey()).getWeight()*item.getValue();
                shippmentWeight+= w;
                String line = String.format("%dX %s\t", item.getValue(), item.getKey().getName());
                if(w>=1000){
                    line+=(w/1000)+"kg\n";
                }
                else{
                    line+=w+"g\n";
                }
                finalS += line;
            }

            System.out.printf("%dX %s\t%f\n", item.getValue(), item.getKey().getName(), productTotal);

            if (amount > this.balance) {
                throw new IllegalStateException("Your orderd items exceeds your balance");
            }
            item.getKey().decrementQuantity(item.getValue());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\t" + total);
        System.out.println("Shipping\t" + shippingTotal);
        amount = total + shippingTotal;
        System.out.println("Amount\t" + amount);
        System.out.println("\n** Shipment notice **\n" + finalS);
        System.out.println("Total package weight "+ (shippmentWeight/1000)+"kg" );
        decrementBalance(amount);
        clearCart();
        System.out.println("*----------------------------------------------------*\n");
    }
}
