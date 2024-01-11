package isp.lab3.exercise3;

import java.util.Objects;

public class Vehicle {
    private String model;
    private String type;
    private int speed;
    private char fuelType;

    private static int numOfVehicles = 0;

    public Vehicle(String model, String type, int speed, char fuelType) {
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.fuelType = fuelType;
        numOfVehicles++;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getFuelType() {
        return fuelType;
    }

    public void setFuelType(char fuelType) {
        this.fuelType = fuelType;
    }

    public static int getNumOfVehicles() {
        return numOfVehicles;
    }

    @Override
    public String toString() {
        return model + " (" + type + ") speed " + speed + " fuel type " + fuelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return speed == vehicle.speed &&
                fuelType == vehicle.fuelType &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(type, vehicle.type);

    }

    public static void displayNumOfVehicles() {
        System.out.println("Numar de Vehicule create: " + numOfVehicles);
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Dacia", "Logan", 150, 'B');
        System.out.println("Vehicul 1:");
        System.out.println(vehicle1.getModel() + " (" + vehicle1.getType() + ") speed " + vehicle1.getSpeed() + " fuel type " + vehicle1.getFuelType());
        //System.out.println(vehicle1.toString());
        Vehicle vehicle2 = new Vehicle("BMW", "M5", 250, 'D');
        System.out.println("Vehicul 2:");
        System.out.println(vehicle2.getModel() + " (" + vehicle2.getType() + ") speed " + vehicle2.getSpeed() + " fuel type " + vehicle2.getFuelType());
        //System.out.println(vehicle2.toString());
        boolean equals = vehicle1.equals(vehicle2);
        System.out.println("Vehicul 1 la fel ca si Vehicul 2? " + equals);
        Vehicle.displayNumOfVehicles();

    }
}
