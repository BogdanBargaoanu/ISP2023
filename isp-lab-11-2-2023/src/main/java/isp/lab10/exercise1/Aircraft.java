package isp.lab10.exercise1;

import java.util.Objects;

public class Aircraft implements Runnable {
    String id;
    String state;
    int altitude;
    ATC atc;
 public void receiveAtcMessage(AtcMsg msg) {

 }
  public Aircraft(String id) {
     this.id=id;
     state="wait";
     altitude=1;
  }
    @Override
    public void run() {
        System.out.println("Aircraft " + id + " is on stand.");

        while (isRunning) {
            String command = atc.getCommand();

            if (command.equals("TakeOff")) {
                taxing();
                takingOff();
                ascending();
                cruising();
                descending();
                landing();
                break;
            }
        }
    }
    private void taxing() {
        System.out.println("Aircraft " + id + " is taxing.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void takingOff() {
        System.out.println("Aircraft " + id + " is taxing.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void ascending() {
        System.out.println("Aircraft " + id + " is taxing.");
        int i=0;
        while(i++<10)
        try {
            Thread.sleep(1000);
            altitude++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void cruising() {
        System.out.println("Aircraft " + id + " is taxing.");
        while(atc.getCommand().equals(LandCommand))
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void descending() {

    }
    private void landing() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return Objects.equals(id, aircraft.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
