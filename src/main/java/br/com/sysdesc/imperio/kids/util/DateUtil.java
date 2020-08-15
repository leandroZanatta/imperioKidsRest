package br.com.sysdesc.imperio.kids.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static final String FORMATO_DD_MM_YYYY = "dd/MM/YYYY";

	private DateUtil() {
	}

	public static String formatString(Date date, String format) {

		return new SimpleDateFormat(format).format(date);
	}

	public static Date parseDate(String date, String format) {

		try {

			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date getDateTimeNow() {

		return new Date();
	}
}
