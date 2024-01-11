package isp.lab4.exercise4;

public class Organizer {
    private String nume;
    private String rol;
    private double salariu;

    public Organizer(String nume, String rol, double salariu) {
        this.nume = nume;
        this.rol = rol;
        this.salariu = salariu;
    }

    public double getSalariu() {
        return salariu;
    }

    public String getNume() {
        return nume;
    }

    public String getRol() {
        return rol;
    }

    public String toString() {
        return "Responsabil staff: " + nume + " cu rolul: " + rol;
    }
}
