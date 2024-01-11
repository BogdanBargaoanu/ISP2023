package isp.lab2.Exercise6WordGuess;

import java.util.*;

public class Exercise6WordGuess {

    /**
     * This method will return the number of occurrences of a character in a word
     *
     * @param c
     * @param word
     * @return
     */
    public static int countOccurence(char c, char[] word) {
        int count = 0;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == c) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "orange", "pear", "pineapple"};
        Random rand = new Random();
        String word = words[rand.nextInt(words.length)];
        int numTries = 0;

        char[] guessedWord = new char[word.length()];
        Arrays.fill(guessedWord, '_');

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Cuvant: " + new String(guessedWord));

            System.out.print("Ghiceste litera:  ");
            char guess = scanner.nextLine().charAt(0);

            int count = countOccurence(guess, word.toCharArray());
            if (count > 0) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
                System.out.println("Corect! Litera " + guess + " apare de " + count + " ori.");
            } else {
                System.out.println("Incorect. Litera " + guess + " nu este in cuvant.");
            }
            numTries++;
            if (new String(guessedWord).equals(word)) {
                System.out.println("Cuvantul este: " + word + ".");
                System.out.println("Numar incercari: " + numTries);
                break;
            }
        }
    }

}
