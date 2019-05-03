package br.com.chap04;

import java.time.LocalDate;
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
			
		}

	}
}
