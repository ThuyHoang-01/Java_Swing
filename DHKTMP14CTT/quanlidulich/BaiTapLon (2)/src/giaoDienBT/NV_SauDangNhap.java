package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import enTiTy.CarriageTrip;
import enTiTy.KhachHang;
import ketNoiSQL.DataBase;
import thucThi.DaoKhachHang_SauDN;
import thucThi.DaoNV_SauDN;
import thucThi.DaoThongTin;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.border.CompoundBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NV_SauDangNhap extends JFrame implements ActionListener, MouseListener, AncestorListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnXoaTrang;
	private JButton btnThoat;
	private JLabel lblMaTour;
	private JLabel lblTuyen;
	private JTextField txtMaTour;
	private JTextField txtTuyen;
	private JLabel lblMaCongTy;
	DaoKhachHang_SauDN dskh = new DaoKhachHang_SauDN();
	private JLabel lblNgayKhoiHanh;

	private JLabel lblNgayKetThuc;

	private JLabel lblTinh;
	private JTextField txtTinh;
	private JLabel lblDiaDiem;
	private JTextField txtDiaDiem;
	private JLabel lblDonGia;
	private JTextField txtDonGia;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton btnThem;
	DaoNV_SauDN dstour = new DaoNV_SauDN();
	private JButton btnXoa;
	private JPanel component6;
	private DefaultTableModel tableModel1;
	private JTable table1;
	private JButton btnXoaKH;
	private DefaultTableModel tableModel2;
	private JTable table2;
	private DefaultTableModel tableModel3;
	private JTable table3;
	private JButton btnchinhsua;
	private JTextField txtMaTour3;
	private JTextField txtTuyen3;
	private JTextField txtTinh3;
	private JTextField txtDiaDiem3;
	private JTextField txtDonGia3;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JDateChooser dateChooser_2;
	private JDateChooser dateChooser_3;
	private SimpleDateFormat df;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	
	private JTextField txttimkiem5;
	private ImageIcon im2;
	private DefaultTableModel tableModel5;
	private JTable table5;
	private JTextField txtTimKiem5;
	private JButton btnTIM;

	public NV_SauDangNhap() {
		super("Nhân Viên Sau Đăng Nhập");
		setBounds(150, 50, 1000, 700);
		setResizable(false);
		setLocation(100, 30);
		setResizable(false);

		JPanel pNorth = new JPanel();
		JLabel lbl = new JLabel();
		try {
			BufferedImage image = ImageIO.read(new File("img/menunv.png"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(1000, 289, java.awt.Image.SCALE_SMOOTH));
			lbl.setIcon(im);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pNorth.add(lbl);
		getContentPane().add(pNorth, BorderLayout.NORTH);

		JTabbedPane menu = new JTabbedPane();
		JPanel component = new JPanel();
		JPanel component1 = new JPanel();
		JPanel component2 = new JPanel();
		JPanel component3 = new JPanel();
		JPanel component4 = new JPanel();
		JPanel component5 = new JPanel();
		component6 = new JPanel();
		try {

			BufferedImage image = ImageIO.read(new File("img/them.png"));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(50, 42, java.awt.Image.SCALE_SMOOTH));
			menu.addTab("   Thêm Tour", icon, component);

			BufferedImage image1 = ImageIO.read(new File("img/xoa.png"));
			ImageIcon icon1 = new ImageIcon(image1.getScaledInstance(50, 42, java.awt.Image.SCALE_SMOOTH));
			menu.addTab("      Xóa Tour", icon1, component1);

			BufferedImage image3 = ImageIO.read(new File("img/sua.png"));
			ImageIcon icon3 = new ImageIcon(image3.getScaledInstance(50, 42, java.awt.Image.SCALE_SMOOTH));
			menu.addTab("   Chỉnh Sửa", icon3, component3);

			BufferedImage image2 = ImageIO.read(new File("img/khachhang.png"));
			ImageIcon icon2 = new ImageIcon(image2.getScaledInstance(50, 42, java.awt.Image.SCALE_SMOOTH));
			menu.addTab("  Khách Hàng", icon2, component2);

			BufferedImage image4 = ImageIO.read(new File("img/danhsach.png"));
			ImageIcon icon4 = new ImageIcon(image4.getScaledInstance(50, 42, java.awt.Image.SCALE_SMOOTH));
			menu.addTab("    Danh Sách", icon4, component4);
			
			
			BufferedImage image5 = ImageIO.read(new File("img/timkiem.png"));
			ImageIcon icon5 = new ImageIcon(image5.getScaledInstance(50, 42, java.awt.Image.SCALE_SMOOTH));
			menu.addTab("    Tìm Kiếm", icon5, component5);

			BufferedImage image6 = ImageIO.read(new File("img/dx.png"));
			ImageIcon icon6 = new ImageIcon(image6.getScaledInstance(50, 42, java.awt.Image.SCALE_SMOOTH));
			menu.addTab("   Đăng Xuất", icon6, component6);
			
			
			
		

		} catch (Exception ex) {
		}
///////////////////////////////////////////////////////////////
		Box c = Box.createVerticalBox();
		c.setBounds(10, 5, 719, 293);
		Box c1, c2, c3, c4, c5, c6, c7, c8, c9;
		c.add(c1 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c1.add(lblMaTour = new JLabel("Mã Tour: "));
		c1.add(txtMaTour = new JTextField(20));
		txtMaTour.setText("" + dstour.getid());
		txtMaTour.setEnabled(false);

		c.add(c2 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c2.add(lblTuyen = new JLabel("Tuyến: "));
		c2.add(txtTuyen = new JTextField());
		txtTuyen.setEnabled(false);

		txtTuyen.setText("Tuyến" + " " + dstour.getid());
		c.add(c3 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c3.add(lblMaCongTy = new JLabel("Mã công ty: "));
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "5", "7"}));
		c3.add(comboBox);
		c.add(c4 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));

		c4.add(lblNgayKhoiHanh = new JLabel("Ngày khởi hành: "));
		dateChooser = new JDateChooser();
		c4.add(dateChooser);
		// c4.add(txtNgayKhoiHanh = new JTextField());

		c.add(c5 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c5.add(lblNgayKetThuc = new JLabel("Ngày kết thúc: "));
		dateChooser_1 = new JDateChooser();
		c5.add(dateChooser_1);
		// c5.add(txtNgayKetThuc = new JTextField());

		c.add(c6 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c6.add(lblTinh = new JLabel("Tỉnh / Thành phố: "));
		c6.add(txtTinh = new JTextField());

		c.add(c7 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c7.add(lblDiaDiem = new JLabel("Địa điểm: "));
		c7.add(txtDiaDiem = new JTextField());

		c.add(c8 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c8.add(lblDonGia = new JLabel("Đơn giá: "));
		c8.add(txtDonGia = new JTextField());

		c.add(c9 = Box.createHorizontalBox());
		c9.add(Box.createHorizontalStrut(20));
		c9.add(btnThem = new JButton("Thêm"));
		btnThem.setBackground(Color.WHITE);
		c9.add(Box.createHorizontalStrut(20));
		c.add(Box.createVerticalStrut(20));
		c9.add(btnXoaTrang = new JButton("Xóa Trắng"));
		btnXoaTrang.setBackground(Color.WHITE);
		try {
			BufferedImage image = ImageIO.read(new File("img/xoarong.png"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
			btnXoaTrang.setIcon(im);
			BufferedImage image1 = ImageIO.read(new File("img/ok.png"));
			ImageIcon im1 = new ImageIcon(image1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
			btnThem.setIcon(im1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		lblTuyen.setPreferredSize(lblTinh.getPreferredSize());
		lblDiaDiem.setPreferredSize(lblTinh.getPreferredSize());
		lblDonGia.setPreferredSize(lblTinh.getPreferredSize());
		lblNgayKhoiHanh.setPreferredSize(lblTinh.getPreferredSize());
		lblNgayKetThuc.setPreferredSize(lblTinh.getPreferredSize());
		lblMaTour.setPreferredSize(lblTinh.getPreferredSize());
		lblMaCongTy.setPreferredSize(lblTinh.getPreferredSize());
		component.setLayout(null);
		component.add(c);
////////////////////////////////////////////////////////////////////////////////////
		component1.setSize(800, 500);
		component1.setLocation(400, 100);
		component1.setLayout(null);

		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split.setBounds(10, 5, 720, 495);
		component1.add(split);

		split.add(btnXoa = new JButton("Xóa Tour"));
		btnXoa.setBackground(Color.RED);
		btnXoa.setForeground(Color.WHITE);

		String[] headers = "Mã Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá"
				.split(";");
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scroll.setBorder(new CompoundBorder());
		split.add(scroll);

		DataBase.getInstance().connect();
		updataTableData();
//////////////////////////////////////////////////////////////////////
		component2.setSize(800, 500);
		component2.setLocation(400, 100);
		component2.setLayout(null);
		JSplitPane split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split1.setBounds(10, 5, 720, 495);
		component2.add(split1);

		split1.add(btnXoaKH = new JButton("Xóa Khách Hàng"));
		btnXoaKH.setBackground(Color.RED);
		btnXoaKH.setForeground(Color.WHITE);

		String[] headers1 = "ID;Họ Tên;Email;Số Điện Thoại;User;Password".split(";");
		tableModel1 = new DefaultTableModel(headers1, 0);
		JScrollPane scroll1 = new JScrollPane();
		scroll1.setViewportView(table1 = new JTable(tableModel1));
		table1.setRowHeight(25);
		table1.setAutoCreateRowSorter(true);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scroll1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		split1.add(scroll1);

		DataBase.getInstance().connect();
		updataTableData1();
/////////////////////////////////////////////////////////////////////
		component3.setSize(1000, 600);
		component3.setLocation(100, 30);
		component3.setLayout(null);
		JSplitPane split3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split3.setBounds(256, 11, 478, 294);
		component3.add(split3);

		String[] headers3 = "Mã Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá"
				.split(";");
		tableModel3 = new DefaultTableModel(headers3, 0);
		JScrollPane scroll3 = new JScrollPane();
		scroll3.setViewportView(table3 = new JTable(tableModel3));
		table3.setRowHeight(50);
		table3.setAutoCreateRowSorter(true);
		table3.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scroll3.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		split3.add(scroll3);

		JLabel lblNewLabel = new JLabel("Mã tour :");
		lblNewLabel.setBounds(23, 23, 68, 14);
		component3.add(lblNewLabel);

		txtMaTour3 = new JTextField();
		txtMaTour3.setEnabled(false);
		txtMaTour3.setBounds(137, 20, 109, 20);
		component3.add(txtMaTour3);
		txtMaTour3.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tuyến :");
		lblNewLabel_1.setBounds(23, 57, 46, 14);
		component3.add(lblNewLabel_1);

		txtTuyen3 = new JTextField();
		txtTuyen3.setEnabled(false);
		txtTuyen3.setBounds(137, 54, 109, 20);
		component3.add(txtTuyen3);
		txtTuyen3.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Mã công ty :");
		lblNewLabel_2.setBounds(23, 85, 68, 14);
		component3.add(lblNewLabel_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"3", "5", "7"}));
		comboBox_1.setBounds(137, 82, 109, 20);
		component3.add(comboBox_1);

		JLabel lblNewLabel_3 = new JLabel("Ngày khởi hành : ");
		lblNewLabel_3.setBounds(23, 113, 104, 14);
		component3.add(lblNewLabel_3);

		dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(137, 107, 109, 20);
		component3.add(dateChooser_2);

		JLabel lblNewLabel_4 = new JLabel("Ngày kết thúc : ");
		lblNewLabel_4.setBounds(23, 144, 86, 14);
		component3.add(lblNewLabel_4);

		dateChooser_3 = new JDateChooser();
		dateChooser_3.setBounds(137, 138, 109, 20);
		component3.add(dateChooser_3);

		JLabel lblNewLabel_5 = new JLabel("Tỉnh / Thành phố :");
		lblNewLabel_5.setBounds(23, 175, 99, 14);
		component3.add(lblNewLabel_5);

		txtTinh3 = new JTextField();
		txtTinh3.setBounds(137, 172, 109, 20);
		component3.add(txtTinh3);
		txtTinh3.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Địa điểm : ");
		lblNewLabel_6.setBounds(23, 206, 86, 14);
		component3.add(lblNewLabel_6);

		txtDiaDiem3 = new JTextField();
		txtDiaDiem3.setBounds(137, 203, 109, 20);
		component3.add(txtDiaDiem3);
		txtDiaDiem3.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Đơn giá : ");
		lblNewLabel_7.setBounds(23, 237, 68, 14);
		component3.add(lblNewLabel_7);

		txtDonGia3 = new JTextField();
		txtDonGia3.setBounds(137, 234, 109, 20);
		component3.add(txtDonGia3);
		txtDonGia3.setColumns(10);

		lblNewLabel_1.setPreferredSize(lblNewLabel_5.getPreferredSize());
		lblNewLabel_2.setPreferredSize(lblNewLabel_5.getPreferredSize());
		lblNewLabel_3.setPreferredSize(lblNewLabel_5.getPreferredSize());
		lblNewLabel_4.setPreferredSize(lblNewLabel_5.getPreferredSize());
		lblNewLabel_6.setPreferredSize(lblNewLabel_5.getPreferredSize());
		lblNewLabel_7.setPreferredSize(lblNewLabel_5.getPreferredSize());

		btnchinhsua = new JButton("Chỉnh sửa");
		btnchinhsua.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnchinhsua.setForeground(new Color(32, 178, 170));
		btnchinhsua.setBackground(new Color(0, 191, 255));
		btnchinhsua.setBounds(23, 282, 223, 23);
		component3.add(btnchinhsua);
		DataBase.getInstance().connect();
		updataTableData3();
/////////////////////////////////////////////////////////////////////
		component4.setSize(800, 500);
		component4.setLocation(400, 100);

		String[] headers2 = "Mã Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá"
				.split(";");
		tableModel2 = new DefaultTableModel(headers2, 0);
		JScrollPane scroll2 = new JScrollPane();
		scroll2.setBounds(0, 5, 750, 309);
		scroll2.setViewportView(table2 = new JTable(tableModel2));
		table2.setRowHeight(50);
		table2.setAutoCreateRowSorter(true);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		component4.setLayout(null);
		scroll2.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		component4.add(scroll2);
		DataBase.getInstance().connect();
		updataTableData2();
		try {
			BufferedImage image1 = ImageIO.read(new File("img/tim.png"));
			 im2 = new ImageIcon(image1.getScaledInstance(30, 20, java.awt.Image.SCALE_SMOOTH));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		String[] headers5 = "Mã Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá".split(";");
		tableModel5 = new DefaultTableModel(headers5, 0);
		component5.setLayout(null);
		
/////////////////////////////////////////////////////////////////////////////
		
		txtTimKiem5 = new JTextField("Nhập thành phố cần tìm");
		txtTimKiem5.setBounds(10, 9, 684, 24);
		component5.add(txtTimKiem5);
		txtTimKiem5.setColumns(10);
		
		 btnTIM = new JButton();
		btnTIM.setBounds(690, 9, 55, 23);
		component5.add(btnTIM);
		try {
			BufferedImage image1 = ImageIO.read(new File("img/tim.png"));
			 im2 = new ImageIcon(image1.getScaledInstance(30, 20, java.awt.Image.SCALE_SMOOTH));
			 btnTIM.setIcon(im2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSplitPane split5 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split5.setBounds(10, 37, 735, 272);
		component5.add(split5);
	
		String[] h5 = "Mã Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá".split(";");
		tableModel5 = new DefaultTableModel(h5, 0);
		JScrollPane scroll5 = new JScrollPane();
		scroll5.setViewportView(table5 = new JTable(tableModel5));
		table5.setRowHeight(25);
		table5.setAutoCreateRowSorter(true);
		table5.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scroll5.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		split5.add(scroll5);
		
		DataBase.getInstance().connect();
		update1();
//////////////////////////////////////////////////////////////////////////////////
		menu.setTabPlacement(menu.LEFT);
		menu.setBackground(Color.WHITE);
		menu.setFont(new Font("Time new Roman", Font.BOLD, 25));
		getContentPane().add(menu);
		JPanel pSouth = new JPanel();

		pSouth.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(Color.green);
		pSouth.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(pSouth, BorderLayout.SOUTH);

		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		component6.addAncestorListener(this);
		btnXoaKH.addActionListener(this);
		btnThoat.addActionListener(this);
		table3.addMouseListener(this);
		btnchinhsua.addActionListener(this);
		btnTIM.addActionListener(this);
	}

	private void update1() {
		List<CarriageTrip> ls = dskh.docTT();
		for(CarriageTrip c : ls) {
			String []data5 = {c.getId()+"",c.getName(), c.getCompayid()+"", c.getNgayBatDau().toString(), c.getNgayKetThuc().toString()
					,c.getPlace(), c.getAddress(), c.getDonGia()+""};
			tableModel5.addRow(data5);
		}
		table5.setModel(tableModel5);
		
	}

	private void updataTableData3() {
		DaoNV_SauDN nv = new DaoNV_SauDN();
		List<CarriageTrip> ls = nv.docTT();
		for (CarriageTrip c : ls) {
			String[] data3 = { c.getId() + "", c.getName(), c.getCompayid() + "", c.getNgayBatDau().toString(),
					c.getNgayKetThuc().toString(), c.getPlace(), c.getAddress(), c.getDonGia() + "" };
			tableModel3.addRow(data3);
		}
		table3.setModel(tableModel3);

	}

	private void updataTableData2() {
		DaoNV_SauDN nv = new DaoNV_SauDN();
		List<CarriageTrip> ls = nv.docTT();
		for (CarriageTrip c : ls) {
			String[] data2 = { c.getId() + "", c.getName(), c.getCompayid() + "", c.getNgayBatDau().toString(),
					c.getNgayKetThuc().toString(), c.getPlace(), c.getAddress(), c.getDonGia() + "" };
			tableModel2.addRow(data2);
		}
		table2.setModel(tableModel2);

	}

	private void updataTableData1() {
		DaoThongTin tt = new DaoThongTin();
		List<KhachHang> ls = tt.DocTB();
		for (KhachHang h : ls) {
			String[] row = { h.getID() + "", h.getLastName(), h.getEmail(), h.getPhone(), h.getUser(),
					h.getPassword() };
			tableModel1.addRow(row);
		}
		table1.setModel(tableModel1);

	}

	private void updataTableData() {
		DaoNV_SauDN nv = new DaoNV_SauDN();
		List<CarriageTrip> ls = nv.docTT();
		for (CarriageTrip c : ls) {
			String[] data = { c.getId() + "", c.getName(), c.getCompayid() + "", c.getNgayBatDau().toString(),
					c.getNgayKetThuc().toString(), c.getPlace(), c.getAddress(), c.getDonGia() + "" };
			tableModel.addRow(data);
		}
		table.setModel(tableModel);

	}

	public static void main(String[] args) throws Exception {
		if (System.getProperty("tour.userId") == null || System.getProperty("tour.userId") == "") {
			DangNhap redirectLogin = new DangNhap();
			redirectLogin.setVisible(true);
			return;
		}
		NV_SauDangNhap frame = new NV_SauDangNhap();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		new NV_SauDangNhap().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThem)) {
			 df =new SimpleDateFormat("yyyy-MM-dd");
			String nkh = df.format( dateChooser.getDate());
			String nkt = df.format( dateChooser_1.getDate());
			if (dstour.create(Integer.parseInt((String)txtMaTour.getText() ) ,txtTuyen.getText(), Integer.parseInt((String) comboBox.getSelectedItem()),nkh,
					nkt, txtTinh.getText(), txtDiaDiem.getText(),
					Double.parseDouble(txtDonGia.getText()))) {
				
				Object[] rowData = { Integer.parseInt((String)txtMaTour.getText() ),txtTuyen.getText(),  Integer.parseInt((String) comboBox.getSelectedItem()),
						dateChooser.toString(), dateChooser_1.toString(), txtTinh.getText(), txtDiaDiem.getText(),
						Double.parseDouble(txtDonGia.getText()) };
				tableModel3.addRow(rowData);
				tableModel2.addRow(rowData);
				tableModel.addRow(rowData);
				JOptionPane.showMessageDialog(null, "Thêm thành công!");
			
				
				dstour.update(Integer.parseInt((String)txtMaTour.getText() ),txtTuyen.getText(),  Integer.parseInt((String) comboBox.getSelectedItem()),nkh,
						nkt, txtTinh.getText(), txtDiaDiem.getText(),
						Double.parseDouble(txtDonGia.getText()));
						setVisible(false);
						new NV_SauDangNhap().setVisible(true);
				}

		}
		if (obj.equals(btnXoaTrang)) {
			comboBox.setSelectedItem((Integer) null);
			dateChooser.setDate(null);
			dateChooser_1.setDate(null);
			txtTinh.setText("");
			txtDiaDiem.setText("");
			txtDonGia.setText("");
		}
		if (obj.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if (row != -1) {
				int id = Integer.parseInt((String) table.getValueAt(row, 0));
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa Tour này", "Chú ý",
						JOptionPane.YES_NO_OPTION);
				if (hoiNhac == JOptionPane.YES_OPTION) {
					if (dstour.deleteTour(id)) {
						tableModel.removeRow(row);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn Tour muốn xóa!");
			}

		}
		if (obj.equals(btnXoaKH)) {

			int row = table1.getSelectedRow();
			if (row != -1) {
				int id = Integer.parseInt((String) table1.getValueAt(row, 0));
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này", "Chú ý",
						JOptionPane.YES_NO_OPTION);
				if (hoiNhac == JOptionPane.YES_OPTION) {
					if (dstour.deleteKH(id)) {
						tableModel1.removeRow(row);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn Khách Hàng muốn xóa!");
			}

		}
		if (obj.equals(btnchinhsua)) {
			int row1 = table3.getSelectedRow();
			if (row1 >= 0) {
				 df =new SimpleDateFormat("yyyy-MM-dd");
				String nkh = df.format( dateChooser_2.getDate());
				String nkt = df.format( dateChooser_3.getDate());
				dstour.update(Integer.parseInt((String)txtMaTour3.getText() ),txtTuyen3.getText(), Integer.parseInt((String) comboBox_1.getSelectedItem()), nkh,nkt, txtTinh3.getText(), txtDiaDiem3.getText(),Double.parseDouble(txtDonGia3.getText()));
					
					table3.setValueAt(txtMaTour3.getText(), row1, 0);
					table3.setValueAt(txtTuyen3.getText(), row1, 1);
					table3.setValueAt(comboBox_1.getSelectedItem(), row1, 2);
					table3.setValueAt(dateChooser_2.toString(), row1, 3);
					table3.setValueAt(dateChooser_3.toString(), row1, 4);
					table3.setValueAt(txtTinh3.getText(), row1, 5);
					table3.setValueAt(txtDiaDiem3.getText(), row1, 6);
					table3.setValueAt(txtDonGia3.getText(), row1, 7);

					JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
					setVisible(false);
					new NV_SauDangNhap().setVisible(true);
				
			}
		}
		if(obj.equals(btnTIM)) {
			String nhap = txtTimKiem5.getText();
			if(nhap.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã muốn tìm!");
				return;
			}else {
			DaoNV_SauDN nv = new DaoNV_SauDN();
			List<CarriageTrip> ls = nv.Search(txtTimKiem5.getText());
			for(CarriageTrip c : ls) {
				String []data = {c.getId()+"",c.getName(), c.getCompayid()+"", c.getNgayBatDau().toString(), c.getNgayKetThuc().toString()
						,c.getPlace(), c.getAddress(), c.getDonGia()+""};
				tableModel5.setRowCount(0);
				tableModel5.addRow(data);
			}
			table5.setModel(tableModel5);
			}
		}
		if (obj.equals(btnThoat)) {
			setVisible(false);
			new Main_Frm();
		}

	}

	@Override
	public void ancestorAdded(AncestorEvent e) {
		Object o = e.getSource();
		if (o.equals(component6)) {
			setVisible(false);
			new Main_Frm();
		}

	}

	@Override
	public void ancestorMoved(AncestorEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ancestorRemoved(AncestorEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = table3.getSelectedRow();
		txtMaTour3.setText(table3.getValueAt(r, 0).toString());
		txtTuyen3.setText(table3.getValueAt(r, 1).toString());
		comboBox_1.setSelectedItem(table3.getValueAt(r, 2).toString());
		txtTinh3.setText(table3.getValueAt(r, 5).toString());
		txtDiaDiem3.setText(table3.getValueAt(r, 6).toString());
		txtDonGia3.setText(table3.getValueAt(r, 7).toString());
		
		try {
			Date date = new SimpleDateFormat("yyy-MM-dd").parse(table3.getValueAt(r, 3).toString());
			Date date1 = new SimpleDateFormat("yyy-MM-dd").parse(table3.getValueAt(r, 4).toString());
			dateChooser_2.setDate(date);
			dateChooser_3.setDate(date1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
}