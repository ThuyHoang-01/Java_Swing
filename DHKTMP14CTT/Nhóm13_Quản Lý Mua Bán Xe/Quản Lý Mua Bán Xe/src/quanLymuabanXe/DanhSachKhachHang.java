 	 package quanLymuabanXe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DanhSachKhachHang {
	ArrayList<KhachHang> dskh;
	KhachHang kh;
	
	public DanhSachKhachHang() {
		dskh = new ArrayList<KhachHang>();
		kh = new KhachHang();
	}
	public ArrayList<KhachHang> docTuBang() {
		try {
			Connection con =  DataBase.getInstance().getConnection();
			String sql = "Select * FROM KhachHang"; 
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String diachi = rs.getString(3);
				int sdt = rs.getInt(4);
				KhachHang s = new KhachHang(ma, ten, diachi, sdt);
				dskh.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dskh;
		
	}
	
	public boolean create(String mkh,String tkh,String dc,int sdt) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stml = null;
		int n =0;
		try {
			stml = con.prepareStatement("insert into KhachHang values(?,?,?,?)");
			stml.setString(1, mkh);
			stml.setString(2, tkh);
			stml.setString(3, dc);
			stml.setInt(4,sdt);
			n = stml.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		return n>0;
	}
	
	public boolean update(String mkh,String tenkh,String dc ,int sdt) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update KhachHang "
						+ "set TenKH = ?," 
						+ "DiaChi = ?,"
						+ "SDT = ? "
						+ "where MaKH = ?");
			stmt.setString(1, tenkh);
			stmt.setString(2, dc);
			stmt.setInt(3, sdt);
			stmt.setString(4, mkh);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n > 0;
	}
	
	public boolean delete(String mkh) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stml = null;
		int n = 0;
		try {
			stml = con.prepareStatement("delete from KhachHang where MaKH = ?");
			stml.setString(1, mkh);
			n = stml.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n>0;
	}
	public KhachHang search( String TenKH) {
	        try {
	        	Connection con = DataBase.getInstance().getConnection();
	            String query = "select * from KhachHang where TenKH =? ";
	            PreparedStatement stmt = null;
	            stmt = con.prepareCall(query);
	            stmt.setString(1,  TenKH + '%');
	            stmt.setString(2,  TenKH + '%');
	            ResultSet result = stmt.executeQuery();
	            while (result.next()) {
	                KhachHang std = new KhachHang(result.getString("MaKH"),
	                        result.getString("TenKH"), result.getString("DiaChi"),
	                        result.getInt("SDT"));
	               return std;
	        }
	        
	        } catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
		}
}

