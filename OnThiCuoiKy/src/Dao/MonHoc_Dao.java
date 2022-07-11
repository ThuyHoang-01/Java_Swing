package Dao;
//25 18092291 TranMinhNhut

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Database;
import entity.BoMon;
import entity.MonHoc;

public class MonHoc_Dao {
	public static ArrayList<MonHoc> getall() {
		ArrayList<MonHoc> dsmh = new ArrayList<MonHoc>();
		try {
			Connection con =Database.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("Select *from MonHoc");
			while (rs.next()) {
				MonHoc mh = new MonHoc(rs.getString(1),rs.getString(2),new BoMon(rs.getString(3)),rs.getInt(4));
				dsmh.add(mh);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsmh;
	}
	public static boolean themMH(MonHoc mh ) {
		Connection con =Database.getConnection();
		PreparedStatement stmt =null;int n=0;
		try {
			stmt=con.prepareStatement("insert into MonHoc values(?,?,?,?)");
			stmt.setString(1, mh.getMaMon());
			stmt.setString(2, mh.getTenMon());
			stmt.setString(3,mh.getBm().getMaMon());
			stmt.setInt(4, mh.getSoTiet());
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
		
	}
	public static void xoaMH(String ma ) {
		Connection con =Database.getConnection();
		PreparedStatement stmt =null;int n=0;
		try {
			stmt=con.prepareStatement("delete from MonHoc where maMon = ?");
			stmt.setString(1, ma);
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception

		}
		
		
	}
	
}
