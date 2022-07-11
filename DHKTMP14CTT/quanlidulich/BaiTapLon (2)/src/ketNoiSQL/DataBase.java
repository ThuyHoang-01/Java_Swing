package ketNoiSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	public static Connection con = null;
	public static DataBase instance = new DataBase();
	public static DataBase getInstance() {
		return instance;
		
	}
	public static void connect() {
	  
		try {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=CompanyTouris;integratedSecurity=true";
		   String user = "sa";
		   String password = "sapassword";
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Ket noi thanh cong !!!!!!!!!!");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Ket Noi That Bai!!!!!!!!!");
		}
	}
	public static Connection getConnection() {
		connect();
		return con;
	}
}
