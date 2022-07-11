package baiTapLon;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;


public class FormChung extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenu menuThem, menuXoa, menuSua, menuTim, menuThongKe;
	private JMenuItem menuItemThemKhachHang, menuItemThemDonThuoc, menuItemThemThuoc,
				menuItemXoaKhachHang, menuItemXoaDonThuoc, menuItemXoaThuoc,
				menuItemSuaKhachHang, menuItemSuaThuoc,
				menuItemTimKhachHang, menuItemTimDonThuoc, menuItemTimThuoc,
				menuItemTongSoThuoc, menuItemSLThuocHetHan, menuItemSLThuocMoiNhap, 
				menuItemDoanhThu, menuItemThuongTinKhachHang;
	private JPanel pnThemKhachHang, pnThemDonThuoc, pnThemThuoc,
					pnSuaKhachHang, pnSuaThuoc,
					pnXoaKhachHang, pnXoaDonThuoc, pnXoaThuoc,
					pnTimKhachHang, pnTimDonThuoc, pnTimThuoc;
	private CardLayout cardLayout;
	private JPanel pane;
	public FormChung() throws ParseException {
		setTitle("Quản lý quầy thuốc");
		setSize(700, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setResizable(false);
		
		
		//create bar
		menuBar = new JMenuBar();
		
		//menu thêm, xóa, sửa, tìm kiếm, Thống kê
		menuThem = new JMenu("Thêm");
		menuThem.setMnemonic(KeyEvent.VK_T);
		menuBar.add(menuThem);
		
		menuXoa = new JMenu("Xóa");
		menuXoa.setMnemonic(KeyEvent.VK_X);
		menuBar.add(menuXoa);
		
		menuSua = new JMenu("Sửa");
		menuSua.setMnemonic(KeyEvent.VK_S);
		menuBar.add(menuSua);
		
		menuTim = new JMenu("Tìm kiếm");
		menuTim.setMnemonic(KeyEvent.VK_K);
		menuBar.add(menuTim);
		
		menuThongKe = new JMenu("Thống kê");
		menuThongKe.setMnemonic(KeyEvent.VK_H);
		menuBar.add(menuThongKe);
		
		//item menuThem
		menuItemThemKhachHang = new JMenuItem("Thêm khách hàng");
		menuItemThemKhachHang.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuThem.add(menuItemThemKhachHang);
		
		menuItemThemDonThuoc = new JMenuItem("Thêm đơn thuốc");
		menuItemThemDonThuoc.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuThem.add(menuItemThemDonThuoc);
		
		menuItemThemThuoc = new JMenuItem("Thêm thuốc");
		menuItemThemThuoc.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		menuThem.add(menuItemThemThuoc);
		
		//item menuXoa
		menuItemXoaKhachHang = new JMenuItem("Xóa khách hàng");
		menuItemXoaKhachHang.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
		menuXoa.add(menuItemXoaKhachHang);
		
		menuItemXoaDonThuoc = new JMenuItem("Xóa đơn thuốc");
		menuItemXoaDonThuoc.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
		menuXoa.add(menuItemXoaDonThuoc);
		
		menuItemXoaThuoc = new JMenuItem("Xóa thuốc");
		menuItemXoaThuoc.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.ALT_MASK));
		menuXoa.add(menuItemXoaThuoc);
		
		//item menuSua
		menuItemSuaKhachHang = new JMenuItem("Sửa khách hàng");
		menuItemSuaKhachHang.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_7, ActionEvent.ALT_MASK));
		menuSua.add(menuItemSuaKhachHang);
		
		
		menuItemSuaThuoc = new JMenuItem("Sửa thuốc");
		menuItemSuaThuoc.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_9, ActionEvent.ALT_MASK));
		menuSua.add(menuItemSuaThuoc);
		
		//item menuTim
		menuItemTimKhachHang = new JMenuItem("Tìm khách hàng");
		menuItemTimKhachHang.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.ALT_MASK));
		menuTim.add(menuItemTimKhachHang);
		
		menuItemTimDonThuoc = new JMenuItem("Tìm đơn thuốc");
		menuItemTimDonThuoc.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F2, ActionEvent.ALT_MASK));
		menuTim.add(menuItemTimDonThuoc);
		
		menuItemTimThuoc = new JMenuItem("Tìm thuốc");
		menuItemTimThuoc.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.ALT_MASK));
		menuTim.add(menuItemTimThuoc);
		
		//item menuThongKe
		menuItemTongSoThuoc = new JMenuItem("Tổng số thuốc");
		menuItemTongSoThuoc.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		menuThongKe.add(menuItemTongSoThuoc);
		
		menuItemSLThuocHetHan = new JMenuItem("Số lượng thuốc hết hạn");
		menuItemSLThuocHetHan.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.ALT_MASK));
		menuThongKe.add(menuItemSLThuocHetHan);
		
		menuItemSLThuocMoiNhap = new JMenuItem("Số lượng thuốc mới nhập");
		menuItemSLThuocMoiNhap.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F6, ActionEvent.ALT_MASK));
		menuThongKe.add(menuItemSLThuocMoiNhap);
		
		menuItemDoanhThu = new JMenuItem("Doanh thu");
		menuItemDoanhThu.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F7, ActionEvent.ALT_MASK));
		menuThongKe.add(menuItemDoanhThu);
		
		menuItemThuongTinKhachHang = new JMenuItem("Thông tin khách hàng");
		menuItemThuongTinKhachHang.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_F8, ActionEvent.ALT_MASK));
		menuThongKe.add(menuItemThuongTinKhachHang);
		
		//actionListener
		menuItemThemKhachHang.addActionListener(this);
		menuItemThemDonThuoc.addActionListener(this);
		menuItemThemThuoc.addActionListener(this);
		
		menuItemSuaKhachHang.addActionListener(this);
		menuItemSuaThuoc.addActionListener(this);
		
		menuItemXoaKhachHang.addActionListener(this);
		menuItemXoaDonThuoc.addActionListener(this);
		menuItemXoaThuoc.addActionListener(this);
		
		menuItemTimKhachHang.addActionListener(this);
		menuItemTimDonThuoc.addActionListener(this);
		menuItemTimThuoc.addActionListener(this);
		
		//them pane
		cardLayout= new CardLayout();
		pane = new JPanel(cardLayout);
		
		//Khach hang
		FormThemKhachHang formThemKhachHang = new FormThemKhachHang();
		pnThemKhachHang = formThemKhachHang.getPanel();
		pnThemKhachHang.setVisible(true);
		pane.add(pnThemKhachHang, "ThemKhachHang");
		
		FormXoaKhachHang formXoaKhachHang = new FormXoaKhachHang();
		pnXoaKhachHang = formXoaKhachHang.getPanel();
		pnXoaKhachHang.setVisible(true);
		pane.add(pnXoaKhachHang, "XoaKhachHang");
		
		FormSuaKhachHang formSuaKhachHang = new FormSuaKhachHang();
		pnSuaKhachHang = formSuaKhachHang.getPanel();
		pnSuaKhachHang.setVisible(true);
		pane.add(pnSuaKhachHang, "SuaKhachHang");
		
		FormTimKiemKhachHang formTimKiemKhachHang = new FormTimKiemKhachHang();
		pnTimKhachHang = formTimKiemKhachHang.getPanel();
		pnTimKhachHang.setVisible(true);
		pane.add(pnTimKhachHang, "TimKhachHang");
		
		//Don thuoc
		FormThemDonThuoc formThemDonThuoc = new FormThemDonThuoc();
		pnThemDonThuoc = formThemDonThuoc.getPane();
		pnThemDonThuoc.setVisible(true);
		pane.add(pnThemDonThuoc, "ThemDonThuoc");
		
		FormXoaDonThuoc formXoaDonThuoc = new FormXoaDonThuoc();
		pnXoaDonThuoc = formXoaDonThuoc.getPane();
		pnXoaDonThuoc.setVisible(true);
		pane.add(pnXoaDonThuoc, "XoaDonThuoc");
		
		FormTimDonThuoc formTimDonThuoc = new FormTimDonThuoc();
		pnTimDonThuoc = formTimDonThuoc.getPane();
		pnTimDonThuoc.setVisible(true);
		pane.add(pnTimDonThuoc, "TimDonThuoc");
		
		//Thuoc
		FormThemThuoc formThemThuoc = new FormThemThuoc();
		pnThemThuoc = formThemThuoc.getPane();
		pnThemThuoc.setVisible(true);
		pane.add(pnThemThuoc, "ThemThuoc");
		
		FormXoaThuoc formXoaThuoc = new FormXoaThuoc();
		pnXoaThuoc = formXoaThuoc.getPane();
		pnXoaThuoc.setVisible(true);
		pane.add(pnXoaThuoc, "XoaThuoc");
		
		FormSuaThuoc formSuaThuoc = new FormSuaThuoc();
		pnSuaThuoc = formSuaThuoc.getPane();
		pnSuaThuoc.setVisible(true);
		pane.add(pnSuaThuoc, "SuaThuoc");
		
		FormTimThuoc formTimThuoc = new FormTimThuoc();
		pnTimThuoc = formTimThuoc.getPane();
		pnTimThuoc.setVisible(true);
		pane.add(pnTimThuoc, "TimThuoc");

		
		add(pane);
		setJMenuBar(menuBar);
		Database.getInstance().connec();
	}
	public static void main(String[] args) throws ParseException {
		new FormChung().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(menuItemThemKhachHang)) {
			cardLayout.show(pane, "ThemKhachHang");
		} else if (o.equals(menuItemThemDonThuoc)) {
			cardLayout.show(pane, "ThemDonThuoc");
		} else if (o.equals(menuItemThemThuoc)) {
			cardLayout.show(pane, "ThemThuoc");
		} else if (o.equals(menuItemXoaKhachHang)) {
			cardLayout.show(pane, "XoaKhachHang");
		} else if (o.equals(menuItemXoaDonThuoc)) {
			cardLayout.show(pane, "XoaDonThuoc");
		} else if (o.equals(menuItemXoaThuoc)) {
			cardLayout.show(pane, "XoaThuoc");
		} else if (o.equals(menuItemSuaKhachHang)) {
			cardLayout.show(pane, "SuaKhachHang");
		} else if (o.equals(menuItemSuaThuoc)) {
			cardLayout.show(pane, "SuaThuoc");
		} else if (o.equals(menuItemTimKhachHang)) {
			cardLayout.show(pane, "TimKhachHang");
		} else if (o.equals(menuItemTimDonThuoc)) {
			cardLayout.show(pane, "TimDonThuoc");
		} else if (o.equals(menuItemTimThuoc)) {
			cardLayout.show(pane, "TimThuoc");
		}
		
	}
	
}
