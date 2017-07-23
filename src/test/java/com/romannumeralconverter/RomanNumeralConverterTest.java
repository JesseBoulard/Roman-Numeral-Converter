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
}
