package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import QuanLy.QuanLyPhongBan;
//import DieuKhien.QuanLyTheLoai;
import DoiTuong.PhongBan;
//import DoiTuong.TheLoai;

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

public class GiaoDienQuanLyPhongBan extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JPanel panel;
	private JLabel lblthongTinPB;
	private JLabel lblmaPB;
	private JLabel lbltenPB;
	private JPanel panel_1;
	private JButton btnthem;
	private JButton btncapNhat;
	private JButton btnxoaRong;
	private JButton btntroVe;
	private JTextField txtmaPB;
	private JTextField txttenPB;
	private QuanLyPhongBan qlPB;

	public GiaoDienQuanLyPhongBan() {
		setTitle("Giao Diện Quản Lý Quốc Gia");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 748, 373);
		setLocationRelativeTo(null);
		taoGiaoDien();
	}

	public void taoGiaoDien() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] header = "Mã Phòng Ban; Tên Phòng Ban".split(";");
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.addMouseListener(this);
		scrollPane.setBounds(10, 10, 383, 317);
		contentPane.add(scrollPane);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(403, 10, 321, 317);
		contentPane.add(panel);
		panel.setLayout(null);

		lblthongTinPB = new JLabel("Thông Tin Phòng Ban");
		lblthongTinPB.setForeground(Color.BLUE);
		lblthongTinPB.setFont(new Font("Arial", Font.BOLD, 19));
		lblthongTinPB.setBounds(61, 11, 232, 31);
		panel.add(lblthongTinPB);

		lblmaPB = new JLabel("Mã Phòng Ban:");
		lblmaPB.setFont(new Font("Arial", Font.PLAIN, 14));
		lblmaPB.setBounds(10, 51, 121, 31);
		panel.add(lblmaPB);

		lbltenPB = new JLabel("Tên Phòng Ban:");
		lbltenPB.setFont(new Font("Arial", Font.PLAIN, 14));
		lbltenPB.setBounds(10, 111, 121, 31);
		panel.add(lbltenPB);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Thanh Công Cụ", TitledBorder.LEADING, TitledBorder.TOP,

				null, Color.BLUE));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 175, 303, 132);
		panel.add(panel_1);

		btnthem = new JButton("Thêm");
		btnthem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnthem.setBackground(Color.WHITE);
		btnthem.setBounds(24, 25, 99, 31);
		panel_1.add(btnthem);

		btncapNhat = new JButton("Cập Nhật");
		btncapNhat.setFont(new Font("Arial", Font.PLAIN, 14));
		btncapNhat.setBackground(Color.WHITE);
		btncapNhat.setBounds(24, 89, 99, 31);
		panel_1.add(btncapNhat);

		btnxoaRong = new JButton("Xóa Rỗng");
		btnxoaRong.setFont(new Font("Arial", Font.PLAIN, 14));
		btnxoaRong.setBackground(Color.WHITE);
		btnxoaRong.setBounds(179, 25, 99, 31);
		panel_1.add(btnxoaRong);

		btntroVe = new JButton("Trở Về");
		btntroVe.setFont(new Font("Arial", Font.PLAIN, 14));
		btntroVe.setBackground(Color.WHITE);
		btntroVe.setBounds(179, 89, 99, 31);
		panel_1.add(btntroVe);

		txtmaPB = new JTextField();
		txtmaPB.setEditable(false);
		txtmaPB.setColumns(10);
		txtmaPB.setBounds(130, 51, 151, 27);
		panel.add(txtmaPB);

		txttenPB = new JTextField();
		txttenPB.setColumns(10);
		txttenPB.setBounds(130, 119, 151, 27);
		panel.add(txttenPB);
		btnthem.addActionListener(this);
		btncapNhat.addActionListener(this);
		btnxoaRong.addActionListener(this);
		btntroVe.addActionListener(this);
		txtmaPB.setEditable(false);
		capNhatBangDuLieu();
	}

	public void capNhatBangDuLieu() {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}
		qlPB = new QuanLyPhongBan();
		List<PhongBan> list = qlPB.docTubang();
		for (PhongBan PhongBan : list) {
			String[] rowData = { PhongBan.getID(), PhongBan.getTen() };
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}

	private boolean kTraDinhDang() {
		String ten = txttenPB.getText();
		if (ten.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tên Phòng ban không được để trống!");
			txttenPB.requestFocus();
			txttenPB.selectAll();
			return false;
		} else if (!ten.matches("^[\\p{L} ]+$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên chính xác!");
			txttenPB.requestFocus();
			txttenPB.selectAll();
			return false;
		}
		qlPB = new QuanLyPhongBan();
		List<PhongBan> list = qlPB.docTubang();
		for (PhongBan PhongBan : list) {
			if(ten.equals(PhongBan.getTen())) {
				JOptionPane.showMessageDialog(this, "Phòng ban đã có trong hệ thống!");
				txttenPB.requestFocus();
				txttenPB.selectAll();
				return false;
			}
		}
//		
		return true;
	}

	public void dienThongTin(int row) {
		if (row != -1) {
			btnthem.setVisible(false);
			String ma = (String) table.getValueAt(row, 0);
			qlPB = new QuanLyPhongBan();
			List<PhongBan> list = qlPB.docTubang();
			for (PhongBan PhongBan : list) {
				if (ma.trim().equals(PhongBan.getID().trim())) {
					txtmaPB.setText(PhongBan.getID());
					txttenPB.setText(PhongBan.getTen());
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(table)) {
			dienThongTin(table.getSelectedRow());
			txtmaPB.setEditable(false);
			txttenPB.setEditable(true);
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
			System.out.println("Dang them");
			if (kTraDinhDang()) {
				qlPB = new QuanLyPhongBan();
				String maPB = qlPB.tuDongLayMa();
				String tenPB = txttenPB.getText();
				if (qlPB.themPhongBan(maPB, tenPB)) {
					capNhatBangDuLieu();
					JOptionPane.showMessageDialog(this, "Thêm thành công");
				} else
					JOptionPane.showMessageDialog(this, "Thêm không thành công");
			}
		} else if (ob.equals(btncapNhat)) {
			System.out.println("Dang cap nhat");
			if (kTraDinhDang()) {
				System.out.println("Dang kiem tra dinh dang");
				String maPB = txtmaPB.getText().trim();
				String tenPB = txttenPB.getText();
				if (qlPB.capNhatBP(maPB, tenPB)) {
					capNhatBangDuLieu();
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
					txtmaPB.setText("");
					txttenPB.setText("");
				} else
					JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
			}
		} else if (ob.equals(btnxoaRong)) {
			System.out.println("Dang xoa rong");
			btnthem.setVisible(true);
			txtmaPB.setText("");
			txttenPB.setText("");
		} else if (ob.equals(btntroVe)) {
			setVisible(false);
		}

	}
}
