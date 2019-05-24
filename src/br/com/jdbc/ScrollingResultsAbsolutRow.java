package br.com.jdbc;

import java.sql.*;

public class ScrollingResultsAbsolutRow {

	public static void main(String[] args) {
		final String url, user, pass;
		url = "jdbc:mysql://localhost:3306/zoo?useTimezone=true&serverTimezone=UTC&useSSL=false";
		user = "student";
		pass = "student123";
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
			ResultSet rs = stmt.executeQuery("select id from animal order by id ");
			 System.out.println(rs.next()); // true
			 System.out.println(rs.getString("id")); // 1
			 System.out.println(rs.relative(2)); // true
			 System.out.println(rs.getString("id")); // 3
			 System.out.println(rs.relative(-1)); // true
			 System.out.println(rs.getString("id")); // 2
			 System.out.println(rs.relative(4)); // false
			 /**  id fk  name  born
		1 -5  *    1  1  Elsa 2001-05-06 02:15:00
		2 -4  *    2  2  Zelda 2002-08-15 09:12:00
		3 -3  *    3  1  Ester 2002-09-09 10:36:00
		4 -2  *    4  1  Eddie 2010-06-08 01:24:00
		5 -1  *    5  2  Zoe 2005-11-12 03:44:00
	 absolut  */
		} catch (Exception e) {
			System.out.println("Game over!");
			e.printStackTrace();
			// TODO: handle exception
			
		}

	}

}
