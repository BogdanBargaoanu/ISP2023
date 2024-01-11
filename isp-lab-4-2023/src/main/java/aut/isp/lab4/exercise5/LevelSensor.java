package aut.isp.lab4.exercise5;

public class LevelSensor extends Sensor {
    private float value;

    public LevelSensor(String manufacturer, String model, float value) {
        super(manufacturer, model);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
        System.out.println("S-a setat valoarea senzorului la: " + value);
    }
}
