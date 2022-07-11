package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=QL_khachsan";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "123456";
    static Connection conn = null;

    static PreparedStatement preparedStatement(String cauTruyVan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public connection() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully(kết nối thành công)");
        } catch (ClassNotFoundException ex) {
            System.out.println("lỗi thiếu thư viện");
        } catch (SQLException ex) {
            System.out.println("lỗi kết nối csdl");
        }

    }


    public static ResultSet Getdata(String cauTruyVan){
        try {
            Statement stm=conn.createStatement();
            
            ResultSet rs=stm.executeQuery(cauTruyVan);
            return rs;
        } catch (SQLException ex) {
            System.out.println("lỗi truy vấn");
            return null;
        }
    
    }
    
    public static int ExecuteTruyVan(String cauTruyVan){
        try {
            Statement stm= conn.createStatement();
            return stm.executeUpdate(cauTruyVan);
            
        } catch (SQLException ex) {
            System.out.println("lỗi thực thi truy vấn");
            return -1;
        }
    }

}
