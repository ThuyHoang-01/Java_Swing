package baiTapLon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class DatPhong extends JFrame implements ActionListener,MouseListener{
	private DanhSachPhong dssp = new DanhSachPhong();
	private JTable table,table2;
	private JTextField txtMaKH,txtTenKH,txtCMND,txtQuocTich, txtGioiTinh, txtTuoi, txtSoDienThoai, txtMaPhong, txtTenPhong, txtTim;
	private JButton btnThem, btnSua, btnTim, btnQuay, btnDat, btnThanhToan;
	public static DefaultTableModel tableModel,tableModel2;
	private DanhSachPhong dsp = new DanhSachPhong();
	private List<Phong> list;
	
	public DatPhong() {
		super("Quản Lý Phòng");
		setSize(900,600);
		setLocationRelativeTo(null);
		GiaoDien();
	}
	public void GiaoDien() {
		JLabel lblTitl, lbl1, lbl2, lblTim, lbltitle;
		JPanel pCenter, pNorth, pSouth;
		this.dsp=dsp;
		list = dsp.getList();
		
		pNorth = new JPanel();
		pNorth.add(lbl1 = new JLabel("Đặt Phòng"));
		Font fp = new Font("Time New Roman", Font.BOLD, 30);
		lbl1.setFont(fp);
		add(pNorth, BorderLayout.NORTH);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel pLeft, pRight, pto;
		pLeft = new JPanel();
		pRight = new JPanel();
		pCenter = new JPanel();
		pto = new JPanel();
		
		
		Box b = Box.createHorizontalBox();
		Box b1,b2, b3, b4;
		
		
		b.add(b1 = Box.createVerticalBox());
		//b.add(Box.createVerticalStrut(10));
		//b1.add(Box.createHorizontalStrut(80));
		String[] headers = "ID Phòng;Tên Phòng;Loại Phòng;Giá Phòng;Tình Trạng;".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll;
		scroll = new JScrollPane(table = new JTable(tableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		b1.add(scroll);
		b.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
		table.setRowHeight(25);
		
		b1.add(b3 = Box.createHorizontalBox());
		b3.add(lblTim = new JLabel("Nhập Tên Phòng"));
		b3.add(txtTim = new JTextField(10));
		b3.add(btnTim = new JButton("Tìm"));
		
	
				
		b.add(Box.createHorizontalStrut(20));
		
		b.add(b2 = Box.createVerticalBox());
		//b.add(Box.createVerticalStrut(10));
		//b1.add(Box.createHorizontalStrut(80));
		String[] headers2 = "ID Phòng;Tên Phòng;Loại Phòng;Giá Phòng;Tình Trạng;".split(";");
		tableModel2 = new DefaultTableModel(headers2,0);
		JScrollPane scroll2;
		scroll2 = new JScrollPane(table2 = new JTable(tableModel2),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		b2.add(scroll2);
		b.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
		table2.setRowHeight(25);
		b2.add(b4 = Box.createHorizontalBox());
		b4.add(btnThanhToan = new JButton("Thanh Toán"));
		
		
		
		
		add(b,BorderLayout.CENTER);
		
		
		
		pSouth = new JPanel();
		pSouth.setBorder(BorderFactory.createTitledBorder("Nhóm 9"));
		pSouth.add(lbltitle = new JLabel("Trần Cao Tường - Nguyễn Huy Hảo - Bùi Thị Mỹ Duyên"));
		pSouth.add(btnQuay = new JButton("Quay Lại"));
		add(pSouth, BorderLayout.SOUTH);
		
		btnThanhToan.addActionListener(this);

		btnTim.addActionListener(this);
		btnQuay.addActionListener(this);
		KHConnect.getInstance().connect();
		updateTableData();
		duyet();
		
		
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
		DatPhong fm = new DatPhong();
		fm.setVisible(true);
	}
	
//	public void duyet() {
//		for (Phong phong : list) {
//			if(phong.getTinhTrang().equals("Hết")) {
//				phong = list.get(list.indexOf(phong));
//				String[] headers = {
//						phong.getMaPhong()+"",phong.getName(),phong.getType(),phong.getPrice()+"",phong.getTinhTrang()
//				};
//				tableModel2.addRow(headers);
//				
//			}
//		}
//		table2.setModel(tableModel2);
//	}
	public void duyet() {
		DanhSachPhong ds = new DanhSachPhong();
		List<Phong> list = ds.docTuBang();
		int row = 0;
		for(Phong s : list) {
			
			if(s.getTinhTrang().equals("Hết")){
				String[] rowData = {s.getMaPhong()+"",s.getName(),s.getType(),s.getPrice()+"",s.getTinhTrang()};
				tableModel2.addRow(rowData);
				tableModel.removeRow(row);
				row--;
			}		
			row++;
		}
		table2.setModel(tableModel2);
		table.setModel(tableModel);
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
		
		if(a.equals(btnThanhToan)) {
			new HoaDon().setVisible(true);
		}
		if(a.equals(btnDat)) {
					int row = table.getSelectedRow();
					String ma = tableModel.getValueAt(row, 0).toString();
					Phong p = new Phong(Integer.parseInt(ma));
					p = list.get(list.indexOf(p));
					p.setTinhTrang("Hết");
					dssp.updates(Integer.parseInt(ma),
							p.getName(), 
							(Object)p.getType(), p.getPrice(), 
							(Object)p.getTinhTrang());
					updateTableData();
					duyet();
					//updateTable();
		}
	
	
	if(a.equals(btnQuay)) {
			setVisible(false);
			new menu().setVisible(true);
		}
		
		if(a.equals(btnDat)) {
			
		}
		
		if(a.equals(btnTim)) {
			
		}
	}
//	public void updateTable() {
//		int r = table.getSelectedRow();
//		table.setValueAt(txtIDPhong.getText(), r, 0);
//		table.setValueAt(txtTenPhong.getText(), r, 1);
//		table.setValueAt(, r, 2);
//		table.setValueAt(txtGiaPhong.getText(), r, 3);
//		table.setValueAt(cBoxTinhTrang.getSelectedItem(), r, 4);
//		table.setValueAt(cBoxTinhTrang.getSelectedItem(), r, 4);
//	}


}
