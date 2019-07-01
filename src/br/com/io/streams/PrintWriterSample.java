package br.com.io.streams;

import java.io.*;

public class PrintWriterSample {

	public static void main(String[] args) throws IOException {
		
		File source = new File("beach.log");
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(source)))) {
			out.print("Today's weather is: ");
			out.println("Sunny");
			out.print("Today's temperature at the beach is: ");
			out.print(1 / 3.0);
			out.println('C');
			out.format("It has rained 10.12 inches this year");
			out.println();
			out.printf("It may rain 21.2 more inches this year");
		}
	}
}