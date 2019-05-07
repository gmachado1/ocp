package br.com.genericsAndCollections.exam;

import java.util.Comparator;
import java.util.TreeSet;

public class SortExam implements Comparable<SortExam>, Comparator<SortExam> {
	private int num;
	private String text;

	SortExam(int n, String t) {
		this.num = n;
		this.text = t;
	}

	public String toString() {
		return "" + num;
	}

	public int compareTo(SortExam se) {
		return text.compareTo(se.text);
	}

	public int compare(SortExam s1, SortExam s2) {
		return s1.num - s2.num;
	}

	public static void main(String args[]) {
		SortExam s1 = new SortExam(88, "a");
		SortExam s2 = new SortExam(55, "b");

		TreeSet<SortExam> t1 = new TreeSet<>();
		t1.add(s1);
		t1.add(s2);
		TreeSet<SortExam> t2 = new TreeSet<>(s1);
		t2.add(s1);
		t2.add(s2);

		System.out.println(t1 + " - " + t2);

	}

}
