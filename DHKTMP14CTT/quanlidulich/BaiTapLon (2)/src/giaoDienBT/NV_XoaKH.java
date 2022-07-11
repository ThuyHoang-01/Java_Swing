package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import enTiTy.KhachHang;
import ketNoiSQL.DataBase;
import thucThi.DaoNV_SauDN;
import thucThi.DaoThongTin;

public class NV_XoaKH extends JFrame implements ActionListener{
	public JButton btnThoat, btnXoa;
	public JTable table;
	public DefaultTableModel tableModel;
	DaoNV_SauDN tt = new DaoNV_SauDN();
	public NV_XoaKH() {
		super("Danh sách khách hàng");
		setSize(600, 500);
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
		
		JPanel pSouth= new JPanel();
		pSouth.add(btnXoa = new JButton("Xóa"));
		btnXoa.setBackground(Color.green);
		pSouth.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(Color.green);
		pSouth.setBackground(Color.LIGHT_GRAY);
		add(pSouth,BorderLayout.SOUTH);
		
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		DataBase.getInstance().connect();
		Doc();
	}
	public void Doc() {
		DaoThongTin tt = new DaoThongTin();
		List<KhachHang> ls = tt.DocTB();
		for (KhachHang h : ls) {
			String []row = {h.getID()+"",h.getLastName(), h.getEmail(),h.getPhone(),h.getUser(),h.getPassword()};
			tableModel.addRow(row);
		}
		table.setModel(tableModel);		
	}

	public static void main(String[] args) {
		NV_XoaKH tt= new NV_XoaKH();
		tt.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row != -1) {
				int id = Integer.parseInt((String)table.getValueAt(row, 0));
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này","Chú ý",JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION) {
					if(tt.deleteKH(id)) {
						tableModel.removeRow(row);				
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn Tour muốn xóa!");
			}
		}else if(obj.equals(btnThoat)) {
			setVisible(false);
			new NV_SauDangNhap().setVisible(true);
		}
	}
	


}
