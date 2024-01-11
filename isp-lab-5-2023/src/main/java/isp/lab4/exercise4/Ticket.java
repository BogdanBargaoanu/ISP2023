package isp.lab4.exercise4;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private Event event;

    public Ticket(String ticketId, Event event) {
        this.ticketId = ticketId;
        this.event = event;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String toString() {
        return "Bilet la " + event.getEventName() + " generat in data de " + event.getDate() + " achizitionat la pretul de: " + event.getPrice() + " lei";
    }
}
