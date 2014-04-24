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
		String finalString = "";
		RandomStringGenerator r = new RandomStringGenerator();
		for(Locale l : new Locale[]{Locale.JAPANESE}) {			
			r.setLocale(l);
			r.setLength(10);
			finalString += l.getDisplayName() +" : " + (r.getRandomString()) + "\r\n";
		}
		new ShowString(finalString, "RandomStringGenerator");
	}
}
