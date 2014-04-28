package com.ppahare.utils.stringutil;

import java.util.Locale;

import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.LocaleData;
import com.ibm.icu.util.ULocale;

/**
 * <p> Creates localized random string of fixed length. </p>
 * 
 * <p> Typical call would look like :
 * 
 * 			RandomStringGenerator r = null;
 * 			r = new RandomStringGenerator(Locale.ENGLISH, 10);
 * 			r.getRandomString();
 * 
 * 									or
 * 
 * 			RandomStringGenerator r = new RandomStringGenerator();
 * 			r.applyLocale(new Locale("ja_JP"))
 * 			 .applyLength(10)
 * 			 .applyMixerStrategy(new ConcatenateAlphabetStringMixer().allowAscii())
 * 			 .getRandomString();
 * 
 * 									or
 * 
 * 			RandomStringGenerator r = new RandomStringGenerator();
 * 			r.applyLocale(new Locale("ja_JP")).applyLength(10).getRandomString();
 * </p>
 * 
 * @author ppahare
 *
 */
public class RandomStringGenerator extends AbstractRandomStringBuilder {
		
	public RandomStringGenerator(Locale locale, int length) {
		super(locale,length);
	}
	
	public RandomStringGenerator() {
	}
	
	private UnicodeSet getUnicode(Locale locale) {
		ULocale ulocale = ULocale.forLocale(locale);
		return LocaleData.getExemplarSet(ulocale, 1);
	}
	
	@Override
	public String getRandomString() {
		if(length == 0) return "";
		
		if (length < 0) { throw new IllegalArgumentException("You might want to specify length gt 0."); }
		
		UnicodeSet alphabet = null;
		
		if(locale != null) alphabet = getUnicode(locale);
		
		if(mixerStrategy == null) {
			mixerStrategy = new DefaultAlphabetStringMixer();
		}
		return mixerStrategy.getMixedString(alphabet, length);
	}	
}
