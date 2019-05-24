package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ResultSet_DateExample {

	public static void main(String[] args) {
		final String url, user, pass;
		url = "jdbc:mysql://localhost:3306/zoo?useTimezone=true&serverTimezone=UTC&useSSL=false";
		user = "student";
		pass = "student123";
		try (Connection conn = DriverManager.getConnection(url, user, pass); Statement stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery("select date_born from animal where name = 'Elsa'");
			while (rs.next()) {
//java.sql.Time or java.sql.TimeStamp
				java.sql.Date sqlDate = rs.getDate(1);// getTime(1) or getTimeStamp(1)
				LocalDate localDate = sqlDate.toLocalDate();// toLocalTime() or toLocalDateTime()
				System.out.println(localDate); // 2008-12-30
			}
		} catch (Exception e) {
			System.out.println("Game Over");
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
