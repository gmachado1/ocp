package br.com.ExceptionsAssertations;


public class CannotSwimExceptions extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CannotSwimExceptions() {
		super();
	}

	public CannotSwimExceptions(Exception e) {
		super(e);
	}

	public CannotSwimExceptions(String message) {
		super(message);
	}
}