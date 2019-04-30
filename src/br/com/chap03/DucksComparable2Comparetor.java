package br.com.chap03;

import java.util.*;

public class DucksComparable2Comparetor implements Comparable<DucksComparable2Comparetor> {

	private String name;
	private int weight;

	public DucksComparable2Comparetor(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public DucksComparable2Comparetor(String name) {
		this.name = name;
	}


	public int compareTo(DucksComparable2Comparetor d) {
		return name.compareTo(d.name); // call String's compareTo
	}

	public static void main(String[] args) {
		Comparator<DucksComparable2Comparetor> byWeight = new Comparator<DucksComparable2Comparetor>() {
			public int compare(DucksComparable2Comparetor d1, DucksComparable2Comparetor d2) {
				return d1.getWeight()-d2.getWeight();
			}
		};
	
		List<DucksComparable2Comparetor> ducks = new ArrayList<>();
		ducks.add(new DucksComparable2Comparetor("Quack", 7));
		ducks.add(new DucksComparable2Comparetor("Puddles", 10));
		Collections.sort(ducks);
		System.out.println(ducks); // [Puddles, Quack]
		Collections.sort(ducks, byWeight);
		System.out.println(ducks); // [Quack, Puddles]
		/*Comparator<Duck> byWeight = (d1, d2) -> d1.getWeight()—d2.getWeight();
		 * Comparator<Duck> byWeight = (Duck d1, Duck d2) -> d1.getWeight()—d2.getWeight();
		 * Comparator<Duck> byWeight = (d1, d2) -> { return d1.getWeight()—d2.getWeight(); };
		 * Comparator<Duck> byWeight = (Duck d1, Duck d2) -> {return d1.getWeight()—d2.getWeight(); };
		 */

		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String toString() { // use readable output
		return name;
	}
}
