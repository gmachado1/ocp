package br.com.chap03.exam;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx implements Comparator<String> {

	public int compare(String a, String b) {
		// return a.compareTo(b); //123 - Abb - aab -
		return b.toLowerCase().compareTo(a.toLowerCase());// Abb - aab - 123 -
	}

	public static void main(String args[]) {
		String[] values = { "123", "Abb", "aab" };
		Arrays.sort(values, new ComparatorEx());
		for (String s : values)
			System.out.print(s + " - ");
	}
}
