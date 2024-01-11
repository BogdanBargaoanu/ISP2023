package aut.isp.lab4.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        AquariumController a1 = new AquariumController();
        a1.setCurrentTime(10.30F);
        System.out.println(a1.toString());
        AquariumController a2 = new AquariumController("FishTank", "AquaInd", 11.50F);
        System.out.println(a2.toString());
    }
}
