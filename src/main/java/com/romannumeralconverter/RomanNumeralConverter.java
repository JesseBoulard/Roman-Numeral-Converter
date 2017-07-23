package com.romannumeralconverter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanNumeralConverter {

	private static final Map<String, Integer> CONVERT_TO_ARABIC_DIGIT = createMapOfRomanToArabicNumerals();
	private String romanNumeral;
	private String[] romanNumeralSymbolArray;
	private int currentSymbolIndex;
	private int valueOfCurrentSymbol;
	private int valueOfNextSymbol;
	private int valueToSubtractFromCurrentSymbol;
	private int arabicNumeral;
	private boolean isValid;

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

	public int valueOf(String romanNumeralSymbol) {
		return CONVERT_TO_ARABIC_DIGIT.get(romanNumeralSymbol);
	}

	public void splitRomanNumeralIntoRomanNumeralSymbolArray() {
		romanNumeralSymbolArray = romanNumeral.split("");
	}

	public void calcValueOfCurrentSymbol() {
		valueOfCurrentSymbol = valueOf(romanNumeralSymbolArray[currentSymbolIndex]);
	}


	public void calcValueOfNextSymbol()
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

	public int returnRomanNumeralConvertedToArabicNumeral()
	{
		arabicNumeral = 0;
		for (currentSymbolIndex = 0; currentSymbolIndex < romanNumeralSymbolArray.length; currentSymbolIndex++)
		{
			calcValueOfCurrentSymbol();
			calcValueOfNextSymbol();
			if (valueOfCurrentSymbol < getValueOfNextSymbol())
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

	public void setIsValidToFalseIfARomanNumeralSymbolIsProceededByAHigherSymbolExceptWhenBothSymbolsCombineToMakeA9OrA4() 
	{
		for (int i = 0; i < romanNumeralSymbolArray.length - 1; i++)
		{
			if (valueOf(romanNumeralSymbolArray[i]) < valueOf(romanNumeralSymbolArray[i + 1]) && 
					Integer.toString((valueOf(romanNumeralSymbolArray[i + 1]) - valueOf(romanNumeralSymbolArray[i]))).charAt(0) != '9' &&
					Integer.toString((valueOf(romanNumeralSymbolArray[i + 1]) - valueOf(romanNumeralSymbolArray[i]))).charAt(0) != '4')
			{
				isValid = false;
			}
		}
	}

	public void setIsValidToFalseIfARomanNumeralSymbolWithAValueStartingWith5AppearsTwiceInARow()
	{
		for (int i = 0; i < romanNumeralSymbolArray.length - 1; i++)
		{
			if (romanNumeralSymbolArray[i].equals(romanNumeralSymbolArray[i + 1]) && Integer.toString(valueOf(romanNumeralSymbolArray[i])).charAt(0) == '5')
			{
				isValid = false;
			}
		}
	}

	public void setIsValidToFalseIfMoreThanThreeRomanNumeralsAreInARow()
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

	public void setIsValidToFalseIfMoreThanOneRomanNumeralIsSubtractedFromAProceedingHigherNumeral() 
	{
		isValid = false;	
	}
	
	//************************************setters and getters****************************************

	public String getRomanNumeral() {
		return romanNumeral;
	}

	public void setRomanNumeral(String romanNumeral) {
		this.romanNumeral = romanNumeral;
	}

	public String[] getRomanNumeralSymbolArray() {
		return romanNumeralSymbolArray;
	}

	public int getCurrentSymbolIndex() {
		return currentSymbolIndex;
	}

	public void setCurrentSymbolIndex(int currentSymbolIndex) {
		this.currentSymbolIndex = currentSymbolIndex;
	}

	public int getValueOfCurrentSymbol() {
		return valueOfCurrentSymbol;
	}

	public int getValueOfNextSymbol() {
		return valueOfNextSymbol;
	}

	public boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

}
