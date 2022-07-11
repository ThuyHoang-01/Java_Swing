package baiTapLon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class KHConnect {
	public static Connection con = null;
	private static 	KHConnect instance = new KHConnect();
	public static KHConnect getInstance(){
		return instance;
	}
	public void connect(){
		String url = "jdbc:sqlserver://localhost:1433;databasename=hotelmanagement;intergratedSecurity=false";
		String user = "sa";
		String password = "123456";
		try {
			con = DriverManager.getConnection (url, user, password);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
	
}
