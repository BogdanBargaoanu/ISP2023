package aut.isp.lab4.exercise3;


public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder f = new FishFeeder("Feederv1", "PRO", 12);
        AquariumController a = new AquariumController("Large", "AnimPro", 10.30F, 11.30F, f);
        System.out.println(a.toString());
        System.out.println(f.toString());
        a.setCurrentTime(11.30F); //primul feed
        a.setFeedingTime(9.30F);
        a.setCurrentTime(9.29F);
        a.setCurrentTime(9.30F); //al doilea feed
        f.fillUp();
        f.feed();
    }
}
