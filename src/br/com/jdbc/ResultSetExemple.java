package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetExemple {

	public static void main(String[] args) {
		String url, user, pass;
		url = "jdbc:mysql://localhost:3306/zoo?useTimezone=true&serverTimezone=UTC&useSSL=false";
		user = "student";
		pass = "student123";
		try (Connection conn = DriverManager.getConnection(url, user, pass); Statement stmt = conn.createStatement();) {
			String sql = "select * from species";
			boolean isResultSet = stmt.execute(sql);
			if (isResultSet) {
				ResultSet rs = stmt.getResultSet();
				System.out.println("ran query");
			} else {
				int result = stmt.getUpdateCount();
				System.out.println("ran update");
			}
		} catch (SQLException e) {
			System.out.println("game over!");
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}
