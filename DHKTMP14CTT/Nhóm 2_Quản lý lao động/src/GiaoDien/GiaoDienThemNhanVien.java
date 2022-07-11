package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import QuanLy.QuanLyCTCongTrinh;

import DatePicker.DateLabelFormatter;
import QuanLy.QuanLyNhanVien;
import DoiTuong.NhanVien;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class GiaoDienThemNhanVien extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txttenNhanVien;
	private JTextField txtcmnd;
	private JTextField txtdiaChi;
	private JTextField txtemail;
	private JTextField txtsdt;
	private Properties p;
	private UtilDateModel model1;
	private JDatePanelImpl datePanel1;
	private JDatePickerImpl datePicker1;
	private QuanLyNhanVien qlNV;
	private List<NhanVien> dsNV;
	private JRadioButton radnam, radnu;
	private JButton btnhuy;
	private ButtonGroup group;
	private JButton btnthem;
	private String maNV;

	public GiaoDienThemNhanVien(String maNV) {
		this.maNV = maNV;
		setTitle("Thêm NVách Hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 448);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblThmNVchHng = new JLabel("Thêm Nhân Viên");
		lblThmNVchHng.setForeground(Color.BLUE);
		lblThmNVchHng.setFont(new Font("Arial", Font.BOLD, 30));
		lblThmNVchHng.setBounds(70, 11, 290, 52);
		contentPane.add(lblThmNVchHng);

		JLabel lbltenNhanVien = new JLabel("Tên Nhân Viên:");
		lbltenNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		lbltenNhanVien.setBounds(20, 74, 111, 25);
		contentPane.add(lbltenNhanVien);

		JLabel lblgioiTinh = new JLabel("Giới Tính:");
		lblgioiTinh.setFont(new Font("Arial", Font.PLAIN, 14));
		lblgioiTinh.setBounds(56, 146,100, 25);
		contentPane.add(lblgioiTinh);

		group = new ButtonGroup();
		radnam = new JRadioButton("Nam");
		radnam.setBackground(Color.WHITE);
		radnam.setBounds(150, 148, 65, 25);
		group.add(radnam);
		contentPane.add(radnam);

		radnu = new JRadioButton("Nữ");
		radnu.setBackground(Color.WHITE);
		radnu.setBounds(246, 148, 47, 25);
		group.add(radnu);
		contentPane.add(radnu);

		JLabel lblcmnd = new JLabel("CMND:");
		lblcmnd.setFont(new Font("Arial", Font.PLAIN, 14));
		lblcmnd.setBounds(69, 182, 52, 25);
		contentPane.add(lblcmnd);

		JLabel lblngaySinh = new JLabel("Ngày Sinh:");
		lblngaySinh.setFont(new Font("Arial", Font.PLAIN, 14));
		lblngaySinh.setBounds(50, 110, 71, 25);
		contentPane.add(lblngaySinh);

		JLabel lbldiaChi = new JLabel("Địa Chỉ:");
		lbldiaChi.setFont(new Font("Arial", Font.PLAIN, 14));
		lbldiaChi.setBounds(69, 254, 52, 25);
		contentPane.add(lbldiaChi);

		JLabel lblemail = new JLabel("Email:");
		lblemail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblemail.setBounds(74, 290, 47, 25);
		contentPane.add(lblemail);

		JLabel lblsdt = new JLabel("Số Điện Thoại :");
		lblsdt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblsdt.setBounds(18, 218, 103, 25);
		contentPane.add(lblsdt);

		txttenNhanVien = new JTextField();
		txttenNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		txttenNhanVien.setColumns(10);
		txttenNhanVien.setBackground(Color.WHITE);
		txttenNhanVien.setBounds(131, 75, 230, 24);
		contentPane.add(txttenNhanVien);

		txtcmnd = new JTextField();
		txtcmnd.setFont(new Font("Arial", Font.PLAIN, 14));
		txtcmnd.setColumns(10);
		txtcmnd.setBackground(Color.WHITE);
		txtcmnd.setBounds(131, 180, 230, 24);
		contentPane.add(txtcmnd);

		txtdiaChi = new JTextField();
		txtdiaChi.setFont(new Font("Arial", Font.PLAIN, 14));
		txtdiaChi.setColumns(10);
		txtdiaChi.setBackground(Color.WHITE);
		txtdiaChi.setBounds(131, 255, 230, 24);
		contentPane.add(txtdiaChi);

		txtemail = new JTextField();
		txtemail.setFont(new Font("Arial", Font.PLAIN, 14));
		txtemail.setColumns(10);
		txtemail.setBackground(Color.WHITE);
		txtemail.setBounds(131, 291, 230, 24);
		contentPane.add(txtemail);

		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model1 = new UtilDateModel();
		datePanel1 = new JDatePanelImpl(model1, p);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		datePicker1.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 14));
		datePicker1.getJFormattedTextField().setBackground(Color.WHITE);
		datePicker1.setBackground(Color.WHITE);
		contentPane.add(datePicker1);
		datePicker1.setBounds(128, 110, 230, 28);

		txtsdt = new JTextField();
		txtsdt.setFont(new Font("Arial", Font.PLAIN, 14));
		txtsdt.setColumns(10);
		txtsdt.setBackground(Color.WHITE);
		txtsdt.setBounds(131, 219, 230, 24);
		contentPane.add(txtsdt);

		btnhuy = new JButton("Hủy");
		btnhuy.setFont(new Font("Arial", Font.PLAIN, 14));
		btnhuy.setBackground(Color.WHITE);
		btnhuy.setBounds(213, 343, 146, 39);
		contentPane.add(btnhuy);

		btnthem = new JButton("Thêm");
		btnthem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnthem.setBackground(Color.WHITE);
		btnthem.setBounds(35, 343, 146, 39);
		contentPane.add(btnthem);
		btnhuy.addActionListener(this);
		btnthem.addActionListener(this);

		radnam.setSelected(true);

	}

	private boolean kiemTraDinhDang() {
		String ten = txttenNhanVien.getText();
		int namSinh = model1.getYear();
		String cmnd = txtcmnd.getText();
		String sdt = txtsdt.getText();
		String diachi = txtdiaChi.getText();
		String email = txtemail.getText();
		if (ten.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tên NVông được để trống!");
			txttenNhanVien.requestFocus();
			txttenNhanVien.selectAll();
			return false;
		} else if (!ten.matches("^[\\p{L} ]+$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên chính xác!");
			txttenNhanVien.requestFocus();
			txttenNhanVien.selectAll();
			return false;
		} else if (cmnd.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "cmnd/CMND NVông được để trống!");
			txtcmnd.requestFocus();
			txtcmnd.selectAll();
			return false;
		} else if (!cmnd.matches("[0-9]{9}") && !cmnd.matches("[0-9]{12}")) {
			JOptionPane.showMessageDialog(this, "cmnd phải là số và phải đủ 12 số(CMND phải là số và phải đủ 9 số) !");
			txtcmnd.requestFocus();
			txtcmnd.selectAll();
			return false;
		} else if (sdt.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại NVông được để trống!");
			txtsdt.requestFocus();
			txtsdt.selectAll();
			return false;
		} else if (!sdt.matches("[0-9]{10}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải là số và phải đủ 10 số!");
			txtsdt.requestFocus();
			txtsdt.selectAll();
			return false;
		} else if (diachi.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ NVông được để trống!");
			txtdiaChi.requestFocus();
			txtdiaChi.selectAll();
			return false;
		} else if (!diachi.matches("^[\\p{L}0-9 -/]+$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng địa chỉ!");
			txtdiaChi.requestFocus();
			txtdiaChi.selectAll();
			return false;
		} else if (email.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Email NVông được để trống");
			txtemail.requestFocus();
			txtemail.selectAll();
			return false;
		} else if (!email.matches("^([a-z0-9_])+@([\\da-z])+\\.([a-z\\.]{2,6})$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng Email!");
			txtemail.requestFocus();
			txtemail.selectAll();
			return false;
		} else if (-namSinh + (int) java.time.LocalDateTime.now().getYear() <18) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tuổi trên 18!");
			return false;
		}
		qlNV = new QuanLyNhanVien();
		List<NhanVien> list = qlNV.docTuBang();
		for (NhanVien NhanVien : list) {
			if (sdt.trim().equals(NhanVien.getSoDT().trim())) {
				JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại trong hệ thống !");
				txtsdt.requestFocus();
				txtsdt.selectAll();
				return false;
			}
			if (cmnd.trim().equals(NhanVien.getCMND().trim())) {
				JOptionPane.showMessageDialog(this, "CMND/cmnd đã tồn tại trong hệ thống !");
				txtcmnd.requestFocus();
				txtcmnd.selectAll();
				return false;
			}
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob.equals(btnhuy)) {
			setVisible(false);
		} else if (ob.equals(btnthem)) {
			if (kiemTraDinhDang()) {
				qlNV = new QuanLyNhanVien();
				String ma = qlNV.tuDongLayMa();
				String ten = txttenNhanVien.getText();
				String gioiTinh;
				if (radnam.isSelected())
					gioiTinh = "Nam";
				else
					gioiTinh = "Nữ";
				Date ngaySinh = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() + 1, model1.getDay()));
				Date ngayDK = Date.valueOf(LocalDate.now());
				String cmnd = txtcmnd.getText();
				String diaChi = txtdiaChi.getText();
				String email = txtemail.getText();
				String sdt = txtsdt.getText();

				if (qlNV.themNhanVien(ma, ten, "PB112", gioiTinh, ngaySinh, null, cmnd, sdt, diaChi, email, 0)) {
					JOptionPane.showMessageDialog(this, "Thêm Thành Công!");
					setVisible(false);
				} else
					JOptionPane.showMessageDialog(this, "Thêm không Thành Công!");
			}
		}

	}
}
