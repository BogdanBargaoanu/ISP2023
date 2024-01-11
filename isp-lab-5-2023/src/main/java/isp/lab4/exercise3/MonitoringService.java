package isp.lab4.exercise3;

public class MonitoringService {

    private double avgTemp;
    private double avgPsi;
    private Sensor[] sensors;

    public MonitoringService(Sensor[] sensors) {
        this.sensors = sensors;
        avgTemp = 0;
        avgPsi = 0;
    }

    public double getAverageTemperatureSensors() {
        int cnt = 0;
        avgTemp = 0;
        for (Sensor sensor : sensors) {
            if (sensor instanceof TemperatureSensor) {
                cnt++;
                TemperatureSensor ts = (TemperatureSensor) sensor;
                avgTemp += ts.getTemperature();
            }
        }
        if (cnt == 0) {
            System.out.println("Nu exista senzori de temperatura in lista!");
            return 0;
        }
        avgTemp /= cnt;
        return avgTemp;
    }

    public double getAveragePressureSensors() {
        int cnt = 0;
        avgPsi = 0;
        for (Sensor sensor : sensors) {
            if (sensor instanceof PressureSensor) {
                cnt++;
                PressureSensor ps = (PressureSensor) sensor;
                avgPsi += ps.getPressure();
            }
        }
        if (cnt == 0) {
            System.out.println("Nu exista senzori de presiune in lista!");
            return 0;
        }
        avgPsi /= cnt;
        return avgPsi;
    }

    public double getAverageAllSensors() {
        int cntTemp = 0;
        int cntPsi = 0;
        avgTemp = 0;
        avgPsi = 0;

        for (Sensor sensor : sensors) {
            if (sensor instanceof TemperatureSensor) {
                cntTemp++;
                TemperatureSensor ts = (TemperatureSensor) sensor;
                avgTemp += ts.getTemperature();
            } else if (sensor instanceof PressureSensor) {
                cntPsi++;
                PressureSensor ps = (PressureSensor) sensor;
                avgPsi += ps.getPressure();
            }
        }
        if (cntTemp == 0 && cntPsi == 0) {
            System.out.println("Nu exista senzori de temperatura sau de presiune in lista!");
            return 0;
        }

        avgTemp /= cntTemp;
        avgPsi /= cntPsi;

        double avgAll = (avgTemp * cntTemp + avgPsi * cntPsi) / (cntTemp + cntPsi);
        return avgAll;
    }

}
