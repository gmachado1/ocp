package br.com.genericsAndCollections;

import java.util.*;

public class DucksComparable implements Comparable<DucksComparable> {

	private String name;

	public DucksComparable(String name) {
		this.name = name;
	}

	public String toString() { // use readable output
		return name;
	}

	public int compareTo(DucksComparable d) {
		return name.compareTo(d.name); // call String's compareTo
	}

	public static void main(String[] args) {
		List<DucksComparable> ducks = new ArrayList<>();
		ducks.add(new DucksComparable("Quack"));
		ducks.add(new DucksComparable("Puddles"));
		Collections.sort(ducks); // sort by name
		System.out.println(ducks); // [Puddles, Quack]
	}
}
