package connect;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public Connect() {
		
	}
	public static Connection getConnect() {
		Connection connect = null;
		String url ="jdbc:sqlserver://localhost:1433;databaseName=QuanLyLaoDong";
		try {
			connect = DriverManager.getConnection(url, "sa","saadmin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connect;
	}

}
