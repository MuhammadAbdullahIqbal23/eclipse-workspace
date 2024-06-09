import java.util.ArrayList;
import java.util.Scanner;

public class i222504_G_A1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CRMS crms = new CRMS();
    
        boolean continueExecution = true;
        while (continueExecution) {
            // Display menu options
            System.out.println("Choose an option:");
            System.out.println("1. Add a car");
            System.out.println("2. Add a renter");
            System.out.println("3. Remove a car if not rented");
            System.out.println("4. Remove a renter");
            System.out.println("5. Show renters list");
            System.out.println("6. Show car list");
            System.out.println("7. Exit");
    
            // Read user choice
            int choice = scanner.nextInt();
            scanner.nextLine(); 
    
            // Perform action based on user choice
            switch (choice) {
                case 1:
                    addCar(scanner, crms); // Add a car
                    break;
                case 2:
                    addRenter(scanner, crms); // Add a renter
                    break;
                case 3:
                    removeCar(scanner, crms); // Remove a car if not rented
                    break;
                case 4:
                    removeRenter(scanner, crms); // Remove a renter
                    break;
                case 5:
                    crms.displayRenterDetails(); // Show renters list
                    break;
                case 6:
                    crms.displayAvailableCars(); // Show car list
                    break;
                case 7:
                    continueExecution = false; // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    
        System.out.println("Thank you for using the rental service.");
        scanner.close();
    }
    
    // Method to add a car
    

    private static void addCar(Scanner scanner, CRMS crms) {
        System.out.println("Enter car details:");
    
        System.out.print("Car ID: ");
        String carID = scanner.nextLine();
    
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
    
        System.out.print("Model: ");
        String model = scanner.nextLine();
    
        System.out.print("Year: ");
        String year = scanner.nextLine();
    
        System.out.print("Rental status (true/false): ");
        boolean rentalStatus = scanner.nextBoolean();
        scanner.nextLine(); 
    
        System.out.print("Rental fee: ");
        double rentalFee = scanner.nextDouble();
        scanner.nextLine(); 
    
        System.out.print("Plate number: ");
        String plateNumber = scanner.nextLine();
        
        // Select car type
        System.out.println("Select car type:");
        System.out.println("1. Compact Car");
        System.out.println("2. SUV");
        System.out.println("3. Luxury Car");
        System.out.print("Enter choice: ");
        int carTypeChoice = scanner.nextInt();
        scanner.nextLine(); 
    
        Car_Type car;
        switch (carTypeChoice) {
            case 1:
                car = new CompactCar(carID, brand, model, year, rentalStatus, rentalFee, plateNumber);
                break;
            case 2:
                car = new SUV(carID, brand, model, year, rentalStatus, rentalFee, plateNumber);
                break;
            case 3:
                car = new Luxury_Car(carID, brand, model, year, rentalStatus, rentalFee, plateNumber);
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Compact Car.");
                car = new CompactCar(carID, brand, model, year, rentalStatus, rentalFee, plateNumber);
                break;
        }
    
        crms.addCar(car); // Add car to the system
    
        System.out.println("Car added successfully.");
    }
    
    // Method to add a renter
    private static void addRenter(Scanner scanner, CRMS crms) {
        System.out.println("Enter renter details:");
    
        System.out.print("Renter ID: ");
        int renterId = scanner.nextInt();
        scanner.nextLine(); 
    
        System.out.print("Name: ");
        String name = scanner.nextLine();
    
        System.out.print("Email: ");
        String email = scanner.nextLine();
    
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
    
        System.out.print("Address: ");
        String address = scanner.nextLine();
        
        // Select renter type
        System.out.println("Select renter type:");
        System.out.println("1. Regular Renter");
        System.out.println("2. Frequent Renter");
        System.out.println("3. Corporate Renter");
        System.out.print("Enter choice: ");
        int renterTypeChoice = scanner.nextInt();
        scanner.nextLine(); 
    
        Renter_Type renter;
        switch (renterTypeChoice) {
            case 1:
                renter = new Regular_Renter(renterId, name, email, new ArrayList<>(), 0, phoneNumber, address);
                break;
            case 2:
                renter = new Frequent_Renter(renterId, name, email, new ArrayList<>(), 0, phoneNumber, address);
                break;
            case 3:
                renter = new Corporate_Renter(renterId, name, email, new ArrayList<>(), 0, phoneNumber, address);
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Regular Renter.");
                renter = new Regular_Renter(renterId, name, email, new ArrayList<>(), 0, phoneNumber, address);
                break;
        }
    
        crms.addRenter(renter);
    
        System.out.println("Renter added successfully.");
    
        
        System.out.println("Available Cars:");
        crms.displayAvailableCars();
    
        rentCar(scanner, crms, renter);
    }
    // Method to rent a car
    private static void rentCar(Scanner scanner, CRMS crms, Renter_Type renter) {
        System.out.println("\nPlease select a car by entering its ID:");
        String selectedCarID = scanner.nextLine();
    
        Car_Type selectedCar = null;
        for (Car_Type car : crms.getCarsList()) {
            if (car.getCarID().equals(selectedCarID)) {
                selectedCar = car;
                break;
            }
        }
    
        if (selectedCar == null) {
            System.out.println("Invalid car ID. Exiting program.");
            System.exit(0);
        }
    
        if (selectedCar.getRental_Status()) {
            System.out.println("Car with ID " + selectedCarID + " is already rented. Exiting program.");
            System.exit(0);
        }
    
        
        selectedCar.setRental_Status(true);
    
        
        double rentalFee = 0;
        
            System.out.print("Enter the distance you plan to travel with the car (in miles): ");
            double distance = scanner.nextDouble();
            scanner.nextLine(); 
    
            if (selectedCar instanceof CompactCar) {
                rentalFee = ((CompactCar) selectedCar).CalculateRent(distance, renter);
            } else if (selectedCar instanceof SUV) {
            
                System.out.print("Is the car insured? (yes/no): ");
                String insuranceInput = scanner.nextLine();
                boolean isInsured = insuranceInput.equalsIgnoreCase("yes");
            
                System.out.print("Is the car Damaged? (yes/no): ");
                String DamageInput = scanner.nextLine();
                boolean isDamaged = DamageInput.equalsIgnoreCase("yes");
                rentalFee = ((SUV) selectedCar).CalculateRent(distance, isDamaged,isInsured, renter);
            
            } else if (selectedCar instanceof Luxury_Car) {

                System.out.print("Is the car insured? (yes/no): ");
                String insuranceInput = scanner.nextLine();
                boolean isInsured = insuranceInput.equalsIgnoreCase("yes");
            
                System.out.print("Is the car damaged? (yes/no): ");
                String damageInput = scanner.nextLine();
                boolean isDamage = damageInput.equalsIgnoreCase("yes");
            
                rentalFee = ((Luxury_Car) selectedCar).CalculateRent(distance, isDamage,isInsured, renter);
            }
        
    
        renter.getRentedCars().add(selectedCarID);
        renter.setTotalRentalFee(renter.getTotalRentalFee() + rentalFee);
    
        System.out.println("Rental fee: $" + rentalFee);
        System.out.println("Car rented successfully.");
    }
    
    // Method to remove a Renter if not rented
    private static void removeRenter(Scanner scanner, CRMS crms) {
        System.out.println("Enter the renter ID to remove:");
        int renterId = scanner.nextInt();
        scanner.nextLine(); 
    
        crms.removeRenterAfterReturn(renterId);
    
        System.out.println("Renter with ID " + renterId + " removed successfully.");
    }

    // Method to remove a car if not rented
    private static void removeCar(Scanner scanner, CRMS crms) {
        System.out.println("Enter the Car ID to remove:");
        String CarID = scanner.nextLine();
        crms.removeCarIfNotRented(CarID);
    
    }
}
    
