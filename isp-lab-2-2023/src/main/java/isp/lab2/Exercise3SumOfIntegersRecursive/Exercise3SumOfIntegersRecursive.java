package isp.lab2.Exercise3SumOfIntegersRecursive;

public class Exercise3SumOfIntegersRecursive {


    /**
     * This method will return the sum of the first n integers
     * @param n
     * @return
     */
    public static int sumOfIntegers(int n) {
        int sum=0;
        if(n!=0)
        sum=sumOfIntegers(n-1);
        return sum+=n;
    }

    public static void main(String[] args) {
        System.out.println(sumOfIntegers(5));

    }
}
