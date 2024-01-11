package isp.lab4.exercise4;

public class User {
    private String name;
    private String phoneNumber;
    private String email;
    private String userId;
    private double balance;

    public User(String name, String phoneNumber, String email, String userId, double balance) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userId = userId;
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
