package br.com.chap04;

interface Gorilla {
	String move();
}

public class GorillaFamily {
	static String walk = "walk";

	static void everyonePlay(boolean baby) {
		String approach = "amble";
		// approach = "run";

		play(() -> walk);
		play(() -> baby ? "hitch a ride" : "run");
		play(() -> approach);
	}

	static void play(Gorilla g) {
		System.out.println(g.move());
	}
	
	public static void main(String args[]) {
		System.out.println("true");
		everyonePlay(true);
		System.out.println("\nfalse");
		everyonePlay(false);
	}
}