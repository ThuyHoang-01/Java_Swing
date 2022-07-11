package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.Database;
import entity.SinhVien;
import entity.ThongTinThue;

public class DSTTro {
	private ArrayList<ThongTinThue> dstt;
	public DSTTro() {
		dstt = new ArrayList<ThongTinThue>();
		ThongTinThue ttt = new ThongTinThue();
	}
	public ArrayList<ThongTinThue> readDB(){
		try {
			Connection cnt = Database.getInstance().getConnection();
			String sql = "Select * From ThueTro";
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
				String tenNT = rs.getString(7);
				String chuTro = rs.getString(8);
				String soDT = rs.getString(9);
				ThongTinThue ttt = new ThongTinThue(ma, ho, ten, queQuan, birth, gender, tenNT, chuTro, soDT);
				dstt.add(ttt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//Đóng kết nối
			//cnt.close();
		}
		return dstt;
	}
	public boolean create(String maSV, String ho, String ten, String gender, String birth, String queQuan, String tenNT, String chuTro, String soDT) {
		Connection cnt = Database.getInstance().getConnection();
		PreparedStatement prestm = null;
		int n = 0;
		try {
			prestm = cnt.prepareStatement("SET DATEFORMAT DMY insert into SinhVien values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			prestm.setString(1, maSV);
			prestm.setString(2, ho);
			prestm.setString(3, ten);
			prestm.setString(4, gender);
			prestm.setString(5, birth);
			prestm.setString(6, queQuan);
			prestm.setString(6, tenNT);
			prestm.setString(6, chuTro);
			prestm.setString(6, soDT);
			n = prestm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Thuê trọ thành công!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, vui lòng kiểm tra lại mã số sinh viên hoặc tên nhà trọ!");
			e.printStackTrace();
		}finally {
			
		}
		return n>0;
	}
}
