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
import DatePicker.DateLabelFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DatePicker.DateLabelFormatter;
import QuanLy.QuanLyCTCongTrinh;
import DoiTuong.ChiTietCongTrinh;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GiaoDienQuanLyCTCongTrinh extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JPanel panel;
	private JLabel lblthongTinCTCT;
	private JLabel blbIDCongTrinh;
	private JLabel lblIDNhanVien;
	private JPanel panel_1;
	private JButton btnthem;
	private JButton btncapNhat;
	private JButton btnxoaRong;
	private JButton btntroVe;
	private JTextField txtIDCongTrinh;
	private JTextField txtIDNhanVien;
	private JTextField txtngayBD;
	private JTextField txtngayKT;
	private Properties p;
	private UtilDateModel model1, model2;
	private JDatePanelImpl datePanel1, datePanel2;
	private JDatePickerImpl datePicker1, datePicker2;
	private QuanLyCTCongTrinh qlCTCT;

	public GiaoDienQuanLyCTCongTrinh() {
		setTitle("Giao Diện Chi Tiet Cong Trinh");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 400);
		setLocationRelativeTo(null);
		taoGiaoDien();
	}

	public void taoGiaoDien() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] header = "ID Công Trình;ID Nhân Viên;Ngày Bắt Đầu;Ngày Kết Thúc".split(";");
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.addMouseListener(this);
		scrollPane.setBounds(10, 10, 500, 345);
		contentPane.add(scrollPane);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(520, 10, 460, 345);
		contentPane.add(panel);
		panel.setLayout(null);

		lblthongTinCTCT = new JLabel("Thông Tin Chi Tiết Công Trình");
		lblthongTinCTCT.setForeground(Color.BLUE);
		lblthongTinCTCT.setFont(new Font("Arial", Font.BOLD, 19));
		lblthongTinCTCT.setBounds(80, 10, 400, 30);
		panel.add(lblthongTinCTCT);

		blbIDCongTrinh = new JLabel("ID Công trình:");
		blbIDCongTrinh.setFont(new Font("Arial", Font.PLAIN, 14));
		blbIDCongTrinh.setBounds(10, 50, 120, 20);
		panel.add(blbIDCongTrinh);

		lblIDNhanVien = new JLabel("ID Nhân Viên:");
		lblIDNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		lblIDNhanVien.setBounds(10, 80, 120, 20);
		panel.add(lblIDNhanVien);
		
		lblIDNhanVien = new JLabel("Ngày Bắt Đầu:");
		lblIDNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		lblIDNhanVien.setBounds(10, 110, 120, 20);
		panel.add(lblIDNhanVien);
		
		lblIDNhanVien = new JLabel("Ngày Kết Thúc:");
		lblIDNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		lblIDNhanVien.setBounds(10, 150, 120, 20);
		panel.add(lblIDNhanVien);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Thanh Công Cụ", TitledBorder.LEADING, TitledBorder.TOP,

				null, Color.BLUE));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 200, 430, 140);
		panel.add(panel_1);

//		btnthem = new JButton("Thêm");
//		btnthem.setFont(new Font("Arial", Font.PLAIN, 14));
//		btnthem.setBackground(Color.WHITE);
//		btnthem.setBounds(25, 25, 170, 40);
//		panel_1.add(btnthem);

		btncapNhat = new JButton("Cập Nhật");
		btncapNhat.setFont(new Font("Arial", Font.PLAIN, 14));
		btncapNhat.setBackground(Color.WHITE);
		btncapNhat.setBounds(25, 80, 170, 40);
		panel_1.add(btncapNhat);

		btnxoaRong = new JButton("Xóa Rỗng");
		btnxoaRong.setFont(new Font("Arial", Font.PLAIN, 14));
		btnxoaRong.setBackground(Color.WHITE);
		btnxoaRong.setBounds(130, 25, 170, 40);
		panel_1.add(btnxoaRong);

		btntroVe = new JButton("Trở Về");
		btntroVe.setFont(new Font("Arial", Font.PLAIN, 14));
		btntroVe.setBackground(Color.WHITE);
		btntroVe.setBounds(230, 80, 170, 40);
		panel_1.add(btntroVe);

		txtIDCongTrinh = new JTextField();
		txtIDCongTrinh.setEditable(false);
		txtIDCongTrinh.setColumns(10);
		txtIDCongTrinh.setBounds(140, 50, 300, 20);
		panel.add(txtIDCongTrinh);

		txtIDNhanVien = new JTextField();
		txtIDNhanVien.setEditable(false);
		txtIDNhanVien.setColumns(10);
		txtIDNhanVien.setBounds(140, 80, 300, 20);
		panel.add(txtIDNhanVien);
		
//		txtngayBD = new JTextField();
//		txtngayBD.setColumns(10);
//		txtngayBD.setBounds(140, 110, 300, 20);
//		panel.add(txtngayBD);
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model1 = new UtilDateModel();
		datePanel1 = new JDatePanelImpl(model1, p);
		datePicker1 = new JDatePickerImpl(datePanel1,new DateLabelFormatter());
		panel.add(datePicker1);
		datePicker1.setBounds(140, 110, 300, 26);
		
