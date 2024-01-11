package isp.lab3;


import isp.lab3.exercise3.Vehicle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VehicleTest {
    @Test
    public void testtoString() {
        Vehicle vehicle = new Vehicle("Dacia", "Logan", 150, 'B');
        assertEquals("Dacia (Logan) speed 150 fuel type B", vehicle.toString());
    }
}
