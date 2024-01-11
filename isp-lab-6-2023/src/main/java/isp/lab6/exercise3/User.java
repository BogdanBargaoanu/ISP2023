package isp.lab6.exercise3;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        boolean b;
        return b = this.hashCode() == user.hashCode();
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
