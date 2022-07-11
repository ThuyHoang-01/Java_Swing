package dao;

import java.beans.Statement;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;
import entity.CongTrinh;
import entity.DiaChi;

public class QuanLyCongTrinh_DAO {
	public ArrayList<CongTrinh> getAllCongTrinh() {
		Connection conn = new Connect().getConnect();
		ArrayList<CongTrinh> dsCongTrinh = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from CongTrinh");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DiaChi diaChi = new DiaChi(rs.getString("tinhTP").trim(), rs.getString("quanHuyen").trim(),
						rs.getString("phuongXa").trim());
				CongTrinh congTrinh = new CongTrinh(rs.getString("maCongTrinh").trim(),
						rs.getString("tenCongTrinh").trim(), rs.getString("loaiCongTrinh").trim(), diaChi,
						rs.getDate("ngayKhoiCong"), rs.getDate("ngayDKHoanThanh"), rs.getString("trangThai").trim());
				dsCongTrinh.add(congTrinh);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsCongTrinh;
	}

	public boolean xoaCongTrinh(String maCT) {
		Connection conn = new Connect().getConnect(); 
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from CongTrinh where maCongTrinh = ?"); //sql
			stmt.setString(1, maCT);
			int recNum = stmt.executeUpdate();
			if (recNum > 0)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public String getMaCongTrinhCuoi() {
		Connection conn = new Connect().getConnect();
		String maCT = "";
		try {
			PreparedStatement stmt = conn.prepareStatement("select maCongTrinh from CongTrinh");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				maCT = rs.getString("maCongTrinh");
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return maCT;
	}

	public boolean themCongTrinh(CongTrinh ct) {
		Connection conn = new Connect().getConnect();
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into CongTrinh values (?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, ct.getMaCongTrinh());
			stmt.setString(2, ct.gettenCongTrinh());
			stmt.setString(3, ct.getLoaiCongTrinh());
			stmt.setDate(4, ct.getNgayKhoiCong());
			stmt.setDate(5, ct.getNgayDKHoanThanh());
			stmt.setString(6, ct.getDiaChi().getTinhTP());
			stmt.setString(7, ct.getDiaChi().getQuanHuyen());
			stmt.setString(8, ct.getDiaChi().getPhuongXa());
			stmt.setString(9, ct.getTrangThai());
			int reNum = stmt.executeUpdate();
			if (reNum > 0)
				return true;
			conn.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean suaCongTrinh(CongTrinh ct) {
		Connection conn = new Connect().getConnect();
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"update CongTrinh set tenCongTrinh = ?,loaiCongTrinh = ?,ngayKhoiCong = ?,ngayDKHoanThanh = ?,tinhTP = ?,quanHuyen = ?,phuongXa = ?,trangThai = ? where maCongtrinh = ?");
			stmt.setString(1, ct.gettenCongTrinh());
			stmt.setString(2, ct.getLoaiCongTrinh());
			stmt.setDate(3, ct.getNgayKhoiCong());
			stmt.setDate(4, ct.getNgayDKHoanThanh());
			stmt.setString(5, ct.getDiaChi().getTinhTP());
			stmt.setString(6, ct.getDiaChi().getQuanHuyen());
			stmt.setString(7, ct.getDiaChi().getPhuongXa());
			stmt.setString(8, ct.getTrangThai());
			stmt.setString(9, ct.getMaCongTrinh());
			int reNum = stmt.executeUpdate();
			if (reNum > 0)
				return true;
			conn.close();
		} catch (Exception e) {

		}
		return false;
	}

	public ArrayList<CongTrinh> timKiemCongTrinh(String maCT, String tenCT) {
		Connection conn = new Connect().getConnect();
		ArrayList<CongTrinh> dsCongTrinh = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from CongTrinh where maCongTrinh like N'%" + maCT
					+ "%' and tenCongTrinh like N'%" + tenCT + "%'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DiaChi diaChi = new DiaChi(rs.getString("tinhTP").trim(), rs.getString("quanHuyen").trim(),
						rs.getString("phuongXa").trim());
				CongTrinh congTrinh = new CongTrinh(rs.getString("maCongTrinh").trim(),
						rs.getString("tenCongTrinh").trim(), rs.getString("loaiCongTrinh").trim(), diaChi,
						rs.getDate("ngayKhoiCong"), rs.getDate("ngayDKHoanThanh"), rs.getString("trangThai").trim());
				dsCongTrinh.add(congTrinh);
			}
			conn.close();
		} catch (Exception e) {
			return null;
		}
		return dsCongTrinh;
	}

	public CongTrinh getCTTheoMa(String ma) {
		CongTrinh ct = new CongTrinh(ma);
		Connection con = new Connect().getConnect();
		try {
			PreparedStatement p = con.prepareStatement("select * from CongTrinh where maCongTrinh = ?");
			p.setString(1, ma);
			ResultSet rs = p.executeQuery();
			rs.next();
			ct = new CongTrinh(rs.getString("maCongTrinh"), rs.getString("tenCongTrinh").trim(),
					rs.getString("loaiCongTrinh").trim(),
					new DiaChi(rs.getString("tinhTP").trim(), rs.getString("quanHuyen").trim(),
							rs.getString("phuongXa").trim()),
					rs.getDate("ngayKhoiCong"), rs.getDate("ngayDKHoanThanh"), rs.getString("trangThai"));
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ct;
	}
}
