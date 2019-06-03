package br.com.functionalProgramming.functionalInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierTesting {
	public static void main(String args[]) {
		{
			//implementing suplier
			Supplier<LocalDate> s1 = LocalDate::now;
			Supplier<LocalDate> s2 = () -> LocalDate.now();
			LocalDate d1 = s1.get();
			LocalDate d2 = s2.get();
			System.out.println(d1);
			System.out.println(d2);
		}
		//Implementing Consumer and BiConsumer
		{
			System.out.println("--------------------");
			Supplier<ArrayList<String>> s1 = ArrayList<String>::new;
			ArrayList<String> a1 = s1.get();
			System.out.println(a1);	
			System.out.println(s1);
		}

	}
}
