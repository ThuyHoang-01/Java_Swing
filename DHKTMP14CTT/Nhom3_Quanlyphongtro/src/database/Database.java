package database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Database {
	private String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=qlsv_java;" + "integratedSecurity=true";
	private String user = "sa";
	private String password = "123";
	public static Connection cnt = null;
	private static Database instance = new Database();
	public static Database getInstance() {
		return instance;
	}
	public void connect() {
		cnt = null;
		try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerException");
            cnt = DriverManager.getConnection(url, user, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
	}
	public static Connection getConnection() {
		return cnt;
	}
}
