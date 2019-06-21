package br.com.ExceptionsAssertations;

public class JammedTurkeyCage implements AutoCloseable {
	public void close() throws IllegalStateException {
		throw new IllegalStateException("Cage door does not close");
	}

	public static void main(String[] args) {
		try (JammedTurkeyCage t = new JammedTurkeyCage()) {
			System.out.println("put turkeys in");
		} catch (IllegalStateException e) {
			System.out.println("caught: " + e.getMessage());
		}

		try (ExampleOne t = new ExampleOne()) {
			System.out.println("ExampleOne  :-)");
		} catch (IllegalStateException e) {
			System.out.println("Example");
		}

		try (ExampleTwo t = new ExampleTwo()) {
			System.out.println("ExampleTwo");
		} catch (Exception e) {
			System.out.println("two...");
		}
		try (ExampleThree t = new ExampleThree()) {
			System.out.println("ExampleThree");
		}
		
		try (ExampleOne t = new ExampleOne()) {
			System.out.println("ExampleOne...again  :-)");
		}

	}
}

/**
 * ExampleOne is the best implementation. ExampleTwo throws Exception rather
 * than a more specific subclass, which is not recommended. ExampleThree has a
 * side effect. It changes the state of a variable. Side effects are not
 * recommended.
 *
 */
class ExampleOne implements AutoCloseable {
	public void close() throws IllegalStateException {
		throw new IllegalStateException("ExampleOne does not close");
	}
}

class ExampleTwo implements AutoCloseable {
	public void close() throws Exception {
		throw new Exception("ExampleTwo does not close");
	}
}

class ExampleThree implements AutoCloseable {
	int COUNT = 0;

	public void close() {
		COUNT++;
	}
}