package br.com.io2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PathTesting {
	private static String LINE = "_________________________________________________________";

	public static void main(String[] args) {
		{
			System.out.println(LINE);

			try {
				System.out.println(Files.isSameFile(Paths.get("resources/teste.lnk"), Paths.get("teste.txt")));
				System.out.println(Files.isSameFile(Paths.get("../monkey"), Paths.get("/user/monkey")));
				System.out.println(
						Files.isSameFile(Paths.get("/leaves/./giraffe.exe"), Paths.get("/leaves/giraffe.exe")));
				System.out
						.println(Files.isSameFile(Paths.get("/flamingo/tail.data"), Paths.get("/cardinal/tail.data")));
			} catch (IOException e) {
				// Handle file I/O exception...
			}
		}
	}
}
