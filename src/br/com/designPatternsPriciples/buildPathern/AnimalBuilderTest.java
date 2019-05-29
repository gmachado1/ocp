package br.com.designPatternsPriciples.buildPathern;

import java.util.Arrays;

import br.com.designPatternsPriciples.singleton.lazy.Animal;

public class AnimalBuilderTest {

	public static void main(String[] args) {
		AnimalBuilder duckBuilder = new AnimalBuilder();
		duckBuilder.setAge(4).setFavoriteFoods(Arrays.asList("grass", "fish")).setSpecies("duck");
		Animal duck = duckBuilder.build();
		Animal flamingo = new AnimalBuilder().setFavoriteFoods(Arrays.asList("algae", "insects")).setSpecies("flamingo")
				.build();
	}
}
