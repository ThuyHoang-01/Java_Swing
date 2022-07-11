package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.Database;
import entity.NhaTro;

public class DSNT {
	private ArrayList<NhaTro> dsnt;

	public DSNT() {
		dsnt = new ArrayList<NhaTro>();
		NhaTro nt = new NhaTro();
	}

	public ArrayList<NhaTro> readDB() {
		try {
			Connection cnt = Database.getInstance().getConnection();
			String sql = "Select * From NhaTro";
			Statement stm = cnt.createStatement();
			// Thực thi câu lệnh SQL trả về đối tượng KQ
			ResultSet rs = stm.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while (rs.next()) {
				String tenNT = rs.getString(1);
				String chuTro = rs.getString(2);
				String soDT = rs.getString(3);
				int phongTrong = rs.getInt(4);
				NhaTro nt = new NhaTro(tenNT, chuTro, soDT,phongTrong);
				dsnt.add(nt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Đóng kết nối
			// cnt.close();
		}
		return dsnt;
	}
	public ArrayList<NhaTro> readTrong() {
		try {
			Connection cnt = Database.getInstance().getConnection();
			String sql = "Select * From NhaTro where phongTrong > 0";
			Statement stm = cnt.createStatement();
			// Thực thi câu lệnh SQL trả về đối tượng KQ
			ResultSet rs = stm.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while (rs.next()) {
				String tenNT = rs.getString(1);
				String chuTro = rs.getString(2);
				String soDT = rs.getString(3);
				int phongTrong = rs.getInt(4);
				NhaTro nt = new NhaTro(tenNT, chuTro, soDT,phongTrong);
				dsnt.add(nt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Đóng kết nối
			// cnt.close();
		}
		return dsnt;
	}
	public ArrayList<NhaTro> readKTrong() {
		try {
			Connection cnt = Database.getInstance().getConnection();
			String sql = "Select * From NhaTro where phongTrong < 1";
			Statement stm = cnt.createStatement();
			// Thực thi câu lệnh SQL trả về đối tượng KQ
			ResultSet rs = stm.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while (rs.next()) {
				String tenNT = rs.getString(1);
				String chuTro = rs.getString(2);
				String soDT = rs.getString(3);
				int phongTrong = rs.getInt(4);
				NhaTro nt = new NhaTro(tenNT, chuTro, soDT,phongTrong);
				dsnt.add(nt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Đóng kết nối
			// cnt.close();
		}
		return dsnt;
	}
	public ArrayList<NhaTro> findTenNT(String tenNT) throws SQLException {
		Connection cnt = Database.getInstance().getConnection();
		PreparedStatement prestm = null;
		ResultSet rs = null;
		try {
			prestm = cnt.prepareStatement("SELECT * FROM NhaTro where tenNT like CONCAT( '%',?,'%')");
			prestm.setString(1, tenNT);
			rs = prestm.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng kiểm tra lại tên nhà trọ nhập vào!");
			e.printStackTrace();
		}
		while (rs.next()) {
			String ten = rs.getString(1);
			String chuTro = rs.getString(2);
			String soDT = rs.getString(3);
			int phongTrong = rs.getInt(4);
			NhaTro nt = new NhaTro(ten, chuTro, soDT,phongTrong);
			dsnt.add(nt);
		}
		return dsnt;
	}

	public ArrayList<NhaTro> findChuTro(String ChuTro) throws SQLException {
		Connection cnt = Database.getInstance().getConnection();
		PreparedStatement prestm = null;
		ResultSet rs = null;
		try {
			prestm = cnt.prepareStatement("SELECT * FROM NhaTro where chuTro like CONCAT( '%',?,'%')");
			prestm.setString(1, ChuTro);
			rs = prestm.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng kiểm tra lại tên chủ trọ!");
			e.printStackTrace();
		}
		while (rs.next()) {
			String ten = rs.getString(1);
			String chuTro = rs.getString(2);
			String soDT = rs.getString(3);
			int phongTrong = rs.getInt(4);
			NhaTro nt = new NhaTro(ten, chuTro, soDT,phongTrong);
			dsnt.add(nt);
		}
		return dsnt;
	}

	public ArrayList<NhaTro> findSdt(String SDT) throws SQLException {
		Connection cnt = Database.getInstance().getConnection();
		PreparedStatement prestm = null;
		ResultSet rs = null;
		try {
			prestm = cnt.prepareStatement("SELECT * FROM NhaTro where soDT like CONCAT( '%',?,'%')");
			prestm.setString(1, SDT);
			rs = prestm.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng kiểm tra lại số điện thoại!");
			e.printStackTrace();
		}
		while (rs.next()) {
			String ten = rs.getString(1);
			String chuTro = rs.getString(2);
			String soDT = rs.getString(3);
			int phongTrong = rs.getInt(4);
			NhaTro nt = new NhaTro(ten, chuTro, soDT,phongTrong);
			dsnt.add(nt);
		}
		return dsnt;
	}
	public ArrayList<NhaTro> findMoreInfor(String ten, String chu, String so, int phong) throws SQLException {
		Connection cnt = Database.getInstance().getConnection();
		PreparedStatement prestm = null;
		ResultSet rs = null;
		try {
			prestm = cnt.prepareStatement("Select * from NhaTro where tenNT like CONCAT( '%',?,'%') and chuTro like CONCAT( '%',?,'%') and soDT like CONCAT( '%',?,'%') and phongTrong like CONCAT( '%',?,'%')");
			prestm.setString(1, ten);
			prestm.setString(2, chu);
			prestm.setString(3, so);
			prestm.setInt(4, phong);
			rs = prestm.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng kiểm tra lại số điện thoại!");
			e.printStackTrace();
		}
		while (rs.next()) {
			String tenNT = rs.getString(1);
			String chuTro = rs.getString(2);
			String soDT = rs.getString(3);
			int phongTrong = rs.getInt(4);
			NhaTro nt = new NhaTro(tenNT, chuTro, soDT,phongTrong);
			dsnt.add(nt);
		}
		return dsnt;
	}
	public boolean create(String tenNT, String chuTro, String soDT, int phong) {
		Connection cnt = Database.getInstance().getConnection();
		PreparedStatement prestm = null;
		int n = 0;
		try {
			prestm = cnt.prepareStatement("insert into NhaTro values(?, ?, ?, ?)");
			prestm.setString(1, tenNT);
			prestm.setString(2, chuTro);
			prestm.setString(3, soDT);
			prestm.setInt(4, phong);
			n = prestm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Thêm nhà trọ thành công!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Tên nhà trọ này đã tồn tại!");
			e.printStackTrace();
		} finally {

		}
		return n > 0;
	}
	
	public boolean update(String ten, String chu, String sdt, int phong) {
		Connection cnt = Database.getInstance().getConnection();
		PreparedStatement prestm = null;
		int n = 0;
		try {
			prestm = cnt.prepareStatement("update NhaTro set chuTro = ?, soDT = ?, phongTrong = ? where tenNT = ?");
			prestm.setString(1, chu);
			prestm.setString(2, sdt);
			prestm.setInt(3, phong);
			prestm.setString(4, ten);
			n = prestm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Đã cập nhật thông tin nhà trọ thành công!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi không xác định!");
			e.printStackTrace();
		}finally {
			
		}
		return n>0;
	}

	public boolean delete(String ten) {
		Connection cnt = Database.getInstance().getConnection();
		PreparedStatement prestm = null;
		int n = 0;
		try {
			prestm = cnt.prepareStatement("delete from NhaTro where tenNT like CONCAT( '%',?,'%')");
			prestm.setString(1, ten);
			n = prestm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Đã xóa nhà trọ thành công!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Không thể xóa nhà trọ đang được sử dụng bởi sinh viên!");
			e.printStackTrace();
		}
		return n > 0;
	}
}
