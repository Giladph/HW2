package tree;
import java.util.Scanner;

public class ReversedWords {

    public static int checkReversed() {
        Scanner scanner = new Scanner(System.in);
        Node root = new Node(); // Create the tree
        int count = 0;

        while (true) {
            String word = scanner.nextLine();
            if (word.equals("X")) {
                break; // Exit when "X" is entered
            }

            String reversedWord = reverseString(word); // Reverse the word using substring
            if (root.num(reversedWord) > 0) {
                count++; // If the reversed word is already in the tree, count it
            }

            root.add(word); // Add the word to the tree
        }

        scanner.close();
        return count; // Return the count of words found in reverse
    }

    // Reverses the word using substring (without StringBuilder)
    private static String reverseString(String s) {
        if (s.isEmpty()) {
            return "";
        }
        return reverseString(s.substring(1)) + s.charAt(0); // Recursive call and append the first character
    }
}