package aut.isp.lab4.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        FishFeeder f1 = new FishFeeder("Feederv1", "PRO", 12);
        LightController l1 = new LightController(0.10F, 6.30F);
        AquariumController a1 = new AquariumController("Aqua", "AquaPRO", 10.30F, 20.30F, f1, l1);
        System.out.println(l1.toString());
        a1.setCurrentTime(4.30F); //on
        a1.setCurrentTime(10.30F); //off
        l1.setLightOnTime(10.30F);
        l1.setLightOffTime(15.20F);
        System.out.println(l1.toString());
        a1.setCurrentTime(11.30F);//on
        a1.setCurrentTime(15.21F);//off
    }
}
