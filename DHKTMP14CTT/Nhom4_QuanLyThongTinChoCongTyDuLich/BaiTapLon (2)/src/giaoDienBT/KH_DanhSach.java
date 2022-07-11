package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import enTiTy.KhachHang;
import ketNoiSQL.DataBase;

import thucThi.DaoThongTin;

public class KH_DanhSach extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel tableModel;
	public JTable table;
	public JButton btnThoat;
	public KH_DanhSach() {
		super("Danh sách khách hàng");
		setSize(800, 500);
		setLocation(400, 100);
		setResizable(false);
		
		String[] headers = "ID;Họ Tên;Email;Số Điện Thoại;User;Password".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scroll.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
		add(scroll);
	
		
		JPanel pSouth = new JPanel();
		pSouth.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(Color.green);
		add(pSouth,BorderLayout.SOUTH);
		
		btnThoat.addActionListener(this);
		DataBase.getInstance().connect();
		updataTableData();
	}
	private void updataTableData() {
		DaoThongTin tt = new DaoThongTin();
		List<KhachHang> ls = tt.DocTB();
		for (KhachHang h : ls) {
			String []row = {h.getID()+"",h.getLastName(), h.getEmail(),h.getPhone(),h.getUser(),h.getPassword()};
			tableModel.addRow(row);
		}
		table.setModel(tableModel);
		
	}
	public static void main(String[] args) {
		KH_DanhSach tt= new KH_DanhSach();
		tt.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThoat)) {
			this.dispose();
			new Menu().setVisible(true);
		}
		
	}
	


}
