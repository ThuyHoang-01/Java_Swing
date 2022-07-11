package GiaoDien;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import QuanLy.QuanLyNhanVien;
import DoiTuong.NhanVien;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JLabel;

public class GiaoDienDanhSachNhanVien extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tablemodelCT;
	private QuanLyNhanVien CT;
	private JButton btnXemChiTiet, btnTimKiem, btnTroVe;
	private String tenNhanVien;
	private String tenPhongBan;

	public GiaoDienDanhSachNhanVien(String tenNhanVien, String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
		this.tenNhanVien = tenNhanVien;
		setTitle("Quản Lý Công Trình");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 953, 594);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] colNameCT = "Mã Nhân Viên;Tên Nhân Viên;Ngày Sinh;CMND;Số Điện Thoại;Email".split(";");
		tablemodelCT = new DefaultTableModel(colNameCT, 0);
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tablemodelCT),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 45, 927, 456);
		contentPane.add(scrollPane);
		capNhatBangDuLieuNhanVien(tenNhanVien, tenPhongBan);

		btnXemChiTiet = new JButton("Xem Chi Tiết");
		btnXemChiTiet.setFont(new Font("Arial", Font.PLAIN, 14));
		btnXemChiTiet.setBounds(149, 512, 151, 23);
		contentPane.add(btnXemChiTiet);
		btnXemChiTiet.addActionListener(this);

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTimKiem.setBounds(423, 512, 107, 23);
		contentPane.add(btnTimKiem);

		JLabel lblDanhSchPhiu = new JLabel("Danh Sách Công Trình");
		lblDanhSchPhiu.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblDanhSchPhiu.setBounds(312, 11, 267, 35);
		contentPane.add(lblDanhSchPhiu);

		btnTroVe = new JButton("Trở Về");
		btnTroVe.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTroVe.setBounds(676, 512, 107, 23);
		contentPane.add(btnTroVe);

		btnTimKiem.addActionListener(this);
		btnTroVe.addActionListener(this);
	}

	private void capNhatBangDuLieuNhanVien(String tenNhanVien, String tenPhongBan) {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tablemodelCT.removeRow(i - 1);
		}
		CT = new QuanLyNhanVien();
		List<NhanVien> list = CT.tim(tenNhanVien,tenPhongBan);
		for (NhanVien Nhanvien : list) {
				String[] rowData = { Nhanvien.getIDNhanVien(), Nhanvien.getHoTen(), Nhanvien.getNgaySinh().toString(),
						Nhanvien.getCMND(), Nhanvien.getSoDT(), Nhanvien.getEmail() };
				tablemodelCT.addRow(rowData);
		}
		table.setModel(tablemodelCT);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnXemChiTiet)) {
			int row = table.getSelectedRow();
			if (row != -1) {
				String maCT = (String) table.getValueAt(row, 0);
				// JOptionPane.showMessageDialog(this, maCT);
//				GiaoDienChiTietPhieuThue ct = new GiaoDienChiTietPhieuThue(maCT,tenPhongBan, tenNhanVien);
//				ct.setVisible(true);
//				setVisible(false);
			}
		} else if (o.equals(btnTimKiem)) {
			GiaoDienTimNhanVien CT = new GiaoDienTimNhanVien();
			CT.setVisible(true);
			setVisible(false);
		} else if (o.equals(btnTroVe)) {
			setVisible(false);
		}
	}
}