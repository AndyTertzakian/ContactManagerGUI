package broker;

/*
 * Author: Andre Tertzakian
 * September, 2014
 */

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class MySqlConnection {

	public MySqlConnection() {
		if (conn == null) {
			setup();
		}
	}

	private static Connection conn;

	private static void setup() {
		try {
			String url = "jdbc:mysql://localhost:3306/contacts";
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = (Connection) DriverManager.getConnection(url, "root", "password");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		if (conn == null) {
			setup();
		}
		return conn;
	}

}
