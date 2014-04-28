package com.ppahare.utils.stringutil;

import java.util.Locale;

/**
 * <p> Abstact Builder class to get random string for a given locale and length.
 * A Policy can also be defined to allow spaces, special characters, ascii character
 * in the generated string.
 * <p>
 * 
 * @author ppahare
 *
 */
abstract public class AbstractRandomStringBuilder {
	protected Locale locale;
	protected int length;
	protected AbstractStringMixer mixerStrategy;

	/**
	 * <p> Default constructor to be used to generate random string 
	 * of different locales and length using the same instance created.
	 * <p>
	 */
	public AbstractRandomStringBuilder() {
		
	}
	
	/** 
	 * @param locale
	 * @param length
	 */
	public AbstractRandomStringBuilder(Locale locale, int length) {
		this.locale = locale;
		this.length = length;
	}
	
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setMixerStrategy(AbstractStringMixer mixerStrategy) {
		this.mixerStrategy = mixerStrategy;
	}

	/**
	 * 
	 * @param mixerStrategy
	 * @return
	 */
	public AbstractRandomStringBuilder applyMixerStrategy(AbstractStringMixer mixerStrategy) {
		this.mixerStrategy = mixerStrategy;
		return this;
	}

	public AbstractRandomStringBuilder applyLocale(Locale locale) {
		this.locale = locale;
		return this;
	}

	public AbstractRandomStringBuilder applyLength(int length) {
		this.length = length;
		return this;
	}
	
	public abstract String getRandomString();

}
