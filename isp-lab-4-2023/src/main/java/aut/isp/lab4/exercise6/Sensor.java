package aut.isp.lab4.exercise6;

public abstract class Sensor {
    private String manufacturer;
    private String model;

    public String toString() {
        return "Producator senzor: " + manufacturer + " modelul: " + model;
    }

    public Sensor(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }
}
