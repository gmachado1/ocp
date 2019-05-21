package br.com.io2;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.sampled.Line;

public class UsingPath {

	private static String LINE = "___________________________________________________________________________";

	public static void main(String[] args) {
		{
			Path path = Paths.get("/home/gustavo/git/zoo.txt");
			System.out.println("The Path Name is: " + path);
			for (int i = 0; i < path.getNameCount(); i++) {
				System.out.println(" Element " + i + " is: " + path.getName(i));
			}
		}
		{
			System.out.println(LINE);
			printPathInformation(Paths.get(
					"C:\\Users\\gustavo\\projetos\\java\\eclipse-workspace\\JavaCertificationProfessionalProgrammer\\zoo.txt"));
			System.out.println();
			printPathInformation(Paths.get("JavaCertificationProfessionalProgrammer\\zoo.txt"));

		}
		{
			System.out.println(LINE);
			
		}
	}

	public static void printPathInformation(Path path) {
		System.out.println("Filename is: " + path.getFileName());
		System.out.println("Root is: " + path.getRoot());
		Path currentParent = path;
		while ((currentParent = currentParent.getParent()) != null) {
			System.out.println(" Current parent is: " + currentParent);
		}
	}

}
