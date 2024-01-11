package isp.lab6.exercise3;

import java.util.*;

public class Exercise3 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Set<User> users = new HashSet<>();
        Map<String, ActiveSession> activeSessions = new HashMap<>();
        Product[] prod = new Product[4];
        prod[0] = new Product("PlacaVideo", 2000);
        prod[1] = new Product("Feon", 300);
        prod[2] = new Product("Skateboard", 500);
        prod[3] = new Product("Tricou", 100);
        for (Product p : prod) {
            products.add(p);
        }
        OnlineStore onlineStore = new OnlineStore(products, activeSessions);
        LoginSystem loginSystem = new LoginSystem(users, onlineStore);
        UserInterface userInterface = new UserInterface(loginSystem, onlineStore);
        userInterface.loadInterface();

    }
}
