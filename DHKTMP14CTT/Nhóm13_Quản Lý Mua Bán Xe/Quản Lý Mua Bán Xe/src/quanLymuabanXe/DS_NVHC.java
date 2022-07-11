package quanLymuabanXe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DS_NVHC {
	ArrayList<NVHC> dshanhchinh;
	NVHC nvhc;

	public DS_NVHC() {
		dshanhchinh = new ArrayList<NVHC>();
		nvhc = new NVHC();

	}

	public ArrayList<NVHC> docTuBang() {
		try {
			Connection con = DataBase.getInstance().getConnection();
			String sql = "Select * FROM NhanVienHanhChinh";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				int ma = rs.getInt(1);
				String ten = rs.getString(2);
				String chucvu = rs.getString(3);
				String phongban = rs.getString(4);
				String trinhdo = rs.getString(5);
				NVHC s = new NVHC(ma, ten, chucvu, phongban, trinhdo);
				dshanhchinh.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dshanhchinh;
	}

	public boolean create(int ma, String ten, String chucvu, String phongban, String trinhdo) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stml = null;
		int n = 0;
		try {
			stml = con.prepareStatement("insert into NhanVienHanhChinh values(?,?,?,?,?");
			stml.setInt(1, ma);
			stml.setString(2, ten);
			stml.setString(3, chucvu);
			stml.setString(4, phongban);
			stml.setString(5, trinhdo);
			n = stml.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return n > 0;
	}

	public boolean update(int ma, String ten, String chucvu, String phongban, String trinhdo) {
		Connection con =DataBase.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVienHanhChinh " + "set tenNV = ?," + "ChucVu = ? ," + "PhongBan = ? ,"
					+ "TrinhdoHV = ?" + "where MaNV = ?");
			stmt.setInt(1, ma);
			stmt.setString(2, ten);
			stmt.setString(3, chucvu);
			stmt.setString(4, phongban);
			stmt.setString(5, trinhdo);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return n > 0;
	}
	public boolean delete(int ma) {
		Connection con =DataBase.getInstance().getConnection();
		PreparedStatement stml = null;
		int n = 0;
		try {
			stml = con.prepareStatement("delete from NhanVienHanhChinh where MaNV = ?");
			stml.setInt(1, ma);
			n = stml.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return n > 0;
	}

}
