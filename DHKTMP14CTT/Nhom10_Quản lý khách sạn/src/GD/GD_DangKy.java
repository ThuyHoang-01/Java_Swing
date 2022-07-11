package GD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GD_DangKy extends JFrame implements ActionListener, MouseListener {
	private JTextField txtHoten;
	private JTextField txtCMND;
	private JTextField txtNgayThue;
	private JTextField txtmaKH;
	private JTextField txtLoaiPhong;

	private JTextField txtDonGia;
	
	private JButton btnThem;
	
	private JLabel lblHoTen, lblCMND, lblNgayThue, lblmaKH, lblLoaiPhong, lblDonGia;
	private JButton btnLuu;
	public static DefaultTableModel tableModel;
	private JTable table;
	private JTextField txtMess;
	private JButton btnXoaRong, btnMenu;
	private JComboBox<String> cbcloaiphong;
	public GD_DangKy() {
		setTitle("Quản Lý Khách Sạn");
		setSize(900, 600);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setResizable(false);	
		 setVisible(true);
		
		 JPanel pNorth;
			add(pNorth = new JPanel(), BorderLayout.NORTH);
			pNorth.setPreferredSize(new Dimension(0, 150));
			pNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
			pNorth.setLayout(null);

			pNorth.add(lblmaKH = new JLabel("Mã khách hàng: "));
			pNorth.add(lblHoTen = new JLabel("Họ tên: "));
			pNorth.add(lblCMND = new JLabel("Số CMND: "));
			pNorth.add(lblNgayThue = new JLabel("Ngày thuê: "));
			
			pNorth.add(lblLoaiPhong = new JLabel("Loại phòng: "));
			pNorth.add(lblDonGia = new JLabel("Đơn giá: "));
			
			pNorth.add(txtmaKH = new JTextField());
			pNorth.add(txtHoten = new JTextField());
			pNorth.add(txtCMND = new JTextField());
			pNorth.add(txtNgayThue = new JTextField());
			
			DefaultComboBoxModel<String> cbcModel = new DefaultComboBoxModel<String>();
			cbcModel.addElement("VIP-Đôi");
			cbcModel.addElement("VIP-Đơn");
			cbcModel.addElement("Thường-Đôi");
			cbcModel.addElement("Thường-Đơn");
			cbcloaiphong = new JComboBox<String>(cbcModel);
			cbcloaiphong.setEditable(false);
			pNorth.add(cbcloaiphong);
			pNorth.add(txtDonGia = new JTextField());
			

			pNorth.add(txtMess = new JTextField());
			txtMess.setEditable(false);
			txtMess.setBorder(null);
			txtMess.setForeground(Color.RED);
			txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

			int w1 = 100, w2 = 300, h = 20;
			lblmaKH.setBounds(20, 20, w1, h);
			txtmaKH.setBounds(120, 20, 200, h);
			
			lblHoTen.setBounds(20, 45, w1, h);
			txtHoten.setBounds(120, 45, 200, h);

			lblCMND.setBounds(20, 70, w1, h);
			txtCMND.setBounds(120, 70, w2, h);

			lblNgayThue.setBounds(450, 20, w1, h);
			txtNgayThue.setBounds(570, 20, w2, h);

		

			lblLoaiPhong.setBounds(450, 45, w1, h);
			cbcloaiphong.setBounds(570, 45, w2, h);

			lblDonGia.setBounds(450, 70, w1, h);
			txtDonGia.setBounds(570, 70, w2, h);

	
			txtMess.setBounds(20, 145, 550, 20);

			JPanel pCen;
			add(pCen = new JPanel(), BorderLayout.CENTER);
			pCen.add(btnThem = new JButton("Thêm"));
			pCen.add(btnXoaRong = new JButton("Xóa rổng"));
			pCen.add(btnLuu = new JButton("Lưu"));
			pCen.add(btnMenu= new JButton("Về Menu"));
			JScrollPane scroll;
			String[] headers = "Mã khách hàng;Họ tên;CMND;Ngày thuê;Loại phòng;DonGia".split(";");
			tableModel = new DefaultTableModel(headers, 0);
			add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
			scroll.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));
			table.setRowHeight(20);
			scroll.setPreferredSize(new Dimension(0, 350));

			
			btnThem.addActionListener(this);
			btnXoaRong.addActionListener(this);
			btnLuu.addActionListener(this);
			table.addMouseListener(this);
			btnMenu.addActionListener(this);
	}
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnMenu)){
					new Menu().setVisible(true);
					this.setVisible(false);
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
	new GD_DangKy().setVisible(true);
}
	
	
}
