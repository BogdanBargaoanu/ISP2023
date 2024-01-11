package isp.lab4.exercise1;

import java.time.LocalDateTime;

public class Order {
    private String orderId;
    private LocalDateTime date;
    private double totalPrice;
    private Product[] products;

    // Constructor
    public Order(String orderId, LocalDateTime date, double totalPrice, Product[] products) {
        this.orderId = orderId;
        this.date = date;
        this.totalPrice = totalPrice;
        this.products = products;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public LocalDateTime getDate() {
        return date.withNano(0);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Product[] getProducts() {
        return products;
    }
}
