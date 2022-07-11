package baiTapLon;

//toi
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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




public class FormSuaThuoc extends JFrame implements ActionListener, MouseListener{
	private JLabel lblTen,lblDonVi,lblHanSuDung,lblMa,lblNhaCungCap,lblGia;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnXoaTrang ,btnSua, btnCapNhat;
	private JComboBox<String>combo;
	private DefaultComboBoxModel<String>comboModel;
	private JPanel pnSuaThuoc;
	private JTextField txtTen,txtDonVi,txtHanSuDung,txtMa,txtNhaCungCap,txtGia;

	private DSThuoc dsthuoc = new DSThuoc();
	public  FormSuaThuoc() throws ParseException {
		setTitle("Sửa Thuốc");
		setSize(700,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		pnSuaThuoc = new JPanel(new BorderLayout());
		Box b,b0, b1, b2, b3, b4, b5, b6, b7 ;
		b = Box.createVerticalBox();
		
		b.add(Box.createVerticalStrut(10));
		JLabel lblTieuDe;
		b0 = Box.createHorizontalBox();
		b0.add( lblTieuDe = new JLabel("SỬA THUỐC"));
		lblTieuDe.setFont(new Font("Time New Roman",Font.BOLD,30));
		b.add(b0);
		b.add(Box.createVerticalStrut(10));
		
		
		

		b.add(b4 = Box.createHorizontalBox());
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblMa = new JLabel("Mã Thuốc: "));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtMa = new JTextField());
		txtMa.setEditable(false);
		b4.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		
		
		
		b.add(b1 = Box.createHorizontalBox());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblTen = new JLabel("Tên Thuốc: "));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtTen = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		b.add(b2 = Box.createHorizontalBox());
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblDonVi = new JLabel("Đơn vị: "));
		b2.add(Box.createHorizontalStrut(20));
		String[] data="viên;ml".split(";");
		comboModel = new DefaultComboBoxModel<String>(data);
		b2.add(combo = new JComboBox<String>(comboModel));
		b2.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		b.add(b3 = Box.createHorizontalBox());
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblHanSuDung = new JLabel("Hạn sử dụng: "));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(txtHanSuDung = new JTextField());
		b3.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		
		
		b.add(b5 = Box.createHorizontalBox());
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lblNhaCungCap = new JLabel("Nhà cung cấp: "));
		b5.add(Box.createHorizontalStrut(20));
		b5.add(txtNhaCungCap = new JTextField());
		b5.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		b.add(b6 = Box.createHorizontalBox());
		b6.add(Box.createHorizontalStrut(20));
		b6.add(lblGia = new JLabel("Giá(1Viên/100ml): "));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(txtGia = new JTextField());
		b6.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(20));
		b.add(Box.createVerticalStrut(20));
		
		JScrollPane scroll ;
		String[] headers = "Tên Thuốc;Mã Thuốc;Đơn vị;Hạn sử dụng;Nhà cung cấp;Giá(1Viên/100ml)".split(";");
		tableModel  = new DefaultTableModel(headers,0);
		scroll = new JScrollPane(table = new JTable(tableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setRowHeight(20);
		
		b7 = Box.createHorizontalBox();
		b7.add(Box.createHorizontalStrut(20));
		b7.add(scroll);
		b7.add(Box.createHorizontalStrut(20));
		b.add(b7);
		
		
		lblMa.setPreferredSize(lblGia.getPreferredSize());
		lblTen.setPreferredSize(lblGia.getPreferredSize());
		lblHanSuDung.setPreferredSize(lblGia.getPreferredSize());
		lblNhaCungCap.setPreferredSize(lblGia.getPreferredSize());
		lblGia.setPreferredSize(lblGia.getPreferredSize());
		lblDonVi.setPreferredSize(lblGia.getPreferredSize());

		
		Box b8 = Box.createVerticalBox();
		Box bBtn;
		b8.add(bBtn = Box.createHorizontalBox());
		bBtn.add(Box.createHorizontalStrut(20));
		bBtn.add(btnSua = new JButton("Sửa"));
		bBtn.add(Box.createHorizontalStrut(10));
		
		
		bBtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		bBtn.add(Box.createHorizontalStrut(20));
		
		bBtn.add(btnCapNhat = new JButton("Cập nhật"));
		bBtn.add(Box.createHorizontalStrut(20));
		
		b8.add(Box.createVerticalStrut(10));
		
		b8.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		
		pnSuaThuoc.add(b,BorderLayout.CENTER);
		pnSuaThuoc.add(b8,BorderLayout.SOUTH);
		add(pnSuaThuoc,BorderLayout.CENTER);
		
		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnCapNhat.addActionListener(this);
		table.addMouseListener(this);
		
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
		new FormSuaThuoc().setVisible(true);
	}
	public JPanel getPane() {
		return this.pnSuaThuoc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnSua)) {
			if (dsthuoc.update(txtMa.getText(), txtTen.getText(), 
					comboModel.getElementAt(combo.getSelectedIndex()), txtNhaCungCap.getText(), 
					txtHanSuDung.getText(), Double.parseDouble(txtGia.getText()))) {
				try {
					tableModel.setRowCount(0);
					updateTableData();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (o.equals(btnXoaTrang)) {
			txtMa.setText("");
			txtTen.setText("");
			combo.setSelectedIndex(0);
			txtNhaCungCap.setText("");
			txtHanSuDung.setText("");
			txtGia.setText("");
			txtMa.requestFocus();
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
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMa.setText(table.getValueAt(row, 0).toString());
		txtTen.setText(table.getValueAt(row, 1).toString());
		combo.setSelectedIndex(xuLy(table.getValueAt(row, 2).toString()));
		txtNhaCungCap.setText(table.getValueAt(row, 3).toString());
		txtHanSuDung.setText(table.getValueAt(row, 4).toString());
		txtGia.setText(table.getValueAt(row, 5).toString());
	}
	public int xuLy(String donViThuoc) {
		if (donViThuoc.equals("ml")) {
			return 1;
		}
		return 0;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


