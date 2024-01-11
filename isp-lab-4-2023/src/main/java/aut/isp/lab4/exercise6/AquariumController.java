package aut.isp.lab4.exercise6;

public class AquariumController {
    private String manufacturer;
    private String model;
    private float currentTime;

    private float feedingTime;

    private FishFeeder feeder;

    private LightController light;

    private Sensor sensor1;
    private Sensor sensor2;
    private Sensor sensor3;
    private Actuator actuator1;
    private Actuator actuator2;
    private Actuator actuator3;
    private int temperature;
    private float waterLevel;
    private float ph;

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if (currentTime == feedingTime) {
            feeder.feed();
        }
        if (currentTime >= light.getLightOnTime() && currentTime <= light.getLightOffTime()) {
            light.turnOn();
        } else {
            light.turnOff();
        }
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    public AquariumController() {
        currentTime = 0;
        feedingTime = 0;
        model = "Necunoscut";
        manufacturer = "Necunoscut";
        feeder = null;
        light = null;
        temperature = 0;
        sensor1 = null;
        sensor2 = null;
        sensor3 = null;
        actuator1 = null;
        actuator2 = null;
        actuator3 = null;
        waterLevel = 0;
        ph = 0;

    }

    public AquariumController(String model, String manufacturer, float currentTime, float feedingTime, int temperature, float waterLevel, float ph, FishFeeder feeder, LightController light, Sensor sensor1, Sensor sensor2, Sensor sensor3, Actuator actuator1, Actuator actuator2, Actuator actuator3) {
        this.currentTime = currentTime;
        this.model = model;
        this.manufacturer = manufacturer;
        this.feedingTime = feedingTime;
        this.feeder = feeder;
        this.light = light;
        this.temperature = temperature;
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
        this.sensor3 = sensor3;
        this.actuator1 = actuator1;
        this.actuator2 = actuator2;
        this.actuator3 = actuator3;
        this.waterLevel = waterLevel;
        this.ph = ph;
    }

    public String toString() {
        int hour = (int) currentTime;
        int minute = (int) ((currentTime - hour) * 100);

        String minuteStr = (minute < 10) ? "0" + minute : Integer.toString(minute);
        return "Producator: " + manufacturer + " modelul: " + model + " ora:" + hour + ":" + minuteStr;
    }

    public float getCurrentTime() {
        return currentTime;
    }

    public void checkTemperature() {
        if (sensor2 instanceof TemperatureSensor && actuator2 instanceof Heater) {
            TemperatureSensor temperatureSensor = (TemperatureSensor) sensor2;
            Heater heater = (Heater) actuator2;
            if (temperature > temperatureSensor.getValue()) {
                System.out.println("Temperatura este mai mica decat cea setata!");
                heater.turnOn();
            } else {
                System.out.println("Temperatura este mai mare sau egala cu cea setata!");
                heater.turnOff();
            }
        } else {
            System.out.println("Senzorul sau/si actuatorul nu se incadreaza in categoriile: Senzor temperatura si Heater");
        }
    }

    public void checkWaterLevel() {
        if (sensor1 instanceof LevelSensor && actuator1 instanceof Alarm) {
            LevelSensor levelSensor = (LevelSensor) sensor1;
            Alarm alarm = (Alarm) actuator1;
            if (waterLevel > levelSensor.getValue()) {
                System.out.println("Nivelul apei este prea scazut!");
                alarm.turnOn();
            } else {
                System.out.println("Nivelul apei este ok!");
                alarm.turnOff();
            }
        } else {
            System.out.println("Senzorul sau/si actuatorul nu se incadreaza in categoriile: Senzor nivel si Alarma");
        }
    }

    public void checkPhLevel() {
        if (sensor3 instanceof PhSensor && actuator3 instanceof PhRegulator) {
            PhSensor phSensor = (PhSensor) sensor3;
            PhRegulator phRegulator = (PhRegulator) actuator3;
            if (ph - 1 > phSensor.getValue()) { //margine de eroare la ph 2ph
                System.out.println("PH-ul apei este prea scazut!");
                phRegulator.turnOn();
            } else if (ph + 1 < phSensor.getValue()) {
                System.out.println("PH-ul apei este prea ridicat!");
                phRegulator.turnOff();
            } else {
                System.out.println("PH-ul apei este ok!");
            }
        } else {
            System.out.println("Senzorul sau/si actuatorul nu se incadreaza in categoriile: Senzor PH si Regulator PH");
        }
    }

    public float getWaterLevel() {
        return waterLevel;
    }

    public int getTemperature() {
        return temperature;
    }

    public float getPh() {
        return ph;
    }
}
