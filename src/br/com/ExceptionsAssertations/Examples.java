package br.com.ExceptionsAssertations;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;

public class Examples {

	public static void main(String[] args) {

		try (ExampleOne t = new ExampleOne()) {
			System.out.println("ExampleOne  :-)");
		} catch (IllegalStateException e) {
			System.out.println("Example");
		}

		try (ExampleTwo t = new ExampleTwo()) {
			System.out.println("ExampleTwo");
		} catch (Exception e) {
			System.out.println("ExampleTwo");
		}
		try (ExampleThree t = new ExampleThree()) {
			System.out.println("ExampleThree");
		}

	}

	public void multiCatch() throws IOException, SQLException, DateTimeParseException {
		try {
			parseData();
		} catch (IOException | SQLException | DateTimeParseException e) {
			System.err.println(e);
			throw e;
		}
	}

	public void parseData() throws IOException, SQLException, DateTimeParseException {

	}

	public void rethrowing() throws IOException, SQLException, DateTimeParseException {
		try {
			parseData();
		} catch (Exception e) {
			System.err.println(e);
			throw e;
		}
	}

}
