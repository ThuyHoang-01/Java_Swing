package baiTapLon;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormTimDonThuoc extends JFrame {
	private JLabel lblMaDonThuoc;
	
	private DefaultComboBoxModel<String> cbBoxModelMaDonThuoc;
	private JComboBox<String> cbBoxMaDonThuoc;
	
	private DefaultTableModel tableModel;
	private JTable table;
	
	private JPanel pnForm;
	
	public FormTimDonThuoc() {
		setTitle("Thêm đơn thuốc");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		Box b, b1, b2;
		b = Box.createVerticalBox();
		
		b.add(Box.createVerticalStrut(20));
		b.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblMaDonThuoc = new JLabel("Chọn mã đơn thuốc: "));
		b1.add(Box.createHorizontalStrut(20));
		String[] maDonThuoc = {"Get value from function"};
		cbBoxModelMaDonThuoc = new DefaultComboBoxModel<String>(maDonThuoc);
		cbBoxMaDonThuoc = new JComboBox<String>(cbBoxModelMaDonThuoc);
		b1.add(cbBoxMaDonThuoc);
		b1.add(Box.createHorizontalStrut(20));
		
		b.add(Box.createVerticalStrut(20));
		b.add(b2 = Box.createHorizontalBox());
		b2.add(Box.createHorizontalStrut(20));
//		b6.add(lblNgayDi = new JLabel("Ngày đi: "));
		String[] headers = {
				"Mã thuốc",
				"Tên thuốc",
				"Số lượng"
		};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table = new JTable(tableModel));
		b2.add(scroll);
		b2.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
//		add(b, BorderLayout.CENTER);
		
		pnForm = new JPanel(new BorderLayout());
		pnForm.add(b, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		new FormTimDonThuoc();
	}
	
	public JPanel getPane() {
		return this.pnForm;
	}
}
