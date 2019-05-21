package br.com.io;

import java.io.File;

public class FileSample {
	public static void main(String[] args) {
		{
			File fileL = new File("/home/gus/data/zoo.txt");
			File fileW = new File(
					"/home/gustavo/git/ocp/zoo.txt");
			System.out.println(fileL.exists());
			System.out.println(fileW.exists());
		}
		{
			File parent = new File("/home/gustavo/git/ocp/");
			File child = new File(parent, "/home/gustavo/git/ocp/zoo.txt");
			System.out.println(child.exists());
		}

	}
}
