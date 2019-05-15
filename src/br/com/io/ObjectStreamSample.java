package br.com.io;

import java.io.*;
import java.util.*;

public class ObjectStreamSample {

	public static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
		List<Animal> animals = new ArrayList<Animal>();
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			while (true) {
				Object object = in.readObject();
				if (object instanceof Animal)
					animals.add((Animal) object);
			}
		} catch (EOFException e) {
			// File end reached
		}
		return animals;
	}

	public static List<Animale> getAnimales(File dataFile) throws IOException, ClassNotFoundException {
		List<Animale> animales = new ArrayList<Animale>();
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			while (true) {
				Object object = in.readObject();
				if (object instanceof Animale)
					animales.add((Animale) object);
			}
		} catch (EOFException e) {
			// File end reached
		}
		return animales;
	}

	public static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			for (Animal animal : animals)
				out.writeObject(animal);
		}
	}

	public static void createAnimalesFile(List<Animale> animales, File dataFile) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			for (Animale animal : animales)
				out.writeObject(animal);
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Lua", 5, 'G'));
		animals.add(new Animal("Brown", 8, 'C'));

		List<Animale> animales = new ArrayList<Animale>();
		animales.add(new Animale("Paxa", 5, 'C'));
		animales.add(new Animale("Bummer", 8, 'C'));

		File dataAnimalFile = new File("animal.txt");
		File dataAnimaleFile = new File("animale.txt");

		createAnimalsFile(animals, dataAnimalFile);
		createAnimalesFile(animales, dataAnimaleFile);

		System.out.println(getAnimals(dataAnimalFile));
		System.out.println(getAnimales(dataAnimaleFile));
	}
}
