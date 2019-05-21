package br.com.io;

import java.io.*;

public class CopySampleFile {

	public static void main(String[] args) throws IOException {
		File dir = new File("/home/gustavo/git/ocp/");
		File source = new File(dir,"teste.txt");
		File destination = new File(dir, "testeCopia.txt");
		copy(source, destination);
	}

	public static void copy(File source, File destination) throws IOException {
		try (InputStream in = new FileInputStream(source); 
				OutputStream out = new FileOutputStream(destination)) {
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
		}
	}

}
