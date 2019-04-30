package br.com.chap02;

public class Swimmer {
	enum AnimalClasses {
		MAMMAL {
			public boolean hasFins() {
				return true;
			}
		},
		FISH {
			public boolean hasFins() {
				return true;
			}
		},
		BIRD {
			public boolean hasFins() {
				return true;
			}
		},
		REPTILE {
			public boolean hasFins() {
				return true;
			}
		},
		AMPHIBIAN {
			public boolean hasFins() {
				return true;
			}
		},
		INVERTEBRATE {
			public boolean hasFins() {
				return true;
			}
		};
		public abstract boolean hasFins();
	}

	public static void main(String[] args) {
		System.out.println(AnimalClasses.FISH);
		System.out.println(AnimalClasses.FISH.ordinal());
		System.out.println(AnimalClasses.FISH.hasFins());
		System.out.println(AnimalClasses.BIRD.hasFins());
	}
}
