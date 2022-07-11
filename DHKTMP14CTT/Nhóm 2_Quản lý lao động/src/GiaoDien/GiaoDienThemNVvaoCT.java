package GiaoDien;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import QuanLy.QuanLyCTCongTrinh;

import DatePicker.DateLabelFormatter;
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
import java.util.Properties;
import javax.swing.JTextField;
import javax.swing.JButton;
import GiaoDien.GiaoDienPhanCong;

public class GiaoDienThemNVvaoCT extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txttenNhanVien;
	private Properties p;
	private UtilDateModel model1,model2;
	private JDatePanelImpl datePanel1,datePanel2;
	private JDatePickerImpl datePicker1,datePicker2;
	private QuanLyCTCongTrinh qlCTCT;
	private JButton btnhuy;
	private JButton btnthem;
	private String maCT;

	public GiaoDienThemNVvaoCT(String maCT) {
		this.maCT = maCT;
		setTitle("Thêm Nhan Vien");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 310);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblThmNVchHng = new JLabel("Thêm Nhân Viên Vào Công Trình "+maCT);
		lblThmNVchHng.setForeground(Color.BLUE);
		lblThmNVchHng.setFont(new Font("Arial", Font.BOLD, 20));
		lblThmNVchHng.setBounds(10, 11, 400, 52);
		contentPane.add(lblThmNVchHng);

		JLabel lbltenNhanVien = new JLabel("Mã nhân viên:");
		lbltenNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		lbltenNhanVien.setBounds(20, 74, 111, 25);
		contentPane.add(lbltenNhanVien);

		JLabel lblngayBatDau = new JLabel("Ngày bắt đầu:");
		lblngayBatDau.setFont(new Font("Arial", Font.PLAIN, 14));
		lblngayBatDau.setBounds(20, 110, 110, 25);
		contentPane.add(lblngayBatDau);
		JLabel lblNgayKetThuc = new JLabel("Ngày Kết Thúc:");
		lblNgayKetThuc.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNgayKetThuc.setBounds(20, 150, 110, 25);
		contentPane.add(lblNgayKetThuc);
		
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
		
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model2 = new UtilDateModel();
		datePanel2 = new JDatePanelImpl(model2, p);
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		datePicker2.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 14));
		datePicker2.getJFormattedTextField().setBackground(Color.WHITE);
		datePicker2.setBackground(Color.WHITE);
		contentPane.add(datePicker2);
		datePicker2.setBounds(128, 150, 230, 28);

		txttenNhanVien = new JTextField();
		txttenNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		txttenNhanVien.setColumns(10);
		txttenNhanVien.setBackground(Color.WHITE);
		txttenNhanVien.setBounds(131, 75, 230, 24);
		contentPane.add(txttenNhanVien);

		btnhuy = new JButton("Hủy");
		btnhuy.setFont(new Font("Arial", Font.PLAIN, 14));
		btnhuy.setBackground(Color.WHITE);
		btnhuy.setBounds(210, 200, 146, 39);
		contentPane.add(btnhuy);

		btnthem = new JButton("Thêm");
		btnthem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnthem.setBackground(Color.LIGHT_GRAY);
		btnthem.setBounds(30, 200, 146, 39);
		contentPane.add(btnthem);
		
		btnhuy.addActionListener(this);
		btnthem.addActionListener(this);
	}
	
	private boolean kiemTraDinhDang() {
		String maNV = txttenNhanVien.getText();
		Date NgayBatDau = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() +1, model1.getDay()));
		Date NgayKetThuc = Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth() +1, model2.getDay()));
		if (maNV.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tên không được để trống!");
			txttenNhanVien.requestFocus();
			txttenNhanVien.selectAll();
			return false;
		} else if (!maNV.matches("^[N][V]\\d{3}$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên chính xác! NV---");
			txttenNhanVien.requestFocus();
			txttenNhanVien.selectAll();
			return false;
		} else if(NgayBatDau.compareTo(NgayKetThuc)>0) {
			JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc");
			return false;
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob.equals(btnhuy)) {
			setVisible(false);
		} else if (ob.equals(btnthem)) {
			if(kiemTraDinhDang()) {
				Date NgayBatDau = Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth() +1, model1.getDay()));
				Date NgayKetThuc = Date.valueOf(LocalDate.of(model2.getYear(), model2.getMonth() +1, model2.getDay()));
				System.out.println(txttenNhanVien.getText()+maCT+NgayBatDau+NgayKetThuc);
				try {
					qlCTCT = new QuanLyCTCongTrinh();
					qlCTCT.themChiTietCongTrinh(txttenNhanVien.getText(), maCT,(Date) NgayBatDau,(Date) NgayKetThuc); 
				}catch (java.lang.NumberFormatException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(this, "Thêm không thành công");
					//setVisible(false);
				}
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				setVisible(false);
			}
		}

	}
}
