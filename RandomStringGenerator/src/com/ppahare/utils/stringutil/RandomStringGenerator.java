package com.ppahare.utils.stringutil;

import java.util.Locale;

import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.LocaleData;
import com.ibm.icu.util.ULocale;


public class RandomStringGenerator extends AbstractRandomStringBuilder 
implements ILocalizedString{
		
	@Override
	public String getAlphabet(Locale locale) {
		ULocale ulocale = ULocale.forLocale(locale);
		UnicodeSet alphabet = LocaleData.getExemplarSet(ulocale, 1);
		StringBuilder randomString = new StringBuilder();
		
		for(int iterator=0; iterator < alphabet.size(); iterator++) {
			int charValue = alphabet.charAt(iterator);
			randomString.append(Character.toChars(charValue));
		}
		
		return randomString.toString();
	}
	
	private UnicodeSet getUnicode(Locale locale) {
		ULocale ulocale = ULocale.forLocale(locale);
		return LocaleData.getExemplarSet(ulocale, 1);
	}
	
	@Override
	public String getRandomString() {
		if (length <= 0) { throw new IllegalArgumentException("You might want to specify length gt 0."); }
		
		UnicodeSet alphabet = null;
		
		if(locale != null) alphabet = getUnicode(locale);
		
		if(mixerStrategy == null) {
			mixerStrategy = new DefaultAlphabetStringMixer();
		}
		return mixerStrategy.getMixedString(alphabet, length);
	}	
}
