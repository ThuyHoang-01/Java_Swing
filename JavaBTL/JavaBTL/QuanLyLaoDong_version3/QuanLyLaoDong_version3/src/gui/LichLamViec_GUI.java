package gui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.toedter.calendar.JDateChooser;
import dao.ChiTietCV_DAO;
import dao.LichLamViec_DAO;
import dao.PhanCongLaoDong_DAO;
import dao.QuanLyCongTrinh_DAO;
import dao.QuanLyLaoDong_DAO;
import entity.ChiTietCV;
import entity.CongTrinh;
import entity.CongViec;
import entity.LaoDong;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;

public class LichLamViec_GUI extends JPanel implements ActionListener, MouseListener, ItemListener, KeyListener {
	private JTextField txtTenCT;
	private JTextField txtTenLD;
	private JTextField txtLDCT;
	private JButton btnLamMoi;
	private JComboBox cbMaCongTrinh;
	private JScrollPane scrollPaneCongTrinh;
	private JScrollPane scrollPaneLaoDong;
	private JScrollPane scrollPaneCongViec;
	private JTable tableCongTrinh;
	private JTable tableLaoDong;
	private JTable tableChiTiet;
	private DefaultTableModel modelCongTrinh;
	private DefaultTableModel modelLaoDong;
	private DefaultTableModel modelChiTiet;
	private ArrayList<CongTrinh> listCongTrinh;
	private ArrayList<LaoDong> listLD;
	private ArrayList<ChiTietCV> dsChiTietCV;
	private ArrayList<CongViec> listCV = new ArrayList<CongViec>();
	private ChiTietCV_DAO chiTietDAO = new ChiTietCV_DAO();
	private QuanLyCongTrinh_DAO quanLyCongTrinh_Dao = new QuanLyCongTrinh_DAO();
	private QuanLyLaoDong_DAO quanLyLaoDong_Dao = new QuanLyLaoDong_DAO();
	private LichLamViec_DAO lichLamViec_DAO = new LichLamViec_DAO();
	private JTextField txtMaLaoDong;

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public LichLamViec_GUI() {
		setBackground(Color.LIGHT_GRAY);
		setBorder(new LineBorder(Color.RED));
		setLocation(0, 13);
		setLayout(null);
		setSize(1284, 554);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Công trình", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 360, 547);
		panel.setLayout(null);

		JLabel tenCongTrinh = new JLabel("Tên CT:");
		tenCongTrinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		tenCongTrinh.setBounds(15, 66, 72, 30);
		panel.add(tenCongTrinh);

		txtTenCT = new JTextField();
		txtTenCT.setBounds(94, 66, 251, 30);
		panel.add(txtTenCT);
		txtTenCT.setColumns(10);

		scrollPaneCongTrinh = new JScrollPane();
		scrollPaneCongTrinh.setEnabled(false);
		scrollPaneCongTrinh.setBounds(6, 124, 350, 418);
		panel.add(scrollPaneCongTrinh);

		Object[] title = { "Tên công trình" };
		modelCongTrinh = new DefaultTableModel(title, 0) {
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
		// table Cong Trinh
		tableCongTrinh = new JTable(modelCongTrinh);
		scrollPaneCongTrinh.setViewportView(tableCongTrinh);

		tableCongTrinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tableCongTrinh.setRowHeight(tableCongTrinh.getRowHeight() + 20);
		tableCongTrinh.getColumnModel().setColumnMargin(3);
		// dua du lieu vao table Cong Trinh
		docDuLieuVaoTBCT();

		JTableHeader h = tableCongTrinh.getTableHeader();
		h.setForeground(new Color(31, 39, 191));
		h.setFont(new Font("Arial", Font.BOLD, 15));
		h.setBackground(new Color(116, 235, 52));

		JPanel JlableLDCT = new JPanel();
		JlableLDCT.setForeground(Color.WHITE);
		JlableLDCT.setBackground(Color.LIGHT_GRAY);
		JlableLDCT.setBorder(new TitledBorder(null, "Chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JlableLDCT.setBounds(636, 0, 648, 544);
		JlableLDCT.setLayout(null);

		scrollPaneCongViec = new JScrollPane();
		scrollPaneCongViec.setBounds(6, 122, 642, 422);
		JlableLDCT.add(scrollPaneCongViec);

		add(panel);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)), "Tìm kiếm", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_3.setBounds(6, 21, 350, 86);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lbCongTrinh;
		lbCongTrinh = new JLabel("Mã CT:");
		lbCongTrinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbCongTrinh.setBounds(15, 16, 80, 31);
		panel_3.add(lbCongTrinh);

		cbMaCongTrinh = new JComboBox();
		cbMaCongTrinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbMaCongTrinh.setBounds(88, 12, 179, 30);
		cbMaCongTrinh.addItem("Tất cả");
		listCongTrinh = quanLyCongTrinh_Dao.getAllCongTrinh();
		// lay toan bo maCongTrinh
		for (CongTrinh congTrinh : listCongTrinh) {
			cbMaCongTrinh.addItem(congTrinh.getMaCongTrinh());
		}

		panel_3.add(cbMaCongTrinh);
		add(JlableLDCT);

		Object[] title2 = { "Lao động/Công trình", "Công việc", "Ngày thực hiện", "Ngày hoàn thành" };
		modelChiTiet = new DefaultTableModel(title2, 0) {
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
		// table Chi Tiet CongViec/LaoDong
		tableChiTiet = new JTable(modelChiTiet);
		scrollPaneCongViec.setViewportView(tableChiTiet);

		tableChiTiet.setRowHeight(tableChiTiet.getRowHeight() + 20);
		tableChiTiet.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		tableChiTiet.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableChiTiet.getColumnModel().setColumnMargin(3);

		JLabel lbCongTrinh_1 = new JLabel("Lao động/Công Trình:");
		lbCongTrinh_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbCongTrinh_1.setBounds(15, 33, 178, 30);
		JlableLDCT.add(lbCongTrinh_1);

		txtLDCT = new JTextField();
		txtLDCT.setEditable(false);
		txtLDCT.setEnabled(false);
		txtLDCT.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtLDCT.setBounds(35, 68, 565, 31);
		JlableLDCT.add(txtLDCT);
		txtLDCT.setColumns(10);

		// button
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLamMoi.setBounds(469, 28, 128, 35);
		JlableLDCT.add(btnLamMoi);

		JTableHeader h2 = tableChiTiet.getTableHeader();
		h2.setForeground(new Color(31, 39, 191));
		h2.setFont(new Font("Arial", Font.BOLD, 15));
		h2.setBackground(new Color(116, 235, 52));

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new TitledBorder(null, "Lao động", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(362, 0, 272, 546);
		add(panel_2);
		panel_2.setLayout(null);

		scrollPaneLaoDong = new JScrollPane();
		scrollPaneLaoDong.setBounds(2, 122, 270, 421);
		panel_2.add(scrollPaneLaoDong);

		Object[] title3 = { "Tên lao động" };
		modelLaoDong = new DefaultTableModel(title3, 0) {
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
		// table Lao Dong (tenLaoDong)
		tableLaoDong = new JTable(modelLaoDong);
		scrollPaneLaoDong.setViewportView(tableLaoDong);

		tableLaoDong.setRowHeight(tableLaoDong.getRowHeight() + 20);
		tableLaoDong.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		JLabel tenLaoDong = new JLabel("Tên:");
		tenLaoDong.setBounds(9, 69, 41, 30);
		panel_2.add(tenLaoDong);
		tenLaoDong.setFont(new Font("Tahoma", Font.BOLD, 16));

		txtTenLD = new JTextField();
		txtTenLD.setBounds(44, 69, 219, 30);
		panel_2.add(txtTenLD);
		txtTenLD.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)), "Tìm kiếm", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_4.setBounds(6, 52, 264, 61);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel lbMaLaoDong = new JLabel("Mã LD:");
		lbMaLaoDong.setBounds(15, 23, 63, 30);
		panel_2.add(lbMaLaoDong);
		lbMaLaoDong.setFont(new Font("Tahoma", Font.BOLD, 16));

		txtMaLaoDong = new JTextField();
		txtMaLaoDong.setBounds(77, 23, 135, 30);
		panel_2.add(txtMaLaoDong);
		txtMaLaoDong.setEnabled(false);
		txtMaLaoDong.setEditable(false);
		txtMaLaoDong.setColumns(10);
		txtMaLaoDong.enable(false);
		txtMaLaoDong.addKeyListener(this);

		JTableHeader hl = tableLaoDong.getTableHeader();
		hl.setForeground(new Color(31, 39, 191));
		hl.setFont(new Font("Arial", Font.BOLD, 15));
		hl.setBackground(new Color(116, 235, 52));
		docDuLieuVaoTBLD();

		tableCongTrinh.addMouseListener(this);
		tableChiTiet.addMouseListener(this);
		tableLaoDong.addMouseListener(this);

		txtTenCT.addKeyListener(this);
		txtTenLD.addKeyListener(this);
		btnLamMoi.addActionListener(this);
		cbMaCongTrinh.addItemListener(this);
	}

	public void xoaRong() {
		cbMaCongTrinh.setSelectedIndex(0);
		txtTenCT.setText("");
		txtTenLD.setText("");
		txtLDCT.setText("");
		txtMaLaoDong.setText("");
		tableCongTrinh.clearSelection();
		tableLaoDong.clearSelection();
		tableChiTiet.clearSelection();
		xoaAllModel();
		xoaAllmodelLD();
		xoaAllmodelChiTiet();
		docDuLieuVaoTBCT();
		docDuLieuVaoTBLD();
	}

	public void docDuLieuVaoTBCT() {
		listCongTrinh = quanLyCongTrinh_Dao.getAllCongTrinh();
		for (CongTrinh congTrinh : listCongTrinh) {
			modelCongTrinh.addRow(new Object[] { congTrinh.gettenCongTrinh() });
		}
	}

	public void docDLvaoTBCTTheoMa(String maCT) {
		listCongTrinh = quanLyCongTrinh_Dao.timKiemCongTrinh(maCT, "");
		for (CongTrinh ct : listCongTrinh) {
			modelCongTrinh.addRow(new Object[] { ct.gettenCongTrinh() });
		}

	}

	public void docDuLieuVaoTBLD() {
		listLD = quanLyLaoDong_Dao.getAllLaoDong();
		for (LaoDong ld : listLD) {
			modelLaoDong.addRow(new Object[] { ld.getTenLaoDong() });
		}
	}

	public void docDuLieuVaoTBChiTietTheoCongTrinh(String maCT) {
		dsChiTietCV = lichLamViec_DAO.getLichLamViecTheoCongTrinh(maCT);
		for (ChiTietCV ctcv : dsChiTietCV) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			modelChiTiet.addRow(
					new Object[] { ctcv.getLaoDong().getTenLaoDong().trim(), ctcv.getCongViec().getTenCongViec().trim(),
							format.format(ctcv.getNgayThucHien()), format.format(ctcv.getNgayHoanThanh()) });
		}
	}

	public void docDuLieuVaoTBChiTietTheoLaoDong(String maLaoDong) {
		dsChiTietCV = lichLamViec_DAO.getLichLamViecTheoLaoDong(maLaoDong);
		for (ChiTietCV ctcv : dsChiTietCV) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			modelChiTiet.addRow(new Object[] { ctcv.getCongTrinh().gettenCongTrinh().trim(),
					ctcv.getCongViec().getTenCongViec().trim(), format.format(ctcv.getNgayThucHien()),
					format.format(ctcv.getNgayHoanThanh()) });
		}
	}

