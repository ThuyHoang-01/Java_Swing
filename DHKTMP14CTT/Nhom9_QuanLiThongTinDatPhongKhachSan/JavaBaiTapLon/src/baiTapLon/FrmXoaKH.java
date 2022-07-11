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

public class FrmXoaKH extends JFrame implements ActionListener,MouseListener{
	DanhSachKhachHang dsxkh = new DanhSachKhachHang();
	private JTable table;
	private JTextField txtMaKH,txtTenKH,txtCMND,  txtTuoi, txtSoDienThoai;
	private JComboBox<String> cBoxQuocTich, cboBoxGioiTinh;
	private JButton  btnXoa, btnThoat;
	public static DefaultTableModel tableModel;
	
	public FrmXoaKH() {
		super("Quản Lý Khách Hàng");
		setSize(900,600);
		setLocationRelativeTo(null);
		GiaoDien();
	}
	public void GiaoDien() {
		JLabel lblTitl, lbl1;
		JPanel pCenter, pNorth;
		
		pNorth = new JPanel();
		pNorth.add(lbl1 = new JLabel("Xóa Khách Hàng"));
		Font fp = new Font("Time New Roman", Font.BOLD, 30);
		lbl1.setFont(fp);
		add(pNorth, BorderLayout.NORTH);
		
		
		
		pCenter = new JPanel();
		
		Box b = Box.createVerticalBox();
		Box b1,b2,b3,b4,b5, b6, b7, b8, b9, b10, b11;
		
		
		b.add(b8 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b8.add(Box.createHorizontalStrut(40));
		String[] headers = "Mã KH;Tên KH;CMND;Quốc Tịch;Giới Tính;Tuổi;SDT".split(";");
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
		pSouth.add(btnXoa = new JButton("Xóa"));
		pSouth.add(btnThoat = new JButton("Thoát"));
		add(pSouth, BorderLayout.SOUTH);
		
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
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
		FrmXoaKH fm = new FrmXoaKH();
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
		if(a.equals(btnXoa)) {
			int r = table.getSelectedRow();
			String ma = table.getValueAt(r, 0).toString();
			if(r != -1) {
				int tb = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa dòng này không?","Delete",JOptionPane.YES_NO_OPTION);
				if(tb == JOptionPane.YES_OPTION) {
					if(dsxkh.delete(ma)) {
						tableModel.removeRow(r);
					}
				}
			}else
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
		}
	
	
		if(a.equals(btnThoat)) {
			setVisible(false);
			new menu().setVisible(true);
		}
		
	}

}
