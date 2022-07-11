package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import db.Database;
import entity.BoMonChuQuan;
import entity.MonHoc;

public class MonHoc_DAO {

	public static ArrayList<MonHoc> getall() {
		ArrayList<MonHoc> dsmh = new ArrayList<MonHoc>();
			try {
				Connection con = Database.getConnection();
				Statement s = con.createStatement();	
				ResultSet rs = s.executeQuery("Select *from MonHoc");
				while(rs.next()) {
					MonHoc mh = new MonHoc(rs.getString(1),rs.getString(2),new BoMonChuQuan(rs.getString(3)),rs.getInt(4));
					dsmh.add(mh);
				}
			
			} catch (SQLException e) {
				
			}
			return dsmh;
	}
	
	public static void themMH(MonHoc mh) {
		Connection con =Database.getConnection();
		PreparedStatement stmt =null;//int n=0;
		
		try {
			stmt= con.prepareStatement("insert into MonHoc values(?,?,?,?)");
			stmt.setString(1, mh.getMaMon());
			stmt.setString(2, mh.getTenMon());
			stmt.setString(3,mh.getBm().getMaBoMonCQ());
			stmt.setInt(4, mh.getSoTiet());
			stmt.executeUpdate();
			JOptionPane.showConfirmDialog( null, "Đã thêm thành công ");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showConfirmDialog(null, "Đã thêm thất bại");
		}
		
	}
	
	public static void xoaMH(String ma) {
		Connection con =Database.getConnection();
		PreparedStatement stmt =null;//int n=0;
		
		try {
			stmt = con.prepareStatement("delete from MonHoc where maMon = ?");
			stmt.setString(1, ma);
			stmt.executeUpdate();
			JOptionPane.showConfirmDialog(null, "Đã xóa  thành công ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showConfirmDialog( null, "Xóa không thành công ");
		}
		
		
	}
}
