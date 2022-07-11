package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongBan;

public class PhongBan_DAO {

	public ArrayList<PhongBan> getalltbPhongBan(){
		ArrayList<PhongBan> dsphongban = new ArrayList<PhongBan>();
			try{
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				
				String sql = "Select * from PhongBan";
				Statement  statement = (Statement) con.createStatement();
				
				ResultSet rs = ((java.sql.Statement) statement).executeQuery(sql);
				
				// Duyệt trên kết quả trả về
				while(rs.next()) {
					String maPB = rs.getString(1);
					String tenPB = rs.getString(2);
					PhongBan p = new PhongBan(maPB , tenPB);
					dsphongban.add(p);
				}
			}catch  (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		return dsphongban;
		
	}
}
