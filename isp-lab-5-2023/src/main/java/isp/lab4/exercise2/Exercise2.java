package isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Laptop l = new Laptop(30);
        SmartPhone sp = new SmartPhone(25);
        SmartWatch sw = new SmartWatch(50);
        System.out.println("Baterie laptop: " + l.getBatteryLevel() + "%");
        System.out.println("Baterie smartphone: " + sp.getBatteryLevel() + "%");
        System.out.println("Baterie smartwatch: " + sw.getBatteryLevel() + "%\n");
        /////////////
        l.charge(17); //3*17 + 30
        System.out.println("Baterie laptop: " + l.getBatteryLevel() + "%");
        l.charge(3); //3*1 + 81
        System.out.println("Baterie laptop: " + l.getBatteryLevel() + "%");
        l.charge(20); //20*1+84 ----100
        System.out.println("");
        /////////////
        sp.charge(30); //2*30 + 25
        System.out.println("Baterie smartphone: " + sp.getBatteryLevel() + "%");
        sp.charge(4); //3*0.5 + 85
        System.out.println("Baterie smartphone: " + sp.getBatteryLevel() + "%");
        sp.charge(30); //30*0.5 + 87 ----100
        System.out.println("");
        /////////////
        sw.charge(32); //32*1 + 50
        System.out.println("Baterie smartwatch: " + sw.getBatteryLevel() + "%");
        sw.charge(12); //12*0.25 + 82
        System.out.println("Baterie smartwatch: " + sw.getBatteryLevel() + "%");
        sw.charge(30); //30*0.25 + 85 ----92.5 (int) -> 92
        System.out.println("");
        sw.charge(40); //40*0.25 + 92 ----100
    }

}
