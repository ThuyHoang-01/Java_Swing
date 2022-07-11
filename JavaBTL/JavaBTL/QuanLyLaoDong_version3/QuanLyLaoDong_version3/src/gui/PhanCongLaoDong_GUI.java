package gui;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.text.TabExpander;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import dao.ChiTietCV_DAO;
import dao.ChuyenMon_DAO;
import dao.PhanCongLaoDong_DAO;
import dao.QLCongViec_DAO;
import dao.QuanLyCongTrinh_DAO;
import dao.QuanLyLaoDong_DAO;
import dao.ThongTinLaoDong_DAO;
import entity.ChiTietCV;
import entity.ChuyenMon;
import entity.CongTrinh;
import entity.CongViec;
import entity.LaoDong;
import entity.QuanLy;
import javax.swing.JTextPane;

public class PhanCongLaoDong_GUI extends JPanel implements ActionListener, ItemListener, MouseListener, KeyListener {
	private JTable tablePC;
	private JTable tableLD;
	private JTable tableCT;
	private JButton btnLamMoi;
	private JButton btnPhanCong;
	private JComboBox cbChuyenMon;
	private JPanel panelPC;
	private DefaultTableModel modelCT;
	private JProgressBar progressBar;
	private boolean kiemTraCbo = true;
	private ChiTietCV_DAO chiTietCongViecDAO = new ChiTietCV_DAO();
	private QuanLyCongTrinh_DAO congTrinhDAO = new QuanLyCongTrinh_DAO();
	private ArrayList<LaoDong> listLaoDong = new ArrayList<LaoDong>();
	private PhanCongLaoDong_DAO phanCongDAO = new PhanCongLaoDong_DAO();
	private QuanLyLaoDong_DAO laoDong_DAO = new QuanLyLaoDong_DAO();
	private ArrayList<CongTrinh> listCT = congTrinhDAO.getAllCongTrinh();
	private ArrayList<ChuyenMon> listCM = new ChuyenMon_DAO().getAllChuyenMon();
	private JDateChooser ngayThucHien;
	private JDateChooser ngayThucHienCV;
	private JDateChooser ngayHoanThanhCV;
	private ArrayList<CongViec> listCV = new QLCongViec_DAO().getCongViec();
	private ArrayList<ChiTietCV> listCTCV = new ArrayList<>();
	private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private JComboBox<String> cbCongViec;
	private JComboBox<String> cboCongTrinh; 
	private JLabel lblThem;
	private JLabel lblXoa;
	private JTextField txtTimTenCongTrinh;
	private JTextField txtTimMaLD;
	private JTextField txtMaCongTrinh;
	private DefaultTableModel modelPC;
	private DefaultTableModel modelLD;
	private	ArrayList<LaoDong> listPhanCong = new ArrayList<>();
	private JTextPane txtNgayKhoiCong;
	private JTextPane txtNgayDKHoanThanh;
	private QuanLy quanLy;

