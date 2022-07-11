package MeNuFrom;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class DangNhap extends JFrame implements ActionListener,MouseListener{
	
	private JTextField txtuser;
	private JPasswordField txtpassword;
	private JButton btnDangNhap,btnThoat;
	private JLabel lblTieuDe,lbluser,lblPassword;
	
	public DangNhap() {
		setSize(500, 300);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel pnorth = new JPanel();
		add(pnorth,BorderLayout.NORTH);
		pnorth.add(lblTieuDe = new JLabel("Đăng Nhập"));
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JPanel pcenter = new JPanel();
		pcenter.setLayout(null);
		
		pcenter.add(lbluser = new JLabel("Tài khoản"));
		pcenter.add(lblPassword = new JLabel("Mật khẩu"));
		
		pcenter.add(txtpassword = new JPasswordField());
		pcenter.add(txtuser = new JTextField());
		
		pcenter.add(btnDangNhap = new JButton("Đăng nhập"));
		pcenter.add(btnThoat = new JButton("Thoát"));
		
		lbluser.setBounds(20,30 ,100, 30);
		txtuser.setBounds(130, 30, 300,30);
		
		lblPassword.setBounds(20,80 ,100, 30);
		txtpassword.setBounds(130, 80, 300,30);
		
		btnDangNhap.setBounds(130, 130, 100, 30);
		btnThoat.setBounds(310, 130, 100, 30);
		
		
		add(pcenter,BorderLayout.CENTER);
		
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
		
		
		
		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDangNhap)) {
			char chPassword[] = txtpassword.getPassword();
			String strPassword = new String(chPassword);
			String nhap = txtuser.getText();
			if(nhap.equals("")|| strPassword.equals("")) {
				JOptionPane.showMessageDialog(null,"Xin nhập đầy đủ tên đăng nhập và mật khẩu");
				return;
			}else {
				if(strPassword.trim().equals("hoangmy")&& nhap.equals("mynguyen833")){
					dispose();
					new MeNuDemo().setVisible(true);
					txtpassword.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
					txtpassword.setText("");;
					txtuser.selectAll();
					txtuser.requestFocus();
				}
			}
		}if(o.equals(btnThoat)) {
			dispose();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new DangNhap().setVisible(true);
	}
	

}

