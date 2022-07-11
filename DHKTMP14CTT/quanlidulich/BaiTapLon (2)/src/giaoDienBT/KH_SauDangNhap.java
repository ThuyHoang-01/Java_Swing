package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import enTiTy.CarriageTrip;
import enTiTy.KhachHang;
import enTiTy.XemTT;
import ketNoiSQL.DataBase;
import thucThi.DaoKhachHang_SauDN;
import thucThi.DaoNV_SauDN;
import thucThi.DaoThongTin;
import thucThi.DaoXemTourDaDat;
import javax.swing.DropMode;

public class KH_SauDangNhap extends JFrame implements ActionListener, MouseListener, AncestorListener {
	DaoKhachHang_SauDN dskh = new DaoKhachHang_SauDN();
	DaoXemTourDaDat mn = new DaoXemTourDaDat();
	DaoXemTourDaDat ld = new DaoXemTourDaDat();
	DaoThongTin tt = new DaoThongTin();
	private JPanel component6;
	private JButton btnThoat;
	private JButton btnDT;
	private DefaultTableModel tableModel;
	private JTable table;
	private JLabel lbl1;
	private JLabel lblTimKiem;
	private JTextField txtTimKiem;
	private JButton btnTIM;
	private DefaultTableModel tableModel1;
	private JTable table1;
	private DefaultTableModel tableModel3;
	private JTable table3;
	private JLabel lblID;
	private JTextField txtID;
	private JLabel lblHoTen;
	private JTextField txtHoTen;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblSdt;
	private JTextField txtSdt;
	private JLabel lblUser;
	private JTextField txtUser;
	private JTextField txtPw;
	private JButton btnCS;
	private ImageIcon im2;
	private DefaultTableModel tableModel4;
	private JTable table4;
	private JButton btnHuy;
	private Component component5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnThayDoi;

