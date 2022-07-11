package DAO;

import java.sql.ResultSet;

public class DangNhap {
	public static ResultSet Dangnhap(String tendangnhap) {
        String cautruyvan = "SELECT *FROM [dbo].[user] WHERE tenuser =N'" + tendangnhap + "'";
        return connection.Getdata(cautruyvan);

    }

    public static ResultSet Ktra_trung() {
        String cautruyvan = "SELECT *FROM [dbo].[user]";
        return connection.Getdata(cautruyvan);
    }

}
