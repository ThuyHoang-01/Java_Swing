package baiTapLon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

public class QuanLyDonThuoc {
	ArrayList<DonThuoc> listDonThuoc;

	public QuanLyDonThuoc() {
		listDonThuoc = new ArrayList<DonThuoc>();
	}

	public ArrayList<DonThuoc> docTuBang() throws ParseException {
		Connection con = null;
		try {
			con = Database.getInstance().getConnection();
			String sql = "select * from donthuoc";
			Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				String maKhachHang = res.getString(1);
				String maThuoc = res.getString(2);
				String soLuong = res.getString(3);
				String ngayLapDonThuoc = res.getString(4);
				
				DonThuoc dt = new DonThuoc(maKhachHang, maThuoc, 
						Integer.parseInt(soLuong), ngayLapDonThuoc);
//				System.out.println(kh);
				listDonThuoc.add(dt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDonThuoc;
	}
	
	public boolean create(String maKhachHang, String maThuoc, String soLuong, 
			String ngaylapDonThuoc) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into donthuoc values(?, ?, ?, ?)");
			stmt.setString(1, maKhachHang);
			stmt.setString(2, maThuoc);
			stmt.setString(3, soLuong);
			stmt.setString(4, ngaylapDonThuoc);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean update(String maKhachHang, String maThuoc, String soLuong, 
			String ngaylapDonThuoc) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update donthuoc "
					+ "soluong = ?,"
					+ "ngaylapdonthuoc = ? "
					+ "where makhachhang = ? and mathuoc = ?");
			stmt.setString(1, soLuong);
			stmt.setString(2, ngaylapDonThuoc);
			stmt.setString(3, maKhachHang);
			stmt.setString(4, maThuoc);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean delete(String maKhachHang) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from donthuoc where maKhachHang = ?");
			stmt.setString(1, maKhachHang);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

}
