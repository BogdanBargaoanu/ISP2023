package isp.lab6.exercise3;

import java.util.HashSet;
import java.util.Set;

public class LoginSystem {
    private Set<User> users;
    private OnlineStore store;

    public LoginSystem() {
        users = new HashSet<>();
        store = new OnlineStore();
    }

    public LoginSystem(Set<User> users, OnlineStore store) {
        this.users = users;
        this.store = store;
    }

    public void register(String username, String password) {
        User user = new User(username, password);
        boolean exista = false;
        for (User u : users) {
            if (u.equals(user)) {
                exista = true;
                System.out.println("User-ul este deja existent.");
                break;
            }
        }
        if (!exista) {
            users.add(user);
            System.out.println("User adaugat cu succes.");
        }
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("User-ul " + username + " logat cu succes.");
                store.addSession(username);
                return true;
            }
        }
        System.out.println("Username sau parola gresita.");
        return false;
    }


    public boolean logout(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                System.out.println("User " + username + " delogat cu succes.");
            store.removeSession(username);
            return true;
        }
        System.out.println("User-ul nu exista pentru a fi delogat.");
        return false;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setStore(OnlineStore store) {
        this.store = store;
    }
}
