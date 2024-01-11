package isp.lab4.exercise3;

public abstract class Sensor {
    private String installLocation;
    private String name;

    public Sensor(String name, String installLocation) {
        this.name = name;
        this.installLocation = installLocation;
    }

    public String getName() {
        return name;
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public abstract String toString();
}
