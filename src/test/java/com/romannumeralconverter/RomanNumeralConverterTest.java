package com.romannumeralconverter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RomanNumeralConverterTest {

	RomanNumeralConverter romanNumeralConverter;

	@Before
	public void setUp() throws Exception 
	{
		romanNumeralConverter = new RomanNumeralConverter();
	}
	
	@Test
	public void ifValueOfIsPassedAnIReturn1() {
		assertEquals(1, romanNumeralConverter.valueOf("I"));
	}
	
	@Test
	public void ifValueOfMethodIsPassedAnyRomanNumeralReturnItsValue() {
		assertEquals(5, romanNumeralConverter.valueOf("V"));
		assertEquals(10, romanNumeralConverter.valueOf("X"));
		assertEquals(50, romanNumeralConverter.valueOf("L"));
		assertEquals(100, romanNumeralConverter.valueOf("C"));
		assertEquals(500, romanNumeralConverter.valueOf("D"));
		assertEquals(1000, romanNumeralConverter.valueOf("M"));
	}
	
	@Test
	public void testSetAndGetRomanNumeral() {
		romanNumeralConverter.setRomanNumeral("MDCLXVI");
		assertEquals("MDCLXVI", romanNumeralConverter.getRomanNumeral());
	}
	
	@Test
	public void testSplitRomanNumeralIntoRomanNumeralSymbolArrayWhenRomanNumeralIsSetToMDCLXVI() {
		romanNumeralConverter.setRomanNumeral("MDCLXVI");
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertEquals("C", romanNumeralConverter.getRomanNumeralSymbolArray()[2]);
	}
	
	@Test
	public void getEveryRomanNumeralSymbolInRomanNumeralSymbolArrayWhenRomanNumeralIsSetToMDCLXVI() {
		romanNumeralConverter.setRomanNumeral("MDCLXVI");
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertEquals("M", romanNumeralConverter.getRomanNumeralSymbolArray()[0]);
		assertEquals("D", romanNumeralConverter.getRomanNumeralSymbolArray()[1]);
		assertEquals("C", romanNumeralConverter.getRomanNumeralSymbolArray()[2]);
		assertEquals("L", romanNumeralConverter.getRomanNumeralSymbolArray()[3]);
		assertEquals("X", romanNumeralConverter.getRomanNumeralSymbolArray()[4]);
		assertEquals("V", romanNumeralConverter.getRomanNumeralSymbolArray()[5]);
		assertEquals("I", romanNumeralConverter.getRomanNumeralSymbolArray()[6]);
	}
	
	@Test
	public void testSetAndGetCurrentSymbolIndex() {
		romanNumeralConverter.setCurrentSymbolIndex(8);
		assertEquals(8, romanNumeralConverter.getCurrentSymbolIndex());
	}
}
