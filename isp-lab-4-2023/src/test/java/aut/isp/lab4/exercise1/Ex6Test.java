package aut.isp.lab4.exercise1;


import aut.isp.lab4.exercise6.*;
import aut.isp.lab4.exercise6.AquariumController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Ex6Test {
    @Test
    public void testEx6v1() {
        LevelSensor ls = new LevelSensor("depth", "longv1", 85.30F);
        TemperatureSensor ts = new TemperatureSensor("TempPRO", "celsius", 25);
        Alarm a1 = new Alarm("LevelAlarm", "v3");
        Heater h1 = new Heater("AquaHeat", "rev2.1");
        PhSensor ps = new PhSensor("HealthyAqua", "rev1", 6.3F);
        PhRegulator pr = new PhRegulator("AquaLife", "RegulatorPro");
        FishFeeder f1 = new FishFeeder("Feederv1", "PRO", 12);
        LightController l1 = new LightController(0.10F, 6.30F);
        AquariumController ac = new AquariumController("Large", "AquaPRO", 10.30F, 11.30F, 28, 85.30F, 6.3F, f1, l1, ls, ts, ps, a1, h1, pr);
        assertEquals(ac.getPh(), ps.getValue(), 0.001F); //ac.checkPhLevel() ---6.30 la senzor 6.30 baseline la controller
        ac.checkPhLevel();
        ps.setValue(12.30F);
        assert ac.getPh() + 1 < ps.getValue(); //ac.checkPhLevel() ---12.30 la senzor si 6.30 baseline la controller -> off
        ac.checkPhLevel();
        ps.setValue(1.30F);
        assert ac.getPh() - 1 > ps.getValue(); //ac.checkPhLevel() ---1.30 la senzor si 6.30 baseline la controller -> on
        ac.checkPhLevel();
    }

    @Test
    public void testEx6v2() { //test pentru eroare la initializare nula cu constructor implicit
        LevelSensor ls = new LevelSensor("depth", "longv1", 85.30F);
        TemperatureSensor ts = new TemperatureSensor("TempPRO", "celsius", 25);
        Alarm a1 = new Alarm("LevelAlarm", "v3");
        Heater h1 = new Heater("AquaHeat", "rev2.1");
        PhSensor ps = new PhSensor("HealthyAqua", "rev1", 6.3F);
        PhRegulator pr = new PhRegulator("AquaLife", "RegulatorPro");
        FishFeeder f1 = new FishFeeder("Feederv1", "PRO", 12);
        LightController l1 = new LightController(0.10F, 6.30F);
        AquariumController ac = new AquariumController();
        assertThrows(NullPointerException.class, () -> ac.setCurrentTime(10.30F));
        ac.checkPhLevel();
    }
}
