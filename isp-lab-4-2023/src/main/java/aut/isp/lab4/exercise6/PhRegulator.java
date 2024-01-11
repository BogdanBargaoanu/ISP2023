package aut.isp.lab4.exercise6;

public class PhRegulator extends Actuator {
    public void turnOn() {
        System.out.println("S-a adaugat bicarbonat de sodiu pentru a urca PH-ul apei!");
    }

    public void turnOff() {
        System.out.println("S-a adaugat acid fosforic pentru a scadea PH-ul apei!");
    }

    public PhRegulator(String manufacturer, String model) {
        super(manufacturer, model);
    }
}
