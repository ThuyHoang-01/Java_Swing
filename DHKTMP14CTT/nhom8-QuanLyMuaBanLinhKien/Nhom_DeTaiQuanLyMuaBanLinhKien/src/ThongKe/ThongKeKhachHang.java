package ThongKe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ThongKeKhachHang extends JFrame implements ActionListener{
	private JLabel lblTongKhachMuaHang,lblTongSoKHMoi;
	private JTextField txtTongKhachMuaHang,txtTongKHMoi;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnThoat;
	
	 public ThongKeKhachHang() {
	
		// TODO Auto-generated constructor stub
		 super("Thống kê khách hàng");
		 setSize(900,600);
		 setResizable(false);
		 //setDefaultCloseOperation(EXIT_ON_CLOSE);
		 control();
	}
	
	private void control() {
		// TODO Auto-generated method stub
		
		Box b = Box.createVerticalBox();
		Box b1,b2,b3,b4;
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		JScrollPane scroll;
		String[] headers = "Mã KH;Tên KH;Địa chỉ;Tổng SL hóa đơn;".split(";");
		tableModel = new DefaultTableModel(headers,0);
		
		b4.add(Box.createHorizontalStrut(20));
		b4.add(scroll = new JScrollPane(table = new JTable(tableModel)
				,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		table.setRowHeight(25);
		scroll.setPreferredSize(new Dimension(700, 400));
		b4.add(Box.createHorizontalStrut(20));
		
		b.add(Box.createVerticalStrut(10));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblTongKhachMuaHang =  new JLabel("Tổng khách mua hàng:"));
		b1.add(txtTongKhachMuaHang = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
		
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblTongSoKHMoi =  new JLabel("Tổng số KH mới:"));
		b2.add(txtTongKHMoi = new JTextField());
		b2.add(Box.createHorizontalStrut(20));

		add(b);
		 
		 JPanel psouth = new JPanel();
		 add(psouth,BorderLayout.SOUTH);
		 psouth.add(Box.createHorizontalStrut(400));
		 psouth.add(btnThoat = new JButton("Thoát"));
		 
		 btnThoat.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			dispose();
		}
	}
	public static void main(String[] args) {
		new ThongKeKhachHang().setVisible(true);
	}

}