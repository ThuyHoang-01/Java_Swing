package baiTapLon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;





public class DanhSachKhachHang {
	ArrayList<KhachHang> dskh;
	KhachHang kh;
	public DanhSachKhachHang() {
		dskh = new ArrayList<KhachHang>();
		kh = new KhachHang();
	}
	public ArrayList<KhachHang> docTuBang(){
		dskh = new ArrayList<KhachHang>();
		try {
			Connection con = KHConnect.getInstance().getConnection();
			String sql = "Select * from tblUser";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int iD = rs.getInt(1);
				String tenKH = rs.getString(2);
				String cmnd  = rs.getString(3);
				String qT = rs.getString(4);
				String gT = rs.getString(5);
				int tuoi = rs.getInt(6);
				String SDT = rs.getString(7);
				KhachHang s = new KhachHang(iD,tenKH,cmnd,qT,gT,tuoi,SDT);
				dskh.add(s);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}
	public boolean create( String tenKH, String cmnd, Object  qT,Object gT,int tuoi, String sdt) {
		Connection con = KHConnect.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into tblUser values(?,?,?,?,?,?)");
			stmt.setString(1, tenKH);
			stmt.setString(2, cmnd);
			stmt.setString(3,  (String) qT);
			stmt.setString(4,  (String) gT);
			stmt.setInt(5, tuoi);
			stmt.setString(6, sdt);
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n>0;
	}
	public boolean updates(int maKH, String tenKH, String cmnd, Object qT,Object gT,int tuoi, String sdt) {
		Connection con = KHConnect.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt = con.prepareStatement("UPDATE tblUser SET tenKH=?,CMND=?,quocTich=?,gioiTinh=?,tuoi=?,sdt=? where ID=?");
			
			stmt.setString(1, tenKH);
			stmt.setString(2,cmnd);
			stmt.setString(3,(String) qT);
			stmt.setString(4,(String) gT);
			stmt.setInt(5, tuoi);
			stmt.setString(6,sdt);
			stmt.setInt(7,maKH);
			n=stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n>0;
	}
	public boolean delete(String maKH) {
		Connection con = KHConnect.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from tblUser where ID = ?");
			stmt.setString(1, maKH);
			n = stmt.executeUpdate();
			if(n > 0)
				return true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		new DanhSachKhachHang();
	}
}
