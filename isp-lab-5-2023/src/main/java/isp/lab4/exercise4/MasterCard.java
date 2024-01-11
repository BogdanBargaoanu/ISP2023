package isp.lab4.exercise4;

import java.util.Scanner;

public class MasterCard extends PaymentGateway {
    private String tipCard;
    private Event event;
    private int rate;

    public MasterCard(User user, Event event, String tipCard, int rate) {
        super(user);
        this.tipCard = tipCard;
        this.event = event;
        this.rate = rate;
    }

    @Override
    public boolean Pay() { //mastercard se va lua pentru plati in rate
        double toPay = event.getPrice();
        double paid = this.getUser().getBalance();
        System.out.println("Se proceseaza plata....");
        if (paid >= toPay / rate) {
            System.out.println("Plata a fost acceptata! Card procesat: " + tipCard);
            this.getUser().setBalance(this.getUser().getBalance() - event.getPrice() / rate);
            System.out.println("Suma ramasa in cont: " + this.getUser().getBalance());
            return true;
        } else {
            System.out.println("Fonduri insuficiente! Card procesat: " + tipCard);
            return false;
        }
    }
}
