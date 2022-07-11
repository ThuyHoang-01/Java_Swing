package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;

import database.Database;

import java.sql.Statement;

import entity.SinhVien;

public class DSSV {
		private ArrayList<SinhVien> dssv;
		public DSSV() {
			dssv = new ArrayList<SinhVien>();
			SinhVien sv = new SinhVien();
		}
		public ArrayList<SinhVien> readDB(){
			try {
				Connection cnt = Database.getInstance().getConnection();
				String sql = "Select * From SinhVien";
				Statement stm = cnt.createStatement();
				//Thực thi câu lệnh SQL trả về đối tượng KQ
				ResultSet rs = stm.executeQuery(sql);
				//Duyệt trên kết quả trả về
				while (rs.next()) {
					String ma = rs.getString(1);
					String ho = rs.getString(2);
					String ten = rs.getString(3);
					String gender = rs.getString(4);
					String birth = rs.getString(5);
					String queQuan = rs.getString(6);
					SinhVien sv = new SinhVien(ma, ho, ten, queQuan, birth, gender);
					dssv.add(sv);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				//Đóng kết nối
				//cnt.close();
			}
			return dssv;
		}
		public ArrayList<SinhVien> findMSSV(String maSV) throws SQLException {
				Connection cnt = Database.getInstance().getConnection();
				PreparedStatement prestm = null;
				ResultSet rs = null;
				try {
					prestm = cnt.prepareStatement("SELECT * FROM SinhVien where maSV like CONCAT( '%',?,'%')");
					prestm.setString(1, maSV);
					rs = prestm.executeQuery();
				} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng kiểm tra lại mã số sinh viên nhập vào!");
				e.printStackTrace();
				}
				while (rs.next()) {
					String ma = rs.getString(1);
					String ho = rs.getString(2);
					String ten = rs.getString(3);
					String gender = rs.getString(4);
					String birth = rs.getString(5);
					String queQuan = rs.getString(6);
					SinhVien sv = new SinhVien(ma, ho, ten, queQuan, birth, gender);
				dssv.add(sv);
			}
			return dssv;
		}
		public ArrayList<SinhVien> findHo(String hoSV) throws SQLException {
			Connection cnt = Database.getInstance().getConnection();
			PreparedStatement prestm = null;
			ResultSet rs = null;
			try {
				prestm = cnt.prepareStatement("SELECT * FROM SinhVien where ho like CONCAT( '%',?,'%')");
				prestm.setString(1, hoSV);
				rs = prestm.executeQuery();
			} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng kiểm tra lại mã số sinh viên nhập vào!");
			e.printStackTrace();
			}
			while (rs.next()) {
				String ma = rs.getString(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				String gender = rs.getString(4);
				String birth = rs.getString(5);
				String queQuan = rs.getString(6);
				SinhVien sv = new SinhVien(ma, ho, ten, queQuan, birth, gender);
				dssv.add(sv);
			}
			return dssv;
		}
		public ArrayList<SinhVien> findTen(String TenSV) throws SQLException {
			Connection cnt = Database.getInstance().getConnection();
			PreparedStatement prestm = null;
			ResultSet rs = null;
			try {
				prestm = cnt.prepareStatement("SELECT * FROM SinhVien where ten like CONCAT( '%',?,'%')");
				prestm.setString(1, TenSV);
				rs = prestm.executeQuery();
			} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng kiểm tra lại mã số sinh viên nhập vào!");
			e.printStackTrace();
			}
			while (rs.next()) {
				String ma = rs.getString(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				String gender = rs.getString(4);
				String birth = rs.getString(5);
				String queQuan = rs.getString(6);
				SinhVien sv = new SinhVien(ma, ho, ten, queQuan, birth, gender);
				dssv.add(sv);
			}
			return dssv;
		}
		
