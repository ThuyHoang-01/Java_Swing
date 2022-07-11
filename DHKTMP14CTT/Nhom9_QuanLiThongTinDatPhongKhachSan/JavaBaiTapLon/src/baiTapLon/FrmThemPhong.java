package baiTapLon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmThemPhong extends JFrame implements ActionListener,MouseListener{
	DanhSachPhong dsp= new DanhSachPhong();
	private JTable table;
	private JTextField txtIDPhong, txtTenPhong, txtLoaiPhong, txtGiaPhong, txtTinhTrang;
	private JComboBox<String> cBoxLoai, cBoxTinhTrang;
	private JButton btnThem, btnSua, btnXoa, btnThoat;
	public static DefaultTableModel tableModel;
	
	public FrmThemPhong() {
		super("Quản Lý Phòng");
		setSize(900,600);
		setLocationRelativeTo(null);
		GiaoDien();
	}
	public void GiaoDien() {
		JLabel lblTitl, lbl1;
		JPanel pCenter, pNorth;
		
		pNorth = new JPanel();
		pNorth.add(lbl1 = new JLabel("Thông Tin Phòng"));
		Font fp = new Font("Time New Roman", Font.BOLD, 30);
		lbl1.setFont(fp);
		add(pNorth, BorderLayout.NORTH);
		
		
		
		
		pCenter = new JPanel();
		
		Box b = Box.createVerticalBox();
		Box b1,b2,b3,b4,b5,b6;
		JLabel  lblIDPhong, lblTenPhong, lblLoaiPhong, lblGiaPhong, lblTinhTrang;
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblIDPhong = new JLabel("ID Phòng             "));
		b1.add(txtIDPhong = new JTextField(15));
		txtIDPhong.setEditable(false);
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTenPhong = new JLabel("Tên Phòng          "));
		b2.add(txtTenPhong = new JTextField(15));
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblLoaiPhong = new JLabel("Loại Phòng"));
		b3.add(Box.createHorizontalStrut(30));
		b3.add(cBoxLoai = new JComboBox<String>());
		cBoxLoai.addItem("Đơn");
		cBoxLoai.addItem("Đôi");
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblGiaPhong = new JLabel("Giá Phòng           "));
		b4.add(txtGiaPhong = new JTextField(15));
	
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b5.add(lblTinhTrang = new JLabel("Tình Trạng"));
		b5.add(Box.createHorizontalStrut(30));
		b5.add(cBoxTinhTrang= new JComboBox<String>());
		cBoxTinhTrang.addItem("Còn");	
		cBoxTinhTrang.addItem("Hết");	
		
		
		
		
	
		
	
		
	
		
	
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b6.add(Box.createHorizontalStrut(80));
		
		
		String[] headers = "ID Phòng;Tên Phòng;Loại Phòng;Giá Phòng;Tình Trạng".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		b6.add(scroll);
//		b.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
		pCenter.add(b);
		add(pCenter, BorderLayout.CENTER);
		
		
		JPanel pSouth = new JPanel();
		pSouth.setBorder(BorderFactory.createTitledBorder("Chọn Tác Vụ"));
		pSouth.add(btnThem = new JButton("Thêm"));
		pSouth.add(btnThoat = new JButton("Thoát"));
		add(pSouth, BorderLayout.SOUTH);
		
		btnThem.addActionListener(this);
		btnThoat.addActionListener(this);
		KHConnect.getInstance().connect();
		updateTableData();
	}
	private void updateTableData() {
		DanhSachPhong ds = new DanhSachPhong();
		List<Phong> list = ds.docTuBang();
		for(Phong s : list) {
			String[] rowData = {s.getMaPhong()+"",s.getName(),s.getType(),s.getPrice()+"",s.getTinhTrang()};
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}

	public static void main(String[] args) {
		FrmThemPhong fm = new FrmThemPhong();
		fm.setVisible(true);
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
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();
		if(a.equals(btnThem)) {
			if(dsp.create(txtTenPhong.getText(), cBoxLoai.getSelectedItem(), Float.parseFloat(txtGiaPhong.getText()),cBoxTinhTrang.getSelectedItem())) {
				Object[] rowData = { txtTenPhong.getText(), cBoxLoai.getSelectedItem(), Float.parseFloat(txtGiaPhong.getText()),cBoxTinhTrang.getSelectedItem()};
				tableModel.addRow(rowData);
				setVisible(false);
				new FrmThemPhong().setVisible(true);
				}
		}
	
		if(a.equals(btnThoat)) {
			setVisible(false);
			new menu().setVisible(true);
		}
		
	}


}

