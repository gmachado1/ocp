package br.com.io2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckPathType {

	private static String LINE = "____________________________________________________________________";

	public static void main(String[] args) {
		{
			System.out.println(LINE);
		}
		{
			Path path1 = Paths.get(
					"C:\\Users\\gustavo\\projetos\\java\\eclipse-workspace\\JavaCertificationProfessionalProgrammer\\zoo.txt");
			System.out.println("Path1 is Absolute? " + path1.isAbsolute());
			System.out.println("Absolute Path1: " + path1.toAbsolutePath());
			Path path2 = Paths.get("JavaCertificationProfessionalProgrammer\\zoo.txt");
			System.out.println("Path2 is Absolute? " + path2.isAbsolute());
			System.out.println("Absolute Path2 " + path2.toAbsolutePath());
		}
		{
			System.out.println(LINE);
			Path path = Paths.get(
					"C:\\Users\\gustavo\\projetos\\java\\eclipse-workspace\\JavaCertificationProfessionalProgrammer\\zoo.txt");
			System.out.println("Path is: " + path);
			// java.lang.IllegalArgumentException if path Number invalid
			System.out.println("ROOT :" + path.getRoot());
			System.out.println("Subpath from 0 to 7 is: " + path.subpath(0, 7));
			System.out.println("Subpath from 1 to 3 is: " + path.subpath(1, 3));
			System.out.println("Subpath from 3 to 6 is: " + path.subpath(3, 6));
		}
		{
			System.out.println(LINE);
			Path path1 = Paths.get("animal.txt");
			Path path2 = Paths.get("zoo.txt");
			System.out.println(path1.relativize(path2));
			System.out.println(path2.relativize(path1));
		}
		{
			System.out.println(LINE);
			// ATENCAO a DIFERENCA
			Path path3 = Paths.get("C:\\Users\\gustavo\\projetos");
			// AMBOS DEVEM SER ABSOLUTOS
			Path path4 = Paths.get(
					"C:\\Users\\gustavo\\projetos\\java\\eclipse-workspace\\JavaCertificationProfessionalProgrammer\\zoo.txt");
			// SE UM dos dois for path relativo, causará // THROWS EXCEPTION AT RUNTIME
			System.out.println(path3.relativize(path4));
			System.out.println(path4.relativize(path3));
			Path path2 = Paths.get("zoo.txt");

			try {
				System.out.println(path2.relativize(path3));// THROWS EXCEPTION AT RUNTIME
			} catch (IllegalArgumentException e) {
				System.out.println("game over...");
			}
			// SE UM dos dois for path em outro drive, causará // THROWS EXCEPTION AT
			// RUNTIME
			Path path1 = Paths.get("e:\\primate\\chimpanzee");
			try {
				System.out.println(path1.relativize(path3));// THROWS EXCEPTION AT RUNTIME
			} catch (IllegalArgumentException e) {
				System.out.println("game over...");
			}
		}
		{
			System.out.println(LINE);
			final Path path1 = Paths.get("/cats/../panther");
			final Path path2 = Paths.get("food");
			System.out.println(path1.resolve(path2));
			System.out.println(path2.resolve(path1));
		}
		{
			System.out.println(LINE);
			final Path path1 = Paths.get("/turkey/food");
			final Path path2 = Paths.get("/tiger/cage");
			System.out.println(path1.resolve(path2));
			System.out.println(path2.resolve(path1));
		}
		{
			System.out.println(LINE);
			Path path3 = Paths.get("/media");
			Path path4 = Paths.get("/home/gustavo");
			Path relativePath = path3.relativize(path4);
			System.out.println(path3.resolve(relativePath));
			System.out.println(path3.resolve(relativePath).normalize());
		}
		{
			System.out.println(LINE);
			// TODO didn´t work, it was expected for the teste.lnk path shows the teste.txt
			// path
			try {
				System.out.println(Paths.get("resources/teste.lnk").toRealPath());
				System.out.println(Paths.get("teste.txt").toRealPath());
				System.out.println(Paths.get("resources/teste.lnk").toAbsolutePath());
				System.out.println(Paths.get("teste.txt").toAbsolutePath());
			} catch (IOException e) {
				// Handle file I/O exception...
				System.out.println("game over..");
			}
		}
		{
			System.out.println(LINE);
			Files.exists(Paths.get("resources"));
			Files.exists(Paths.get("resources\\teste.lnk"));
		}

	}
}
