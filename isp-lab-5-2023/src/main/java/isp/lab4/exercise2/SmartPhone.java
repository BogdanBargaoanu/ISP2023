package isp.lab4.exercise2;

public class SmartPhone implements Chargeable {
    private int batteryLevel;

    public SmartPhone(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void charge(int minute) {
        System.out.print("Se incarca smartphone....   ");
        if (batteryLevel < 80) {
            batteryLevel += 2 * minute; //2% pe minut
        } else if (batteryLevel >= 80) {
            batteryLevel += 0.5 * minute; //0.5% pe minut
        }
        if (batteryLevel > 100) {
            batteryLevel = 100;
            System.out.println("Bateria telefonului s-a incarcat complet!");
        }
    }
}
