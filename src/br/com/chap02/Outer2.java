package br.com.chap02;

public class Outer2 {
	
	private int lenght = 5;
	public void calculate() {
		final int width=20;
		class Inner{
			public void multiply() {
				System.out.println(lenght*width);
			}
		}
		Inner inner =  new Inner();
		inner.multiply();
	}

	public static void main(String srgs[]) {
		Outer2 out2 = new Outer2();
		out2.calculate();
	}
}
