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
	
	@Test
	public void return50ifCurrentSymbolIsLAndValueOfCurrentSymbolMethodIsCalled() {
		romanNumeralConverter.setRomanNumeral("MDCLXVI");
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.setCurrentSymbolIndex(3);
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(50, romanNumeralConverter.getValueOfCurrentSymbol());
	}
	
	@Test
	public void testAllSymbolsWhenValueOfCurrentSymbolMethodIsCalled() {
		romanNumeralConverter.setRomanNumeral("MDCLXVI");
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.setCurrentSymbolIndex(0);
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(1000, romanNumeralConverter.getValueOfCurrentSymbol());
		romanNumeralConverter.setCurrentSymbolIndex(1);
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(500, romanNumeralConverter.getValueOfCurrentSymbol());
		romanNumeralConverter.setCurrentSymbolIndex(2);
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(100, romanNumeralConverter.getValueOfCurrentSymbol());
		romanNumeralConverter.setCurrentSymbolIndex(3);
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(50, romanNumeralConverter.getValueOfCurrentSymbol());
		romanNumeralConverter.setCurrentSymbolIndex(4);
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(10, romanNumeralConverter.getValueOfCurrentSymbol());
		romanNumeralConverter.setCurrentSymbolIndex(5);
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(5, romanNumeralConverter.getValueOfCurrentSymbol());
		romanNumeralConverter.setCurrentSymbolIndex(6);
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(1, romanNumeralConverter.getValueOfCurrentSymbol());
	}
	
	@Test
	public void return10ifNextSymbolIsXAndValueOfNextSymbolMethodIsCalled() {
		romanNumeralConverter.setRomanNumeral("MDCLXVI");
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.setCurrentSymbolIndex(3);
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(10, romanNumeralConverter.getValueOfNextSymbol());
	}
	
	@Test
	public void returnCorrectValueIfTheValueOfNextSymbolMethodIsCalledOnAnySymbolInRomanNumeralSymbolArray() {
		romanNumeralConverter.setRomanNumeral("MDCLXVI");
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.setCurrentSymbolIndex(6);
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(0, romanNumeralConverter.getValueOfNextSymbol());
		romanNumeralConverter.setCurrentSymbolIndex(5);
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(1, romanNumeralConverter.getValueOfNextSymbol());
		romanNumeralConverter.setCurrentSymbolIndex(4);
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(5, romanNumeralConverter.getValueOfNextSymbol());
		romanNumeralConverter.setCurrentSymbolIndex(3);
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(10, romanNumeralConverter.getValueOfNextSymbol());
		romanNumeralConverter.setCurrentSymbolIndex(2);
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(50, romanNumeralConverter.getValueOfNextSymbol());
		romanNumeralConverter.setCurrentSymbolIndex(1);
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(100, romanNumeralConverter.getValueOfNextSymbol());
		romanNumeralConverter.setCurrentSymbolIndex(0);
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(500, romanNumeralConverter.getValueOfNextSymbol());
	}
	
	@Test
	public void return1666ifRomanNumeralIsMDCLXVIAndReturnRomanNumeralConvertedToArabicNumeralMethodIsCalled() {
		romanNumeralConverter.setRomanNumeral("MDCLXVI");
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertEquals(1666, romanNumeralConverter.returnRomanNumeralConvertedToArabicNumeral());
	}
	
	@Test
	public void return1ifRomanNumeralIsIAndReturnRomanNumeralConvertedToArabicNumeralMethodIsCalled() {
		romanNumeralConverter.setRomanNumeral("I");
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertEquals(1, romanNumeralConverter.returnRomanNumeralConvertedToArabicNumeral());
	}
	
	@Test
	public void return3999ifRomanNumeralIsMMMCMXCIXAndReturnRomanNumeralConvertedToArabicNumeralMethodIsCalled() {
		romanNumeralConverter.setRomanNumeral("MMMCMXCIX");
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertEquals(3999, romanNumeralConverter.returnRomanNumeralConvertedToArabicNumeral());
	}
	
	@Test
	public void testGetIsValidAndSetIsValid() {
		romanNumeralConverter.setIsValid(false);
		assertEquals(false, romanNumeralConverter.getIsValid());		
	}
	
	@Test
	public void testSetIsValidToFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4() {
		romanNumeralConverter.setRomanNumeral("DM");	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.setIsValid(true);
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4();
		assertFalse(romanNumeralConverter.getIsValid());		
	}
	
	@Test
	public void testSetIsValidToTrueIfARomanNumeralIsNotProceededByAHigherRomanNumeralExceptWhenBothNumeralsCombineToMakeA9OrA4WhenRomanNumeralIsMMMCMXCIX() {
		romanNumeralConverter.setRomanNumeral("MMMCMXCIX");	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.setIsValid(true);
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4();
		assertTrue(romanNumeralConverter.getIsValid());		
	}
	
	@Test
	public void testSetIsValidToTrueIfARomanNumeralIsNotProceededByAHigherRomanNumeralExceptWhenBothNumeralsCombineToMakeA9OrA4WhenRomanNumeralIsCDXLIV() {
		romanNumeralConverter.setRomanNumeral("CDXLIV");	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.setIsValid(true);
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4();
		assertTrue(romanNumeralConverter.getIsValid());		
	}
	
	@Test
	public void testSetIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5IsProceededByAnotherRomanNumeralSymbolWithAValueStartingWith5() {
		romanNumeralConverter.setRomanNumeral("MDDCVI");	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.setIsValid(true);
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5IsProceededByAnotherRomanNumeralSymbolWithAValueStartingWith5();
		assertFalse(romanNumeralConverter.getIsValid());		
	}
	
	@Test
	public void testSetIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5IsProceededByAnotherRomanNumeralSymbolWithAValueStartingWith5whenRomanNumeralIsMDCVVI() {
		romanNumeralConverter.setRomanNumeral("MDCVVI");	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.setIsValid(true);
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5IsProceededByAnotherRomanNumeralSymbolWithAValueStartingWith5();
		assertFalse(romanNumeralConverter.getIsValid());		
	}
	
	@Test
	public void testSetIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5IsProceededByAnotherRomanNumeralSymbolWithAValueStartingWith5whenRomanNumeralIsMDCLLXI() {
		romanNumeralConverter.setRomanNumeral("MDCLLXI");	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		romanNumeralConverter.setIsValid(true);
		romanNumeralConverter.setIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5IsProceededByAnotherRomanNumeralSymbolWithAValueStartingWith5();
		assertFalse(romanNumeralConverter.getIsValid());		
	}
}
