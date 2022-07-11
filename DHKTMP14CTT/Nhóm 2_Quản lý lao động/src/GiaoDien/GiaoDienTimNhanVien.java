package GiaoDien;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import org.jdatepicker.impl.*;

import javax.swing.JLabel;

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
import DoiTuong.NhanVien;
import QuanLy.QuanLyNhanVien;
import DoiTuong.PhongBan;
import QuanLy.QuanLyPhongBan;

import javax.swing.JButton;

public class GiaoDienTimNhanVien extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtKH;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox cboPhongBan;
	private JButton btnTimKiem, btnTroVe;
	private QuanLyNhanVien qlNhanVien;
	private QuanLyPhongBan qlPhongBan;

	public GiaoDienTimNhanVien() {
		setTitle("Tìm Kiếm Nhân Viên");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTimKiemCT = new JLabel("Tìm Nhân Viên");
		lblTimKiemCT.setBounds(99, 11, 200, 39);
		lblTimKiemCT.setFont(new Font("Arial", Font.PLAIN, 23));
		contentPane.add(lblTimKiemCT);

		JLabel lblTenCT = new JLabel("Tên Nhân Viên");
		lblTenCT.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTenCT.setBounds(10, 66, 124, 23);
		contentPane.add(lblTenCT);		

		txtKH = new JTextField();
		txtKH.setBounds(135, 69, 240, 20);
		contentPane.add(txtKH);
		txtKH.setColumns(10);
		
		JLabel lblDiaDiemCT = new JLabel("Phòng Ban:");
		lblDiaDiemCT.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDiaDiemCT.setBounds(10, 111, 100, 23);
		contentPane.add(lblDiaDiemCT);

		cboPhongBan = new JComboBox();
		cboPhongBan.setBounds(135, 113, 237, 22);
		contentPane.add(cboPhongBan);

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTimKiem.setBounds(70, 170, 108, 40);
		contentPane.add(btnTimKiem);

		btnTroVe = new JButton("Trở Về");
		btnTroVe.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTroVe.setBounds(235, 170, 89, 40);
		contentPane.add(btnTroVe);

		btnTimKiem.addActionListener(this);
		btnTroVe.addActionListener(this);

		qlPhongBan = new QuanLyPhongBan();
		List<PhongBan> list = qlPhongBan.docTubang();
		cboPhongBan.addItem("---------------------------------------------------");
		for (PhongBan PhongBan : list) {
			String[] rowData = {  PhongBan.getID(), PhongBan.getTen()};
			cboPhongBan.addItem(PhongBan.getTen());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnTroVe)) {
			setVisible(false);
		} else if (o.equals(btnTimKiem)) {
			String tenNV = txtKH.getText();
			String tenPhongBan = (String) cboPhongBan.getSelectedItem();
			if (tenPhongBan.equals("---------------------------------------------------"))
				tenPhongBan = "";
			GiaoDienDanhSachNhanVien hd = new GiaoDienDanhSachNhanVien(tenNV, tenPhongBan);
			hd.setVisible(true);
			setVisible(false);

		}
	}
}
