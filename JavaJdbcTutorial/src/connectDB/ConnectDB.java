package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB {

	public static Connection con =null;
	public static ConnectDB i =new ConnectDB();
	private static ConnectDB geti() {
		return i ;
	}
	public static void connect() {
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLMonHoc","sa","sapassword");
			System.out.println("thanh cong");
		} catch (Exception e) {
			System.out.println("that bai ");
		}
	}
	public static Connection getConnection() {
		return con;
	}
}
