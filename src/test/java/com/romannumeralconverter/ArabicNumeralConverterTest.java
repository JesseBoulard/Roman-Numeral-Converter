package com.romannumeralconverter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArabicNumeralConverterTest {

	ArabicNumeralConverter arabicNumeralConverter;
	
	@Before
	public void setUp() throws Exception {
		arabicNumeralConverter = new ArabicNumeralConverter();
	}

	@Test
	public void ifRomanNumeralSymbolForIsPassedA1ReturnI() 
	{
		assertEquals("I", arabicNumeralConverter.romanNumeralSymbolFor(1));
	}

	@Test
	public void ifRomanNumeralSymbolForIsPassedADigitReturnItsRomanNumeralEquivalent() 
	{
		assertEquals("V", arabicNumeralConverter.romanNumeralSymbolFor(5));
		assertEquals("X", arabicNumeralConverter.romanNumeralSymbolFor(10));
		assertEquals("L", arabicNumeralConverter.romanNumeralSymbolFor(50));
		assertEquals("C", arabicNumeralConverter.romanNumeralSymbolFor(100));
		assertEquals("D", arabicNumeralConverter.romanNumeralSymbolFor(500));
		assertEquals("M", arabicNumeralConverter.romanNumeralSymbolFor(1000));
	}
	
	@Test
	public void testSetArabicNumeralAndGetArabicNumeral() 
	{
		arabicNumeralConverter.setArabicNumeral(10);
		assertEquals(10, arabicNumeralConverter.getArabicNumeral());
	}
	
	@Test
	public void testGetDigitArrayWhenArabicNumeralIsSetTo1666() {
		arabicNumeralConverter.setArabicNumeral(1666);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals(1, arabicNumeralConverter.getDigitArray()[0]);
	}

	@Test
	public void testGetDigitArrayForAllDigitArrayValuesWhenArabicNumeralIsSetTo1666AndSplitArabicNumeralIntoDigitArrayIsCalled() {
		arabicNumeralConverter.setArabicNumeral(1666);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals(1, arabicNumeralConverter.getDigitArray()[0]);
		assertEquals(6, arabicNumeralConverter.getDigitArray()[1]);
		assertEquals(6, arabicNumeralConverter.getDigitArray()[2]);
		assertEquals(6, arabicNumeralConverter.getDigitArray()[3]);
	}
	
	@Test
	public void testSetCurrentDigitIndexAndGetCurrentDigitIndex() 
	{
		arabicNumeralConverter.setCurrentDigitIndex(2);
		assertEquals(2, arabicNumeralConverter.getCurrentDigitIndex());
	}
	
	@Test
	public void testCurrentDigitPlaceValueWhenPlaceValueShouldBe100() {
		arabicNumeralConverter.setArabicNumeral(1693);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(1);
		assertEquals(100, arabicNumeralConverter.currentDigitPlaceValue());
	}
	
	@Test
	public void testCurrentDigitPlaceValueForAllValues() {
		arabicNumeralConverter.setArabicNumeral(1693);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(0);
		assertEquals(1000, arabicNumeralConverter.currentDigitPlaceValue());
		arabicNumeralConverter.setCurrentDigitIndex(1);
		assertEquals(100, arabicNumeralConverter.currentDigitPlaceValue());
		arabicNumeralConverter.setCurrentDigitIndex(2);
		assertEquals(10, arabicNumeralConverter.currentDigitPlaceValue());
		arabicNumeralConverter.setCurrentDigitIndex(3);
		assertEquals(1, arabicNumeralConverter.currentDigitPlaceValue());
	}
	
	@Test
	public void testSetCurrentDigitValueAndGetCurrentDigitValue() 
	{
		arabicNumeralConverter.setCurrentDigitValue(10);
		assertEquals(10, arabicNumeralConverter.getCurrentDigitValue());
	}
	
	@Test
	public void testIfCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenationWhen9IsInOnesPlace() {
		arabicNumeralConverter.setArabicNumeral(2109);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(3);
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenation();
		assertEquals("IX", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenationWhen9IsInTensPlace() {
		arabicNumeralConverter.setArabicNumeral(2190);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(2);
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenation();
		assertEquals("XC", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenationWhen9IsInHundredsPlace() {
		arabicNumeralConverter.setArabicNumeral(2910);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(1);
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenation();
		assertEquals("CM", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenationWhenCurrentDigitPlaceValueIsOnes() {
		arabicNumeralConverter.setArabicNumeral(1396);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(3);
		arabicNumeralConverter.currentDigitPlaceValue();
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("VI", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenationWhenCurrentDigitPlaceValueIsTens() {
		arabicNumeralConverter.setArabicNumeral(1376);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(2);
		arabicNumeralConverter.currentDigitPlaceValue();
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("LXX", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenationWhenCurrentDigitPlaceValueIsHundreds() {
		arabicNumeralConverter.setArabicNumeral(1836);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(1);
		arabicNumeralConverter.currentDigitPlaceValue();
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("DCCC", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenationWhen4IsInOnesPlace() {
		arabicNumeralConverter.setArabicNumeral(1394);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(3);
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenation();
		assertEquals("IV", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenationWhen4IsInTensPlace() {
		arabicNumeralConverter.setArabicNumeral(1348);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(2);
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenation();
		assertEquals("XL", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenationWhen4IsInHundredsPlace() {
		arabicNumeralConverter.setArabicNumeral(1458);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(1);
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenation();
		assertEquals("CD", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenationWhenDigitIsInOnesPlace() {
		arabicNumeralConverter.setArabicNumeral(1693);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(3);
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("III", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenationWhenDigitIsInTensPlace() {
		arabicNumeralConverter.setArabicNumeral(1624);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(2);
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("XX", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenationWhenDigitIsInHundredsPlace() {
		arabicNumeralConverter.setArabicNumeral(1154);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.setCurrentDigitIndex(1);
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("C", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void returnMDCLXVIifArabicNumeralIs1666AndReturnArabicNumeralConvertedToRomanNumeralMethodIsCalled() {
		arabicNumeralConverter.setArabicNumeral(1666);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals("MDCLXVI", arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());
	}
	
	@Test
	public void returnMMMCMXCIXifArabicNumeralIs3999AndReturnArabicNumeralConvertedToRomanNumeralMethodIsCalled() {
		arabicNumeralConverter.setArabicNumeral(3999);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals("MMMCMXCIX", arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());		
	}

	@Test
	public void returnIifArabicNumeralIs1AndReturnArabicNumeralConvertedToRomanNumeralMethodIsCalled() {
		arabicNumeralConverter.setArabicNumeral(1);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals("I", arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());		
	}

	@Test
	public void returnMCMXLVIIifArabicNumeralIs1947AndReturnArabicNumeralConvertedToRomanNumeralMethodIsCalled() {
		arabicNumeralConverter.setArabicNumeral(1947);
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals("MCMXLVII", arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());		
	}
	
	@Test
	public void testGetIsValidAndSetIsValid() {
		arabicNumeralConverter.setIsValid(false);
		assertEquals(false, arabicNumeralConverter.getIsValid());		
	}

	@Test
	public void testGetUserInputAndSetUserInput() {
		arabicNumeralConverter.setUserInput("P1F5");
		assertEquals("P1F5", arabicNumeralConverter.getUserInput());		
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIs1() {
		arabicNumeralConverter.setUserInput("1");
		arabicNumeralConverter.setIsValidToFalseIfUserInputIsNotAnIntBetween1And3999();
		assertEquals(1, arabicNumeralConverter.getArabicNumeral());		
		assertTrue(arabicNumeralConverter.getIsValid());	
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIsME262() {
		arabicNumeralConverter.setUserInput("ME262");
		arabicNumeralConverter.setIsValidToFalseIfUserInputIsNotAnIntBetween1And3999();
		assertEquals(0, arabicNumeralConverter.getArabicNumeral());		
		assertFalse(arabicNumeralConverter.getIsValid());	
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIs3999() {
		arabicNumeralConverter.setUserInput("3999");
		arabicNumeralConverter.setIsValidToFalseIfUserInputIsNotAnIntBetween1And3999();
		assertEquals(3999, arabicNumeralConverter.getArabicNumeral());		
		assertTrue(arabicNumeralConverter.getIsValid());	
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIs4000() {
		arabicNumeralConverter.setUserInput("4000");
		arabicNumeralConverter.setIsValidToFalseIfUserInputIsNotAnIntBetween1And3999();
		assertEquals(0, arabicNumeralConverter.getArabicNumeral());		
		assertFalse(arabicNumeralConverter.getIsValid());	
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIs0() {
		arabicNumeralConverter.setUserInput("0");
		arabicNumeralConverter.setIsValidToFalseIfUserInputIsNotAnIntBetween1And3999();
		assertEquals(0, arabicNumeralConverter.getArabicNumeral());		
		assertFalse(arabicNumeralConverter.getIsValid());	
	}
}
