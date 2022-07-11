package app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmDangNhapTV extends JFrame implements ActionListener{
	private JButton btnDN,btnDK,btnBack;
	private JTextField txtcmnd;
	private Database database;
	public FrmDangNhapTV() {
		setTitle("Thành Viên");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pNorth;
		JLabel lblCMND;
		add(pNorth = new JPanel(),BorderLayout.NORTH);
		pNorth.add(lblCMND = new JLabel("CMND: "));
		pNorth.add(txtcmnd = new JTextField(30));
		JPanel pCen;
		add(pCen = new JPanel(), BorderLayout.CENTER);
		btnDN = new JButton("Đăng nhập");
		pCen.add(btnDN);
		btnDK = new JButton("Đăng ký");
		pCen.add(btnDK);
		btnBack = new JButton("Trở về");
		pCen.add(btnBack);
		btnDN.addActionListener(this);
		btnDK.addActionListener(this);
		btnBack.addActionListener(this);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnDK)) {
			new FrmDangKyTV().setVisible(true);
			this.setVisible(false);
		}else if(o.equals(btnDN)) {
				if(database.checkTV(txtcmnd.getText().trim())) {
					database.DeleteCart();
					ThanhVien tv = new ThanhVien(txtcmnd.getText().trim());
					QuanLyBDCart.SetKhachHang(txtcmnd.getText().trim());
					new FrmBangDiaKhachHang().setVisible(true);
					this.setVisible(false);
				}else JOptionPane.showMessageDialog(this, "CMND không tồn tại");
			}else if(o.equals(btnBack)) {
				new FrmMenu().setVisible(true);
				this.setVisible(false);
			}
		
	}
	
}
