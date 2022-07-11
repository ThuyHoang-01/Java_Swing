package baiTapLon;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormThemDonThuoc extends JFrame implements ActionListener {
	private JLabel lblMaKhachHang, lblMaDonThuoc, lblThuoc, lblSoLuongThuoc, lblDonViThuoc, lblNgayLapDonThuoc;
	private JTextField txtMaDonThuoc, txtSoluongThuoc, txtNgayLapDonThuoc;
	private JButton btnThem, btnXoaTrang, btnThemDSThuoc, btnCapNhat;
	
	private DefaultComboBoxModel<String> cbBoxModelMaKhachHang, cbBoxModelThuoc, cbBoxModelDonViThuoc;
	private JComboBox<String> cbBoxMaKhachHang, cbBoxThuoc, cbBoxDonViThuoc;
	
	private DefaultTableModel tableModel;
	private JTable table;
	
	private JPanel pnForm;
	
	private QuanLyDonThuoc qldt = new QuanLyDonThuoc();
	public FormThemDonThuoc() throws ParseException {
		setTitle("Thêm đơn thuốc");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		Box b, b1, b2, b3, b4, b5, b6;
		b = Box.createVerticalBox();
		
		b.add(Box.createVerticalStrut(20));
		b.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblMaKhachHang = new JLabel("Chọn tên khách hàng: "));
		b1.add(Box.createHorizontalStrut(20));
		String[] maKhachHang = {};
		cbBoxModelMaKhachHang = new DefaultComboBoxModel<String>(maKhachHang);
		cbBoxMaKhachHang = new JComboBox<String>(cbBoxModelMaKhachHang);
		b1.add(cbBoxMaKhachHang);
		b1.add(Box.createHorizontalStrut(20));
		
		
		b.add(Box.createVerticalStrut(20));
		b.add(b3 = Box.createHorizontalBox());
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblNgayLapDonThuoc = new JLabel("Ngày lập đơn thuốc: "));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(txtNgayLapDonThuoc = new JTextField());
		b3.add(Box.createHorizontalStrut(20));
		
		b.add(Box.createVerticalStrut(20));
		b.add(b4 = Box.createHorizontalBox());
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblThuoc = new JLabel("Chọn thuốc: "));
		b4.add(Box.createHorizontalStrut(20));
		String[] tenThuoc = {};
		cbBoxModelThuoc = new DefaultComboBoxModel<String>(tenThuoc);
		cbBoxThuoc = new JComboBox<String>(cbBoxModelThuoc);
		b4.add(cbBoxThuoc);
		b4.add(Box.createHorizontalStrut(10));
		String[] donViThuoc = {"Viên", "ml"};
		cbBoxModelDonViThuoc = new DefaultComboBoxModel<String>(donViThuoc);
		b4.add(Box.createHorizontalStrut(10));
		cbBoxDonViThuoc = new JComboBox<String>(cbBoxModelDonViThuoc);
		b4.add(lblDonViThuoc = new JLabel("Đơn vị thuốc: "));
		b4.add(cbBoxDonViThuoc);
		b4.add(Box.createHorizontalStrut(20));
		
		b.add(Box.createVerticalStrut(20));
		b.add(b5 = Box.createHorizontalBox());
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lblSoLuongThuoc = new JLabel("Số lượng đơn thuốc: "));
		b5.add(Box.createHorizontalStrut(20));
		b5.add(txtSoluongThuoc = new JTextField());
		b5.add(Box.createHorizontalStrut(20));
		b5.add(btnThemDSThuoc = new JButton("Thêm thuốc vào đơn"));
		b5.add(Box.createHorizontalStrut(20));
		
		lblNgayLapDonThuoc.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblThuoc.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblSoLuongThuoc.setPreferredSize(lblMaKhachHang.getPreferredSize());
		
		b.add(Box.createVerticalStrut(20));
		b.add(b6 = Box.createHorizontalBox());
		b6.add(Box.createHorizontalStrut(20));
