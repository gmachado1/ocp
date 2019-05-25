package br.com.classDesign.virtualMethodsInvocation;

public class PlayWithAnimals {

	public static void main(String... args) {
		Animal animal = new Lion();
		animal.printName();
		animal.careFor();
	}

}

abstract class Animal {
	String name = "???";

	public void printName() {
		System.out.println(name);
	}

	public void careFor() {
		play();
	}

	public void play() {
		System.out.println("pet animal");
	}

	public abstract void feed();
}

class Cow extends Animal {
	public void feed() {
		addHay();
	}

	private void addHay() {
	}
}

class Bird extends Animal {
	public void feed() {
		addSeed();
	}

	private void addSeed() {
	}
}

class Lion extends Animal {
	String name = "Leo";

	public void printName() {
		System.out.println(name);
	}

	public void play() {
		System.out.println("toss in meat");
	}

	public void feed() {
		addMeat();
	}

	private void addMeat() {
	}
}
