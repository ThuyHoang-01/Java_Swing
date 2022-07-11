package baiTapLon;

import java.sql.Connection;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class DSThuoc {
	ArrayList<Thuoc> listThuoc;

	public DSThuoc() {
		listThuoc = new ArrayList<Thuoc>();
	}
	public ArrayList<Thuoc> doctubang() throws ParseException{
		Connection con = null;
		try {
			con = Database.getInstance().getConnection();
			String sql = "select * from Thuoc";
			Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
			
				
				String mathuoc = res.getString(1);
				String tenthuoc = res.getString(2);
				String donvithuoc = res.getString(3);
				String nhacungcap = res.getString(4);
				String hansudung = res.getString(5);
				String dongia = res.getString(6);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
				Thuoc th = new Thuoc(mathuoc, tenthuoc, donvithuoc, nhacungcap, Double.parseDouble(dongia), hansudung);
			
			
				System.out.println(th);
				listThuoc.add(th);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listThuoc;
	
		
	}
	public boolean create(String mathuoc,String  tenthuoc, String donvithuoc,
			String  nhacungcap,String hansudung, Double dongia) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into Thuoc values(?, ?, ?, ?, ?, ?)");
			stmt.setString(1, mathuoc);
			stmt.setString(2, tenthuoc);
			stmt.setString(3, donvithuoc);
			stmt.setString(4,  nhacungcap);
			stmt.setString(5, hansudung);
			stmt.setDouble(6, dongia);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean update(String mathuoc,String  tenthuoc, String donvithuoc,
			String  nhacungcap, String  hansudung, Double dongia) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {

			stmt = con.prepareStatement("update thuoc "
					+ "set tenthuoc = ?,"
					+ "donvithuoc = ?,"
					+ "nhacungcap = ?,"
					+ "hansudung = ?,"
					+ "dongia  = ? "
					+ "where mathuoc = ?");
			stmt.setString(1, tenthuoc);
			stmt.setString(2,donvithuoc);
			stmt.setString(3, nhacungcap);
			stmt.setString(4,hansudung);
			stmt.setDouble(5, dongia );
			stmt.setString(6, mathuoc);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean delete(String maThuoc) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from Thuoc where maThuoc = ?");
			stmt.setString(1, maThuoc);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
//	public boolean themThuoc(Thuoc th) {
//		if (listThuoc.contains(th)) {
//			return false;
//		}
//		listThuoc.add(th);
//		return true;
//	}
//	public boolean xoaThuoc(String maThuoc) {
//		Thuoc th = new Thuoc(maThuoc);
//		if (listThuoc.contains(th)) {
//			listThuoc.remove(listThuoc.indexOf(maThuoc));
//			return true;
//		}
//		return false;
//	}
	public Thuoc timThuoc(String maThuoc) {
		Thuoc th = new Thuoc(maThuoc);
		if (listThuoc.contains(th)) {
			
			for (Thuoc thuoc : listThuoc) {
				if (thuoc.getMaThuoc().equals(maThuoc)) {
					return thuoc;
				}
			}
		}
		return null;
		
	}
	public Thuoc timThuocTenThuoc(String tenThuoc) {
		for (Thuoc thuoc : listThuoc) {
			if (thuoc.getTenThuoc().equals(tenThuoc)) {
				return thuoc;
			}
		}
		return null;
	}
//	public boolean checkHanSuDung(String maThuoc) {
//		Thuoc th = timThuoc(maThuoc);
//		if (th != null) {
//			return th.getHanSuDung().getTimeInMillis() > System.currentTimeMillis();
//		}
//		return false;
//	}
	public static void main(String[] args) throws ParseException {
		DSThuoc ds = new DSThuoc();
		Database.getInstance().connec();
		ds.doctubang();
	}
}
