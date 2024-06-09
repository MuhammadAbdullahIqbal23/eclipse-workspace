package i222504_G_LAB11_task1.i222504_G_LAB11_task1;

import org.springframework.beans.factory.annotation.Autowired;

public class CoffeeShop {
    private Coffee coffee;

    @Autowired
    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
    @Autowired
    public void displayCoffeeDetails() {
        System.out.println("Serving coffee: " + coffee.toString());
    }
}
