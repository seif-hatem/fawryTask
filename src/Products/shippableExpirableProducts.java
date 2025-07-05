package Products;
import java.time.LocalDate;

import interfaces.*;
public class shippableExpirableProducts extends Products implements expirable,shippable {
    private LocalDate expire;
    private double weight;

    public shippableExpirableProducts(LocalDate expire, double weight) {
        this.expire = expire;
        this.weight = weight;
    }

    public shippableExpirableProducts(String name, double price, int quantity, LocalDate expire, double weight) {
        super(name, price, quantity);
        this.expire = expire;
        this.weight = weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expire;
    }

    @Override
    public boolean isExpired() {
        return !LocalDate.now().isBefore(expire);
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
