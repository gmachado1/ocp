package br.com.genericsAndCollections.comparable;

import java.util.*;

public class Ducks implements Comparable<Ducks> {

	private String name;

	public Ducks(String name) {
		this.name = name;
	}

	public String toString() { // use readable output
		return name;
	}

	public int compareTo(Ducks d) {
		return name.compareTo(d.name); // call String's compareTo
	}

	public static void main(String[] args) {
		List<Ducks> ducks = new ArrayList<>();
		ducks.add(new Ducks("Quack"));
		ducks.add(new Ducks("Puddles"));
		Collections.sort(ducks); // sort by name
		System.out.println(ducks); // [Puddles, Quack]
	}
}
