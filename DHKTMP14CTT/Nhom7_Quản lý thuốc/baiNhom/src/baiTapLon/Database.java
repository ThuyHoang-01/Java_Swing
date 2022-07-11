package baiTapLon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	public static Connection con = null;
	private static Database instance = new Database();
	public static Database getInstance() {
		return instance;
	}
	public void connec() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLQT";
		String user = "sa";
		String password = "sapassword";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
}
