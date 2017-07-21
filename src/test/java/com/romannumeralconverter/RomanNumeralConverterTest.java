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
	public void ifRomanNumeralSymbolForIsPassedA1ReturnI() 
	{
		assertEquals("I", romanNumeralConverter.romanNumeralSymbolFor(1));
	}

	@Test
	public void ifRomanNumeralSymbolForIsPassedADigitReturnItsRomanNumeralEquivalent() 
	{
		assertEquals("V", romanNumeralConverter.romanNumeralSymbolFor(5));
		assertEquals("X", romanNumeralConverter.romanNumeralSymbolFor(10));
		assertEquals("L", romanNumeralConverter.romanNumeralSymbolFor(50));
		assertEquals("C", romanNumeralConverter.romanNumeralSymbolFor(100));
		assertEquals("D", romanNumeralConverter.romanNumeralSymbolFor(500));
		assertEquals("M", romanNumeralConverter.romanNumeralSymbolFor(1000));
	}
	
	@Test
	public void testSetArabicNumeralAndGetArabicNumeral() 
	{
		romanNumeralConverter.setArabicNumeral(10);
		assertEquals(10, romanNumeralConverter.getArabicNumeral());
	}
	
	@Test
	public void testGetDigitArrayWhenArabicNumeralIsSetTo1666() {
		romanNumeralConverter.setArabicNumeral(1666);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals(1, romanNumeralConverter.getDigitArray()[0]);
	}

}
