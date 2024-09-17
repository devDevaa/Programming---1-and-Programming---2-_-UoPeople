import java.util.Scanner;

interface Vehicle {
    String getMake();
    String getModel();
    int getYear();
}

interface CarVehicle {
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();
    void setFuelType(String fuelType);
    String getFuelType();
}

interface MotorVehicle {
    void setNumberOfWheels(int wheels);
    int getNumberOfWheels();
    void setType(String type);
    String getType();
}

interface TruckVehicle {
    void setCargoCapacity(double capacity);
    double getCargoCapacity();
    void setTransmissionType(String transmissionType);
    String getTransmissionType();
}

class Car implements Vehicle, CarVehicle {
    private String make, model, fuelType;
    private int year, numberOfDoors;
    
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override public String getMake() { return make; }
    @Override public String getModel() { return model; }
    @Override public int getYear() { return year; }
    @Override public void setNumberOfDoors(int doors) { numberOfDoors = doors; }
    @Override public int getNumberOfDoors() { return numberOfDoors; }
    @Override public void setFuelType(String fuelType) { this.fuelType = fuelType; }
    @Override public String getFuelType() { return fuelType; }
}

class Motorcycle implements Vehicle, MotorVehicle {
    private String make, model, type;
    private int year, numberOfWheels;
    
    public Motorcycle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override public String getMake() { return make; }
    @Override public String getModel() { return model; }
    @Override public int getYear() { return year; }
    @Override public void setNumberOfWheels(int wheels) { numberOfWheels = wheels; }
    @Override public int getNumberOfWheels() { return numberOfWheels; }
    @Override public void setType(String type) { this.type = type; }
    @Override public String getType() { return type; }
}

class Truck implements Vehicle, TruckVehicle {
    private String make, model, transmissionType;
    private int year;
    private double cargoCapacity;
    
    public Truck(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override public String getMake() { return make; }
    @Override public String getModel() { return model; }
    @Override public int getYear() { return year; }
    @Override public void setCargoCapacity(double capacity) { cargoCapacity = capacity; }
    @Override public double getCargoCapacity() { return cargoCapacity; }
    @Override public void setTransmissionType(String transmissionType) { this.transmissionType = transmissionType; }
    @Override public String getTransmissionType() { return transmissionType; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Vehicle Information System");
        System.out.println("Select vehicle type: 1. Car 2. Motorcycle 3. Truck");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1: createCar(scanner); break;
            case 2: createMotorcycle(scanner); break;
            case 3: createTruck(scanner); break;
            default: System.out.println("Invalid choice!");
        }
        scanner.close();
    }
    
    private static void createCar(Scanner scanner) {
        System.out.println("Enter Car Make:"); String make = scanner.nextLine();
        System.out.println("Enter Car Model:"); String model = scanner.nextLine();
        System.out.println("Enter Car Year:"); int year = scanner.nextInt(); scanner.nextLine();
        Car car = new Car(make, model, year);
        System.out.println("Enter Number of Doors:"); int doors = scanner.nextInt(); scanner.nextLine();
        car.setNumberOfDoors(doors);
        System.out.println("Enter Fuel Type (petrol/diesel/electric):"); String fuelType = scanner.nextLine();
        car.setFuelType(fuelType);
        displayVehicleDetails(car);
    }

    private static void createMotorcycle(Scanner scanner) {
        System.out.println("Enter Motorcycle Make:"); String make = scanner.nextLine();
        System.out.println("Enter Motorcycle Model:"); String model = scanner.nextLine();
        System.out.println("Enter Motorcycle Year:"); int year = scanner.nextInt(); scanner.nextLine();
        Motorcycle motorcycle = new Motorcycle(make, model, year);
        System.out.println("Enter Number of Wheels:"); int wheels = scanner.nextInt(); scanner.nextLine();
        motorcycle.setNumberOfWheels(wheels);
        System.out.println("Enter Type (sport/cruiser/off-road):"); String type = scanner.nextLine();
        motorcycle.setType(type);
        displayVehicleDetails(motorcycle);
    }

    private static void createTruck(Scanner scanner) {
        System.out.println("Enter Truck Make:"); String make = scanner.nextLine();
        System.out.println("Enter Truck Model:"); String model = scanner.nextLine();
        System.out.println("Enter Truck Year:"); int year = scanner.nextInt(); scanner.nextLine();
        Truck truck = new Truck(make, model, year);
        System.out.println("Enter Cargo Capacity (in tons):"); double capacity = scanner.nextDouble(); scanner.nextLine();
        truck.setCargoCapacity(capacity);
        System.out.println("Enter Transmission Type (manual/automatic):"); String transmissionType = scanner.nextLine();
        truck.setTransmissionType(transmissionType);
        displayVehicleDetails(truck);
    }

    private static void displayVehicleDetails(Vehicle vehicle) {
        System.out.println("Vehicle Details:");
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year: " + vehicle.getYear());
        
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            System.out.println("Number of Doors: " + car.getNumberOfDoors());
            System.out.println("Fuel Type: " + car.getFuelType());
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) vehicle;
            System.out.println("Number of Wheels: " + motorcycle.getNumberOfWheels());
            System.out.println("Type: " + motorcycle.getType());
        } else if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
            System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
            System.out.println("Transmission Type: " + truck.getTransmissionType());
        }
    }
}