//		b6.add(lblNgayDi = new JLabel("Ngày đi: "));
		String[] headers = {
				"Tên khách hàng",
				"Tên thuốc",
				"Số lượng(Viên|ml)",
				"Ngày lập đơn thuốc"
		};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table = new JTable(tableModel));
		b6.add(scroll);
		b6.add(Box.createHorizontalStrut(20));
		
		
		Box bWrap = Box.createVerticalBox(), bBot;
		bWrap.add(Box.createVerticalStrut(20));
		bWrap.add(bBot = Box.createHorizontalBox());
		bBot.add(btnXoaTrang = new JButton("Xóa trắng"));
		bBot.add(Box.createHorizontalStrut(20));
		bBot.add(btnCapNhat = new JButton("Cập nhật"));
		bWrap.add(Box.createVerticalStrut(20));
		bWrap.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		
//		add(b, BorderLayout.CENTER);
//		add(bWrap, BorderLayout.SOUTH);
		pnForm = new JPanel(new BorderLayout());
		pnForm.add(b, BorderLayout.CENTER);
		pnForm.add(bWrap, BorderLayout.SOUTH);
		btnXoaTrang.addActionListener(this);
		btnThemDSThuoc.addActionListener(this);
		btnCapNhat.addActionListener(this);
		
		Database.getInstance().connec();
		updateTableData();
	}
	
	private void updateTableData() throws ParseException {
		QuanLyDonThuoc qldt = new QuanLyDonThuoc();
		List<DonThuoc> list = qldt.docTuBang();
		
		DSKhachHang dskh = new DSKhachHang();
		List<KhachHangCoKeDon> listKH = dskh.docTuBang();
		
		DSThuoc dsThuoc = new DSThuoc();
		List<Thuoc> listThuoc = dsThuoc.doctubang();
		
		for (DonThuoc s : list) {
			String[] rowData = {
					dskh.timKhachHang(s.getMaKhachHang()).getTenKhachHang(), 
					dsThuoc.timThuoc(s.getMaThuoc()).getTenThuoc(), 
					s.getSoLuong() + "",
					s.getNgayLapDonThuoc(),
					};
			System.out.println(s);
			tableModel.addRow(rowData);
		}
		cbBoxModelMaKhachHang.removeAllElements();
		cbBoxModelThuoc.removeAllElements();
		for (KhachHangCoKeDon kh : listKH) {
			cbBoxModelMaKhachHang.addElement(kh.getTenKhachHang());
		}
		

		for (Thuoc thuoc : listThuoc) {
			cbBoxModelThuoc.addElement(thuoc.getTenThuoc());
		}
		table.setModel(tableModel);
	}
	
	public static void main(String[] args) throws ParseException {
		new FormThemDonThuoc();
	}
	
	public JPanel getPane() {
		return this.pnForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		DSKhachHang dskh = new DSKhachHang();
		DSThuoc dsthuoc = new DSThuoc();
		try {
			dskh.docTuBang();
			dsthuoc.doctubang();
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		if (o.equals(btnThemDSThuoc)) {
			if (qldt.create(
					dskh.timKhachHangTheoTen(cbBoxModelMaKhachHang.getElementAt(cbBoxMaKhachHang.getSelectedIndex())).getMaKhachHang(), 
					dsthuoc.timThuocTenThuoc(cbBoxModelThuoc.getElementAt(cbBoxThuoc.getSelectedIndex())).getMaThuoc(), 
					txtSoluongThuoc.getText(), txtNgayLapDonThuoc.getText())) {
				try {
					tableModel.setRowCount(0);
					updateTableData();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, "Thêm thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Lỗi nhập liệu");
			}
		} else if (o.equals(btnXoaTrang)) {
			cbBoxMaKhachHang.setSelectedIndex(0);
			cbBoxThuoc.setSelectedIndex(0);
			txtSoluongThuoc.setText("");
			txtNgayLapDonThuoc.setText("");
		} else if (o.equals(btnCapNhat)) {
			tableModel.setRowCount(0);
			try {
				updateTableData();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
