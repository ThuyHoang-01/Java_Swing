package MatHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import NhanVien.DataBase;
import NhanVien.NhanVien;

public class ListHang {
	ArrayList<MatHang> listHang;
	MatHang mh;
	public ListHang() {
		listHang = new ArrayList<MatHang>();
		mh = new MatHang();
	}
	
	
	
	public ArrayList<MatHang> docTuBang(){
		try {
			Connection con =  DataBase.getInstance().getConnection();
			String sql = "Select * from MatHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String nhaCC = rs.getString(3);
				float gia = rs.getFloat(4);
				int soLuong = rs.getInt(5);
				MatHang mh = new MatHang(ma, ten, nhaCC, gia, soLuong);
				listHang.add(mh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listHang;
	}
	
	
	public boolean create(String maH,String tenH,String nhaCC,float gia, int soLuong) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stml = null;
		int n =0;
		try {
			stml = con.prepareStatement("insert into MatHang values(?,?,?,?,?)");
			stml.setString(1, maH);
			stml.setString(2, tenH);
			stml.setString(3, nhaCC);
			stml.setFloat(4, gia);
			stml.setInt(5, soLuong);
			n = stml.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		return n>0;
	}
	
	public boolean update(String maH,String tenH,String nhaCC,float gia, int soLuong) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update MatHang "
						+ "set TenHang = ?,"
						+"NhaCC = ?"
						+ "Gia = ? "
						+"SoLuong = ?"
						+ "where MaHang = ?");
			stmt.setString(1, tenH);
			stmt.setString(2, nhaCC);
			stmt.setFloat(3, gia);
			stmt.setInt(4, soLuong);
			stmt.setString(5, maH);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n > 0;
	}
	
	public boolean delete(String maH) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stml = null;
		int n = 0;
		try {
			stml = con.prepareStatement("delete from MatHang where MaHang = ?");
			stml.setString(1, maH);
			n = stml.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n>0;
	}
	
	
	public MatHang timkiem(String maH) {
		
		MatHang mh = new MatHang(maH);
		if(listHang.contains(mh)) {
			return listHang.get(listHang.indexOf(mh));
		}
		return null;
	}
}

