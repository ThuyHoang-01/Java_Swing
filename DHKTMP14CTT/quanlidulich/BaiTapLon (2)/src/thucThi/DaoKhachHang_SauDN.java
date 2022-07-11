package thucThi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enTiTy.CarriageTrip;


import ketNoiSQL.DataBase;


public class DaoKhachHang_SauDN {
	ArrayList<CarriageTrip> lkh;
	CarriageTrip c;
	   public DaoKhachHang_SauDN() {
           lkh = new ArrayList<CarriageTrip>();
           c = new CarriageTrip();

   }
	   public ArrayList<CarriageTrip> docTT(){
           try {
                   Connection con = DataBase.getInstance().getConnection();
                   String sql = "select *from CarriageTrip";
                  
                   Statement statement = con.createStatement();
                   //thuc thi cau lenh SQL tra ve gia tri tren ResultSet
                   ResultSet rs = statement.executeQuery(sql);      
                   //Duyet tren ket qua tra ve;
                   while(rs.next())// di chuyen con tro xuong ban ghi ke tiep
                   {                        
                	   int id = rs.getInt(1);
                       String tenTuyen= rs.getString(2);
                       int companyid = rs.getInt(3);
                       java.sql.Date ngayBatDau= rs.getDate(4);
                       java.sql.Date ngayketThuc= rs.getDate(5);
                       String address = rs.getString(6);
                       String place = rs.getString(7);
                       Double donGia = rs.getDouble(8);
                     
                       CarriageTrip kh= new CarriageTrip(id, tenTuyen, companyid,
                    		   ngayBatDau, ngayketThuc, address, place, donGia);
                       lkh.add(kh);
                   }
           }catch (SQLException e) {
                   e.printStackTrace();
                 
           }
           return lkh;
   }
	   public ArrayList<CarriageTrip> Search(int ma){
		   try {
				Connection con = DataBase.getInstance().getConnection();
				String sql = "select *from CarriageTrip where id ="+ma;
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next())// di chuyen con tro xuong ban ghi ke tiep
		           {                        
		        	   int id = rs.getInt(1);
		               String tenTuyen= rs.getString(2);
		               int companyid = rs.getInt(3);
		               java.sql.Date ngayBatDau= rs.getDate(4);
		               java.sql.Date ngayketThuc= rs.getDate(5);
		               String address = rs.getString(6);
		               String place = rs.getString(7);
		               Double donGia = rs.getDouble(8);
		             
		               CarriageTrip kh= new CarriageTrip(id, tenTuyen, companyid,
		            		   ngayBatDau, ngayketThuc, address, place, donGia);
		               lkh.add(kh);
		           }
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
		   return lkh;
	   }
	   	
	   	
}
