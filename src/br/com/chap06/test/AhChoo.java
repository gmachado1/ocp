package br.com.chap06.test;

public class AhChoo {
	static class SneezeException extends Exception {
	}

	static class SniffleException extends SneezeException {
	}

	public static void main(String[] args) throws SneezeException {
		try {
			throw new SneezeException();
		} catch (SneezeException e) {
			//e = new SneezeException();
			//e = new SniffleException();
			throw e;
		}
	}
}
