package jesseboulard.romannumeralconverter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jesseboulard.romannumeralconverter.RomanNumeralConverter;

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
	public void testReturnFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4() {
		romanNumeralConverter.romanNumeral = "DM";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.returnFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4());			
	}
	
	@Test
	public void testReturnTrueIfARomanNumeralIsNotProceededByAHigherRomanNumeralExceptWhenBothNumeralsCombineToMakeA9OrA4WhenRomanNumeralIsMMMCMXCIX() {
		romanNumeralConverter.romanNumeral = "MMMCMXCIX";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertTrue(romanNumeralConverter.returnFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4());		
	}
	
	@Test
	public void testReturnTrueIfARomanNumeralIsNotProceededByAHigherRomanNumeralExceptWhenBothNumeralsCombineToMakeA9OrA4WhenRomanNumeralIsCDXLIV() {
		romanNumeralConverter.romanNumeral = "CDXLIV";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertTrue(romanNumeralConverter.returnFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4());		
	}
	
	@Test
	public void testReturnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARowWhenRomanNumeralIsMDDCVI() {
		romanNumeralConverter.romanNumeral = "MDDCVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.returnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow());	
	}
	
	@Test
	public void testReturnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARowWhenRomanNumeralIsMDCVVI() {
		romanNumeralConverter.romanNumeral = "MDCVVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.returnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow());			
	}
	
	@Test
	public void testReturnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARowWhenRomanNumeralIsMDCLLXI() {
		romanNumeralConverter.romanNumeral = "MDCLLXI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.returnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow());		
	}
	
	@Test
	public void testIsTrueWhenReturnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARowWhenRomanNumeralIsMDLVI() {
		romanNumeralConverter.romanNumeral = "MDLVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertTrue(romanNumeralConverter.returnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow());		
	}
	
	@Test
	public void testReturnFalseIfMoreThanThreeRomanNumeralsAreInARow() {
		romanNumeralConverter.romanNumeral = "XXXXIV";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.returnFalseIfMoreThanThreeRomanNumeralsAreInARow());	
	}
	
	@Test
	public void testReturnTrueIfNoMoreThanThreeRomanNumeralsAreInARow() {
		romanNumeralConverter.romanNumeral = "XXXIV";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertTrue(romanNumeralConverter.returnFalseIfMoreThanThreeRomanNumeralsAreInARow());	
	}
	
	@Test
	public void testReturnFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral() {
		romanNumeralConverter.romanNumeral = "XXLVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.returnFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral());	
	}
	
	@Test
	public void testReturnFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeralSetsIsValidToTrueWhenRomanNumeralIsXLVI() {
		romanNumeralConverter.romanNumeral = "XLVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertTrue(romanNumeralConverter.returnFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral());	
	}
	
	@Test
	public void testReturnFalseIfSymbolIsNotRomanNumeralSymbolWhenRomanNumeralIsXLPI() {
		romanNumeralConverter.romanNumeral = "XLPI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.returnFalseIfSymbolIsNotRomanNumeralSymbol());	
	}
	
	@Test
	public void testReturnFalseIfSymbolIsNotRomanNumeralSymbolWhenRomanNumeralIsXLVI() {
		romanNumeralConverter.romanNumeral = "XLVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertTrue(romanNumeralConverter.returnFalseIfSymbolIsNotRomanNumeralSymbol());	
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXLPI() {
		romanNumeralConverter.romanNumeral = "XLPI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.isValidRomanNumeral());	
	}
	

	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXLVI() {
		romanNumeralConverter.romanNumeral = "XLVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertTrue(romanNumeralConverter.isValidRomanNumeral());	
	}
	
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsLLVI() {
		romanNumeralConverter.romanNumeral = "LLVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.isValidRomanNumeral());		
	}
	
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXXXXVI() {
		romanNumeralConverter.romanNumeral = "XXXXVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.isValidRomanNumeral());		
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXXCXVI() {
		romanNumeralConverter.romanNumeral = "XXCXVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.isValidRomanNumeral());	
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXMXVI() {
		romanNumeralConverter.romanNumeral = "XMXVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.isValidRomanNumeral());
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsVXVI() {
		romanNumeralConverter.romanNumeral = "VXVI";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.isValidRomanNumeral());	
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsMMMCMXCIX() {
		romanNumeralConverter.romanNumeral = "MMMCMXCIX";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertTrue(romanNumeralConverter.isValidRomanNumeral());		
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsMMMM() {
		romanNumeralConverter.romanNumeral = "MMMM";	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		assertFalse(romanNumeralConverter.isValidRomanNumeral());
	}
}
