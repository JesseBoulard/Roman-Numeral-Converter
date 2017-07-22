package com.romannumeralconverter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {

	private static final Map<Integer, String> CONVERT_TO_ROMAN_NUMERAL_SYMBOL = createMapOfArabicToRomanNumerals();
	
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
	
	private int arabicNumeral;
	private int[] digitArray;
	private int currentDigitIndex;
	
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
}
