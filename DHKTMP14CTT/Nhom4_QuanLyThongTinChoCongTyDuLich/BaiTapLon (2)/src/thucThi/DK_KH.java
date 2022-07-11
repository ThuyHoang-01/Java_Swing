package thucThi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import enTiTy.KhachHang;
import ketNoiSQL.DataBase;

public class DK_KH {
	ArrayList<KhachHang> lkh;
	KhachHang tt = new KhachHang();
	public boolean createKH(String tenkh, String email, String sdt,
			   String user, String pass) {
		   DataBase.getInstance();
	       Connection con = DataBase.getConnection();
	       PreparedStatement stmt= null;
	       int n=0;
	       try
	       {
	               stmt = con.prepareStatement("insert into Customer values(?,?,?,?,?)");
	               stmt.setString(1, tenkh);
	               stmt.setString(2, email);
	               stmt.setString(3, sdt);
	               stmt.setString(4, user);
	               stmt.setString(5, pass);
	               n = stmt.executeUpdate();
	       }catch (SQLException e) {
	               e.printStackTrace();
	       }
	       return n>0;   
	   }
}
