package baiTapLon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HoaDon extends JFrame implements ActionListener,MouseListener{

	private JTable table;
	private JTextField txtidphong, txtidKH, txtTimKiem, txtten, txtgia,txtngayNhan,txtgioNhan,txtngayTra,txtgioTra;
	private JComboBox<String> cBoxTheLoai;
	private JButton btnOK, btnCancel;
	public static DefaultTableModel tableModel;
	JLabel lblidPhong, lblidKH, lblTimKiem, lblGia, lblten, lblOK, lblNgayNhan, lblGioNhan, lblNgayTra, lblGioTra;
	
	public HoaDon() {
		super("Form Hóa Đơn");
		setSize(600,300);
		setLocationRelativeTo(null);
		GiaoDien();
	}
	public void GiaoDien() {
		JLabel lblTitl;
		JPanel pNorth;
		
		add(pNorth = new JPanel(),BorderLayout.NORTH);
		pNorth.add(lblTitl = new JLabel("HÓA ĐƠN"));
		lblTitl.setFont(new Font("Arial",Font.BOLD,50));
		lblTitl.setForeground(Color.BLUE);
		
		Box b = Box.createVerticalBox();
		Box b1,b2,b3,b4,b5,b6;
		
		
		
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblidPhong = new JLabel("ID Phòng"));
		b1.add(Box.createHorizontalStrut(30));
		b1.add(txtidphong = new JTextField(5));
		txtidphong.setEditable(false);
		b1.add(Box.createHorizontalStrut(30));
		b1.add(lblidKH = new JLabel("ID Khách Hàng"));
		b1.add(Box.createHorizontalStrut(5));
		b1.add(txtidKH = new JTextField(5));
		txtidKH.setEditable(false);
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblten = new JLabel("Họ Tên "));
		b3.add(Box.createHorizontalStrut(30));
		b3.add(txtten = new JTextField(20));
		txtten.setEditable(false);
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblGia = new JLabel("Thành Tiền"));
		b4.add(Box.createHorizontalStrut(30));
		b4.add(txtgia = new JTextField(15));
		txtgia.setEditable(false);
		
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b5.add(lblNgayNhan = new JLabel("Ngày Nhận"));
		b5.add(Box.createHorizontalStrut(30));
		b5.add(txtngayNhan = new JTextField(10));
		txtngayNhan.setEditable(false);
		b5.add(lblGioNhan = new JLabel("         Giờ Nhận"));
		b5.add(Box.createHorizontalStrut(30));
		b5.add(txtgioNhan = new JTextField(10));
		txtgioNhan.setEditable(false);
		
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b6.add(lblNgayTra = new JLabel("Ngày Trả"));
		b6.add(Box.createHorizontalStrut(30));
		b6.add(txtngayTra = new JTextField(10));
		txtngayTra.setEditable(false);
		b6.add(lblGioTra = new JLabel("         Giờ Trả"));
		b6.add(Box.createHorizontalStrut(30));
		b6.add(txtgioTra = new JTextField(10));
		txtgioTra.setEditable(false);
		
		
		pNorth.add(b);
		add(pNorth, BorderLayout.CENTER);
		
		lblidPhong.setPreferredSize(lblGia.getPreferredSize());
		lblNgayNhan.setPreferredSize(lblGia.getPreferredSize());
		lblNgayTra.setPreferredSize(lblGia.getPreferredSize());
		lblten.setPreferredSize(lblGia.getPreferredSize());
		
		lblGioNhan.setPreferredSize(lblidKH.getPreferredSize());
		lblGioTra.setPreferredSize(lblidKH.getPreferredSize());
		
		
	
		
		JPanel pSouth;
		add(pSouth = new JPanel(),BorderLayout.SOUTH);
		pSouth.add(btnOK = new JButton("OK"));
		btnOK.setBackground(Color.yellow);
		pSouth.add(btnCancel = new JButton("Cancel"));
		btnCancel.setBackground(Color.yellow);
		
		
		btnCancel.addActionListener(this);
		btnOK.addActionListener(this);
	
	}
	
	

	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();
		if(a.equals(btnCancel)) {
			setVisible(false);
			
		}
		
		if(a.equals(btnOK)) {
			JOptionPane.showMessageDialog(this, "Thanh Toán Thành Công");
			setVisible(false);
			
		}
		
	}
	public void mouseClicked(MouseEvent e) {
	
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
	HoaDon fm = new HoaDon();
		fm.setVisible(true);
		
	}

}
