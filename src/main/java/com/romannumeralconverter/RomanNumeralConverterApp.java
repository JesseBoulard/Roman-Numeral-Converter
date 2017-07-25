package com.romannumeralconverter;

import java.util.Scanner;

public class RomanNumeralConverterApp {
	
	private int whichConverter;
	
	public RomanNumeralConverterApp()
	{
		promptUserForWhichTypeOfNumeralToConvert();
	}
	public static void main(String[] args)
	{
		RomanNumeralConverterApp romanNumeralConverterApp = new RomanNumeralConverterApp();
	}
	
	private void promptUserForWhichTypeOfNumeralToConvert()
	{
		System.out.println("If you would like to convert a Roman numeral to an Arabic numeral, enter: 1");
		System.out.println("If you would like to convert a Arabic numeral to an Roman numeral, enter: 2");
		System.out.println("To quit enter: 3");
		Scanner scnr = new Scanner(System.in);
		whichConverter = scnr.nextInt();
		attemptToConvertNumeralOfTypeSelected();
	}
	
	public void convertRomanNumeral()
	{
		RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
		romanNumeralConverter.promptUserForARomanNumeral();
	}
	
	public void convertArabicNumeral()
	{
		ArabicNumeralConverter arabicNumeralConverter = new ArabicNumeralConverter();
		arabicNumeralConverter.promptUserForAnArabicNumeral();
	}
	
	public void attemptToConvertNumeralOfTypeSelected()
	{
		if (whichConverter == 1)
		{
			convertRomanNumeral();
		}
		else if (whichConverter == 2)
		{
			convertArabicNumeral();
		}
		else
		{
			System.out.println("Goodbye");
		}
	}	
}
