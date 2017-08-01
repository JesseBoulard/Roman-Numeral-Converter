package jesseboulard.romannumeralconverter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArabicNumeralConverter {
	protected static final Map<Integer, String> CONVERT_TO_ROMAN_NUMERAL_SYMBOL = createMapOfArabicToRomanNumerals();
	protected int[] digitArray;
	protected int currentDigitIndex;
	protected int nextDigitPlaceValue;

	private static Map<Integer, String> createMapOfArabicToRomanNumerals() 
	{
		Map<Integer, String> convertToRomanNumeral = new HashMap<Integer, String>();
		convertToRomanNumeral.put(1, "I");
		convertToRomanNumeral.put(5, "V");
		convertToRomanNumeral.put(10, "X");
		convertToRomanNumeral.put(50, "L");
		convertToRomanNumeral.put(100, "C");
		convertToRomanNumeral.put(500, "D");
		convertToRomanNumeral.put(1000, "M");
		return Collections.unmodifiableMap(convertToRomanNumeral);
	}

	protected String romanNumeralSymbolFor(int arabicNumeral) {
		return CONVERT_TO_ROMAN_NUMERAL_SYMBOL.get(arabicNumeral);
	}

	protected void splitArabicNumeralIntoDigitArray(String arabicNumeral) { 
		String[] digitArrayAsString = arabicNumeral.split("");
		digitArray = new int[digitArrayAsString.length];
		for (int i = 0; i < digitArray.length; i++)
		{
			digitArray[i] = Integer.parseInt(digitArrayAsString[i]);
		}
	}
	
	protected int currentDigitPlaceValue()
	{
		if (currentDigitIndex == digitArray.length - 1)
		{
			nextDigitPlaceValue = 10;
		}
		else if (currentDigitIndex == digitArray.length - 2)
		{
			nextDigitPlaceValue = 100;
		}
		else if (currentDigitIndex == digitArray.length - 3)
		{
			nextDigitPlaceValue = 1000;
		}
		else if (currentDigitIndex == digitArray.length - 4)
		{
			nextDigitPlaceValue = 10000;
		}
		else
		{
			nextDigitPlaceValue = 0;
		}
		return nextDigitPlaceValue / 10;
	}

	protected String returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsA9(String romanNumeralConcatenation) {
		if (digitArray[currentDigitIndex] == 9)
		{
			romanNumeralConcatenation += romanNumeralSymbolFor(currentDigitPlaceValue());
			romanNumeralConcatenation += romanNumeralSymbolFor(nextDigitPlaceValue);
		}
		return romanNumeralConcatenation;
	}

	protected String returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsLessThan9AndGreaterThanOrEqualTo5(String romanNumeralConcatenation) {
		if (digitArray[currentDigitIndex] >= 5 && digitArray[currentDigitIndex] < 9)
		{
			int currentDigitPlaceValue = currentDigitPlaceValue();
			romanNumeralConcatenation += romanNumeralSymbolFor(nextDigitPlaceValue / 2);
			for (int i = 0; i < (digitArray[currentDigitIndex] - 5); i++)
			{
				romanNumeralConcatenation += romanNumeralSymbolFor(currentDigitPlaceValue);
			}
		}
		return romanNumeralConcatenation;
	}

	protected String returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsA4(String romanNumeralConcatenation)
	{
		if (digitArray[currentDigitIndex] == 4)
		{
			romanNumeralConcatenation += romanNumeralSymbolFor(currentDigitPlaceValue());
			romanNumeralConcatenation += romanNumeralSymbolFor(nextDigitPlaceValue / 2);
		}
		return romanNumeralConcatenation;
	}

	protected String returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsLessThan4(String romanNumeralConcatenation)
	{
		if (digitArray[currentDigitIndex] < 4)
		{
			for (int i = 0; i < digitArray[currentDigitIndex]; i++)
			{
				romanNumeralConcatenation += romanNumeralSymbolFor(currentDigitPlaceValue());
			}
		}
		return romanNumeralConcatenation;
	}

	protected String returnArabicNumeralConvertedToRomanNumeral() {
		String romanNumeralConcatenation = "";
		for (currentDigitIndex = 0; currentDigitIndex < digitArray.length; currentDigitIndex++)
		{
			romanNumeralConcatenation = returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsA9(romanNumeralConcatenation);
			romanNumeralConcatenation = returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsLessThan9AndGreaterThanOrEqualTo5(romanNumeralConcatenation);
			romanNumeralConcatenation = returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsA4(romanNumeralConcatenation);
			romanNumeralConcatenation = returnConcatenationOfRomanNumeralEquivalentOfCurrentDigitIfItIsLessThan4(romanNumeralConcatenation);
		}
		return romanNumeralConcatenation;
	}

	protected boolean returnTrueIfUserInputIsAnIntBetween1And3999(String userInput)
	{
		int arabicNumeral = 0;
		boolean isValid = true;
		arabicNumeral = Integer.parseInt(userInput);
		if (arabicNumeral < 1 || arabicNumeral > 3999)
		{
			arabicNumeral = 0;
			isValid = false;
		}
		return isValid;
	}

	protected boolean returnFalseIfUserInputIsNotAnIntBetween1And3999(String userInput)
	{
		boolean isValid = false;
		try
		{
			if (returnTrueIfUserInputIsAnIntBetween1And3999(userInput))
			{
				isValid = true;
			}
		}
		catch (Exception e)
		{
			isValid = false;
		}
		return isValid;
	}
}
