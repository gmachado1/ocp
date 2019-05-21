package br.com.io;

import java.io.Console;

public class ConsoleExample {

	public static void main(String args[]) {
		String name = "";
		Console c = System.console();
		char[] pw;
		pw = c.readPassword("%s", "pw: ");
		StringBuilder sb = new StringBuilder();

		for (char ch : pw) {
			c.format("%c ", ch);
			sb.append(ch);
		}
		c.format("\n");
		while (!sb.toString().equals(name)) {
			System.out.println(sb.equals(name));
			System.out.println(name);
			System.out.println(sb);
			name = c.readLine("%s", "input?: ");
			c.format("output: %s \n", name);
		}
	}
}
