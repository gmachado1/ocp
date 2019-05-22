package br.com.io2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributeViewSample {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("ocp/zoo/mammals/wolf.txt");

		BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);

		BasicFileAttributes att = view.readAttributes();
		FileTime lastModifiedTime = FileTime.fromMillis(att.lastModifiedTime().toMillis() + 10_000);
		view.setTimes(lastModifiedTime, null, null);
	}

}
