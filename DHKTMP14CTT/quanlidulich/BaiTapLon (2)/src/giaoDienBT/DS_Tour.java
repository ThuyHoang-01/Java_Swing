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

import enTiTy.CarriageTrip;
import enTiTy.KhachHang;
import ketNoiSQL.DataBase;
import thucThi.DaoNV_SauDN;
import thucThi.DaoThongTin;

public class DS_Tour extends JFrame implements ActionListener{
	DefaultTableModel tableModel;
	public JTable table;
	public JButton btnThoat;
	public DS_Tour() {
		super("Danh sách Tour");
		setSize(800, 500);
		setLocation(400, 100);
		setResizable(false);
		
		String[] headers = "Mã Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá".split(";");
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
		
		DataBase.getInstance().connect();
		updataTableData();
	}
	private void updataTableData() {
		DaoNV_SauDN nv = new DaoNV_SauDN();
		List<CarriageTrip> ls = nv.docTT();
		for(CarriageTrip c : ls) {
			String []data = {c.getId()+"",c.getName(), c.getCompayid()+"", c.getNgayBatDau().toString(), c.getNgayKetThuc().toString()
					,c.getPlace(), c.getAddress(), c.getDonGia()+""};
			tableModel.addRow(data);
		}
		table.setModel(tableModel);
		
	}
	public static void main(String[] args) {
		DS_Tour tt= new DS_Tour();
		tt.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThoat)) {
			setVisible(false);
			
		}
		
	}
	


}
