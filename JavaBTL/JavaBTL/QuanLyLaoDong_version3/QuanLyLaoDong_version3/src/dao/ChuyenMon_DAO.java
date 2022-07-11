package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.Connect;
import entity.ChuyenMon;

public class ChuyenMon_DAO {
	public ArrayList<ChuyenMon> getAllChuyenMon() {
		ArrayList<ChuyenMon> listChuyenMon= new ArrayList<ChuyenMon>();
		Connection con = new Connect().getConnect();
		
		try {
			Statement stt = con.createStatement();
			ResultSet r = stt.executeQuery("select * from ChuyenMon");
			
			while(r.next()) {
				listChuyenMon.add(new ChuyenMon(r.getString("maChuyenMon").trim(), r.getString("tenChuyenMon")));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listChuyenMon;
	}
	public ChuyenMon getChuyenMon(String maChuyenMon, String tenChuyenMon) {
		ArrayList<ChuyenMon> arrChuyenMon = getAllChuyenMon();
		for (ChuyenMon cm : arrChuyenMon) {
			if(cm.getMaChuyenMon().trim().equals(maChuyenMon))
				return cm;
			if(cm.getTenChuyenMon().trim().equals(tenChuyenMon))
				return cm;
		}
		return null;
	}

}
