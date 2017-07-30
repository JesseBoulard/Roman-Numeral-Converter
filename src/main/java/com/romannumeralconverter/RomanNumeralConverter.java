package com.romannumeralconverter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanNumeralConverter {

	private static final Map<String, Integer> CONVERT_TO_ARABIC_DIGIT = createMapOfRomanToArabicNumerals();
	protected String romanNumeral;
	protected String[] romanNumeralSymbolArray;
	protected int currentSymbolIndex;
	protected int valueOfCurrentSymbol;
	protected int valueOfNextSymbol;
	protected int valueToSubtractFromCurrentSymbol;
	protected int arabicNumeral;
	protected boolean isValid;
	protected String userInput;

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

	protected void splitRomanNumeralIntoRomanNumeralSymbolArray() {
		romanNumeralSymbolArray = romanNumeral.split("");
	}

	protected void calcValueOfCurrentSymbol() {
		valueOfCurrentSymbol = valueOf(romanNumeralSymbolArray[currentSymbolIndex]);
	}


	protected void calcValueOfNextSymbol()
	{
		if (currentSymbolIndex == romanNumeralSymbolArray.length - 1)
		{
			valueOfNextSymbol = 0;
		}
		else
		{
			valueOfNextSymbol = valueOf(romanNumeralSymbolArray[currentSymbolIndex + 1]);
		}
	}

	protected int returnRomanNumeralConvertedToArabicNumeral()
	{
		arabicNumeral = 0;
		for (currentSymbolIndex = 0; currentSymbolIndex < romanNumeralSymbolArray.length; currentSymbolIndex++)
		{
			calcValueOfCurrentSymbol();
			calcValueOfNextSymbol();
			if (valueOfCurrentSymbol < valueOfNextSymbol)
			{
				valueToSubtractFromCurrentSymbol = valueOfCurrentSymbol;
			}
			else
			{
				arabicNumeral += (valueOfCurrentSymbol - valueToSubtractFromCurrentSymbol);
				valueToSubtractFromCurrentSymbol = 0;
			}
		}
		return arabicNumeral;
	}

	protected void setIsValidToFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4() 
	{
		for (currentSymbolIndex = 0; currentSymbolIndex < romanNumeralSymbolArray.length - 1; currentSymbolIndex++)
		{
			if (valueOf(romanNumeralSymbolArray[currentSymbolIndex]) < valueOf(romanNumeralSymbolArray[currentSymbolIndex + 1]) && 
					valueOf(romanNumeralSymbolArray[currentSymbolIndex + 1]) / valueOf(romanNumeralSymbolArray[currentSymbolIndex]) != 10 &&
					valueOf(romanNumeralSymbolArray[currentSymbolIndex + 1]) / valueOf(romanNumeralSymbolArray[currentSymbolIndex]) != 5)
			{
				isValid = false;
			}
		}
	}

	protected void setIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow()
	{
		for (int i = 0; i < romanNumeralSymbolArray.length - 1; i++)
		{
			if (romanNumeralSymbolArray[i].equals(romanNumeralSymbolArray[i + 1]) && Integer.toString(valueOf(romanNumeralSymbolArray[i])).charAt(0) == '5')
			{
				isValid = false;
			}
		}
	}

	protected void setIsValidToFalseIfMoreThanThreeRomanNumeralsAreInARow()
	{
		for (int i = 0; i < romanNumeralSymbolArray.length - 3; i++)
		{
			if (romanNumeralSymbolArray[i].equals(romanNumeralSymbolArray[i + 1]) && romanNumeralSymbolArray[i].equals(romanNumeralSymbolArray[i + 2]) && 
					romanNumeralSymbolArray[i].equals(romanNumeralSymbolArray[i + 3]))
			{
				isValid = false;
			}
		}
	}

	protected void setIsValidToFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral()
	{
		for (int i = 0; i < romanNumeralSymbolArray.length - 2; i++)
		{
			if (romanNumeralSymbolArray[i].equals(romanNumeralSymbolArray[i + 1]) && valueOf(romanNumeralSymbolArray[i + 2]) > valueOf(romanNumeralSymbolArray[i + 1]))
			{
				isValid = false;
			}
		}
	}

	protected void setIsValidToFalseIfSymbolIsNotRomanNumeralSymbol()
	{
		try
		{
			for (currentSymbolIndex = 0; currentSymbolIndex < romanNumeralSymbolArray.length; currentSymbolIndex++)
			{
				calcValueOfCurrentSymbol();
			}
		}
		catch (Exception e)
		{
			isValid = false;
		}
	}


	protected boolean isValidRomanNumeral()
	{
		isValid = true;
		setIsValidToFalseIfSymbolIsNotRomanNumeralSymbol();
		if (isValid == true)
		{
			setIsValidToFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4();
		}
		if (isValid == true)
		{
			setIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow();
		}
		if (isValid == true)
		{
			setIsValidToFalseIfMoreThanThreeRomanNumeralsAreInARow();
		}
		if (isValid == true)
		{
			setIsValidToFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral();
		}
		return isValid;
	}

	protected void promptUserForARomanNumeral()
	{
		System.out.println("Please enter a Roman numeral to convert to an Arabic numeral. Enter q to to quit.");
		Scanner scnr = new Scanner(System.in);
		userInput = scnr.next();
		romanNumeral = userInput.toUpperCase();
		if (romanNumeral.charAt(0) == 'Q')
		{
			RomanNumeralConverterApp romanNumeralConverterApp = new RomanNumeralConverterApp();
			return;
		}
		splitRomanNumeralIntoRomanNumeralSymbolArray();
		if (isValidRomanNumeral())
		{
			System.out.println(romanNumeral + " is equal to " + returnRomanNumeralConvertedToArabicNumeral());
			promptUserForARomanNumeral();
		}
		else
		{
			System.out.println("Roman numeral is invalid!");
			promptUserForARomanNumeral();
		}
	}

}
