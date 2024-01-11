package isp.lab6.exercise3;

import java.util.Scanner;

public class UserInterface {
    private LoginSystem loginSystem;
    private OnlineStore store;

    public UserInterface() {
        loginSystem = new LoginSystem();
        store = new OnlineStore();
    }

    public UserInterface(LoginSystem loginSystem, OnlineStore store) {
        this.loginSystem = loginSystem;
        this.store = store;
    }

    public void loadInterface() {
        String username;
        String password;
        String productName;
        int quantity;
        int c;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 ---- Afiseaza produsele");
            System.out.println("2 ---- Inregistrare utilizator");
            System.out.println("3 ---- Logare utilizator");
            System.out.println("4 ---- Delogare utilizator");
            System.out.println("5 ---- Adauga in cos");
            System.out.println("6 ---- Checkout");
            System.out.println("7 ---- Iesire");
            System.out.println("//////////// Introdu selectia: ");
            c = scanner.nextInt();
            switch (c) {
                case 1:
                    for (Product product : store.getProducts()) {
                        System.out.println(product.toString());
                    }
                    break;
                case 2:
                    System.out.println("Introdu numele de utilizator: ");
                    username = scanner.next();
                    System.out.println("Introdu parola: ");
                    password = scanner.next();
                    loginSystem.register(username, password);
                    break;
                case 3:
                    System.out.println("Introdu numele de utilizator: ");
                    username = scanner.next();
                    System.out.println("Introdu parola: ");
                    password = scanner.next();
                    loginSystem.login(username, password);
                    break;
                case 4:
                    System.out.println("Introdu numele de utilizator: ");
                    username = scanner.next();
                    loginSystem.logout(username);
                    break;
                case 5:
                    System.out.println("Introdu numele de utilizator: ");
                    username = scanner.next();
                    System.out.println("Introdu produsul dorit: ");
                    productName = scanner.next();
                    System.out.println("Introdu cantitatea dorita: ");
                    quantity = scanner.nextInt();
                    for (Product p : store.getProducts()) {
                        if (p.name.equals(productName)) {
                            store.addToCart(username, p, quantity);
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Introdu numele de utilizator: ");
                    username = scanner.next();
                    System.out.println(store.checkout(username));
                    break;
                case 7:
                    System.out.println("Iesire din program...");
                    System.exit(0);
                    break;

            }
        }
    }
}
