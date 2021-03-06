package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;



import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

import dao.DiaChi_DAO;
import dao.QuanLyCongTrinh_DAO;
import entity.CongTrinh;
import entity.DiaChi;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.SimpleFormatter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

public class QuanLyCongTrinh_GUI extends JPanel implements ActionListener, MouseListener, ItemListener {
	private JTextField txtTenCT;
	private JTextField txtMaCT;
	private JTextField txtTimMaCT;
	private JTextField txtTimTenCT;
	private DefaultTableModel model;
	private JTable tableCT;
	private JButton btnThemCT;
	private JButton btnXoa;
	private JButton btnSuaCT;
	private JButton btnTimKiem;
	private JScrollPane scrollPane;
	private JComboBox cbLoaiCT;
	private JDateChooser ngayKhoiCong;
	private JDateChooser ngayDKHoanThanh;
	private ArrayList<CongTrinh> listCongTrinh;
	private JComboBox cbTrangThai;
	private JComboBox cbTinhTP;
	private JComboBox cbQuanHuyen;
	private JComboBox cbPhuongXa;
	private JButton btnLamMoi;
	private QuanLyCongTrinh_DAO quanLyCongTrinhDao = new QuanLyCongTrinh_DAO();
	private DiaChi_DAO diaChiDao = new DiaChi_DAO();

	/**
	 * Create the panel.
	 */
	public QuanLyCongTrinh_GUI() {
		setLocation(0, 13);
		setLayout(null);
		setSize(1284, 555);
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 1284, 194);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("T??n c??ng tr??nh:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(21, 10, 125, 22);
		panel.add(lblNewLabel);

		txtTenCT = new JTextField();
		txtTenCT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenCT.setBounds(156, 8, 626, 30);
		panel.add(txtTenCT);
		txtTenCT.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("M?? c??ng tr??nh:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setBounds(21, 46, 125, 22);
		panel.add(lblNewLabel_1);

		txtMaCT = new JTextField();
		txtMaCT.setEditable(false);
		txtMaCT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaCT.setBounds(156, 44, 361, 30);
		panel.add(txtMaCT);
		txtMaCT.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Lo???i c??ng tr??nh:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2.setBounds(863, 10, 125, 22);
		panel.add(lblNewLabel_2);

		cbLoaiCT = new JComboBox();
		cbLoaiCT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbLoaiCT.addItem("         ");
		cbLoaiCT.addItem("Giao th??ng");
		cbLoaiCT.addItem("C??ng nghi???p");
		cbLoaiCT.addItem("D??n d???ng");
		cbLoaiCT.addItem("An ninh qu???c ph??ng");
		cbLoaiCT.addItem("N??ng nghi???p v?? ph??t tri???n n??ng th??n");
		cbLoaiCT.addItem("D??? ??n ?????u t??");
		cbLoaiCT.setBounds(998, 8, 264, 30);
		panel.add(cbLoaiCT);

		JLabel lblNewLabel_3 = new JLabel("Ng??y kh???i c??ng:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3.setBounds(863, 46, 142, 22);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Ng??y d??? ki???n ho??n th??nh:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_4.setBounds(863, 83, 205, 22);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Tr???ng Th??i: ");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_5.setBounds(538, 46, 92, 22);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("?????a ch???: ");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_6.setBounds(21, 83, 92, 22);
		panel.add(lblNewLabel_6);

		cbTrangThai = new JComboBox();
		cbTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbTrangThai.setBounds(640, 44, 142, 30);
		panel.add(cbTrangThai);
		cbTrangThai.addItem("Ch??a ho??n th??nh");
		cbTrangThai.addItem("Ho??n th??nh");
		cbTrangThai.addItem("Ho???n");
		cbTrangThai.setEnabled(false);

		cbTinhTP = new JComboBox();
		cbTinhTP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbTinhTP.setBounds(156, 80, 183, 30);
		panel.add(cbTinhTP);
		cbTinhTP.addItem("T???nh/TP");
		ArrayList<String> tinhTP = diaChiDao.getTinhTP();
		for (String t : tinhTP) {
			cbTinhTP.addItem(t);
		}

		cbQuanHuyen = new JComboBox();
		cbQuanHuyen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbQuanHuyen.setBounds(368, 80, 195, 30);
		panel.add(cbQuanHuyen);
		cbQuanHuyen.addItem("Qu???n/Huy???n");

		cbPhuongXa = new JComboBox();
		cbPhuongXa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbPhuongXa.setBounds(588, 80, 194, 30);
		panel.add(cbPhuongXa);
		cbPhuongXa.addItem("Ph?????ng/X??");

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "T??c v???", TitledBorder.LEFT,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(31, 120, 443, 63);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnThemCT = new JButton("Th??m");
		btnThemCT.setBounds(12, 18, 100, 34);
		panel_1.add(btnThemCT);
		btnThemCT.setBackground(SystemColor.activeCaption);
		btnThemCT.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemCT.setForeground(SystemColor.desktop);

		btnXoa = new JButton("X??a");
		btnXoa.setBounds(122, 18, 87, 34);
		panel_1.add(btnXoa);
		btnXoa.setBackground(SystemColor.activeCaption);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnSuaCT = new JButton("S???a");
		btnSuaCT.setBounds(219, 18, 87, 34);
		panel_1.add(btnSuaCT);
		btnSuaCT.setBackground(SystemColor.activeCaption);
		btnSuaCT.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnLamMoi = new JButton("L??m m???i");
		btnLamMoi.setBounds(316, 18, 117, 34);
		panel_1.add(btnLamMoi);
		btnLamMoi.setBackground(SystemColor.activeCaption);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "T??m Ki???m", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLUE));
		panel_2.setBounds(504, 120, 751, 63);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("M?? c??ng tr??nh");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(10, 25, 124, 22);
		panel_2.add(lblNewLabel_7);

