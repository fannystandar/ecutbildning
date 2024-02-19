package programmering_och_automatisering.assignment_morse_code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {
	//Skriv ett program som gör om morsekod till engelska och engelska till morsekod

	//Skriv programmet med minst en logikklass samt en klass som läser in text och skriver ut text (med en main-metod)
	//Använd den internationella morsekoden (se slide 5)

	//Utveckla programmet i TDD och skriv minst 3 JUnit-testfall

	//Skapa minst två felhanteringar i systemet som fångar två saker som användaren kan göra som går utanför det vanliga användandet av systemet
	@Test
	public void testEToDot() {
		Converter converter = new Converter();

		String testdata = "E";
		String actual = converter.getMorse(testdata);
		String expected = ".";

		assertEquals(expected, actual);
	}
	@Test
	public void testTToDash() {
		Converter converter = new Converter();

		String testdata = "T";
		String actual = converter.getMorse(testdata);
		String expected = "-";

		assertEquals(expected, actual);
	}
	@Test
	public void testOToDashes() {
		Converter converter = new Converter();

		String testdata = "O";
		String actual = converter.getMorse(testdata);
		String expected = "---";

		assertEquals(expected, actual);
	}
	@Test
	public void testDotToE() {
		Converter converter = new Converter();

		String testdata = ".";
		String actual = converter.getEnglish(testdata);
		String expected = "E";

		assertEquals(expected, actual);
	}
	@Test
	public void testDashesToO() {
		Converter converter = new Converter();

		String testdata = "---";
		String actual = converter.getEnglish(testdata);
		String expected = "O";

		assertEquals(expected, actual);
	}
	@Test
	public void testDashToT() {
		Converter converter = new Converter();

		String testdata = "-";
		String actual = converter.getEnglish(testdata);
		String expected = "T";

		assertEquals(expected, actual);
	}
	@Test
	public void testNumberToMorse() {
		Converter converter = new Converter();

		String testdata = "1";
		String actual = converter.getMorse(testdata);
		String expected = ".----";

		assertEquals(expected, actual);
	}
	@Test
	public void testMorseToNumber() {
		Converter converter = new Converter();

		String testdata = "...--";
		String actual = converter.getEnglish(testdata);
		String expected = "3";

		assertEquals(expected, actual);
	}
}
