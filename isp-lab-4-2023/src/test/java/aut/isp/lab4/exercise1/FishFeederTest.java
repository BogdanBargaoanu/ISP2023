package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise2.FishFeeder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FishFeederTest {
    @Test
    public void testFishFeeder() {
        FishFeeder f = new FishFeeder("HealthyLife", "Classic", 5);
        assertEquals("Producator: HealthyLife model: Classic capacitate actuala a Feeder: 5", f.toString());
    }

    @Test
    public void testFeedFillup() {
        FishFeeder ff = new FishFeeder();
        ff.fillUp();
        ff.feed();
        assertEquals("Producator: Necunoscut model: Necunoscut capacitate actuala a Feeder: 13", ff.toString());
    }
}
