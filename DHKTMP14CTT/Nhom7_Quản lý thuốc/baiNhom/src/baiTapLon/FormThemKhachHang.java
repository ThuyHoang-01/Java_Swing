package baiTapLon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormThemKhachHang extends JFrame implements ActionListener{
	private JLabel lblMaKhachHang,lblTenKhachHang,lblNgayDenKhachHang,lblSoDienThoaiKhachHang,
					lblDiaChiKhachHang,lblNguyenNhanBenhKhachHang;
	private JTextField txtMaKhachHang,txtTenKhachHang,txtNgayDenKhachHang,txtSoDienThoaiKhachHang,
						txtDiaChiKhachHang,qtxtNguyenNhanBenhKhachHang;
	private JTextArea txtNguyenNhanBenhKhachHang;
	private JButton btnThem, btnXoaTrang, btnCapNhat;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnXoa;
	private JPanel pen;
	private JPanel pTong;
	
	private DSKhachHang dskh  = new DSKhachHang();
	public FormThemKhachHang() throws ParseException {
		setTitle("Thêm khách hàng");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(700,600);
		
		Box b = Box.createVerticalBox();
		add(b,BorderLayout.CENTER);
		Box b1,b2,b3,b4,b5,b6,b7;
		b.add(Box.createVerticalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblMaKhachHang = new JLabel("Mã khách Hàng:"));
		b2.add(txtMaKhachHang = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
		
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblTenKhachHang = new JLabel("Tên khách hàng:"));
		b1.add(txtTenKhachHang = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblDiaChiKhachHang = new JLabel("Ðịa chỉ:"));
		b3.add(txtDiaChiKhachHang = new JTextField());
		b3.add(Box.createHorizontalStrut(20));
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblNgayDenKhachHang = new JLabel("Ngày đến:"));
		b4.add(txtNgayDenKhachHang = new JTextField());
		b4.add(Box.createHorizontalStrut(20));
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lblSoDienThoaiKhachHang = new JLabel("Số điện thoại"));
		b5.add(txtSoDienThoaiKhachHang = new JTextField());
		b5.add(Box.createHorizontalStrut(20));
		
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(lblNguyenNhanBenhKhachHang = new JLabel("Nguyên nhân bệnh:"));
		b6.add(txtNguyenNhanBenhKhachHang = new JTextArea(3, 3));
		b6.add(Box.createHorizontalStrut(20));
		
		Box b8;
		b.add(Box.createVerticalStrut(10));
		b.add(b8 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b8.add(Box.createHorizontalStrut(20));
		JScrollPane scroll;
		String[] headers = "Mã khách hàng;Tên khách hàng;Ðịa chỉ;Ngày đến;Số điện thoại;Nguyên nhân bệnh".split(";");
		tableModel = new DefaultTableModel(headers,0);
		b8.add(scroll = new JScrollPane(table = new JTable(tableModel)));
//		table.setRowHeight(10);
		b8.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		lblDiaChiKhachHang.setPreferredSize(lblNguyenNhanBenhKhachHang.getPreferredSize());
		lblMaKhachHang.setPreferredSize(lblNguyenNhanBenhKhachHang.getPreferredSize());
		lblNgayDenKhachHang.setPreferredSize(lblNguyenNhanBenhKhachHang.getPreferredSize());
		lblSoDienThoaiKhachHang.setPreferredSize(lblNguyenNhanBenhKhachHang.getPreferredSize());
		lblTenKhachHang.setPreferredSize(lblNguyenNhanBenhKhachHang.getPreferredSize());
		
		
		
		b7 = Box.createHorizontalBox();
		add(b7,BorderLayout.SOUTH);
		b.add(Box.createVerticalStrut(10));
		b7.add(Box.createHorizontalStrut(250));
		b7.add(btnThem = new JButton("Thêm"));
		b7.add(Box.createHorizontalStrut(20));
		b7.add(btnXoaTrang = new JButton("Xóa trắng"));
		b7.add(Box.createHorizontalStrut(20));
		b7.add(btnCapNhat = new JButton("Cập nhật"));
		b7.add(Box.createHorizontalStrut(20));
		b7.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ thêm"));	
		
		pTong = new JPanel(new BorderLayout());
		pTong.add(b,BorderLayout.CENTER);
		pTong.add(b7,BorderLayout.SOUTH);
		
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnCapNhat.addActionListener(this);
		Database.getInstance().connec();
		updateTableData();
	}
	public static void main(String[] args) throws ParseException {
		new FormThemKhachHang();
	}
	public JPanel getPanel() {
		return pTong;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (dskh.create(txtMaKhachHang.getText(), txtTenKhachHang.getText(), 
					txtSoDienThoaiKhachHang.getText(), txtDiaChiKhachHang.getText(), 
					txtNguyenNhanBenhKhachHang.getText(), txtNgayDenKhachHang.getText())) {
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
			txtMaKhachHang.setText("");
			txtTenKhachHang.setText("");
			txtSoDienThoaiKhachHang.setText("");
			txtDiaChiKhachHang.setText("");
			txtNguyenNhanBenhKhachHang.setText("");
			txtNgayDenKhachHang.setText("");
			txtMaKhachHang.requestFocus();
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
	private void updateTableData() throws ParseException {
		DSKhachHang ds = new DSKhachHang();
		List<KhachHangCoKeDon> list = ds.docTuBang();
		for (KhachHangCoKeDon s : list) {
			String[] rowData = {
					s.getMaKhachHang(), 
					s.getTenKhachHang(), 
					s.getDiaChi(),
					s.getNgayDenQuayThuoc(),
					s.getSoDienThoai(),
					s.getNguyenNhanBenh()
					};
			System.out.println(s);
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}

}

