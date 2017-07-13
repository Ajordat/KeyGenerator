package model;

import java.util.Date;
import java.util.Random;

public class KeyGenerator {
	private static final String CAPS_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static final String INTEGERS_ALPHABET = "0123456789";
	private static final String SPECIAL_ALPHABET = "@%+/'!#$^?:(){}[]~-_<>=*,.\\\"";

	public static String generate(int n, boolean[] conds) {

		String pass = "";

		int q = 0;
		for (boolean b : conds) if (b) q++;
		String[] alphabets = new String[q];
		int n_alphabet = 0;

		if (conds[0]) {
			alphabets[n_alphabet] = generateRandom(CAPS_ALPHABET, n);
			n_alphabet++;
		}
		if (conds[1]) {
			alphabets[n_alphabet] = generateRandom(ALPHABET, n);
			n_alphabet++;
		}
		if (conds[2]) {
			alphabets[n_alphabet] = generateRandom(INTEGERS_ALPHABET, n);
			n_alphabet++;
		}
		if (conds[3]) {
			alphabets[n_alphabet] = generateRandom(SPECIAL_ALPHABET, n);
			n_alphabet++;
		}

		Random random = new Random((new Date()).getTime());
		for (int i = 0; i < n; i++) {
			pass += alphabets[random.nextInt(n_alphabet)].charAt(i);
		}
		return pass;
	}

	private static String generateRandom(String str, int n) {
		Random random = new Random((new Date()).getTime());
		String key = "";
		int length = str.length();

		for (int i = 0; i < n; i++) {
			key += str.charAt(random.nextInt(length));
		}
		return key;
	}

}
