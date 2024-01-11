package isp.lab7.safehome;

public class Door {
    private DoorStatus status;

    public void closeDoor() {
        status = status.CLOSE;
    }

    public void openDoor() {
        status = status.OPEN;
    }

    public Door(DoorStatus status) {
        this.status = status;
    }

    public DoorStatus getStatus() {
        return status;
    }
}
