package aut.isp.lab4.exercise6;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals;

    public FishFeeder() {
        meals = 0;
        model = "Necunoscut";
        manufacturer = "Necunoscut";
    }

    public FishFeeder(String manufacturer, String model, int meals) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = meals;
    }

    public void feed() {
        if (meals == 0) {
            System.out.println("FishFeeder-ul este gol!");
        } else {
            meals--;
            System.out.println("S-au hranit pestii din acvariu, noua capacitate a Feederului fiind de " + meals + " mese");
        }
    }

    public void fillUp() {
        if (meals == 14) {
            System.out.println("FishFeeder-ul este deja plin!");
        } else {
            meals = 14;
            System.out.println("S-a umplut FishFeederul.");
        }
    }

    public String toString() {
        return "Producator: " + manufacturer + " model: " + model + " capacitate actuala a Feeder: " + meals;
    }

    public int getMeals() {
        return meals;
    }
}
