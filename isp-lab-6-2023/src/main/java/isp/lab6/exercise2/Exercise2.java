package isp.lab6.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        VehicleRegistry vehicleRegistry = new VehicleRegistry();
        vehicleRegistry.addVehicle("WAUZ662424", "CJ33ASD", "Audi", "A4", 2015);
        vehicleRegistry.addVehicle("WAUZ662424", "BN13AFS", "BMW", "330d", 2010);
        vehicleRegistry.addVehicle("VWAU556223", "B111JMM", "Volkswagen", "Passat", 2022);
        vehicleRegistry.addVehicle("AUUCU11111", "MM55ASM", "Mercedes-Benz", "S550", 2021);
        vehicleRegistry.removeVehicle("WAUZ662424");
        vehicleRegistry.addVehicle("WAUZ662424", "BN13AFS", "BMW", "330d", 2010);
        if (vehicleRegistry.checkExistance("WAUZ662424")) {
            System.out.println("Verificare existenta VIN: WAUZ662424--------- vehiculul exista in registru.");
        }
        vehicleRegistry.displayVehicles();
    }
}
