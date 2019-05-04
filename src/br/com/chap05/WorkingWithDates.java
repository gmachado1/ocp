package br.com.chap05;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class WorkingWithDates {

	public static void main(String[] args) throws InterruptedException {
		{
			System.out.println(LocalDate.now());
			System.out.println(LocalTime.now());
			System.out.println(LocalDateTime.now());
			System.out.println(ZonedDateTime.now());
		}
		{
			LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
			LocalDate date2 = LocalDate.of(2015, 1, 20);
			System.out.println(date1);
			System.out.println(date2);
		}
		{
			LocalTime time1 = LocalTime.of(6, 15); // hour and minute
			LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
			LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds
			System.out.println(time1);
			System.out.println(time2);
			System.out.println(time3);
		}
		{
			LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
			LocalTime time1 = LocalTime.of(6, 15); // hour and minute
			LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
			LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);
			System.out.println(dateTime1);
			System.out.println(dateTime2);
		}
		{
			LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
			LocalTime time1 = LocalTime.of(6, 15); // hour and minute
			LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
			ZoneId zone = ZoneId.of("US/Eastern");
			ZonedDateTime zoned1 = ZonedDateTime.of(2015, 1, 20, 6, 15, 30, 200, zone);
			ZonedDateTime zoned2 = ZonedDateTime.of(date1, time1, zone);
			ZonedDateTime zoned3 = ZonedDateTime.of(dateTime1, zone);
			System.out.println(zoned1);
			System.out.println(zoned2);
			System.out.println(zoned3);
		}
		{
			System.out.println();
			System.out.println(ZoneId.systemDefault());
		}
		{
			ZoneId.getAvailableZoneIds().stream().filter(z -> z.contains("America") || z.contains("US")).sorted()
					.forEach(System.out::println);
		}
		{
			LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
			System.out.println(date); // 2014–01–20
			date = date.plusDays(2);
			System.out.println(date); // 2014–01–22
			date = date.plusWeeks(1);
			System.out.println(date); // 2014–01–29
			date = date.plusMonths(1);
			System.out.println(date); // 2014–02–28
			date = date.plusYears(2);
			System.out.println(date); // 2019–02–28
			date = date.plusDays(1);
			System.out.println(date);
		}
		{
			LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
			LocalTime time = LocalTime.of(5, 15);
			LocalDateTime dateTime = LocalDateTime.of(date, time);
			System.out.println(dateTime); // 2020–01–20T05:15
			dateTime = dateTime.minusDays(1);
			System.out.println(dateTime); // 2020–01–19T05:15
			dateTime = dateTime.minusHours(10);
			System.out.println(dateTime); // 2020–01–18T19:15
			dateTime = dateTime.minusSeconds(30);
			System.out.println(dateTime); // 2020–01–18T19:14:30
		}
		{
			LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
			LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
			performAnimalEnrichment(start, end);
			System.out.println(end);
			System.out.println(start);
		}
		{
			LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
			LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
			Period period = Period.ofMonths(1); // create a period
			performAnimalEnrichment(start, end, period);
		}
		{
			Period annually = Period.ofYears(1); // every 1 year
			Period quarterly = Period.ofMonths(3); // every 3 months
			Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
			Period everyOtherDay = Period.ofDays(2); // every 2 days
			Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days
			System.out.println(annually);
			System.out.println(quarterly);
			System.out.println(everyThreeWeeks);
			System.out.println(everyOtherDay);
			System.out.println(everyYearAndAWeek);
		}
		{
			Duration daily = Duration.ofDays(1); // PT24H
			Duration hourly = Duration.ofHours(1); // PT1H
			Duration everyMinute = Duration.ofMinutes(1); // PT1M
			Duration everyTenSeconds = Duration.ofSeconds(10); // PT10S
			Duration everyMilli = Duration.ofMillis(1); // PT0.001S
			Duration everyNano = Duration.ofNanos(1); // PT0.000000001S
			System.out.println(daily);
			System.out.println(hourly);
			System.out.println(everyMinute);
			System.out.println(everyTenSeconds);
			System.out.println(everyMilli);
			System.out.println(everyNano);
		}
		{
			Duration daily = Duration.of(1, ChronoUnit.DAYS);
			Duration hourly = Duration.of(1, ChronoUnit.HOURS);
			Duration everyMinute = Duration.of(1, ChronoUnit.MINUTES);
			Duration everyTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
			Duration everyMilli = Duration.of(1, ChronoUnit.MILLIS);
			Duration everyNano = Duration.of(1, ChronoUnit.NANOS);
			System.out.println(daily);
			System.out.println(hourly);
			System.out.println(everyMinute);
			System.out.println(everyTenSeconds);
			System.out.println(everyMilli);
			System.out.println(everyNano);
		}
		{
			LocalTime one = LocalTime.of(5, 15);
			LocalTime two = LocalTime.of(6, 30);
			LocalDate date = LocalDate.of(2016, 1, 20);
			System.out.println(ChronoUnit.HOURS.between(one, two)); // 1
			System.out.println(ChronoUnit.MINUTES.between(one, two)); // 75
			try {
				System.out.println(ChronoUnit.MINUTES.between(one, date));
			} catch (DateTimeException e) {
				e.getMessage();
			} // DateTimeException
		}
		{
			Instant now = Instant.now();
			// do something time consuming
			Thread.sleep(1000);
			Instant later = Instant.now();

			Duration duration = Duration.between(now, later);
			System.out.println(duration.toMillis());
		}
		{
			LocalDate date = LocalDate.of(2015, 5, 25);
			LocalTime time = LocalTime.of(11, 55, 00);
			ZoneId zone = ZoneId.of("US/Eastern");
			ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
			Instant instant = zonedDateTime.toInstant(); // 2015–05–25T15:55:00Z
			System.out.println(zonedDateTime); // 2015–05–25T11:55–04:00[US/Eastern]
			System.out.println(instant); // 2015–05–25T15:55:00Z
		}
		{
			Instant instant = Instant.ofEpochSecond(2);// TODO coloquei qq numero para não dar erro
			System.out.println(instant); // 2015–05–25T15:55:00Z
			Instant nextDay = instant.plus(1, ChronoUnit.DAYS);
			System.out.println(nextDay); // 2015–05–26T15:55:00Z
			Instant nextHour = instant.plus(1, ChronoUnit.HOURS);
			System.out.println(nextHour); // 2015–05–25T16:55:00Z
			Instant nextWeek = instant.plus(1, ChronoUnit.WEEKS); // exception
		}
		{// HORARIO DE VERAO
			LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
			LocalTime time = LocalTime.of(1, 30);
			ZoneId zone = ZoneId.of("US/Eastern");
			ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
			System.out.println(dateTime); // 2016–03–13T01:30–05:00[US/Eastern]
			dateTime = dateTime.plusHours(1);
			System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]
		}
		{// HORARIO DE VERAO FIM
			LocalDate date = LocalDate.of(2016, Month.NOVEMBER, 6);
			LocalTime time = LocalTime.of(1, 30);
			ZoneId zone = ZoneId.of("US/Eastern");
			ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
			System.out.println(dateTime); // 2016–11–06T01:30–04:00[US/Eastern]
			dateTime = dateTime.plusHours(1);
			System.out.println(dateTime); // 2016–11–06T01:30–05:00[US/Eastern]
			dateTime = dateTime.plusHours(1);
			System.out.println(dateTime); // 2016–11–06T02:30–05:00[US/Eastern]
		}
		{
			LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
			LocalTime time = LocalTime.of(2, 30);
			ZoneId zone = ZoneId.of("US/Eastern");
			ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
			System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]
		}
	}

	private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {
		LocalDate upTo = start;
		while (upTo.isBefore(end)) {
			System.out.println("give new toy: " + upTo);
			upTo = upTo.plus(period); // adds the period
		}
	}

	private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
		LocalDate upTo = start;
		while (upTo.isBefore(end)) { // check if still before end
			System.out.println("give new toy: " + upTo);
			upTo = upTo.plusMonths(1); // add a month
			start = upTo;
		} // TODO se comentar acima altera só no metodo.
		System.out.println("up to " + upTo);
		System.out.println("start  " + start);
	}
}
