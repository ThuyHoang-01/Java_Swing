package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Database;
import entity.BoMonChuQuan;
import entity.MonHoc;

public class MonHoc_DAO {

	public static ArrayList<MonHoc> getall() {
	ArrayList<MonHoc> dsmh = new ArrayList<MonHoc>();
		try {
			Connection con = Database.getConnection();
			Statement s = con.createStatement();	
			ResultSet rs = s.executeQuery("Select *from MonHoc");
			while(rs.next()) {
				MonHoc mh = new MonHoc(rs.getString(1),rs.getString(2),new BoMonChuQuan(rs.getString(3)),rs.getInt(4));
				dsmh.add(mh);
			}
		
		} catch (SQLException e) {
			
		}
		return dsmh;
		
		
		
		
	}



	
	
}
