package baiTapLon;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormXoaThuoc extends JFrame implements ActionListener{
	
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnXoa, btnCapNhat;
	private JPanel pnXoaThuoc;
	
	private DSThuoc dsthuoc = new DSThuoc();
	public FormXoaThuoc() throws ParseException{
		setTitle("Xóa Thuốc");
		setSize(700,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		pnXoaThuoc = new JPanel(new BorderLayout());
		
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b0 = Box.createHorizontalBox();
		b.add(Box.createVerticalStrut(20));
		JLabel lblTieuDe;
		
		b0.add( lblTieuDe = new JLabel("XÓA THUỐC"));
		lblTieuDe.setFont(new Font("Time New Roman",Font.BOLD,30));
		b.add(b0);
	
		
		JScrollPane scroll ;
		String[] headers = "Mã Thuốc;Tên Thuốc;Đơn vị;Hạn sử dụng;Nhà cung cấp;Giá(1Viên/100ml)".split(";");
		tableModel  = new DefaultTableModel(headers,0);
		scroll = new JScrollPane(table = new JTable(tableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setRowHeight(20);
		b.add(Box.createVerticalStrut(20));
		b.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(scroll);
		b1.add(Box.createHorizontalStrut(20));
		
		
		
		
		
		Box b2 = Box.createHorizontalBox();
		Box bBtn;
		b2.add(Box.createVerticalStrut(20));
		b2.add(bBtn = Box.createHorizontalBox());
		bBtn.add(Box.createHorizontalStrut(290));
		bBtn.add(btnXoa = new JButton("Xóa"));
		bBtn.add(Box.createHorizontalStrut(10));
		bBtn.add(btnCapNhat = new JButton("Cập nhật"));
		bBtn.add(Box.createHorizontalStrut(290));
		bBtn.setBorder(BorderFactory.createTitledBorder("Chức năng xóa"));
		
		
		b2.add(Box.createVerticalStrut(20));
		
		
		b.add(Box.createHorizontalStrut(20));
		b.add(Box.createHorizontalStrut(20));
		b.add(Box.createHorizontalStrut(100));
		pnXoaThuoc.add(b, BorderLayout.CENTER);
		pnXoaThuoc.add(b2 ,BorderLayout.SOUTH);
		
		add(pnXoaThuoc, BorderLayout.CENTER);
		btnXoa.addActionListener(this);
		btnCapNhat.addActionListener(this);
		Database.getInstance().connec();
		updateTableData();
	}
	private void updateTableData() throws ParseException {
		DSThuoc dsThuoc = new DSThuoc();
		List<Thuoc> list = dsThuoc.doctubang();
		for (Thuoc s : list) {
			String[] rowData = {
					s.getMaThuoc(), 
					s.getTenThuoc(), 
					s.getDonViThuoc(),
					s.getNhaCungCap(),
					s.getHanSuDung(),
					s.getDonGia() + " VND"
					};
			System.out.println(s);
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		new FormXoaThuoc().setVisible(true);

	}
	public JPanel getPane() {
		return this.pnXoaThuoc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if (row >= 0) {
				String maThuoc = (String) table.getValueAt(row, 0);
				if (dsthuoc.delete(maThuoc)) {
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
