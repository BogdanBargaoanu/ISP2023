package isp.lab2.Exercise5EvenOddSearch;

public class Exercise5EvenOddSearch {

    public static int[] findEvenOdd(String input) {
        int[] evenodd = new int[4];
        evenodd[0] = 0; //max
        evenodd[2] = 9999; //min
        String[] splited = input.split(",");
        int element;
        for (int i = 0; i < splited.length; i++) {
            element = Integer.parseInt(splited[i]);
            if (element % 2 == 0 && element > evenodd[0]) {
                evenodd[0] = element;
                evenodd[1] = i; //poz maxim
            } else if (element % 2 != 0 && element < evenodd[2]) {
                evenodd[2] = element;
                evenodd[3] = i; //poz minim
            }
        }
        return evenodd;
    }

    public static void main(String[] args) {
        String input = "1,2,3,4,5,6,7,8,9,10";
        int[] result = findEvenOdd(input);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
