import java.time.LocalDate;

import Products.*;

public class Main {
    public static void main(String[] args) {
        Customer customer=new Customer(10000);
        Products cheese=new shippableExpirableProducts("cheese",150,7,LocalDate.now().plusDays(10),1000);
        Products TV=new shippableProducts("TV",2500,1000,1500);
        Products biscuits=new shippableExpirableProducts("Biscuits",25,20,LocalDate.now().minusDays(2),1);
       customer.addToCart(cheese,2);
        customer.addToCart(TV,1);
        customer.addToCart(biscuits,6);
        customer.checkout();
    }
}