package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;

public class NhanVien_DAO {
	public NhanVien_DAO() {
		
	}
	public ArrayList<NhanVien> getalltbNhanVien(){
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select * from nhanvien";
			Statement statement = (Statement) con.createStatement(); 
			ResultSet rs = ((java.sql.Statement) statement).executeQuery(sql);
			
			while (rs.next()) {
				int maNV = rs.getInt(1);
				String hoNV = rs.getString(2);
				String tenNV = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				double luong = rs.getDouble(6);
				
				PhongBan pBan = new PhongBan(rs.getString(7), tenNV);
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, pBan);
				dsnv.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return dsnv;
	}
	
	public ArrayList<NhanVien> getNhanVienTheoMaNV(int id){
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Select * from nhanvien where manv = ?";
			statement = con.prepareStatement(sql);
			statement.setInt(1, id);
		
			ResultSet rs = ((java.sql.Statement) statement).executeQuery(sql);
			
			while (rs.next()) {
				int maNV = rs.getInt(1);
				String hoNV = rs.getString(2);
				String tenNV = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				double luong = rs.getDouble(6);
				
				PhongBan pBan = new PhongBan(rs.getString(7), tenNV);
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, pBan);
				dsnv.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return dsnv;
	}

	public ArrayList<NhanVien> getNhanVienTheoPhongBan(String idpb){
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Select * from nhanvien where maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, idpb);
		
			ResultSet rs = ((java.sql.Statement) statement).executeQuery(sql);
			
			while (rs.next()) {
				int maNV = rs.getInt(1);
				String hoNV = rs.getString(2);
				String tenNV = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				double luong = rs.getDouble(6);
				
				PhongBan pBan = new PhongBan(rs.getString(7), tenNV);
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, pBan);
				dsnv.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return dsnv;
	}
	
	public boolean create(NhanVien nv){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + "NhanVien values(?,?,?,?,?,?,?)");
			stmt.setInt(1,nv.getMaNv());
			stmt.setString(2, nv.getHoNV());
			stmt.setString(3, nv.getTenNv());
			stmt.setInt(4,nv.getTuoi());
			stmt.setBoolean(5,nv.isPhai());
			stmt.setDouble(6, nv.getLuong());
	    	stmt.setString(7, nv.getPhong().getMaPhongBan());
			 n = stmt.executeUpdate();
			}
		 catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
			stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return n > 0;
	}
	
	public boolean update(NhanVien nv){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien set hoNV = ?, tenNV = ?" + "tuoiNV = ?, phai = ? , luong = ?, phongban = ?"+"where maNV = ?");
			stmt.setInt(1,nv.getMaNv());
			stmt.setString(2, nv.getHoNV());
			stmt.setString(3, nv.getTenNv());
			stmt.setInt(4,nv.getTuoi());
			stmt.setBoolean(5,nv.isPhai());
			stmt.setDouble(6, nv.getLuong());
	    	stmt.setString(7, nv.getPhong().getMaPhongBan());
			 n = stmt.executeUpdate();
			}
		 catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
			stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return n > 0;
	}
	
}

