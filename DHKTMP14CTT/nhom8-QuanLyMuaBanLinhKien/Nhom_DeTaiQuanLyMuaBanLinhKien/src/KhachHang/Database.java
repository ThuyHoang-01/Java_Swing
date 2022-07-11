package KhachHang;


import java.sql.Connection;
import java.sql.DriverManager;



public class Database {
	private static Connection con =null;
	private static Database instance = new Database();
	public static Database getInstance() {
		return instance;
	}
	
	

	public void connect() {
		 String URL="jdbc:sqlserver://localhost:1433;databasename=QLMBLK";
		 String user="sa";
		 String password="123456";
		try {
			con = DriverManager.getConnection(URL,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return con;
	}

}
