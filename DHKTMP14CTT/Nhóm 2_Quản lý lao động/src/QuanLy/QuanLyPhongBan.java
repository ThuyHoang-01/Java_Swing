package QuanLy;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Database;
import DoiTuong.PhongBan;

public class QuanLyPhongBan {
	private ArrayList<PhongBan> dscv;
	
	public QuanLyPhongBan() {
		dscv=new ArrayList<PhongBan>();
	}
	public ArrayList<PhongBan> docTubang(){
		try {
			Connection ketnoi=Database.getConnection();
			String sqlChucVu="SELECT [IDPhongBan]\r\n" + 
					"      ,[TenPhongBan]\r\n" + 
					"  FROM [dbo].[PhongBan]";
			Statement statement=ketnoi.createStatement();
			ResultSet rs=statement.executeQuery(sqlChucVu);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				PhongBan cv= new PhongBan(ma, ten);
				dscv.add(cv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscv;
	}

	public boolean themPhongBan(String maChucVu, String tenChucVu) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO [dbo].[PhongBan]\r\n" + 
					"           ([IDPhongBan]\r\n" + 
					"           ,[TenPhongBan])\r\n" + 
					"     VALUES\r\n" + 
					"           (?\r\n" + 
					"           ,?)");
			stmt.setString(1, maChucVu);
			stmt.setString(2, tenChucVu);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean capNhatBP(String maChucVu, String tenChucVu) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("\r\n" + 
					"UPDATE [dbo].[PhongBan]\r\n" + 
					"   SET [TenPhongBan] = ?\r\n" + 
					" WHERE [IDPhongBan] like ?");
			stmt.setString(1, tenChucVu);
			stmt.setString(2, maChucVu);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public String tuDongLayMa() {
		String maCV = "";
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "declare @ma char(5),@max int = 110\r\n"
					+ "set @ma = RIGHT((select MAX([IDPhongBan]) from [dbo].[PhongBan]),3)\r\n"
					+ "set @max = CAST(@ma as int) + 1\r\n" 
					+ "set @ma = 'PB' + cast(@max as char(3))\r\n"
					+ "select @ma";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maChucVu = rs.getString(1);
				maCV = maChucVu;
			}
		} catch (SQLException e) {
			// TODO: handle exception	
			e.printStackTrace();
		}
		return maCV;
	}
	

}

