package isp.lab4.exercise4;


public class UserAppImpl implements UserApp {

    private Event event;
    private TicketManager ticketManager;
    private User user;

    public UserAppImpl(User user, Event event, TicketManager ticketManager) {
        this.user = user;
        this.event = event;
        this.ticketManager = ticketManager;
    }

    @Override
    public void buyTicket() {
        Ticket ticket = ticketManager.generateTicket(user, event);
        if (ticket == null) {
            System.out.println("Nu s-a putut genera un ticket.");
        } else {
            System.out.println("Ticket generat cu succes, ID-ul este: " + ticket.getTicketId());
        }

    }

    @Override
    public void viewTicket(String ticketId, Ticket[] tickets) {
        boolean exists = false;
        for (Ticket ticket : tickets) {
            if (ticket != null && ticket.getTicketId().equals(ticketId)) {
                System.out.println(ticket.toString());
                exists = true;
                break;

            }
        }
        if (exists == false) {
            System.out.println("Ticketul nu a fost gasit!");
        }
    }
}

