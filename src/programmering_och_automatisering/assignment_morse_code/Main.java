package programmering_och_automatisering.assignment_morse_code;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Converter converter = new Converter();

		// English to Morse
		System.out.println("Converting English to Morse Code");
		converter.printValidEnglishCharacters();
		String text = " ";

		while (!text.isEmpty()) {
			System.out.println("Enter text to convert or leave empty to exit.");
			text = scan.nextLine();
			try {
				if (converter.validEnglishCharacter(text)) {
					System.out.println(converter.getMorse(text));
				} // Felhantering: Konverterar endast om användaren skrivit in ett giltigt engelskt tecken enligt listan validEnglishCharacter
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}


		// Morse to English
		System.out.println("Converting Morse Code to English");
		converter.printValidMorseCharacters();
		text = " ";
		while (!text.isEmpty()) {
			System.out.println("Enter text to convert or leave empty to exit.");
			text = scan.nextLine();
			try {
				if (converter.validMorseCharacter(text)) {
					System.out.println(converter.getEnglish(text));
				} // Felhantering: Konverterar endast om användaren skrivit in ett giltigt morsetecken enligt listan validMorseCharacter
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}