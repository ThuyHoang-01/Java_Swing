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
	public void connect() {
	  String url = "jdbc:sqlserver://localhost:1433;"
		            + "databaseName=CompanyTouris;"
		            + "integratedSecurity=false";
		   String user = "sa";
		   String password = "manh123";
		try {
			con = DriverManager.getConnection(url,user,password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
}
