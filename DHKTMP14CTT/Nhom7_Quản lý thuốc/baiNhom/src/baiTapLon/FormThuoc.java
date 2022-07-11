package baiTapLon;

import java.awt.BorderLayout;

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

public class FormThuoc extends JFrame {
	private JLabel lblMaThuoc, lblTenThuoc, lblDonViThuoc, lblNhaCungCap, lblDonGia, lblHanSuDung;
	private JTextField txtMaThuoc, txtTenThuoc, txtNhaCungCap, txtDonGia, txtHanSuDung, txtTim;
	private JButton btnThem, btnXoa, btnXoaTrang, btnTim, btnLuu;
	
	private DefaultComboBoxModel<String> comboModel;
	private JComboBox<String> comboBoxDonViThuoc;
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JPanel pnThuoc;
	public FormThuoc() {
		setTitle("Quản lý thuốc");
		setSize(700, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		pnThuoc = new JPanel(new BorderLayout());
		
		Box b, b1, b2, b3, b4, b5, b6, b7;
		b = Box.createVerticalBox();
		
		b.add(Box.createVerticalStrut(20));
		b.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblMaThuoc = new JLabel("Mã Thuốc: "));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtMaThuoc = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		b.add(b2 = Box.createHorizontalBox());
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblTenThuoc = new JLabel("Tên Thuốc: "));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtTenThuoc = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		b.add(b3 = Box.createHorizontalBox());
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblDonViThuoc = new JLabel("Đơn vị Thuôc: "));
		b3.add(Box.createHorizontalStrut(20));
		String[] donViThuoc = {"viên", "ml"};
		comboModel = new DefaultComboBoxModel<String>(donViThuoc);
		b3.add(comboBoxDonViThuoc = new JComboBox<String>(comboModel));
		b3.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		b.add(b4 = Box.createHorizontalBox());
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblNhaCungCap = new JLabel("Nhà cung cấp: "));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtNhaCungCap = new JTextField());
		b4.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		b.add(b5 = Box.createHorizontalBox());
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lblDonGia = new JLabel("Đơn giá: "));
		b5.add(Box.createHorizontalStrut(20));
		b5.add(txtDonGia = new JTextField());
		b5.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		b.add(b6 = Box.createHorizontalBox());
		b6.add(Box.createHorizontalStrut(20));
		b6.add(lblHanSuDung = new JLabel("Hạn sử dụng: "));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(txtHanSuDung = new JTextField());
		b6.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		lblMaThuoc.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblTenThuoc.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblDonViThuoc.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblDonGia.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblHanSuDung.setPreferredSize(lblNhaCungCap.getPreferredSize());
		
		b.add(Box.createVerticalStrut(20));
		b.add(b5 = Box.createHorizontalBox());
		b5.add(Box.createHorizontalStrut(20));
		String[] headers = {
				"Mã thuốc",
				"Tên Thuốc",
				"Đơn vị thuốc",
				"Nhà cung cấp",
				"Đơn giá",
				"Hạn sử dụng"
		};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table = new JTable(tableModel));
		table.setRowHeight(20);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		b5.add(scroll);
		b5.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		Box bWrap = Box.createVerticalBox(), bBot;
		bWrap.add(bBot = Box.createHorizontalBox());
		bBot.add(Box.createHorizontalStrut(20));
		bBot.add(new JLabel("Nhập mã thuốc cần tìm: "));
		bBot.add(txtTim = new JTextField());
		bBot.add(btnTim = new JButton("Tìm"));
		bBot.add(btnThem = new JButton("Thêm"));
		bBot.add(btnXoa = new JButton("Xóa"));
		bBot.add(btnXoaTrang = new JButton("Xóa trắng"));
		bBot.add(btnLuu = new JButton("Lưu"));
		bBot.add(Box.createHorizontalStrut(20));
		bWrap.add(Box.createVerticalStrut(10));
		bBot.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));

		
		pnThuoc.add(b, BorderLayout.CENTER);
		pnThuoc.add(bWrap, BorderLayout.SOUTH);
	}
//	public static void main(String[] args) {
//		new FormThuoc().setVisible(true);
//	}
	public JPanel getPane() {
		return this.pnThuoc;
	}
}
