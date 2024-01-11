package aut.isp.lab4.exercise4;

public class AquariumController {
    private String manufacturer;
    private String model;
    private float currentTime;

    private float feedingTime;

    private FishFeeder feeder;

    private LightController light;

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
        feedingTime = 1;
        model = "Necunoscut";
        manufacturer = "Necunoscut";
        feeder = null;
        light = null;
    }

    public AquariumController(String model, String manufacturer, float currentTime, float feedingTime, FishFeeder feeder, LightController light) {
        this.currentTime = currentTime;
        this.model = model;
        this.manufacturer = manufacturer;
        this.feedingTime = feedingTime;
        this.feeder = feeder;
        this.light = light;
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
}
