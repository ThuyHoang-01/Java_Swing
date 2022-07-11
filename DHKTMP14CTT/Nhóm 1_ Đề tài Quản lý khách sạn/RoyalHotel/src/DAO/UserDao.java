package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Entity.User;

public class UserDao {
	public Connection conn;

	public UserDao() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databasename=QL_khachsan;" + "username=sa;password=123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User layUser_theoTen(String tendangnhap) {
		User user = new User();
		try {
			String sql = "SELECT *FROM [dbo].[user] where tenuser =N'" + tendangnhap + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setTendangnhap(rs.getString(1));
				user.setMk(rs.getString(2));
				user.setHovaten(rs.getString(3));
				user.setEmail(rs.getString(4));

			}
		} catch (

		Exception e) {
			// TODO: handle exception
		}
		return user;
	}

	public boolean  UPdateuser(String tendangnhap, String hovaten, String pass2, String email, String quyen) {
        String sql = "UPDATE [dbo].[user]  SET  [password] = N'" +pass2+ "',[role] = N'" +quyen+ "',[hovaten] = N'" +hovaten+ "',[email] =N'" +email+ "'WHERE tenuser=N'" + tendangnhap + "'";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pass2);
			ps.setString(2, quyen);
			ps.setString(3, hovaten);
			ps.setString(4, email);
			ps.setString(5, tendangnhap);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
