package baiTapLon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;





public class DanhSachPhong {
	ArrayList<Phong> dsp;
	Phong p;
	public DanhSachPhong() {
		dsp = new ArrayList<Phong>();
		p = new Phong();
	}
	public ArrayList<Phong> docTuBang(){
		dsp = new ArrayList<Phong>();
		try {
			Connection con = KHConnect.getInstance().getConnection();
			String sql = "Select * from tblRoom";
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
	public boolean create( String name, Object type, float price,Object tinhTrang) {
		Connection con = KHConnect.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into tblRoom values(?,?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2,(String) type);
			stmt.setFloat(3,price);
			stmt.setString(4,(String) tinhTrang);
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n>0;
	}
	public boolean updates(int ma,String name, Object type, float price,Object tinhTrang) {
		Connection con = KHConnect.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt = con.prepareStatement("UPDATE tblRoom SET name=?,type=?,Price =?,tinhTrang=? where ID=?");
			
			stmt.setString(1, name);
			stmt.setString(2,(String)type);
			stmt.setFloat(3,price);
			stmt.setString(4,(String) tinhTrang);
			stmt.setInt(5,ma);
			n=stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n>0;
	}
	public boolean delete(String ma) {
		Connection con = KHConnect.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from tblRoom where ID = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
			if(n > 0)
				return true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			
		}
		return false;
	}
	public boolean getTinhTrang(int maPhong) {
		Phong p = new Phong(maPhong);
				if(dsp.get(dsp.indexOf(p)).getTinhTrang().equals("Còn")) {
					return true;				
				}
				return false;
	}
	public ArrayList<Phong> getList(){
		return dsp;
	}
	public int getTong() {
		return dsp.size();
	}
}

