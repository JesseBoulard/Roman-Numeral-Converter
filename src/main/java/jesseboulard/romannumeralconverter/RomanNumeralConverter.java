package jesseboulard.romannumeralconverter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanNumeralConverter {

	private static final Map<String, Integer> CONVERT_TO_ARABIC_DIGIT = createMapOfRomanToArabicNumerals();
	protected String[] romanNumeralSymbolArray;
	protected int currentSymbolIndex;

	private static Map<String, Integer> createMapOfRomanToArabicNumerals() 
	{
		Map<String, Integer> convertToArabicNumeral = new HashMap<String, Integer>();
		convertToArabicNumeral.put("I", 1);
		convertToArabicNumeral.put("V", 5);
		convertToArabicNumeral.put("X", 10);
		convertToArabicNumeral.put("L", 50);
		convertToArabicNumeral.put("C", 100);
		convertToArabicNumeral.put("D", 500);
		convertToArabicNumeral.put("M", 1000);
		return Collections.unmodifiableMap(convertToArabicNumeral);
	}

	protected int valueOf(String romanNumeralSymbol) {
		return CONVERT_TO_ARABIC_DIGIT.get(romanNumeralSymbol);
	}

	protected void splitRomanNumeralIntoRomanNumeralSymbolArray(String romanNumeral) {
		romanNumeralSymbolArray = romanNumeral.split("");
	}

	protected int valueOfCurrentSymbol() {
		return valueOf(romanNumeralSymbolArray[currentSymbolIndex]);
	}


	protected int valueOfNextSymbol()
	{
		int valueOfNextSymbol = 0;
		if (currentSymbolIndex == romanNumeralSymbolArray.length - 1)
		{
			valueOfNextSymbol = 0;
		}
		else
		{
			valueOfNextSymbol = valueOf(romanNumeralSymbolArray[currentSymbolIndex + 1]);
		}
		return valueOfNextSymbol;
	}

	protected int returnRomanNumeralConvertedToArabicNumeral()
	{
		int arabicNumeral = 0;
		int valueToSubtract = 0;
		for (currentSymbolIndex = 0; currentSymbolIndex < romanNumeralSymbolArray.length; currentSymbolIndex++)
		{
			if (valueOfCurrentSymbol() < valueOfNextSymbol())
			{
				valueToSubtract = valueOfCurrentSymbol();
			}
			else
			{
				arabicNumeral += (valueOfCurrentSymbol() - valueToSubtract);
				valueToSubtract = 0;
			}
		}
		return arabicNumeral;
	}

	protected boolean returnFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4() 
	{
		boolean isValid = true;
		for (currentSymbolIndex = 0; currentSymbolIndex < romanNumeralSymbolArray.length - 1; currentSymbolIndex++)
		{
			if (valueOf(romanNumeralSymbolArray[currentSymbolIndex]) < valueOf(romanNumeralSymbolArray[currentSymbolIndex + 1]) && 
					valueOf(romanNumeralSymbolArray[currentSymbolIndex + 1]) / valueOf(romanNumeralSymbolArray[currentSymbolIndex]) != 10 &&
					valueOf(romanNumeralSymbolArray[currentSymbolIndex + 1]) / valueOf(romanNumeralSymbolArray[currentSymbolIndex]) != 5)
			{
				isValid = false;
			}
		}
		return isValid;
	}

	protected boolean returnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow()
	{
		boolean isValid = true;
		for (int i = 0; i < romanNumeralSymbolArray.length - 1; i++)
		{
			if (romanNumeralSymbolArray[i].equals(romanNumeralSymbolArray[i + 1]) && Integer.toString(valueOf(romanNumeralSymbolArray[i])).charAt(0) == '5')
			{
				isValid = false;
			}
		}
		return isValid;
	}

	protected boolean returnFalseIfMoreThanThreeRomanNumeralsAreInARow()
	{
		boolean isValid = true;
		for (int i = 0; i < romanNumeralSymbolArray.length - 3; i++)
		{
			if (romanNumeralSymbolArray[i].equals(romanNumeralSymbolArray[i + 1]) && romanNumeralSymbolArray[i].equals(romanNumeralSymbolArray[i + 2]) && 
					romanNumeralSymbolArray[i].equals(romanNumeralSymbolArray[i + 3]))
			{
				isValid = false;
			}
		}
		return isValid;
	}

	protected boolean returnFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral()
	{
		boolean isValid = true;
		for (int i = 0; i < romanNumeralSymbolArray.length - 2; i++)
		{
			if (romanNumeralSymbolArray[i].equals(romanNumeralSymbolArray[i + 1]) && valueOf(romanNumeralSymbolArray[i + 2]) > valueOf(romanNumeralSymbolArray[i + 1]))
			{
				isValid = false;
			}
		}
		return isValid;
	}

	protected boolean returnFalseIfSymbolIsNotRomanNumeralSymbol()
	{
		boolean isValid = true;
		try
		{
			for (currentSymbolIndex = 0; currentSymbolIndex < romanNumeralSymbolArray.length; currentSymbolIndex++)
			{
				valueOfCurrentSymbol();
			}
		}
		catch (Exception e)
		{
			isValid = false;
		}
		return isValid;
	}


	protected boolean isValidRomanNumeral()
	{
		boolean isValid = true;
		
		if (returnFalseIfSymbolIsNotRomanNumeralSymbol() &&
				returnFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4() &&
				returnFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow() &&	
				returnFalseIfMoreThanThreeRomanNumeralsAreInARow() &&
				returnFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral())
		{
			isValid = true;
		}
		else
		{
			isValid = false;
		}
		return isValid;
	}
}
