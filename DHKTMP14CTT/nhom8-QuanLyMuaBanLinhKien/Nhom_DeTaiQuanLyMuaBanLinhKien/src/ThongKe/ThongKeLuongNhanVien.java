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

public class ThongKeLuongNhanVien extends JFrame implements ActionListener {

	private JLabel lblTienLuong,lblTienThuong,lblTongTienTriTra;
	private JTextField txtTienLuong,txtTienThuong,txtTongTienTriTra;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnThoat;
	
	public ThongKeLuongNhanVien() {
		// TODO Auto-generated constructor stub
		 super("Thống kê lương nhân viên");
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
		String[] headers = "Mã NV;Tên NV;Tiền lương;Tăng ca;Tiền thưởng;Tổng số tiền được nhận".split(";");
		tableModel = new DefaultTableModel(headers,0);
		
		b4.add(Box.createHorizontalStrut(20));
		b4.add(scroll = new JScrollPane(table = new JTable(tableModel)
				,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		table.setRowHeight(25);
		scroll.setPreferredSize(new Dimension(770, 400));
		b4.add(Box.createHorizontalStrut(20));
		
		b.add(Box.createVerticalStrut(10));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblTienLuong =  new JLabel("Tiền lương tri trả:"));
		b1.add(txtTienLuong = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
		
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblTienThuong =  new JLabel("Tiền thưởng tri trả:"));
		b2.add(txtTienThuong = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblTongTienTriTra =  new JLabel("Tổng tiền tri trả cho nhân viên:"));
		b4.add(txtTongTienTriTra = new JTextField());
		b4.add(Box.createHorizontalStrut(20));
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
		new ThongKeLuongNhanVien().setVisible(true);
	}


}
