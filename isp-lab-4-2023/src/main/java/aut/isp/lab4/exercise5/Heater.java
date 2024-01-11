package aut.isp.lab4.exercise5;

public class Heater extends Actuator {
    public void turnOn() {
        System.out.println("S-a pornit incalzirea apei!");
    }

    public void turnOff() {
        System.out.println("S-a oprit incalzirea apei!");
    }

    public Heater(String manufacturer, String model) {
        super(manufacturer, model);
    }
}