		txtTimMaCT = new JTextField();
		txtTimMaCT.setBounds(139, 20, 400, 30);
		panel_2.add(txtTimMaCT);
		txtTimMaCT.setColumns(10);

		btnTimKiem = new JButton("T??m ki???m");
		btnTimKiem.setBounds(580, 20, 117, 30);
		btnTimKiem.setBackground(SystemColor.activeCaption);
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btnTimKiem);

		ngayKhoiCong = new JDateChooser();
		ngayKhoiCong.setBounds(1101, 46, 161, 28);
		panel.add(ngayKhoiCong);
		ngayKhoiCong.setDateFormatString("dd/MM/yyyy");
		ngayKhoiCong.setFont(cbLoaiCT.getFont());

		ngayDKHoanThanh = new JDateChooser();
		ngayDKHoanThanh.setBounds(1101, 82, 161, 28);
		panel.add(ngayDKHoanThanh);
		ngayDKHoanThanh.setDateFormatString("dd/MM/yyyy");
		ngayDKHoanThanh.setFont(cbLoaiCT.getFont());

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 194, 1284, 341);
		add(scrollPane);
		String[] colHeader = { "M?? c??ng tr??nh", "T??n c??ng tr??nh", "Lo???i c??ng tr??nh", "?????a ch???","Ng??y kh???i c??ng", "Ng??y d??? ki???n ho??n th??nh"};
		model = new DefaultTableModel(colHeader, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		tableCT = new JTable(model) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
		    {
		        Component c = super.prepareRenderer(renderer, row, column);

		        //  Alternate row color

		        if (!isRowSelected(row))
		            c.setBackground(row % 2 == 0 ? getBackground() : SystemColor.menu);

		        return c;
		    }
		};
		tableCT.setFillsViewportHeight(true);
		tableCT.setBackground(Color.WHITE);
		tableCT.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scrollPane.setViewportView(tableCT);

		tableCT.setRowHeight(tableCT.getRowHeight() + 20);

		tableCT.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableCT.getColumnModel().getColumn(1).setPreferredWidth(190);
		tableCT.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableCT.getColumnModel().getColumn(3).setPreferredWidth(190);
		tableCT.getColumnModel().getColumn(4).setPreferredWidth(40);
		tableCT.getColumnModel().getColumn(5).setPreferredWidth(45);
		tableCT.getColumnModel().setColumnMargin(3);

		JTableHeader h = tableCT.getTableHeader();
		h.setForeground(new Color(31, 39, 191));
		h.setFont(new Font("Arial", Font.BOLD, 15));
		h.setBackground(new Color(116, 235, 52));

		docDuLieuVaoModel();

		tableCT.addMouseListener(this);
		cbTinhTP.addItemListener(this);
		cbQuanHuyen.addItemListener(this);
		cbPhuongXa.addItemListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSuaCT.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThemCT.addActionListener(this);
		btnTimKiem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnLamMoi) {
			xoaSach();
		}

		if (o == btnXoa) {
			int row = tableCT.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Ch???n c??ng tr??nh mu???n x??a!");
			} else {
				String maCT = tableCT.getValueAt(row, 0).toString().trim();
				int op = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n x??a c??ng tr??nh n??y?", "Delete",
						JOptionPane.YES_NO_OPTION);
				if (op == JOptionPane.YES_OPTION) {
					if (quanLyCongTrinhDao.xoaCongTrinh(maCT)) {
						JOptionPane.showMessageDialog(this, "X??a th??nh c??ng!");
						xoaSach();
						xoaSachModel();
						docDuLieuVaoModel();
					} else
						JOptionPane.showMessageDialog(this, "X??a th???t b???i!");
				}
			}

		}

		if (o == btnThemCT) {
			if (txtMaCT.getText().equals("")) {
				if (kiemTraDuLieu(btnThemCT)) {
					String ma = taoMaMoi();
					String ten = txtTenCT.getText().trim();
					String loai = cbLoaiCT.getSelectedItem().toString();
					String trangThai = cbTrangThai.getSelectedItem().toString();
					String tinh = cbTinhTP.getSelectedItem().toString();
					String quan = cbQuanHuyen.getSelectedItem().toString();
					String phuong = cbPhuongXa.getSelectedItem().toString();
					DiaChi diaChi = new DiaChi(tinh, quan, phuong);
					String date[] = (new SimpleDateFormat("yyyy-MM-dd").format(ngayKhoiCong.getDate())).split("-");
					java.sql.Date ngayKC = new java.sql.Date(Integer.parseInt(date[0])-1900, Integer.parseInt(date[1])-1,
							Integer.parseInt(date[2]));
					date = (new SimpleDateFormat("yyyy-MM-dd").format(ngayDKHoanThanh.getDate())).split("-");
					java.sql.Date ngayDKHT = new java.sql.Date(Integer.parseInt(date[0])-1900, Integer.parseInt(date[1])-1,
							Integer.parseInt(date[2]));
					CongTrinh ct = new CongTrinh(ma, ten, loai, diaChi, ngayKC, ngayDKHT, trangThai);
					if (quanLyCongTrinhDao.themCongTrinh(ct)) {
						JOptionPane.showMessageDialog(this, "Th??m c??ng tr??nh th??nh c??ng!");
						xoaSachModel();
						docDuLieuVaoModel();
					} else
						JOptionPane.showMessageDialog(this, "Th??m c??ng tr??nh th???t b???i!");
				}
			} else
				JOptionPane.showMessageDialog(this, "M???i ch???n l??m m???i c??ng tr??nh tr?????c khi th??m");
		}

		if (o == btnSuaCT) {
			if(tableCT.getSelectedRow()!=-1) {
				if (kiemTraDuLieu(btnSuaCT)) {
					int op = JOptionPane.showConfirmDialog(this, "B???n mu???n s???a c??ng tr??nh n??y?", "Warning",
							JOptionPane.YES_NO_OPTION);
					if (op == JOptionPane.YES_OPTION) {
						String ma = txtMaCT.getText().trim();
						String ten = txtTenCT.getText().trim();
						String loai = cbLoaiCT.getSelectedItem().toString();
						String trangThai = cbTrangThai.getSelectedItem().toString();
						String tinh = cbTinhTP.getSelectedItem().toString();
						String quan = cbQuanHuyen.getSelectedItem().toString();
						String phuong = cbPhuongXa.getSelectedItem().toString();
						DiaChi diaChi = new DiaChi(tinh, quan, phuong);
						String date[] = (new SimpleDateFormat("yyyy-MM-dd").format(ngayKhoiCong.getDate())).split("-");
						java.sql.Date ngayKC = new java.sql.Date(Integer.parseInt(date[0])- 1900, Integer.parseInt(date[1])-1,
								Integer.parseInt(date[2]));
						date = (new SimpleDateFormat("yyyy-MM-dd").format(ngayDKHoanThanh.getDate())).split("-");
						java.sql.Date ngayDKHT = new java.sql.Date(Integer.parseInt(date[0])-1900, Integer.parseInt(date[1])-1,
								Integer.parseInt(date[2]));
						CongTrinh ct = new CongTrinh(ma, ten, loai, diaChi, ngayKC, ngayDKHT, trangThai);
						if (quanLyCongTrinhDao.suaCongTrinh(ct)) {
							JOptionPane.showMessageDialog(this, "S???a c??ng tr??nh th??nh c??ng!");
							xoaSachModel();
							docDuLieuVaoModel();
						} else
							JOptionPane.showMessageDialog(this, "S???a c??ng tr??nh th???t b???i!");
					}
				}
			}
			else
				JOptionPane.showMessageDialog(this,"M???i ch???n c??ng tr??nh c???n s???a");
		}
		if(o.equals(btnTimKiem)) {
			timKiem();
		}

	}
	public void timKiem() {
		xoaSachModel();
		listCongTrinh = null;
		listCongTrinh = quanLyCongTrinhDao.timKiemCongTrinhTheoMa(txtTimMaCT.getText().trim());
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			
			for (CongTrinh congTrinh : listCongTrinh) {
				model.addRow(new Object[] { congTrinh.getMaCongTrinh(), congTrinh.gettenCongTrinh(),
						congTrinh.getLoaiCongTrinh(), congTrinh.getDiaChi().toString(),
						formatDate.format(congTrinh.getNgayKhoiCong()),
						formatDate.format(congTrinh.getNgayDKHoanThanh()) });
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void xoaSach() {
		txtMaCT.setText("");
		txtTenCT.setText("");
//		txtTimMaCT.setText("");
//		txtTimTenCT.setText("");
		cbLoaiCT.setSelectedIndex(0);
		cbTrangThai.setSelectedIndex(0);
		cbTinhTP.setSelectedIndex(0);
		cbQuanHuyen.setSelectedIndex(0);
		cbPhuongXa.setSelectedIndex(0);
		ngayKhoiCong.setDate(null);
		ngayDKHoanThanh.setDate(null);
		tableCT.clearSelection();
		cbTrangThai.setEnabled(false);
	}

	public void xoaSachModel() {
		try {
			while(tableCT.getRowCount() > 0) {
				model.removeRow(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void docDuLieuVaoModel() {
		listCongTrinh = quanLyCongTrinhDao.getAllCongTrinh();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		for (CongTrinh congTrinh : listCongTrinh) {

			model.addRow(new Object[] { congTrinh.getMaCongTrinh(), congTrinh.gettenCongTrinh(),
					congTrinh.getLoaiCongTrinh(), congTrinh.getDiaChi().toString(),
					formatDate.format(congTrinh.getNgayKhoiCong()),
					formatDate.format(congTrinh.getNgayDKHoanThanh()) });
		}
	}

	public String taoMaMoi() {
		String maCuoi = quanLyCongTrinhDao.getMaCongTrinhCuoi().trim().substring(2);
		int ma = Integer.parseInt(maCuoi);
		String maMoi = String.format("CT%08d", ma + 1);
		return maMoi;
	}

	public boolean kiemTraDuLieu(JButton btn) {
		if (txtTenCT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "M???i nh???p t??n c??ng tr??nh");
			txtTenCT.selectAll();
			txtTenCT.requestFocus();
			return false;
		}
	
		if (!(txtTenCT.getText().trim().matches("\\p{L}+(\\s\\p{L}+)*"))) {
			JOptionPane.showMessageDialog(this, "T??n c??ng tr??nh kh??ng ???????c ph??p c?? c??c k?? t??? ?????c bi???t");
			txtTenCT.selectAll();
			txtTenCT.requestFocus();
			return false;
		}
		if (cbLoaiCT.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "M???i ch???n lo???i c??ng tr??nh");
			return false;
		}

		if (ngayKhoiCong.getDate() == null) {
			JOptionPane.showMessageDialog(this, "M???i ch???n ng??y kh???i c??ng");
			return false;
		}
		Date dateNow = new Date();
		if (btn == btnThemCT) {
			if (ngayKhoiCong.getDate().before(dateNow)) {
				JOptionPane.showMessageDialog(this, "Ng??y kh???i c??ng ph???i sau ng??y hi???n t???i");
				return false;
			}
		}
		if (ngayDKHoanThanh.getDate() == null) {
			JOptionPane.showMessageDialog(this, "M???i ch???n ng??y d??? ki???n ho??n th??nh");
			return false;
		}
		if (ngayDKHoanThanh.getDate().before(ngayKhoiCong.getDate())) {
			JOptionPane.showMessageDialog(this, "Ng??y ho??n th??nh ph???i sau ng??y kh???i c??ng");
			return false;
		}
		if (cbTinhTP.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "M???i ch???n T???nh/th??nh ph???");
			return false;
		}
		if (cbQuanHuyen.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "M???i ch???n Qu???n/huy???n");
			return false;
		}
		if (cbPhuongXa.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "M???i ch???n Ph?????ng/x??");
			return false;
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableCT.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "Kh??ng c?? d??ng n??o ???????c ch???n!");
		}else {
			txtMaCT.setText(model.getValueAt(row, 0).toString());
			txtTenCT.setText(model.getValueAt(row, 1).toString());
			cbLoaiCT.setSelectedItem(model.getValueAt(row, 2));
			cbTrangThai.setSelectedItem(listCongTrinh.get(row).getTrangThai());
			try {
				Date ngayKC = new SimpleDateFormat("dd/MM/yyyy").parse(model.getValueAt(row, 4).toString());
				Date ngayDKHT = new SimpleDateFormat("dd/MM/yyyy").parse(model.getValueAt(row, 5).toString());
				ngayKhoiCong.setDate(ngayKC);
				ngayDKHoanThanh.setDate(ngayDKHT);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String diaChi[] = model.getValueAt(row, 3).toString().split(", ");
			cbTinhTP.setSelectedItem(diaChi[2]);
			cbQuanHuyen.setSelectedItem(diaChi[1]);
			cbPhuongXa.setSelectedItem(diaChi[0]);

			cbTrangThai.setEnabled(true);
		}
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
	public void itemStateChanged(ItemEvent e) {
		Object o = e.getSource();
		if (o == cbTinhTP) {
			for (int i = cbQuanHuyen.getItemCount() - 1; i > 0; i--)
				cbQuanHuyen.removeItemAt(i);
			ArrayList<String> listQuan = diaChiDao.getQuanHuyen(cbTinhTP.getSelectedItem().toString().trim());
			for (String quan : listQuan) {
				cbQuanHuyen.addItem(quan);
			}
		}

		if (o == cbQuanHuyen) {
			for (int i = cbPhuongXa.getItemCount() - 1; i > 0; i--)
				cbPhuongXa.removeItemAt(i);
			ArrayList<String> listPhuong = diaChiDao.getPhuongXa(cbTinhTP.getSelectedItem().toString().trim(),
					cbQuanHuyen.getSelectedItem().toString().trim());
			for (String phuong : listPhuong) {
				cbPhuongXa.addItem(phuong.trim());
			}
		}

	}
}
