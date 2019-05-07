package br.com.ExceptionsAssertations.assertation;

public class AssertationExample {

	public static void main(String[] args) {
		int numGuests = -2;
		assert numGuests >0;
		System.out.println(numGuests);
	}
}
