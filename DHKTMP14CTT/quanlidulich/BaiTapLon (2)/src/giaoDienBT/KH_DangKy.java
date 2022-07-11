package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ketNoiSQL.DataBase;
import thucThi.DK_KH;


public class KH_DangKy extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblId,lblhoten, lblemail, lblmatkhau, lblmatkhau2, lblUser, lblSdt;
	public JTextField txthoten, txtemail, txtmatkhau, txtmatkhau2, txtUser,txtSdt;
	public JButton btnDangKi, btnThoat,btnXoaRong;
	DefaultTableModel tableModel;
	JTable table;
	DK_KH dk = new DK_KH();
	
	public KH_DangKy() {
		super("Đăng ký tài khoản khách hàng");
		setSize(400,300);
		setLocation(400,100);
		setResizable(false);
		Box b = Box.createVerticalBox();
		Box b2,b3,b4,b5,b6;
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblhoten = new JLabel("Họ Tên:"));
		b2.add(txthoten = new JTextField());
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblemail = new JLabel("Email:"));
		b3.add(txtemail = new JTextField());
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblSdt = new JLabel("Số điện thoại:"));
		b4.add(txtSdt = new JTextField());
		
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b5.add(lblUser = new JLabel("User:"));
		b5.add(txtUser = new JTextField());
		
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b6.add(lblmatkhau = new JLabel("Nhập mật khẩu:"));
		b6.add(txtmatkhau = new JTextField());
		
		lblhoten.setPreferredSize(lblmatkhau.getPreferredSize());
		lblemail.setPreferredSize(lblmatkhau.getPreferredSize());
		lblUser.setPreferredSize(lblmatkhau.getPreferredSize());
		lblmatkhau.setPreferredSize(lblmatkhau.getPreferredSize());
		lblSdt.setPreferredSize(lblmatkhau.getPreferredSize());
		
		
		b.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
		b.setBackground(java.awt.Color.gray);
		add(b,BorderLayout.CENTER);
		
		JPanel pSouth;
		add(pSouth = new JPanel(),BorderLayout.SOUTH);
		pSouth.add(btnDangKi = new JButton("Đăng ký"));
		pSouth.add(btnXoaRong = new JButton("Xóa Rỗng"));
		pSouth.add(btnThoat = new JButton("Thoát")); 
		btnDangKi.setBackground(java.awt.Color.cyan);
		btnThoat.setBackground(java.awt.Color.cyan);
		btnXoaRong.setBackground(java.awt.Color.cyan);
		
		btnXoaRong.addActionListener(this);
		btnDangKi.addActionListener(this);
		btnThoat.addActionListener(this);
		DataBase.getInstance().connect();
		
	}
	public void XoaRong() {
		txthoten.setText("");
		txtemail.setText("");
		txtUser.setText("");
		txtSdt.setText("");
		txtmatkhau.setText("");
		txthoten.requestFocus();
	}
	public static void main(String[] args) {
		KH_DangKy dk =new KH_DangKy();
		dk.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnDangKi)) {
			if(dk.createKH( txthoten.getText(), txtemail.getText(), txtSdt.getText(), txtUser.getText(), txtmatkhau.getText())) {
				JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
				setVisible(false);
				new KH_DanhSach().setVisible(true);
				
			}
		}else if(obj.equals(btnXoaRong)) {
			XoaRong();
		}else if(obj.equals(btnThoat)) {
			setVisible(false);
			new Main_Frm();
		}
		
	}

}
