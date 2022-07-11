package quanLymuabanXe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JFrame implements ActionListener {
	private JLabel lblTitle;
	private JMenuBar mbQuanLyXe;
	private JMenu menuNhanVienHC, menuXe, menuKhachHang, menuNhanVienKythuat, menuHoaDon;
	private JMenuItem CapNhapNVHC, TimKiemNVHC, XoaNVHC, CapNhapNVKT, TimKiemNVKT, XoaNVKT, CapNhapXe, TimKiemXe, Xoaxe,ThongTinKH,
			TimKiemKH, MuaBanXe,BaoHanh;

	public Menu() {
		super("Menu");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setMenu();
	}

	private void setMenu() {
		mbQuanLyXe = new JMenuBar();
		setJMenuBar(mbQuanLyXe);
		mbQuanLyXe.add(menuNhanVienHC = new JMenu("Nhân viên hành chinh"));
		mbQuanLyXe.add(menuNhanVienKythuat = new JMenu("Nhân viên kỹ thuật"));
		mbQuanLyXe.add(menuXe = new JMenu("Xe"));
		mbQuanLyXe.add(menuKhachHang = new JMenu("Khách hàng"));
		mbQuanLyXe.add(menuHoaDon = new JMenu("Hóa đơn"));

		menuNhanVienHC.add(CapNhapNVHC = new JMenuItem("Cập Nhập Nhân Viên"));
		menuNhanVienHC.add(TimKiemNVHC = new JMenuItem("Tìm Kiếm Nhân Viên"));
		menuNhanVienHC.add(XoaNVHC = new JMenuItem("Xoa Nhân Viên"));
		
		CapNhapNVHC.addActionListener(this);
		TimKiemNVHC.addActionListener(this);
		XoaNVHC.addActionListener(this);
		
		menuNhanVienKythuat.add(CapNhapNVKT = new JMenuItem("Thông tin Nhân Viên"));
		menuNhanVienKythuat.add(TimKiemNVKT = new JMenuItem("Tìm Kiếm Nhân Viên"));
		CapNhapNVKT.addActionListener(this);

		menuXe.add(CapNhapXe = new JMenuItem("Thông tin Xe"));
		menuXe.add(TimKiemXe = new JMenuItem("Tìm Kiếm Xe"));
		menuXe.add(Xoaxe = new JMenuItem("Xóa xe"));
		menuXe.add(BaoHanh = new JMenuItem("Bảo Hành"));
		CapNhapXe.addActionListener(this);
		BaoHanh.addActionListener(this);
		menuKhachHang.add(TimKiemKH = new JMenuItem("Tìm Kiếm"));
		menuKhachHang.add(ThongTinKH = new JMenuItem("Thông tin Khách hàng"));
		TimKiemKH.addActionListener(this);
		TimKiemKH.addActionListener(this);
		ThongTinKH.addActionListener(this);

		menuHoaDon.add(MuaBanXe = new JMenuItem("Mua Bán Xe"));
		JPanel pnCenter = new JPanel();
		pnCenter.add( lblTitle = new JLabel("QUẢN LÝ MUA BÁN XE",SwingConstants.CENTER));
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblTitle.setForeground(Color.BLUE);
		add(pnCenter,BorderLayout.NORTH);
	

	}

	public static void main(String[] args) {
		new Menu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==CapNhapNVHC) {
	
			new NhanVienHanhChinh().setVisible(true);
		}
		if(e.getSource()==CapNhapNVKT) {
			new NhanVienKyThuat().setVisible(true);
		}
		if(e.getSource()==ThongTinKH) {
		
			new KhachHang_Form().setVisible(true);
		}
		if(e.getSource()==CapNhapNVKT) {
			
			new NhanVienKyThuat().setVisible(true);
		}
		if(e.getSource()==CapNhapXe) {
			
			new Xe_Form().setVisible(true);
		}
		if (e.getSource()==BaoHanh) {
			new BaoHanh_Frm().setVisible(true);
		}
		if(e.getSource()==TimKiemKH) {
			new TimKhachHang_Frm().setVisible(true);		
		}
	}
}
