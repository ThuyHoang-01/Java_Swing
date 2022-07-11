package MatHang;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmDanhMucHang extends JFrame implements ActionListener {
	private JTable table;
	private DefaultTableModel tablemodule;
	private JButton btnThoat;
	private ListHang dskh = new ListHang();
	
	public FrmDanhMucHang() {
		// TODO Auto-generated constructor stub
		super("Danh sách mặt hàng");
		setSize(800, 500);
		setLocationRelativeTo(null);
		Box b = Box.createVerticalBox();
		Box b2 = Box.createHorizontalBox();
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		
		String [] headertim ="Mã hàng;Tên hàng;Nhà cung cấp; Giá;Số lượng".split(";");
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
		ListHang ds = new ListHang();
		ArrayList<MatHang> list = ds.docTuBang();
		for (MatHang mh : list) {
			String [] rowData = {mh.getMaH(),mh.getTenH(),mh.getNhaCC(),mh.getGia()+"",mh.getSoLuong()+""};
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
		new FrmDanhMucHang().setVisible(true);
	}

	
	

}