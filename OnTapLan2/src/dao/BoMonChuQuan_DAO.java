package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Database;
import entity.BoMonChuQuan;


public class BoMonChuQuan_DAO {

	public static ArrayList<BoMonChuQuan> getall() {
		ArrayList<BoMonChuQuan> dsmh = new ArrayList<BoMonChuQuan>();
			try {
				Connection con = Database.getConnection();
				Statement s = con.createStatement();	
				ResultSet rs = s.executeQuery("Select *from BoMonChuQuan");
				while(rs.next()) {
					BoMonChuQuan mh = new BoMonChuQuan(rs.getString(1),rs.getString(2));
					dsmh.add(mh);
				}
			
			} catch (SQLException e) {
				
			}
			return dsmh;
	}
}
