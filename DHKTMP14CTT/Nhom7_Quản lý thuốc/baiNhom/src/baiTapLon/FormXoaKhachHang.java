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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FormXoaKhachHang extends JFrame implements ActionListener {
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnXoa, btnCapNhat;
	private JPanel pTong;
	private DSKhachHang dskh = new DSKhachHang();
	public FormXoaKhachHang() throws ParseException {
		setTitle("Xóa");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(700,600);
		
		Box b = Box.createVerticalBox();
		Box b1,b2;b.add(Box.createVerticalStrut(10));
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
		
		
		b2 = Box.createHorizontalBox();
		add(b2,BorderLayout.SOUTH);
		b.add(Box.createVerticalStrut(20));
		b2.add(Box.createHorizontalStrut(300));
		b2.add(btnXoa = new JButton("Xóa"));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(btnCapNhat = new JButton("Cập nhật"));
		b2.add(Box.createHorizontalStrut(20));
		b2.setBorder(BorderFactory.createTitledBorder("Chức năng xóa"));
		
		pTong = new JPanel();
		pTong.add(b,BorderLayout.CENTER);
		pTong.add(b2,BorderLayout.SOUTH);
		
		btnXoa.addActionListener(this);
		btnCapNhat.addActionListener(this);
		Database.getInstance().connec();
		updateTableData();
		
	}
//	public static void main(String[] args) {
//		new FormXoaKhachHang();
//	}
	public JPanel getPanel() {
		return pTong;
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
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if (row >= 0) {
				String maKhachHang = (String) table.getValueAt(row, 0);
				if (dskh.delete(maKhachHang)) {
					tableModel.removeRow(row);
				}
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


