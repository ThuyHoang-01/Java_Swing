package quanLymuabanXe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.sun.net.httpserver.Authenticator.Result;

public class DanhSachHoaDon {
	ArrayList<HoaDon> dshd;
	HoaDon hd;
	
	public DanhSachHoaDon() {
		dshd = new ArrayList<HoaDon>();
		hd = new HoaDon();
	}
	public ArrayList<HoaDon> docTuBang() {
		try {
			Connection con =  DataBase.getInstance().getConnection();
			String sql = "Select H.MaHoaDon ,X.MaXe,H.SoLanTra,H.MaKH,H.TenNhanVien,X.TenXe,H.NgayGiaoDich,X.GiaXe "
					+ "FROM HoaDon H INNER JOIN Xe X "
					+ "ON H.MaXe =X.MaXe";
					 
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				int maHD = rs.getInt(1);
				int MaXe = rs.getInt(2);
				int solanTra = rs.getInt(3);
				String maKh = rs.getString(4);
				String tenNV = rs.getString(5);
				String tenXe = rs.getString(6);
				String NgayGD = rs.getString(7);
				Double tien = rs.getDouble(8);
				HoaDon s = new HoaDon(maHD, MaXe, solanTra, maKh, tenNV, tenXe, NgayGD,tien);
				dshd.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dshd;
		
	}
	
	public boolean create(int mahd,int maxe,String makh,String ngayGD,int solantra,String tennv) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stml = null;
		int n =0;
		try {
			stml = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?)");
			stml.setInt(1, mahd);
			stml.setInt(2, maxe);
			stml.setString(3, makh);
			stml.setString(4, ngayGD);
			stml.setInt(5,solantra);
			stml.setString(5, tennv);
			n = stml.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		return n>0;
	}
		
}
