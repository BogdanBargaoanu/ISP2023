package aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder f1 = new FishFeeder();
        f1.feed();
        f1.fillUp();
        System.out.println(f1.toString());
        FishFeeder f2 = new FishFeeder("DD", "Classic", 10);
        System.out.println(f2.toString());
        f2.feed();
    }
}
