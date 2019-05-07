package br.com.genericsAndCollections;

import java.util.ArrayList;
import java.util.List;

public class Testing {

	public static void main(String args[]) {
		List teste = new ArrayList();

		
		java.util.List numbers = new java.util.ArrayList();
		numbers.add(5);
		//int result = numbers.get(0); // DOES NOT COMPILE
		Object result = numbers.get(0); 
		System.out.println(result);
	}
}
