package tree;

import java.util.Scanner;

public class ReversedWords {

	// reads words from user until "X", counts how many are reverse of a previous one
	public static int checkReversed() {
		Node root = new Node();
		int countString = 0;
		Scanner scanner = new Scanner(System.in);
		String checkInput = scanner.next();

		while (!checkInput.equals("X")) {
			if (!checkInput.equals(" ") && !checkInput.equals("")) {
				String reverseWord = reverseString(checkInput);

				if (root.num(checkInput) == 0) {
					root.add(reverseWord);
				} else {
					countString++;
				}
			}
			checkInput = scanner.next();
		}

		scanner.close();
		return countString;
	}

	// returns the reversed version of the input string
	private static String reverseString(String checkInput) {
		StringBuilder reverseStringBuilder = new StringBuilder();
		for (int i = checkInput.length() - 1; i >= 0; i--)
			reverseStringBuilder.append(checkInput.charAt(i));
		return reverseStringBuilder.toString();
	}
}
