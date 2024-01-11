package isp.lab3.exercise2;

public class Rectangle {
    private int length;
    private int width;
    private String color;

    public Rectangle() {
        length = 2;
        width = 1;
        color = "red";
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
        color = "red";
    }

    public Rectangle(int length, int width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public int getPerimeter() {
        return 2 * (length + width);
    }

    public int getArea() {
        return length * width;
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle();
        System.out.println("Rectangle 1:");
        System.out.println("Lungime: " + rectangle1.getLength());
        System.out.println("Latime: " + rectangle1.getWidth());
        System.out.println("Culoare: " + rectangle1.getColor());
        System.out.println("Perimetru: " + rectangle1.getPerimeter());
        System.out.println("Arie: " + rectangle1.getArea());

        Rectangle rectangle2 = new Rectangle(5, 3);
        System.out.println("Rectangle 2:");
        System.out.println("Lungime: " + rectangle2.getLength());
        System.out.println("Latime: " + rectangle2.getWidth());
        System.out.println("Culoare: " + rectangle2.getColor());
        System.out.println("Perimetru: " + rectangle2.getPerimeter());
        System.out.println("Arie: " + rectangle2.getArea());

        Rectangle rectangle3 = new Rectangle(4, 6, "albastru");
        System.out.println("Rectangle 3:");
        System.out.println("Lungime: " + rectangle3.getLength());
        System.out.println("Latime: " + rectangle3.getWidth());
        System.out.println("Culoare: " + rectangle3.getColor());
        System.out.println("Perimetru: " + rectangle3.getPerimeter());
        System.out.println("Arie: " + rectangle3.getArea());
    }
}
