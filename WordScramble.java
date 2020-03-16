import java.util.Scanner;
/*
 * Author:		Tyler Blanchard
 * Date:		12/1/2017
 * 
 * Description:		This program scrambles the words 'ilovecps180' 'Java' 
 * 					'Eclipse' 'fireupchips!' 'safebreak' and has the user
 * 					unscrambles them. Also counts how many the user
 * 					successfully unscrambled.
 */
public class WordScramble {

	public static void main(String[] args) {
		final int NUMBER_OF_WORDS = 5;
		String [] scrambledWord = new String[NUMBER_OF_WORDS];
		String [] correctWord = new String[NUMBER_OF_WORDS];
		String userGuess = "";
		int correctGuesses = 0;
		int numberOfLetters = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		correctWord[0] = "ilovecps180";
		correctWord[1] = "Java";
		correctWord[2] = "Eclipse";
		correctWord[3] = "fireupchips!";
		correctWord[4] = "safebreak";
		
		// Step 1: Scramble the words
		for (int i = 0; i < NUMBER_OF_WORDS; i++) {
			scrambledWord[i] = rotateOrder(correctWord[i]);
			scrambledWord[i] = reverseString(scrambledWord[i]);
		}
		
		// Step 2: Get guesses from the user
		for (int i = 0; i < NUMBER_OF_WORDS; i++) {
			numberOfLetters = scrambledWord[i].length();
			System.out.print("Unscramble '" + scrambledWord[i] + "' (");
			System.out.print(numberOfLetters + " letters): ");
			userGuess = scanner.nextLine();
			if (userGuess.equals(correctWord[i])) {
				correctGuesses++;
			}
		}
		
		// Step 3: Display output
		System.out.println("");
		System.out.print("The correct answers are: 'ilovecps180' 'Java' ");
		System.out.println("'fireupchips!' 'safebreak'");
		System.out.print("You successfully unscrambled " + correctGuesses);
		System.out.println(" word(s). Great!");
		
	}
	
	/*****************************************************************************************************
	 * rotateOrder - Encodes a string by rotating it until the last character becomes the first character
	 *   of the string and every other character is shifted one position to the right.
	 * 
	 * String originalWord - Input string from the array.
	 * return rotatedWord - The encoded string in which the last character of the input string has been
	 *   wrapped around to become the first character.
	 */
	public static String rotateOrder(String originalWord) {
		String rotatedWord = originalWord;
		if (originalWord.length() >= 2) {
			rotatedWord = originalWord.charAt(originalWord.length() - 1) + 
					originalWord.substring(0, originalWord.length() - 1);
		}
		
		return rotatedWord;
	}
	
	/*****************************************************************************************************
	 * reverseString - Reverse the order of the characters in a string.
	 *
	 * String originalWord - input String from the array.
	 * return reversedWord - The input string in reverse.
	 */
	public static String reverseString(String originalWord) {
		String reversedWord = "";
		for (int i = 0; i < originalWord.length(); i++) {
			reversedWord += originalWord.charAt(originalWord.length() - 1 - i);
		}
		
		return reversedWord;
	}

}
