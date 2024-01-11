package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.Map;

public class ActiveSession {
    private String username;
    private Map<String, Integer> shoppingCart;

    public ActiveSession(String username) {
        this.username = username;
        this.shoppingCart = new HashMap<>();

    }

    public void addToCart(Product product, int quantity) {
        if (shoppingCart.containsKey(product.name)) {
            int currentQuantity = shoppingCart.get(product.name);
            shoppingCart.put(product.name, currentQuantity + quantity);
        } else {
            shoppingCart.put(product.name, quantity);
        }

    }

    public String getUsername() {
        return username;
    }
}
