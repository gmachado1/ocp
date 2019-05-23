package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/zoo?useTimezone=true&serverTimezone=UTC&useSSL=false", "student",
				"student123");
		System.out.println(conn);
	}
}
