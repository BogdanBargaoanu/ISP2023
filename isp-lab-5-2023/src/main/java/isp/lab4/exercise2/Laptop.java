package isp.lab4.exercise2;

public class Laptop implements Chargeable {
    private int batteryLevel;

    public Laptop(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void charge(int minute) {
        System.out.print("Se incarca laptop....   ");
        if (batteryLevel < 80) {
            batteryLevel += 3 * minute; //3% pe minut
        } else if (batteryLevel >= 80) {
            batteryLevel += minute; //1% pe minut
        }
        if (batteryLevel > 100) {
            batteryLevel = 100;
            System.out.println("Bateria laptopului s-a incarcat complet!");
        }
    }
}
