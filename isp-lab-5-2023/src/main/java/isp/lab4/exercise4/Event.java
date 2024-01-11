package isp.lab4.exercise4;

import java.time.LocalDateTime;

public class Event {
    private String eventName;
    private LocalDateTime date;
    private double price;

    public Event(String eventName, LocalDateTime date, double price) {
        this.eventName = eventName;
        this.date = date.withNano(0);
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getEventName() {
        return eventName;
    }

    public double getPrice() {
        return price;
    }
}
