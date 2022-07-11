package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.Connect;
import entity.CongViec;

public class CongViec_DAO {
	public CongViec getCongViecTheoMa(String maCongViec) {
		Connection conn = new Connect().getConnect();
		CongViec congViec = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from CongViec where maCongViec = ?");
			stmt.setString(1, maCongViec);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				congViec = new CongViec(rs.getString("maCongViec"),rs.getString("tenCongViec"));
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return congViec;
	}
}
