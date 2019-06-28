package br.com.io.fileobj;

import java.io.File;

public class FileSample {
	public static void main(String[] args) {
		{
			File fileL = new File("/home/gus/data/zoo.txt");// Linux
			File fileW = new File("C:\\repositorio\\git\\ocp\\zoo.txt");// windows
			System.out.println(fileL.exists());
			System.out.println(fileW.exists());
		}
		{// linux
			File parent = new File("/home/gustavo/git/ocp/");
			File child = new File(parent, "/home/gustavo/git/ocp/zoo.txt");
			System.out.println(child.exists());
		}
		{// windows
			File parent = new File("C:\\repositorio\\git");
			File child = new File(parent, "ocp\\zoo.txt");
			System.out.println(child.exists());
		}

	}
}
