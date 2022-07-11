package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.Connect;
import entity.ChiTietCV;
import entity.CongTrinh;
import entity.CongViec;
import entity.LaoDong;

public class LichLamViec_DAO {
	public ArrayList<ChiTietCV> getLichLamViecTheoLaoDong(String maLD){
		Connection conn = new Connect().getConnect();
		ArrayList<ChiTietCV> dsChiTietCV = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from ChiTietCV where maLaoDong = ?");
			stmt.setString(1, maLD);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ChiTietCV cTietCV;
				CongTrinh congTrinh = new QuanLyCongTrinh_DAO().getCTTheoMa(rs.getString("maCongTrinh").trim());
				CongViec congViec = new CongViec_DAO().getCongViecTheoMa(rs.getString("maCongViec").trim());
				LaoDong laoDong = new QuanLyLaoDong_DAO().getLaoDong(rs.getString("maLaoDong"));
				cTietCV = new ChiTietCV(congTrinh,congViec,laoDong,rs.getDate("ngayThucHien"),rs.getDate("NgayHoanThanh"));
				dsChiTietCV.add(cTietCV);
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsChiTietCV;
	}
	
	public ArrayList<ChiTietCV> getLichLamViecTheoCongTrinh(String maCT){
		Connection conn = new Connect().getConnect();
		ArrayList<ChiTietCV> dsChiTietCV = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from ChiTietCV where maCongTrinh = ?");
			stmt.setString(1, maCT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ChiTietCV cTietCV;
				CongTrinh congTrinh = new QuanLyCongTrinh_DAO().getCTTheoMa(rs.getString("maCongTrinh").trim());
				CongViec congViec = new CongViec_DAO().getCongViecTheoMa(rs.getString("maCongViec").trim());
				LaoDong laoDong = new QuanLyLaoDong_DAO().getLaoDong(rs.getString("maLaoDong"));
				cTietCV = new ChiTietCV(congTrinh,congViec,laoDong,rs.getDate("ngayThucHien"),rs.getDate("NgayHoanThanh"));
				dsChiTietCV.add(cTietCV);
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsChiTietCV;
	}
}
