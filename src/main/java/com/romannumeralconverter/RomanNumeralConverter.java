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

}
