package thucThi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enTiTy.CarriageTrip;
import ketNoiSQL.DataBase;


public class DaoNV_SauDN {
	ArrayList<CarriageTrip> lkh;
	CarriageTrip c;
	public DaoNV_SauDN() {
       lkh = new ArrayList<CarriageTrip>();
       c = new CarriageTrip();
   }
	public ArrayList<CarriageTrip> docTT(){
           try {
               Connection con = DataBase.getInstance().getConnection();
               String sql = "select *from CarriageTrip";
          
           Statement statement = con.createStatement();
        
           ResultSet rs = statement.executeQuery(sql);      
           
           while(rs.next())// di chuyen con tro xuong ban ghi ke tiep
           {                        
        	   int id = rs.getInt(1);
               String tenTuyen= rs.getString(2);
               int companyid = rs.getInt(3);
               String ngayBatDau= rs.getString(4);
               String ngayketThuc= rs.getString(5);
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
	   public ArrayList<CarriageTrip> Search(String search){
		   try {
				Connection con = DataBase.getInstance().getConnection();
				String sql = "select ct.* from CarriageTrip ct left join Company c on c.Id = ct.CompanyId where ct.Name like '%"+ search + "%'" 
						+ " or ct.Address like '%"+ search + "%'"
						+ " or ct.Place like '%"+ search + "%'"
						+ " or c.Name like '%"+ search + "%'";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next())// di chuyen con tro xuong ban ghi ke tiep
		           {                        
		        	   int id = rs.getInt(1);
		               String tenTuyen= rs.getString(2);
		               int companyid = rs.getInt(3);
		               String ngayBatDau= rs.getString(4);
		               String ngayketThuc= rs.getString(5);
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
	   public boolean create(String tuyen,int maCongty, String ngaybatdau, String ngayketthuc,
		String address, String diadiem, Double donGia) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into CarriageTrip values(?,?,?,?,?,?,?)");
			stmt.setString(1, tuyen);
			stmt.setInt(2,maCongty);
			stmt.setString(3, ngaybatdau);
			stmt.setString(4, ngayketthuc);
			stmt.setString(5, address);
			stmt.setString(6, diadiem);
			stmt.setDouble(7, donGia);
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n > 0;
		
	}
	
	   public boolean update(int id,String tuyen,int maCongty, String ngaybatdau, String ngayketthuc,
				String address, String diadiem, Double donGia) {
			Connection con = DataBase.getInstance().getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("update CarriageTrip set Name= ?, CompanyId=? ,[DepartureDate] = ?,FinishDate=?,Address =?,Place=?,Price= ? where Id = ?");
				stmt.setString(1, tuyen);
				stmt.setInt(2,maCongty);
				stmt.setString(3, ngaybatdau);
				stmt.setString(4, ngayketthuc);
				stmt.setString(5, address);
				stmt.setString(6, diadiem);
				stmt.setDouble(7, donGia);
				stmt.setInt(8, id);
				
				n = stmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				
			}
			return n > 0;
		}
	
	public boolean deleteTour(int id) {
		Connection con = DataBase.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from CarriageTrip where Id = ?");
			stmt.setInt(1, id);
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return n > 0;
	}	
	   public boolean deleteKH(int id) {
			Connection con = DataBase.getInstance().getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("delete from Customer where Id = ?");
				stmt.setInt(1, id);
				n = stmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				
			}
			return n > 0;
		}
}
