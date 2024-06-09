package i222504_LAB3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
	
    private String name;
    private float salary;

    public Employee(String name, float salary) {
    	
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
    	
        return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + '}';
    }
}

public class i222504_LAB3_TASK6 {
    public static void main(String[] args) {
    	
    	
        List<Employee> employees = new ArrayList<>();
        
        
        employees.add(new Employee("John", 50000));
        employees.add(new Employee("Alice", 60000));
        employees.add(new Employee("Bob", 45000));
        employees.add(new Employee("Jane", 70000));

        System.out.println("Before sorting:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        employees.sort(Comparator.comparingDouble(Employee::getSalary));

        System.out.println("\nAfter sorting:");
        
        for (Employee emp : employees) {
            System.out.println(emp);
            
        }
    }
}