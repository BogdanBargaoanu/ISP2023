package aut.isp.lab4.exercise1;

public class AquariumController {

    private String manufacturer;
    private String model;
    private float currentTime;

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }

    public AquariumController() {
        currentTime = 0;
        model = "Necunoscut";
        manufacturer = "Necunoscut";
    }

    public AquariumController(String model, String manufacturer, float currentTime) {
        this.currentTime = currentTime;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public String toString() {
        int hour = (int) currentTime;
        int minute = (int) ((currentTime - hour) * 100);

        String minuteStr = (minute < 10) ? "0" + minute : Integer.toString(minute);
        return "Producator: " + manufacturer + " modelul: " + model + " ora:" + hour + ":" + minuteStr;
    }


}