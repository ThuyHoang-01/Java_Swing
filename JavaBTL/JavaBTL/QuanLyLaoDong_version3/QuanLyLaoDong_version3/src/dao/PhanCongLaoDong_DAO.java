package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.Connect;
import entity.ChiTietCV;
import entity.CongTrinh;
import entity.CongViec;
import entity.LaoDong;

public class PhanCongLaoDong_DAO {
	public boolean kiemTraTrungLich(CongTrinh ct, CongViec cv,LaoDong ld) {
		Connection conn = new Connect().getConnect();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from ChiTietCV where maCongTrinh = ? and maCongViec = ? and maLaoDong = ?");
			stmt.setString(1, ct.getMaCongTrinh().trim());
			stmt.setString(2, cv.getMaCongViec().trim());
			stmt.setString(3, ld.getMaLaoDong().trim());
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				return false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
	public boolean phanCongCongViec(ChiTietCV ctcv) {
		Connection conn = new Connect().getConnect();
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into ChiTietCV values (?,?,?,?,?,?,?)");
			stmt.setString(1,ctcv.getCongTrinh().getMaCongTrinh());
			stmt.setString(2, ctcv.getCongViec().getMaCongViec());
			stmt.setString(3, ctcv.getLaoDong().getMaLaoDong());
			stmt.setDate(4, ctcv.getNgayThucHien());
			stmt.setDate(5, ctcv.getNgayHoanThanh());
			stmt.setString(6, ctcv.getQuanLy().getMaQuanLy());
			stmt.setBoolean(7, ctcv.isTrangThai());
			int recNum = stmt.executeUpdate();
			if (recNum>0)
				return true;
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
