package quanLymuabanXe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DanhSachXe {
	ArrayList<Xe> dsXe;
	Xe xe;
	
	public DanhSachXe() {
		dsXe = new ArrayList<Xe>();
		xe = new Xe();
	}
	public ArrayList<Xe> docTuBang() {
		try {
			Connection con =  DataBase.getInstance().getConnection();
			String sql = "Select * FROM Xe"; 
			
					
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				int maXe = rs.getInt(1);
				String tenXe = rs.getString(2);
				String nuocSX = rs.getString(3);
				String loaiXe = rs.getString(4);
				int sopk = rs.getInt(5);
				int soKhung = rs.getInt(6);
				int soLuong = rs.getInt(7);
				String mauXe = rs.getString(8);
				Double gia = rs.getDouble(9);
				Xe s = new Xe(maXe, tenXe, nuocSX, loaiXe, sopk, soKhung, soLuong, mauXe, gia);
				dsXe.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsXe;
		
	}
	
	public boolean create(int maXe,String tenXe,String nuocSX,String loaiXe,int sopk,int soKhung,int soLuong,String mauXe,Double gia) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stml = null;
		int n =0;
		try {
			stml = con.prepareStatement("insert into Xe values(?,?,?,?,?,?,?,?,?)");
			stml.setInt(1, maXe);
			stml.setString(2, tenXe);
			stml.setString(3, nuocSX);
			stml.setString(4,loaiXe);
			stml.setInt(5,sopk);
			stml.setInt(6,soKhung);
			stml.setInt(7,soLuong);
			stml.setString(8,mauXe);
			stml.setDouble(9,gia);
			n = stml.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		return n>0;
	}
	public boolean delete(int mXe) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stml = null;
		int n = 0;
		try {
			stml = con.prepareStatement("delete from Xe where MaXe = ?");
			stml.setInt(1, mXe);
			n = stml.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n>0;
	}
	

}
