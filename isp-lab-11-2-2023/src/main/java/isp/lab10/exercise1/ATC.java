package isp.lab10.exercise1;

import java.util.ArrayList;
import java.util.List;

public class ATC {

    private List<Aircraft> aircrafts;

    public ATC() {
        aircrafts = new ArrayList<>();
    }

    public void addAircraft(String id) {
        Aircraft a = new Aircraft(id);
        for (Aircraft aircraft : aircrafts) {
            if (aircraft.equals(a)) {
                System.out.println("Aircraft with this id already exists");
            } else {
                aircrafts.add(a);
                System.out.println("Aircraft with id " + id + " added");
            }
        }
    }

    public void sendCommand(String id, AtcCommand command) {
        System.out.println("Aircraft with id " + id + " received command " + command);
    }

    public void showAircrafts() {
        System.out.println("Display aircrfats.");
    }

    public String getCommand() {

        return null;
    }
}

class AtcCommand {
    String command;

    public AtcCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "AtcCommand{" +
                "command='" + command + '\'' +
                '}';
    }
}
