package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise4.AquariumController;
import aut.isp.lab4.exercise4.FishFeeder;
import aut.isp.lab4.exercise4.LightController;
import org.junit.Test;

import java.util.InvalidPropertiesFormatException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Ex4Test {
    @Test
    public void testEx4v1() {
        FishFeeder f1 = new FishFeeder("Feederv1", "PRO", 12);
        LightController l1 = new LightController(0.10F, 6.30F);
        AquariumController a1 = new AquariumController("Aqua", "AquaPRO", 10.30F, 20.30F, f1, l1);
        assertEquals(false, (a1.getCurrentTime() >= l1.getLightOnTime() && a1.getCurrentTime() <= l1.getLightOffTime())); //10:30 > 6:30
    }

    @Test
    public void testEx4v2() { //test pentru eroare la initializare nula cu constructor implicit
        FishFeeder f2 = new FishFeeder();
        LightController l2 = new LightController();
        AquariumController a2 = new AquariumController();
        assertThrows(NullPointerException.class, () -> a2.setCurrentTime(10.30F));
    }
}
