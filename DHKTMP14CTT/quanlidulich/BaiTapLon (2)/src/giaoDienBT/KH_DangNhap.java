package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.*;


public class KH_DangNhap extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtUser;
	public JPasswordField txtPw;
	public JLabel lblUser,lblTitle,lblPw;
	public JButton btnDangNhap,btnDangKiTK,btnThoat;

	private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=CompanyTouris;"
            + "integratedSecurity=false";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "sapassword";
	public KH_DangNhap() {
		super("Form đăng nhập của khách hàng");
		setSize(450, 180);
		setLocation(400, 100);
	//	setVisible(true);
		setResizable(false);

		JPanel pNorth = new JPanel();
		pNorth.add(lblTitle = new JLabel("Đăng Nhập tài khoản"));
		lblTitle.setFont(new Font("Time news Roman",Font.BOLD,20));
		lblTitle.setForeground(Color.BLUE);
	
		add(pNorth,BorderLayout.NORTH);
		
		Box b = Box.createVerticalBox();
		Box b1,b2,b3,b4;
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblUser = new JLabel("Tài Khoản:"));
		b1.add(txtUser = new JTextField());
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblPw = new JLabel("Mật Khẩu: "));
		txtPw= new JPasswordField();
		b2.add(txtPw);
		
		//lblPw.setPreferredSize(lblUser.getPreferredSize());
		
		b.add(b3 = Box.createHorizontalBox());
		b3.add(Box.createHorizontalStrut(30));
		b3.add(btnDangNhap = new JButton("Đăng Nhập"));
		btnDangNhap.setBackground(Color.white);
		try {
			BufferedImage image = ImageIO.read(new File("dautich.png"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(20	, 20, java.awt.Image.SCALE_SMOOTH));
			btnDangNhap.setIcon(im);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		b3.add(Box.createHorizontalStrut(20));
		b3.add(btnDangKiTK = new JButton("Đăng ký"));
		btnDangKiTK.setBackground(Color.white);
		try {
			BufferedImage image = ImageIO.read(new File("dangky.jpg"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
			btnDangKiTK.setIcon(im);
		} catch (Exception e) {
			e.printStackTrace();
		}
		b3.add(Box.createHorizontalStrut(20));
		b3.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(Color.white);
		try {
			BufferedImage image = ImageIO.read(new File("thoat1.jpg"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(20	, 20, java.awt.Image.SCALE_SMOOTH));
			btnThoat.setIcon(im);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JPanel pnSouth = new JPanel();
		pnSouth.add(b3);
		add(pnSouth,BorderLayout.SOUTH);
		btnDangNhap.addActionListener(this);
		btnDangKiTK.addActionListener(this);
		btnThoat.addActionListener(this);
		
		add(b,BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		KH_DangNhap dm = new KH_DangNhap();
		dm.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		if(obj.equals(btnDangNhap)) {
			if(txtUser.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập UserName");
			}else if(txtPw.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập Password");
			}else {
				try {
					Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
					String sql =  "select Id, UserName, Password from Customer where UserName = ? and Password = ?";
					 ps = con.prepareStatement(sql);
					 ps.setString(1, txtUser.getText());
					 ps.setString(2, txtPw.getText());
					 rs = ps.executeQuery();
					if(rs.next()) {
						
					System.setProperty("tour.userId", rs.getString(1));					
					
						new KH_SauDangNhap().setVisible(true);
						this.dispose();
					}else {
						JOptionPane.showMessageDialog(this, "Đăng Nhập thất bại");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		if(obj.equals(btnDangKiTK)) {
			new KH_DangKy().setVisible(true);
			
		}
		if(obj.equals(btnThoat)) {
			setVisible(false);
			new Main_Frm();
		}
		
	}


	}
