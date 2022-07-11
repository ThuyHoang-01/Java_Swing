package baiTapLon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormThongKeTongSoThuoc extends JFrame implements ActionListener{
	private JLabel  lblTongSoThuoc,lblSoThuocNuocDaBan,lblSoThuocVienDaban,lblSoThuocDaHetHan;
	private JTextField txtTongSoThuoc,txtSoThuocNuocDaBan,txtSoThuocVienDaban,txtSoThuocDaHetHan;
	private JTable tableThongKeDoanhThu;
	private DefaultTableModel tableThongKeDoanhThuModel;
	private JButton btnDong;
	public FormThongKeTongSoThuoc() {
		setTitle("Thông tin thống kê tổng số thuốc");
//		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(800,600);
	
		Box b = Box.createVerticalBox();
		Box b1,b2,b3,b4,b5;
		b.add(Box.createVerticalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		JScrollPane scroll;
		String[] headers = "Tên thuốc;Mã thuốc; Đơn vị; Hạn sử dụng;Nhà cung cấp;Số lượng;Giá".split(";");
		tableThongKeDoanhThuModel = new DefaultTableModel(headers,0);
		b5.add(Box.createHorizontalStrut(20));
		b5.add(scroll = new JScrollPane(tableThongKeDoanhThu = new JTable(tableThongKeDoanhThuModel)
				,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		tableThongKeDoanhThu.setRowHeight(25);
		b5.add(Box.createHorizontalStrut(20));
		
		b.add(Box.createVerticalStrut(10));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblTongSoThuoc =  new JLabel("Tổng số thuốc:"));
		b1.add(txtTongSoThuoc = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
		
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblSoThuocNuocDaBan =  new JLabel("Số thuốc nước đã bán:"));
		b2.add(txtSoThuocNuocDaBan = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblSoThuocVienDaban =  new JLabel("Số thuốc viên đã bán:"));
		b3.add(txtSoThuocVienDaban = new JTextField());
		b3.add(Box.createHorizontalStrut(20));
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblSoThuocDaHetHan =  new JLabel("Số thuốc đã hết hạn:"));
		b4.add(txtSoThuocDaHetHan = new JTextField());
		b4.add(Box.createHorizontalStrut(20));
		
		lblSoThuocDaHetHan.setPreferredSize(lblSoThuocNuocDaBan.getPreferredSize());
		lblSoThuocVienDaban.setPreferredSize(lblSoThuocNuocDaBan.getPreferredSize());
		lblTongSoThuoc.setPreferredSize(lblSoThuocNuocDaBan.getPreferredSize());
		
		txtSoThuocDaHetHan.setEditable(false);
		txtSoThuocNuocDaBan.setEditable(false);
		txtSoThuocVienDaban.setEditable(false);
		txtTongSoThuoc.setEditable(false);
		
		
		
		add(b);
		JPanel pSouth =new JPanel();
		pSouth.add(btnDong = new JButton("Đóng"));
		add(pSouth,BorderLayout.SOUTH);
		btnDong.addActionListener(this);
		
		
		
		
		
	}
	public static void main(String[] args) {
		new FormThongKeTongSoThuoc().setVisible(true);;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnDong)){			
			//FormThongKe formThongKe = new FormThongKe();
			//formThongKe.setVisible(true);
			this.setVisible(false);
			//System.exit(0);
		}
	}
	
}


