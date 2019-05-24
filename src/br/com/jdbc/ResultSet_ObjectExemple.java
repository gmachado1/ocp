package br.com.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ResultSet_ObjectExemple {

	public static void main(String[] args) {
		final String url, user, pass;
		url = "jdbc:mysql://localhost/zoo?useTimezone=true&serverTimezone=UTC&useSSL=false";
		user = "student";
		pass = "student123";
		try (Connection conn = DriverManager.getConnection(url, user, pass); Statement stmt = conn.createStatement();) {
			String sql = "select id, name from species";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Object idField = rs.getObject("id");
				Object nameField = rs.getObject("name");
				if (idField instanceof Integer) {
					int id = (Integer) idField;
					System.out.println(id);
				}
				if (nameField instanceof String) {
					String name = (String) nameField;
					System.out.println(name);
				}
			}

		} catch (SQLException e) {
			System.out.println("Game over 1");
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
