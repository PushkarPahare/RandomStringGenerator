package com.ppahare.utils.stringutil;

import java.util.ArrayList;
import java.util.Random;

import com.ibm.icu.text.UnicodeSet;

public class DefaultAlphabetStringMixer extends AbstractStringMixer {
	
    public DefaultAlphabetStringMixer(Random random) {
    	super(random);
    }
    
    public DefaultAlphabetStringMixer() {
    	super();
    }
    
	@Override
	public String getMixedString(UnicodeSet localeAlphabet, int length) {
		if(length == 0) {
			return "";
		}
		
		if(length <= 0) {
			throw new IllegalArgumentException("Length must be greater than 0.");
		}
		
		ArrayList<int[]> alphabets = this.getCharacterSetList();
		alphabets.add(getCharArray(localeAlphabet));
		
		int numberOfAlphabets = alphabets.size();
		if(alphabets == null || numberOfAlphabets == 0) {
			throw new IllegalArgumentException("No Alphabet specified.");
		}
		
		StringBuilder randomString = new StringBuilder();
		
		for(int iterator=0; iterator < length; iterator++) {
			int index = RANDOM.nextInt(numberOfAlphabets);
			int[] alphabet = alphabets.get(index);
			int randomValue = RANDOM.nextInt(alphabet.length);
			int charValue = alphabet[randomValue];
			randomString.append(Character.toChars(charValue));
		}
		
		return randomString.toString();
	}

}
