package br.com.io2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PathStudy {

	private static String LINE = "___________________________________________________________________--";

	public static void main(String[] args) {
		String path = "C:\\Users\\gustavo\\projetos\\java\\eclipse-workspace\\JavaCertificationProfessionalProgrammer\\";
		{
			try {
				Files.createDirectory(Paths.get(path + "ocp"));
				Files.createDirectories(Paths.get(path + "ocp/zoo/mammals/primate"));
				System.out.println("okidoki!");
			} catch (IOException e) {
				System.out.println("Game over...0");
				e.printStackTrace();
				// Handle file I/O exception...
			}
		}
		{
			System.out.println(LINE + 1);
			try {
				File newFile = new File("ocp/zoo/mammals/primate/banana.txt");
				boolean success = false;
				Files.createDirectories(Paths.get(path + "/ocp/zoo/mammals/primate-save/"));
				// outra forma de criar arquivo
				// Path newFile = Paths.get("ocp/zoo/mammals/monkie/banana.txt");
				// Files.createFile(newFile);

				do {
					success = newFile.createNewFile();
					if (success) {
						// Files.copy(Paths.get("/ocp/zoo/mammals/monkie"),
						// Paths.get("/ocp/zoo/mammals/monkie-save"));
						// Both directories should be already created to work as expected
						Files.copy(Paths.get(path + "/ocp/zoo/mammals/primate/banana.txt"),
								Paths.get(path + "/ocp/zoo/mammals/primate-save/banana.txt"));

					} else {
						Files.deleteIfExists(newFile.toPath());
					}
				} while (!success);
			} catch (IOException e) {
				System.out.println("game over 1");
				// Handle file I/O exception...
			}
		}
		{
			File source = new File("ocp/zoo/mammals/primate/banana.txt");
			try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(source)))) {
				out.print("3 bananas on my breakfast: is fine.");
				out.println("on sunny days");
				out.print("5 bananas on my breakfast: is fine.");
				out.println("on windy days");
				out.format("2 bananas on my breakfast: is fine.");
				out.println();
				out.printf("If may rain no bananas to eat!");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		{
			System.out.println(LINE + 2);
			try (InputStream is = new FileInputStream("ocp/zoo/mammals/primate/banana.txt");
					OutputStream out = new FileOutputStream("ocp/zoo/mammals/primate-save/banana.txt")) {
				// Copy stream data to file
				Files.copy(is, Paths.get("ocp/zoo/mammals/wolf.txt"));
				// TODO Copy file data to stream NOT WORKING..KNOW WHY??
				Files.copy(Paths.get("ocp/zoo/clown.xsl"), out);
			} catch (IOException e) {
				// Handle file I/O exception...
				System.out.println("game over ...2");
				e.printStackTrace();
			}
		}
		{
			System.out.println(LINE + 3);
			try {
				File newFile = new File("ocp/zoo/mammals/primate-save/banana.txt");
				// delete for be able to move file
				Files.deleteIfExists(newFile.toPath());
				Files.move(Paths.get("ocp/zoo/mammals/primate-save"), Paths.get("ocp/zoo/mammals/primate-move"));
				// if we did´n have deletes it´d get error on next line!
				// DirectoryNotEmptyException
				Files.move(Paths.get("ocp/zoo/mammals/primate/banana.txt"),
						Paths.get("ocp/zoo/mammals/primate-move/banana2.txt"));
			} catch (IOException e) {
				// Handle file I/O exception...
				System.out.println("Game over move...3");
				e.printStackTrace();
			}
		}
		{
			System.out.println(LINE + 4);
			try {
				Files.delete(Paths.get("ocp/zoo/mammals/primate-move/banana2.txt"));
				Files.deleteIfExists(Paths.get("ocp/zoo/mammals/primate-move"));
			} catch (IOException e) {
				// Handle file I/O exception...
				System.out.println("Game over ...4");
				e.printStackTrace();
			}

		}
		List<String> data = new ArrayList();
		{
			System.out.println(LINE + 5);
			Path file = Paths.get("ocp/zoo/mammals/wolf.txt");
			try (BufferedReader reader = Files.newBufferedReader(file, Charset.forName("US-ASCII"))) {
				// Read from the stream
				String currentLine = null;
				while ((currentLine = reader.readLine()) != null) {
					System.out.println(currentLine);
					data.add(currentLine);
				}
			} catch (IOException e) {
				// Handle file I/O exception...
				System.out.println("game over 5");
				e.printStackTrace();
			}
		}
		{
			System.out.println(LINE + 6);
			Path file = Paths.get("ocp/zoo/mammals/primate/gorilla.txt");

			try (BufferedWriter writer = Files.newBufferedWriter(file, Charset.forName("UTF-16"))) {
				writer.write("Hello monkie!");

			} catch (IOException e) {
				// Handle file I/O exception...
				System.out.println("game over bufferWriter... 6");
				e.printStackTrace();
			}

		}
		{
			System.out.println(LINE + 7);
			Path file = Paths.get("ocp/zoo/mammals/wolf.txt");
			try {
				final List<String> lines = Files.readAllLines(file);
				for (String line : lines) {
					System.out.println(line);
				}
			} catch (IOException e) {
				System.out.println("game over 7");
				e.printStackTrace();
				// Handle file I/O exception...
			}
		}
		{
			System.out.println(LINE + 8);
			try {
				System.out.println(Files.isHidden(Paths.get("ocp/zoo/mammals/wolf.txt")));
			} catch (IOException e) {
				System.out.println("game over 8");
				e.printStackTrace();
				// Handle file I/O exception...
			}
		}
		{
			System.out.println(LINE + 9);
			try {
				System.out.println(Files.size(Paths.get("ocp/zoo/mammals/wolf.txt")));
			} catch (IOException e) {
				System.out.println("game over 9");
				e.printStackTrace();
				// Handle file I/O exception...
			}
		}
		{
			
		}

	}

}