class Car_Type {
    private String CarID;
    private String Brand;
    private String Model;
    private String Year;
    private Boolean Rental_Status;
    private double Rental_fee;
    private String Plate_number;

    public Car_Type(String carID, String brand, String model, String year, Boolean rental_Status, double rental_fee,
                    String plate_number) {
        CarID = carID;
        Brand = brand;
        Model = model;
        Year = year;
        Rental_Status = rental_Status;
        Rental_fee = rental_fee;
        Plate_number = plate_number;
    }

    public String getCarID() {
        return CarID;
    }

    public void setCarID(String carID) {
        CarID = carID;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public Boolean getRental_Status() {
        return Rental_Status;
    }

    public void setRental_Status(Boolean rental_Status) {
        Rental_Status = rental_Status;
    }

    public double getRental_fee() {
        return Rental_fee;
    }

    public void setRental_fee(double rental_fee) {
        Rental_fee = rental_fee;
    }

    public String getPlate_number() {
        return Plate_number;
    }

    public void setPlate_number(String plate_number) {
        Plate_number = plate_number;
    }
}

class CompactCar extends Car_Type {
    private String Features = "Basic features, suitable for short-distance travel.\n";
    private Boolean Insurable = false;

    public CompactCar(String carID, String brand, String model, String year, Boolean rental_Status, double rental_fee,
                      String plate_number) {
        super(carID, brand, model, year, rental_Status, rental_fee, plate_number);
    }

