package br.com.chap05;

import java.util.Locale;

public class WorkingStrings {
	public static void main(String[] args) {

		{
			String s1 = "bunny";
			String s2 = "bunny";
			String s3 = new String("bunny");
			System.out.println(s1 == s2); // true
			System.out.println(s1 == s3); // false
			System.out.println(s1.equals(s3)); // true
		}
		{
			String s = "abcde ";
			System.out.println(s.trim().length()); // 5
			System.out.println(s.charAt(4)); // e
			System.out.println(s.indexOf('e')); // 4
			System.out.println(s.indexOf("de")); // 3
			System.out.println(s.substring(2, 4).toUpperCase()); // CD
			System.out.println(s.replace('a', '1')); // 1bcde
			System.out.println(s.contains("DE")); // false
			System.out.println(s.startsWith("a")); // true
		}
		{
			StringBuilder b = new StringBuilder();
			b.append(12345).append('-');
			System.out.println(b.length()); // 6
			System.out.println(b.indexOf("-")); // 5
			System.out.println(b.charAt(2)); // 3

			StringBuilder b2 = b.reverse();
			System.out.println(b.toString()); // -54321
			System.out.println(b == b2); // true
		}
		{
			Locale locale = Locale.getDefault();
			System.out.println(locale);
			Locale l1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
			Locale l2 = new Locale.Builder().setRegion("US").setLanguage("en").build();
			System.out.println(l1);
			System.out.println(l2);
		}
		{
			System.out.println(Locale.getDefault()); // pt_BR
			Locale locale = new Locale("fr");
			// Locale.setDefault(locale); // change the default
			System.out.println(Locale.getDefault()); // fr
		}
		{
			Locale us = new Locale("en", "US");
			Locale france = new Locale("fr", "FR");
			Locale englishCanada = new Locale("en", "CA");
			Locale frenchCanada = new Locale("fr", "CA");
		}
	}
}
