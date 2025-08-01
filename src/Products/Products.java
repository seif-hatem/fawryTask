package Products;

public class Products {
    private String name;
    private double price;
    private int quantity;

    public Products() {
    }

    public Products(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void decrementQuantity(int quantity){
        this.quantity-=quantity;
    }
    public void incrementQuantity(int quantity){
        this.quantity+=quantity;
    }
}
