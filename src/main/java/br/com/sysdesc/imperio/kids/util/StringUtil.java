package br.com.sysdesc.imperio.kids.util;

import java.util.Arrays;

public class StringUtil {

	private StringUtil() {
	}

	public static final String STRING_VAZIA = "";

	public static boolean isNullOrEmpty(String valor) {
		return valor == null || valor.equals(STRING_VAZIA);
	}

	public static boolean isNullOrEmptyTrim(String valor) {
		return valor == null || valor.trim().equals(STRING_VAZIA);
	}

	public static String arrayToString(char[] password) {
		StringBuilder sb = new StringBuilder();

		for (char c : password) {
			sb.append(c);
		}
		return sb.toString();
	}

	public static boolean isNumeric(String text) {
		try {
			Double.valueOf(text);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public static String formatarNumero(String text) {

		return text.replaceAll("[^0-9]", STRING_VAZIA);
	}

	public static String padLeft(String stringToPad, Long padToLength) {

		String retValue;

		if (stringToPad.length() < padToLength) {

			Integer pad = (padToLength.intValue() - stringToPad.length());

			retValue = String.format(concat("%0", pad.toString(), "d%s"), 0, stringToPad);

		} else {

			retValue = stringToPad;
		}

		return retValue;
	}

	public static String concat(String... params) {

		StringBuilder stringBuilder = new StringBuilder();

		Arrays.asList(params).forEach(stringBuilder::append);

		return stringBuilder.toString();
	}
}
