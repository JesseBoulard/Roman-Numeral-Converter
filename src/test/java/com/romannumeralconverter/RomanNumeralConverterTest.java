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
		romanNumeralConverter.romanNumeral = "MDCLXVI";
		assertEquals("MDCLXVI", romanNumeralConverter.romanNumeral);
	}
	
	@Test
	public void testSplitRomanNumeralIntoRomanNumeralSymbolArrayWhenRomanNumeralIsSetToMDCLXVI() {
		romanNumeralConverter.romanNumeral = "MDCLXVI";
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertEquals("C", romanNumeralConverter.romanNumeralSymbolArray[2]);
	}
	
	@Test
	public void getEveryRomanNumeralSymbolInRomanNumeralSymbolArrayWhenRomanNumeralIsSetToMDCLXVI() {
		romanNumeralConverter.romanNumeral = "MDCLXVI";
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertEquals("M", romanNumeralConverter.romanNumeralSymbolArray[0]);
		assertEquals("D", romanNumeralConverter.romanNumeralSymbolArray[1]);
		assertEquals("C", romanNumeralConverter.romanNumeralSymbolArray[2]);
		assertEquals("L", romanNumeralConverter.romanNumeralSymbolArray[3]);
		assertEquals("X", romanNumeralConverter.romanNumeralSymbolArray[4]);
		assertEquals("V", romanNumeralConverter.romanNumeralSymbolArray[5]);
		assertEquals("I", romanNumeralConverter.romanNumeralSymbolArray[6]);
	}
	
	@Test
	public void return50ifCurrentSymbolIsLAndValueOfCurrentSymbolMethodIsCalled() {
		romanNumeralConverter.romanNumeral = "MDCLXVI";
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.currentSymbolIndex = 3;
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(50, romanNumeralConverter.valueOfCurrentSymbol);
	}
	
	@Test
	public void testAllSymbolsWhenValueOfCurrentSymbolMethodIsCalled() {
		romanNumeralConverter.romanNumeral = "MDCLXVI";
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.currentSymbolIndex = 0;
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(1000, romanNumeralConverter.valueOfCurrentSymbol);
		romanNumeralConverter.currentSymbolIndex = 1;
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(500, romanNumeralConverter.valueOfCurrentSymbol);
		romanNumeralConverter.currentSymbolIndex = 2;
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(100, romanNumeralConverter.valueOfCurrentSymbol);
		romanNumeralConverter.currentSymbolIndex = 3;
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(50, romanNumeralConverter.valueOfCurrentSymbol);
		romanNumeralConverter.currentSymbolIndex = 4;
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(10, romanNumeralConverter.valueOfCurrentSymbol);
		romanNumeralConverter.currentSymbolIndex = 5;
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(5, romanNumeralConverter.valueOfCurrentSymbol);
		romanNumeralConverter.currentSymbolIndex = 6;
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(1, romanNumeralConverter.valueOfCurrentSymbol);
	}
	
	@Test
	public void return10ifNextSymbolIsXAndValueOfNextSymbolMethodIsCalled() {
		romanNumeralConverter.romanNumeral = "MDCLXVI";
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.currentSymbolIndex = 3;
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(10, romanNumeralConverter.valueOfNextSymbol);
	}
	
	@Test
	public void returnCorrectValueIfTheValueOfNextSymbolMethodIsCalledOnAnySymbolInRomanNumeralSymbolArray() {
		romanNumeralConverter.romanNumeral = "MDCLXVI";
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.currentSymbolIndex = 6;
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(0, romanNumeralConverter.valueOfNextSymbol);
		romanNumeralConverter.currentSymbolIndex = 5;
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(1, romanNumeralConverter.valueOfNextSymbol);
		romanNumeralConverter.currentSymbolIndex = 4;
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(5, romanNumeralConverter.valueOfNextSymbol);
		romanNumeralConverter.currentSymbolIndex = 3;
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(10, romanNumeralConverter.valueOfNextSymbol);
		romanNumeralConverter.currentSymbolIndex = 2;
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(50, romanNumeralConverter.valueOfNextSymbol);
		romanNumeralConverter.currentSymbolIndex = 1;
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(100, romanNumeralConverter.valueOfNextSymbol);
		romanNumeralConverter.currentSymbolIndex = 0;
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(500, romanNumeralConverter.valueOfNextSymbol);
	}
	
	@Test
	public void return1666ifRomanNumeralIsMDCLXVIAndReturnRomanNumeralConvertedToArabicNumeralMethodIsCalled() {
		romanNumeralConverter.romanNumeral = "MDCLXVI";
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertEquals(1666, romanNumeralConverter.returnRomanNumeralConvertedToArabicNumeral());
	}
	
	@Test
	public void return1ifRomanNumeralIsIAndReturnRomanNumeralConvertedToArabicNumeralMethodIsCalled() {
		romanNumeralConverter.romanNumeral = "I";
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertEquals(1, romanNumeralConverter.returnRomanNumeralConvertedToArabicNumeral());
	}
	
	@Test
	public void return3999ifRomanNumeralIsMMMCMXCIXAndReturnRomanNumeralConvertedToArabicNumeralMethodIsCalled() {
		romanNumeralConverter.romanNumeral = "MMMCMXCIX";
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertEquals(3999, romanNumeralConverter.returnRomanNumeralConvertedToArabicNumeral());
	}
	
	@Test
	public void testSetIsValidToFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4() {
		romanNumeralConverter.romanNumeral = "DM";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4();
		assertFalse(romanNumeralConverter.isValid);			
	}
	
	@Test
	public void testSetIsValidToTrueIfARomanNumeralIsNotProceededByAHigherRomanNumeralExceptWhenBothNumeralsCombineToMakeA9OrA4WhenRomanNumeralIsMMMCMXCIX() {
		romanNumeralConverter.romanNumeral = "MMMCMXCIX";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4();
		assertTrue(romanNumeralConverter.isValid);		
	}
	
	@Test
	public void testSetIsValidToTrueIfARomanNumeralIsNotProceededByAHigherRomanNumeralExceptWhenBothNumeralsCombineToMakeA9OrA4WhenRomanNumeralIsCDXLIV() {
		romanNumeralConverter.romanNumeral = "CDXLIV";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4();
		assertTrue(romanNumeralConverter.isValid);		
	}
	
	@Test
	public void testSetIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARowWhenRomanNumeralIsMDDCVI() {
		romanNumeralConverter.romanNumeral = "MDDCVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow();
		assertFalse(romanNumeralConverter.isValid);		
	}
	
	@Test
	public void testSetIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARowWhenRomanNumeralIsMDCVVI() {
		romanNumeralConverter.romanNumeral = "MDCVVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow();
		assertFalse(romanNumeralConverter.isValid);			
	}
	
	@Test
	public void testSetIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARowWhenRomanNumeralIsMDCLLXI() {
		romanNumeralConverter.romanNumeral = "MDCLLXI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow();
		assertFalse(romanNumeralConverter.isValid);			
	}
	
	@Test
	public void testSetIsValidIsTrueWhenSetIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARowWhenRomanNumeralIsMDLVI() {
		romanNumeralConverter.romanNumeral = "MDLVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow();
		assertTrue(romanNumeralConverter.isValid);		
	}
	
	@Test
	public void testSetIsValidToFalseIfMoreThanThreeRomanNumeralsAreInARow() {
		romanNumeralConverter.romanNumeral = "XXXXIV";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfMoreThanThreeRomanNumeralsAreInARow();
		assertFalse(romanNumeralConverter.isValid);			
	}
	
	@Test
	public void testIsValidIsTrueIfNoMoreThanThreeRomanNumeralsAreInARow() {
		romanNumeralConverter.romanNumeral = "XXXIV";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfMoreThanThreeRomanNumeralsAreInARow();
		assertTrue(romanNumeralConverter.isValid);		
	}
	
	@Test
	public void testSetIsValidToFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral() {
		romanNumeralConverter.romanNumeral = "XXLVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral();
		assertFalse(romanNumeralConverter.isValid);			
	}
	
	@Test
	public void testSetIsValidToFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeralSetsIsValidToTrueWhenRomanNumeralIsXLVI() {
		romanNumeralConverter.romanNumeral = "XLVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral();
		assertTrue(romanNumeralConverter.isValid);		
	}
	
	@Test
	public void testSetIsValidToFalseIfSymbolIsNotRomanNumeralSymbolWhenRomanNumeralIsXLPI() {
		romanNumeralConverter.romanNumeral = "XLPI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfSymbolIsNotRomanNumeralSymbol();
		assertFalse(romanNumeralConverter.isValid);		
	}
	
	@Test
	public void testSetIsValidToFalseIfSymbolIsNotRomanNumeralSymbolWhenRomanNumeralIsXLVI() {
		romanNumeralConverter.romanNumeral = "XLVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.setIsValidToFalseIfSymbolIsNotRomanNumeralSymbol();
		assertTrue(romanNumeralConverter.isValid);		
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXLPI() {
		romanNumeralConverter.romanNumeral = "XLPI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.isValidRomanNumeral();
		assertFalse(romanNumeralConverter.isValid);		
	}
	

	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXLVI() {
		romanNumeralConverter.romanNumeral = "XLVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.isValidRomanNumeral();
		assertTrue(romanNumeralConverter.isValid);		
	}
	
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsLLVI() {
		romanNumeralConverter.romanNumeral = "LLVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.isValidRomanNumeral();
		assertFalse(romanNumeralConverter.isValid);			
	}
	
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXXXXVI() {
		romanNumeralConverter.romanNumeral = "XXXXVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.isValidRomanNumeral();
		assertFalse(romanNumeralConverter.isValid);			
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXXCXVI() {
		romanNumeralConverter.romanNumeral = "XXCXVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.isValidRomanNumeral();
		assertFalse(romanNumeralConverter.isValid);		
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXMXVI() {
		romanNumeralConverter.romanNumeral = "XMXVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.isValidRomanNumeral();
		assertFalse(romanNumeralConverter.isValid);		
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsVXVI() {
		romanNumeralConverter.romanNumeral = "VXVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.isValidRomanNumeral();
		assertFalse(romanNumeralConverter.isValid);			
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsMMMCMXCIX() {
		romanNumeralConverter.romanNumeral = "MMMCMXCIX";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.isValidRomanNumeral();
		assertTrue(romanNumeralConverter.isValid);			
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsMMMM() {
		romanNumeralConverter.romanNumeral = "MMMM";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.isValid = true;
		romanNumeralConverter.isValidRomanNumeral();
		assertFalse(romanNumeralConverter.isValid);		
	}
}
