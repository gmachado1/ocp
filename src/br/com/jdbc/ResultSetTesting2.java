package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ResultSetTesting2 {

	public static void main(String[] args) {
		final String url, user, pass;
		url = "jdbc:mysql://localhost:3306/zoo?useTimezone=true&serverTimezone=UTC&useSSL=false";
		user = "student";
		pass = "student123";
		try (Connection conn = DriverManager.getConnection(url, user, pass); Statement stmt = conn.createStatement();) {
			Map<Integer, String> idToNameMap = new HashMap<>();
			ResultSet rs = stmt.executeQuery("select id, name from species");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				idToNameMap.put(id, name);
			}
			System.out.println(idToNameMap); // {1=African Elephant, 2=Zebra}
		} catch (Exception e) {
			System.out.println("Game Over");
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
