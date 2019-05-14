package br.com.io;

import java.io.File;

public class FileSample {
	public static void main(String[] args) {
		{
			File fileL = new File("/home/gus/data/zoo.txt");
			File fileW = new File(
					"C:\\Users\\gustavo\\projetos\\java\\eclipse-workspace\\JavaCertificationProfessionalProgrammer\\zoo.txt");
			System.out.println(fileL.exists());
			System.out.println(fileW.exists());
		}
		{
			File parent = new File("C:\\\\Users\\\\gustavo\\\\projetos\\\\java\\\\eclipse-workspace\\\\");
			File child = new File(parent, "JavaCertificationProfessionalProgrammer\\\\zoo.txt");
			System.out.println(child.exists());
		}

	}
}
