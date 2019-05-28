package br.com.designPatternsPriciples;

import br.com.io.Animal;

@FunctionalInterface
interface Sprint {
	public void sprint(Animal animal);
}

public class Tiger implements Sprint {
	public void sprint(Animal animal) {
		System.out.println("Animal is sprinting fast! " + animal.toString());
	}
}
