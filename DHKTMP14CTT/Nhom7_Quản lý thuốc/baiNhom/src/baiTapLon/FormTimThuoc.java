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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormTimThuoc extends JFrame implements ActionListener {
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnTim, btnCapNhat;
	private JTextField txtTim;
	
	private DefaultComboBoxModel<String> comboBoxModel;
	private JComboBox<String> comboBox;
	
	private JPanel pnTimThuoc;
	boolean flag = true;
	private DSThuoc dsthuoc = new DSThuoc();
	public FormTimThuoc() throws ParseException {
		setTitle("Tìm Thuốc");
		setSize(700,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		pnTimThuoc = new JPanel(new BorderLayout());
		
		Box b = Box.createVerticalBox();
		Box b0 = Box.createHorizontalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		
		JScrollPane scroll ;
		String[] headers = "Tên Thuốc;Mã Thuốc;Đơn vị;Hạn sử dụng;Nhà cung cấp;Giá(1Viên/100ml)".split(";");
		tableModel  = new DefaultTableModel(headers,0);
		scroll = new JScrollPane(table = new JTable(tableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setRowHeight(20);
		
		
		b.add(Box.createVerticalStrut(20));
		JLabel lblTieuDe;
		
		b0.add( lblTieuDe = new JLabel("TÌM THUỐC"));
		lblTieuDe.setFont(new Font("Time New Roman",Font.BOLD,30));
		b.add(b0);
		
		b.add(Box.createHorizontalStrut(100));
		b.add(Box.createVerticalStrut(20));
		b2.add(Box.createHorizontalStrut(100));
		String[] tenThuoc = {};
		comboBoxModel = new DefaultComboBoxModel<String>(tenThuoc);
		b2.add(comboBox = new JComboBox<String>(comboBoxModel));
		b2.add(btnTim = new JButton("Tìm"));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(btnCapNhat = new JButton("Cập nhật"));
		b2.add(Box.createHorizontalStrut(100));
		b2.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createHorizontalStrut(100));
		
	
		b.add(Box.createVerticalStrut(20));
		b.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(scroll);
		b1.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		b.add(Box.createVerticalStrut(40));
		
		
		

		pnTimThuoc.add(b , BorderLayout.CENTER);
		b2.setBorder(BorderFactory.createTitledBorder("Chọn Thuốc Cần Tìm"));
		add(pnTimThuoc, BorderLayout.CENTER);
		
		btnTim.addActionListener(this);
		btnCapNhat.addActionListener(this);
		Database.getInstance().connec();
		updateTableData();
	}
	private void updateTableData() throws ParseException {
		DSThuoc dsThuoc = new DSThuoc();
		List<Thuoc> list = dsThuoc.doctubang();
		comboBoxModel.removeAllElements();
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
			
			comboBoxModel.addElement(s.getTenThuoc());
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		new FormTimThuoc().setVisible(true);
	}
	public JPanel getPane() {
		return this.pnTimThuoc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o.equals(btnTim)) {
			try {
				
				String tenThuoc = comboBoxModel.getElementAt(comboBox.getSelectedIndex());
				DSThuoc dsThuoc = new DSThuoc();
				dsThuoc.doctubang();
				Thuoc thuoc = dsThuoc.timThuocTenThuoc(tenThuoc);

				if (thuoc == null) {
					JOptionPane.showMessageDialog(this, "Khong tim thay");
					return;
				} else {
					tableModel.setRowCount(0);
					String[] dataRow = {
							thuoc.getMaThuoc(),
							thuoc.getTenThuoc(),
							thuoc.getDonViThuoc(),
							thuoc.getNhaCungCap(),
							thuoc.getHanSuDung(),
							thuoc.getDonGia() + ""
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
