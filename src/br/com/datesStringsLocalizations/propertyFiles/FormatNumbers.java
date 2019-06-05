package br.com.datesStringsLocalizations.propertyFiles;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Locale;

public class FormatNumbers {
	
	public static void main(String[] args) {
		{
			int attendeesPerYear = 3_200_000;
			int attendeesPerMonth = attendeesPerYear / 12;
			NumberFormat us = NumberFormat.getInstance(Locale.US);
			System.out.println(us.format(attendeesPerMonth));
			NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
			System.out.println(g.format(attendeesPerMonth));
			NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
			System.out.println(ca.format(attendeesPerMonth));
		}
		{

			double price = 48;
			NumberFormat br = NumberFormat.getCurrencyInstance();
			System.out.println(br.format(price));
			NumberFormat us = NumberFormat.getInstance(Locale.US).getCurrencyInstance(Locale.US);
			System.out.println(us.format(price));
		}
		{
			LocalDate date = LocalDate.of(2020, Month.FEBRUARY, 20);
			System.out.println(date.getDayOfWeek()); // THURSDAY
			System.out.println(date.getMonth()); // FEBRUARY
			System.out.println(date.getYear()); // 2020
			System.out.println(date.getDayOfYear()); // 51
			System.out.println(date.getDayOfMonth()); // 20
		}
		{
			LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
			LocalTime time = LocalTime.of(11, 12, 34);
			LocalDateTime dateTime = LocalDateTime.of(date, time);
			System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
			System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
			System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		}
		{
			LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
			LocalTime time = LocalTime.of(11, 12, 34);
			LocalDateTime dateTime = LocalDateTime.of(date, time);
			DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
			System.out.println(shortDateTime.format(dateTime)); // 1/20/20
			System.out.println(shortDateTime.format(date)); // 1/20/20
			try {
				System.out.println(shortDateTime.format(time));
			} catch (UnsupportedTemporalTypeException e) {
				e.getMessage();
				System.out.println("PEEEEEEEEEEE");
			}
			;
		}
		{
			LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
			LocalTime time = LocalTime.of(11, 12, 34);
			LocalDateTime dateTime = LocalDateTime.of(date, time);
			DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
			DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
			System.out.println(shortF.format(dateTime)); // 1/20/20 11:12 AM
			System.out.println(mediumF.format(dateTime)); // Jan 20, 2020 11:12:34 AM
		}
	}
}
