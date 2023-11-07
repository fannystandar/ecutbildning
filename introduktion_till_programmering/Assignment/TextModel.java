package Introduktion.Assignment;

public class TextModel {

	// Håller reda på antalet behandlade rader (förutom när order "stop" hanteras)
	private int rowCount = 0;
	// Antalet tecken som behandlats
	private int characterCount = 0;
	// Antalet ord som behandlats
	private int wordCount = 0;
	// Längsta ordet som behandlats
	private String longestWord = "";

	// Retunerar true om ord behandlas och false om ord ej behandlas
	public boolean handleRow(String row) {
		// Om ordet "stop" skickas in så behandlar vi inte ordet
		if (row.equalsIgnoreCase("stop"))
			return false;

		rowCount++; // Öka rowCount med 1
		characterCount += row.length(); // Lägg till längden av String row (antalet tecken) till characterCount

		String[] splitWords = row.trim().split("\\s+"); // Gör en array genm att splitta upp och spara varje ord från användarens input
		wordCount += splitWords.length; // Lägg till antalet ord från vår splitWords-array till wordCount

		for (String word : splitWords) { // Gå igenom alla ord i arryen splitWords
			// Spara undan ord om det är det länsta hittills
			if (word.length() > longestWord.length())
				longestWord = word;
		}

		// Ord har behandlats, skicka tillbaka true
		return true;
	}

	public int getWordCount() {
		return wordCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getCharacterCount() {
		return characterCount;
	}

	public String getLongestWord() {
		return longestWord;
	}

}
