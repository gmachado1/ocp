package br.com.io;

import java.io.*;
import java.util.*;

public class CopyTextFileSample {
	public static List<String> readFile(File source) throws IOException {
		List<String> data = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
			String s;
			while ((s = reader.readLine()) != null) {
				data.add(s);
			}
		}
		return data;
	}

	/**
	 * if the file doesn�t exist, it�ll be automatically created.
	 * 
	 * @param data
	 * @param destination
	 * @throws IOException
	 */
	public static void writeFile(List<String> data, File destination) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
			for (String s : data) {
				writer.write(s);
				writer.newLine();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		File dir = new File("/home/gustavo/git/ocp/");
		File source = new File(dir, "teste.txt");
		File destination = new File(dir, "testeBufCopia.txt");
		List<String> data = readFile(source);
		for (String record : data) {
			System.out.println(record);
		}
		writeFile(data, destination);
	}
}