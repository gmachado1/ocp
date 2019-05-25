package br.com.classDesign;

public class EnumExample {

	public static void main(String[] args) {
		Season s = Season.SUMMER;
		System.out.println(Season.SUMMER); // SUMMER
		System.out.println(s == Season.SUMMER); // true
		for (Season season : Season.values()) {
			System.out.println(season.name() + " " + season.ordinal());
		}
		
		switch (s) {
			case WINTER:
			System.out.println("Get out the sled!");
			break;
			case SUMMER:
			System.out.println("Time for the pool!");
			break;
			default:
			System.out.println("Is it summer yet?");
			}
	}
}
