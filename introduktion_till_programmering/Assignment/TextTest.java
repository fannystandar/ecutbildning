package Introduktion.Assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextTest {

	@org.junit.jupiter.api.Test
	public void testRowCounter() {
		int expected = 2;
		TextModel counter = new TextModel();

		counter.handleRow("Hej");
		counter.handleRow("Hej");

		assertEquals(expected, counter.getRowCount());
	}

	@org.junit.jupiter.api.Test
	public void testCharacterCount() {
		int expected = 3;
		TextModel counter = new TextModel();

		counter.handleRow("Å C");

		assertEquals(expected, counter.getCharacterCount());
	}

	@org.junit.jupiter.api.Test
	public void testWordCount() {
		int expected = 4;
		TextModel counter = new TextModel();

		counter.handleRow("Hej hej    a     ");
		counter.handleRow("      Abc   ");

		assertEquals(expected, counter.getWordCount());
	}

	@org.junit.jupiter.api.Test
	public void testLongestWord() {
		String expected = "Hippopotomonstrosesquippedaliophobia";
		TextModel counter = new TextModel();

		counter.handleRow("Hej hej    a     ");
		counter.handleRow("      Abc   ");
		counter.handleRow("      Hippopotomonstrosesquippedaliophobia   ");

		assertEquals(expected, counter.getLongestWord());
	}

}
