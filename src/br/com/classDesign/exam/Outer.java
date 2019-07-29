package br.com.classDesign.exam;

public class Outer {
	private int x = 5;

	class Inner {
		public int x = 10;//not STATIC

		public void go() {
			System.out.println(x);
		}
	}

	public static void main(String[] args) {
		//Inner in = new Inner();  //não compila
		//Inner in1 = Outer.new Inner(); //não compila
		Inner in = new Outer().new Inner();
		Outer out = new Outer();
		Outer.Inner in3 = out.new Inner();
		in.go();
	}
}
