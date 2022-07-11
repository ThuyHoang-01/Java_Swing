package baiTapLon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DanhSachDatPhong {
	ArrayList<Phong> dsp;
	Phong p;
	public DanhSachDatPhong() {
		dsp = new ArrayList<Phong>();
		p = new Phong();
	}
	public ArrayList<Phong> docTuBang(){
		dsp = new ArrayList<Phong>();
		try {
			Connection con = KHConnect.getInstance().getConnection();
			String sql = "Select ID from tblUser  where tblbooking ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int iD = rs.getInt(1);
				String name = rs.getString(2);
				String type  = rs.getString(3);
				float price = rs.getFloat(4);
				String tinhTrang = rs.getString(5);
				Phong s = new Phong(iD,name,type,price,tinhTrang);
				dsp.add(s);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsp;
	}
}
