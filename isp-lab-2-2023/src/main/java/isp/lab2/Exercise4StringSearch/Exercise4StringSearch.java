package isp.lab2.Exercise4StringSearch;

import java.util.Scanner;

public class Exercise4StringSearch {
    /**
     * This method should return an array of strings that contain the substring.
     *
     * @param input
     * @param substring what to search for
     * @return
     */
    public static String[] searchSubstrings(String input, String substring) {
        String[] splited = input.split(",");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < splited.length; i++) {
            if (splited[i].contains(substring)) {
                result.append(splited[i]);
            }
        }
        return new String[]{result.toString()};
    }

    public static String readFromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter line: ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        String input = "apples,computer,bread,tea,car";
        String substring = "te";
        String[] result = searchSubstrings(input, substring);
        for (String string : result) {
            System.out.println(string);
        }
    }
}
