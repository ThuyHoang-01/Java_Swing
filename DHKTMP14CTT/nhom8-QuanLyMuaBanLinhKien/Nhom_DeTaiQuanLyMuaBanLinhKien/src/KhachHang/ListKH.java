package KhachHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ListKH {
		
		ArrayList<KhachHang> dskh;
		KhachHang kh;
		
		public ListKH() {
			dskh = new ArrayList<KhachHang>();
			kh = new KhachHang();
		}
		
		public ArrayList<KhachHang> docTuBang() {
			try {
				Connection con =  Database.getInstance().getConnection();
				String sql = "Select * from KhachHang";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				
				while(rs.next()) {
					String maKH = rs.getString(1);
					String tenKH = rs.getString(2);
					String email = rs.getString(3);
					String diaChi = rs.getString(4);
					String soDT = rs.getString(5);
					KhachHang kh = new KhachHang(maKH, tenKH, email, diaChi,soDT);
					dskh.add(kh);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dskh;
			
		}
		
		public boolean create(String maKH,String tenKH,String email,String diaChi,String soDT) {
			Connection con = Database.getInstance().getConnection();
			PreparedStatement stml = null;
			int n =0;
			try {
				stml = con.prepareStatement("insert into KhachHang values(?,?,?,?,?)");
				stml.setString(1, maKH);
				stml.setString(2, tenKH);
				stml.setString(3, email);
				stml.setString(4, diaChi);
				stml.setString(5, soDT);
				n = stml.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
			}
			return n>0;
		}
		
		public boolean update(String maKH,String tenKH,String email,String diaChi,String soDT) {
			Connection con = Database.getInstance().getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("update KhachHang "
											+ "set TenKH = ?,"
											+ "Email = ?"
											+ "DiaChi = ?"
											+ "SoDT = ?" 
											+ "where MaKH = ?");
				stmt.setString(1, tenKH);
				stmt.setString(2, email);
				stmt.setString(3, diaChi);
				stmt.setString(4, soDT);
				stmt.setString(5, maKH);
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				
			}
			return n > 0;
		}
		
		public boolean delete(String maKH) {
			Connection con = Database.getInstance().getConnection();
			PreparedStatement stml = null;
			int n = 0;
			try {
				stml = con.prepareStatement("delete from KhachHang where MaKH = ?");
				stml.setString(1, maKH);
				n = stml.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				
			}
			return n>0;
		}
		/*
		public KhachHang timKiem(String tenNV) {
			try {
				Connection con = Database.getInstance().getConnection();
				String sql = "Select * from KHACHHANG where TENKHACHHANG = ?";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				
				if(rs != null) {
					String maKH = rs.getString(1);
					String tenKH = rs.getString(2);
					String email = rs.getString(3);
					String diaChi = rs.getString(4);
					String soDT = rs.getString(5);
					KhachHang kh = new KhachHang(maKH, tenKH, email,diaChi,soDT);
					return kh;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
			
		}
		
		public KhachHang timkiem(String tenKH) {
			
			KhachHang k = new KhachHang(tenKH);
			if(dskh.contains(k)) {
				return dskh.get(dskh.indexOf(k));
			}
			return null;
		}
		*/
	}