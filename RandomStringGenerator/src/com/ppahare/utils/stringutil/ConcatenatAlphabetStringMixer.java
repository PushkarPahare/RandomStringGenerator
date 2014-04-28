package com.ppahare.utils.stringutil;

import java.util.ArrayList;
import java.util.Random;

import com.ibm.icu.text.UnicodeSet;

public class ConcatenatAlphabetStringMixer extends AbstractStringMixer {

	public ConcatenatAlphabetStringMixer(Random random) {
    	super(random);
    }
	
	public ConcatenatAlphabetStringMixer() {
    	super();
    }
    
	@Override
	public String getMixedString(UnicodeSet localeAlphabet, int length) {
		if(length == 0) {
			return "";
		} else if(length < 0) {
			throw new IllegalArgumentException("Length must be greater than 0.");
		}

		ArrayList<int[]> alphabets = this.getCharacterSetList();
		
		if(localeAlphabet != null) {
			alphabets.add(getCharArray(localeAlphabet));
		}
		
		int numberOfAlphabets = alphabets.size();
		if(alphabets == null || numberOfAlphabets == 0) {
			throw new IllegalArgumentException("No Alphabet specified.");
		}
		
		
		
		StringBuilder randomString = new StringBuilder();
		
		for(int iterator=0; iterator < alphabets.size(); iterator++) {
			int count = length / alphabets.size();
			if(iterator == alphabets.size()-1){
				count += length % alphabets.size();
			}
			int[] chars = alphabets.get(iterator);
			randomString.append(RandomUtils.random(count,chars,RANDOM));
		}
		
		return randomString.toString();
	}
}
