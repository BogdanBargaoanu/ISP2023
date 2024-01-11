package isp.lab4.exercise3;

public class TemperatureSensor extends Sensor {
    private double temperature;

    public TemperatureSensor(String name, String installLocation, double temperature) {
        super(name, installLocation);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "Senzor de temperatura----Nume: " + this.getName() + " locatie: " + this.getInstallLocation();
    }
}
