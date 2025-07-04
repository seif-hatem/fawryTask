package Products;

import java.time.LocalDate;

import interfaces.expirable;

public class expirableProducts extends Products implements expirable {
    private LocalDate expire;
    public expirableProducts(){
        super();
    }
    public expirableProducts(LocalDate expire) {
        this.expire = expire;
    }

    public expirableProducts(String name, double price, int quantity, LocalDate expire) {
        super(name, price, quantity);
        this.expire = expire;
    }

    public LocalDate getExpire() {
        return expire;
    }

    public void setExpire(LocalDate expire) {
        this.expire = expire;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expire;
    }

    @Override
    public boolean isExpired() {
        return expire.isAfter(LocalDate.now());
    }
}
