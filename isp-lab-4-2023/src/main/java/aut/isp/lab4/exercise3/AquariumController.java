package aut.isp.lab4.exercise3;

public class AquariumController {
    private String manufacturer;
    private String model;
    private float currentTime;

    private float feedingTime;

    private FishFeeder feeder;

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if (currentTime == feedingTime) {
            feeder.feed();
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
    }

    public AquariumController(String model, String manufacturer, float currentTime, float feedingTime, FishFeeder feeder) {
        this.currentTime = currentTime;
        this.model = model;
        this.manufacturer = manufacturer;
        this.feedingTime = feedingTime;
        this.feeder = feeder;
    }

    public String toString() {
        int hour = (int) currentTime;
        int minute = (int) ((currentTime - hour) * 100);

        String minuteStr = (minute < 10) ? "0" + minute : Integer.toString(minute);
        return "Producator: " + manufacturer + " modelul: " + model + " ora:" + hour + ":" + minuteStr;
    }

}
