package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect.Connect;
import entity.ChuyenMon;
import entity.DiaChi;
import entity.LaoDong;

public class QuanLyLaoDong_DAO {
	public ArrayList<LaoDong> getLaoDongTheoChuyenMon(String maChuyenMon) {
		ArrayList<LaoDong> list = new ArrayList<LaoDong>();
		Connection con = new Connect().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("select * from LaoDong where maChuyenMon = ?");
			statement.setString(1,maChuyenMon);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				DiaChi dc = new DiaChi(result.getString("tinhTP").trim(), result.getString("quanHuyen").trim(),
						result.getString("phuongXa").trim());
				ChuyenMon cm = new ChuyenMon(result.getString("maChuyenMon"));
				LaoDong ld = new LaoDong(result.getString("maLaoDong"), result.getString("tenLaoDong").trim(),
						result.getDate("ngaySinh"), result.getBoolean("gioiTinh"), result.getString("CMND").trim(), dc,
						cm, result.getString("SDT").trim(), result.getBoolean("trangThai"));
				list.add(ld);
			}
			statement.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	public static ArrayList<LaoDong> getAllLaoDong() {
		ArrayList<LaoDong> list = new ArrayList<LaoDong>();
		Connection con = new Connect().getConnect();

		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from LaoDong");
			while (result.next()) {
				DiaChi dc = new DiaChi(result.getString("tinhTP").trim(), result.getString("quanHuyen").trim(),
						result.getString("phuongXa").trim());
				ChuyenMon cm = new ChuyenMon(result.getString("maChuyenMon"));
				LaoDong ld = new LaoDong(result.getString("maLaoDong"), result.getString("tenLaoDong").trim(),
						result.getDate("ngaySinh"), result.getBoolean("gioiTinh"), result.getString("CMND").trim(), dc,
						cm, result.getString("SDT").trim(), result.getBoolean("trangThai"));
				list.add(ld);
			}
			statement.close();
			con.close();
		} catch (Exception e) {
		}
		return list;
	}

	public boolean themLaoDong(LaoDong ld) {
		Connection con = new Connect().getConnect();
		PreparedStatement stt = null;

		try {
			stt = con.prepareStatement("insert into LaoDong values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stt.setString(1, ld.getMaLaoDong());
			stt.setString(2, ld.getTenLaoDong());
			stt.setDate(3, ld.getNgaySinh());
			stt.setString(4, ld.getSDT());
			stt.setString(5, ld.getCMND());
			stt.setString(6, ld.getDiaChi().getTinhTP());
			stt.setString(7, ld.getDiaChi().getQuanHuyen());
			stt.setString(8, ld.getDiaChi().getPhuongXa());
			stt.setBoolean(9, ld.isGioiTinh());
			stt.setString(10, ld.getChuyenMon().getMaChuyenMon());
			stt.setBoolean(11, ld.isTrangThai());
			stt.execute();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean suaLD(LaoDong ld) {
		Connection con = new Connect().getConnect();
		PreparedStatement stt = null;

		try {
			stt = con.prepareStatement(
					"update LaoDong set tenLaoDong=?, CMND=?, gioiTinh=?, SDT=?, ngaySinh=? , maChuyenMon=?, tinhTP=?, quanHuyen=?, phuongXa=? where maLaoDong=?");
			stt.setString(1, ld.getTenLaoDong());
			stt.setString(2, ld.getCMND());
			stt.setBoolean(3, ld.isGioiTinh());
			stt.setString(4, ld.getSDT());
			stt.setDate(5, ld.getNgaySinh());
			stt.setString(6, ld.getChuyenMon().getMaChuyenMon().trim());
			stt.setString(7, ld.getDiaChi().getTinhTP());
			stt.setString(8, ld.getDiaChi().getQuanHuyen());
			stt.setString(9, ld.getDiaChi().getPhuongXa());
			stt.setString(10, ld.getMaLaoDong());
			int res = stt.executeUpdate();
			if (res > 0)
				return true;
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	public boolean nghiViecLaoDong(String maLaoDong) {
		Connection con = new Connect().getConnect();
		PreparedStatement stt = null;
		int check = 0;

		try {
			stt = con.prepareStatement("update LaoDong set trangThai=0 where maLaoDong=?");
			stt.setString(1, maLaoDong);
			check = stt.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		if (check == 0)
			return false;
		return true;
	}

	public ArrayList<LaoDong> timKiemLaoDong(String maLaoDong, String tenLaoDong) {
		Connection con = new Connect().getConnect();
		PreparedStatement stt = null;
		ArrayList<LaoDong> list = new ArrayList<LaoDong>();
		try {
			stt = con.prepareStatement("select * from LaoDong where maLaoDong like N'%"+maLaoDong+"%' and tenLaoDong like N'%"+tenLaoDong+"%'");
			ResultSet result = stt.executeQuery();

			while (result.next()) {
				DiaChi dc = new DiaChi(result.getString("tinhTP").trim(), result.getString("quanHuyen").trim(),
						result.getString("phuongXa").trim());
				ChuyenMon cm = new ChuyenMon(result.getString("maChuyenMon"));
				LaoDong ld = new LaoDong(result.getString("maLaoDong"), result.getString("tenLaoDong").trim(),
						result.getDate("ngaySinh"), result.getBoolean("gioiTinh"), result.getString("CMND").trim(), dc,
						cm, result.getString("SDT").trim(), result.getBoolean("trangThai"));
				list.add(ld);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public LaoDong getLaoDong(String ma) {
		Connection con = new Connect().getConnect();
		LaoDong ld = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from LaoDong where maLaoDong=?");
			p.setString(1, ma);
			ResultSet result = p.executeQuery();
			result.next();
			DiaChi dc = new DiaChi(result.getString("tinhTP").trim(), result.getString("quanHuyen").trim(),
					result.getString("phuongXa").trim());
			ChuyenMon cm = new ChuyenMon(result.getString("maChuyenMon"));
			ld = new LaoDong(result.getString("maLaoDong"), result.getString("tenLaoDong").trim(),
					result.getDate("ngaySinh"), result.getBoolean("gioiTinh"), result.getString("CMND").trim(), dc,
					cm, result.getString("SDT").trim(), result.getBoolean("trangThai"));
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ld;
	}
	public String getMaLaoDongCuoi() {
		Connection conn = new Connect().getConnect();
		String maLD = "";
		try {
			PreparedStatement stmt = conn.prepareStatement("select maLaoDong from LaoDong");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				maLD = rs.getString("maLaoDong");
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return maLD;
	}
	
	//Them ham LaoDong co trang thai con lam
	public ArrayList<LaoDong> getAllLaoDongTheoTrangThai() {
		Connection con = new Connect().getConnect();
		PreparedStatement stt = null;
		ArrayList<LaoDong> list = new ArrayList<LaoDong>();
		try {
			stt = con.prepareStatement("select * from LaoDong where trangThai = 1");
			ResultSet result = stt.executeQuery();

			while (result.next()) {
				DiaChi dc = new DiaChi(result.getString("tinhTP").trim(), result.getString("quanHuyen").trim(),
						result.getString("phuongXa").trim());
				ChuyenMon cm = new ChuyenMon(result.getString("maChuyenMon"));
				LaoDong ld = new LaoDong(result.getString("maLaoDong"), result.getString("tenLaoDong").trim(),
						result.getDate("ngaySinh"), result.getBoolean("gioiTinh"), result.getString("CMND").trim(), dc,
						cm, result.getString("SDT").trim(), result.getBoolean("trangThai"));
				list.add(ld);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<LaoDong> timKiemLaoDongConLam(String maLaoDong, String tenLaoDong) {
		Connection con = new Connect().getConnect();
		PreparedStatement stt = null;
		ArrayList<LaoDong> list = new ArrayList<LaoDong>();
		try {
			stt = con.prepareStatement("select * from LaoDong where trangThai = 1 and maLaoDong like N'%"+ maLaoDong +"%' and tenLaoDong like N'%"+tenLaoDong+"%'");
			ResultSet result = stt.executeQuery();

			while (result.next()) {
				DiaChi dc = new DiaChi(result.getString("tinhTP").trim(), result.getString("quanHuyen").trim(),
						result.getString("phuongXa").trim());
				ChuyenMon cm = new ChuyenMon(result.getString("maChuyenMon"));
				LaoDong ld = new LaoDong(result.getString("maLaoDong"), result.getString("tenLaoDong").trim(),
						result.getDate("ngaySinh"), result.getBoolean("gioiTinh"), result.getString("CMND").trim(), dc,
						cm, result.getString("SDT").trim(), result.getBoolean("trangThai"));
				list.add(ld);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<LaoDong> getLaoDongTheoChuyenMonVaTrangThai(String maChuyenMon) {
		ArrayList<LaoDong> list = new ArrayList<LaoDong>();
		Connection con = new Connect().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement("select * from LaoDong where maChuyenMon = ? and trangThai = 1");
			statement.setString(1,maChuyenMon);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				DiaChi dc = new DiaChi(result.getString("tinhTP").trim(), result.getString("quanHuyen").trim(),
						result.getString("phuongXa").trim());
				ChuyenMon cm = new ChuyenMon(result.getString("maChuyenMon"));
				LaoDong ld = new LaoDong(result.getString("maLaoDong"), result.getString("tenLaoDong").trim(),
						result.getDate("ngaySinh"), result.getBoolean("gioiTinh"), result.getString("CMND").trim(), dc,
						cm, result.getString("SDT").trim(), result.getBoolean("trangThai"));
				list.add(ld);
			}
			statement.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
