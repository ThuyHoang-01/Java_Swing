package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;
import entity.ChiTietCV;
import entity.CongTrinh;
import entity.CongViec;

import entity.DiaChi;
import entity.LaoDong;

public class ChiTietCV_DAO {
	
	public int demSluongDuLieuTrongDB() {
		int dem = 0;
		String sql = "select count(macongtrinh) as dem from CongTrinh where maCongtrinh in(select macongtrinh from ChiTietCV group by maCongtrinh)";
		Connection con = new Connect().getConnect();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				dem = rs.getInt("dem");
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dem;
	}

	public ArrayList<ChiTietCV> getChiTiet(String cv, String ct) {
		ArrayList<ChiTietCV> list = new ArrayList<ChiTietCV>();
		Connection con = new Connect().getConnect();
		PreparedStatement stu = null;
		try {
			stu = con.prepareStatement("select * from ChiTietCV  where maCongtrinh = ? and maCongViec = ? and trangThai = 0");
			stu.setString(1, ct);
			stu.setString(2, cv);
			ResultSet r = stu.executeQuery();
			while (r.next()) {
				list.add(new ChiTietCV(new CongTrinh(r.getString("maCongTrinh")),
						new CongViec(r.getString("maCongViec")), new LaoDong(r.getString("maLaoDong")),
						r.getDate("ngayThucHien"), r.getDate("ngayHoanThanh")));
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public boolean capNhatLL(Date th, Date ht, String maCT, String maCV, String maLD) {
		Connection con = new Connect().getConnect();
		String sql = "update ChiTietCV set ngayThucHien = ? , ngayHoanThanh = ? where maCongTrinh = ? and MaCongViec = ?";
		if(!maLD.equals(""))
			sql +=" and maLaoDong = '"+maLD+"'";
		try {
			PreparedStatement sa = con.prepareStatement(sql);
			sa.setDate(1, th);
			sa.setDate(2, ht);
			sa.setString(3, maCT);
			sa.setString(4, maCV);
			sa.execute();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public ArrayList<ChiTietCV> getChiTietTheoMaCT(String maCT) {
		ArrayList<ChiTietCV> list = new ArrayList<ChiTietCV>();
		Connection con = new Connect().getConnect();
		try {
			PreparedStatement p = con
					.prepareStatement("select * from ChiTietCV where maCongTrinh = ? and trangThai = ?");
			p.setString(1, maCT);
			p.setBoolean(2, false);
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

	public ArrayList<ChiTietCV> timDanhSachCongViecDangLam(String maLD, String ct) {
		ArrayList<ChiTietCV> list = new ArrayList<ChiTietCV>();
		Connection con = new Connect().getConnect();
		PreparedStatement stu = null;
		try {
			stu = con.prepareStatement("select * from ChiTietCV  where maCongtrinh = ? and maLaoDong = ? ");
			stu.setString(1, ct);
			stu.setString(2, maLD);
			ResultSet r = stu.executeQuery();
			while (r.next()) {
				list.add(new ChiTietCV(new CongTrinh(r.getString("maCongTrinh")),
						new CongViec(r.getString("maCongViec")), new LaoDong(r.getString("maLaoDong")),
						r.getDate("ngayThucHien"), r.getDate("ngayHoanThanh")));
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public void nghiViec(String ma) {
		Connection con = new Connect().getConnect();
		try {
			PreparedStatement p = con.prepareStatement("update ChiTietCV set trangThai = ? where maLaoDong = ?");
			p.setBoolean(1, true);
			p.setString(1, ma);
			p.execute();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public ArrayList<CongTrinh> getCongTrinhDangLam(String ma) {
		Connection con = new Connect().getConnect();
		ArrayList<CongTrinh> list = new ArrayList<CongTrinh>();
		try {
			PreparedStatement p = con
					.prepareStatement("select maCongTrinh from ChiTietCV where maCongTrinh != ? group by maCongTrinh");
			ResultSet r = p.executeQuery();
			while (r.next())
				list.add(new CongTrinh(r.getString("maCongTrinh")));
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public ArrayList<CongTrinh> timCTDangLamTheoTen(String ten) {
		ArrayList<CongTrinh> list = new ArrayList<CongTrinh>();
		Connection con = new Connect().getConnect();
		try {
			PreparedStatement p = con.prepareStatement(
					"select * from CongTrinh where maCongTrinh in (select maCongTrinh from ChiTietCV) and tenCongTrinh like N'%"
							+ ten + "%' and trangThai = N'Chưa hoàn thành'");
			ResultSet r = p.executeQuery();
			while (r.next()) {
				list.add(new CongTrinh(r.getString("maCongTrinh").trim(), r.getString("tenCongTrinh").trim(),
						r.getString("loaiCongTrinh").trim(), new DiaChi(r.getString("tinhTP").trim(), r.getString("quanHuyen").trim(),
								r.getString("phuongXa").trim()),
						r.getDate("ngayKhoiCong"), r.getDate("ngayHoanThanh"), r.getString("trangThai").trim()));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public ArrayList<ChiTietCV> timLDDangLamTheoTen(String maCT, String tenLD) {
		ArrayList<ChiTietCV> list = new ArrayList<ChiTietCV>();
		Connection con = new Connect().getConnect();
		try {
			PreparedStatement p = con.prepareStatement(
					"select * from ChiTietCV ct join LaoDong ld on ct.maLaoDong = ld.maLaoDong where maCongtrinh = ? and tenLaoDong like N'%"
							+ tenLD + "%' and ct.trangThai = 0 ");
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
	
	public ArrayList<CongTrinh> timCongTrinhDangLam(String maCT, String tenCT) {
		ArrayList<CongTrinh> list = new ArrayList<CongTrinh>();
		Connection con = new Connect().getConnect();
		String sql = "select * from CongTrinh where maCongTrinh in (select maCongTrinh from ChiTietCV) and trangThai = N'Chưa hoàn thành' and ";
		if(!maCT.equals(""))
			sql += "maCongTrinh like N'%"+maCT+"%' and ";
		if(!tenCT.equals(""))
			sql +="tenCongTrinh like N'%"+tenCT+"%' and ";
		sql = sql.substring(0, sql.length()-5);
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet r = p.executeQuery();
			while(r.next()) {
				DiaChi diadiem= new DiaChi(r.getString("tinhTP").trim(),r.getString("quanHuyen").trim(), r.getString("phuongXa").trim());
				list.add(new CongTrinh(r.getString("maCongTrinh").trim(), r.getString("tenCongTrinh").trim(),
						r.getString("loaiCongTrinh").trim(), new DiaChi(r.getString("tinhTP").trim(), r.getString("quanHuyen").trim(),
								r.getString("phuongXa").trim()),
						r.getDate("ngayKhoiCong"), r.getDate("ngayHoanThanh"), r.getString("trangThai").trim()));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public ArrayList<ChiTietCV> getChiTietTheoMaCV(String maCT, String maCV) {
		ArrayList<ChiTietCV> list = new ArrayList<ChiTietCV>();
		Connection con = new Connect().getConnect();
		try {
			PreparedStatement p = con.prepareStatement("select * from ChiTietCV where maCongTrinh = ? and maCongViec = ? and trangThai = 0");
			p.setString(1, maCT);
			p.setString(2, maCV);
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

}
