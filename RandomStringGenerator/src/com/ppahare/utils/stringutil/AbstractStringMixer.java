package com.ppahare.utils.stringutil;

import java.util.ArrayList;
import java.util.Random;

import com.ibm.icu.text.UnicodeSet;

abstract public class AbstractStringMixer {
	protected boolean allowSpaces;
	protected boolean allowSpecialCharacters;
	protected boolean allowNumbers;
	protected boolean allowWhiteSpaces;
	protected boolean allowAlphaNumeric;
	protected boolean allowAscii;
	protected Random RANDOM;
	
	public AbstractStringMixer allowSpaces() {
		allowSpaces = true;
		return this;
	}
	
	public AbstractStringMixer allowSpecialCharacters() {
		allowSpecialCharacters = true;
		return this;
	}
	
	public AbstractStringMixer allowNumbers() {
		allowNumbers = true;
		return this;
	}
	
	public AbstractStringMixer allowWhiteSpaces() {
		allowWhiteSpaces = true;
		return this;
	}
	
	public AbstractStringMixer allowAlphaNumeric() {
		allowAlphaNumeric = true;
		return this;
	}
	
	public AbstractStringMixer allowAscii() {
		allowAscii = true;
		return this;
	}
	
	public AbstractStringMixer(Random random) {
    	RANDOM = random;
    }
	
	public AbstractStringMixer() {
    	RANDOM = new Random();
    }
    
	public String getMixedString(UnicodeSet alphabet, int length, Random random) {
		RANDOM = random;
		return getMixedString(alphabet, length);
	}
	abstract String getMixedString(UnicodeSet alphabet, int length);
	
	protected ArrayList<int[]> getCharacterSetList() {
		ArrayList<int[]> alphabets = new ArrayList<int[]>();
		if(allowAscii) alphabets.add(getAsciiCharArray());
		if(allowSpaces) alphabets.add(getSpaceArray());
		if(allowNumbers) alphabets.add(getNumericArray());
		if(allowWhiteSpaces) alphabets.add(getWhiteSpaceArray());
		if(allowSpecialCharacters) alphabets.add(getSpecialCharacterArray());
		return alphabets;
	}
	private int[] getSpaceArray() {
		return new int[] {' '};
	}
	
	private int[] getWhiteSpaceArray() {
		return new int[] {' ', '\t', '\n', '\r'};
	}
	
	private int[] getNumericArray() {
		return new int[] {'0','1','2','3','4','5','6','7','8','9'};
	}
	
	private int[] getSpecialCharacterArray() {
		return new int[] {'`','~','!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+'
				, '=', '{', '[', '}', ']', '|', '|', ':', ';', '"', '\'', '<', ',', '>', '.', '?', '/'};
	}
	
	private int[] getAsciiCharArray() {
		int[] intArray = new int[256];
		for(int iterator = 0; iterator < 256; iterator++) {
			intArray[iterator] = iterator;
		}
		return intArray;
	}
	protected int[] getCharArray(UnicodeSet unicodeSet) {
		int[] intArray = new int[unicodeSet.size()];
		for(int iterator = 0; iterator < unicodeSet.size(); iterator++) {
			intArray[iterator] = unicodeSet.charAt(iterator);
		}
		return intArray;
	}
}
