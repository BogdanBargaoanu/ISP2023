package isp.lab4.exercise4;

public class Visa extends PaymentGateway {
    private String tipCard;
    private Event event;

    public Visa(User user, Event event, String tipCard) {
        super(user);
        this.tipCard = tipCard;
        this.event = event;
    }

    @Override
    public boolean Pay() {
        double toPay = event.getPrice();
        double paid = this.getUser().getBalance();
        System.out.println("Se proceseaza plata....");
        if (paid >= toPay) {
            System.out.println("Plata a fost acceptata! Card procesat: " + tipCard);
            this.getUser().setBalance(this.getUser().getBalance() - event.getPrice());
            System.out.println("Suma ramasa in cont: " + this.getUser().getBalance());
            return true;
        } else {
            System.out.println("Fonduri insuficiente! Card procesat: " + tipCard);
            return false;
        }
    }
}
