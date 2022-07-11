package giaoDienBT;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class DangNhap extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtTenDangNhap;
	private JPasswordField txtMatKhau;
	private JButton btnDangNhap;
	private JCheckBox cbNhanVien;
	private JButton btnDangKy;
	private static String db_url = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=CompanyTouris;"
            + "integratedSecurity=false";
	private static String userName = "sa";
	private static String passWord = "sapassword";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap() {
		setBounds(150, 50, 1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(0, 0, 1000, 700);
		contentPane.add(desktopPane);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setForeground(Color.BLACK);
		lblBackground.setBackground(Color.WHITE);
		Image imgBackground = new ImageIcon(this.getClass().getResource("/bg2.jpeg")).getImage();
		lblBackground.setIcon(new ImageIcon(imgBackground));
		lblBackground.setBounds(0, 0, 990, 662);
		desktopPane.add(lblBackground);
		
		JLabel lblQldl = new JLabel("Quản lý du lịch");
		lblQldl.setBackground(Color.WHITE);
		lblQldl.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		desktopPane.setLayer(lblQldl, 1);
		lblQldl.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblQldl.setBounds(403, 36, 220, 49);
		desktopPane.add(lblQldl);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		desktopPane.setLayer(panel, 1);
		panel.setBounds(323, 169, 384, 367);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setText("");
		txtTenDangNhap.setBounds(87, 80, 289, 27);
		panel.add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);
		
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setText("");
		txtMatKhau.setBounds(87, 128, 289, 27);
		panel.add(txtMatKhau);
		txtMatKhau.setColumns(10);
		
		
		btnDangNhap = new JButton("Xác Nhận");
		btnDangNhap.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDangNhap.setBackground(Color.RED);
		btnDangNhap.setBounds(10, 223, 366, 40);
		panel.add(btnDangNhap);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 0, 417, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDangNhap = new JLabel("Đăng nhập");
		lblDangNhap.setBackground(Color.CYAN);
		lblDangNhap.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setBounds(0, 0, 382, 50);
		panel_1.add(lblDangNhap);
		
		JLabel lblDangKy = new JLabel("Nếu chưa có tài khoản hãy đăng ký");
		lblDangKy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDangKy.setFont(new Font("SansSerif", Font.ITALIC, 12));
		lblDangKy.setBounds(10, 285, 289, 20);
		panel.add(lblDangKy);
		
		 btnDangKy = new JButton("Đăng ký");
		btnDangKy.setForeground(Color.BLACK);
		btnDangKy.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDangKy.setBounds(10, 316, 366, 40);
		panel.add(btnDangKy);
		
		cbNhanVien = new JCheckBox("Nhân viên");
		cbNhanVien.setFont(new Font("SansSerif", Font.ITALIC, 12));
		cbNhanVien.setBackground(Color.WHITE);
		cbNhanVien.setBounds(295, 176, 81, 23);
		panel.add(cbNhanVien);
		
		JLabel lblTiKhon = new JLabel("Tài Khoản :");
		lblTiKhon.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblTiKhon.setBounds(10, 79, 99, 27);
		panel.add(lblTiKhon);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu :");
		lblMtKhu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblMtKhu.setBounds(10, 130, 72, 21);
		panel.add(lblMtKhu);
		
		
		btnDangNhap.addActionListener(this);
		btnDangKy.addActionListener(this);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		
		if(o.equals(btnDangKy)) {
			new KH_DangKy().setVisible(true);
		}
		if(o.equals(btnDangNhap)) {
			if(txtTenDangNhap.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Không được để trống tên đăng nhập");
			}else if(txtMatKhau.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Không được để trống mật khẩu");
			}else {
				try {
					Connection con = DriverManager.getConnection(db_url, userName, passWord);
					if(cbNhanVien.isSelected() == false) {
						sql = "select Id, UserName, Password from Customer where UserName = ? and Password = ?";
						ps = con.prepareStatement(sql);
						ps.setString(1, txtTenDangNhap.getText());
						ps.setString(2, txtMatKhau.getText());
						rs = ps.executeQuery();
						if(rs.next()) {
							
							System.setProperty("tour.userId", rs.getString(1));					
							
							new KH_SauDangNhap().setVisible(true);
							this.dispose();
							}else {
								JOptionPane.showMessageDialog(this, "Đăng Nhập thất bại");
							}
					}
					if(cbNhanVien.isSelected() == true) {
						sql =  "Select [UserName],[Password] from [dbo].[User] where UserName = ? and Password = ?";
						ps = con.prepareStatement(sql);
						ps.setString(1, txtTenDangNhap.getText());
						ps.setString(2, txtMatKhau.getText());
						rs = ps.executeQuery();
						if(rs.next()) {
							NV_SauDangNhap v = new NV_SauDangNhap();
							v.setVisible(true);
							this.dispose();
						}else {
							JOptionPane.showMessageDialog(this, "Đăng Nhập thất bại");
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		
	}
}













