package com.romannumeralconverter;

import java.util.Scanner;

public class RomanNumeralConverterApp {
	
	protected int whichConverter;
	
	public RomanNumeralConverterApp()
	{
		promptUserForWhichTypeOfNumeralToConvert();
	}
	public static void main(String[] args)
	{
		RomanNumeralConverterApp romanNumeralConverterApp = new RomanNumeralConverterApp();
	}
	
	protected void promptUserForWhichTypeOfNumeralToConvert()
	{
		System.out.println("If you would like to convert a Roman numeral to an Arabic numeral, enter: 1");
		System.out.println("If you would like to convert a Arabic numeral to an Roman numeral, enter: 2");
		System.out.println("To quit enter: 3");
		Scanner scnr = new Scanner(System.in);
		whichConverter = scnr.nextInt();
		attemptToConvertNumeralOfTypeSelected();
	}
	
	protected void convertRomanNumeral()
	{
		RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
		romanNumeralConverter.promptUserForARomanNumeral();
	}
	
	protected void convertArabicNumeral()
	{
		ArabicNumeralConverter arabicNumeralConverter = new ArabicNumeralConverter();
		arabicNumeralConverter.promptUserForAnArabicNumeral();
	}
	
	protected void attemptToConvertNumeralOfTypeSelected()
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
