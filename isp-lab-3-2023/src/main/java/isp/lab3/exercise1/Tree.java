package isp.lab3.exercise1;

public class Tree {
    public int height;

    public Tree() {
        height = 15;
    }

    public void grow(int meters) {
        if (meters >= 1) {
            height += meters;
        }
    }

    public String toString() {
        return "Inaltimea copacului este de " + height + " metri";
    }

    public static void main(String[] args) {
        Tree copac1 = new Tree();
        String afis1 = copac1.toString();
        System.out.println(afis1); //15
        copac1.grow(10);
        afis1 = copac1.toString();
        System.out.println(afis1); //25
        copac1.height = 19;
        afis1 = copac1.toString();
        System.out.println(afis1); //19
    }
}