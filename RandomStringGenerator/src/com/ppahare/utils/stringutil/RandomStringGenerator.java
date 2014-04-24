package com.ppahare.utils.stringutil;

import java.util.Locale;
import java.util.Random;

import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.LocaleData;
import com.ibm.icu.util.ULocale;


public class RandomStringGenerator extends AbstractRandomStringBuilder {
	
	public UnicodeSet getAlphabet(Locale locale) {
		ULocale ulocale = ULocale.forLocale(locale);
		UnicodeSet alphabet = LocaleData.getExemplarSet(ulocale, 1);
		return alphabet;
	}
	public String getRandomString() {
		if (locale == null) { throw new IllegalArgumentException ("You might want to specify locale."); }
		if (length <= 0) { throw new IllegalArgumentException("You might want to specify length gt 0."); }
		
		UnicodeSet alphabet = getAlphabet(locale);
		if(allowNumbers) alphabet.addAll("0123456789");
		if(allowSpecialCharacters) alphabet.addAll("~!@#$%^&*()_+{}|:\"<>?`-=[]\\;',./'");
		if(allowSpaces) alphabet.addAll(" \t\r\n");
		
		return getRandomString(alphabet);
	}
	
	private String getRandomString(UnicodeSet alphabet){
		int alphabetSize = alphabet.size();
		Random rand = new Random();
		String randomString = "";
		for(int i=0; i<length; i++) {
			int charAt = rand.nextInt(alphabetSize);
			int r = alphabet.charAt(charAt);
			randomString += new String(Character.toChars(r));
		}
		return randomString;
	}
	
}
