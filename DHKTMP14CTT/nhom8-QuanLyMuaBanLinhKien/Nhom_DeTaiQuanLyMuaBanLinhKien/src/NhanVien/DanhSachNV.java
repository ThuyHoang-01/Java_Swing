package NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DanhSachNV {
	ArrayList<NhanVien> dsnv;
	NhanVien nv;
	
	public DanhSachNV() {
		dsnv = new ArrayList<NhanVien>();
		nv = new NhanVien();
	}
	
	public ArrayList<NhanVien> docTuBang() {
		try {
			Connection con =  DataBase.getInstance().getConnection();
			String sql = "Select * from NHANVIEN";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				float luong = rs.getFloat(3);
				NhanVien nv = new NhanVien(ma, ten, luong);
				dsnv.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
		
	}
	
	public boolean create(String manv,String tnv,float luong) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stml = null;
		int n =0;
		try {
			stml = con.prepareStatement("insert into NHANVIEN values(?,?,?)");
			stml.setString(1, manv);
			stml.setString(2, tnv);
			stml.setFloat(3, luong);
			n = stml.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		return n>0;
	}
	
	public boolean update(String mavn,String tnv,float luong) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NHANVIEN "
						+ "set TENNHANVIEN = ?," 
						+ "TIENLUONG = ? "
						+ "where MANHANVIEN = ?");
			stmt.setString(1, tnv);
			stmt.setFloat(2, luong);
			stmt.setString(3, mavn);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n > 0;
	}
	
	public boolean delete(String manv) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stml = null;
		int n = 0;
		try {
			stml = con.prepareStatement("delete from NHANVIEN where MANHANVIEN = ?");
			stml.setString(1, manv);
			n = stml.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n>0;
	}
	
	public NhanVien timKiem(String maNV) {
		try {
			Connection con = DataBase.getInstance().getConnection();
			String sql = "Select * from NHANVIEN where MANHANVIEN = ?";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs != null) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				float luong = rs.getFloat(3);
				NhanVien nv = new NhanVien(ma, ten, luong);
				return nv;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	
	public NhanVien timkiem(String maNV) {
		
		NhanVien nv = new NhanVien(maNV);
		if(dsnv.contains(nv)) {
			return dsnv.get(dsnv.indexOf(nv));
		}
		return null;
	}
	
	
}
