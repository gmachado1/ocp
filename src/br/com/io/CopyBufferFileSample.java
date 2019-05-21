package br.com.io;

import java.io.*;

public class CopyBufferFileSample {

	public static void main(String[] args) throws IOException {
		File dir = new File("/home/gustavo/git/ocp/");
		File source = new File(dir, "teste.txt");
		File destination = new File(dir, "testeBufCopia.txt");
		copy(source, destination);
	}

	public static void copy(File source, File destination) throws IOException {
		try (InputStream in = new BufferedInputStream(new FileInputStream(source));
				OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
			byte[] buffer = new byte[1024];
			int lengthRead;
			while ((lengthRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
		}
	}
}