//		txtngayKT = new JTextField();
//		txtngayKT.setColumns(10);
//		txtngayKT.setBounds(140, 140, 300, 20);
//		panel.add(txtngayKT);
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model2 = new UtilDateModel();
		datePanel2 = new JDatePanelImpl(model2, p);
		datePicker2 = new JDatePickerImpl(datePanel2,new DateLabelFormatter());
		panel.add(datePicker2);
		datePicker2.setBounds(140, 150, 300, 26);
		
//		btnthem.addActionListener(this);
		btncapNhat.addActionListener(this);
		btnxoaRong.addActionListener(this);
		btntroVe.addActionListener(this);
		txtIDCongTrinh.setEditable(false);
		capNhatBangDuLieu();
	}

	public void capNhatBangDuLieu() {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}
		qlCTCT = new QuanLyCTCongTrinh();
		List<ChiTietCongTrinh> list = qlCTCT.docTuBang();
		for (ChiTietCongTrinh CTCongTrinh : list) {
			String[] rowData = { CTCongTrinh.getIDCongTrinh(), CTCongTrinh.getIDNhanVien(), CTCongTrinh.getNgayBatDau().toString(), CTCongTrinh.getNgayKetThuc().toString()};
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}

	private boolean kTraDinhDang() {
//		Date ngayCapPhep = (Date) Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth(), model1.getDay()));
//		if (ten.matches("\\s*")) {
//			JOptionPane.showMessageDialog(this, "Tên Quốc Gia không được để trống!");
//			txtIDNhanVien.requestFocus();
//			txtIDNhanVien.selectAll();
//			return false;
//		} else if (!ten.matches("^[\\p{L} ]+$")) {
//			JOptionPane.showMessageDialog(this, "Vui lòng điền tên chính xác!");
//			txtIDNhanVien.requestFocus();
//			txtIDNhanVien.selectAll();
//			return false;
//		}
//		qlCTCT = new QuanLyCTCongTrinh();
//		List<CTCongTrinh> list = qlCTCT.docTuBang();
//		for (CTCongTrinh CTCongTrinh : list) {
//			if(ten.equals(CTCongTrinh.getTenCTCongTrinh())) {
//				JOptionPane.showMessageDialog(this, "Quốc Gia đã có trong hệ thống!");
//				txtIDNhanVien.requestFocus();
//				txtIDNhanVien.selectAll();
//				return false;
//			}
//		}
//		
		return true;
	}

	public void dienThongTin(int row) {
		if (row != -1) {
//			btnthem.setVisible(false);
			String ma = (String) table.getValueAt(row, 1);
			qlCTCT = new QuanLyCTCongTrinh();
			List<ChiTietCongTrinh> list = qlCTCT.docTuBang();
			for (ChiTietCongTrinh CTCongTrinh : list) {
				if (ma.trim().equals(CTCongTrinh.getIDNhanVien().trim())) {
					txtIDCongTrinh.setText(CTCongTrinh.getIDCongTrinh());
					txtIDNhanVien.setText(CTCongTrinh.getIDNhanVien());
					model1.setValue(CTCongTrinh.getNgayBatDau());
					model2.setValue(CTCongTrinh.getNgayKetThuc());
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(table)) {
			dienThongTin(table.getSelectedRow());
			datePicker2.setTextEditable(true);
			datePicker1.setTextEditable(true);
		}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob.equals(btnthem)) {
//			if (kTraDinhDang()) {
//				qlCTCT = new QuanLyCTCongTrinh();
//				String maCTCT = qlCTCT.tuDongLayMa();
//				String tenCTCT = txtIDNhanVien.getText();
//				if (qlCTCT.themTheLoai(maCTCT, tenCTCT)) {
//					capNhatBangDuLieu();
//					JOptionPane.showMessageDialog(this, "Thêm thành công");
//				} else
//					JOptionPane.showMessageDialog(this, "Thêm không thành công");
//			}
		} else if (ob.equals(btncapNhat)) {
			if (kTraDinhDang()) {
				String maCT = txtIDCongTrinh.getText().trim();
				String maNV = txtIDNhanVien.getText();
				Date ngayBatDau = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() +1, model1.getDay()));
				Date ngayKetThuc = Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth() +1, model2.getDay()));
				if (qlCTCT.capNhat(maNV, maCT, ngayBatDau, ngayKetThuc)) {
					capNhatBangDuLieu();
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				} else
					JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
			}
		} else if (ob.equals(btnxoaRong)) {
//			btnthem.setVisible(true);
			txtIDCongTrinh.setText("");
			txtIDNhanVien.setText("");
			model1.setValue(null);
			model2.setValue(null);
			datePicker2.setTextEditable(false);
			datePicker1.setTextEditable(false);
		} else if (ob.equals(btntroVe)) {
			setVisible(false);
		}

	}
}
