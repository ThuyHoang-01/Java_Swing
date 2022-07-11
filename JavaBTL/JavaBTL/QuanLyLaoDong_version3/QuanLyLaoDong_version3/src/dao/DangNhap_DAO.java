package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.Connect;
import entity.QuanLy;

public class DangNhap_DAO {
	public QuanLy getQuanLy(String maQL) {
		Connection conn = new Connect().getConnect();
		QuanLy quanLy = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from QuanLy where maQuanLy = ?");
			stmt.setString(1, maQL);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				quanLy = new QuanLy(rs.getString("maQuanLy").trim(),rs.getString("tenQuanLy").trim(),rs.getString("matKhau").trim());
			}
			conn.close();
		} catch (Exception e) {
			return null;
		}
		return quanLy;
	}
}
