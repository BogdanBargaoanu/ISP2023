package isp.lab3.exercise4;

public class MyPoint {
    private int x;
    private int y;
    private int z;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public MyPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public double distance(int x, int y, int z) {
        int xDif = this.x - x;
        int yDif = this.y - y;
        int zDif = this.z - z;
        return Math.sqrt(xDif * xDif + yDif * yDif + zDif * zDif);
    }

    public double distance(MyPoint another) {
        return distance(another.x, another.y, another.z);
    }
    public static void main(String[] args) {
        MyPoint punct1 = new MyPoint(1, 2, 3);
        MyPoint punct2 = new MyPoint(10, 11, 12);

        System.out.println("Punct 1: " + punct1.toString());
        System.out.println("Punct 2: " + punct2.toString());

        double distance = punct1.distance(punct2);
        System.out.println("Distanta dintre cele doua puncte: " + distance);
    }
}
