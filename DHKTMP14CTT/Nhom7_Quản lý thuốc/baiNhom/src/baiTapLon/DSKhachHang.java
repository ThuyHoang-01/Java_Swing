package baiTapLon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class DSKhachHang {
	ArrayList<KhachHangCoKeDon> listKhachHang;

	public DSKhachHang() {
		listKhachHang = new ArrayList<KhachHangCoKeDon>();
	}
	
	public ArrayList<KhachHangCoKeDon> docTuBang() throws ParseException {
		Connection con = null;
		try {
			con = Database.getInstance().getConnection();
			String sql = "select * from khachhang";
			Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				String maKhachHang = res.getString(1);
				String tenKhachHang = res.getString(2);
				String diaChi = res.getString(3);
				String soDienThoai = res.getString(4);
				String nguyenNhanBenh = res.getString(5);
				String ngayDenQuayThuoc = res.getString(6);
				
				KhachHangCoKeDon kh = new KhachHangCoKeDon(maKhachHang, tenKhachHang, 
						soDienThoai, diaChi, nguyenNhanBenh, ngayDenQuayThuoc);
//				System.out.println(kh);
				listKhachHang.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listKhachHang;
	}
	
	public boolean create(String maKhachHang, String tenKhachHang, String soDienThoai, 
			String diaChi, String nguyenNhanBenh, String ngayDenQuayThuoc) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into khachhang values(?, ?, ?, ?, ?, ?)");
			stmt.setString(1, maKhachHang);
			stmt.setString(2, tenKhachHang);
			stmt.setString(3, diaChi);
			stmt.setString(4, soDienThoai);
			stmt.setString(5, nguyenNhanBenh);
			stmt.setString(6, ngayDenQuayThuoc);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean update(String maKhachHang, String tenKhachHang, String soDienThoai, 
			String diaChi, String nguyenNhanBenh, String ngayDenQuayThuoc) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update khachhang "
					+ "set tenkhachhang = ?,"
					+ "diachi = ?,"
					+ "sodienthoai = ?,"
					+ "nguyennhanbenh = ?,"
					+ "ngayDenQuayThuoc = ? "
					+ "where makhachhang = ?");
			stmt.setString(1, tenKhachHang);
			stmt.setString(2, diaChi);
			stmt.setString(3, soDienThoai);
			stmt.setString(4, nguyenNhanBenh);
			stmt.setString(5, ngayDenQuayThuoc);
			stmt.setString(6, maKhachHang);
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
			stmt = con.prepareStatement("delete from khachhang where maKhachHang = ?");
			stmt.setString(1, maKhachHang);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	
	
//	public boolean themKhachHang(KhachHang kh) {
//		if (listKhachHang.contains(kh)) {
//			return false;
//		}
//		listKhachHang.add(kh);
//		return true;
//	}
//	public boolean xoaKhachHang(String maKhachHang) {
//		KhachHang kh = new KhachHang(maKhachHang);
//		if (listKhachHang.contains(kh)) {
//			listKhachHang.remove(listKhachHang.indexOf(maKhachHang));
//			return true;
//		}
//		return false;
//	}
	public KhachHangCoKeDon timKhachHang(String maKhachHang) {
		KhachHang kh = new KhachHangCoKeDon(maKhachHang);
		if (listKhachHang.contains(kh)) {
			for (KhachHangCoKeDon khachHangCoKeDon : listKhachHang) {
				if (khachHangCoKeDon.getMaKhachHang().equals(maKhachHang)) {
					return khachHangCoKeDon;
				}
			}
		}
		return null;
	}
	public KhachHangCoKeDon timKhachHangTheoTen(String tenKhachHang) {
		for (KhachHangCoKeDon khachHangCoKeDon : listKhachHang) {
			if (khachHangCoKeDon.getTenKhachHang().equals(tenKhachHang)) {
				return khachHangCoKeDon;
			}
		}
		return null;
	}
	public static void main(String[] args) throws ParseException {
		DSKhachHang ds = new DSKhachHang();
		Database.getInstance().connec();
		ds.docTuBang();
	}
}