	public void reload() {
		cbMaCongTrinh.removeAllItems();
		cbMaCongTrinh.addItem("Tất cả");
		xoaRong();
		for (CongTrinh congTrinh : listCongTrinh) {
			cbMaCongTrinh.addItem(congTrinh.getMaCongTrinh());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btnLamMoi) {
			xoaRong();
		}
	}

	public void xoaAllModel() {
		listLD = new ArrayList<LaoDong>();
		DefaultTableModel m = (DefaultTableModel) tableCongTrinh.getModel();
		m.getDataVector().removeAllElements();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

		if (o == tableCongTrinh) {
			tableLaoDong.clearSelection();
			txtMaLaoDong.setText("");
			int rowCongTrinh = tableCongTrinh.getSelectedRow();
			try {
				String maCongTrinh = listCongTrinh.get(rowCongTrinh).getMaCongTrinh();
				xoaAllmodelChiTiet();
				docDuLieuVaoTBChiTietTheoCongTrinh(maCongTrinh);

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		if (o == tableLaoDong) {
			tableCongTrinh.clearSelection();
			int rowLaoDong = tableLaoDong.getSelectedRow();
			try {
				String maLaoDong = listLD.get(rowLaoDong).getMaLaoDong();
				xoaAllmodelChiTiet();
				docDuLieuVaoTBChiTietTheoLaoDong(maLaoDong);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		if (o == tableLaoDong) {
			int rowLaoDong = tableLaoDong.getSelectedRow();
			try {
				String maLD = listLD.get(rowLaoDong).getMaLaoDong().trim();
				txtMaLaoDong.setText(maLD);
				txtMaLaoDong.setFont(new Font("Tahoma", Font.BOLD, 15));
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		if (o == tableChiTiet) {
			int row = tableChiTiet.getSelectedRow();
			txtLDCT.setText(modelChiTiet.getValueAt(row, 0).toString());
			txtLDCT.setFont(new Font("Tahoma", Font.BOLD, 15));
		}

	}

	public void xoaAllmodelLD() {
		try {
			for (int i=listLD.size()-1; i>=0; i--)
				modelLaoDong.removeRow(i);
			listLD = null;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void xoaAllmodelChiTiet() {
		try {
			for (int i = dsChiTietCV.size() - 1; i >= 0; i--)
				modelChiTiet.removeRow(i);
			dsChiTietCV = null;
		} catch (Exception e) {
			// TODO: handle exception
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
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == cbMaCongTrinh) {
			tableCongTrinh.clearSelection();
			xoaAllModel();
			xoaAllmodelChiTiet();
			if (cbMaCongTrinh.getSelectedIndex() > 0) {
				String maCongTrinh = cbMaCongTrinh.getSelectedItem().toString().trim();
				listCongTrinh = new ArrayList<CongTrinh>();
				listCongTrinh.add(quanLyCongTrinh_Dao.getCTTheoMa(maCongTrinh));
				for (CongTrinh congTrinh : listCongTrinh) {
					modelCongTrinh.addRow(new Object[] { congTrinh.gettenCongTrinh() });
				}
				docDuLieuVaoTBChiTietTheoCongTrinh(maCongTrinh);
			} else
				docDuLieuVaoTBCT();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == txtTenCT) {
			tableCongTrinh.clearSelection();
			cbMaCongTrinh.setSelectedIndex(0);
			xoaAllModel();
			listCongTrinh = null;
			listCongTrinh = quanLyCongTrinh_Dao.timKiemCongTrinh("", txtTenCT.getText().trim());

			try {
				for (CongTrinh congtrinh : listCongTrinh) {
					modelCongTrinh.addRow(new Object[] { congtrinh.gettenCongTrinh() });
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		if (o == txtTenLD) {
			tableLaoDong.clearSelection();
			xoaAllmodelChiTiet();
			xoaAllmodelLD();
			listLD = null;
			listLD = quanLyLaoDong_Dao.timKiemLaoDong("", txtTenLD.getText().trim());
			try {
				for (LaoDong ld : listLD) {
					modelLaoDong.addRow(new Object[] { ld.getTenLaoDong() });
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
