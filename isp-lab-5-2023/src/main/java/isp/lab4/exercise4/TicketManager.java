package isp.lab4.exercise4;

public interface TicketManager {
    public Ticket generateTicket(User user, Event event);

    public boolean validateTicket(String ticketId);
}
