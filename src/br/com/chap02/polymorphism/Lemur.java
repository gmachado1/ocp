package br.com.chap02.polymorphism;


interface HasTail {
	public boolean isTailStriped();
	
}
public class Lemur extends Primate implements HasTail{
	public int age = 10;
	public boolean isTailStriped() {
		return true;
	}
	
	public static void main(String args[]) {
		Lemur lemur = new Lemur();
		System.out.println(lemur.age);
		
		HasTail ht = lemur;
		System.out.println(ht.isTailStriped());
		
		Primate p = lemur;
		System.out.println(p.hasHair());
	}
}