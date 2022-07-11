package NhanVien;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	private static Connection con = null;
	private static DataBase instance  = new DataBase();
	public static DataBase getInstance() {
		return instance;
	}
	
	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLMBLK";
		String user = "sa";
		String password = "123456";
		try {
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;
	}

}