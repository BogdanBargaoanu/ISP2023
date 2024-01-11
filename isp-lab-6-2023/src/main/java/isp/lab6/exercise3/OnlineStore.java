package isp.lab6.exercise3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlineStore {
    private List<Product> products;
    private Map<String, ActiveSession> sessions;

    public OnlineStore() {
        sessions = new HashMap<>();
        products = new ArrayList<>();
    }

    public OnlineStore(List<Product> products, Map<String, ActiveSession> sessions) {
        this.products = products;
        this.sessions = sessions;
    }

    public List<Product> getProducts() {
        return products;
    }

    void addSession(String username) {
        if (sessions.containsKey(username)) {
            System.out.println("User-ul " + username + " este deja logat.");
        } else {
            ActiveSession activeSession = new ActiveSession(username);
            sessions.put(username, activeSession);
        }
    }

    void removeSession(String username) {
        if (sessions.containsKey(username)) {
            sessions.remove(username);
        } else {
            System.out.println("User-ul nu exista.");
        }
    }

    public void addToCart(String username, Product product, int quantity) {
        if (sessions.containsKey(username)) {
            ActiveSession activeSession = sessions.get(username);
            activeSession.addToCart(product, quantity);
            System.out.println("S-a adaugat cu succes " + product.name + " in numar de " + quantity);
        } else {
            System.out.println("Username-ul nu exista.");
        }
    }

    public String checkout(String username) {
        if (sessions.containsKey(username)) {
            return "User-ul: " + username + " a finalizat comanda.";
        } else {
            return "Username-ul nu exista.";
        }

    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setSessions(Map<String, ActiveSession> sessions) {
        this.sessions = sessions;
    }
}
