package aut.isp.lab4.exercise5;

public class Alarm extends Actuator {
    public void turnOn() {
        System.out.println("S-a pornit alarma de nivel al apei!");
    }

    public void turnOff() {
        System.out.println("S-a oprit alarma de nivel al apei!");
    }

    public Alarm(String manufacturer, String model) {
        super(manufacturer, model);
    }
}
