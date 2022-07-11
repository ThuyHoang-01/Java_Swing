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
//toi
public class FormThemThuoc extends JFrame implements ActionListener{
	private JLabel lblTen,lblDonVi,lblHanSuDung,lblMa,lblNhaCungCap,lblGia;
	private JButton btnThem, btnXoaTrang, btnCapNhat;
	private JComboBox<String>combo;
	private DefaultComboBoxModel<String>comboModel;
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JPanel pnThemThuoc;
	private JTextField txtTen,txtDonVi,txtHanSuDung,txtMa,txtNhaCungCap,txtGia;
	
	private DSThuoc dsthuoc = new DSThuoc();
	public FormThemThuoc() throws ParseException {
		setTitle("Thêm Thuốc");
		setSize(700,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//setResizable(false);
		pnThemThuoc = new JPanel(new BorderLayout());
		Box b, b0, b1, b2, b3, b4, b5, b6 ;
		b = Box.createVerticalBox();
		
		b.add(Box.createVerticalStrut(30));
		JLabel lblTieuDe;
		b0 = Box.createHorizontalBox();
		b0.add( lblTieuDe = new JLabel("THÊM THUỐC"));
		lblTieuDe.setFont(new Font("Time New Roman",Font.BOLD,30));
		b.add(b0);
		b.add(Box.createVerticalStrut(30));
		
		
		
		b.add(b4 = Box.createHorizontalBox());
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblMa = new JLabel("Mã Thuốc: "));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtMa = new JTextField());
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
		b.add(Box.createVerticalStrut(10));
		
		lblMa.setPreferredSize(lblGia.getPreferredSize());
		lblTen.setPreferredSize(lblGia.getPreferredSize());
		lblHanSuDung.setPreferredSize(lblGia.getPreferredSize());
		lblNhaCungCap.setPreferredSize(lblGia.getPreferredSize());
		lblGia.setPreferredSize(lblGia.getPreferredSize());
		lblDonVi.setPreferredSize(lblGia.getPreferredSize());
		
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
		
		Box b8 = Box.createVerticalBox();
		Box bBtn;
		b8.add(bBtn = Box.createHorizontalBox());
		bBtn.add(Box.createHorizontalStrut(20));
	
	
		
		bBtn.add(btnThem = new JButton("Thêm"));
		bBtn.add(Box.createHorizontalStrut(5));
		bBtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		bBtn.add(Box.createHorizontalStrut(20));
		bBtn.add(btnCapNhat = new JButton("Cập nhật"));
		bBtn.add(Box.createHorizontalStrut(20));
		b8.add(Box.createVerticalStrut(10));
		b8.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		
		pnThemThuoc.add(b,BorderLayout.CENTER);
		pnThemThuoc.add(b8,BorderLayout.SOUTH);
		
		
		
		add(Box.createVerticalStrut(30), BorderLayout.NORTH);

		add(pnThemThuoc,BorderLayout.CENTER);
		add(Box.createVerticalStrut(20), BorderLayout.SOUTH);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnCapNhat.addActionListener(this);
		Database.getInstance().connec();
		updateTableData();
		
	}
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		new FormThemThuoc().setVisible(true);
	}
	
	public JPanel getPane() {
		return this.pnThemThuoc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (dsthuoc.create(txtMa.getText(), txtTen.getText(), 
					comboModel.getElementAt(combo.getSelectedIndex()), txtNhaCungCap.getText(), 
					txtHanSuDung.getText(), Double.parseDouble(txtGia.getText()))) {
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
}
