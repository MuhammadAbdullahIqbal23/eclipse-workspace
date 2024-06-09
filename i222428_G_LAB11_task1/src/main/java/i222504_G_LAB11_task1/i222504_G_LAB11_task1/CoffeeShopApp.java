package i222504_G_LAB11_task1.i222504_G_LAB11_task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class CoffeeShopApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CoffeeShop shop = context.getBean("coffeeShop", CoffeeShop.class);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Coffee Shop!");
        System.out.println("What type of coffee would you like to order? (espresso/latte)");
        String coffeeType = scanner.nextLine().toLowerCase(); 

        System.out.println("What size would you like? (small/medium/large)");
        String size = scanner.nextLine().toLowerCase(); 
        
        String coffeeBeanId = coffeeType + size;
        Coffee coffee = context.getBean(coffeeBeanId, Coffee.class);

        
        shop.setCoffee(coffee);
        shop.displayCoffeeDetails();

        scanner.close();
    }
}
