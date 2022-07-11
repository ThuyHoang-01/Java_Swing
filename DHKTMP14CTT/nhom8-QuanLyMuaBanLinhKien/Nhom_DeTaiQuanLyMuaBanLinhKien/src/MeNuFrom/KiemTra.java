package MeNuFrom;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import NhanVien.FrmNhanVien;

public class KiemTra extends JFrame implements ActionListener {
	
	private JPasswordField txtpassword;
	private JButton btnDangNhap,btnThoat;
	private JLabel lblTieuDe,lblPassword;
	
	public KiemTra() {
		setSize(450, 200);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel pnorth = new JPanel();
		add(pnorth,BorderLayout.NORTH);
		pnorth.add(lblTieuDe = new JLabel("Nhập mã của phòng nhân sự"));
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel pcenter = new JPanel();
		add(pcenter,BorderLayout.CENTER);
		pcenter.setLayout(null);
		
		pcenter.add(lblPassword = new JLabel("Mật khẩu"));
		pcenter.add(txtpassword = new JPasswordField());
		
		pcenter.add(btnDangNhap = new JButton("Đăng nhập"));
		pcenter.add(btnThoat = new JButton("Thoát"));
		
		lblPassword.setBounds(20, 20, 100, 40);
		txtpassword.setBounds(100, 20, 300, 40);
		
		btnDangNhap.setBounds(100, 80, 100, 40);
		btnThoat.setBounds(280, 80, 100,40);
		
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new KiemTra().setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(btnDangNhap)) {
			char chPassword[] = txtpassword.getPassword();
			String strPassword = new String(chPassword);
			if(strPassword.equals("")) {
				JOptionPane.showMessageDialog(null,"Xin nhập vào mật khẩu");
				return;
			}else {
				if(strPassword.trim().equals("123456")){
					dispose();
					new FrmNhanVien().setVisible(true);
					txtpassword.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
					txtpassword.setText("");
				}
			}
		}
		
		if(o.equals(btnThoat)) {
			dispose();
		}
		
		
		
		
	}

}
