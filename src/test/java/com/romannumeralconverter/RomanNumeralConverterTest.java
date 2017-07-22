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

	@Test
	public void testGetDigitArrayForAllDigitArrayValuesWhenArabicNumeralIsSetTo1666AndSplitArabicNumeralIntoDigitArrayIsCalled() {
		romanNumeralConverter.setArabicNumeral(1666);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals(1, romanNumeralConverter.getDigitArray()[0]);
		assertEquals(6, romanNumeralConverter.getDigitArray()[1]);
		assertEquals(6, romanNumeralConverter.getDigitArray()[2]);
		assertEquals(6, romanNumeralConverter.getDigitArray()[3]);
	}
	
	@Test
	public void testSetCurrentDigitIndexAndGetCurrentDigitIndex() 
	{
		romanNumeralConverter.setCurrentDigitIndex(2);
		assertEquals(2, romanNumeralConverter.getCurrentDigitIndex());
	}
	
	@Test
	public void testCurrentDigitPlaceValueWhenPlaceValueShouldBe100() {
		romanNumeralConverter.setArabicNumeral(1693);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(1);
		assertEquals(100, romanNumeralConverter.currentDigitPlaceValue());
	}
	
	@Test
	public void testCurrentDigitPlaceValueForAllValues() {
		romanNumeralConverter.setArabicNumeral(1693);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(0);
		assertEquals(1000, romanNumeralConverter.currentDigitPlaceValue());
		romanNumeralConverter.setCurrentDigitIndex(1);
		assertEquals(100, romanNumeralConverter.currentDigitPlaceValue());
		romanNumeralConverter.setCurrentDigitIndex(2);
		assertEquals(10, romanNumeralConverter.currentDigitPlaceValue());
		romanNumeralConverter.setCurrentDigitIndex(3);
		assertEquals(1, romanNumeralConverter.currentDigitPlaceValue());
	}
	
	@Test
	public void testNextDigitPlaceValue() {
		romanNumeralConverter.setArabicNumeral(1693);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(1);
		assertEquals(100, romanNumeralConverter.currentDigitPlaceValue());
		assertEquals(1000, romanNumeralConverter.nextDigitPlaceValue());	
	}
	
	@Test
	public void testSetCurrentDigitValueAndGetCurrentDigitValue() 
	{
		romanNumeralConverter.setCurrentDigitValue(10);
		assertEquals(10, romanNumeralConverter.getCurrentDigitValue());
	}
	
	@Test
	public void testSetRomanNumeralConcatenationAndGetRomanNumeralConcatenation() 
	{
		romanNumeralConverter.setRomanNumeralConcatenation("MMC");
		assertEquals("MMC", romanNumeralConverter.getRomanNumeralConcatenation());
	}
	
	@Test
	public void testIfCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenationWhen9IsInOnesPlace() {
		romanNumeralConverter.setArabicNumeral(2109);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(3);
		romanNumeralConverter.setRomanNumeralConcatenation("");
		romanNumeralConverter.ifCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenation();
		assertEquals("IX", romanNumeralConverter.getRomanNumeralConcatenation());
	}
	
	@Test
	public void testIfCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenationWhen9IsInTensPlace() {
		romanNumeralConverter.setArabicNumeral(2190);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(2);
		romanNumeralConverter.setRomanNumeralConcatenation("");
		romanNumeralConverter.ifCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenation();
		assertEquals("XC", romanNumeralConverter.getRomanNumeralConcatenation());
	}
	
	@Test
	public void testIfCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenationWhen9IsInHundredsPlace() {
		romanNumeralConverter.setArabicNumeral(2910);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(1);
		romanNumeralConverter.setRomanNumeralConcatenation("");
		romanNumeralConverter.ifCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenation();
		assertEquals("CM", romanNumeralConverter.getRomanNumeralConcatenation());
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenationWhenCurrentDigitPlaceValueIsOnes() {
		romanNumeralConverter.setArabicNumeral(1396);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(3);
		romanNumeralConverter.currentDigitPlaceValue();
		romanNumeralConverter.setRomanNumeralConcatenation("");
		romanNumeralConverter.ifCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("VI", romanNumeralConverter.getRomanNumeralConcatenation());
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenationWhenCurrentDigitPlaceValueIsTens() {
		romanNumeralConverter.setArabicNumeral(1376);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(2);
		romanNumeralConverter.currentDigitPlaceValue();
		romanNumeralConverter.setRomanNumeralConcatenation("");
		romanNumeralConverter.ifCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("LXX", romanNumeralConverter.getRomanNumeralConcatenation());
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenationWhenCurrentDigitPlaceValueIsHundreds() {
		romanNumeralConverter.setArabicNumeral(1836);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(1);
		romanNumeralConverter.currentDigitPlaceValue();
		romanNumeralConverter.setRomanNumeralConcatenation("");
		romanNumeralConverter.ifCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("DCCC", romanNumeralConverter.getRomanNumeralConcatenation());
	}
	
	@Test
	public void testIfCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenationWhen4IsInOnesPlace() {
		romanNumeralConverter.setArabicNumeral(1394);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(3);
		romanNumeralConverter.setRomanNumeralConcatenation("");
		romanNumeralConverter.ifCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenation();
		assertEquals("IV", romanNumeralConverter.getRomanNumeralConcatenation());
	}
	
	@Test
	public void testIfCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenationWhen4IsInTensPlace() {
		romanNumeralConverter.setArabicNumeral(1348);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(2);
		romanNumeralConverter.setRomanNumeralConcatenation("");
		romanNumeralConverter.ifCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenation();
		assertEquals("XL", romanNumeralConverter.getRomanNumeralConcatenation());
	}
	
	@Test
	public void testIfCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenationWhen4IsInHundredsPlace() {
		romanNumeralConverter.setArabicNumeral(1458);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(1);
		romanNumeralConverter.setRomanNumeralConcatenation("");
		romanNumeralConverter.ifCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenation();
		assertEquals("CD", romanNumeralConverter.getRomanNumeralConcatenation());
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenationWhenDigitIsInOnesPlace() {
		romanNumeralConverter.setArabicNumeral(1693);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(3);
		romanNumeralConverter.setRomanNumeralConcatenation("");
		romanNumeralConverter.ifCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("III", romanNumeralConverter.getRomanNumeralConcatenation());
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenationWhenDigitIsInTensPlace() {
		romanNumeralConverter.setArabicNumeral(1624);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(2);
		romanNumeralConverter.setRomanNumeralConcatenation("");
		romanNumeralConverter.ifCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("XX", romanNumeralConverter.getRomanNumeralConcatenation());
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenationWhenDigitIsInHundredsPlace() {
		romanNumeralConverter.setArabicNumeral(1154);
		romanNumeralConverter.splitArabicNumeralIntoDigitArray();
		romanNumeralConverter.setCurrentDigitIndex(1);
		romanNumeralConverter.setRomanNumeralConcatenation("");
		romanNumeralConverter.ifCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("C", romanNumeralConverter.getRomanNumeralConcatenation());
	}
}
