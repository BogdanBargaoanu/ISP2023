package isp.lab3;

import isp.lab3.example.Airplain;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class AirplainTest {

    @Test
    public void testIsLate() {
        //create airplane with departure time 2023-03-15T09:30
        LocalDateTime date1 = LocalDateTime.of(2025, 3, 15, 9, 30); // March 15, 2025 at 9:30 AM
        Airplain airplane = new Airplain("Boeing 747", 416, 913, 14200, date1);

        // Test isLate() when the departure time is in the future
        assertFalse(airplane.isLate());

        // Test isLate() when the departure time is in the past
        LocalDateTime date2 = LocalDateTime.of(2019, 3, 15, 9, 30); // March 15, 2019 at 9:30 AM
        airplane = new Airplain("Boeing 747", 416, 913, 14200, date2);
        assertTrue(airplane.isLate());
    }

    @Test
    public void testLoadPassengers() {
        LocalDateTime date1 = LocalDateTime.of(2023, 3, 15, 9, 30); // March 15, 2023 at 9:30 AM
        Airplain airplane = new Airplain("Boeing 747", 416, 913, 14200, date1);

        // Test loading passengers when there are enough available seats
        airplane.loadPassengers(200);
        assertEquals(200, airplane.getPassengers());
        airplane.loadPassengers(100);
        assertEquals(300, airplane.getPassengers());

        // Test loading passengers when there are not enough available seats
        airplane.loadPassengers(117);
        assertEquals(300, airplane.getPassengers());
    }
}