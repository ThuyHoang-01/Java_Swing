package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import dao.ChuyenMon_DAO;
import dao.QuanLyLaoDong_DAO;
import dao.DiaChi_DAO;
import entity.ChuyenMon;
import entity.DiaChi;
import entity.LaoDong;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class QuanLyLaoDong_GUI extends JPanel implements ActionListener, ItemListener, MouseListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtHoTen;
	private JTextField txtCMND;
	private JTextField txtSoDT;
	private JTable tableLaoDong;
	private DefaultTableModel modelLaoDong;
	private JTextField txtMaLD;
	private JTextField txtTenLD;
	private JButton btnThem;
	private JButton btnCapNhat;
	private JButton btnNghiViec;
	private JButton btnLamMoi;
	private JDateChooser ngaySinh;
	private JComboBox<String> cbGioiTinh;
	private JComboBox<String> cbTinhTP;
	private JComboBox<String> cbQuanHuyen;
	private JComboBox<String> cbXaPhuong;
	private JComboBox<String> cbChuyenMon;
	private DiaChi_DAO dao_dc = new DiaChi_DAO();
	private QuanLyLaoDong_DAO dao_qlld = new QuanLyLaoDong_DAO();
	ChuyenMon_DAO listChuyenMon = new ChuyenMon_DAO();

	private ArrayList<LaoDong> listLaoDong;
	private JComboBox<String> cbTrangthai;
	private ArrayList<LaoDong> listTable = QuanLyLaoDong_DAO.getAllLaoDong();

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("static-access")
	public QuanLyLaoDong_GUI() {
		setLayout(null);
		setSize(1284, 555);
		JLabel lbHoTen = new JLabel("Họ tên:");
		lbHoTen.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbHoTen.setBounds(10, 19, 95, 30);
		add(lbHoTen);

		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(113, 21, 234, 30);
		add(txtHoTen);
		txtHoTen.setColumns(10);

		JLabel lbCMND = new JLabel("Số CMND:");
		lbCMND.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbCMND.setBounds(467, 22, 95, 30);
		add(lbCMND);

		JLabel lbSoDT = new JLabel("Số ĐT:");
		lbSoDT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbSoDT.setBounds(10, 65, 95, 30);
		add(lbSoDT);

		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(572, 22, 234, 30);
		add(txtCMND);

		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGiiTnh.setBounds(904, 19, 95, 30);
		add(lblGiiTnh);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setBounds(1029, 19, 234, 30);
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		cbGioiTinh.setEditable(false);
		add(cbGioiTinh);

		txtSoDT = new JTextField();
		txtSoDT.setColumns(10);
		txtSoDT.setBounds(113, 65, 234, 30);
		add(txtSoDT);

		JLabel lbNgaySinh = new JLabel("Ngày sinh:");
		lbNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbNgaySinh.setBounds(467, 68, 95, 30);
		add(lbNgaySinh);

		ngaySinh = new JDateChooser();
		ngaySinh.setBounds(572, 68, 234, 30);
		ngaySinh.setDateFormatString("dd/MM/yyyy");
		add(ngaySinh);

		cbChuyenMon = new JComboBox<String>();
		cbChuyenMon.setBounds(1029, 66, 234, 30);
		add(cbChuyenMon);

		JLabel lbDiaChi = new JLabel("Địa chỉ:");
		lbDiaChi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbDiaChi.setBounds(10, 115, 95, 30);
		add(lbDiaChi);

		cbTinhTP = new JComboBox<String>();
		cbTinhTP.setBounds(113, 116, 234, 30);
		add(cbTinhTP);

		cbQuanHuyen = new JComboBox<String>();
		cbQuanHuyen.setBounds(381, 116, 184, 30);
		add(cbQuanHuyen);

		cbXaPhuong = new JComboBox<String>();
		cbXaPhuong.setBounds(624, 116, 184, 30);
		add(cbXaPhuong);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBounds(712, 157, 120, 35);
		add(btnThem);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCapNhat.setBounds(852, 157, 120, 35);
		add(btnCapNhat);

		btnNghiViec = new JButton("Nghỉ việc");
		btnNghiViec.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNghiViec.setBounds(993, 157, 128, 35);
		add(btnNghiViec);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoi.setBounds(1143, 157, 120, 35);
		add(btnLamMoi);

		JLabel lbTimKiem = new JLabel("Tìm kiếm:");
		lbTimKiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbTimKiem.setBounds(10, 163, 95, 23);
		add(lbTimKiem);

		String[] colHeader = { "Mã lao động", "Họ Tên", "Ngày sinh", "Giới Tính", "Số điện thoại", "Số CMND", "Địa chỉ",
				"Chuyên môn" };
		modelLaoDong = new DefaultTableModel(colHeader, 0) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {

				return false;
			};
		};
		tableLaoDong = new JTable(modelLaoDong);
		tableLaoDong.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane(tableLaoDong);
		scrollPane.setBounds(0, 248, 1284, 300);
		add(scrollPane);
		JTableHeader h = tableLaoDong.getTableHeader();
		h.setForeground(new Color(31, 39, 191));
		h.setFont(new Font("Arial", Font.BOLD, 15));
		h.setBackground(new Color(116, 235, 52));

		tableLaoDong.setRowHeight(tableLaoDong.getRowHeight() + 20);

		JLabel label = new JLabel("");
		label.setBounds(86, 313, 46, 14);
		add(label);

		JLabel lbMaLD = new JLabel("Mã lao động");
		lbMaLD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbMaLD.setBounds(10, 191, 111, 30);
		add(lbMaLD);

		txtMaLD = new JTextField();
		txtMaLD.setColumns(10);
		txtMaLD.setBounds(124, 193, 193, 30);
		add(txtMaLD);

		JLabel lbTenLD = new JLabel("Tên lao động");
		lbTenLD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbTenLD.setBounds(353, 191, 111, 30);
		add(lbTenLD);

		txtTenLD = new JTextField();
		txtTenLD.setColumns(10);
		txtTenLD.setBounds(474, 193, 193, 30);
		add(txtTenLD);

		JLabel lbChuyeMon = new JLabel("Chuyên môn:");
		lbChuyeMon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbChuyeMon.setBounds(904, 65, 115, 30);
		add(lbChuyeMon);

		cbTinhTP.addItem("Tỉnh");
		cbQuanHuyen.addItem("Quận");
		cbXaPhuong.addItem("Xã");
		ArrayList<String> listTinh = dao_dc.getTinhTP();
		for (String dc : listTinh) {
			cbTinhTP.addItem(dc);
		}

		tableLaoDong.getColumnModel().getColumn(0).setPreferredWidth(35);
		tableLaoDong.getColumnModel().getColumn(1).setPreferredWidth(124);
		tableLaoDong.getColumnModel().getColumn(2).setPreferredWidth(20);
		tableLaoDong.getColumnModel().getColumn(3).setPreferredWidth(10);
		tableLaoDong.getColumnModel().getColumn(4).setPreferredWidth(55);
		tableLaoDong.getColumnModel().getColumn(5).setPreferredWidth(40);
		tableLaoDong.getColumnModel().getColumn(6).setPreferredWidth(350);
		tableLaoDong.getColumnModel().getColumn(7).setPreferredWidth(30);
		// Change
		cbTinhTP.addItemListener(this);
		cbQuanHuyen.addItemListener(this);
		
		// Btn
		btnThem.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnNghiViec.addActionListener(this);
		// table
		tableLaoDong.addMouseListener(this);

		txtMaLD.addKeyListener(this);
		txtTenLD.addKeyListener(this);

		cbTrangthai = new JComboBox<String>();
		cbTrangthai.addItem("Đang làm việc");
		cbTrangthai.addItem("Đã nghỉ việc");
		cbTrangthai.setBounds(1116, 203, 147, 30);
		add(cbTrangthai);
 
		cbTrangthai.addItemListener(this);

		JLabel lbTrangthai = new JLabel("Trạng thái");
		lbTrangthai.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbTrangthai.setBounds(993, 203, 115, 30);
		add(lbTrangthai);
		// load du lieu vao chuyen mon
		for (ChuyenMon tm : listChuyenMon.getAllChuyenMon()) {
			cbChuyenMon.addItem(tm.getTenChuyenMon());
		}

		// load du lieu vao table
		listLaoDong = new QuanLyLaoDong_DAO().getAllLaoDong();
		
		loadDataTable(getDSLDLamViec(listLaoDong));

	}
	public ArrayList<LaoDong> getDSLDLamViec(ArrayList<LaoDong> list) {
		ArrayList<LaoDong> listLV = new ArrayList<LaoDong>();
		for (LaoDong ld : list) {
			if (ld.isTrangThai()) {
				listLV.add(ld);
			} 
		}
		return listLV;
	}
	public ArrayList<LaoDong> getDSLDNghiViec(ArrayList<LaoDong> list) {
		ArrayList<LaoDong> listNV = new ArrayList<LaoDong>();
		for (LaoDong ld : list) {
			if (!ld.isTrangThai()) {
				listNV.add(ld);
			} 
		}
		return listNV;
	}
	public void loadDataTable(ArrayList<LaoDong> list) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for (LaoDong ld : list) {
			modelLaoDong.addRow(new Object[] { ld.getMaLaoDong(), ld.getTenLaoDong().toUpperCase(), df.format(ld.getNgaySinh()),
					getGioiTinh(ld.isGioiTinh()), ld.getSDT(), ld.getCMND(), ld.getDiaChi().toString(),
					listChuyenMon.getChuyenMon(ld.getChuyenMon().getMaChuyenMon(), "").getTenChuyenMon()});
		}
	}
	public void deleteDataTable() {
		int maxRow = tableLaoDong.getRowCount();
		for (int i = maxRow - 1; i >= 0; i--) {
			modelLaoDong.removeRow(i);
		}
	}

	public String getGioiTinh(boolean gt) {
		return gt ? "Nam" : "Nữ";
	}

	public void foCus(JTextField txt) {
		txt.selectAll();
		txt.requestFocus();
	}

	public boolean kiemtraDuLieu() {

		if (txtHoTen.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên không được trống");
			foCus(txtHoTen);
			return false;
		}
		if (!txtHoTen.getText()
				.matches("" + "[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ"
						+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu"
						+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+")) {
			JOptionPane.showMessageDialog(this, "Tên không có kí tự đặc biệt");
			foCus(txtHoTen);
			return false;
		}

		if (txtCMND.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "CMND không được trống");
			foCus(txtCMND);
			return false;
		}
		if (!txtCMND.getText().matches("[0-9]{9}|[0-9]{12}")) {
			JOptionPane.showMessageDialog(this, "CMND là số có 9 hoặc 12 chữ số");
			foCus(txtCMND);
			return false;
		}

		if (txtSoDT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được trống");
			foCus(txtSoDT);
			return false;
		}
		if (!txtSoDT.getText().matches("^0[1-9][0-9]{8}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
			foCus(txtSoDT);

			return false;
		}

		if (ngaySinh.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh");
			return false;
		}
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String[] s = df.format(ngaySinh.getDate()).split("/");
		LocalDate ld = LocalDate.of(Integer.parseInt(s[2]), Integer.parseInt(s[1]), Integer.parseInt(s[0]));

		if (Period.between(ld, LocalDate.now()).getYears() < 18) {
			JOptionPane.showMessageDialog(this, "Người lao động phải lớn hơn 18 tuổi");
			return false;
		}

		if (cbGioiTinh.getSelectedIndex() == 0) {
			if (Period.between(ld, LocalDate.now()).getYears() > 60) {
				JOptionPane.showMessageDialog(this, "Người lao động nam phải nhỏ hơn 60");
				return false;
			}
		} else {
			if (Period.between(ld, LocalDate.now()).getYears() > 55) {
				JOptionPane.showMessageDialog(this, "Người lao động nữ phải nhỏ hơn 55");
				return false;
			}
		}
		if (cbTinhTP.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn tỉnh/thành phố");
			return false;
		}
		if (cbQuanHuyen.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn quận/huyện");
			return false;
		}
		if (cbXaPhuong.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn xã/phường");
			return false;
		}
		return true;
	}

	// Ma lao dong LDxxx (x la so nguyen)
	public String taoMaLaoDong() {
		String maCuoi = dao_qlld.getMaLaoDongCuoi().trim().substring(2);
		int maLD =  Integer.parseInt(maCuoi);
		String maMoi = String.format("LD%08d", maLD + 1);
		return maMoi;
	}

	public boolean isGioiTinh(int index) {
		return index == 0 ? true : false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		if (src.equals(btnThem)) {
			if (tableLaoDong.getSelectedRow() >= 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng làm mới trước khi thêm");
				return;
			}
			if (kiemtraDuLieu()) {
				String maLD = taoMaLaoDong();
				String hoTen = txtHoTen.getText().toUpperCase();
				String cmnd = txtCMND.getText();
				String sdt = txtSoDT.getText();
				boolean gt = isGioiTinh(cbGioiTinh.getSelectedIndex());
				ChuyenMon cm = listChuyenMon.getChuyenMon("",cbChuyenMon.getSelectedItem().toString());
				String tinh = cbTinhTP.getSelectedItem().toString();
				String huyen = cbQuanHuyen.getSelectedItem().toString();
				String xa = cbXaPhuong.getSelectedItem().toString();
				DiaChi dc = new DiaChi(tinh, huyen, xa);
				Date date = ngaySinh.getDate();
				String[] s = df.format(date).split("/");
				java.sql.Date ngay = new java.sql.Date(Integer.parseInt(s[2]) - 1900, Integer.parseInt(s[1]) - 1,
						Integer.parseInt(s[0]));
				int yesNo = JOptionPane.showConfirmDialog(this, "Xác nhận thêm", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (yesNo == JOptionPane.YES_OPTION) {
					LaoDong ld = new LaoDong(maLD, hoTen, ngay, gt, cmnd, dc, cm, sdt, true);
					if (dao_qlld.themLaoDong(ld)) {
						JOptionPane.showMessageDialog(this, "Thêm thành công");

						listLaoDong.add(ld);
						listTable = listLaoDong;
						loadDataTable(listLaoDong);
					} else {
						JOptionPane.showMessageDialog(this, "Thêm không thành công");
					}
				}
			}
		}
		if (src.equals(btnLamMoi)) {
			xoaRong();
		}
		if (src.equals(btnCapNhat)) {
			int row = tableLaoDong.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn lao động");
				return;
			}
			if (kiemtraDuLieu()) {
				LaoDong ld = dao_qlld.getLaoDong(modelLaoDong.getValueAt(row, 0).toString());
				String maLD = ld.getMaLaoDong();
				String hoTen = txtHoTen.getText();
				String cmnd = txtCMND.getText();
				String sdt = txtSoDT.getText();
				boolean gt = isGioiTinh(cbGioiTinh.getSelectedIndex());
				ChuyenMon cm = listChuyenMon.getChuyenMon("",cbChuyenMon.getSelectedItem().toString());
				String tinh = cbTinhTP.getSelectedItem().toString();
				String huyen = cbQuanHuyen.getSelectedItem().toString();
				String xa = cbXaPhuong.getSelectedItem().toString();
				DiaChi dc = new DiaChi(tinh, huyen, xa);
				Date date = ngaySinh.getDate();
				String[] s = df.format(date).split("/");
				@SuppressWarnings("deprecation")
				java.sql.Date ngay = new java.sql.Date(Integer.parseInt(s[2]) - 1900, Integer.parseInt(s[1]) - 1,
						Integer.parseInt(s[0]));
				ld = new LaoDong(maLD, hoTen, ngay, gt, cmnd, dc, cm, sdt, true);
				int yesNo = JOptionPane.showConfirmDialog(this, "Xác nhận cập nhật", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (yesNo == JOptionPane.YES_OPTION) {
					if (dao_qlld.suaLD(ld)) {
						// cap nhat table
						tableLaoDong.setValueAt(ld.getTenLaoDong(), row, 1);
						tableLaoDong.setValueAt(df.format(ld.getNgaySinh()), row, 2);
						tableLaoDong.setValueAt(getGioiTinh(ld.isGioiTinh()), row, 3);
						tableLaoDong.setValueAt(ld.getSDT(), row, 4);
						tableLaoDong.setValueAt(ld.getCMND(), row, 5);
						tableLaoDong.setValueAt(ld.getDiaChi(), row, 6);
						tableLaoDong.setValueAt(ld.getChuyenMon().getTenChuyenMon(), row, 7);
						// capnhat arraylist
						listLaoDong.add(row, ld);
						listLaoDong.remove(row + 1);
						JOptionPane.showMessageDialog(this, "Cập nhật thành công");
					}
				}
			}
		}
		if (src.equals(btnNghiViec)) {
			int row = tableLaoDong.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn lao động");
			} else {
				if(!dao_qlld.getLaoDong(modelLaoDong.getValueAt(row, 0).toString()).isTrangThai()) {
					JOptionPane.showMessageDialog(this, "Lao động này đã nghỉ việc");
					return ;
				}
				int ys = JOptionPane.showConfirmDialog(this, "Xác nhận cho nghỉ việc", null, JOptionPane.YES_NO_OPTION);
				if (ys == JOptionPane.YES_OPTION) {
					dao_qlld.nghiViecLaoDong(tableLaoDong.getValueAt(row, 0).toString());
					listTable = dao_qlld.getAllLaoDong();
					modelLaoDong.removeRow(row);
					xoaRong();
					JOptionPane.showMessageDialog(this, "Nghỉ việc thành công");
				}
			}
		}
	}

	private void xoaRong() {
		tableLaoDong.clearSelection();
		txtHoTen.setText("");
		txtCMND.setText("");
		txtMaLD.setText("");
		txtSoDT.setText("");
		txtTenLD.setText("");
		ngaySinh.setDate(null);
		cbGioiTinh.setSelectedIndex(0);
		cbChuyenMon.setSelectedIndex(0);
		cbTinhTP.setSelectedIndex(0);
		cbQuanHuyen.setSelectedIndex(0);
		cbXaPhuong.setSelectedIndex(0);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object o = e.getSource();
		if (o.equals(cbTinhTP)) {
			if (cbTinhTP.getSelectedIndex() != 0) {
				String tinh = cbTinhTP.getSelectedItem().toString();
				ArrayList<String> list = dao_dc.getQuanHuyen(tinh.trim());
				cbQuanHuyen.removeAllItems();
				cbQuanHuyen.addItem("Quận");

				for (String h : list) {
					cbQuanHuyen.addItem(h);
				}
			} else {
				cbQuanHuyen.removeAllItems();
				cbXaPhuong.removeAllItems();
				cbQuanHuyen.addItem("Quận");
			}
		} else if (o.equals(cbQuanHuyen) && cbQuanHuyen.getSelectedItem() != null) {
			if (cbQuanHuyen.getSelectedIndex() != 0) {
				String tinh = cbTinhTP.getSelectedItem().toString();
				String huyen = cbQuanHuyen.getSelectedItem().toString();
				ArrayList<String> listxa = dao_dc.getPhuongXa(tinh.trim(), huyen.trim());
				cbXaPhuong.removeAllItems();
				cbXaPhuong.addItem("Xã");
				for (String xa : listxa) {
					cbXaPhuong.addItem(xa);
				}
			} else {
				cbXaPhuong.removeAllItems();
				cbXaPhuong.addItem("Xã");
			}
		} else if(o.equals(cbTrangthai)) {
			deleteDataTable();
			xoaRong();
			if(cbTrangthai.getSelectedIndex() == 0) {
				loadDataTable(getDSLDLamViec(listTable));
			} else {
				loadDataTable(getDSLDNghiViec(listTable));
			} 
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableLaoDong.getSelectedRow();
		if(row == -1) return;
		txtHoTen.setText(tableLaoDong.getValueAt(row, 1).toString());
		cbGioiTinh.setSelectedItem(tableLaoDong.getValueAt(row, 3));
		txtSoDT.setText(tableLaoDong.getValueAt(row, 4).toString());
		txtCMND.setText(tableLaoDong.getValueAt(row, 5).toString());
		String[] dc = tableLaoDong.getValueAt(row, 6).toString().split(", ");
		cbTinhTP.setSelectedItem(dc[2].toString());
		cbQuanHuyen.setSelectedItem(dc[1].toString());
		cbXaPhuong.setSelectedItem(dc[0].toString());
		cbChuyenMon.setSelectedItem(tableLaoDong.getValueAt(row, 7).toString());
		Object d = tableLaoDong.getValueAt(row, 2);
		String[] ngay = d.toString().split("/");
		@SuppressWarnings("deprecation")
		Date date = new Date(Integer.parseInt(ngay[2]) - 1900, Integer.parseInt(ngay[1]) - 1,
				Integer.parseInt(ngay[0]));
		ngaySinh.setDate(date);
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

	@SuppressWarnings("static-access")
	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Object src = e.getSource();
		listTable = new ArrayList<LaoDong>();
		if (src.equals(txtMaLD)) {
			txtTenLD.setText("");
			try {
				listTable = dao_qlld.timKiemLaoDong(txtMaLD.getText().trim(), "");
			} catch (Exception e2) {
				listTable = null;
			}
		} 
		else if(src.equals(txtTenLD)){
			txtMaLD.setText("");
			try {
				listTable = dao_qlld.timKiemLaoDong("", txtTenLD.getText().trim());

			} catch (Exception e2) {
				listTable = null;
			}
		}
		deleteDataTable();
		if(cbTrangthai.getSelectedIndex() == 0) {
			loadDataTable(getDSLDLamViec(listTable));
		} else if(cbTrangthai.getSelectedIndex() == 1) {
			loadDataTable(getDSLDNghiViec(listTable));
		} else {
			if(cbTrangthai.getSelectedIndex() == -1) return;
//			loadDataTable(listTable);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
