package thucThi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import enTiTy.CompanyTripCustomer;
import enTiTy.XemTT;
import ketNoiSQL.DataBase;

public class DaoXemTourDaDat {

	ArrayList<XemTT> lsc;
	XemTT ct;

	public DaoXemTourDaDat() {
		lsc = new ArrayList<XemTT>();
		ct = new XemTT();
	}

	public ArrayList<XemTT> docTTDatTour() {
		try {
			Connection con = DataBase.getInstance().getConnection();
			String sql = " select ct.id, CompanyId, ct.Name, ct.DepartureDate, ct.FinishDate, ct.Address, ct.Place,ct.Price\r\n"
					+ "	from [dbo].[CompanyTripCustomer] cp join [dbo].[CarriageTrip] ct on  cp.CarriageTripId = ct.Id\r\n"
					+ "		where cp.CustomerId = " + System.getProperty("tour.userId");
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				int CompanyID = rs.getInt(2);
				String tenTuyen = rs.getString(3);
				String ngayBatDau = rs.getString(4);
				String ngayketThuc = rs.getString(5);
				String address = rs.getString(6);
				String place = rs.getString(7);
				Double donGia = rs.getDouble(8);
				XemTT t = new XemTT(id, CompanyID, tenTuyen, ngayBatDau, ngayketThuc, address, place, donGia);
				lsc.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lsc;

	}

	public boolean huyTour(int id) {
		
		for (XemTT xemTT : docTTDatTour()) {
			if (xemTT.getId() == id) {
				//Connection con = DataBase.getInstance().getConnection();
				///PreparedStatement stmt = null;
				//int n = 0;
				//try {
				//	stmt = con.prepareStatement("delete  from [dbo].[CompanyTripCustomer] cp join [dbo].[CarriageTrip] ct on  cp.CarriageTripId = ct.Id where Id = ?");
				//	stmt.setInt(1, id);
				//	n = stmt.executeUpdate();
				//}catch(SQLException e) {
				//	e.printStackTrace();
				//}finally {
					
				//}
				return true;
			}

		}

		return false;
	}

	public boolean DatTour(int carrigeTripId) {

		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		for (XemTT xemTT : lsc) {
			if (xemTT.getId() == carrigeTripId)
				return false;
			else {
				try {
					stmt = con.prepareStatement("insert into CompanyTripCustomer values(?,?,?,?)");
					stmt.setInt(1, Integer.parseInt(System.getProperty("tour.userId")));
					stmt.setInt(2, carrigeTripId);
					stmt.setBoolean(3, true);
					stmt.setNull(4, java.sql.Types.INTEGER);
					n = stmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}
		return true;

	}
}
