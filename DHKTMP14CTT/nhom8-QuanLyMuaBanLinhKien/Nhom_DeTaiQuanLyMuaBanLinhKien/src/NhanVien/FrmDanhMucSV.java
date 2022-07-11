package NhanVien;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmDanhMucSV extends JFrame implements ActionListener{

	private JTable table;
	private DefaultTableModel tablemodule;
	private JButton btnThoat;
	private DanhSachNV dsnv = new DanhSachNV();
	
	public FrmDanhMucSV() {
		super("Danh sách nhân viên");
		setSize(800, 500);
		setLocationRelativeTo(null);
		Box b = Box.createVerticalBox();
		Box b2 = Box.createHorizontalBox();
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		
		String [] headertim ="Mã NV;Tên NV; Tiền lương".split(";");
		tablemodule = new DefaultTableModel(headertim,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tablemodule));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		b2.add(scroll);
		//bt.setBorder(BorderFactory.createEmptyBorder(20, 20,20, 20));
		add(b,BorderLayout.CENTER);
		
		JPanel psouth = new JPanel();
		add(psouth,BorderLayout.SOUTH);
		psouth.add(Box.createHorizontalStrut(400));
		psouth.add(btnThoat = new JButton("Thoát"));
		DataBase.getInstance().connect();
		updateTableData();
		
		btnThoat.addActionListener(this);
	}
	
	private void updateTableData() {
		DanhSachNV ds = new DanhSachNV();
		ArrayList<NhanVien> list = ds.docTuBang();
		for (NhanVien nv : list) {
			String [] rowData = {nv.getMaNV(),nv.getHoTen(),nv.getTienLuong()+""};
			tablemodule.addRow(rowData);
		}
		table.setModel(tablemodule);
		table.setEnabled(false);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			dispose();
		}
		
		
	}
	
	public static void main(String[] args) {
		new FrmDanhMucSV().setVisible(true);
	}
	
}
