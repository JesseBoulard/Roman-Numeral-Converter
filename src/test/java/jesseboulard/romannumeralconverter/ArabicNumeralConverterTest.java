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
		arabicNumeralConverter.arabicNumeral = 1666;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals(1, arabicNumeralConverter.digitArray[0]);
	}

	@Test
	public void testGetDigitArrayForAllDigitArrayValuesWhenArabicNumeralIsSetTo1666AndSplitArabicNumeralIntoDigitArrayIsCalled() {
		arabicNumeralConverter.arabicNumeral = 1666;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals(1, arabicNumeralConverter.digitArray[0]);
		assertEquals(6, arabicNumeralConverter.digitArray[1]);
		assertEquals(6, arabicNumeralConverter.digitArray[2]);
		assertEquals(6, arabicNumeralConverter.digitArray[3]);
	}
	
	@Test
	public void testCurrentDigitPlaceValueWhenPlaceValueShouldBe100() {
		arabicNumeralConverter.arabicNumeral = 1693;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 1;
		assertEquals(100, arabicNumeralConverter.currentDigitPlaceValue());
	}
	
	@Test
	public void testCurrentDigitPlaceValueForAllValues() {
		arabicNumeralConverter.arabicNumeral = 1693;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
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
		arabicNumeralConverter.arabicNumeral = 2109;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 3;
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenation();
		assertEquals("IX", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenationWhen9IsInTensPlace() {
		arabicNumeralConverter.arabicNumeral = 2190;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 2;
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenation();
		assertEquals("XC", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenationWhen9IsInHundredsPlace() {
		arabicNumeralConverter.arabicNumeral = 2910;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 1;
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenation();
		assertEquals("CM", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenationWhenCurrentDigitPlaceValueIsOnes() {
		arabicNumeralConverter.arabicNumeral = 1396;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 3;
		arabicNumeralConverter.currentDigitPlaceValue();
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("VI", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenationWhenCurrentDigitPlaceValueIsTens() {
		arabicNumeralConverter.arabicNumeral = 1376;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 2;
		arabicNumeralConverter.currentDigitPlaceValue();
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("LXX", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenationWhenCurrentDigitPlaceValueIsHundreds() {
		arabicNumeralConverter.arabicNumeral = 1836;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 1;
		arabicNumeralConverter.currentDigitPlaceValue();
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("DCCC", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenationWhen4IsInOnesPlace() {
		arabicNumeralConverter.arabicNumeral = 1394;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 3;
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenation();
		assertEquals("IV", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenationWhen4IsInTensPlace() {
		arabicNumeralConverter.arabicNumeral = 1348;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 2;
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenation();
		assertEquals("XL", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenationWhen4IsInHundredsPlace() {
		arabicNumeralConverter.arabicNumeral = 1458;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 1;
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenation();
		assertEquals("CD", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenationWhenDigitIsInOnesPlace() {
		arabicNumeralConverter.arabicNumeral = 1693;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 3;
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("III", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenationWhenDigitIsInTensPlace() {
		arabicNumeralConverter.arabicNumeral = 1624;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 2;
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("XX", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void testIfCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenationWhenDigitIsInHundredsPlace() {
		arabicNumeralConverter.arabicNumeral = 1154;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		arabicNumeralConverter.currentDigitIndex = 1;
		arabicNumeralConverter.romanNumeralConcatenation = "";
		arabicNumeralConverter.ifCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenation();
		assertEquals("C", arabicNumeralConverter.romanNumeralConcatenation);
	}
	
	@Test
	public void returnMDCLXVIifArabicNumeralIs1666AndReturnArabicNumeralConvertedToRomanNumeralMethodIsCalled() {
		arabicNumeralConverter.arabicNumeral = 1666;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals("MDCLXVI", arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());
	}
	
	@Test
	public void returnMMMCMXCIXifArabicNumeralIs3999AndReturnArabicNumeralConvertedToRomanNumeralMethodIsCalled() {
		arabicNumeralConverter.arabicNumeral = 3999;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals("MMMCMXCIX", arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());		
	}

	@Test
	public void returnIifArabicNumeralIs1AndReturnArabicNumeralConvertedToRomanNumeralMethodIsCalled() {
		arabicNumeralConverter.arabicNumeral = 1;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals("I", arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());		
	}

	@Test
	public void returnMCMXLVIIifArabicNumeralIs1947AndReturnArabicNumeralConvertedToRomanNumeralMethodIsCalled() {
		arabicNumeralConverter.arabicNumeral = 1947;
		arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
		assertEquals("MCMXLVII", arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());		
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIs1() {
		assertTrue(arabicNumeralConverter.returnFalseIfUserInputIsNotAnIntBetween1And3999("1"));	
		assertEquals(1, arabicNumeralConverter.arabicNumeral);		
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIsME262() {
		assertFalse(arabicNumeralConverter.returnFalseIfUserInputIsNotAnIntBetween1And3999("ME262"));	
		assertEquals(0, arabicNumeralConverter.arabicNumeral);		
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIs3999() {
		assertTrue(arabicNumeralConverter.returnFalseIfUserInputIsNotAnIntBetween1And3999("3999"));	
		assertEquals(3999, arabicNumeralConverter.arabicNumeral);		
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIs4000() {
		assertFalse(arabicNumeralConverter.returnFalseIfUserInputIsNotAnIntBetween1And3999("4000"));	
		assertEquals(0, arabicNumeralConverter.arabicNumeral);		
	}
	
	@Test
	public void testVerifyInputIsArabicNumeralBetween1And3999WhenUserInputIs0() {
		assertEquals(0, arabicNumeralConverter.arabicNumeral);		
		assertFalse(arabicNumeralConverter.returnFalseIfUserInputIsNotAnIntBetween1And3999("0"));	
	}
}
