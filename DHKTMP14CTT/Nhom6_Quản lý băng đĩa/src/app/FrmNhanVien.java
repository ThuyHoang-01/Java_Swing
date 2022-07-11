package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmNhanVien extends JFrame implements ActionListener, MouseListener {

	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtSDT;
	private JTextField txtMoTa;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnBack;
	private JTable table;
	private JTextField txtMess;
	private JButton btnXoaRong;

	private Database database;

	public static DefaultTableModel tableModel;

	public FrmNhanVien() {
		setTitle("Quản lý nhân viên");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
		database.loadDataBaseNV();
	}

	private void buildUI() {
		JPanel pNorth;
		add(pNorth = new JPanel(), BorderLayout.NORTH);
		pNorth.setPreferredSize(new Dimension(0, 180));
		pNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pNorth.setLayout(null);

		JLabel lblMaNV, lblTenNV, lblSDT, lblMoTa;
		pNorth.add(lblMaNV = new JLabel("Mã nhân viên: "));
		pNorth.add(lblTenNV = new JLabel("Tên tên nhân viên: "));
		pNorth.add(lblSDT = new JLabel("Số điện thoại: "));
		pNorth.add(lblMoTa = new JLabel("Mô tả: "));
		
		pNorth.add(txtMaNV = new JTextField());
		pNorth.add(txtTenNV = new JTextField());
		pNorth.add(txtSDT = new JTextField());
		pNorth.add(txtMoTa = new JTextField());
		
		pNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.RED);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

		int w1 = 100, w2 = 300, h = 20;
		lblMaNV.setBounds(20, 20, w1+10, h);
		txtMaNV.setBounds(130, 20, w2, h);

		lblTenNV.setBounds(20, 45, w1+10, h);
		txtTenNV.setBounds(130, 45, w2, h);

		lblSDT.setBounds(450, 45, w1, h);
		txtSDT.setBounds(570, 45, w2, h);

		lblMoTa.setBounds(20, 70, w1+10, h);
		txtMoTa.setBounds(130, 70, w2, h);
		
		txtMess.setBounds(20, 145, 550, 20);

		JPanel pCen;
		add(pCen = new JPanel(), BorderLayout.CENTER);
		pCen.add(btnThem = new JButton("Thêm"));
		pCen.add(btnXoaRong = new JButton("Xóa rỗng"));
		pCen.add(btnXoa = new JButton("Xóa"));
		pCen.add(btnSua = new JButton("Sửa"));
		pCen.add(btnLuu = new JButton("Lưu"));
		pCen.add(btnBack = new JButton("Trở về"));

		JScrollPane scroll;
		String[] headers = "MaNV;TenNV;SDT;MoTa".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách các nhân viên"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));

		// cboMaSach.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnBack.addActionListener(this);
		// btnLoc.addActionListener(this);
		table.addMouseListener(this);

	}

	private void clearTextFields() {
		txtTenNV.setText("");
		txtMaNV.setText("");
		txtSDT.setText("");
		txtMoTa.setText("");
		txtMaNV.setEditable(true);
		txtMaNV.requestFocus();
	}

	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}

	String maNV, tenNV, SDT, Mota;

	private NhanVien revertNVFromTextFields() {
		maNV = txtMaNV.getText().trim();
		tenNV = txtTenNV.getText().trim();
		SDT = txtSDT.getText().trim();
		Mota = txtMoTa.getText().trim();
		return new NhanVien(maNV, tenNV, SDT, Mota);
	}

	private void fillForm(int row) {
		if (row != -1) {
			String maNV = (String) table.getValueAt(row, 0);
			NhanVien nv = new NhanVien(maNV);
			ArrayList<NhanVien> dsNV = QuanLyNhanVien.getDsNhanVien();
			if (QuanLyNhanVien.getDsNhanVien().contains(nv)) {
				nv = dsNV.get(dsNV.indexOf(nv));
				txtMaNV.setText(nv.getMaNV());
				txtTenNV.setText(nv.getTenNV());
				txtSDT.setText(nv.getsDT());
				txtMoTa.setText(nv.getMoTa());
				txtMaNV.setEditable(false);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		fillForm(row);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if (row != -1) {
				int hoinhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không?", "Chú ý",
						JOptionPane.YES_NO_OPTION);
				if (hoinhac == JOptionPane.YES_OPTION) {
					if (QuanLyNhanVien.xoaNhanVien(row)) {
						tableModel.removeRow(row);
						txtMess.setText("Đã xóa");
						clearTextFields();
					}
				}
			} else
				txtMess.setText("Bạn cần phải chọn một nhân viên cần xóa");
		} else if (o.equals(btnThem)) {
			NhanVien nv = revertNVFromTextFields();
			String[] row = { maNV, tenNV, SDT, Mota+ "\n" };
			if (QuanLyNhanVien.themNhanVien(nv)) {
				tableModel.addRow(row);
				txtMess.setText("Thêm thành công một nhân viên");
			} else {
				showMessage("Error: Trùng mã nv", txtMaNV);
			}
		} else if (o.equals(btnXoaRong)) {
			clearTextFields();
		} else if (o.equals(btnSua)) {
			String maNVOld = txtMaNV.getText().trim();
			NhanVien NVNew = revertNVFromTextFields();
			if (QuanLyNhanVien.capNhatNhanVien(maNVOld, NVNew)) {
				txtMess.setText("Cập nhật thành công");
				int row = table.getSelectedRow();
				tableModel.setValueAt(txtMaNV.getText(), row, 0);
				tableModel.setValueAt(txtTenNV.getText(), row, 1);
				tableModel.setValueAt(txtSDT.getText(), row, 2);
				tableModel.setValueAt(txtMoTa.getText(), row, 3);
			} else
				txtMess.setText("Cần chọn nhân viên để cập nhật");
		} else if (o.equals(btnLuu)) {
			Database.SaveDatabaseNV(QuanLyNhanVien.getDsNhanVien());
			txtMess.setText("Lưu thành công");
		} else if (o.equals(btnBack)) {
			new FrmMenu().setVisible(true);
			this.setVisible(false);
		}
	}

}
