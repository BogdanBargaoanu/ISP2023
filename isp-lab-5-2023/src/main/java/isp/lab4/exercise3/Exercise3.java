package isp.lab4.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        Sensor[] sensors = new Sensor[5];
        MonitoringService ms = new MonitoringService(sensors);
        sensors[0] = new TemperatureSensor("TermostatApa ", "Bucla de racire apa", 32.0);
        sensors[1] = new PressureSensor("PresiunePneu ", "Anvelopa", 3.3);
        sensors[2] = new PressureSensor("PresiuneUlei ", "Baia de ulei", 35.4);
        sensors[3] = new TemperatureSensor("TermostatHabitaclu ", "Bord", 22.3);
        sensors[4] = new PressureSensor("PresiuneTurbo ", "FurtunTurbo", 1.3);

        for (Sensor sensor : sensors) {
            System.out.println(sensor.toString());
        }
        System.out.println("Media temperaturilor sistemului: " + ms.getAverageTemperatureSensors());
        System.out.println("Media presiunilor sistemului: " + ms.getAveragePressureSensors());
        System.out.println("Media tuturor senzorilor: " + ms.getAverageAllSensors());
    }
}
