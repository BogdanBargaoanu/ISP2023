package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise5.*;
import aut.isp.lab4.exercise5.AquariumController;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ex5Test {
    @Test
    public void testEx5v1() {
        LevelSensor ls = new LevelSensor("depth", "longv1", 85.30F);
        TemperatureSensor ts = new TemperatureSensor("TempPRO", "celsius", 25);
        Alarm a1 = new Alarm("LevelAlarm", "v3");
        Heater h1 = new Heater("AquaHeat", "rev2.1");
        FishFeeder f1 = new FishFeeder("Feederv1", "PRO", 12);
        LightController l1 = new LightController(0.10F, 6.30F);
        AquariumController ac = new AquariumController("Large", "AquaPRO", 10.30F, 11.30F, 28, 85.30F, f1, l1, ls, ts, a1, h1);
        assertEquals(ac.getWaterLevel(), ls.getValue(), 0.001F); //ac.checkWaterLevel() ---85.30 la senzor 85.30 baseline la controller
        ac.checkWaterLevel();
        ls.setValue(30.30F);
        assert ac.getWaterLevel() > ls.getValue(); //ac.checkWaterLevel() ---30.30 la senzor si 85.30 baseline la controller
        ac.checkWaterLevel();
        assert ac.getTemperature() > ts.getValue(); //ac.checkTemperature() ---25 la senzor si 28 baseline la controller
        ac.checkTemperature();
        ts.setValue(30);
        assert ac.getTemperature() < ts.getValue(); //ac.checkTemperature() ---30 la senzor si 28 baseline la controller
    }

    @Test
    public void testEx5v2() { //test pentru eroare la initializare nula cu constructor implicit
        LevelSensor ls = new LevelSensor("depth", "longv1", 85.30F);
        TemperatureSensor ts = new TemperatureSensor("TempPRO", "celsius", 25);
        Alarm a1 = new Alarm("LevelAlarm", "v3");
        Heater h1 = new Heater("AquaHeat", "rev2.1");
        FishFeeder f1 = new FishFeeder("Feederv1", "PRO", 12);
        LightController l1 = new LightController(0.10F, 6.30F);
        AquariumController ac = new AquariumController();
        assertThrows(NullPointerException.class, () -> ac.setCurrentTime(10.30F));
        ac.checkTemperature();
        ac.checkWaterLevel();
    }
}
