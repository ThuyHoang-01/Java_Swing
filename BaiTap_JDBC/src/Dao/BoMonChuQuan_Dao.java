package Dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Database;
import entity.BoMon;
import entity.MonHoc;

public class BoMonChuQuan_Dao {
	public static ArrayList<BoMon> getall() {
		ArrayList<BoMon> dsbm = new ArrayList<BoMon>();
		try {
			Connection con =Database.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("Select *from BoMonChuQuan");
			while (rs.next()) {
				BoMon bm = new BoMon(rs.getString(1),rs.getString(2));
				dsbm.add(bm);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsbm;
	}
}
