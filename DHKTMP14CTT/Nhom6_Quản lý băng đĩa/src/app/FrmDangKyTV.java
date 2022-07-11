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

public class FrmDangKyTV extends JFrame implements ActionListener, MouseListener {

	private JTextField txtCMND;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JButton btnDangKy;
	private JButton btnThoat;
	private JTextField txtMess;

	private Database database;

	private JComboBox cboGioiTinh;

	public FrmDangKyTV() {
		setTitle("Đăng ký");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
		database.loadDataBaseTV();
	}

	private void buildUI() {
		JPanel pNorth;
		add(pNorth = new JPanel(), BorderLayout.NORTH);
		pNorth.setPreferredSize(new Dimension(0, 180));
		pNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pNorth.setLayout(null);

		JLabel lblCMND, lblTen, lblSDT, lblGioiTinh, lblDiaChi;
		pNorth.add(lblCMND = new JLabel("CMND: "));
		pNorth.add(lblTen = new JLabel("Tên: "));
		pNorth.add(lblSDT = new JLabel("SDT: "));
		pNorth.add(lblGioiTinh = new JLabel("Giới tính: "));
		pNorth.add(lblDiaChi = new JLabel("Địa chỉ: "));

		pNorth.add(txtCMND = new JTextField());
		pNorth.add(txtTen = new JTextField());
		pNorth.add(txtSDT = new JTextField());
		pNorth.add(cboGioiTinh = new JComboBox<String>());
		cboGioiTinh.addItem("Nam");
		cboGioiTinh.addItem("Nữ");
		pNorth.add(txtDiaChi = new JTextField());

		pNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.RED);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

		int w1 = 100, w2 = 300, h = 20;
		lblCMND.setBounds(20, 20, w1, h);
		txtCMND.setBounds(120, 20, w2, h);

		lblTen.setBounds(20, 45, w1, h);
		txtTen.setBounds(120, 45, w2, h);

		lblSDT.setBounds(450, 45, w1, h);
		txtSDT.setBounds(570, 45, w2, h);

		lblGioiTinh.setBounds(450, 70, w1, h);
		cboGioiTinh.setBounds(570, 70, w2, h);

		lblDiaChi.setBounds(20, 70, w1, h);
		txtDiaChi.setBounds(120, 70, w2, h);

		txtMess.setBounds(20, 145, 550, 20);

		JPanel pCen;
		add(pCen = new JPanel(), BorderLayout.CENTER);
		pCen.add(btnDangKy = new JButton("Đăng ký"));
		pCen.add(btnThoat = new JButton("Thoát"));
		
		btnDangKy.addActionListener(this);
		btnThoat.addActionListener(this);

	}


	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}

	String cmnd, ten, sdt, gioiTinh, diaChi;


	private ThanhVien revertTVFromTextFields() {
		cmnd = txtCMND.getText().trim();
		ten = txtTen.getText().trim();
		sdt = txtSDT.getText().trim();
		gioiTinh = cboGioiTinh.getSelectedItem().toString();
		diaChi = txtDiaChi.getText().trim();
		return new ThanhVien(cmnd, ten, gioiTinh, sdt, diaChi);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
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
		if (o.equals(btnThoat)) {
			new FrmDangNhapTV().setVisible(true);
			this.setVisible(false);
		} else if (o.equals(btnDangKy)) {
			ThanhVien tv = revertTVFromTextFields();
			if(QuanLyThanhVien.themThanhVien(tv)) {
				database.SaveDatabaseTV(QuanLyThanhVien.getDsThanhVien());
				txtMess.setText("Thêm thành công một thành viên");
			} else {
				showMessage("Error: Trùng mã nv", txtCMND);
			}
		}
	}

}
