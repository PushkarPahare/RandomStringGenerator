package com.ppahare.utils.stringutil;

import java.util.Random;

public class RandomUtils {

	/**
	 * <p>
	 * Creates a random string based on a given set of chars, using supplied
	 * source of randomness.
	 * </p>
	 * 
	 * <p>
	 * This method accepts a user-supplied {@link Random} instance to use as a
	 * source of randomness..
	 * </p>
	 * 
	 * @param count
	 * @param chars
	 * @param randomizer
	 * @return
	 */
	public static String random(int count, int[] chars, Random randomizer) {
		if (count == 0) {
			return "";
		} else if (count < 0) {
			throw new IllegalArgumentException(
					"Requested random string length " + count
							+ " is less than 0.");
		}
		if (chars != null && chars.length == 0) {
			throw new IllegalArgumentException(
					"The chars array must not be empty");
		}
		if (randomizer == null) {
			throw new IllegalArgumentException(
					"Provide valid instance of Random class or of it's subclass");
		}
		StringBuilder returnStr = new StringBuilder();
		for (int iterator = 0; iterator < count; iterator++) {
			returnStr.append(Character.toChars(chars[randomizer
					.nextInt(chars.length)]));
		}
		return returnStr.toString();
	}

	/**
	 * <p>
	 * Creates a random string based on a given set of chars, using default
	 * instance of {@link Random} class.
	 * </p>
	 * 
	 * @param count
	 * @param chars
	 * @return
	 */
	public static String random(int count, int[] chars) {
		if (count == 0) {
			return "";
		} else if (count < 0) {
			throw new IllegalArgumentException(
					"Requested random string length " + count
							+ " is less than 0.");
		}
		if (chars != null && chars.length == 0) {
			throw new IllegalArgumentException(
					"The chars array must not be empty");
		}

		Random randomizer = new Random();
		StringBuilder returnStr = new StringBuilder();
		for (int iterator = 0; iterator < count; iterator++) {
			returnStr.append(Character.toChars(chars[randomizer
					.nextInt(chars.length)]));
		}
		return returnStr.toString();
	}
}
