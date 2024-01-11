package isp.lab4.exercise1;

import java.time.LocalDateTime;


public class Customer {
    private String customerId;
    private String name;
    private String phone;
    private Address address;


    public Customer(String customerId, String name, String phone, Address address) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Order placeOrder(Product[] products) {
        String orderId = customerId + 100;
        LocalDateTime now = LocalDateTime.now();
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        Order order = new Order(orderId, now, totalPrice, products);
        return order;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }
}

