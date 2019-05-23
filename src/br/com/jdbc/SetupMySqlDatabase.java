package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SetupMySqlDatabase {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/zoo?useTimezone=true&serverTimezone=UTC&useSSL=false";// "jdbc:mysql:zoo;create=true";
		String user = "student";
		String pass = "student123";

		try (Connection conn = DriverManager.getConnection(url, user, pass); Statement stmt = conn.createStatement()) {
			stmt.executeUpdate("CREATE TABLE species (" + "id INTEGER PRIMARY KEY, " + "name VARCHAR(255), "
					+ "num_acres DECIMAL)");
			stmt.executeUpdate("CREATE TABLE animal (" + "id INTEGER PRIMARY KEY, " + "species_id integer, "
					+ "name VARCHAR(255), " + "date_born TIMESTAMP)");
			stmt.executeUpdate("INSERT INTO species VALUES (1, 'African Elephant', 7.5)");
			stmt.executeUpdate("INSERT INTO species VALUES (2, 'Zebra', 1.2)");
			
			stmt.executeUpdate("INSERT INTO animal VALUES ('1', '1', 'Elsa', '2008-12-31 02:15:00');");
			stmt.executeUpdate("INSERT INTO animal VALUES ('2', '2', 'Zelda', '2002-08-15 09:12:00');");
			stmt.executeUpdate("INSERT INTO animal VALUES ('3', '1', 'Ester', '2002-09-09 10:36:00');");
			stmt.executeUpdate("INSERT INTO animal VALUES ('4', '1', 'Eddie', '2010-06-08 01:24:00');");
			stmt.executeUpdate("INSERT INTO animal VALUES ('5', '2', 'Zoe', '2005-11-12 03:44:00');");
		}
	}
}