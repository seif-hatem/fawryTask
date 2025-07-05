import java.time.LocalDate;

import Products.*;

public class Main {
    public static void main(String[] args) {
        // normal flow
        try{
            Customer customer = new Customer(10000);
            Products cheese = new shippableExpirableProducts("cheese", 150, 7, LocalDate.now().plusDays(10), 1000);
            Products TV = new shippableProducts("TV", 2500, 1000, 1500);
            Products biscuits = new shippableExpirableProducts("Biscuits", 25, 20, LocalDate.now().plusDays(2), 1);
            customer.addToCart(cheese, 2);
            customer.addToCart(TV, 1);
            customer.addToCart(biscuits, 5);
            customer.checkout();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        // ordering more than available quantity
        try{
            Customer customer1 = new Customer(10000);
            Products cheese1 = new shippableExpirableProducts("cheese", 150, 7, LocalDate.now().plusDays(10), 1000);
            Products TV1 = new shippableProducts("TV", 2500, 1000, 1500);
            Products biscuits1 = new shippableExpirableProducts("Biscuits", 10, 20, LocalDate.now().plusDays(2), 1);
            customer1.addToCart(cheese1, 2);
            customer1.addToCart(TV1, 1);
            customer1.addToCart(biscuits1, 21);
            customer1.checkout();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        // proceeding to checkout while no items in cart
        try{
            Customer customer2 = new Customer(10000);
            Products cheese2 = new shippableExpirableProducts("cheese", 150, 7, LocalDate.now().plusDays(10), 1000);
            Products TV2 = new shippableProducts("TV", 2500, 1000, 1500);
            Products biscuits2 = new shippableExpirableProducts("Biscuits", 10, 20, LocalDate.now().plusDays(2), 1);
            customer2.checkout();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        // ordering with balance < items to buy
        try{
            Customer customer3 = new Customer(1);
            Products cheese3 = new shippableExpirableProducts("cheese", 150, 7, LocalDate.now().plusDays(10), 1000);
            Products TV3= new shippableProducts("TV", 2500, 1000, 1500);
            Products biscuits3 = new shippableExpirableProducts("Biscuits", 10, 20, LocalDate.now().plusDays(2), 1);
            customer3.addToCart(cheese3, 2);
            customer3.addToCart(TV3, 1);
            customer3.addToCart(biscuits3, 5);
            customer3.checkout();

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        // ordering item that expired
        try{
            Customer customer4 = new Customer(10000);
            Products cheese4 = new shippableExpirableProducts("cheese", 150, 7, LocalDate.now().plusDays(10), 1000);
            Products TV4= new shippableProducts("TV", 2500, 1000, 1500);
            Products biscuits3 = new shippableExpirableProducts("Biscuits", 10, 20, LocalDate.now().minusDays(2), 1);
            customer4.addToCart(cheese4, 2);
            customer4.addToCart(TV4, 1);
            customer4.addToCart(biscuits3, 5);
            customer4.checkout();

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}