package aut.isp.lab4.exercise5;

public class TemperatureSensor extends Sensor {
    private int value;

    public TemperatureSensor(String manufacturer, String model, int value) {
        super(manufacturer, model);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        System.out.println("S-a setat valoarea senzorului la: " + value);
    }
}
