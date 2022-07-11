package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DatePicker.DateLabelFormatter;

//import DatePicker.DateLabelFormatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Properties;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class GiaoDienXemLichLaoDong extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txttenNhanVien;
	private JTextField txtSDT;
	private JTextField txtcmnd;
	private Properties p;
	private UtilDateModel model1, model2;
	private JDatePanelImpl datePanel1, datePanel2;
	private JDatePickerImpl datePicker1, datePicker2;
	private JButton btnTimKiem, btnTroVe;

	public GiaoDienXemLichLaoDong() {
		super("Giao Diện Xem Lịch Lao Động");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 417, 434);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Tên Nhân Viên:");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(10, 77, 124, 23);
		contentPane.add(label);

		txttenNhanVien = new JTextField();
		txttenNhanVien.setColumns(10);
		txttenNhanVien.setBounds(144, 80, 240, 20);
		contentPane.add(txttenNhanVien);

		JLabel lblTimNhanVien = new JLabel("Tìm Kiếm Nhân Viên");
		lblTimNhanVien.setFont(new Font("Arial", Font.PLAIN, 23));
		lblTimNhanVien.setBounds(110, 11, 260, 39);
		lblTimNhanVien.setForeground(Color.BLUE);
		contentPane.add(lblTimNhanVien);

		JLabel lblNgyngK = new JLabel("Ngày Làm:");
		lblNgyngK.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNgyngK.setBounds(10, 213, 124, 23);
		contentPane.add(lblNgyngK);

		JLabel label_2 = new JLabel("Từ Ngày:");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(65, 247, 72, 25);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Đến Ngày:");
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		label_3.setBounds(65, 290, 72, 25);
		contentPane.add(label_3);

		JLabel lblSinThoi = new JLabel("Số Điện Thoại:");
		lblSinThoi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSinThoi.setBounds(10, 122, 124, 23);
		contentPane.add(lblSinThoi);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(144, 125, 240, 20);
		contentPane.add(txtSDT);

		JLabel lblcmndCccd = new JLabel("cmnd / CCCD :");
		lblcmndCccd.setFont(new Font("Arial", Font.PLAIN, 14));
		lblcmndCccd.setBounds(10, 168, 124, 23);
		contentPane.add(lblcmndCccd);

		txtcmnd = new JTextField();
		txtcmnd.setColumns(10);
		txtcmnd.setBounds(144, 171, 240, 20);
		contentPane.add(txtcmnd);

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTimKiem.setBounds(65, 361, 104, 23);
		contentPane.add(btnTimKiem);

		btnTroVe = new JButton("Trở Về");
		btnTroVe.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTroVe.setBounds(236, 361, 89, 23);
		contentPane.add(btnTroVe);

		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model1 = new UtilDateModel();
		datePanel1 = new JDatePanelImpl(model1, p);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		datePicker1.setBounds(154, 250, 171, 28);
		contentPane.add(datePicker1);
		datePicker1.setTextEditable(true);

		model2 = new UtilDateModel();
		datePanel2 = new JDatePanelImpl(model2, p);
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		datePicker2.setBounds(154, 293, 171, 28);
		contentPane.add(datePicker2);
		datePicker2.setTextEditable(true);

		ButtonGroup group = new ButtonGroup();

		btnTimKiem.addActionListener(this);
		btnTroVe.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTroVe)) {
			setVisible(false);
		} else if (o.equals(btnTimKiem)) {
			if(kiemTraDinhDang()) {
				Date tuNgay = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() + 1, model1.getDay()));
				Date denNgay = Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth() + 1, model2.getDay()));
				GiaoDienLichLaoDong tenNhanVien = new GiaoDienLichLaoDong(
						txttenNhanVien.getText(),txtSDT.getText(), txtcmnd.getText(), tuNgay, denNgay);
				tenNhanVien.setVisible(true);
				setVisible(false);				
			}
		}
	}

	private boolean kiemTraDinhDang() {
		String ten = txttenNhanVien.getText();
		String SDT = txtSDT.getText();
		String cmnd = txtcmnd.getText();
		Date tuNgay = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() + 1, model1.getDay()));
		Date denNgay = Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth() + 1, model2.getDay()));
		
		if (!ten.matches("^[\\p{L} ]+$")&&!ten.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên chính xác!");
			txttenNhanVien.requestFocus();
			txttenNhanVien.selectAll();
			return false;
		}else if (!cmnd.matches("[0-9]{9}") && !cmnd.matches("[0-9]{12}")&&!cmnd.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "CCCD phải là số và phải đủ 12 số(cmnd phải là số và phải đủ 9 số) !");
			txtcmnd.requestFocus();
			txtcmnd.selectAll();
			return false;
		} else if (!SDT.matches("[0-9]{10}")&&!SDT.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải là số và phải đủ 10 số!");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}else if(tuNgay.compareTo(denNgay)>0) {
			JOptionPane.showMessageDialog(this, "Từ ngày không được lớn hơn đến ngày");
			return false;
		}			
		return true;
	}
}
