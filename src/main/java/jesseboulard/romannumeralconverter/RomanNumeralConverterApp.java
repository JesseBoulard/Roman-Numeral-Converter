package jesseboulard.romannumeralconverter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RomanNumeralConverterApp {

	private int whichConverter;
	private String userInput;

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
		attemptToConvertNumeralOfTypeSelected();
	}

	private void promptUserForARomanNumeral()
	{
		RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
		System.out.println("Please enter a Roman numeral to convert to an Arabic numeral. Enter q to to quit.");
		Scanner scnr = new Scanner(System.in);
		userInput = scnr.next();
		romanNumeralConverter.romanNumeral = userInput.toUpperCase();
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

	private void promptUserForAnArabicNumeral()
	{
		ArabicNumeralConverter arabicNumeralConverter = new ArabicNumeralConverter();
		System.out.println("Please enter a Arabic numeral to convert to a Roman numeral. Enter q to to quit.");
		Scanner scnr = new Scanner(System.in);
		userInput = scnr.next();
		if (userInput.charAt(0) == 'q')
		{
			RomanNumeralConverterApp romanNumeralConverterApp = new RomanNumeralConverterApp();
			return;
		}
		if (arabicNumeralConverter.returnFalseIfUserInputIsNotAnIntBetween1And3999(userInput))
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

	private void convertNumeralOfTypeSelected()
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

	private void attemptToConvertNumeralOfTypeSelected()
	{
		Scanner scnr = new Scanner(System.in);
		try
		{
			whichConverter = scnr.nextInt();
			convertNumeralOfTypeSelected();	
		}
		catch (InputMismatchException e)
		{
			System.out.println("Invalid input!");
			promptUserForWhichTypeOfNumeralToConvert();
		}
	}
}
