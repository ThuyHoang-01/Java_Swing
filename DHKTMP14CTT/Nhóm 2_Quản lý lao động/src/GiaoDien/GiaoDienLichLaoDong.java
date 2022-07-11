package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

//import Lich.Lich;
import Database.Database;
//import DatePicker.DateLabelFormatter;
import DoiTuong.NhanVien;
import QuanLy.QuanLyNhanVien;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.SystemColor;

public class GiaoDienLichLaoDong extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private Properties p;
	private UtilDateModel model1, model2;
	private JDatePanelImpl datePanel1, datePanel2;
	private JDatePickerImpl datePicker1, datePicker2;
	private JLabel lblthongKeTuan;
	private JLabel lbltongCong, lblngay, lblt;
	private JButton btninLich, btntroVe, btnthongKe;
	private NhanVien nv;
	private String TenNV;
	private String tentenNhanVien,SDT, cmnd;
	private Date tuNgay,denNgay;

	public GiaoDienLichLaoDong(String tentenNhanVien, String SDT, String cmnd, Date tuNgay, Date denNgay) {
		this.tentenNhanVien = tentenNhanVien;
		this.SDT = SDT;
		this.cmnd = cmnd;
		this.tuNgay = tuNgay;
		this.denNgay = denNgay;
		setTitle("Giao Diện Xem Lich Lao Dong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 705);
		setLocationRelativeTo(null);
//		nv = new QuanLyNhanVien().timKiemTheoCMND(cmnd);
		taoGiaoDien();
	}

	public void taoGiaoDien() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] headers = "Mã Nhân Viên;Tên Nhân Viên;Ngày Bắt Đầu;Ngày Kết Thúc".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.addMouseListener(this);
		scrollPane.setBounds(10, 113, 661, 419);
		contentPane.add(scrollPane);

		JLabel lbltuNgay = new JLabel("Từ Ngày :");
		lbltuNgay.setFont(new Font("Arial", Font.PLAIN, 14));
		lbltuNgay.setBounds(135, 76, 133, 30);
		contentPane.add(lbltuNgay);

		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model1 = new UtilDateModel(Date.valueOf(LocalDate.now()));
		datePanel1 = new JDatePanelImpl(model1, p);
		datePicker1 = new JDatePickerImpl(datePanel1, null);
		datePicker1.getJFormattedTextField().setBackground(Color.WHITE);
		datePicker1.setBackground(Color.WHITE);
		contentPane.add(datePicker1);
		datePicker1.setBounds(236, 76, 119, 28);

		JLabel label = new JLabel("-");
		label.setBounds(365, 84, 23, 13);
		contentPane.add(label);

		model2 = new UtilDateModel(Date.valueOf(LocalDate.now()));
		datePanel2 = new JDatePanelImpl(model2, p);
		datePicker2 = new JDatePickerImpl(datePanel2, null);
		datePicker2.getJFormattedTextField().setBackground(Color.WHITE);
		datePicker2.setBackground(Color.WHITE);
		contentPane.add(datePicker2);
		datePicker2.setBounds(379, 76, 119, 28);

		lblthongKeTuan = new JLabel("XEM LỊCH LAO ĐỘNG");
		lblthongKeTuan.setForeground(Color.BLUE);
		lblthongKeTuan.setHorizontalAlignment(SwingConstants.LEFT);
		lblthongKeTuan.setFont(new Font("Arial", Font.PLAIN, 19));
		lblthongKeTuan.setBounds(231, 10, 233, 36);
		contentPane.add(lblthongKeTuan);

		lbltongCong = new JLabel("Tổng Cộng :");
		lbltongCong.setFont(new Font("Arial", Font.BOLD, 14));
		lbltongCong.setBounds(10, 542, 99, 27);
		contentPane.add(lbltongCong);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Thanh Công Cụ", TitledBorder.LEADING, TitledBorder.TOP,

				null, Color.BLUE));
		panel.setBackground(Color.WHITE);
		panel.setBounds(74, 579, 544, 79);
		contentPane.add(panel);

		btninLich = new JButton("In Lịch");
		btninLich.setFont(new Font("Arial", Font.PLAIN, 14));
		btninLich.setBackground(Color.LIGHT_GRAY);
		btninLich.setBounds(86, 25, 115, 31);
		panel.add(btninLich);

		btntroVe = new JButton("Trở Về");
		btntroVe.setFont(new Font("Arial", Font.PLAIN, 14));
		btntroVe.setBackground(Color.WHITE);
		btntroVe.setBounds(357, 25, 99, 31);
		panel.add(btntroVe);

		btnthongKe = new JButton("Xem Lịch");
		btnthongKe.setFont(new Font("Arial", Font.PLAIN, 14));
		btnthongKe.setBackground(new Color(135, 206, 250));
		btnthongKe.setBounds(529, 72, 99, 31);
		contentPane.add(btnthongKe);

		lblt = new JLabel("");
		lblt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblt.setBounds(112, 542, 99, 27);
		contentPane.add(lblt);

		JLabel lblNgy = new JLabel("Ngày :");
		lblNgy.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNgy.setBounds(529, 0, 64, 27);
		contentPane.add(lblNgy);

		lblngay = new JLabel("\r\n");
		lblngay.setFont(new Font("Arial", Font.PLAIN, 14));
		lblngay.setBounds(572, 0, 99, 27);
		contentPane.add(lblngay);
		LocalDate ngay = LocalDate.now();
		lblngay.setText(ngay + "");
		btninLich.addActionListener(this);
		btntroVe.addActionListener(this);
		btnthongKe.addActionListener(this);
		capNhatBangDuLieu();
	}

	public void capNhatBangDuLieu() {

		int dem = 1;
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}
		try {
			System.out.println(cmnd+"**"+SDT+"***"+tentenNhanVien);
			Date ngayBD = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() + 1, model1.getDay()));
			Date ngayEnd = Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth() + 1, model2.getDay()));
			Connection con = Database.getInstance().getConnection();
			String sql = "SELECT NV.IDNhanVien,HoTenNV,CT.NgayStart,CT.NgayEnd\r\n" + 
					"FROM [dbo].[NhanVien] nv\r\n" + 
					"JOIN [dbo].[ChiTietCongTrinh] CT\r\n" + 
					"ON NV.IDNhanVien = CT.IDNhanVien\r\n" + 
					"WHERE NV.[CMND] LIKE N'"+cmnd+
					"' OR NV.[SDT] LIKE N'"+SDT+
					"' OR NV.[HoTenNV] LIKE N'"+tentenNhanVien+"'";
//					") AND (CT.[NgayStart] >= "+tuNgay+
//						"CT.[NgayEnd] <= "+denNgay+")";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String IDNV = rs.getString(1);
				String HoTen = rs.getString(2);
				Date batDau = rs.getDate(3);
				Date ketThuc = rs.getDate(4);
				String[] rowData = {IDNV,HoTen,batDau.toString(),ketThuc.toString()};
//				System.out.println(IDNV+"***"+HoTen+"***"+batDau+"***"+ketThuc);
				tableModel.addRow(rowData);
			}
			table.setModel(tableModel);
//			tinhTong();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void tinhTong() {
		double t = 0;
		int rowCount = table.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			String tong = (String) table.getValueAt(i, 3);
			Double tien = Double.parseDouble(tong);
			t += tien;
		}
		lblt.setText(t + " VND");

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
		Object o = e.getSource();
		if (o.equals(btnthongKe)) {
			capNhatBangDuLieu();
		} else if (o.equals(btntroVe)) {
			setVisible(false);
		} else if (o.equals(btninLich)) {
			Date ngayBD = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() + 1, model1.getDay()));
			Date ngayKT = Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth() + 1, model2.getDay()));
		}

	}
}
