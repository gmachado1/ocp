package br.com.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class MarkExample {

	public static void main(String[] args) {

		{

			File parent = new File("/home/gustavo/git/ocp/");
			File child = new File(parent, "teste.txt");
			try {
				InputStream is = new FileInputStream(child);
				//BufferedInputStream  is = new BufferedInputStream(new FileInputStream(child));

				System.out.print((char) is.read());
				if (is.markSupported()) {
					//is.mark(100);
					System.out.print((char) is.read());
					System.out.print((char) is.read());
					is.reset();
				}
				is.skip(1);
				System.out.print((char) is.read());
				System.out.print((char) is.read());
				System.out.print((char) is.read());
				System.out.print((char) is.read());
				is.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}
