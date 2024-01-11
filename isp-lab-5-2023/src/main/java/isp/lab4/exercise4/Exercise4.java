package isp.lab4.exercise4;

import java.time.LocalDateTime;

public class Exercise4 {
    public static void main(String[] args) {
        Ticket[] tickets = new Ticket[5];
        LocalDateTime now = LocalDateTime.now();
        Event event = new Event("UNTOLD", now, 550.0);
        User[] users = new User[5];
        users[0] = new User("Andrei", "02xx", "asd@gmail.com", "001", 600);
        users[1] = new User("Matei", "07xxx", "matei22@gmail.com", "010", 200);
        users[2] = new User("Andreea", "02xx1", "asdfg@gmail.com", "011", 150);
        users[3] = new User("Matias", "07xxxxxx", "matias2001@gmail.com", "100", 20);
        users[4] = new User("Daiana", "07522xx", "beauty-store@gmail.com", "101", 4000);
        PaymentGateway[] paymentGateway = new PaymentGateway[5];
        ///////////////// generarea metodelor de plata
        paymentGateway[0] = new Visa(users[0], event, "VisaMaestro");
        paymentGateway[1] = new Visa(users[1], event, "Avantaj");
        paymentGateway[2] = new MasterCard(users[2], event, "Gold", 12);
        paymentGateway[3] = new MasterCard(users[3], event, "Silver", 6);
        paymentGateway[4] = new Visa(users[4], event, "Platinum");
        TicketManagerImpl tm = new TicketManagerImpl(tickets, paymentGateway);
        Organizer organizer = new Organizer("Mircea", "Gardian", 3000);
        UserAppImpl[] UI = new UserAppImpl[5];
        ///////////////// generarea interfetelor utilizatorilor
        UI[0] = new UserAppImpl(users[0], event, tm);
        UI[1] = new UserAppImpl(users[1], event, tm);
        UI[2] = new UserAppImpl(users[2], event, tm);
        UI[3] = new UserAppImpl(users[3], event, tm);
        UI[4] = new UserAppImpl(users[4], event, tm);
        OrganizerAppImpl Staff = new OrganizerAppImpl(tm, organizer);
        UI[0].buyTicket(); //user 0 cumpara cu Visa //pass
        UI[1].buyTicket(); // user 1 cumpara cu Visa, alt tip de card //fail
        UI[2].buyTicket(); //user 2 cumpara cu MasterCard //pass
        UI[3].buyTicket(); //user 3 cumpara cu MasterCard, alt tip de card //fail
        UI[4].buyTicket(); //user 4 cumpara cu Visa //pass
        //////////////////// vizualizare+incercare id bilete la 3 persoane(pentru a economisi spatiu de afisare)
        System.out.println("----------------------- Verificare bilete pentru:" + users[0].getName());
        for (int i = 0; i < 5; i++) {
            UI[0].viewTicket("UNTOLD-001-" + Integer.toString(i), tickets); //are bilet -> primul bilet creat
        }
        System.out.println("----------------------- Verificare bilete pentru: " + users[3].getName());
        for (int i = 0; i < 5; i++) {
            UI[3].viewTicket("UNTOLD-100-" + Integer.toString(i), tickets); //nu are bilet ->toate biletele create sunt incercari esuate
        }
        System.out.println("----------------------- Verificare bilete pentru: " + users[2].getName());
        for (int i = 0; i < 5; i++) {
            UI[2].viewTicket("UNTOLD-011-" + Integer.toString(i), tickets); //are bilet -> al treilea bilet creat
        }
        //////////////////// testare checkIn facut de organizator
        System.out.println("----------------------- CheckIn bilete");
        Staff.CheckIn("UNTOLD-001-0"); //pass users[0]
        Staff.CheckIn("UNTOLD-010-1"); //fail user[1]
        Staff.CheckIn("UNTOLD-011-2"); //pass user[2]
        Staff.CheckIn("UNTOLD-100-3");
        Staff.CheckIn("UNTOLD-101-4");
        //////////////////// verificare functionalitate CheckIn-> toate biletele ar trebui sa fie nule dupa check in
        System.out.println("-----------------------Verificare proprietate de unicitate a biletelor dupa check in:");
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] != null) {
                System.out.println("Bilet actual pentru: " + users[i].getName() + " --> " + tickets[i].getTicketId());

            }
        }

    }
}
