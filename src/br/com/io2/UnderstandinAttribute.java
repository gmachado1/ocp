package br.com.io2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class UnderstandinAttribute {

	public static String LINE = "_________________________________________________________________--";

	public static void main(String[] args) {
		{
			System.out.println(LINE + 1);
			try {
				final Path path = Paths.get("ocp/zoo/mammals/wolf.txt");
				System.out.println(Files.getLastModifiedTime(path).toMillis());
				Files.setLastModifiedTime(path, FileTime.fromMillis(System.currentTimeMillis()));
				System.out.println(Files.getLastModifiedTime(path).toMillis());
			} catch (IOException e) {
				System.out.println("Game over 1");
				e.printStackTrace();
				// Handle file I/O exception...
			}
		}
		{
			System.out.println(LINE + 2);
			try {
				// Read owner of file
				Path path = Paths.get("ocp/zoo/mammals/wolf.txt");
				
				System.out.println(Files.getOwner(path).getName());
				// Change owner of file
				UserPrincipal owner = path.getFileSystem().getUserPrincipalLookupService()
						.lookupPrincipalByName("gustavo");
				Files.setOwner(path, owner);
				// Output the updated owner information
				System.out.println(Files.getOwner(path).getName());
			} catch (IOException e) {
				// Handle file I/O exception...
				System.out.println("Game over 2");
				e.printStackTrace();
			}
		}
	}
}
