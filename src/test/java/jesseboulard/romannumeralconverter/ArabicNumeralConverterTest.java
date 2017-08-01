package jesseboulard.romannumeralconverter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jesseboulard.romannumeralconverter.ArabicNumeralConverter;

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
	public void testGetDigitArrayWhenArabicNumeralIsSetTo1666() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1666");
		assertEquals(1, arabicNumeralConverter.digitArray[0]);
	}

	@Test
	public void testGetDigitArrayForAllDigitArrayValuesWhenArabicNumeralIsSetTo1666AndSplitArabicNumeralIntoDigitArrayIsCalled() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1666");
		assertEquals(1, arabicNumeralConverter.digitArray[0]);
		assertEquals(6, arabicNumeralConverter.digitArray[1]);
		assertEquals(6, arabicNumeralConverter.digitArray[2]);
		assertEquals(6, arabicNumeralConverter.digitArray[3]);
	}
	
	@Test
	public void testCurrentDigitPlaceValueWhenPlaceValueShouldBe100() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1693");
		arabicNumeralConverter.currentDigitIndex = 1;
		assertEquals(100, arabicNumeralConverter.currentDigitPlaceValue());
	}
	
	@Test
	public void testCurrentDigitPlaceValueForAllValues() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1693");
		arabicNumeralConverter.currentDigitIndex = 0;
		assertEquals(1000, arabicNumeralConverter.currentDigitPlaceValue());
		arabicNumeralConverter.currentDigitIndex = 1;
		assertEquals(100, arabicNumeralConverter.currentDigitPlaceValue());
		arabicNumeralConverter.currentDigitIndex = 2;
		assertEquals(10, arabicNumeralConverter.currentDigitPlaceValue());
		arabicNumeralConverter.currentDigitIndex = 3;
		assertEquals(1, arabicNumeralConverter.currentDigitPlaceValue());
	}
	
	@Test
	public void testIfCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenationWhen9IsInOnesPlace() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("2109");
		arabicNumeralConverter.currentDigitIndex = 3;
		assertEquals("IX", arabicNumeralConverter.returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsA9(""));
	}
	
	@Test
	public void testIfCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenationWhen9IsInTensPlace() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("2190");
		arabicNumeralConverter.currentDigitIndex = 2;
		assertEquals("XC", arabicNumeralConverter.returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsA9(""));
	}
	
	@Test
	public void testIfCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenationWhen9IsInHundredsPlace() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("2910");
		arabicNumeralConverter.currentDigitIndex = 1;
		assertEquals("CM", arabicNumeralConverter.returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsA9(""));
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenationWhenCurrentDigitPlaceValueIsOnes() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1396");
		arabicNumeralConverter.currentDigitIndex = 3;
		arabicNumeralConverter.currentDigitPlaceValue();
		assertEquals("VI", arabicNumeralConverter.returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsLessThan9AndGreaterThanOrEqualTo5(""));
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenationWhenCurrentDigitPlaceValueIsTens() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1376");
		arabicNumeralConverter.currentDigitIndex = 2;
		arabicNumeralConverter.currentDigitPlaceValue();
		assertEquals("LXX", arabicNumeralConverter.returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsLessThan9AndGreaterThanOrEqualTo5(""));
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenationWhenCurrentDigitPlaceValueIsHundreds() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1836");
		arabicNumeralConverter.currentDigitIndex = 1;
		arabicNumeralConverter.currentDigitPlaceValue();
		assertEquals("DCCC", arabicNumeralConverter.returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsLessThan9AndGreaterThanOrEqualTo5(""));
	}
	
	@Test
	public void testIfCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenationWhen4IsInOnesPlace() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1394");
		arabicNumeralConverter.currentDigitIndex = 3;
		assertEquals("IV", arabicNumeralConverter.returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsA4(""));
	}
	
	@Test
	public void testIfCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenationWhen4IsInTensPlace() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1348");
		arabicNumeralConverter.currentDigitIndex = 2;
		assertEquals("XL", arabicNumeralConverter.returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsA4(""));
	}
	
	@Test
	public void testIfCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenationWhen4IsInHundredsPlace() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1458");
		arabicNumeralConverter.currentDigitIndex = 1;
		assertEquals("CD", arabicNumeralConverter.returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsA4(""));
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenationWhenDigitIsInOnesPlace() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1693");
		arabicNumeralConverter.currentDigitIndex = 3;
		assertEquals("III", arabicNumeralConverter.returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsLessThan4(""));
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenationWhenDigitIsInTensPlace() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1624");
		arabicNumeralConverter.currentDigitIndex = 2;
		assertEquals("XX", arabicNumeralConverter.returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsLessThan4(""));
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenationWhenDigitIsInHundredsPlace() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1154");
		arabicNumeralConverter.currentDigitIndex = 1;
		assertEquals("C", arabicNumeralConverter.returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsLessThan4(""));
	}
	
	@Test
	public void returnMDCLXVIifArabicNumeralIs1666AndReturnArabicNumeralConvertedToRomanNumeralMethodIsCalled() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1666");
		assertEquals("MDCLXVI", arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());
	}
	
	@Test
	public void returnMMMCMXCIXifArabicNumeralIs3999AndReturnArabicNumeralConvertedToRomanNumeralMethodIsCalled() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("3999");
		assertEquals("MMMCMXCIX", arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());		
	}

	@Test
	public void returnIifArabicNumeralIs1AndReturnArabicNumeralConvertedToRomanNumeralMethodIsCalled() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1");
		assertEquals("I", arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());		
	}

	@Test
	public void returnMCMXLVIIifArabicNumeralIs1947AndReturnArabicNumeralConvertedToRomanNumeralMethodIsCalled() {
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray("1947");
		assertEquals("MCMXLVII", arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());		
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIs1() {
		assertTrue(arabicNumeralConverter.returnFalseIfUserInputIsNotAnIntBetween1And3999("1"));		
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIsME262() {
		assertFalse(arabicNumeralConverter.returnFalseIfUserInputIsNotAnIntBetween1And3999("ME262"));	
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIs3999() {
		assertTrue(arabicNumeralConverter.returnFalseIfUserInputIsNotAnIntBetween1And3999("3999"));		
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIs4000() {
		assertFalse(arabicNumeralConverter.returnFalseIfUserInputIsNotAnIntBetween1And3999("4000"));	
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIs0() {	
		assertFalse(arabicNumeralConverter.returnFalseIfUserInputIsNotAnIntBetween1And3999("0"));	
	}
}
