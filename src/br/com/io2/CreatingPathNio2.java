package br.com.io2;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingPathNio2 {

	public static void main(String[] args) {
		{
			Path path1 = Paths.get("/animals.txt");
			Path path2 = Paths.get(
					"C:\\Users\\gustavo\\projetos\\java\\eclipse-workspace\\JavaCertificationProfessionalProgrammer\\zoo.txt");
			Path path3 = Paths.get("/home/gustavo/zoo.txt");
		}
		{
			// Operation System-dependent path
			Path path1 = Paths.get("pandas", "cuddly.png");
			Path path2 = Paths.get("c:", "Users", "gustavo", "projetos", "java", "eclipse-workspace",
					"JavaCertificationProfessionalProgrammer", "zoo.txt");
			Path path3 = Paths.get("/", "home", "gustavo", "zoo.txt");
		}

		{
			try {
				Path path1 = Paths.get(new URI("file://animals.txt"));
				Path path2 = Paths.get(new URI(
						"file:///C:\\Users\\gustavo\\projetos\\java\\eclipse-workspace\\JavaCertificationProfessionalProgrammer\\zoo.txt"));
				Path path3 = Paths.get(new URI("file:///home/gustavo/zoo.txt"));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		{
			try {
				Path path4 = Paths.get(new URI("http://www.wiley.com"));
				Path path5 = Paths.get(new URI("ftp://username:password@ftp.the-ftp-server.com"));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		{

			try {
				Path path4 = Paths.get(new URI("http://www.wiley.com"));
				URI uri4 = path4.toUri();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		{// utiliza FileSystem ao invés de Paths
			Path path1 = FileSystems.getDefault().getPath("/animals.txt");
			Path path2 = FileSystems.getDefault().getPath(
					"C:\\Users\\gustavo\\projetos\\java\\eclipse-workspace\\JavaCertificationProfessionalProgrammer\\zoo.txt");
			Path path3 = FileSystems.getDefault().getPath("/home/gustavo/zoo.txt");
		}
		{
			try {
				FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://www.guga.net"));
				Path path = fileSystem.getPath("duck.txt");
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		{
			// Compatibility PATH and FILE
			File file = new File("pandas/cuddly.png");
			Path path = file.toPath();
		}
		{
			// Compatibility PATH and FILE
			Path path = Paths.get("cuddly.png");
			File file = path.toFile();
		}

	}

}
