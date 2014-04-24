package com.ppahare.utils.stringutil;

import java.util.Locale;
import java.util.Random;

import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.LocaleData;
import com.ibm.icu.util.ULocale;


public class RandomStringGenerator {
	
	private Locale locale;
	private int length;
	private boolean allowSpaces;
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isAllowSpaces() {
		return allowSpaces;
	}

	public void setAllowSpaces(boolean allowSpaces) {
		this.allowSpaces = allowSpaces;
	}

	public boolean isAllowSpecialCharacters() {
		return allowSpecialCharacters;
	}

	public void setAllowSpecialCharacters(boolean allowSpecialCharacters) {
		this.allowSpecialCharacters = allowSpecialCharacters;
	}

	public boolean isAllowNumbers() {
		return allowNumbers;
	}

	public void setAllowNumbers(boolean allowNumbers) {
		this.allowNumbers = allowNumbers;
	}

	private boolean allowSpecialCharacters;
	private boolean allowNumbers;

	public RandomStringGenerator(Locale locale,
								int len, 
								boolean allowSpaces,
								boolean allowSpecialCharacters,
								boolean allowNumbers) {
		this.locale = locale;
		this.length = len;
		this.allowSpaces = allowSpaces;
		this.allowSpecialCharacters = allowSpecialCharacters;
		this.allowNumbers = allowNumbers;
	}
	
	public String getRandomString() {
		ULocale ulocale = ULocale.forLocale(locale);
		UnicodeSet alphabet = LocaleData.getExemplarSet(ulocale, 1);
		int alphabetSize = alphabet.size();
		Random rand = new Random();
		String randomString = "";
		for(int i=0; i<length; i++) {
			int charAt = rand.nextInt(alphabetSize);
			int r =alphabet.charAt(charAt);
			randomString += new String(Character.toChars(r));
		}
		return randomString;
	}
	
	public static String getRandomString(Locale locale, int len) {
		ULocale ulocale = ULocale.forLocale(locale);
		UnicodeSet alphabet = LocaleData.getExemplarSet(ulocale, 1);
		int alphabetSize = alphabet.size();
		Random rand = new Random();
		String randomString = "";
		for(int i=0; i<len; i++) {
			int charAt = rand.nextInt(alphabetSize);
			int r =alphabet.charAt(charAt);
			randomString += new String(Character.toChars(r));
		}
		return randomString;
	}
	
	public String getAlphabet() {
		ULocale ulocale = ULocale.forLocale(locale);
		UnicodeSet alphabet = LocaleData.getExemplarSet(ulocale, 1);
		String str = "";
		for(int i=0; i<alphabet.size(); i++) {
			int r =alphabet.charAt(i);		
			str += new String(Character.toChars(r));
		}
		return str;
	}
}
