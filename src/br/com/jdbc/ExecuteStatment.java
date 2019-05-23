package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteStatment {

	public static void main(String[] args) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/zoo?useTimezone=true&serverTimezone=UTC&useSSL=false", "student",
					"student123");
			Statement stmt = conn.createStatement();
			int result = stmt.executeUpdate("insert into species values(10, 'Deer', 3)");
			System.out.println(result); // 1
			result = stmt.executeUpdate("update species set name = '' where name = 'None'");
			System.out.println(result); // 0
			result = stmt.executeUpdate("delete from species where id = 10");
			System.out.println(result); // 1
		} catch (SQLException e) {
			System.out.println("Game Over!");
			e.printStackTrace();
		}
		

	}
}
