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

public class TimPhong extends JFrame implements ActionListener,MouseListener{

	private JTable table;
	private JTextField txtMaKH,txtTenKH,txtCMND,txtQuocTich, txtGioiTinh, txtTuoi, txtSoDienThoai, txtMaPhong, txtTenPhong;
	private JComboBox<String> cBoxQuocTich, cboBoxGioiTinh;
	private JButton btnThem, btnSua, btnTim, btnThoat;
	public static DefaultTableModel tableModel;
	
	public TimPhong() {
		super("Quản Lý Phòng");
		setSize(900,600);
		setLocationRelativeTo(null);
		GiaoDien();
	}
	public void GiaoDien() {
		JLabel lblTitl, lbl1, lbl2;
		JPanel pCenter, pNorth;
		
		pNorth = new JPanel();
		pNorth.add(lbl1 = new JLabel("Tìm Phòng"));
		Font fp = new Font("Time New Roman", Font.BOLD, 30);
		lbl1.setFont(fp);
		add(pNorth, BorderLayout.NORTH);
		
		
		
		pCenter = new JPanel();
		
		Box b = Box.createVerticalBox();
		Box b1,b2,b3,b4,b5, b6, b7, b8, b9, b10, b11;
		
		
		b.add(b8 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b8.add(Box.createHorizontalStrut(80));
		
		
		String[] headers = "ID Phòng;Tên Phòng;Giá Phòng;Loại Phòng;Tình Trạng;".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		b8.add(scroll);
		b.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
		pCenter.add(b);
		add(pCenter, BorderLayout.CENTER);
		
		
		JPanel pSouth = new JPanel();
		pSouth.setBorder(BorderFactory.createTitledBorder("Chọn Tác Vụ"));
		pSouth.add(lbl2 = new JLabel("Nhập Tên Phòng"));
		pSouth.add(txtTenPhong = new JTextField(10));
		pSouth.add(btnTim= new JButton("Tìm"));
		pSouth.add(btnThoat = new JButton("Thoát"));
		add(pSouth, BorderLayout.SOUTH);
		
		btnTim.addActionListener(this);
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
		TimPhong fm = new TimPhong();
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
		if(a.equals(btnTim)) {
			
		}
	
		if(a.equals(btnThoat)) {
			setVisible(false);
			new menu().setVisible(true);
		}
		
	}


}
