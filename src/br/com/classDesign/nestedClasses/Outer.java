package br.com.classDesign.nestedClasses;

public class Outer {
	private String greeting = "Hi";

	protected class Inner {
		public int repeat = 3;

		public void go() {
			for (int i = 0; i < repeat; i++)
				System.out.println(greeting);
		}
	}

	public void callInner() {
		Inner inner = new Inner();
		inner.go();
	}

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.callInner();

		Outer o = new Outer();
		Inner inner = o.new Inner(); // create the inner class
		inner.go();
	}
}