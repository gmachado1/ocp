package br.com.io2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WalkDirectory {

	private static String LINE = "___________________________________________________________________________";

	public static void main(String[] args) {
		{
			System.out.println(LINE + 1);
			Path path = Paths.get("src");
			try {
				Files.walk(path).filter(p -> p.toString().endsWith(".java")).forEach(System.out::println);
			} catch (IOException e) {
				System.out.println("game over 1");
				e.printStackTrace();
			}
		}
		{
			System.out.println(LINE + 2);
			Path path = Paths.get("src");
			long dateFilter = 1420070400000l;
			try {
				Stream<Path> stream = Files.find(path, 10, (p, a) -> p.toString().endsWith(".java")
						&& a.lastModifiedTime().toMillis() > dateFilter && p.toString().endsWith("a.java"));
				stream.forEach(System.out::println);
			} catch (Exception e) {
				System.out.println("game over 2");
				e.printStackTrace();
				// Handle file I/O exception...
			}
		}
		{
			System.out.println(LINE + 3);
			try {
				Path path = Paths.get(
						"C:\\Users\\gustavo\\projetos\\java\\eclipse-workspace\\JavaCertificationProfessionalProgrammer");
				Files.list(path).filter(p -> !Files.isDirectory(p)).map(p -> p.toAbsolutePath())
						.forEach(System.out::println);
			} catch (IOException e) {
				System.out.println("game over 3");
				e.printStackTrace();
				// Handle file I/O exception...
			}
		}
		{
			System.out.println(LINE + 4);
			Path path = Paths.get("beach.log");
			try {
				Files.lines(path).forEach(System.out::println);
			} catch (IOException e) {
				System.out.println("Game Over 4");
				e.printStackTrace();
				// Handle file I/O exception...
			}
		}
		{
			System.out.println(LINE + 5);
			Path path = Paths.get("beach.log");
			try {
				System.out.println(Files.lines(path).filter(s -> s.startsWith("It")).map(s -> s.substring(5))
						.collect(Collectors.toList()));
			} catch (IOException e) {
				System.out.println("game over 5");
				e.printStackTrace();
				// Handle file I/O exception...
			}
		}
	}
}
