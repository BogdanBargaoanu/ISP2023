package aut.isp.lab4.exercise5;


public class AquariumController {
    private String manufacturer;
    private String model;
    private float currentTime;

    private float feedingTime;

    private FishFeeder feeder;

    private LightController light;

    private Sensor sensor1;
    private Sensor sensor2;
    private Actuator actuator1;
    private Actuator actuator2;
    private int temperature;
    private float waterLevel;

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
        actuator1 = null;
        actuator2 = null;
        waterLevel = 0;

    }

    public AquariumController(String model, String manufacturer, float currentTime, float feedingTime, int temperature, float waterLevel, FishFeeder feeder, LightController light, Sensor sensor1, Sensor sensor2, Actuator actuator1, Actuator actuator2) {
        this.currentTime = currentTime;
        this.model = model;
        this.manufacturer = manufacturer;
        this.feedingTime = feedingTime;
        this.feeder = feeder;
        this.light = light;
        this.temperature = temperature;
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
        this.actuator1 = actuator1;
        this.actuator2 = actuator2;
        this.waterLevel = waterLevel;
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

    public float getWaterLevel() {
        return waterLevel;
    }

    public int getTemperature() {
        return temperature;
    }
}
