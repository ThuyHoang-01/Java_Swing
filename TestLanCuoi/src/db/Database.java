package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	private static Database i = new Database();
	private static Connection con;

	public static Database geti() {
		return i;
		
	}
	public static Connection getConnection() {
		return con;
		
	}
	public static void connect() {
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLMonHoc","sa","saadmin");
			System.out.println("ket noi thanh cong");
		} 
		catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("ket noi that bai");
		}
		
	}

}
