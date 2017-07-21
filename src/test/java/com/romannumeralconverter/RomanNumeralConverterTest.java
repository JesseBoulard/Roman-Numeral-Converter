package com.romannumeralconverter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RomanNumeralConverterTest {

	@Test
	public void ifRomanNumeralSymbolForIsPassedA1ReturnI() {
		RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
		assertEquals("I", romanNumeralConverter.romanNumeralSymbolFor(1));
	}

}
