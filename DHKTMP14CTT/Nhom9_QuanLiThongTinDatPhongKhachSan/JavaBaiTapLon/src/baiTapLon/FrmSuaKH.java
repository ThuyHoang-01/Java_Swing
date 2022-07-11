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

public class FrmSuaKH extends JFrame implements ActionListener,MouseListener{
	DanhSachKhachHang dsskh = new DanhSachKhachHang();
	private JTable table;
	private JTextField txtMaKH,txtTenKH,txtCMND, txtTuoi, txtSoDienThoai, txtMaPhong;
	private JComboBox<String> cBoxQuocTich, cboBoxGioiTinh;
	private JButton btnThem, btnSua, btnXoa, btnThoat;
	public static DefaultTableModel tableModel;
	
	public FrmSuaKH() {
		super("Quản Lý Khách Hàng");
		setSize(900,600);
		setLocationRelativeTo(null);
		GiaoDien();
	}
	public void GiaoDien() {
		JLabel lblTitl, lbl1;
		JPanel pCenter, pNorth;
		
		pNorth = new JPanel();
		pNorth.add(lbl1 = new JLabel("Chỉnh Sửa Thông Tin Khách Hàng"));
		Font fp = new Font("Time New Roman", Font.BOLD, 30);
		lbl1.setFont(fp);
		add(pNorth, BorderLayout.NORTH);
		
		
		
		pCenter = new JPanel();
		
		Box b = Box.createVerticalBox();
		Box b1,b2,b3,b4,b5, b6, b7, b8, b9, b10, b11;
		JLabel  lblMaKH,lblTenKH,lblCMND,lblQuocTich, lblGioiTinh, lblTuoi, lblSoDienThoai, lblMaPhong;
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaKH = new JLabel("Mã Khách Hàng     "));
		b1.add(txtMaKH = new JTextField(15));
		txtMaKH.setEditable(false);
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTenKH = new JLabel("Tên Khách Hàng     "));
		b2.add(txtTenKH = new JTextField(15));
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblCMND = new JLabel("Chứng Minh Nhân Dân "));
		b3.add(txtCMND = new JTextField(15));
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblQuocTich = new JLabel("Quốc Tịch              "));
		b4.add(Box.createHorizontalStrut(30));
		b4.add(cBoxQuocTich = new JComboBox<String>());
		cBoxQuocTich.addItem("Việt Nam");
		cBoxQuocTich.addItem("Lào");
		cBoxQuocTich.addItem("Campuchia");
		cBoxQuocTich.addItem("...");
		
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b5.add(lblGioiTinh = new JLabel("Giới Tính               "));
		b5.add(Box.createHorizontalStrut(30));
		b5.add(cboBoxGioiTinh= new JComboBox<String>());
		cboBoxGioiTinh.addItem("Nam");	
		cboBoxGioiTinh.addItem("Nữ");	
		
		
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b6.add(lblTuoi = new JLabel("Tuổi     "));
		b6.add(txtTuoi = new JTextField(15));
		
		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b7.add(lblSoDienThoai = new JLabel("Số Điện Thoại     "));
		b7.add(txtSoDienThoai = new JTextField(15));
		
		lblTenKH.setPreferredSize(lblCMND.getPreferredSize());
		lblMaKH.setPreferredSize(lblCMND.getPreferredSize());
//		lblGioiTinh.setPreferredSize(lblCMND.getPreferredSize());
//		lblQuocTich.setPreferredSize(lblCMND.getPreferredSize());
		lblSoDienThoai.setPreferredSize(lblCMND.getPreferredSize());
		lblTuoi.setPreferredSize(lblCMND.getPreferredSize());
		lblTenKH.setPreferredSize(lblCMND.getPreferredSize());
		
	
		
	
		b.add(b8 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b8.add(Box.createHorizontalStrut(80));
		
		
		String[] headers = "Mã KH;Tên KH;CMND;Quốc Tịch;Giới Tính;Tuổi;SDT".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		b8.add(scroll);
//		b.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
		pCenter.add(b);
		add(pCenter, BorderLayout.CENTER);
		
		
		JPanel pSouth = new JPanel();
		pSouth.setBorder(BorderFactory.createTitledBorder("Chọn Tác Vụ"));
		pSouth.add(btnSua = new JButton("Sửa"));
		pSouth.add(btnThoat = new JButton("Thoát"));
		add(pSouth, BorderLayout.SOUTH);
		
		btnSua.addActionListener(this);
		btnThoat.addActionListener(this);
		table.addMouseListener(this);
		KHConnect.getInstance().connect();
		updateTableData();
		
	}
	private void updateTableData() {
		DanhSachKhachHang ds = new DanhSachKhachHang();
		List<KhachHang> list = ds.docTuBang();
		for(KhachHang s : list) {
			String[] rowData = {s.getMaKH()+"", s.getTenKH(), s.getcMND(),s.getqT(),s.getGioiTinh(),s.getTuoi()+"",s.getsDT()};
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}

	public static void main(String[] args) {
		FrmSuaKH fm = new FrmSuaKH();
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
		int r = table.getSelectedRow();
		if(r != -1) {
			txtMaKH.setText(tableModel.getValueAt(r, 0).toString());
			txtTenKH.setText(tableModel.getValueAt(r, 1).toString());
			txtCMND.setText(tableModel.getValueAt(r, 2).toString());
			cBoxQuocTich.setSelectedItem(tableModel.getValueAt(r, 3).toString());
			cboBoxGioiTinh.setSelectedItem(tableModel.getValueAt(r, 4).toString());
			txtTuoi.setText(tableModel.getValueAt(r, 5).toString());
			txtSoDienThoai.setText(tableModel.getValueAt(r, 6).toString());
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();
		if(a.equals(btnSua)) {
			int r = table.getSelectedRow();
			String ma = tableModel.getValueAt(r, 0).toString();
			dsskh.updates(Integer.parseInt(txtMaKH.getText()), txtTenKH.getText(), txtCMND.getText(),cBoxQuocTich.getSelectedItem(), cboBoxGioiTinh.getSelectedItem(),Integer.parseInt(txtTuoi.getText()), txtSoDienThoai.getText());
			updateTable();
		}
	
		if(a.equals(btnThoat)) {
			setVisible(false);
			new menu().setVisible(true);
		}
		
	}
	public void updateTable() {
		int r = table.getSelectedRow();
		table.setValueAt(txtMaKH.getText(), r, 0);
		table.setValueAt(txtTenKH.getText(), r, 1);
		table.setValueAt(txtCMND.getText(), r, 2);
		table.setValueAt(cBoxQuocTich.getSelectedItem(), r, 3);
		table.setValueAt(cboBoxGioiTinh.getSelectedItem(), r, 4);
		table.setValueAt(txtSoDienThoai.getText(), r, 5);
	}

}
