package QuanLy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Database;
import DoiTuong.CongTrinh;

public class QuanLyCongTrinh {
	private ArrayList<CongTrinh> qlct;

	public QuanLyCongTrinh() {
		qlct = new ArrayList<CongTrinh>();
	}

	public ArrayList<CongTrinh> docTuBang() {
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "SELECT [IDCongTrinh]\r\n" + 
					"      ,[TenCongTrinh]\r\n" + 
					"      ,[DiaDiemCongTrinh]\r\n" + 
					"      ,[NgayCapPhepXayDung]\r\n" + 
					"      ,[NgayKhoiCong]\r\n" + 
					"      ,[NgayHoanThanhTheoDuKien]\r\n" + 
					"  FROM [dbo].[CongTrinh]";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String diadiem = rs.getString(3);
				Date ngayCapPhep = rs.getDate(4);
				Date ngayKhoiCong = rs.getDate(5);
				Date ngayDuKienHT = rs.getDate(6);
				CongTrinh ct = new CongTrinh(ma, ten, diadiem, ngayKhoiCong, ngayCapPhep, ngayDuKienHT);
				qlct.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qlct;
	}

	public boolean themCongTrinh(String iD, String ten, String diaDiem, Date ngayKhoiCong, Date ngayCapPhep, Date ngayDuKienHT) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"INSERT INTO [dbo].[CongTrinh]\r\n" + 
					"           ([IDCongTrinh]\r\n" + 
					"           ,[TenCongTrinh]\r\n" + 
					"           ,[DiaDiemCongTrinh]\r\n" + 
					"           ,[NgayCapPhepXayDung]\r\n" + 
					"           ,[NgayKhoiCong]\r\n" + 
					"           ,[NgayHoanThanhTheoDuKien])\r\n" + 
					"     VALUES\r\n" + 
					"           (?\r\n" + 
					"           ,?\r\n" + 
					"           ,?\r\n" + 
					"           ,?\r\n" + 
					"           ,?\r\n" + 
					"           ,?)");
			stmt.setString(1, iD);
			stmt.setString(2, ten);
			stmt.setString(3, diaDiem);
			stmt.setDate(4, ngayCapPhep);
			stmt.setDate(5, ngayKhoiCong);
			stmt.setDate(6, ngayDuKienHT);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean capNhat(String mact, String ten, String diaDiem, Date ngayCapPhep, Date ngayKhoiCong, Date ngayDuKienHT) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("UPDATE [dbo].[CongTrinh]\r\n" + 
					"   SET [TenCongTrinh] = ?\r\n" + 
					"      ,[DiaDiemCongTrinh] = ?\r\n" + 
					"      ,[NgayCapPhepXayDung] = ?\r\n" + 
					"      ,[NgayKhoiCong] = ?\r\n" + 
					"      ,[NgayHoanThanhTheoDuKien] = ?\r\n" + 
					" WHERE [IDCongTrinh] like ?");
			stmt.setString(1, ten);
			stmt.setString(2, diaDiem);
			stmt.setDate(3, ngayCapPhep);
			stmt.setDate(4, ngayKhoiCong);
			stmt.setDate(5, ngayDuKienHT);
			stmt.setString(6, mact);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public ArrayList<CongTrinh> tim(String ten, String diaDiemTim, Date tuNgay, Date denNgay) {
		ArrayList<CongTrinh> dstimct = new ArrayList<CongTrinh>();
		try {
			Connection con = Database.getInstance().getConnection();
			String sql;
			if(!ten.equals("")&&!diaDiemTim.equals("")) {
				sql = "select * from [dbo].[CongTrinh] where [TenCongTrinh] LIKE N'"
						+ ten + "' AND [DiaDiemCongTrinh] LIKE '"+ diaDiemTim+""
						+ "' AND [NgayCapPhepXayDung] >= '"+tuNgay
						+ "' AND [NgayCapPhepXayDung] <= '"+denNgay+"'";				
			}else if(ten.equals("")&&!diaDiemTim.equals("")) {
				sql = "select * from [dbo].[CongTrinh] where [DiaDiemCongTrinh] LIKE '"+diaDiemTim
						+ "' AND [NgayCapPhepXayDung] >= '"+tuNgay
						+ "' AND [NgayCapPhepXayDung] <= '"+denNgay+"'";
			}else {
				sql = "select * from [dbo].[CongTrinh] WHERE"
						+ " [NgayCapPhepXayDung] >= '"+tuNgay
						+ "' AND [NgayCapPhepXayDung] <= '"+denNgay+"'";
			}
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String iD = rs.getString(1);
				String tenCT = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayKhoiCong = rs.getDate(5);
				Date ngayCapPhep = rs.getDate(4);
				Date ngayDuKienHT = rs.getDate(6);
				CongTrinh ct = new CongTrinh(iD, tenCT, diaDiem, ngayKhoiCong, ngayCapPhep, ngayDuKienHT);
				dstimct.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dstimct;
	}

	public String tuDongLayMa() {
		String mact = "";
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "declare @ma char(5),@max int\r\n"
					+ "set @ma = RIGHT((select MAX(IDCongTrinh) from CongTrinh),3)\r\n"
					+ "set @max = CAST(@ma as int) + 1\r\n" 
					+ "set @ma = 'CT' + cast(@max as char(3))\r\n"
					+ "select @ma";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				mact = ma;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mact;
	}

	public String layMact(String maTK) {
		String mact = "";
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select [IDCongTrinh] from [dbo].[CongTrinh] where [IDCongTrinh] like '" + maTK + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				mact = ma;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mact;
	}

	public String layMaTK(String mact) {
		String maTK = "";
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select [IDCongTrinh] from [dbo].[CongTrinh] where [IDCongTrinh] like '" + mact + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				maTK = ma;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maTK;
	}

}