	double CalculateRent(double distance, Renter_Type renter) {
        final double Base_rent = 500;
        double discount = 0;
        
        if (renter instanceof Regular_Renter) {
            discount = 0.1 * Base_rent; 
        } else if (renter instanceof Frequent_Renter) {
            discount = 0.15 * Base_rent;
        } else if (renter instanceof Corporate_Renter) {
            discount = 0.2 * Base_rent; 
        }
        
        setRental_fee(Base_rent + (2 * distance) - discount);
        return getRental_fee();
    }


    public String getFeatures() {
        return Features;
    }

    public Boolean getInsurable() {
        return Insurable;
    }
    public void setInsurable(Boolean type){
        Insurable =type;
    }
}

class SUV extends Car_Type {
    public String Features = "Spacious, suitable for family trips.\n";
    public Boolean Insurable = true;

    public SUV(String carID, String brand, String model, String year, Boolean rental_Status, double rental_fee,
               String plate_number) {
        super(carID, brand, model, year, rental_Status, rental_fee, plate_number);
    }

	double CalculateRent(double distance, boolean isDamage, boolean isInsured,Renter_Type renter) {
        final double Base_rent = 800;
        double Damage_Cost = 0;
        double discount = 0;
        double insuranceCost = isInsured ? 0 : 200;

        
        if (renter instanceof Regular_Renter) {
            discount = 0.1 * Base_rent; 
        } else if (renter instanceof Frequent_Renter) {
            discount = 0.15 * Base_rent;
        } else if (renter instanceof Corporate_Renter) {
            discount = 0.2 * Base_rent; 
        }
        
        if (isDamage) {
            Damage_Cost = 0.2 * Base_rent;
        }
        if(insuranceCost!=0){
            setRental_fee(Base_rent + (5 * distance) + Damage_Cost - discount + insuranceCost);
            setInsurable(false);
        }
        else
        {
        setRental_fee(Base_rent + (5 * distance) + Damage_Cost - discount);

        }
        return getRental_fee();
    }

    public String getFeatures() {
        return Features;
    }

    public Boolean getInsurable() {
        return Insurable;
    }
    public void setInsurable(Boolean type){
        Insurable =type;
    }
}

class Luxury_Car extends Car_Type {
    private String Features = "High-end, suitable for special occasions.\n";
    private Boolean Insurable = true;
  final  private double Luxury_tax = 1499.99;

    public Luxury_Car(String carID, String brand, String model, String year, Boolean rental_Status, double rental_fee,
                       String plate_number) {
        super(carID, brand, model, year, rental_Status, rental_fee, plate_number);
    }

    double CalculateRent(double distance, boolean isDamage,boolean isInsured, Renter_Type renter) {
       final double Base_rent = 1000;
        double Damage_Cost = isDamage ? 0.2 * (Base_rent + getLuxury_tax()) : 0;
        double discount = 0;
        double insuranceCost = isInsured ? 0 : 500;
        
        if (renter instanceof Regular_Renter) {
            discount = 0.1 * Base_rent;
        } else if (renter instanceof Frequent_Renter) {
            discount = 0.15 * Base_rent;
        } else if (renter instanceof Corporate_Renter) {
            discount = 0.2 * Base_rent; 
        }
        if( Damage_Cost!= 0){
        setRental_fee(Base_rent + (5 * distance) + Damage_Cost + getLuxury_tax() - discount+insuranceCost);
        setInsurable(false);
        }
        else
        {
        
            setRental_fee(Base_rent + (5 * distance) + Damage_Cost + getLuxury_tax() - discount);
        }
        return getRental_fee();
    }

