package isp.lab6.exercise2;

import java.util.HashSet;
import java.util.Set;

public class VehicleRegistry {
    private Set<Vehicle> vehicles;

    public VehicleRegistry() {
        this.vehicles = new HashSet<>();
    }

    public void addVehicle(String vin, String licensePlate, String make, String model, int year) {
        Vehicle vehicle = new Vehicle(vin, licensePlate, make, model, year);
        boolean exista = false;
        for (Vehicle veh : vehicles) {
            if (veh.equals(vehicle))
                exista = true;
        }
        if (!exista) {
            vehicles.add(vehicle);
            System.out.println("Vehiculul cu VIN: " + vin + " a fost adaugat in registru.");
        } else {
            System.out.println("Vehiculul cu VIN: " + vin + " exista deja in registru.");
        }
    }

    public void removeVehicle(String vin) {
        Vehicle vehicleToBeRemoved = null;
        for (Vehicle vehicle : vehicles) {
            if (vin.hashCode() == vehicle.hashCode()) {
                vehicleToBeRemoved = vehicle;
                break;
            }
        }
        if (vehicleToBeRemoved != null) {
            vehicles.remove(vehicleToBeRemoved);
            System.out.println("Vehiculul cu VIN: " + vin + " a fost sters din registru.");
        } else {
            System.out.println("Vehiculul cu VIN: " + vin + " nu exista in registru.");
        }
    }

    public boolean checkExistance(String vin) {
        for (Vehicle vehicle : vehicles) {
            if (vin.hashCode() == vehicle.hashCode()) {
                return true;
            }
        }
        return false;
    }

    public void displayVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("Registrul de vehicule este gol.");
        } else {
            System.out.println("Registrul de vehicule:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.toString());
            }
        }
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }
}
