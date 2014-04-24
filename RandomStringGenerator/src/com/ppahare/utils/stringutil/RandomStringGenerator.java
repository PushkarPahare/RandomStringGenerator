package com.ppahare.utils.stringutil;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.LocaleData;
import com.ibm.icu.util.ULocale;


public class RandomStringGenerator extends AbstractRandomStringBuilder {
	
	private static final String WHITE_SPACE = " \t\n\r";
	private static final String SPACE = " ";
	private static final String NUMBERS = "0123456789";
	private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_+{}|:\"<>?`-=[\\;'./,']";

	public UnicodeSet getAlphabet(Locale locale) {
		ULocale ulocale = ULocale.forLocale(locale);
		UnicodeSet alphabet = LocaleData.getExemplarSet(ulocale, 1);
		return alphabet;
	}
	public String getRandomString() {
		//if (locale == null) { throw new IllegalArgumentException ("You might want to specify locale."); }
		if (length <= 0) { throw new IllegalArgumentException("You might want to specify length gt 0."); }
		
		ArrayList<UnicodeSet> alphabets = new ArrayList<UnicodeSet>();
		
		if(locale != null) alphabets.add(getAlphabet(locale));
		if(allowSpaces) alphabets.add(new UnicodeSet().addAll(SPACE));
		if(allowWhiteSpaces) alphabets.add(new UnicodeSet().addAll(WHITE_SPACE));
		if(allowNumbers) alphabets.add(new UnicodeSet().addAll(NUMBERS));
		if(allowNumbers) alphabets.add(new UnicodeSet().addAll(SPECIAL_CHARACTERS));
		if(allowAscii) alphabets.add(new UnicodeSet().addAll(RandomStringUtils.randomAscii(length)));
		if(allowAlphaNumeric) alphabets.add(new UnicodeSet().addAll(RandomStringUtils.randomAlphanumeric(length)));
		
		if(mixerStrategy == null) {
			mixerStrategy = new DefaultAlphabetStringMixer();
		}
		return mixerStrategy.getMixedString(alphabets, length);
	}
}
