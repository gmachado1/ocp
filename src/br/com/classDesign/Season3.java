package br.com.classDesign;

/**
 * is not necessery to implement methos in all enums you can create a default
 * one and implement the spscific ones.
 * 
 * @author gustavo
 *
 */
public enum Season3 {
	WINTER {
		public void printHours() {
			System.out.println("short hours");
		}
	},
	SUMMER {
		public void printHours() {
			System.out.println("long hours");
		}
	},
	SPRING, FALL;
	public void printHours() {
		System.out.println("default hours");
	}
}