	public KH_SauDangNhap() {
		super("Khách Hàng Sau Đăng Nhập");
		setBounds(150, 50, 1000, 700);
		setResizable(false);
		setLocation(100, 30);
		setResizable(false);

		JPanel pNorth = new JPanel();
		JLabel lbl = new JLabel();
		try {
			BufferedImage image = ImageIO.read(new File("img/menuKH.png"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(970, 290, java.awt.Image.SCALE_SMOOTH));
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
			menu.addTab("    Đặt Tour", icon, component);

			BufferedImage image1 = ImageIO.read(new File("img/timkiem.png"));
			ImageIcon icon1 = new ImageIcon(image1.getScaledInstance(50, 42, java.awt.Image.SCALE_SMOOTH));
			menu.addTab("    Tìm Kiếm", icon1, component1);

			BufferedImage image3 = ImageIO.read(new File("img/sua.png"));
			ImageIcon icon3 = new ImageIcon(image3.getScaledInstance(50, 42,  java.awt.Image.SCALE_SMOOTH));
			menu.addTab("Tour Đã Đặt", icon3, component3);

			BufferedImage image2 = ImageIO.read(new File("img/khachhang.png"));
			ImageIcon icon2 = new ImageIcon(image2.getScaledInstance(50, 42,  java.awt.Image.SCALE_SMOOTH));
			menu.addTab("   Thông Tin", icon2, component2);

			BufferedImage image4 = ImageIO.read(new File("img/xoa.png"));
			ImageIcon icon4 = new ImageIcon(image4.getScaledInstance(50, 42,  java.awt.Image.SCALE_SMOOTH));
			menu.addTab("   Hủy Tour", icon4, component4);

			BufferedImage image5 = ImageIO.read(new File("img/doimk.png"));
			ImageIcon icon5 = new ImageIcon(image5.getScaledInstance(50, 42,  java.awt.Image.SCALE_SMOOTH));
			menu.addTab("   Tài Khoản", icon5, component5);
			
			BufferedImage image6 = ImageIO.read(new File("img/dx.png"));
			ImageIcon icon6 = new ImageIcon(image6.getScaledInstance(50, 42,  java.awt.Image.SCALE_SMOOTH));

			menu.addTab("Đăng Xuất", icon6, component6);

		} catch (Exception ex) {
		}
///////////////////////////////////////////////////////////////////
		component.setSize(800, 500);
		component.setLocation(400, 100);
		component.setLayout(null);

		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split.setBounds(10, 11, 735, 303);
		component.add(split);

		split.add(btnDT = new JButton("Đặt Tour"));
		btnDT.setBackground(Color.WHITE);
		btnDT.setForeground(Color.BLACK);

		try {
			BufferedImage image1 = ImageIO.read(new File("img/ok.png"));
			ImageIcon im1 = new ImageIcon(image1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
			btnDT.setIcon(im1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] headers = "Mã Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá"
				.split(";");
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scroll.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		split.add(scroll);

		DataBase.getInstance().connect();
		updataTableData();
//////////////////////////////////////////////////////////////////		
		component1.setSize(800, 500);
		component1.setLocation(400, 100);
		component1.setLayout(null);
		JSplitPane split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split1.setBounds(10, 37, 735, 272);
		component1.add(split1);
		try {
			BufferedImage image1 = ImageIO.read(new File("img/tim.png"));
			im2 = new ImageIcon(image1.getScaledInstance(30, 20, java.awt.Image.SCALE_SMOOTH));
		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] headers1 = "Mã Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá"
				.split(";");
		tableModel1 = new DefaultTableModel(headers1, 0);
		JScrollPane scroll1 = new JScrollPane();
		scroll1.setViewportView(table1 = new JTable(tableModel1));
		table1.setRowHeight(25);
		table1.setAutoCreateRowSorter(true);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scroll1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		split1.add(scroll1);

		txtTimKiem = new JTextField("Nhập thành phố cần tìm");
		component1.add(txtTimKiem);
		txtTimKiem.setToolTipText("");

		split1.add(btnTIM = new JButton());
		btnTIM.setBounds(690, 9, 55, 23);
		component1.add(btnTIM);
		btnTIM.setBackground(Color.WHITE);
		btnTIM.setForeground(Color.BLACK);
		btnTIM.setIcon(im2);

		txtTimKiem.setBounds(10, 9, 684, 24);
		btnTIM.addActionListener(this);
		DataBase.getInstance().connect();
		update1();

////////////////////////////////////////////////////////////////
		component3.setSize(1000, 400);
		component3.setLocation(120, 100);

		String[] headers3 = "Mã Đặt Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá"
				.split(";");
		tableModel3 = new DefaultTableModel(headers3, 0);
		JScrollPane scroll3 = new JScrollPane();
		scroll3.setBounds(10, 15, 735, 427);
		scroll3.setViewportView(table3 = new JTable(tableModel3));
		table3.setRowHeight(25);
		table3.setAutoCreateRowSorter(true);
		table3.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		component3.setLayout(null);
		component3.add(scroll3);
		component3.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		DataBase.getInstance().connect();
		// xemThongTin();

///////////////////////////////////////////////////////////////
		component2.setSize(600, 500);
		component2.setLocation(200, 100);
		component2.setLayout(null);
		JSplitPane split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split2.setBounds(10, 5, 735, 240);
		component2.add(split2);

		split2.add(btnCS = new JButton("Chỉnh Sửa"));
		btnCS.setBackground(Color.BLUE);
		btnCS.setForeground(Color.WHITE);

		Box b = Box.createVerticalBox();
		split2.add(b);
		Box b1, b2, b3, b4, b5, b6, b7;

		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b5.add(lblID = new JLabel("ID:  "));
		b5.add(txtID = new JTextField());
		txtID.setEditable(false);

		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b1.add(lblHoTen = new JLabel("Họ Tên:  "));
		b1.add(txtHoTen = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b3.add(lblEmail = new JLabel("Email:  "));
		b3.add(txtEmail = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b2.add(lblSdt = new JLabel("Phone:       "));
		b2.add(txtSdt = new JTextField(30));

		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b6.add(lblUser = new JLabel("User: "));
		b6.add(txtUser = new JTextField());
		txtUser.setEditable(false);

		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b7.add(lblSdt = new JLabel("Password "));
		b7.add(txtPw = new JTextField());
		txtPw.setEditable(false);
		lblID.setPreferredSize(lblSdt.getPreferredSize());

		lblHoTen.setPreferredSize(lblSdt.getPreferredSize());
		lblEmail.setPreferredSize(lblSdt.getPreferredSize());
		lblUser.setPreferredSize(lblSdt.getPreferredSize());
		DataBase.getInstance().connect();
		Doc();

/////////////////////////////////////////////////////////////
		component4.setSize(1000, 400);
		component4.setLocation(120, 100);

		String[] headers4 = "Mã Đặt Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá"
				.split(";");
		tableModel4 = new DefaultTableModel(headers4, 0);
		JScrollPane scroll4 = new JScrollPane();
		scroll4.setBounds(10, 36, 722, 406);
		scroll4.setViewportView(table4 = new JTable(tableModel4));
		table4.setRowHeight(25);
		table4.setAutoCreateRowSorter(true);
		table4.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		component4.setLayout(null);
		component4.add(scroll4);
		component4.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		btnHuy = new JButton("Hủy Tour");
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setBackground(Color.RED);
		btnHuy.setBounds(10, 0, 723, 30);
		component4.add(btnHuy);
		huyTour();

//////////////////////////////////////////////////////////
		component5.setSize(1000, 400);
		component5.setLocation(120, 100);
		component5.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(10, 11, 761, 32);
		component5.add(panel);
		
		JLabel lblTiKhon = new JLabel("Tài Khoản");
		lblTiKhon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTiKhon.setForeground(new Color(255, 255, 255));
		lblTiKhon.setBackground(new Color(255, 255, 255));
		panel.add(lblTiKhon);
		
		JLabel lblTiKhon_1 = new JLabel("Tài khoản : ");
		lblTiKhon_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTiKhon_1.setBounds(51, 67, 86, 14);
		component5.add(lblTiKhon_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(251, 66, 443, 20);
		component5.add(textField);
		textField.setColumns(10);
		
		JLabel lblTiKhon_1_1 = new JLabel("Mật khẩu: ");
		lblTiKhon_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTiKhon_1_1.setBounds(51, 116, 86, 14);
		component5.add(lblTiKhon_1_1);
		
		JLabel lblTiKhon_1_2 = new JLabel("Nhập mật khẩu mới : ");
		lblTiKhon_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTiKhon_1_2.setBounds(51, 172, 163, 14);
		component5.add(lblTiKhon_1_2);
		
		JLabel lblTiKhon_1_3 = new JLabel("Nhập lại mật khẩu   :");
		lblTiKhon_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTiKhon_1_3.setBounds(51, 224, 142, 14);
		component5.add(lblTiKhon_1_3);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(251, 115, 443, 20);
		component5.add(textField_1);
		
		textField_2 = new JPasswordField();
		textField_2.setColumns(10);
		textField_2.setBounds(251, 171, 443, 20);
		component5.add(textField_2);
		
		textField_3 = new JPasswordField();
		textField_3.setColumns(10);
		textField_3.setBounds(251, 223, 443, 20);
		component5.add(textField_3);
		
		 btnThayDoi = new JButton("Thay đổi");
		btnThayDoi.setBackground(new Color(0, 191, 255));
		btnThayDoi.setForeground(new Color(255, 255, 255));
		btnThayDoi.setBounds(251, 270, 89, 23);
		component5.add(btnThayDoi);
		doi1();
		
		
/////////////////////////////////////////////////////////////
		JPanel pSouth = new JPanel();

		pSouth.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(Color.green);
		pSouth.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(pSouth, BorderLayout.SOUTH);

		menu.setTabPlacement(menu.LEFT);
		menu.setBackground(Color.WHITE);
		menu.setFont(new Font("Time new Roman", Font.BOLD, 25));
		getContentPane().add(menu);
		btnThoat.addActionListener(this);
		btnDT.addActionListener(this);
		btnCS.addActionListener(this);
		btnHuy.addActionListener(this);
		btnThayDoi.addActionListener(this);
		component6.addAncestorListener(this);
	}

	private void doi1() {
		DaoThongTin tt = new DaoThongTin();
		List<KhachHang> ls = tt.doctuBang();
		for (KhachHang h : ls) {
			String[] row = { h.getID() + "", h.getLastName(), h.getEmail(), h.getPhone(), h.getUser(),
					h.getPassword() };
			textField.setText(h.getUser() + "");
			textField_1.setText(h.getPassword() + "");
		}
		
	}

	private void Doc() {
		DaoThongTin tt = new DaoThongTin();
		List<KhachHang> ls = tt.doctuBang();
		for (KhachHang h : ls) {
			String[] row = { h.getID() + "", h.getLastName(), h.getEmail(), h.getPhone(), h.getUser(),
					h.getPassword() };

			txtID.setText(h.getID() + "");
			txtHoTen.setText(h.getLastName() + "");
			txtEmail.setText(h.getEmail() + "");
			txtSdt.setText(h.getPhone() + "");
			txtUser.setText(h.getUser() + "");
			txtPw.setText(h.getPassword() + "");
		}

	}

	private void xemThongTin() {
		List<XemTT> kn = ld.docTTDatTour();
		for (XemTT c : kn) {
			String[] data3 = { c.getId() + "", c.getName(), c.getCompayID() + "", c.getNgaybatDau(), c.getNgayKetThuc(),
					c.getAddress(), c.getPlace(), c.getDonGia() + "" };
			tableModel3.addRow(data3);
		}
		table3.setModel(tableModel3);

	}

	private void huyTour() {
		List<XemTT> kn = ld.docTTDatTour();
		for (XemTT c : kn) {
			String[] data4 = { c.getId() + "", c.getName(), c.getCompayID() + "", c.getNgaybatDau(), c.getNgayKetThuc(),
					c.getAddress(), c.getPlace(), c.getDonGia() + "" };
			tableModel4.addRow(data4);
			tableModel3.addRow(data4);
		}
		table4.setModel(tableModel4);

	}

	private void updataTableData() {
		List<CarriageTrip> ls = dskh.docTT();
		for (CarriageTrip c : ls) {
			String[] data = { c.getId() + "", c.getName(), c.getCompayid() + "", c.getNgayBatDau().toString(),
					c.getNgayKetThuc().toString(), c.getPlace(), c.getAddress(), c.getDonGia() + "" };
			tableModel.addRow(data);
		}
		table.setModel(tableModel);

	}

	private void update1() {
		List<CarriageTrip> ls = dskh.docTT();
		for (CarriageTrip c : ls) {
			String[] data1 = { c.getId() + "", c.getName(), c.getCompayid() + "", c.getNgayBatDau().toString(),
					c.getNgayKetThuc().toString(), c.getPlace(), c.getAddress(), c.getDonGia() + "" };
			tableModel1.addRow(data1);
		}
		table1.setModel(tableModel1);
	}

	public static void main(String[] args) {
		if (System.getProperty("tour.userId") == null || System.getProperty("tour.userId") == "") {
			DangNhap redirectLogin = new DangNhap();
			redirectLogin.setVisible(true);
			return;
		}
		new KH_SauDangNhap().setVisible(true);
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
		Object obj = e.getSource();
		if (obj.equals(btnThoat)) {
			new Main_Frm();
			setVisible(false);

		}
		if (obj.equals(btnDT)) {
			List<CarriageTrip> ls = new ArrayList<CarriageTrip>();
			int row = table.getSelectedRow();
			if (row != -1) {
				int id = Integer.parseInt((String) table.getValueAt(row, 0));
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Thanh toán tour : " + table.getValueAt(row, 7),
						"Thanh Toán", JOptionPane.YES_NO_OPTION);
				if (hoiNhac == JOptionPane.YES_OPTION) {
					if (mn.DatTour(Integer.parseInt(table.getValueAt(row, 0).toString())) == true) {
						JOptionPane.showMessageDialog(this, "Thành công");
						setVisible(false);
						new KH_SauDangNhap().setVisible(true);
						tableModel.removeRow(row);
					} else
						JOptionPane.showMessageDialog(this, "Tour này đã đặt");
				} else {
					JOptionPane.showMessageDialog(this, "Không thành công, vui lòng thử lại");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn tour muốn đặt!");
			}

		}
		if (obj.equals(btnTIM)) {
			String nhap = txtTimKiem.getText();
			if (nhap.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã muốn tìm!");
				return;
			} else {
				DaoNV_SauDN nv = new DaoNV_SauDN();
				List<CarriageTrip> ls = nv.Search(txtTimKiem.getText());
				for (CarriageTrip c : ls) {
					String[] data = { c.getId() + "", c.getName(), c.getCompayid() + "", c.getNgayBatDau().toString(),
							c.getNgayKetThuc().toString(), c.getPlace(), c.getAddress(), c.getDonGia() + "" };
					tableModel1.setRowCount(0);
					tableModel1.addRow(data);
				}
				table1.setModel(tableModel1);
			}
		}
		if (obj.equals(btnCS)) {
			tt.update(Integer.parseInt(txtID.getText()), txtHoTen.getText(), txtEmail.getText(), txtSdt.getText(),
					txtUser.getText(), txtPw.getText());
			JOptionPane.showMessageDialog(this, "Chỉnh Sửa Thành Công");

		}
		if (obj.equals(btnHuy)) {
			int row4 = table4.getSelectedRow();
			if (row4 != -1) {
				int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy tour : " + table4.getValueAt(row4, 6),
						"Hủy Tour", JOptionPane.YES_NO_OPTION);
				if (hoi == JOptionPane.YES_OPTION ) {
					int id =Integer.parseInt(table4.getValueAt(row4, 0).toString());
					if( mn.huyTour(id) == true) {
						JOptionPane.showMessageDialog(this, "Đã hủy tour");
						tableModel4.removeRow(row4);
						tableModel3.removeRow(row4);
					}

				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn tour muốn hủy!");
			}

		}
		if (obj.equals(btnThayDoi)) {
			tt.update(Integer.parseInt(txtID.getText()), txtHoTen.getText(), txtEmail.getText(), txtSdt.getText(),
					txtUser.getText(), textField_2.getText());
			JOptionPane.showMessageDialog(this, "Thay đổi Thành Công");
		}
	}
}
