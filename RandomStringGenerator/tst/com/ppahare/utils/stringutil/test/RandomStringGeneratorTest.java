package com.ppahare.utils.stringutil.test;

import java.util.Locale;

import com.ppahare.utils.stringutil.RandomStringGenerator;

public class RandomStringGeneratorTest {
	public static void main(String s[]) {
		
		Locale[] locales = new Locale[]{new Locale("zh_CN"), 
										new Locale("es_ES"), 
										new Locale("fr_FR"), 
										new Locale("de_DE"),  
										new Locale("it_IT"), 
										new Locale("en_CA"), 
										new Locale("ja_JP"),
										new Locale("en_GB"),
										new Locale("en_US"), 
										new Locale("en_IN")}	;
		RandomStringGenerator r = new RandomStringGenerator();
		for(Locale l : locales) {			
			r.setLocale(l)
			 .setLength(1000)
			 .allowSpecialCharacters(true)
			 .allowNumbers(true)
			 .allowSpaces(true);
			//System.out.println(r.getRandomString() + " " +  l.getDisplayCountry() + "_" + l.getDisplayLanguage());
			new ShowString(r.getRandomString(), l.getDisplayCountry() + "_" + l.getDisplayLanguage());
		}
		
	}
}
