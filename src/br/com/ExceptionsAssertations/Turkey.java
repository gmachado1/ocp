package br.com.ExceptionsAssertations;

public class Turkey implements AutoCloseable {

	@Override
	public void close() {
		System.out.println("Close");

	}

	public static void main(String[] args) {
		try (Turkey t = new Turkey()) {
			System.out.println("put turkeys in");
		}
	}

}
