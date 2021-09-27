
import java.util.Scanner;

public class Assignment1 {

	static final int MIN_NUMBER = 1;
	static final int MAX_NUMBER = 1000;
	static final String MESSAGE_INPUT = "Please input a positive integer between " + MIN_NUMBER + " and " + MAX_NUMBER
			+ ": ";

	/**
	 * Print error message when the input value is not an integer.
	 */
	private static void printMessageNotInteger(String value) {
		System.out.println("The input value \"" + value + "\" is not an integer.");
		System.out.print(MESSAGE_INPUT);
	}

	/**
	 * Print error message when the input value is less than the minimal boundary.
	 */
	private static void printMessageLessThanMin(int num) {
		System.out.println("The input value \"" + num + "\" is less than " + MIN_NUMBER + ".");
		System.out.print(MESSAGE_INPUT);
	}

	/**
	 * Print error message when the input value is greater than the maximal
	 * boundary.
	 */
	private static void printMessageGreaterThanMax(int num) {
		System.out.println("The input value \"" + num + "\" is greater than " + MAX_NUMBER + ".");
		System.out.print(MESSAGE_INPUT);
	}

	/**
	 * Print message when the input value is too low.
	 */
	private static void printMessageTooLow(int num, int turns) {
		System.out.println("Turn " + turns + ": The input value \"" + num + "\" is too low!");
		System.out.print(MESSAGE_INPUT);
	}

	/**
	 * Print message when the input value is too high.
	 */
	private static void printMessageTooHigh(int num, int turns) {
		System.out.println("Turn " + turns + ": The input value \"" + num + "\" is too high!");
		System.out.print(MESSAGE_INPUT);
	}

	/**
	 * Print message when the input value is the answer.
	 */
	private static void printMessageBingo(int num, int turns) {
		System.out.println("Bingo! The answer is \"" + num + "\". You took " + turns + " turns!");
	}

	/**
	 * A game to guess number.
	 */
	public static void main(String[] args) {

		// A random number.
		int answer = ((int) (Math.random() * MAX_NUMBER) + MIN_NUMBER);

		System.out.print(MESSAGE_INPUT);

		// Default values.
		int turns = 0;
		int guess = -1;
		Scanner scanner = new Scanner(System.in);

		do { // Get input value repeatedly.

			if (!scanner.hasNextInt()) { // The input value is not an integer.
				System.out.println();
				printMessageNotInteger(scanner.next());
				continue;
			}

			System.out.println();
			guess = scanner.nextInt();

			if (guess < MIN_NUMBER) { // The input value is less than minimal boundary.
				printMessageLessThanMin(guess);
				continue;
			}

			if (guess > MAX_NUMBER) { // The input value is greater than maximal boundary.
				printMessageGreaterThanMax(guess);
				continue;
			}

			// Increase the number of turns.
			turns++;

			if (guess < answer) { // The input value is less than the answer.
				printMessageTooLow(guess, turns);

			} else if (guess > answer) { // The input value is greater than the answer.
				printMessageTooHigh(guess, turns);

			} else { // The input value is the answer.
				printMessageBingo(guess, turns);
			}

		} while (guess != answer); // Repeat when the guess is incorrect.

		scanner.close();
	}
}
