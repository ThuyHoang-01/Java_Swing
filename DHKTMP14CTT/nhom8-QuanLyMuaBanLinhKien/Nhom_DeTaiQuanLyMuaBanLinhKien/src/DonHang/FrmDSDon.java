package DonHang;

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

import MatHang.DataBase;
import MatHang.FrmDanhMucHang;
import MatHang.ListHang;
import MatHang.MatHang;

public class FrmDSDon extends JFrame implements ActionListener{
	private JTable table;
	private DefaultTableModel tablemodule;
	private JButton btnThoat;
	private ListHang listHang = new ListHang();
	
	public FrmDSDon() {
		super("Danh sách các đơn hàng");
		setSize(800, 500);
		setLocationRelativeTo(null);
		Box b = Box.createVerticalBox();
		Box b2 = Box.createHorizontalBox();
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		
		String [] headertim ="Số hoá đơn;Mã khách hàng;Mã nhân viên; Ngày đặt hàng;Ngày chuyển hàng;Nơi nhận".split(";");
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
		btnThoat.addActionListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			dispose();
		}
		
		
	}
	
	public static void main(String[] args) {
		new FrmDSDon().setVisible(true);
	}
}