    public String getFeatures() {
        return Features;
    }

    public Boolean getInsurable() {
        return Insurable;
    }

    public double getLuxury_tax() {
        return Luxury_tax;
    }
    public void setInsurable(Boolean type){
        Insurable =type;
    }
}

class Renter_Type {
    private int renterId;
    private String name;
    private String email;
    private ArrayList<String> rentedCars;
    private double totalRentalFee;
    private String phoneNumber;
    private String address;

    // Constructor
    public Renter_Type(int renterId, String name, String email, ArrayList<String> rentedCars, double totalRentalFee, String phoneNumber, String address) {
        this.renterId = renterId;
        this.name = name;
        this.email = email;
        this.rentedCars = rentedCars;
        this.totalRentalFee = totalRentalFee;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters
    public int getRenterId() {
        return renterId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getRentedCars() {
        return rentedCars;
    }

    public double getTotalRentalFee() {
        return totalRentalFee;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRentedCars(ArrayList<String> rentedCars) {
        this.rentedCars = rentedCars;
    }

    public void setTotalRentalFee(double totalRentalFee) {
        this.totalRentalFee = totalRentalFee;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class Regular_Renter extends Renter_Type{

	public Regular_Renter(int renterId, String name, String email, ArrayList<String> rentedCars, double totalRentalFee,
			String phoneNumber, String address) {
		super(renterId, name, email, rentedCars, totalRentalFee, phoneNumber, address);
	}

}
class Frequent_Renter extends Renter_Type{

	public Frequent_Renter(int renterId, String name, String email, ArrayList<String> rentedCars, double totalRentalFee,
			String phoneNumber, String address) {
		super(renterId, name, email, rentedCars, totalRentalFee, phoneNumber, address);
	}

}
class Corporate_Renter extends Renter_Type{

	public Corporate_Renter(int renterId, String name, String email, ArrayList<String> rentedCars, double totalRentalFee,
			String phoneNumber, String address) {
		super(renterId, name, email, rentedCars, totalRentalFee, phoneNumber, address);
	}

}

class CRMS{
	private ArrayList<Car_Type> carsList = new ArrayList<>();
    private ArrayList<Renter_Type> rentersList = new ArrayList<>();

    public void addCar(Car_Type car) {
        carsList.add(car);
    }
    public ArrayList<Car_Type> getCarsList() {
        return carsList;
    }

    public void displayAvailableCars() {
        for (Car_Type car : carsList) {
            if (!car.getRental_Status()) {
                System.out.println(car.getCarID() + " - " + car.getBrand() + " " + car.getModel());
            }
        }
    }

    public void removeCarIfNotRented(String carID) {
        for (Car_Type car : carsList) {
            if (car.getCarID().equals(carID) && car.getRental_Status()!= true) {
                carsList.remove(car);
                System.out.println("Car removed successfully.");
                return;
            }
        }
        System.out.println("Car with ID " + carID + " not found or is currently rented.");
    }

    public void addRenter(Renter_Type renter) {
        rentersList.add(renter);
    }

    public void displayRenterDetails() {
        for (Renter_Type renter : rentersList) {
            System.out.println("Renter ID: " + renter.getRenterId());
            System.out.println("Name: " + renter.getName());
            System.out.println("Email: " + renter.getEmail());
            System.out.println("Phone Number: " + renter.getPhoneNumber());
            System.out.println("Address: " + renter.getAddress());
            System.out.println("Total Rental Fee: $" + renter.getTotalRentalFee());
            System.out.println("Rented Cars: ");
            for (String carID : renter.getRentedCars()) {
                System.out.println(carID);
            }
            System.out.println("--------------------");
        }
    }

    public void removeRenterAfterReturn(int renterId) {
        for (Renter_Type renter : rentersList) {
            if (renter.getRenterId() == renterId) {
                // Add back rented cars to available cars list
                for (String carID : renter.getRentedCars()) {
                    for (Car_Type car : carsList) {
                        if (car.getCarID().equals(carID)) {
                            car.setRental_Status(false); // Mark the car as available
                            break;
                        }
                    }
                }
                rentersList.remove(renter);
                System.out.println("Renter with ID " + renterId + " removed successfully.");
                return;
            }
        }
        System.out.println("Renter with ID " + renterId + " not found.");
    }
    
}