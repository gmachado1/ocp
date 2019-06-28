package br.com.io.fileobj;

import java.io.File;

public class ReadFileInformation {
	public static void main(String[] args) {
		 {	
			//windows
			String pathText = "C:\\repositorio\\git\\ocp\\zoo.txt";
			File file = new File(pathText);
			System.out.println("File Exists:(Windows) " + file.exists());
			if (file.exists()) {
				System.out.println("Absolute Path: " + file.getAbsolutePath());
				System.out.println("Is Directory: " + file.isDirectory());
				System.out.println("Parent Path: " + file.getParent());
				if (file.isFile()) {
					System.out.println("File size: " + file.length());
					System.out.println("File LastModified: " + file.lastModified());
				} else {
					for (File subfile : file.listFiles()) {
						System.out.println("\t" + subfile.getName());
					}
				}
			}
		}
		{	
			//Linux
			System.out.println("\n\n\n File exist(LINUX):");
			String simplePath = "/home/gustavo/git/ocp/zoo.txt";
			File file = new File(simplePath);
			System.out.println("File Exists: " + file.exists());
			if (file.exists()) {
				System.out.println("Absolute Path: " + file.getAbsolutePath());
				System.out.println("Is Directory: " + file.isDirectory());
				System.out.println("Parent Path: " + file.getParent());
				if (file.isFile()) {
					System.out.println("File size: " + file.length());
					System.out.println("File LastModified: " + file.lastModified());
				} else {
					for (File subfile : file.listFiles()) {
						System.out.println("\t" + subfile.getName());
					}
				}
			}
		}
		
	}
}
