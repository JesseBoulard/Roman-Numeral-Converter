package com.romannumeralconverter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArabicNumeralConverter {
	private static final Map<Integer, String> CONVERT_TO_ROMAN_NUMERAL_SYMBOL = createMapOfArabicToRomanNumerals();
	private int arabicNumeral;
	private int[] digitArray;
	private int currentDigitIndex;
	private int currentDigitValue;
	private int nextDigitPlaceValue;
	private String romanNumeralConcatenation;
	private String userInput;
	private boolean isValid;

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

	public void splitArabicNumeralIntoDigitArray() { 
		String[] digitArrayAsString = Integer.toString(arabicNumeral).split("");
		digitArray = new int[digitArrayAsString.length];
		for (int i = 0; i < digitArray.length; i++)
		{
			digitArray[i] = Integer.parseInt(digitArrayAsString[i]);
		}
	}

	public int currentDigitPlaceValue()
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

	public void ifCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenation() {
		if (digitArray[currentDigitIndex] == 9)
		{
			romanNumeralConcatenation += romanNumeralSymbolFor(currentDigitPlaceValue());
			romanNumeralConcatenation += romanNumeralSymbolFor(nextDigitPlaceValue);
		}
	}

	public void ifCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenation() {
		if (digitArray[currentDigitIndex] >= 5 && digitArray[currentDigitIndex] < 9)
		{
			int currentDigitPlaceValue = currentDigitPlaceValue();
			romanNumeralConcatenation += romanNumeralSymbolFor(nextDigitPlaceValue / 2);
			for (int i = 0; i < (digitArray[currentDigitIndex] - 5); i++)
			{
				romanNumeralConcatenation += romanNumeralSymbolFor(currentDigitPlaceValue);
			}
		}
	}

	public void ifCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenation()
	{
		if (digitArray[currentDigitIndex] == 4)
		{
			romanNumeralConcatenation += romanNumeralSymbolFor(currentDigitPlaceValue());
			romanNumeralConcatenation += romanNumeralSymbolFor(nextDigitPlaceValue / 2);
		}
	}

	public void ifCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenation()
	{
		if (digitArray[currentDigitIndex] < 4)
		{
			for (int i = 0; i < digitArray[currentDigitIndex]; i++)
			{
				romanNumeralConcatenation += romanNumeralSymbolFor(currentDigitPlaceValue());
			}
		}
	}

	public String returnArabicNumeralConvertedToRomanNumeral() {
		romanNumeralConcatenation = "";
		for (currentDigitIndex = 0; currentDigitIndex < digitArray.length; currentDigitIndex++)
		{
			ifCurrentDigitIsA9Add9EquivalentToRomanNumeralConcatenation();
			ifCurrentDigitIsLessThan9AndGreaterThanOrEqualTo5AddDigitEquivalentToRomanNumeralConcatenation();
			ifCurrentDigitIsA4Add4EquivalentToRomanNumeralConcatenation();
			ifCurrentDigitIsLessThan4AddDigitEquivalentToRomanNumeralConcatenation();
		}
		return romanNumeralConcatenation;
	}

	public void setIsValidToTrueIfUserInputIsAnIntBetween1And3999()
	{
		arabicNumeral = 0;
		isValid = true;
		arabicNumeral = Integer.parseInt(userInput);
		if (arabicNumeral < 1 || arabicNumeral > 3999)
		{
			arabicNumeral = 0;
			isValid = false;
		}
	}

	public void setIsValidToFalseIfUserInputIsNotAnIntBetween1And3999()
	{
		try
		{
			setIsValidToTrueIfUserInputIsAnIntBetween1And3999();
		}
		catch (Exception e)
		{
			isValid = false;
		}
	}

	public void promptUserForAnArabicNumeral()
	{
		System.out.println("Please enter a Arabic numeral to convert to a Roman numeral. Enter q to to quit.");
		Scanner scnr = new Scanner(System.in);
		userInput = scnr.next();
		setIsValidToFalseIfUserInputIsNotAnIntBetween1And3999();
		if (userInput.charAt(0) == 'q')
		{
			RomanNumeralConverterApp romanNumeralConverterApp = new RomanNumeralConverterApp();
			return;
		}
		if (isValid)
		{
			splitArabicNumeralIntoDigitArray();
			System.out.println(arabicNumeral + " is equal to " + returnArabicNumeralConvertedToRomanNumeral());
			promptUserForAnArabicNumeral();
		}
		else
		{
			System.out.println("Arabic numeral is invalid!");
			promptUserForAnArabicNumeral();
		}
	}



	public void promptUserAgain()
	{
		setIsValidToFalseIfUserInputIsNotAnIntBetween1And3999();
		if (isValid)
		{
			System.out.println(arabicNumeral + " is equal to " + returnArabicNumeralConvertedToRomanNumeral());
		}
		else
		{
			promptUserForAnArabicNumeral();
			promptUserAgain();
		}
	}

	//************************************ setters and getters *********************************************
	public int getArabicNumeral() {
		return arabicNumeral;
	}

	public void setArabicNumeral(int arabicNumeral) {
		this.arabicNumeral = arabicNumeral;
	}

	public int[] getDigitArray() {
		return digitArray;
	}

	public int getCurrentDigitIndex() {
		return currentDigitIndex;
	}

	public void setCurrentDigitIndex(int currentDigitIndex) {
		this.currentDigitIndex = currentDigitIndex;
	}

	public int getCurrentDigitValue() {
		return currentDigitValue;
	}

	public void setCurrentDigitValue(int currentDigitValue) {
		this.currentDigitValue = currentDigitValue;
	}

	public String getRomanNumeralConcatenation() {
		return romanNumeralConcatenation;
	}

	public void setRomanNumeralConcatenation(String romanNumeralConcatenation) {
		this.romanNumeralConcatenation = romanNumeralConcatenation;
	}

	public boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getUserInput() {
		return userInput;
	}

	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}
}
