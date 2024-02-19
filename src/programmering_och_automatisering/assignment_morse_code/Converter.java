package programmering_och_automatisering.assignment_morse_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Converter {
	//Skriv ett program som gör om morsekod till engelska och engelska till morsekod

	//Skriv programmet med minst en logikklass samt en klass som läser in text och skriver ut text (med en main-metod)

	//Utveckla programmet i TDD och skriv minst 3 JUnit-testfall

	//Skapa minst två felhanteringar i systemet som fångar två saker som användaren kan göra som går utanför det vanliga användandet av systemet
	private HashMap<String, String> englishToMorseMap;
	private HashMap<String, String> morseToEnglishMap;
	private List<String> validEnglishCharacters;
	private List<String> validMorseCharacters;
	public Converter() {
		englishToMorseMap = new HashMap<>(); // HashMap med engelska tecken som key och morse som value
		englishToMorseMap.put("A", ".-");
		englishToMorseMap.put("B", "-...");
		englishToMorseMap.put("C", "-.-.");
		englishToMorseMap.put("D", "-..");
		englishToMorseMap.put("E", ".");
		englishToMorseMap.put("F", "..-.");
		englishToMorseMap.put("G", "--.");
		englishToMorseMap.put("H", "....");
		englishToMorseMap.put("I", "..");
		englishToMorseMap.put("J", ".---");
		englishToMorseMap.put("K", "-.-");
		englishToMorseMap.put("L", ".-..");
		englishToMorseMap.put("M", "--");
		englishToMorseMap.put("N", "-.");
		englishToMorseMap.put("O", "---");
		englishToMorseMap.put("P", ".--.");
		englishToMorseMap.put("Q", "--.-");
		englishToMorseMap.put("R", ".-.");
		englishToMorseMap.put("S", "...");
		englishToMorseMap.put("T", "-");
		englishToMorseMap.put("U", "..-");
		englishToMorseMap.put("V", "...-");
		englishToMorseMap.put("W", ".--");
		englishToMorseMap.put("X", "-..-");
		englishToMorseMap.put("Y", "-.--");
		englishToMorseMap.put("Z", "--..");

		englishToMorseMap.put("0", "-----");
		englishToMorseMap.put("1", ".----");
		englishToMorseMap.put("2", "..---");
		englishToMorseMap.put("3", "...--");
		englishToMorseMap.put("4", "....-");
		englishToMorseMap.put("5", ".....");
		englishToMorseMap.put("6", "-....");
		englishToMorseMap.put("7", "--...");
		englishToMorseMap.put("8", "---..");
		englishToMorseMap.put("9", "----.");

		englishToMorseMap.put(",", "--..--");
		englishToMorseMap.put(".", ".-.-.-");
		englishToMorseMap.put("?", "..--..");
		englishToMorseMap.put(" ", "/"); // Hantering av mellanslag
		englishToMorseMap.put("", ""); // Hantering av enterslag

		morseToEnglishMap = new HashMap<>(); // HashMap med morse som key och engelska tecken som value
		for (HashMap.Entry<String, String> entry : englishToMorseMap.entrySet()) {
			morseToEnglishMap.put(entry.getValue(), entry.getKey());
		}
		validEnglishCharacters = new ArrayList<>(englishToMorseMap.keySet()); // Gör en lista av alla keys i englishToMorseMap
		validMorseCharacters = new ArrayList<>(morseToEnglishMap.keySet());
	}
	public String getMorse(String english) {
		String morse = "";
		english = english.toUpperCase();
		// Felhantering: Konverterar det användaren skrivit in till uppercase (eftersom att alla bokstäver i HashMaps sparats som uppercase)

		String[] englishCharacters = english.split("");
		for (int i = 0; i < englishCharacters.length; i++){
			morse += englishToMorseMap.get(englishCharacters[i]);
			morse += " "; // Lägg till ett mellanslag mellan varje morsekod-bokstav för lättläslighet
		}
		return morse.trim(); // Felhantering: Tar bort det sista mellanslaget (trailing space) som sparats i morse
	}
	public String getEnglish(String morse) {
		String english = "";
		String[] morseWords = morse.split(" ");

		for (String morseWord : morseWords) {
			for (HashMap.Entry<String, String> entry : morseToEnglishMap.entrySet()) {
				if (entry.getKey().equals(morseWord)) {
					english += entry.getValue() + " ";
				}
			}
		}
		return english.trim(); // Felhantering: Tar bort det sista mellanslaget (trailing space) som sparats i english
	}
	public boolean validMorseCharacter(String text) throws Exception {
		for (char c : text.toCharArray()) {
			if (c == ' ') {
				continue;
			} // Fortsätt om nästa char i String text är ett mellanslag
				String morseCharacter = String.valueOf(c);
				if (!morseToEnglishMap.containsKey(morseCharacter)) {
					throw new Exception("Invalid Morse Character: " + morseCharacter);
				}
		}
		return true;
	}
	public boolean validEnglishCharacter(String text) throws Exception {
		for (char c : text.toUpperCase().toCharArray()){
			// Felhantering: Konverterar det användaren skrivit in till uppercase (eftersom att alla bokstäver i HashMaps är sparade som uppercase)
			String englishCharacter = String.valueOf(c);
			if (!englishToMorseMap.containsKey(englishCharacter)) {
				throw new Exception("Invalid English Character: " + englishCharacter);
			}
		}
		return true;
	}
	public void printValidEnglishCharacters(){
		System.out.println("Valid English Characters:" + String.join(" ", validEnglishCharacters));
	}
	public void printValidMorseCharacters(){
		System.out.println("Valid Morse Characters: " + String.join(" ", validMorseCharacters));
	}
}