		public ArrayList<SinhVien> findGender(String genDer) throws SQLException {
			Connection cnt = Database.getInstance().getConnection();
			PreparedStatement prestm = null;
			ResultSet rs = null;
			try {
				prestm = cnt.prepareStatement("SELECT * FROM SinhVien where gender like CONCAT( '%',?,'%')");
				prestm.setString(1, genDer);
				rs = prestm.executeQuery();
			} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng kiểm tra lại mã số sinh viên nhập vào!");
			e.printStackTrace();
			}
			while (rs.next()) {
				String ma = rs.getString(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				String gender = rs.getString(4);
				String birth = rs.getString(5);
				String queQuan = rs.getString(6);
				SinhVien sv = new SinhVien(ma, ho, ten, queQuan, birth, gender);
				dssv.add(sv);
			}
			return dssv;
		}
		public ArrayList<SinhVien> findBirth(String birthD) throws SQLException {
			Connection cnt = Database.getInstance().getConnection();
			PreparedStatement prestm = null;
			ResultSet rs = null;
			try {
				prestm = cnt.prepareStatement("SELECT * FROM SinhVien where birth like CONCAT( '%',?,'%')");
				prestm.setString(1, birthD);
				rs = prestm.executeQuery();
			} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng kiểm tra lại mã số sinh viên nhập vào!");
			e.printStackTrace();
			}
			while (rs.next()) {
				String ma = rs.getString(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				String gender = rs.getString(4);
				String birth = rs.getString(5);
				String queQuan = rs.getString(6);
				SinhVien sv = new SinhVien(ma, ho, ten, queQuan, birth, gender);
				dssv.add(sv);
			}
			return dssv;
		}
		public ArrayList<SinhVien> findQue(String que) throws SQLException {
			Connection cnt = Database.getInstance().getConnection();
			PreparedStatement prestm = null;
			ResultSet rs = null;
			try {
				prestm = cnt.prepareStatement("SELECT * FROM SinhVien where queQuan like CONCAT( '%',?,'%')");
				prestm.setString(1, que);
				rs = prestm.executeQuery();
			} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng kiểm tra lại mã số sinh viên nhập vào!");
			e.printStackTrace();
			}
			while (rs.next()) {
				String ma = rs.getString(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				String gender = rs.getString(4);
				String birth = rs.getString(5);
				String queQuan = rs.getString(6);
				SinhVien sv = new SinhVien(ma, ho, ten, queQuan, birth, gender);
				dssv.add(sv);
			}
			return dssv;
		}
		public boolean create(String maSV, String ho, String ten, String gender, String birth, String queQuan) {
			Connection cnt = Database.getInstance().getConnection();
			PreparedStatement prestm = null;
			int n = 0;
			try {
				prestm = cnt.prepareStatement("SET DATEFORMAT DMY insert into SinhVien values(?, ?, ?, ?, ?, ?)");
				prestm.setString(1, maSV);
				prestm.setString(2, ho);
				prestm.setString(3, ten);
				prestm.setString(4, gender);
				prestm.setString(5, birth);
				prestm.setString(6, queQuan);
				n = prestm.executeUpdate();
				JOptionPane.showMessageDialog(null, "Thêm sinh viên thành công!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng kiểm tra lại mã số sinh viên hoặc định dạng ngày sinh!");
				e.printStackTrace();
			}finally {
				
			}
			return n>0;
		}
		public boolean update(String maSV, String ho, String ten, String gender, String birth, String queQuan) {
			Connection cnt = Database.getInstance().getConnection();
			PreparedStatement prestm = null;
			int n = 0;
			try {
				prestm = cnt.prepareStatement("update SinhVien set ho = ?, ten = ?, gender = ?, birth = ?, queQuan = ? where maSV = ?");
				prestm.setString(1, ho);
				prestm.setString(2, ten);
				prestm.setString(3, gender);
				prestm.setString(4, birth);
				prestm.setString(5, queQuan);
				prestm.setString(6, maSV);
				n = prestm.executeUpdate();
				JOptionPane.showMessageDialog(null, "Đã cập nhật sinh viên thành công!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi không xác định!");
				e.printStackTrace();
			}finally {
				
			}
			return n>0;
		}
		public boolean delete(String maSV) {
			Connection cnt = Database.getInstance().getConnection();
			PreparedStatement prestm = null;
			int n = 0;
			try {
				prestm = cnt.prepareStatement("delete from SinhVien where maSV = ?");
				prestm.setString(1, maSV);
				n = prestm.executeUpdate();
				JOptionPane.showMessageDialog(null, "Đã xóa sinh viên thành công!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi không xác định!");
				e.printStackTrace();
			}
			return n>0;
		}
		public boolean deleteMoreInfor(String maSV, String ho, String ten, String gender, String birth, String queQuan) {
			Connection cnt = Database.getInstance().getConnection();
			PreparedStatement prestm = null;
			int n = 0;
			try {
				prestm = cnt.prepareStatement("delete from SinhVien where maSV like CONCAT( '%',?,'%') and ho like CONCAT( '%',?,'%') and ten like CONCAT( '%',?,'%') and gender like CONCAT( '%',?,'%') and birth like CONCAT( '%',?,'%') and queQuan like CONCAT( '%',?,'%')");
				prestm.setString(1, maSV);
				prestm.setString(2, ho);
				prestm.setString(3, ten);
				prestm.setString(4, gender);
				prestm.setString(5, birth);
				prestm.setString(6, queQuan);
				n = prestm.executeUpdate();
				JOptionPane.showMessageDialog(null, "Đã xóa sinh viên tương ứng thành công!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Các thông tin nhập vào không chính xác!");
				e.printStackTrace();
			}
			return n>0;
		}
}
