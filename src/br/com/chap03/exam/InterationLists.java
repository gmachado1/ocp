package br.com.chap03.exam;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InterationLists {

	public static void main(String args[]) {
		{
			Set<Number> numbers = new HashSet<>();
			numbers.add(new Integer(86));
			numbers.add(75);
			numbers.add(new Integer(86));
			numbers.add(null);
			numbers.add(208l);
			Iterator it = numbers.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}
	}
}
