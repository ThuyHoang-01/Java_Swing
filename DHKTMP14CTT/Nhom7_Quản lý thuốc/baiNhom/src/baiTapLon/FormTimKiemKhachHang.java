package baiTapLon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


//import formNhanVien_FileObject.NhanVien;

public class FormTimKiemKhachHang extends JFrame implements ActionListener {
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnTim, btnCapNhat;
	private JTextField txtTim;
	
	private DefaultComboBoxModel<String> comboBoxModel;
	private JComboBox<String> comboBox;
	
	private JPanel pTong;
	public FormTimKiemKhachHang() throws ParseException {
		setTitle("Tìm kiếm khách hàng");
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(700,600);
		
		Box b = Box.createVerticalBox();
		Box b1,b2;
		b.add(Box.createVerticalStrut(10));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(Box.createHorizontalStrut(20));
		JScrollPane scroll;
		String[] headers = "Mã khách hàng;Tên khách hàng;Ðịa chỉ;Ngày đến;Số điện thoại;Nguyên nhân bệnh".split(";");
		tableModel = new DefaultTableModel(headers,0);
		b1.add(scroll = new JScrollPane(table = new JTable(tableModel)
				,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
				,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.CENTER);
		table.setRowHeight(20);
		b1.add(Box.createHorizontalStrut(20));
		
		b.add(Box.createVerticalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		//add(b2,BorderLayout.SOUTH);
		//b.add(Box.createVerticalStrut(20));
		b2.add(Box.createHorizontalStrut(35));
		String[] tenKhachHang = {};
		comboBoxModel = new DefaultComboBoxModel<String>(tenKhachHang);
		b2.add(comboBox = new JComboBox<String>(comboBoxModel));
		b2.add(Box.createHorizontalStrut(1));
		b2.add(btnTim = new JButton("Tìm"));
		//b2.setPreferredSize(new Dimension(300,20));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(btnCapNhat = new JButton("Cập nhật"));
		b2.add(Box.createHorizontalStrut(35));
		b2.setBorder(BorderFactory.createTitledBorder("Chức năng tìm tên khách hàng"));
		add(b);
		
		pTong = new JPanel();
		pTong.add(b,BorderLayout.CENTER);
		btnTim.addActionListener(this);
		btnCapNhat.addActionListener(this);
//		pTong.add(b2,BorderLayout.SOUTH);
		Database.getInstance().connec();
		updateTableData();
	}
//	public static void main(String[] args) {
//		new FormTimKiemKhachHang().setVisible(true);
//	}
	public JPanel getPanel() {
		return pTong;
	}
	private void updateTableData() throws ParseException {
		DSKhachHang ds = new DSKhachHang();
		List<KhachHangCoKeDon> list = ds.docTuBang();
		comboBoxModel.removeAllElements();
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
			comboBoxModel.addElement(s.getTenKhachHang());
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTim)) {
			try {
				String tenKhachHang = comboBoxModel.getElementAt(comboBox.getSelectedIndex());
				DSKhachHang dskh = new DSKhachHang();
				dskh.docTuBang();
				KhachHangCoKeDon kh = dskh.timKhachHangTheoTen(tenKhachHang);

				if (kh == null) {
					JOptionPane.showMessageDialog(this, "Khong tim thay");
					return;
				} else {
					tableModel.setRowCount(0);
					String[] dataRow = {
							kh.getMaKhachHang(),
							kh.getTenKhachHang(),
							kh.getDiaChi(),
							kh.getNgayDenQuayThuoc(),
							kh.getSoDienThoai(),
							kh.getNguyenNhanBenh()
					};
					tableModel.addRow(dataRow);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
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
