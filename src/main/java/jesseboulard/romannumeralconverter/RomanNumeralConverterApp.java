package jesseboulard.romannumeralconverter;

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
	
	protected void promptUserForARomanNumeral()
	{
		RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
		System.out.println("Please enter a Roman numeral to convert to an Arabic numeral. Enter q to to quit.");
		Scanner scnr = new Scanner(System.in);
		romanNumeralConverter.userInput = scnr.next();
		romanNumeralConverter.romanNumeral = romanNumeralConverter.userInput.toUpperCase();
		if (romanNumeralConverter.romanNumeral.charAt(0) == 'Q')
		{
			RomanNumeralConverterApp romanNumeralConverterApp = new RomanNumeralConverterApp();
			return;
		}
		romanNumeralConverter.splitRomanNumeralIntoRomanNumeralSymbolArray();
		if (romanNumeralConverter.isValidRomanNumeral())
		{
			System.out.println(romanNumeralConverter.romanNumeral + " is equal to " + romanNumeralConverter.returnRomanNumeralConvertedToArabicNumeral());
			promptUserForARomanNumeral();
		}
		else
		{
			System.out.println("Roman numeral is invalid!");
			promptUserForARomanNumeral();
		}
	}

	protected void promptUserForAnArabicNumeral()
	{
		ArabicNumeralConverter arabicNumeralConverter = new ArabicNumeralConverter();
		System.out.println("Please enter a Arabic numeral to convert to a Roman numeral. Enter q to to quit.");
		Scanner scnr = new Scanner(System.in);
		arabicNumeralConverter.userInput = scnr.next();
		arabicNumeralConverter.setIsValidToFalseIfUserInputIsNotAnIntBetween1And3999();
		if (arabicNumeralConverter.userInput.charAt(0) == 'q')
		{
			RomanNumeralConverterApp romanNumeralConverterApp = new RomanNumeralConverterApp();
			return;
		}
		if (arabicNumeralConverter.isValid)
		{
			arabicNumeralConverter.splitArabicNumeralIntoDigitArray();
			System.out.println(arabicNumeralConverter.arabicNumeral + " is equal to " + arabicNumeralConverter.returnArabicNumeralConvertedToRomanNumeral());
			promptUserForAnArabicNumeral();
		}
		else
		{
			System.out.println("Arabic numeral is invalid!");
			promptUserForAnArabicNumeral();
		}
	}
	
	protected void attemptToConvertNumeralOfTypeSelected()
	{
		if (whichConverter == 1)
		{
			promptUserForARomanNumeral();
		}
		else if (whichConverter == 2)
		{
			promptUserForAnArabicNumeral();
		}
		else
		{
			System.out.println("Goodbye");
		}
	}	
}
