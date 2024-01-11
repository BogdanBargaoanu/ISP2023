package aut.isp.lab4.exercise5;

public class LightController {
    private float lightOnTime;
    private float lightOffTime;

    public void setLightOnTime(float lightOnTime) {
        this.lightOnTime = lightOnTime;
    }

    public void setLightOffTime(float lightOffTime) {
        this.lightOffTime = lightOffTime;
    }

    public float getLightOnTime() {
        return lightOnTime;
    }

    public float getLightOffTime() {
        return lightOffTime;
    }

    public void turnOn() {
        System.out.println("S-a pornit lumina");
    }

    public void turnOff() {
        System.out.println("S-a stins lumina");
    }

    public LightController() {
        lightOffTime = 0;
        lightOnTime = 0;
    }

    public LightController(float lightOnTime, float lightOffTime) {
        this.lightOnTime = lightOnTime;
        this.lightOffTime = lightOffTime;

    }

    public String toString() {
        int hour = (int) lightOnTime;
        int minute = (int) ((lightOnTime - hour) * 100);
        int hour2 = (int) lightOffTime;
        int minute2 = (int) ((lightOffTime - hour2) * 100);


        String minuteStr = (minute < 10) ? "0" + minute : Integer.toString(minute);
        String minuteStr2 = (minute2 < 10) ? "0" + minute2 : Integer.toString(minute2);
        return "Timpul pornirii luminilor este: " + hour + ":" + minuteStr + " iar timpul opririi lor este: " + hour2 + ":" + minuteStr2;
    }
}
