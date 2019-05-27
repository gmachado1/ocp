package br.com.classDesign.exam;

public enum AnimalClasses {
																								//if it has params need ;
	MAMMAL(true), FISH(Boolean.FALSE), BIRD(false), REPTILE(false), AMPHIBIAN(false), INVERTEBRATE(false);

	boolean hasHair;

	private AnimalClasses(boolean hasHair) { //PRECISA SER PRIVATE
		this.hasHair = hasHair;
	}

	public boolean hasHair() {
		return hasHair;
	}

	public void giveWig() {
		hasHair = true;
	}
}