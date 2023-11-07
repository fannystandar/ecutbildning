package Introduktion.Assignment;

import java.util.Scanner;

public class TextController {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TextModel counter = new TextModel();
		System.out.println("Skriv din text. För att avsluta, skriv \"stop\".");
		while (counter.handleRow(scan.nextLine())) {}  // OM false returneras hoppar vi ur while-loopen

		// Skriv ut resultaten
		System.out.println("Number of rows: " + counter.getRowCount());
		System.out.println("Number of characters: " + counter.getCharacterCount());
		System.out.println("Number of words: " + counter.getWordCount());
		System.out.println("Longest word: " + counter.getLongestWord());
	}

}
