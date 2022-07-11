package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class NV_DangNhap extends JFrame  implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtUser;
	public JLabel lblUser,lblTitle,lblPw;
	public JPasswordField txtPw;
	public JButton btnDangNhap,btnDangKiTK,btnThoat;

	private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=CompanyTouris;"
            + "integratedSecurity=false";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "manh123";
	public NV_DangNhap() {
		super("Form đăng nhập của nhân viên");
		setSize(350, 180);
		setLocation(400, 200);
		setResizable(false);
		JPanel pNorth = new JPanel();

		pNorth.add(lblTitle = new JLabel("Nhân Viên Đăng Nhập"));
		lblTitle.setFont(new Font("Time news Roman",Font.BOLD,20));
		lblTitle.setForeground(Color.BLUE);
		add(pNorth,BorderLayout.NORTH);
		
		Box b = Box.createVerticalBox();
		Box b1,b2,b3,b4;
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblUser = new JLabel("User:  "));
		b1.add(txtUser = new JTextField());
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblPw = new JLabel("Password: "));
		txtPw= new JPasswordField();
		b2.add(txtPw);
		
		lblUser.setPreferredSize(lblPw.getPreferredSize());	
		add(b,BorderLayout.CENTER);
		
		JPanel pnSouth = new JPanel();
		b.add(b3 = Box.createHorizontalBox());
		b3.add(btnDangNhap = new JButton("Đăng Nhập"));
		btnDangNhap.setBackground(Color.pink);
		b3.add(Box.createHorizontalStrut(20));
		b3.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(Color.pink);
		pnSouth.add(b3);
		add(pnSouth, BorderLayout.SOUTH);
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
	}
	public static void main(String[] args) {
		NV_DangNhap n = new NV_DangNhap();
		n.setVisible(true);
	}
	@SuppressWarnings("deprecation")
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
					String sql =  "Select [UserName],[Password] from [dbo].[User] where UserName = ? and Password = ?";
					 ps = con.prepareStatement(sql);
					 ps.setString(1, txtUser.getText());
					 ps.setString(2, txtPw.getText());
					 rs = ps.executeQuery();
					if(rs.next()) {
						
						NV_SauDangNhap v = new NV_SauDangNhap();
						v.setVisible(true);
						this.dispose();
					}else {
						JOptionPane.showMessageDialog(this, "Đăng Nhập thất bại");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
	
		}
	
		if(obj.equals(btnThoat)) {
			setVisible(false);
			new Menu().setVisible(true);
		}
		
	}
	

}
