package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.*;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import DatePicker.DateLabelFormatter;
import DoiTuong.CongTrinh;
import QuanLy.QuanLyCongTrinh;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class GiaoDienTimCongTrinh extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtKH;
	private JTextField textField;
	private JTextField textField_1;
	private Properties p;
	private UtilDateModel model1, model2;
	private JDatePanelImpl datePanel1, datePanel2;
	private JDatePickerImpl datePicker1, datePicker2;
	private JComboBox cboDiaDiem;
	private JButton btnTimKiem, btnTroVe;
	private QuanLyCongTrinh qlDiaDiem;
	private JRadioButton rabDaTra, rabChuaTra;

	public GiaoDienTimCongTrinh() {
		setTitle("Tìm Kiếm Công Trình");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 432);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTimKiemCT = new JLabel("Tìm Kiếm Công Trình");
		lblTimKiemCT.setBounds(99, 11, 200, 39);
		lblTimKiemCT.setFont(new Font("Arial", Font.PLAIN, 23));
		contentPane.add(lblTimKiemCT);

		JLabel lblTenCT = new JLabel("Tên Công Trinh:");
		lblTenCT.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTenCT.setBounds(10, 66, 124, 23);
		contentPane.add(lblTenCT);

		JLabel lblDiaDiemCT = new JLabel("Địa Điểm:");
		lblDiaDiemCT.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDiaDiemCT.setBounds(10, 111, 100, 23);
		contentPane.add(lblDiaDiemCT);

		JLabel lblNgayCapPhep = new JLabel("Ngày Cấp Phép:");
		lblNgayCapPhep.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNgayCapPhep.setBounds(10, 161, 134, 23);
		contentPane.add(lblNgayCapPhep);
		
		JLabel lblTuNgay = new JLabel("Từ Ngày:");
		lblTuNgay.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTuNgay.setBounds(75, 203, 69, 23);
		contentPane.add(lblTuNgay);
		
		JLabel lblDenNgay = new JLabel("Đến Ngày:");
		lblDenNgay.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDenNgay.setBounds(65, 249, 69, 23);
		contentPane.add(lblDenNgay);

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTimKiem.setBounds(70, 358, 108, 23);
		contentPane.add(btnTimKiem);

		btnTroVe = new JButton("Trở Về");
		btnTroVe.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTroVe.setBounds(235, 358, 89, 23);
		contentPane.add(btnTroVe);

		txtKH = new JTextField();
		txtKH.setBounds(135, 69, 240, 20);
		contentPane.add(txtKH);
		txtKH.setColumns(10);
		cboDiaDiem = new JComboBox();
		cboDiaDiem.setBounds(135, 113, 237, 22);
		contentPane.add(cboDiaDiem);

		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model1 = new UtilDateModel();
		datePanel1 = new JDatePanelImpl(model1, p);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		datePicker1.setBounds(154, 206, 145, 20);
		contentPane.add(datePicker1);

		model2 = new UtilDateModel();
		datePanel2 = new JDatePanelImpl(model2, p);
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		datePicker2.setBounds(154, 252, 145, 20);
		contentPane.add(datePicker2);

		btnTimKiem.addActionListener(this);
		btnTroVe.addActionListener(this);

		qlDiaDiem = new QuanLyCongTrinh();
		List<CongTrinh> list = qlDiaDiem.docTuBang();
		cboDiaDiem.addItem("---------------------------------------------------");
		for (CongTrinh CongTrinh : list) {
			String[] rowData = {  CongTrinh.getID(), CongTrinh.getTen(), CongTrinh.getDiaDiem(),
					CongTrinh.getNgayCapPhep().toString(), CongTrinh.getNgayKhoiCong().toString(), CongTrinh.getNgayDuKienHT().toString() };
			cboDiaDiem.addItem(CongTrinh.getDiaDiem());
		}
		model2.setValue(Date.valueOf(LocalDate.now()));
		model1.setValue(Date.valueOf(LocalDate.now()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnTroVe)) {
			setVisible(false);
		} else if (o.equals(btnTimKiem)) {
			String tenKH = txtKH.getText();
			String tenDiaDiem = (String) cboDiaDiem.getSelectedItem();
			if (tenDiaDiem.equals("---------------------------------------------------"))
				tenDiaDiem = "";
			Date tuNgay = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() + 1, model1.getDay()));
			Date denNgay = Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth() + 1, model2.getDay()));
//			System.out.println(tenKH+tenDiaDiem+tuNgay+denNgay);
			GiaoDienDanhSachCongTrinh hd = new GiaoDienDanhSachCongTrinh(tenKH, tenDiaDiem, tuNgay, denNgay);
			hd.setVisible(true);
			setVisible(false);

		}
	}
}
