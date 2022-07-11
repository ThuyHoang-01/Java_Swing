package GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Font;

import DoiTuong.ChiTietCongTrinh;
import QuanLy.QuanLyCTCongTrinh;

public class GiaoDienPhanCong extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private QuanLyCTCongTrinh qlCTCT;
	private List<ChiTietCongTrinh> list;
	private JTextField txtMaCT;
	private JButton btntimKiem, btnthem, btnThemNVvaoCT;
	private JLabel lblMaCT;
	private JButton btnTroVe;
	private String maNV;

	public GiaoDienPhanCong() {
		this.maNV = maNV;
		setTitle("Giao Diện Phân Công");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1068, 730);
		setLocationRelativeTo(null);
		taoGiaoDien();
	}

	public void taoGiaoDien() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] header = "Mã Công Trình;Mã Nhân Viên;Ngày Bắt Đầu;Ngày Kết Thúc".split(";");
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scrollPane);
		scrollPane.setBounds(12, 68, 1030, 506);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thanh Tìm Kiếm ",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(12, 597, 462, 83);
		contentPane.add(panel);
		panel.setLayout(null);

		lblMaCT = new JLabel("Mã Công Trình:");
		lblMaCT.setBounds(10, 24, 95, 40);
		panel.add(lblMaCT);

		txtMaCT = new JTextField();
		txtMaCT.setBounds(100, 24, 150, 40);
		panel.add(txtMaCT);
		txtMaCT.setColumns(10);
		txtMaCT.setBackground(Color.WHITE);

		btntimKiem = new JButton("Tìm kiếm Mã Công Trình");
		btntimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		btntimKiem.setBounds(255, 24, 200, 40);
		btntimKiem.setBackground(Color.LIGHT_GRAY);
		panel.add(btntimKiem);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Các Thao Tác",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(484, 597, 558, 83);
		contentPane.add(panel_1);

		btnthem = new JButton("Thêm Nhân Viên");
		btnthem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnthem.setBounds(20, 22, 171, 39);
		panel_1.add(btnthem);
		btnthem.setBackground(Color.WHITE);

		btnThemNVvaoCT = new JButton("Thêm Vào Công Trình");
		btnThemNVvaoCT.setFont(new Font("Arial", Font.PLAIN, 14));
		btnThemNVvaoCT.setBounds(200, 22,200, 39);
		panel_1.add(btnThemNVvaoCT);
		btnThemNVvaoCT.setBackground(Color.LIGHT_GRAY);

		btnTroVe = new JButton("Trở Về");
		btnTroVe.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTroVe.setBackground(Color.WHITE);
		btnTroVe.setBounds(407, 22, 129, 39);
		panel_1.add(btnTroVe);

		JLabel lblDanhSchKhch = new JLabel("PHÂN CÔNG NHÂN VIÊN");
		lblDanhSchKhch.setForeground(Color.BLUE);
		lblDanhSchKhch.setFont(new Font("Arial", Font.BOLD, 30));
		lblDanhSchKhch.setBounds(345, 11, 392, 52);
		contentPane.add(lblDanhSchKhch);
		btntimKiem.addActionListener(this);
		btnThemNVvaoCT.addActionListener(this);
		btnthem.addActionListener(this);
		btnTroVe.addActionListener(this);
		capNhatBangDuLieu();
	}

	private void capNhatBangDuLieu() {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}
		qlCTCT = new QuanLyCTCongTrinh();
		List<ChiTietCongTrinh> list = qlCTCT.docTuBang();
		for (ChiTietCongTrinh CTCT : list) {
			String[] rowData = { CTCT.getIDCongTrinh(), CTCT.getIDNhanVien(), CTCT.getNgayBatDau().toString(), CTCT.getNgayKetThuc().toString() };
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}
	public void capNhatTABLE() {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}
		qlCTCT = new QuanLyCTCongTrinh();
		List<ChiTietCongTrinh> list = qlCTCT.docTuBang();
		for (ChiTietCongTrinh CTCongTrinh : list) {
			if(CTCongTrinh.getIDCongTrinh().equals(txtMaCT.getText())) {
				String[] rowData = { CTCongTrinh.getIDCongTrinh(), CTCongTrinh.getIDNhanVien(), CTCongTrinh.getNgayBatDau().toString(), CTCongTrinh.getNgayKetThuc().toString()};
				tableModel.addRow(rowData);				
			}
		}
		table.setModel(tableModel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob.equals(btntimKiem)) {
			if(txtMaCT.getText().matches("^[C][T]\\d{3}$")){
				capNhatTABLE();
				table.selectAll();				
			}else {
				JOptionPane.showMessageDialog(this, "Nhâp đúng dạng CT---");
				txtMaCT.selectAll();
				txtMaCT.requestFocus();
			}
		} else if (ob.equals(btnthem)) {
			GiaoDienThemNhanVien kh = new GiaoDienThemNhanVien(maNV);
			kh.setVisible(true);
		} else if (ob.equals(btnThemNVvaoCT)) {
			if(txtMaCT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Nhâp mã công trình để thêm");
				txtMaCT.requestFocus();
			}else {
				GiaoDienThemNVvaoCT them = new GiaoDienThemNVvaoCT(txtMaCT.getText());
				them.setVisible(true);
				capNhatBangDuLieu();
			}
		} else if (ob.equals(btnTroVe)) {
			setVisible(false);
		}
		
	}
}
