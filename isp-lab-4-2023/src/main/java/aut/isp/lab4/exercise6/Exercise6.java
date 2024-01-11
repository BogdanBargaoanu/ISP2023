package aut.isp.lab4.exercise6;


public class Exercise6 {
    public static void main(String[] args) {
        LevelSensor ls = new LevelSensor("depth", "longv1", 5.4F);
        System.out.println(ls.toString());
        System.out.println("Nivelul senzorului: " + ls.getValue());
        ls.setValue(10.30F);
        TemperatureSensor ts = new TemperatureSensor("TempPRO", "celsius", 25);
        System.out.println(ts.toString());
        System.out.println("Temperatura senzorului: " + ts.getValue());
        ts.setValue(30);
        Alarm a1 = new Alarm("LevelAlarm", "v3");
        System.out.println(a1.toString());
        a1.turnOn();
        a1.turnOff();
        Heater h1 = new Heater("AquaHeat", "rev2.1");
        System.out.println(h1.toString());
        h1.turnOn();
        h1.turnOff();
        PhSensor ps = new PhSensor("HealthyAqua", "rev1", 3.3F);
        System.out.println(ps.toString());
        System.out.println("Nivelul PH al senzorului: " + ps.getValue());
        ps.setValue(5.8F);
        PhRegulator pr = new PhRegulator("AquaLife", "RegulatorPro");
        System.out.println(pr.toString());
        pr.turnOn();
        pr.turnOff();
        FishFeeder f1 = new FishFeeder("Feederv1", "PRO", 12);
        LightController l1 = new LightController(0.10F, 6.30F);
        AquariumController ac = new AquariumController("Large", "AquaPRO", 10.30F, 11.30F, 28, 85.30F, 6.3F, f1, l1, ls, ts, ps, a1, h1, pr);
        ts.setValue(12);
        ac.checkTemperature();
        ts.setValue(35);
        ac.checkTemperature();
        ac.checkWaterLevel();
        ls.setValue(90.30F);
        ac.checkWaterLevel();
        ac.checkPhLevel(); //5.8PH senzor 6.3 baseline la controller ->ok
        ps.setValue(3.8F);
        ac.checkPhLevel();
        ps.setValue(12.30F);
        ac.checkPhLevel();
    }
}
