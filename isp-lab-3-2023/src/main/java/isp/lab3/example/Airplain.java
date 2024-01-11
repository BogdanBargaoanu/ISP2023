package isp.lab3.example;

import java.time.LocalDateTime;

public class Airplain {
    private String model;
    private int capacity;
    private double maxSpeed;
    private double range;
    private int passengers;

    private LocalDateTime departureDateTime;

    public Airplain(String model, int capacity, double maxSpeed, double range, LocalDateTime departureDateTime) {
        this.model = model;
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
        this.range = range;
        this.passengers = 0;
        this.departureDateTime = departureDateTime;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getRange() {
        return range;
    }

    public int getPassengers() {
        return passengers;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void loadPassengers(int numPassengers) {
        int availableSeats = capacity - passengers;
        if (numPassengers <= availableSeats) {
            passengers += numPassengers;
            System.out.println(numPassengers + " passengers have been loaded onto the airplane.");
        } else {
            System.out.println("There are only " + availableSeats + " seats available on the airplane.");
        }
    }

    public boolean isLate() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(departureDateTime);
    }

    @Override
    public String toString() {
        return "Airplaine{" +
                "model='" + model + '\'' +
                ", capacity=" + capacity +
                ", maxSpeed=" + maxSpeed +
                ", range=" + range +
                ", passengers=" + passengers +
                '}';
    }

    public static void main(String[] args) {
        LocalDateTime date1 = LocalDateTime.of(2023, 3, 15, 9, 30); // March 15, 2023 at 9:30 AM
        Airplain airplaine1 = new Airplain("Boeing 737", 150, 800, 5000, date1);

        LocalDateTime date2 = LocalDateTime.now();
        Airplain airplaine2 = new Airplain("Airbus A320", 180, 850, 6000, date2);

        LocalDateTime date3 = LocalDateTime.parse("2023-03-15T09:30:00");
        Airplain airplaine3 = new Airplain("Boeing 747", 400, 900, 7000, date3);

        airplaine1.loadPassengers(50);
        airplaine2.loadPassengers(100);
        airplaine3.loadPassengers(50);

        System.out.println(airplaine1);
        System.out.println(airplaine2);
        System.out.println(airplaine3);
    }
}
