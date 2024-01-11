package isp.lab4.exercise2;

public class SmartWatch implements Chargeable {
    private int batteryLevel;

    public SmartWatch(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void charge(int minute) {
        System.out.print("Se incarca smartwatch....   ");
        if (batteryLevel < 80) {
            batteryLevel += 1 * minute; //1% pe minut
        } else if (batteryLevel >= 80) {
            batteryLevel += 0.25 * minute; //0.25% pe minut
        }
        if (batteryLevel > 100) {
            batteryLevel = 100;
            System.out.println("Bateria ceasului s-a incarcat complet!");
        }
    }
}
