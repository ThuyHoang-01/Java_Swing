package QuanLy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Database.Database;
import DoiTuong.ChiTietCongTrinh;

public class QuanLyCTCongTrinh {
	private ArrayList<ChiTietCongTrinh> qlnv;

	public QuanLyCTCongTrinh() {
		qlnv = new ArrayList<ChiTietCongTrinh>();
	}

	public ArrayList<ChiTietCongTrinh> docTuBang() {
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "SELECT [IDNhanVien]\r\n" + 
					"      ,[IDCongTrinh]\r\n" + 
					"      ,[NgayStart]\r\n" + 
					"      ,[NgayEnd]\r\n" + 
					"  FROM [dbo].[ChiTietCongTrinh]";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString(1);
				String maCT = rs.getString(2);
				Date ngayBatDau = rs.getDate(3);
				Date ngayKetThuc = rs.getDate(4);
				ChiTietCongTrinh nv = new ChiTietCongTrinh(maNV, maCT, ngayBatDau, ngayKetThuc);
				qlnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qlnv;

	}

	public boolean themChiTietCongTrinh(String maNV, String maCT, Date ngayBatDau, Date ngayKetThuc) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"INSERT INTO [dbo].[ChiTietCongTrinh]\r\n" + 
					"           ([IDNhanVien]\r\n" + 
					"           ,[IDCongTrinh]\r\n" + 
					"           ,[NgayStart]\r\n" + 
					"           ,[NgayEnd])" + 
					"     VALUES\r\n" + 
					"           (?\r\n" + 
					"           ,?\r\n" + 
					"           ,?\r\n" + 
					"           ,?)");
			stmt.setString(1, maNV);
			stmt.setString(2, maCT);
			stmt.setDate(3, ngayBatDau);
			stmt.setDate(4, ngayKetThuc);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean capNhat(String maNV, String maCT, Date ngayBatDau, Date ngayKetThuc) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("UPDATE [dbo].[ChiTietCongTrinh]\r\n" + 
					"   SET [NgayStart] = ?\r\n" + 
					"      ,[NgayEnd] = ?\r\n" + 
					" WHERE [IDNhanVien] LIKE ? AND [IDCongTrinh] LIKE ?");
			stmt.setDate(1, ngayBatDau);
			stmt.setDate(2, ngayKetThuc);
			stmt.setString(3, maNV);
			stmt.setString(4, maCT);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public ArrayList<ChiTietCongTrinh> tim(String ten) {
		ArrayList<ChiTietCongTrinh> dstimNV = new ArrayList<ChiTietCongTrinh>();
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select * from [dbo].[ChiTietCongTrinh] where [IDCongTrinh] = '" + ten + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString(1);
				String maCT = rs.getString(2);
				Date ngayBatDau = rs.getDate(5);
				Date ngayKetThuc = rs.getDate(6);
				ChiTietCongTrinh nv = new ChiTietCongTrinh(maNV, maCT, ngayBatDau, ngayKetThuc);
				qlnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dstimNV;
	}

	public String tuDongLayMa() {
		String maNV = "";
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "declare @ma char(5),@max int\r\n"
					+ "set @ma = RIGHT((select MAX(IDChiTietCongTrinh) from ChiTietCongTrinh),3)\r\n"
					+ "set @max = CAST(@ma as int) + 1\r\n" 
					+ "set @ma = 'NV' + cast(@max as char(3))\r\n"
					+ "select @ma";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				maNV = ma;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maNV;
	}

	public String layMaNV(String maTK) {
		String maNV = "";
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select IDChiTietCongTrinh from ChiTietCongTrinh where IDTaiKhoan like '" + maTK + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				maNV = ma;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return maNV;
	}

	public String layMaTK(String maNV) {
		String maTK = "";
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select IDTaiKhoan from ChiTietCongTrinh where IDChiTietCongTrinh like '" + maNV + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				maTK = ma;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return maTK;
	}

}
