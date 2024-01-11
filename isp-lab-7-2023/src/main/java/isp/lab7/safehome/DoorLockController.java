package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DoorLockController implements ControllerInterface {
    private Door door;
    private int tries;
    private String doorLock;
    private Map<Tenant, AccessKey> validAccess;
    private List<AccessLog> accessLogs;

    public DoorLockController() {
        this.validAccess = null;
        this.door = null;
        this.accessLogs = null;
        tries = 0;
        doorLock = "UNLOCKED";
    }

    public DoorLockController(Door door, Map<Tenant, AccessKey> validAccess) {
        this.door = door;
        this.validAccess = validAccess;
        this.accessLogs = new ArrayList<>();
        tries = 0;
        doorLock = "UNLOCKED";
    }

    public Tenant getTenant(String pin) {
        AccessKey accessKey = new AccessKey(pin);
        for (Map.Entry<Tenant, AccessKey> entry : validAccess.entrySet()) {
            if (entry.getValue().equals(accessKey)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public DoorStatus enterPin(String pin) throws Exception {
        AccessKey accessKey = new AccessKey(pin);
        LocalDateTime now = LocalDateTime.now();
        AccessLog accessLog;
        if (pin.equals(MASTER_KEY)) {
            doorLock = "UNLOCKED";
            tries = 0;
            door.openDoor();
            accessLog = new AccessLog("MASTERKEY", now, "UNLOCK", door.getStatus(), "NO ERROR");
            accessLogs.add(accessLog);
            return door.getStatus();
        }
        if (validAccess.containsValue(accessKey) && doorLock.equals("UNLOCKED")) {
            if (door.getStatus() == DoorStatus.OPEN) {
                door.closeDoor();
            } else if (door.getStatus() == DoorStatus.CLOSE) {
                door.openDoor();
            }
            accessLog = new AccessLog(getTenant(pin).getName(), now, "enterPin - success", door.getStatus(), "NO ERROR");
            accessLogs.add(accessLog);
            return door.getStatus();
        } else {
            tries++;
            if (tries >= 3) {
                doorLock = "LOCKED";
                door.closeDoor();
                accessLog = new AccessLog("NoTenant", now, "enterPin - fail", door.getStatus(), "TooManyAttempts");
                accessLogs.add(accessLog);
                throw new TooManyAttemptsException("The pin: " + pin + "was used too many times. Door is now locked");
            } else {
                accessLog = new AccessLog("NoTenant", now, "enterPin - fail", door.getStatus(), "InvalidPin");
                accessLogs.add(accessLog);
                throw new InvalidPinException("The entered pin is invalid");
            }
        }
    }

    @Override
    public void addTenant(String pin, String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {//trim sterge spatii
            throw new EmptyTenantNameException("Cannot add empty name");
        }
        Tenant tenant = new Tenant(name);
        AccessKey accessKey = new AccessKey(pin);
        if (validAccess.containsKey(tenant)) {
            throw new TenantAlreadyExistsException("Tenant already exists: " + name);
        } else {
            validAccess.put(tenant, accessKey);
        }

    }

    @Override
    public void removeTenant(String name) throws Exception {
        Tenant tenant = new Tenant(name);
        if (!validAccess.containsKey(tenant)) {
            throw new TenantNotFoundException("Tenant " + name + "doesn't exist");
        } else {
            validAccess.remove(tenant);
        }
    }

    @Override
    public List<AccessLog> getAccessLogs() {
        return null;
    }
}
