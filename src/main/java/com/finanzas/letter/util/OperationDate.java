package com.finanzas.letter.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class OperationDate {
	public static Long restaDate(LocalDate d1,LocalDate d2) {
		if(d1 == null || d2 == null)return Long.valueOf(-1);
		long daysBetween = ChronoUnit.DAYS.between(d1,d2);
		return daysBetween;
	}
	public static double setPrecision(Double value,int scala) {
		return BigDecimal.valueOf(value).setScale(scala,BigDecimal.ROUND_HALF_DOWN).doubleValue();
	}
}
