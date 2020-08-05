package br.com.sysdesc.imperio.kids.util;

public class LongUtil {

	private LongUtil() {
	}

	public static boolean isNullOrZero(Long value) {
		return value == null || value.equals(0L);
	}
}
