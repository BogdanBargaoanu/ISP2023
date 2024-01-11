package isp.lab4.exercise4;

public abstract class PaymentGateway {
    private User user;

    public PaymentGateway(User user) {
        this.user = user;
    }

    public abstract boolean Pay();

    public User getUser() {
        return user;
    }
}
