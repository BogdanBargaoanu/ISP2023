package isp.lab7.safehome;

import java.time.LocalDateTime;

public class AccessLog {
    private String tenantName;
    private LocalDateTime dateTime;
    private String operation;
    private DoorStatus doorStatus;
    private String errorMessage;

    public AccessLog(String tenantName, LocalDateTime dateTime, String operation, DoorStatus doorStatus, String errorMessage) {
        this.tenantName = tenantName;
        this.dateTime = dateTime;
        this.operation = operation;
        this.doorStatus = doorStatus;
        this.errorMessage = errorMessage;
    }
}
