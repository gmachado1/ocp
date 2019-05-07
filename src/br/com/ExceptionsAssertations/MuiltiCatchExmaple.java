package br.com.ExceptionsAssertations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.MissingResourceException;

public class MuiltiCatchExmaple {
	public static void main(String[] args) {
		try {
			Path path = Paths.get("dolphinsBorn.txt");
			String text = new String(Files.readAllBytes(path));
			LocalDate date = LocalDate.parse(text);
			System.out.println(date);
		} catch (DateTimeParseException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void doesNotCompile() { // METHOD DOES NOT COMPILE
		try {
			mightThrow();
		} catch ( IllegalStateException |IllegalArgumentException|FileNotFoundException e) {
			// } catch (InputMismatchException e | MissingResourceException e) {
		} catch (MissingResourceException| InputMismatchException  e) {
		} catch (ArrayIndexOutOfBoundsException e) {
		} catch (SQLException | IOException e) {
		} catch (Exception e) {
		}
	}

	private void mightThrow() throws DateTimeParseException, IOException, SQLException {
	}
}
