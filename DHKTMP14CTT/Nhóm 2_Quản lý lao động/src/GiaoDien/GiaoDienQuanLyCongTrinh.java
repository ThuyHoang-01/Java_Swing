package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Database.Database;
import DatePicker.DateLabelFormatter;
//import DieuKhien.QuanLyPhongBan;
//import DieuKhien.QuanLyNhaCungCap;
//import DieuKhien.QuanLyCongTrinh;
//import DieuKhien.QuanLyTheLoai;
import DoiTuong.PhongBan;
import DoiTuong.CongTrinh;
//import DoiTuong.NhaCungCap;
//import DoiTuong.CongTrinh;
import QuanLy.QuanLyCongTrinh;
//import DoiTuong.TheLoai;
import QuanLy.QuanLyNhanVien;
import QuanLy.QuanLyPhongBan;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class GiaoDienQuanLyCongTrinh extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JComboBox<String> cbotimKiem;
	private JButton btntimKiem;
	private JButton btnthem;
	private JButton btnxoa;
	private JButton btnthoat, btncapnhat;
	private JPanel panel;
	private JLabel lblThngTinNhn;
	private JLabel lblmaCT;
	private JLabel lbltenCT;
	private JLabel lblDiaDiem;
	private JLabel lblngaySinh;
	private JLabel lblngayLamViec;
	private JTextField txtmaCT;
	private JTextField txttenCT;
	private JTextField txtdiaChi;
	private List<CongTrinh> list;
	private QuanLyCongTrinh qlCT;
	private Properties p;
	private UtilDateModel model1, model2, model3;
	private JDatePanelImpl datePanel1, datePanel2, datePanel3;
	private JDatePickerImpl datePicker1, datePicker2, datePicker3;
	private JRadioButton radNam, radNu, rabLam, rabNghi;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel label;

	public GiaoDienQuanLyCongTrinh() {
		setTitle("Quản lý nhân viên");
		setBounds(100, 100, 1298, 631);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		taoGiaoDien();
		// XuatTT();
	}

	public void taoGiaoDien() {

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);
		getContentPane().add(contentPane);
		contentPane.setLayout(null);

		JScrollPane scroll;
		String[] header = "Mã Công Trình;Tên Công Trình;Địa Điểm;Ngày Cấp Phép;Ngày Dự Kiến;Ngày Khởi Công".split(";");
		tableModel = new DefaultTableModel(header, 0);
		contentPane.add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		table.addMouseListener(this);
		Database.getInstance().connect();

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(696, 13, 575, 571);
		contentPane.add(panel);
		panel.setLayout(null);

		lblThngTinNhn = new JLabel("THÔNG TIN CÔNG TRÌNH");
		lblThngTinNhn.setForeground(Color.BLUE);
		lblThngTinNhn.setFont(new Font("Arial", Font.BOLD, 30));
		lblThngTinNhn.setBounds(151, 13, 400, 49);
		panel.add(lblThngTinNhn);

		lblmaCT = new JLabel("Mã Công Trình: ");
		lblmaCT.setBounds(12, 87, 110, 26);
		panel.add(lblmaCT);

		lbltenCT = new JLabel("Tên Công Trình: ");
		lbltenCT.setBounds(12, 145, 110, 26);
		panel.add(lbltenCT);

		lblDiaDiem = new JLabel("Địa Điểm:");
		lblDiaDiem.setBounds(12, 203, 110, 26);
		panel.add(lblDiaDiem);

		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model1 = new UtilDateModel();
		datePanel1 = new JDatePanelImpl(model1, p);
		datePicker1 = new JDatePickerImpl(datePanel1,new DateLabelFormatter());
		panel.add(datePicker1);
		datePicker1.setTextEditable(true);

		lblngaySinh = new JLabel("Ngày Cấp Phép:");
		lblngaySinh.setBounds(12, 261, 110, 26);
		panel.add(lblngaySinh);

		model2 = new UtilDateModel();
		datePanel2 = new JDatePanelImpl(model2, p);
		datePicker2 = new JDatePickerImpl(datePanel2,new DateLabelFormatter());
		panel.add(datePicker2);
		datePicker2.setTextEditable(true);

		lblngayLamViec = new JLabel("Ngày Khởi Công:");
		lblngayLamViec.setBounds(12, 319, 110, 26);
		panel.add(lblngayLamViec);
		
		model3 = new UtilDateModel();
		datePanel3 = new JDatePanelImpl(model3, p);
		datePicker3 = new JDatePickerImpl(datePanel3,new DateLabelFormatter());
		panel.add(datePicker3);
		datePicker3.setTextEditable(true);

		lblngayLamViec = new JLabel("Ngày Dự Kiến:");
		lblngayLamViec.setBounds(12, 377, 110, 26);
		panel.add(lblngayLamViec);

		txtmaCT = new JTextField();
		txtmaCT.setEditable(false);
		txtmaCT.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtmaCT.setBounds(105, 87, 394, 26);
		panel.add(txtmaCT);
		txtmaCT.setColumns(10);

		txttenCT = new JTextField();
		txttenCT.setColumns(10);
		txttenCT.setBounds(105, 145, 394, 26);
		panel.add(txttenCT);

		txtdiaChi = new JTextField();
		txtdiaChi.setColumns(10);
		txtdiaChi.setBounds(105, 203, 394, 26);
		panel.add(txtdiaChi);

		datePicker1.setBounds(105, 261, 394, 26);
		datePicker2.setBounds(105, 319, 394, 26);
		datePicker3.setBounds(105, 377, 394, 26);

		panel_1 = new JPanel();
		panel_1.setBounds(12, 483, 553, 76);
		panel.add(panel_1);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thanh Công Cụ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);

		btnthoat = new JButton("Trở Về");
		btnthoat.setBounds(447, 26, 96, 26);
		panel_1.add(btnthoat);
		btnthoat.setBackground(Color.WHITE);

		btnxoa = new JButton("Xóa Rỗng");
		btnxoa.setBounds(294, 26, 110, 26);
		panel_1.add(btnxoa);
		btnxoa.setBackground(Color.WHITE);

		btncapnhat = new JButton("Cập Nhật");
		btncapnhat.setBounds(149, 26, 110, 26);
		panel_1.add(btncapnhat);
		btncapnhat.setBackground(Color.WHITE);

		btnthem = new JButton("Thêm");
		btnthem.setBounds(10, 26, 110, 26);
		panel_1.add(btnthem);
		btnthem.setBackground(Color.WHITE);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thanh tìm kiếm",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(12, 512, 674, 72);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		label = new JLabel("Tên Công Trình: ");
		label.setBounds(39, 23, 110, 26);
		panel_2.add(label);

		cbotimKiem = new JComboBox();
		cbotimKiem.setBounds(146, 21, 304, 31);
		panel_2.add(cbotimKiem);
		cbotimKiem.setBackground(Color.WHITE);

		btntimKiem = new JButton("Tìm kiếm");
		btntimKiem.setBounds(520, 23, 119, 26);
		panel_2.add(btntimKiem);
		btntimKiem.setBackground(Color.WHITE);
		btntimKiem.addActionListener(this);
		btnthem.addActionListener(this);
		btncapnhat.addActionListener(this);
		btnxoa.addActionListener(this);
		btnthoat.addActionListener(this);
		scroll.setEnabled(false);
		scroll.setBounds(12, 13, 672, 488);
		capNhatBangDuLieu();
	}


	private void capNhatBangDuLieu() {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}
		cbotimKiem.removeAll();
		qlCT = new QuanLyCongTrinh();
		List<CongTrinh> list = qlCT.docTuBang();
		for (CongTrinh CongTrinh : list) {
			String[] rowData = { CongTrinh.getID(), CongTrinh.getTen(), CongTrinh.getDiaDiem(),
					CongTrinh.getNgayCapPhep().toString(), CongTrinh.getNgayKhoiCong().toString(), CongTrinh.getNgayDuKienHT().toString() };
			tableModel.addRow(rowData);
			cbotimKiem.addItem(CongTrinh.getTen());
		}
		table.setModel(tableModel);
	}

	private void dienThongTin(int row) {
		if (row != -1) {
			btnthem.setVisible(false);
			String ma = (String) table.getValueAt(row, 0);
			List<CongTrinh> list = qlCT.docTuBang();
			for (CongTrinh CT : list) {
				if (ma.trim().equals(CT.getID().trim())) {
					// txtmaCT.setEditable(false);
					txtmaCT.setText(ma);
					txttenCT.setText(CT.getTen());
					txtdiaChi.setText(CT.getDiaDiem());
					model1.setValue(CT.getNgayCapPhep());
					model2.setValue(CT.getNgayKhoiCong());
					model3.setValue(CT.getNgayDuKienHT());
				}
			}
		}
	}

	private void xoaRong() {
		btnthem.setVisible(true);
		txtmaCT.setText("");
		txttenCT.setText("");
		txtdiaChi.setText("");
		model1.setValue(null);
		model2.setValue(null);
		model3.setValue(null);
	}

	private boolean kiemTraDinhDang() {
		String ten = txttenCT.getText();
		String diachi = txtdiaChi.getText();
		Date ngayCapPhep = (Date) Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth(), model1.getDay()));
		Date ngayKhoiCong = (Date) Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth(), model2.getDay()));
		Date ngayDuKienHT = (Date) Date.valueOf(LocalDate.of(model3.getYear(), model3.getMonth(), model3.getDay()));
		if (ten.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tên không được để trống!");
			txttenCT.requestFocus();
			txttenCT.selectAll();
			return false;
		} else if (!ten.matches("^.+$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên chính xác!");
			txttenCT.requestFocus();
			txttenCT.selectAll();
			return false;
		} else if (diachi.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!");
			txtdiaChi.requestFocus();
			txtdiaChi.selectAll();
			return false;
		} else if (!diachi.matches("^[\\w\\s]+$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng địa chỉ!");
			txtdiaChi.requestFocus();
			txtdiaChi.selectAll();
			return false;
		} else if (ngayCapPhep.compareTo(ngayKhoiCong) >= 0) {
			JOptionPane.showMessageDialog(this, "Ngày cấp phép phải nhỏ hơn ngày khởi công");
			return false;
		} else if (ngayKhoiCong.compareTo(ngayDuKienHT) >= 0) {
			JOptionPane.showMessageDialog(this, "Ngày khởi công phải nhỏ hơn ngày hoàn thành");
			return false;
		} 
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(table)) {
			dienThongTin(table.getSelectedRow());
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob.equals(btntimKiem)) {
			dienThongTin(cbotimKiem.getSelectedIndex());

		} else if (ob.equals(btnthem)) {
			if (kiemTraDinhDang()) {
				qlCT = new QuanLyCongTrinh();
				String ma = qlCT.tuDongLayMa();
				String ten = txttenCT.getText();
				String diaDiem = txtdiaChi.getText();
				Date ngayCapPhep = (Date) Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth(), model1.getDay()));
				Date ngayKhoiCong = (Date) Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth(), model2.getDay()));
				Date ngayDuKienHT = (Date) Date.valueOf(LocalDate.of(model3.getYear(), model3.getMonth(), model3.getDay()));
				if(qlCT.themCongTrinh(ma, ten, diaDiem, ngayKhoiCong, ngayCapPhep, ngayDuKienHT)) {
					capNhatBangDuLieu();
					JOptionPane.showMessageDialog(this, "Thêm thành công");
					xoaRong();
				} else
					JOptionPane.showMessageDialog(this, "Thêm không thành công");		
			}
		} else if (ob.equals(btnthoat)) {
			setVisible(false);
		} else if (ob.equals(btncapnhat)) {
			if (kiemTraDinhDang()) {
				String ma = txtmaCT.getText().trim();
				String ten = txttenCT.getText();
				String diaDiem = txtdiaChi.getText();
				Date ngayCapPhep = (Date) Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth(), model1.getDay()));
				Date ngayKhoiCong = (Date) Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth(), model2.getDay()));
				Date ngayDuKienHT = (Date) Date.valueOf(LocalDate.of(model3.getYear(), model3.getMonth(), model3.getDay()));

				int row = table.getSelectedRow();
				if (qlCT.capNhat(ma, ten, diaDiem, ngayCapPhep, ngayKhoiCong, ngayDuKienHT)) {
					int rowCount = table.getRowCount();
					for (int i = rowCount; i > 0; i--) {
						tableModel.removeRow(i - 1);
					}
					capNhatBangDuLieu();
					xoaRong();
					JOptionPane.showMessageDialog(this, "Lưu thành công !");
				} else
					JOptionPane.showMessageDialog(this, "Lưu ko thành công !");
			}

		} else if (ob.equals(btnxoa)) {
			xoaRong();
		}

	}
}
