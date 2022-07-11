package UI;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import dao.PhongBan_DAO;
import entity.NhanVien;
import entity.PhongBan;

public class NhanVien_GUI extends JFrame implements ActionListener, MouseListener {
	
	private static final long serialVersionUID = 1L;

	private JTable tableNhanVien;
	private DefaultTableModel modelNhanVien;

	private JTextField txtMaNV;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtTienLuong;
	private JTextField txtTim;
	private JButton bttTim;
	private JButton bttThem;
	private JButton bttXoa;
	private JButton bttLuu;
	private JButton bttXoaTrang;
	
	private JCheckBox chkNu;
	private JComboBox<String> cboPhongBan;

	private NhanVien_DAO nv_dao;
	private PhongBan_DAO pb_dao;

	private boolean phai;

	public NhanVien_GUI() {

		// khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nv_dao = new NhanVien_DAO();
		pb_dao = new PhongBan_DAO();

		setTitle("^-^");
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblTieuDe;
		lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.blue);

		Box b = Box.createVerticalBox();

		Box b11, b1, b2, b3, b4;
		JLabel lblMaNV, lblHo, lblTuoi, lblPhai, lblTienLuong, lblTim = null;
		;

		b.add(b11 = Box.createHorizontalBox());
		b11.add(lblTieuDe);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaNV = new JLabel("Mã nhân viên:   "));
		b1.add(txtMaNV = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblHo = new JLabel("Họ "));
		b2.add(txtHo = new JTextField());
		b2.add(new JLabel("Tên nhân viên: "));
		b2.add(txtTen = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblTuoi = new JLabel("Tuổi: "));
		b3.add(txtTuoi = new JTextField());
		b3.add(lblPhai = new JLabel("Phái: "));
		b3.add(chkNu = new JCheckBox("Nữ"));

		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblTienLuong = new JLabel("Tiền lương: "));
		b4.add(txtTienLuong = new JTextField());
		b4.add(new JLabel("Phòng Ban: "));
		
		//Tạo và đổ dữ liệu vào comboBox
		b4.add(cboPhongBan = new JComboBox<String>());
		cboPhongBan.setEditable(true);		
		
		ArrayList<PhongBan> listPB = pb_dao.getalltbPhongBan();
		for(PhongBan p : listPB) {
			cboPhongBan.addItem(p.getMaPhongBan());
		}

		lblHo.setPreferredSize(lblMaNV.getPreferredSize());
		lblPhai.setPreferredSize(lblMaNV.getPreferredSize());
		lblTienLuong.setPreferredSize(lblMaNV.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());
		cboPhongBan.setPreferredSize(lblMaNV.getPreferredSize());
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);

		String[] colHeader = { "Mã NV", "Họ NV", "Tên NV", "Tuổi", "Phái", "Lương", "Phòng ban" };
		modelNhanVien = new DefaultTableModel(colHeader, 0);
		tableNhanVien = new JTable(modelNhanVien);
		add(new JScrollPane(tableNhanVien), BorderLayout.CENTER);

		// =================================
		// doc du lieu tu database SQL vao Jtable

		DocDuLieuDatabaseVaoTable();
		// =================================

		JPanel p = new JPanel();
		add(p, BorderLayout.SOUTH);
		JPanel pnlLeft, pnlRight;
		p.add(pnlLeft = new JPanel());
		p.add(pnlRight = new JPanel());

		pnlLeft.add(lblTim = new JLabel("Nhập mã số cần tìm: "));
		pnlLeft.add(txtTim = new JTextField(10));
		pnlLeft.add(bttTim = new JButton("Tìm"));

		pnlRight.add(bttThem = new JButton("Thêm"));
		pnlRight.add(bttXoaTrang = new JButton("Xóa trắng"));
		pnlRight.add(bttXoa = new JButton("Xóa"));
		pnlRight.add(bttLuu = new JButton("Loc theo Ph Ban"));

		bttTim.addActionListener(this);
		bttThem.addActionListener(this);
		bttXoa.addActionListener(this);
		bttLuu.addActionListener(this);
		bttXoaTrang.addActionListener(this);
		tableNhanVien.addMouseListener(this);
	}

	public static void main(String[] args) {
		new NhanVien_GUI().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(bttThem)) {
			int ma = Integer.parseInt(txtMaNV.getText());
			String ho = txtHo.getText();
			String ten = txtTen.getText();
			int tuoi = Integer.parseInt(txtTuoi.getText());
			boolean phao = chkNu.isSelected();
			double luong = Double.parseDouble(txtTienLuong.getText());
			String phongban = cboPhongBan.getSelectedItem().toString();
			

			NhanVien nv = new NhanVien(ma,ho,ten,tuoi,phai,luong,new PhongBan(phongban, phongban));
			
			try {
				nv_dao.create(nv);
				modelNhanVien.addRow(new Object[] {
						nv.getMaNv(),nv.getHoNV(),nv.getTenNv(),nv.getTuoi(),nv.isPhai(),nv.getLuong()
				});
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Trung");
			}
			
		}
		if (o.equals(bttXoa)) {
			int r = tableNhanVien.getSelectedRow();
			modelNhanVien.removeRow(r); // xóa trong table model

		}
		if (o.equals(bttXoaTrang)) {
			txtHo.setText("");
			txtMaNV.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			txtTienLuong.setText("");
			txtMaNV.requestFocus();
		}
		if (o.equals(bttTim)) {

		}
		if (o.equals(bttLuu)) {
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableNhanVien.getSelectedRow();
		txtMaNV.setText(modelNhanVien.getValueAt(row, 0).toString());
		txtHo.setText(modelNhanVien.getValueAt(row, 1).toString());
		txtTen.setText(modelNhanVien.getValueAt(row, 2).toString());
		txtTuoi.setText(modelNhanVien.getValueAt(row, 3).toString());
		chkNu.setSelected(modelNhanVien.getValueAt(row, 4).toString() == "Nữ" ? true : false);
		txtTienLuong.setText(modelNhanVien.getValueAt(row, 5).toString());
		cboPhongBan.setSelectedItem(modelNhanVien.getValueAt(row, 6).toString());
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
	
	public void DocDuLieuDatabaseVaoTable() {
		List<NhanVien> list = nv_dao.getalltbNhanVien();
		
		for (NhanVien nv : list) {
			modelNhanVien.addRow(new Object[] {
					nv.getMaNv(), nv.getHoNV(),nv.getTenNv(),nv.getTuoi(),nv.isPhai(),nv.getLuong(),nv.getPhong(),nv.getMaPhongBan
			});
		}
	}
	
}