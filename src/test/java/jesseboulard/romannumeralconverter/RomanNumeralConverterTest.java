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
	public void testSplitRomanNumeralIntoRomanNumeralSymbolArrayWhenRomanNumeralIsSetToMDCLXVI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MDCLXVI");
		assertEquals("C", romanNumeralConverter.romanNumeralSymbolArray[2]);
	}
	
	@Test
	public void getEveryRomanNumeralSymbolInRomanNumeralSymbolArrayWhenRomanNumeralIsSetToMDCLXVI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MDCLXVI");
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
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MDCLXVI");
		romanNumeralConverter.currentSymbolIndex = 3;
		romanNumeralConverter.calcValueOfCurrentSymbol();
		assertEquals(50, romanNumeralConverter.valueOfCurrentSymbol);
	}
	
	@Test
	public void testAllSymbolsWhenValueOfCurrentSymbolMethodIsCalled() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MDCLXVI");
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
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MDCLXVI");
		romanNumeralConverter.currentSymbolIndex = 3;
		romanNumeralConverter.calcValueOfNextSymbol();
		assertEquals(10, romanNumeralConverter.valueOfNextSymbol);
	}
	
	@Test
	public void returnCorrectValueIfTheValueOfNextSymbolMethodIsCalledOnAnySymbolInRomanNumeralSymbolArray() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MDCLXVI");
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
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MDCLXVI");
		assertEquals(1666, romanNumeralConverter.returnRomanNumeralConvertedToArabicNumeral());
	}
	
	@Test
	public void return1ifRomanNumeralIsIAndReturnRomanNumeralConvertedToArabicNumeralMethodIsCalled() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("I");
		assertEquals(1, romanNumeralConverter.returnRomanNumeralConvertedToArabicNumeral());
	}
	
	@Test
	public void return3999ifRomanNumeralIsMMMCMXCIXAndReturnRomanNumeralConvertedToArabicNumeralMethodIsCalled() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MMMCMXCIX");
		assertEquals(3999, romanNumeralConverter.returnRomanNumeralConvertedToArabicNumeral());
	}
	
	@Test
	public void testReturnFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("DM");
		assertFalse(romanNumeralConverter.returnFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4());			
	}
	
	@Test
	public void testReturnTrueIfARomanNumeralIsNotProceededByAHigherRomanNumeralExceptWhenBothNumeralsCombineToMakeA9OrA4WhenRomanNumeralIsMMMCMXCIX() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MMMCMXCIX");
		assertTrue(romanNumeralConverter.returnFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4());		
	}
	
	@Test
	public void testReturnTrueIfARomanNumeralIsNotProceededByAHigherRomanNumeralExceptWhenBothNumeralsCombineToMakeA9OrA4WhenRomanNumeralIsCDXLIV() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("CDXLIV");
		assertTrue(romanNumeralConverter.returnFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4());		
	}
	
	@Test
	public void testReturnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARowWhenRomanNumeralIsMDDCVI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MDDCVI");
		assertFalse(romanNumeralConverter.returnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow());	
	}
	
	@Test
	public void testReturnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARowWhenRomanNumeralIsMDCVVI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MDCVVI");
		assertFalse(romanNumeralConverter.returnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow());			
	}
	
	@Test
	public void testReturnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARowWhenRomanNumeralIsMDCLLXI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MDCLLXI");
		assertFalse(romanNumeralConverter.returnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow());		
	}
	
	@Test
	public void testIsTrueWhenReturnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARowWhenRomanNumeralIsMDLVI() {	
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MDLVI");
		assertTrue(romanNumeralConverter.returnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow());		
	}
	
	@Test
	public void testReturnFalseIfMoreThanThreeRomanNumeralsAreInARow() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("XXXXIV");
		assertFalse(romanNumeralConverter.returnFalseIfMoreThanThreeRomanNumeralsAreInARow());	
	}
	
	@Test
	public void testReturnTrueIfNoMoreThanThreeRomanNumeralsAreInARow() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("XXXIV");
		assertTrue(romanNumeralConverter.returnFalseIfMoreThanThreeRomanNumeralsAreInARow());	
	}
	
	@Test
	public void testReturnFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("XXLVI");
		assertFalse(romanNumeralConverter.returnFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral());	
	}
	
	@Test
	public void testReturnFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeralSetsIsValidToTrueWhenRomanNumeralIsXLVI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("XLVI");
		assertTrue(romanNumeralConverter.returnFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral());	
	}
	
	@Test
	public void testReturnFalseIfSymbolIsNotRomanNumeralSymbolWhenRomanNumeralIsXLPI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("XLPI");
		assertFalse(romanNumeralConverter.returnFalseIfSymbolIsNotRomanNumeralSymbol());	
	}
	
	@Test
	public void testReturnFalseIfSymbolIsNotRomanNumeralSymbolWhenRomanNumeralIsXLVI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("XLVI");
		assertTrue(romanNumeralConverter.returnFalseIfSymbolIsNotRomanNumeralSymbol());	
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXLPI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("XLPI");
		assertFalse(romanNumeralConverter.isValidRomanNumeral());	
	}
	

	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXLVI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("XLVI");
		assertTrue(romanNumeralConverter.isValidRomanNumeral());	
	}
	
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsLLVI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("LLVI");
		assertFalse(romanNumeralConverter.isValidRomanNumeral());		
	}
	
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXXXXVI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("XXXXVI");
		assertFalse(romanNumeralConverter.isValidRomanNumeral());		
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXXCXVI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("XXCXVI");
		assertFalse(romanNumeralConverter.isValidRomanNumeral());	
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsXMXVI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("XMXVI");
		assertFalse(romanNumeralConverter.isValidRomanNumeral());
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsVXVI() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("VXVI");
		assertFalse(romanNumeralConverter.isValidRomanNumeral());	
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsMMMCMXCIX() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MMMCMXCIX");
		assertTrue(romanNumeralConverter.isValidRomanNumeral());		
	}
	
	@Test
	public void testIsValidRomanNumeralWhenRomanNumeralIsMMMM() {
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray("MMMM");
		assertFalse(romanNumeralConverter.isValidRomanNumeral());
	}
}
