package isp.lab4.exercise4;

public class OrganizerAppImpl implements OrganizerApp {
    private Organizer organizer;
    private TicketManagerImpl ticketManager;

    public OrganizerAppImpl(TicketManagerImpl ticketManager, Organizer organizer) {
        this.ticketManager = ticketManager;
        this.organizer = organizer;
    }

    @Override
    public void CheckIn(String ticketId) {
        if (ticketManager.validateTicket(ticketId)) {
            System.out.println("----- Ticket valid ------  Validator:" + organizer.toString());
        } else {
            System.out.println("----- Ticket invalid ------  Validator: " + organizer.toString());
        }
    }
}

