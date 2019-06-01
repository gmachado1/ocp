package br.com.genericsAndCollections.lambdas;

import java.util.List;
import java.util.ArrayList;

public class Circo {
	public static void main(String[] args) {
		List<String> circo = new ArrayList<String>();
		circo.add("Mágico");
		circo.add("Trapezista");
		circo.add("Motoqueiro");
		
		System.out.println("antes do replace all");
		circo.forEach(System.out::println);
		System.out.println();
		System.out.println("depois do replace all");
		circo.replaceAll(c->c+" de Soler");
		circo.forEach(System.out::println);
		System.out.println();
		System.out.println("depois do removeIf");
		circo.removeIf(s -> s.startsWith("M"));
		circo.forEach(System.out::print);

	}
}
