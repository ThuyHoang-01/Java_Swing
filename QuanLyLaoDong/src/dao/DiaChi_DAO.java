package dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;

public class DiaChi_DAO {
	public ArrayList<String> getTinhTP(){
		Connection conn = new Connect().getConnect();
		ArrayList<String> listTinh = new ArrayList<>();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("select tinhTP from DiaChi group by tinhTP");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				listTinh.add(rs.getString("tinhTP").trim());
			}
			conn.close();
		} catch (SQLException e) {
			return null;
		}
		return listTinh;
	}
	
	public  ArrayList<String> getQuanHuyen(String tinhTP) {
		Connection conn = new Connect().getConnect();
		PreparedStatement stmt;
		ArrayList<String> dsQuanHuyen = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("select quanHuyen from DiaChi where tinhTP=? group by quanHuyen");
			stmt.setString(1,tinhTP);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dsQuanHuyen.add(rs.getString("quanHuyen").trim());
			}
			conn.close();
		} catch (SQLException e) {
			return null;
		}
		return dsQuanHuyen;
		
	}
	
	public ArrayList<String> getPhuongXa(String tinhTP, String quanHuyen){
		Connection conn = new Connect().getConnect();
		ArrayList<String> listPhuong = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select phuongXa from DiaChi where tinhTP=? and quanHuyen=?");
			stmt.setString(1, tinhTP);
			stmt.setString(2,quanHuyen);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				listPhuong.add(rs.getString("phuongXa").trim());
			}
			conn.close();
		} catch (Exception e) {
			return null;
		}
		return listPhuong;
	}
	
}
