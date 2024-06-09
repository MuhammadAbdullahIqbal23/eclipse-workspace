package i222504_LAB2;

import java.util.ArrayList;

interface Product {
    String getName();

    int getPrice();

    String getDescription();
}

class Electronics implements Product {
    private String name;
    private int price;
    private String description;

    public Electronics(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

class Clothing implements Product {
    private String name;
    private int price;
    private String description;

    public Clothing(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

class Books implements Product {
    private String name;
    private int price;
    private String description;

    public Books(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

interface Order {
    void addProduct(Product product, int quantity);

    void removeProduct(Product product, int quantity);

    void calculateTotal();
}

class OnlineOrder implements Order {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            products.add(product);
            System.out.println(product.getName() + " add to inventory");

        }
    }

    public void removeProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (products.contains(product)) {
                products.remove(product);
                System.out.println(product.getName() + " removed from inventory");
            } else {
                System.out.println("Product not found in the order.");
            }
        }
    }

    public void calculateTotal() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }

        System.out.println("Total Price: " + total);
        total =0;

    }
}
class Customer {
    private String name;
    private String email;
    private String address;
    private ArrayList<Order> orders = new ArrayList<>();

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Order placed successfully.");
    }

    public void viewOrderHistory() {
        System.out.println("Order History for Customer: " + name);
        for (Order order : orders) {
            order.calculateTotal();
        }
    }

    
}
public class i222504_LAB2_task3 {
    public static void main(String[] args) {
        Product laptop = new Electronics("Laptop", 1000, "High-performance laptop");
        Product shirt = new Clothing("Shirt", 50, "Casual cotton shirt");
        Product novel = new Books("Novel", 20, "Bestseller novel");

        Customer customer = new Customer("Abdullah", "Abdullah@gmail.com", "Bahria town phase 8");

        OnlineOrder order1 = new OnlineOrder();
        order1.addProduct(laptop, 1);
        order1.addProduct(shirt, 2);

        customer.placeOrder(order1);

        System.out.println("\nOrder History after the first order:");
        customer.viewOrderHistory();

        OnlineOrder order2 = new OnlineOrder();
        order2.addProduct(novel, 3);
        order2.addProduct(laptop, 3);

        customer.placeOrder(order2);

        System.out.println("\nOrder History after the second order:");
        customer.viewOrderHistory();
    }
}

