package isp.lab6.exercise2;

public class Vehicle {
    private String vin;
    private String licensePlate;
    private String make;
    private String model;
    private int year;

    public Vehicle(String vin, String licensePlate, String make, String model, int year) {
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    @Override
    public int hashCode() {
        return vin.hashCode();
    }

    @Override
    public String toString() {
        return "VIN: " + vin + ", License Plate: " + licensePlate + ", Make: " + make + ", Model: " + model + ", Year: " + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        boolean b;
        return b = this.hashCode() == vehicle.hashCode();
    }
}
