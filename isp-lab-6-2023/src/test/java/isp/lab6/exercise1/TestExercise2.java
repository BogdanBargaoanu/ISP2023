package isp.lab6.exercise1;

import isp.lab6.exercise2.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestExercise2 {
    @Test
    public void testEx2() {
        VehicleRegistry vehicleRegistry = new VehicleRegistry();
        vehicleRegistry.addVehicle("WAUZ662424", "CJ33ASD", "Audi", "A4", 2015);
        vehicleRegistry.addVehicle("WAUZ662424", "BN13AFS", "BMW", "330d", 2010);
        vehicleRegistry.addVehicle("VWAU556223", "B111JMM", "Volkswagen", "Passat", 2022);
        assertEquals(false, vehicleRegistry.checkExistance("ASD"));
        assertEquals(true, vehicleRegistry.checkExistance("VWAU556223"));
        vehicleRegistry.removeVehicle("WAUZ662424");
        String rez = "";
        for (Vehicle vehicle : vehicleRegistry.getVehicles()) {
            rez = rez + vehicle.toString();
        }
        assertNotEquals("VIN: VWAU556223, License Plate: B111JMM, Make: Volkswagen, Model: Passat, Year: 2022\n" +
                "VIN: WAUZ662424, License Plate: BN13AFS, Make: BMW, Model: 330d, Year: 2010", rez);
        assertEquals("VIN: VWAU556223, License Plate: B111JMM, Make: Volkswagen, Model: Passat, Year: 2022", rez);
    }
}
