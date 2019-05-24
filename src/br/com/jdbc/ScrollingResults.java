package br.com.jdbc;

import java.sql.*;

public class ScrollingResults {

	public static void main(String[] args) {
		final String url, user, pass;
		url = "jdbc:mysql://localhost:3306/zoo?useTimezone=true&serverTimezone=UTC&useSSL=false";
		user = "student";
		pass = "student123";
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
			ResultSet rs = stmt.executeQuery("select id from species order by id ");
			rs.afterLast();
			// if resultSet has no result previous/last/first return false
			System.out.println(rs.previous());// true
			System.out.println(rs.getInt(1));// 2
			System.out.println(rs.previous());// true
			System.out.println(rs.getInt(1));// 1
			System.out.println(rs.last());// true
			System.out.println(rs.getInt(1));// 2
			System.out.println(rs.first());// true
			System.out.println(rs.getInt(1));// 1
			rs.beforeFirst();
			System.out.println(rs.getInt(1));// SQLException
		} catch (Exception e) {
			System.out.println("Game over!");
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
