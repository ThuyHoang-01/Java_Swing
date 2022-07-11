package GD;

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

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class GD_TraPhong extends JFrame implements ActionListener{
	private JLabel lblHoTen, lblSLphong,lbltgtra,lbldVu,lblLoaiPhong;
	private JComboBox  cboLoaiPhong;
	private JTextField txtHoTen, txtSLphong,txtLoaiPhong,txttgtra,txtdVu, txtMess;
	private JButton btnThem, btnXoa, btnXoaRong,btnSua, btnThoat, btnLuu, btnMenu;
	public static DefaultTableModel tableModel;
	private JTable table;
	
	public GD_TraPhong() {
		setTitle("Quản lý khách sạn");
		setSize(700, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		 JPanel pNorth;
			add(pNorth = new JPanel(), BorderLayout.NORTH);
			pNorth.setPreferredSize(new Dimension(0, 160));
			pNorth.setBorder(BorderFactory.createTitledBorder("Form Trả Phòng"));
			pNorth.setLayout(null);

			pNorth.add(lblHoTen = new JLabel("Họ tên Khách Hàng:"));
			pNorth.add(lblSLphong= new JLabel("Số lượng phòng : "));
			pNorth.add(lblLoaiPhong= new JLabel("Loại Phòng"));
			pNorth.add(lbltgtra = new JLabel("Thời gian trả phòng :"));
			pNorth.add(lbldVu= new JLabel("Dịch vụ sử dụng :"));
			DefaultComboBoxModel<String> select = new DefaultComboBoxModel();
			select.addElement("Thường đơn");
			select.addElement("Thường đôi");
			select.addElement("Vip đơn");
			select.addElement("Vip đôi");
			pNorth.add(txtHoTen = new JTextField());
			pNorth.add(txtSLphong = new JTextField());
			pNorth.add(cboLoaiPhong = new JComboBox(select));
			pNorth.add(txttgtra= new JTextField());
			pNorth.add(txtdVu= new JTextField());
		
			

			pNorth.add(txtMess = new JTextField());
			txtMess.setEditable(false);
			txtMess.setBorder(null);
			txtMess.setForeground(Color.RED);
			txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

			int w1 = 200, w2 = 300, h = 20;
			lblHoTen.setBounds(20, 20, w1, 20);
			txtHoTen.setBounds(220, 20, w2, h);
			
			lblSLphong.setBounds(20, 45, w1, h);
			txtSLphong.setBounds(220, 45, w2, h);

			lblLoaiPhong.setBounds(20, 70, w1, h);
			cboLoaiPhong.setBounds(220, 70, w2, h);

			lbltgtra.setBounds(20, 95, w1, h);
			txttgtra.setBounds(220, 95, w2, h);
		
		
	
	
			txtMess.setBounds(20, 145, 550, 20);

			JPanel pCen;
			add(pCen = new JPanel(), BorderLayout.CENTER);
			pCen.add(btnThem = new JButton("Thêm"));
			pCen.add(btnXoaRong = new JButton("Xóa rổng"));
			pCen.add(btnLuu = new JButton("Lưu"));
			pCen.add(btnMenu = new JButton("Về menu"));
			JScrollPane scroll;
			String[] headers = "Họ Tên;Số lượng phòng;Loại Phòng ;Thời gian trả ;Dịch Vụ".split(";");
			tableModel = new DefaultTableModel(headers, 0);
			add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
			scroll.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
			table.setRowHeight(20);
			scroll.setPreferredSize(new Dimension(0, 350));
			btnMenu.addActionListener(this);

	}
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource().equals(btnMenu)) {
		new Menu().setVisible(true);
		this.setVisible(false);
		}
	}

	public static void main(final String[] args) {
		final GD_TraPhong frm = new GD_TraPhong();
		frm.setVisible(true);
	
}
}


