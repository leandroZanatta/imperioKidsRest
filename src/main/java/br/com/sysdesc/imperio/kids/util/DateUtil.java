package br.com.sysdesc.imperio.kids.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static final String FORMATO_DD_MM_YYYY = "dd/MM/YYYY";

	private DateUtil() {
	}

	public static String formatString(Date date, String format) {

		return new SimpleDateFormat(format).format(date);
	}

	public static Date getDateTimeNow() {

		return new Date();
	}
}
