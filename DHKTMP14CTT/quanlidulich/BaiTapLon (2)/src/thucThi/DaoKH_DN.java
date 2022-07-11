package thucThi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import enTiTy.KhachHang;
import giaoDienBT.KH_DangNhapCS;
import giaoDienBT.KH_SauDangNhap;
import ketNoiSQL.DataBase;

public class DaoKH_DN {
		ArrayList<KhachHang> lkh;
		KhachHang kh;
		KH_DangNhapCS m = new KH_DangNhapCS();
		public DaoKH_DN() {
			lkh = new ArrayList<KhachHang>();
			kh = new KhachHang();
		}

		public void Load() {
			if(m.txtUser.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập UserName");
			}else if(m.txtPw.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập Password");
			}else {
				try {
					 
					Connection con = DataBase.getInstance().getConnection();
					String sql = "select *from Customer \r\n" + 
							"		where UserName = '?' and Password = '?'";
					
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {
						KH_SauDangNhap n= new KH_SauDangNhap();
						n.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Đăng Nhập thất bại");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	
}
