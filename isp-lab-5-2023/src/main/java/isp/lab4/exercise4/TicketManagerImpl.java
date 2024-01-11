package isp.lab4.exercise4;


import java.time.LocalDateTime;

public class TicketManagerImpl implements TicketManager {
    private int ticketCount;
    private Ticket[] tickets;
    private PaymentGateway[] paymentGateway;

    public TicketManagerImpl(Ticket[] tickets, PaymentGateway[] paymentGateway) {
        this.tickets = tickets;
        this.paymentGateway = paymentGateway;
        ticketCount = 0;
    }

    @Override
    public Ticket generateTicket(User user, Event event) {

        if (paymentGateway[ticketCount].Pay()) {
            String eventId = event.getEventName();
            String userId = user.getUserId();
            String ticketId = eventId + "-" + userId + "-" + Integer.toString(ticketCount);
            tickets[ticketCount] = new Ticket(ticketId, event);
            ticketCount++;
            return tickets[ticketCount - 1];
        } else {
            ticketCount++;
            return null;
        }
    }

    @Override
    public boolean validateTicket(String ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket != null && ticket.getTicketId().equals(ticketId)) {
                ticket.setTicketId("NULL"); //stergere bilet
                return true;
            }
        }
        return false;
    }
}
