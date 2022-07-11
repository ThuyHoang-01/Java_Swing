package quanLymuabanXe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class  DangNhap extends JFrame implements ActionListener{
	
	private JLabel lblDangNhap,lblTaiKhoan,lblmatkhau;
	private JTextField txtTaiKhoan,txtMatKhau;
	private JButton btnDangNhap,btnThoat;
	
	public  DangNhap() {
		super("Dang Nhap");
		setSize(350, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDangNhap();
	}

	private void setDangNhap() {
		JPanel pnNorth = new JPanel();
		add(pnNorth,BorderLayout.NORTH);
		pnNorth.add(lblDangNhap = new JLabel("Dang Nhap"));
		lblDangNhap.setFont(new Font("Arial",Font.BOLD,25));
		pnNorth.setBackground(Color.PINK);
		
		JPanel pnCen = new JPanel();
		pnCen.setLayout(null);
		pnCen.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.RED),"Nhap Tai Khoan Mat Khau"));
		
		pnCen.add(lblTaiKhoan = new JLabel("Tai Khoan:"));
		pnCen.add(txtTaiKhoan = new JTextField());
		
		pnCen.add(lblmatkhau = new JLabel("Mat Khau"));
		pnCen.add(txtMatKhau = new JTextField());
		
		lblTaiKhoan.setBounds(30,50, 150,20);
		lblmatkhau.setBounds(30, 85, 150, 20);
		
		txtTaiKhoan.setBounds(100, 50, 200, 20);
		txtMatKhau.setBounds(100, 85, 200, 20);
		pnCen.setPreferredSize(new Dimension(0, 160));
		add(pnCen,BorderLayout.CENTER);
		
		JPanel pnSo = new JPanel();
		add(pnSo,BorderLayout.SOUTH);
		pnSo.add(btnDangNhap = new JButton("Dang Nhap"));
		pnSo.add(btnThoat = new JButton("Dong chuong trinh"));
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new DangNhap();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object sourceEvent = e.getSource();
		if (sourceEvent.equals(btnDangNhap)) {
			ActionfrmHoaDon();
		}
		if (sourceEvent.equals(btnThoat)) {
			int a = JOptionPane.showConfirmDialog(this,"Ban Muon Thoat Chuong trinh","thoat",JOptionPane.YES_NO_OPTION);
			if (a== JOptionPane.YES_OPTION) {
				System.exit(0);;
			}
		}
		
	
	}
		private void ActionfrmHoaDon() {
				if (txtTaiKhoan.getText().equals("admin")&&txtMatKhau.getText().equals("123456")) {
					setVisible(false);
					new Menu().setVisible(true);
				}
				else {
					txtMatKhau.setText("");
					txtTaiKhoan.setText("");
					txtTaiKhoan.requestFocus();
					JOptionPane.showMessageDialog(this,"Sai Tai Khoan Mat Khau");
				}
		}
}