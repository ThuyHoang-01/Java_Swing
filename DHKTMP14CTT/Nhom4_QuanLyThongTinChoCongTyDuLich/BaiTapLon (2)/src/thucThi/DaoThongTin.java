 package thucThi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enTiTy.KhachHang;
import ketNoiSQL.DataBase;


public class DaoThongTin {
	ArrayList<KhachHang> lkh;
	KhachHang s ;
	
	public DaoThongTin() {
		lkh = new ArrayList<KhachHang>();
		s = new KhachHang();
	}
	public ArrayList<KhachHang> DocTB(){
		try {
			Connection con = DataBase.getInstance().getConnection();

				String sql = "select *from Customer" ;
				
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					int id = rs.getInt(1);
					String ten = rs.getString(2);
					String email = rs.getString(3);
					String phone = rs.getString(4);
					String User = rs.getString(5);
					String Pass = rs.getString(6);
					
					KhachHang kh = new KhachHang(id, ten, email, phone, User, Pass);
					lkh.add(kh);
				}
				
			//}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lkh;
			
		
	}
	public ArrayList<KhachHang> doctuBang(){
		try {
			Connection con = DataBase.getInstance().getConnection();

				String sql = "select *from Customer where id="+ System.getProperty("tour.userId");
				
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					int id = rs.getInt(1);
					String ten = rs.getString(2);
					String email = rs.getString(3);
					String phone = rs.getString(4);
					String User = rs.getString(5);
					String Pass = rs.getString(6);
					
					KhachHang kh = new KhachHang(id, ten, email, phone, User, Pass);
					lkh.add(kh);
				}
				
			//}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lkh;
			
		
	}
	public boolean update(int id,String ten, String email, String phone,
			 String user, String pass) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Customer set  [LastName]=?,[Email] = ?,[Phone]=?,[UserName] = ?,[Password] =? where id=?");
			stmt.setString(1, ten);
			stmt.setString(2, email);
			stmt.setString(3, phone);
			stmt.setString(4, user);
			stmt.setString(5, pass);
			stmt.setInt(6, id);
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n > 0;
	}

}
