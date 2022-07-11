package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;
import entity.ChiTietCV;
import entity.CongTrinh;
import entity.CongViec;
import entity.LaoDong;
import entity.QuanLy;
import entity.ChuyenMon;;

public class QLCongViec_DAO {
	
	public boolean themCV(CongViec cv) {
		Connection con = new Connect().getConnect();
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("insert into CongViec values (?, ?)");
			st.setString(1, cv.getMaCongViec());
			st.setString(2, cv.getTenCongViec());
			st.execute();
			con.close();
		} catch (SQLException e) {
			// ToDO: handle exception

			return false;
		}
		return true;
	}
	public boolean capnhatCV(CongViec cv) {
		Connection con = new Connect().getConnect();
		PreparedStatement ste = null;

		try {
			ste = con.prepareStatement(
					"update CongViec set tenCongViec=? where maCongViec=? ");
			ste.setString(1, cv.getTenCongViec());

			ste.setString(3, cv.getMaCongViec());
			ste.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// ToDo: handle exception

			return false;
		}
		return true;
	}
	
	public CongViec getCVCuoi() {
		Connection con = new Connect().getConnect();
		CongViec cv = new CongViec();
		try {
			PreparedStatement p = con.prepareStatement("select max(maCongViec) as ma from CongViec");
			ResultSet r = p.executeQuery();
			r.next();
			cv = new CongViec(r.getString("ma").trim());
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cv;
	}
	public ArrayList<CongViec> getCongViec() {
		ArrayList<CongViec> listCV = new ArrayList<CongViec>();
		Connection conn = new Connect().getConnect();
		try {

			PreparedStatement p = conn.prepareStatement("select * from congviec");
			ResultSet r = p.executeQuery();
			while (r.next()) {
				listCV.add(
						new CongViec(r.getString("maCongViec").trim(), r.getString("tenCongViec").trim()));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Lỗi lấy data");
		}
		return listCV;
	}

	public CongViec getCongViec(String ma) {
		CongViec cv = new CongViec();
		Connection con =new Connect().getConnect();
		try {
			PreparedStatement p =con.prepareStatement("select * from CongViec where maCongViec = ?");
			p.setString(1, ma);
			ResultSet r = p.executeQuery();
			r.next();
			cv = new CongViec(r.getString("maCongViec").trim(), r.getString("tenCongViec").trim());
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cv;
	}	
	public ArrayList<ChiTietCV> getChiTietTheoMaCT(String maCT) {
		ArrayList<ChiTietCV> list = new ArrayList<ChiTietCV>();
		Connection con = new Connect().getConnect();
		try {
			PreparedStatement p = con
					.prepareStatement("select * from ChiTietCV where maCongTrinh = ? ");
			p.setString(1, maCT);
			ResultSet r = p.executeQuery();
			while (r.next()) {
				list.add(new ChiTietCV(new CongTrinh(maCT), new CongViec(r.getString("maCongViec")),
						new LaoDong(r.getString("maLaoDong")), r.getDate("ngayThucHien"), r.getDate("ngayHoanThanh")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public ArrayList<ChiTietCV> getChiTiet(String cv, String ct) {
		ArrayList<ChiTietCV> list = new ArrayList<ChiTietCV>();
		Connection con = new Connect().getConnect();
		PreparedStatement stu = null;
		try {
			stu = con.prepareStatement("select * from ChiTietCV  where maCongtrinh = ? and maCongViec = ? ");
			stu.setString(1, ct);
			stu.setString(2, cv);
			ResultSet r = stu.executeQuery();
			while (r.next()) {
//				list.add(new ChiTietCV(new CongTrinh(r.getString("maCongTrinh")), new LaoDong(r.getString("maLaoDong")),
//						r.getDate("ngayThucHien"), r.getDate("ngayHoanThanh")));
				list.add(new ChiTietCV(new CongTrinh(r.getString("maCongTrinh")), new CongViec(r.getString("maCongViec")), new LaoDong(r.getString("maLaoDong")),
						r.getDate("ngayThucHien"), r.getDate("ngayHoanThanh"), r.getBoolean("trangThai"), new QuanLy(r.getString("maQuanLy"))));
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public boolean capNhatTrangThaiCB(String maCT,String maCV, boolean trangThai) {
		Connection con = new Connect().getConnect();
		try {
			PreparedStatement sa = con.prepareStatement(
					"update ChiTietCV set trangThai = '"+trangThai+"' where maCongTrinh = '"+maCT+"'  and MaCongViec = '"+maCV+"'");
			sa.execute();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
}

