package isp.lab4.exercise3;

public class PressureSensor extends Sensor {
    private double pressure;

    public PressureSensor(String name, String installLocation, double pressure) {
        super(name, installLocation);
        this.pressure = pressure;
    }

    public double getPressure() {
        return pressure;
    }

    @Override
    public String toString() {
        return "Senzor de presiune----Nume: " + this.getName() + " locatie: " + this.getInstallLocation();
    }
}
