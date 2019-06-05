package br.com.datesStringsLocalizations.propertyFiles;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class ZooOpen {

	public static void main(String[] args) {
		
		Locale us = new Locale("en", "US");
		Locale france = new Locale("fr", "FR");
		Locale bra = new Locale("pt", "BR");
//		printProperties(us);
//		System.out.println();
//		printProperties(france);
		System.out.println();
		printProperties(bra);
		System.out.println();
//		printPropertiesStream(us);
//		System.out.println();
//		printPropertiesStream(france);
//		System.out.println();
		printPropertiesStream(bra);

//		System.out.println();
//		PrintPropConvertStream(us);
//		System.out.println();
//		PrintPropConvertStream(france);
		System.out.println();
		PrintPropConvertStream(bra);
		
		
	}

	public static void printProperties(Locale locale) {
		ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("open"));
		System.out.println(rb.getString("teste.do.sistema"));
	}

	private static void printPropertiesStream(Locale locale) {
		ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
		Set<String> keys = rb.keySet();
		keys.stream().map(k -> k + " " + rb.getString(k)).forEach(System.out::println);
	}

	private static void PrintPropConvertStream(Locale locale) {
		ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
		Properties props = new Properties();
		rb.keySet().stream().forEach(k -> props.put(k, rb.getString(k)));

		System.out.println(props.getProperty("notReallyAProperty"));
		System.out.println(props.getProperty("notReallyAProperty", "123"));
	}
}
