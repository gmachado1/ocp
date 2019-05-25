package br.com.classDesign.equals;

public class EqualsExamples {

	public static void main(String[] args) {
		String s1 = new String("lion");
		String s2 = new String("lion");
		System.out.println(s1.equals(s2)); // true
		StringBuilder sb1 = new StringBuilder("lion");
		StringBuilder sb2 = new StringBuilder("lion");
		System.out.println(sb1.equals(sb2)); // false
		System.out.println(sb1.toString().equals(sb2)); // false
	}

}
