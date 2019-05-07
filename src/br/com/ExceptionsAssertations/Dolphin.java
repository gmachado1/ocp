package br.com.ExceptionsAssertations;

class CannotSwimException extends Exception {
	public CannotSwimException() {
		super();
	}

	public CannotSwimException(Exception e) {
		super(e);
	}

	public CannotSwimException(String message) {
		super(message);
	}
}

class DangerInTheWaterException extends RuntimeException {
}

class SharkInTheWater extends DangerInTheWaterException {
}

public class Dolphin {
	public static void main(String[] args) {

	}

	public void swim() throws CannotSwimException {

	}

}
