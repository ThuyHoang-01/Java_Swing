package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();
	public static ConnectDB getInstance() {
		return instance;
	}
	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static Connection getConnection() {
		return con;
	}
	
	public static Connection ketnoi() {
		Connection con = null;
		String url = "jdbc:sqlserver://localhost:1433;databasename=QL_NhanVien";
		String name = "sa";
		String pass = "123";
		
		try {
			con = DriverManager.getConnection(url,name,pass);
		} catch (SQLException e) {
			System.out.println("Loi ket noi!");
		}
		return con;
	}

}