package isp.lab3.exercise6;

import java.util.Scanner;

public class NewVendingMachine {
    private String[] products = new String[3];
    private static NewVendingMachine instance;
    private int credit;

    private NewVendingMachine() {
        products[0] = "Coca-Cola";
        products[1] = "Pepsi";
        products[2] = "Mars";
        credit = 0;
    }

    public static NewVendingMachine getInstance() {
        if (instance == null) {
            instance = new NewVendingMachine();
        }
        return instance;
    }

    public String displayProducts() {
        String productsInfo = "";
        for (int i = 0; i < products.length; i++) {
            productsInfo += Integer.toString(i + 1) + " - " + products[i] + "\n";
        }
        return productsInfo;
    }

    public void insertCoin(int value) {
        credit += value;
    }

    public String selectProduct(int id) {
        if (id <= products.length) {
            String productName = products[id - 1];
            if (credit >= 100) {
                credit -= 100;
                return "S-a cumparat " + productName;
            } else {
                return "Credit insuficient";
            }
        } else {
            return "Selectie invalida";
        }
    }

    public int displayCredit() {
        System.out.println("Credit: " + credit);
        return credit;
    }

    public void userMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selectia de produse:");
        System.out.println("//Pretul fix setat de 100 monede pentru orice produs//");
        String produse = displayProducts();
        System.out.print(produse);
        System.out.println("Apasa 0 de 2 ori pentru a opri cumpararea");
        int selection = -1;
        while (selection != 0) {
            System.out.print("Introdu monede: ");
            int coin = scanner.nextInt();
            insertCoin(coin);
            displayCredit();
            System.out.print("Introdu selectia produsului: ");
            selection = scanner.nextInt();
            if (selection != 0) {
                System.out.println(selectProduct(selection));
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        NewVendingMachine v1 = NewVendingMachine.getInstance();
        v1.userMenu();
    }
}