	public PhanCongLaoDong_GUI(QuanLy quanLy) {
		this.quanLy = quanLy;
		setLocation(0, 13);
		setLayout(null);
		setSize(1284, 555);

		JPanel panelCT = new JPanel();
		panelCT.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)), "Công Trình", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCT.setBounds(10, 11, 410, 533);
		add(panelCT);
		panelCT.setLayout(null);

		JPanel panelCT_TimKiem = new JPanel();
		panelCT_TimKiem.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255)), "Tìm kiếm",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCT_TimKiem.setBounds(10, 95, 390, 114);
		panelCT.add(panelCT_TimKiem);
		panelCT_TimKiem.setLayout(null);
		//
		String[] colHeaderCT = { "Tên công trình" };
		modelCT = new DefaultTableModel(colHeaderCT, 0) {
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

		JLabel lblMaCT = new JLabel("Mã Công Trình :");
		lblMaCT.setBounds(10, 21, 145, 30);
		panelCT_TimKiem.add(lblMaCT);
		lblMaCT.setFont(new Font("Dialog", Font.BOLD, 16));

		cboCongTrinh = new JComboBox<String>();
		cboCongTrinh.setBounds(153, 24, 216, 30);
		panelCT_TimKiem.add(cboCongTrinh);
		cboCongTrinh.addItem("Tất cả");
		for(CongTrinh ct : listCT) {
			cboCongTrinh.addItem(ct.getMaCongTrinh());
		}
		
		JLabel lblTnCngTrnh = new JLabel("Tên Công Trình:");
		lblTnCngTrnh.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTnCngTrnh.setBounds(10, 66, 132, 30);
		panelCT_TimKiem.add(lblTnCngTrnh);

		txtTimTenCongTrinh = new JTextField();
		txtTimTenCongTrinh.setBounds(153, 69, 216, 30);
		panelCT_TimKiem.add(txtTimTenCongTrinh);
		txtTimTenCongTrinh.setColumns(10);

		JLabel lblNgyKhiCng = new JLabel("Ngày Khởi Công:");
		lblNgyKhiCng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgyKhiCng.setBounds(39, 15, 117, 30);
		panelCT.add(lblNgyKhiCng);

		txtNgayKhoiCong = new JTextPane();
		txtNgayKhoiCong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNgayKhoiCong.setEditable(false);
		txtNgayKhoiCong.setBounds(205, 15, 175, 30);
		panelCT.add(txtNgayKhoiCong);

		JLabel lblNgyDkHon = new JLabel("Ngày DK Hoàn Thành:");
		lblNgyDkHon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgyDkHon.setBounds(39, 54, 164, 30);
		panelCT.add(lblNgyDkHon);

		txtNgayDKHoanThanh = new JTextPane();
		txtNgayDKHoanThanh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNgayDKHoanThanh.setEditable(false);
		txtNgayDKHoanThanh.setBounds(205, 54, 175, 30);
		panelCT.add(txtNgayDKHoanThanh);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 220, 390, 302);
		panelCT.add(scrollPane);
		tableCT = new JTable(modelCT){
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
		    {
		        Component c = super.prepareRenderer(renderer, row, column);

		        //  Alternate row color

		        if (!isRowSelected(row))
		            c.setBackground(row % 2 == 0 ? getBackground() : SystemColor.menu);

		        return c;
		    }
		};
		tableCT.setBackground(Color.WHITE);
		tableCT.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tableCT.getColumnModel().getColumn(0).setPreferredWidth(200);
		scrollPane.setViewportView(tableCT);
		tableCT.setRowHeight(tableCT.getRowHeight() + 20);

		JTableHeader h2 = tableCT.getTableHeader();
		tableCT.addMouseListener(this);
		h2.setForeground(new Color(31, 39, 191));
		h2.setBackground(new Color(116, 235, 52));
		docDuLieuVaoModelCT();
		//
		panelPC = new JPanel();
		panelPC.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)), "Ph\u00E2n C\u00F4ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPC.setBounds(850, 11, 424, 533);
		add(panelPC);
		panelPC.setLayout(null);

		JLabel lblNgayTH = new JLabel("Ngày Thực Hiện :");
		lblNgayTH.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNgayTH.setBounds(37, 103, 139, 30);
		panelPC.add(lblNgayTH);
		ngayThucHien = new JDateChooser();

		JLabel lblNgayHT = new JLabel("Ngày Hoàn Thành :");
		lblNgayHT.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNgayHT.setBounds(36, 144, 154, 30);
		panelPC.add(lblNgayHT);

		JPanel panelPC_CV = new JPanel();
		panelPC_CV.setLayout(null);
		panelPC_CV.setBounds(10, 226, 404, 296);
		panelPC.add(panelPC_CV);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 404, 390);
		panelPC_CV.add(scrollPane_1);

		String[] colHeaderPC = { "Mã Lao Động", "Tên Lao Động" };
		modelPC = new DefaultTableModel(colHeaderPC, 0) {
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
		tablePC = new JTable(modelPC){
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
		    {
		        Component c = super.prepareRenderer(renderer, row, column);

		        //  Alternate row color

		        if (!isRowSelected(row))
		            c.setBackground(row % 2 == 0 ? getBackground() : SystemColor.menu);

		        return c;
		    }
		};
		tablePC.setBackground(Color.WHITE);
		tablePC.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tablePC.getColumnModel().getColumn(1).setPreferredWidth(200);
		scrollPane_1.setViewportView(tablePC);
		tablePC.setRowHeight(tablePC.getRowHeight() + 20);

		tablePC.getColumnModel().getColumn(0).setPreferredWidth(80);
		tablePC.getColumnModel().getColumn(1).setPreferredWidth(200);

		JTableHeader h = tablePC.getTableHeader();
		h.setForeground(new Color(31, 39, 191));
		h.setBackground(new Color(116, 235, 52));

		ngayThucHienCV = new JDateChooser();
		ngayThucHienCV.setBounds(186, 103, 200, 30);
		panelPC.add(ngayThucHienCV);

		ngayThucHienCV.setDateFormatString("dd/MM/yyyy");

		ngayHoanThanhCV = new JDateChooser();
		ngayHoanThanhCV.setBounds(186, 144, 200, 30);
		panelPC.add(ngayHoanThanhCV);

		ngayHoanThanhCV.setDateFormatString("dd/MM/yyyy");

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoi.setBounds(96, 185, 117, 34);
		panelPC.add(btnLamMoi);
		btnLamMoi.setBackground(Color.WHITE);

		btnPhanCong = new JButton("Phân Công");
		btnPhanCong.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPhanCong.setBounds(255, 185, 117, 34);
		panelPC.add(btnPhanCong);
		btnPhanCong.setBackground(Color.WHITE);

		lblXoa = new JLabel("");
		lblXoa.setBounds(10, 178, 32, 37);
		panelPC.add(lblXoa);

		cbCongViec = new JComboBox<String>();
		cbCongViec.setBounds(186, 65, 200, 30);
		panelPC.add(cbCongViec);
		for (CongViec c : listCV) {
			cbCongViec.addItem(c.getTenCongViec());
		}
		
		JLabel lblCongViec = new JLabel("Công Việc:");
		lblCongViec.setBounds(38, 62, 113, 30);
		panelPC.add(lblCongViec);
		lblCongViec.setFont(new Font("Dialog", Font.BOLD, 16));

		JLabel lblMCngTrnh = new JLabel("Mã Công Trình:");
		lblMCngTrnh.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMCngTrnh.setBounds(36, 21, 128, 30);
		panelPC.add(lblMCngTrnh);

		txtMaCongTrinh = new JTextField();
		txtMaCongTrinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaCongTrinh.setEditable(false);
		txtMaCongTrinh.setBounds(186, 24, 198, 30);
		panelPC.add(txtMaCongTrinh);
		txtMaCongTrinh.setColumns(10);
		

		JPanel panelCV = new JPanel();
		panelCV.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)), "Lao \u0110\u1ED9ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCV.setBounds(430, 11, 410, 533);
		add(panelCV);
		panelCV.setLayout(null);
		String[] colHeaderLD = { "Mã Lao Động", "Tên Lao Động" };
		modelLD = new DefaultTableModel(colHeaderLD, 0) {
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

		lblThem = new JLabel("");
		lblThem.setBackground(Color.LIGHT_GRAY);
		lblThem.setBounds(368, 178, 32, 37);
		panelCV.add(lblThem);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255)), "T\u00ECm ki\u1EBFm",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 35, 366, 112);
		panelCV.add(panel);
		panel.setLayout(null);

		JLabel lblChuyenMon = new JLabel("Chuyên Môn:");
		lblChuyenMon.setBounds(10, 19, 113, 30);
		panel.add(lblChuyenMon);
		lblChuyenMon.setFont(new Font("Dialog", Font.BOLD, 16));

		cbChuyenMon = new JComboBox<String>();
		cbChuyenMon.setBounds(148, 19, 210, 30);
		panel.add(cbChuyenMon);
		cbChuyenMon.addItem("Tất cả");
		for (ChuyenMon cm : listCM) {
			cbChuyenMon.addItem(cm.getTenChuyenMon());
		}

		JLabel lblMLaong = new JLabel("Mã Lao Động:");
		lblMLaong.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMLaong.setBounds(10, 60, 113, 30);
		panel.add(lblMLaong);

		txtTimMaLD = new JTextField();
		txtTimMaLD.setBounds(148, 63, 211, 30);
		panel.add(txtTimMaLD);
		txtTimMaLD.setColumns(10);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 226, 390, 296);
		panelCV.add(scrollPane_2);
		tableLD = new JTable(modelLD){
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
		    {
		        Component c = super.prepareRenderer(renderer, row, column);

		        //  Alternate row color

		        if (!isRowSelected(row))
		            c.setBackground(row % 2 == 0 ? getBackground() : SystemColor.menu);

		        return c;
		    }
		};
		tableLD.setBackground(Color.WHITE);
		tableLD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tableLD.getColumnModel().getColumn(1).setPreferredWidth(200);
		scrollPane_2.setViewportView(tableLD);
		tableLD.setRowHeight(tableLD.getRowHeight() + 20);

		JTableHeader h1 = tableLD.getTableHeader();
		h1.setForeground(new Color(31, 39, 191));
		h1.setBackground(new Color(116, 235, 52));
		docDuLieuVaomodelLD();
		// Đăng kí lắng nghe
		btnLamMoi.addActionListener(this);
		cbCongViec.addItemListener(this);
		btnPhanCong.addActionListener(this);
		tableLD.addMouseListener(this);
		cbChuyenMon.addItemListener(this);
		cboCongTrinh.addItemListener(this);
		tablePC.addMouseListener(this);
		lblThem.addMouseListener(this);
		lblXoa.addMouseListener(this);
		txtTimTenCongTrinh.addKeyListener(this);
		txtTimMaLD.addKeyListener(this);
	}

	/////////////////////////////////

	public void docDuLieuVaomodelLD() {
		listLaoDong = laoDong_DAO.getAllLaoDongTheoTrangThai();
		for (LaoDong ld : listLaoDong) {
					modelLD.addRow(new Object[] { ld.getMaLaoDong(), ld.getTenLaoDong() });
		}
	}

	public void docDuLieuVaoModelLDTheoChuyenMon(String maChuyenMon) {
		listLaoDong = laoDong_DAO.getLaoDongTheoChuyenMonVaTrangThai(maChuyenMon);
		for (LaoDong ld : listLaoDong) {
			modelLD.addRow(new Object[] { ld.getMaLaoDong(), ld.getTenLaoDong() });
		}
	}

	public void docDuLieuVaoModelCT() {
		listCT = congTrinhDAO.getAllCongTrinh();
		for (CongTrinh congTrinh : listCT) {
			modelCT.addRow(new Object[] { congTrinh.gettenCongTrinh() });
		}
	}
	public void docDuLieuVaoModalPC() {
		for (LaoDong ld : listPhanCong) {
			modelPC.addRow(new Object[] { ld.getMaLaoDong(), ld.getTenLaoDong() });
		}
	}
	public void xoaSachModel() {
		try {
			for (int i = listCT.size() - 1; i >= 0; i--)
				modelCT.removeRow(i);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void xoaSachModelLD() {
		try {
			for (int i = listLaoDong.size() - 1; i >= 0; i--)
				modelLD.removeRow(i);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void xoaSachModelPC() {
		try {
			for (int i = listPhanCong.size() - 1; i >= 0; i--)
				modelPC.removeRow(i);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public boolean kiemTra() {
		int row = tableCT.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn công trình");
			return false;
		}
		if (listPhanCong.size() == 0) {
			JOptionPane.showMessageDialog(this,"Vui lòng chọn lao động cần phân công");
			return false;
		}
		if (ngayThucHienCV.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày thực hiện");
			return false;
		}
		Date dateNow = new Date();
		
		if (ngayThucHienCV.getDate().before(dateNow))
		{
			JOptionPane.showMessageDialog(this,"Ngày thực hiện phải sau ngày hiện tại");
			return false;
		}
		if (ngayHoanThanhCV.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày hoàn thành");
			return false;
		}
		if(ngayThucHienCV.getDate().after(ngayHoanThanhCV.getDate())) {
			JOptionPane.showMessageDialog(this,"Ngày thực hiện phải trước ngày hoàn thành");
			return false;
		}
		
		return true;
	}
	public void clearALL() {
		cbChuyenMon.setSelectedIndex(0);
		txtMaCongTrinh.setText("");
		txtNgayKhoiCong.setText("");
		txtNgayDKHoanThanh.setText("");
		tableCT.clearSelection();
		tableLD.clearSelection();
		xoaSachModelPC();
		txtTimTenCongTrinh.setText("");
		txtTimMaLD.setText("");
		ngayThucHienCV.setDate(null);
		ngayHoanThanhCV.setDate(null);
		cboCongTrinh.setSelectedIndex(0);
		cbCongViec.setSelectedIndex(0);
		tableCT.setEnabled(true);
		cboCongTrinh.setEnabled(true);
		txtTimTenCongTrinh.setEnabled(true);
		
	}
	public void reload() {
		xoaSachModel();
		docDuLieuVaoModelCT();
		cboCongTrinh.removeAllItems();
		cboCongTrinh.addItem("Tất cả");
		for(CongTrinh ct : listCT) {
			cboCongTrinh.addItem(ct.getMaCongTrinh());
		}
		xoaSachModelLD();
		docDuLieuVaomodelLD();
		
	}
	//////////////////////////////////////////

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
		Object o = e.getSource();
		if(o == txtTimTenCongTrinh) {
			cboCongTrinh.setSelectedIndex(0);
			xoaSachModel();
			listCT = null;
			listCT = congTrinhDAO.timKiemCongTrinh("",txtTimTenCongTrinh.getText().trim());
			try {
				for(CongTrinh ct : listCT) {
					modelCT.addRow(new Object[] {
							ct.gettenCongTrinh()
					});
				}
			}catch (Exception e2) {
				// TODO: handle exception
			}
		}
		if(o == txtTimMaLD) {
			cbChuyenMon.setSelectedIndex(0);
			xoaSachModelLD();
			listLaoDong = null;
			listLaoDong = laoDong_DAO.timKiemLaoDongConLam(txtTimMaLD.getText().trim(), " ");
			try {
				for(LaoDong ld : listLaoDong) {
					modelLD.addRow(new Object[] {
							ld.getMaLaoDong(),ld.getTenLaoDong()
					});
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

	@Override
	public void mouseClicked(MouseEvent e) {

		Object o = e.getSource();
		int rowCT = tableCT.getSelectedRow();
		int rowLD = tableLD.getSelectedRow();
		int rowPC = tablePC.getSelectedRow();
		if(o == tableCT) {
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
			String ngayKC = formatDate.format(listCT.get(rowCT).getNgayKhoiCong().getTime());
			txtNgayKhoiCong.setText(ngayKC);
			String ngayDKHT = formatDate.format(listCT.get(rowCT).getNgayDKHoanThanh().getTime());
			txtNgayDKHoanThanh.setText(ngayDKHT);
		}
		if (o == tableCT) {
			String maCongTrinh = listCT.get(rowCT).getMaCongTrinh().trim();
			txtMaCongTrinh.setText(maCongTrinh);
		}
		if (o==lblThem) {
			if(tableCT.getSelectedRow()!=-1) {
				if (rowLD == -1)
					JOptionPane.showMessageDialog(this, "Vui lòng chọn lao động cần thêm");
				else {
					CongViec cv = listCV.get(cbCongViec.getSelectedIndex());
					CongTrinh ct = listCT.get(tableCT.getSelectedRow());
					LaoDong ld = listLaoDong.get(rowLD);
					if (phanCongDAO.kiemTraTrungLich(ct,cv,ld)) {
						xoaSachModelPC();
						listPhanCong.add(listLaoDong.get(rowLD));
						docDuLieuVaoModalPC();
						listLaoDong.remove(rowLD);
						modelLD.removeRow(rowLD);
						if(listPhanCong.size() > 0) {
							tableCT.setEnabled(false);
							cboCongTrinh.setEnabled(false);
							txtTimTenCongTrinh.setEnabled(false);
						}
					}
					else
						JOptionPane.showMessageDialog(this,"Lao động này bị trùng lịch");
				}
			}
			else
				JOptionPane.showMessageDialog(this,"Vui lòng chọn công trình trước khi chọn lao động");
		}
		if (o == lblXoa) {
			if (rowPC==-1)
				JOptionPane.showMessageDialog(this, "Vui lòng chọn lao động cần xóa");
			else {
				xoaSachModelPC();
				listLaoDong.add(listPhanCong.get(rowPC));
				modelLD.addRow(new Object[] {listPhanCong.get(rowPC).getMaLaoDong(),listPhanCong.get(rowPC).getTenLaoDong()});
				listPhanCong.remove(rowPC);
				docDuLieuVaoModalPC();
				if(listPhanCong.size() == 0) {
					tableCT.setEnabled(true);
					cboCongTrinh.setEnabled(true);
					txtTimTenCongTrinh.setEnabled(true);
				}
			}
		}

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
	public void itemStateChanged(ItemEvent arg0) {
		Object o = arg0.getSource();
		if (o == cbChuyenMon) {
			txtTimMaLD.setText("");
			xoaSachModelLD();
			if (cbChuyenMon.getSelectedIndex() > 0) {
				String maChuyenMon = listCM.get(cbChuyenMon.getSelectedIndex() - 1).getMaChuyenMon();
				docDuLieuVaoModelLDTheoChuyenMon(maChuyenMon);
			} else
				docDuLieuVaomodelLD();
		}
		if(o == cboCongTrinh) {
			txtTimTenCongTrinh.setText("");
			xoaSachModel();
			if(cboCongTrinh.getSelectedIndex() > 0) {
				String maCongTrinh = cboCongTrinh.getSelectedItem().toString().trim();
				listCT = new ArrayList<CongTrinh>();
				listCT.add(congTrinhDAO.getCTTheoMa(maCongTrinh));
				for (CongTrinh congTrinh : listCT) {
					modelCT.addRow(new Object[] { congTrinh.gettenCongTrinh() });
				}
			}else {
				docDuLieuVaoModelCT();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnLamMoi) {
			clearALL();
		}
		if (o == btnPhanCong) {
			if (kiemTra()) {
				SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
				String date[] = formatDate.format(ngayThucHienCV.getDate()).split("-");
				java.sql.Date ngayThucHien = new java.sql.Date(Integer.parseInt(date[0])-1900, Integer.parseInt(date[1])-1,
						Integer.parseInt(date[2]));
				date = formatDate.format(ngayHoanThanhCV.getDate()).split("-");
				java.sql.Date ngayHoanThanh = new java.sql.Date(Integer.parseInt(date[0])-1900, Integer.parseInt(date[1])-1,
						Integer.parseInt(date[2]));
				CongViec cv = listCV.get(cbCongViec.getSelectedIndex());
				CongTrinh ct = listCT.get(tableCT.getSelectedRow());
				int kt = JOptionPane.showConfirmDialog(null, "Bạn muốn phân công ?", "Thông báo",JOptionPane.YES_NO_OPTION);
				if (kt == JOptionPane.YES_OPTION) {
					for (LaoDong ld : listPhanCong) {
						ChiTietCV ctcv = new ChiTietCV(ct, cv, ld, ngayThucHien, ngayHoanThanh, false, quanLy);
						phanCongDAO.phanCongCongViec(ctcv);
					}
					JOptionPane.showMessageDialog(this,"Phân công thành công !");
					clearALL();
					listPhanCong = new ArrayList<LaoDong>();
				}
				
			}
		}

	}
}
