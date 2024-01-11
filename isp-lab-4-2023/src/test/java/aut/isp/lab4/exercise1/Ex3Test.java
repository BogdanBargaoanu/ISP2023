package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise3.AquariumController;
import aut.isp.lab4.exercise3.FishFeeder;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ex3Test {
    @Test
    public void testEx3v1() {
        FishFeeder f = new FishFeeder("Feederv1", "PRO", 12);
        AquariumController a = new AquariumController("Large", "AnimPro", 10.30F, 11.30F, f);
        a.setCurrentTime(11.30F);
        assertEquals(11, f.getMeals());
    }

    @Test
    public void testEx3v2() { //test pentru eroare la initializare nula cu constructor implicit
        FishFeeder f1 = new FishFeeder();
        AquariumController a1 = new AquariumController();
        assertEquals(0, f1.getMeals());
        a1.setFeedingTime(2.30F);
        assertThrows(NullPointerException.class, () -> a1.setCurrentTime(2.30F));
    }
}
