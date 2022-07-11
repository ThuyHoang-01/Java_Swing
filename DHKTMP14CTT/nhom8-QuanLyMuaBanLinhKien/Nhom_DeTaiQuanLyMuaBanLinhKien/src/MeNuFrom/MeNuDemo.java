package MeNuFrom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import BaoCao.BaoCaoDonHang;
import BaoCao.BaoCaoKhachHang;
import BaoCao.BaoCaoMatHang;
import BaoCao.BaoCaoNhanVien;
import DonHang.FrmDSDon;
import DonHang.FrmDonHang;
import DonHang.FrmTimDsDon;
import KhachHang.DanhSachKhachHang;
import KhachHang.FrmKH;
import KhachHang.FrmTimKH;
import MatHang.FormHang;
import MatHang.FrmDanhMucHang;
import MatHang.FrmDsMatHang;
import NhanVien.FrmDanhMucSV;
import NhanVien.FrmNhanVien;
import NhanVien.FrmTimNhanVien;
import ThongKe.ThongKeKhachHang;
import ThongKe.ThongKeLuongNhanVien;
import ThongKe.ThongKeMatHangBanChay;
import chiTietHoaDon.FrmCTHD;
import chiTietHoaDon.FrmDSCT;
import chiTietHoaDon.FrmTimChiTietHD;


public class MeNuDemo extends JFrame implements ActionListener{
	
	private JMenuBar menuBar;
    private JMenu mCapNhat,mDanhMuc,mTimKiem,mThongKe,mBaoCao;
    private JMenuItem CNKHang,CNDDHang,CNCTdathang,CNHangHoa,CNNhanVien;
    private JMenuItem TKKHang,TKDDHang,TKCTDonHang,TKHangHoa,TKNhanVien;
    private JMenuItem DMKhang,DMDDHang,DMCTDonHang,DMHangHoa,DMNhanVien;
    private JMenuItem TKLuongNV, TKMHBC, TKKHTN;
    private JMenuItem BCMatHang,BCKH,BCNhanVien,BCDDHang;
    private JButton btnDangXuat;
    private JPasswordField txtMaPNS;
    public MeNuDemo() {
    	super("MENU CHINH");
    	setSize(800, 600);
    	setLocationRelativeTo(null);
    	
    	menuBar = new JMenuBar();
    	setJMenuBar(menuBar);
    	
    	menuBar.add(Box.createHorizontalStrut(10));
    	menuBar.add(mCapNhat = new JMenu("Cập nhật"));
    	menuBar.add(Box.createHorizontalStrut(20));
    	menuBar.add(mDanhMuc = new JMenu("Danh mục"));
    	menuBar.add(Box.createHorizontalStrut(20));
    	menuBar.add(mTimKiem = new JMenu("Tìm kiếm"));
    	menuBar.add(Box.createHorizontalStrut(20));
    	menuBar.add(mThongKe = new JMenu("Thống kê"));
    	menuBar.add(Box.createHorizontalStrut(20));
    	menuBar.add(mBaoCao = new JMenu("Báo cáo"));
    	
    	mCapNhat.add(CNNhanVien = new JMenuItem("Nhân viên"));
    	mCapNhat.add(CNHangHoa = new JMenuItem("Hàng hóa"));
    	mCapNhat.add(CNKHang = new JMenuItem("Khách hàng"));
    	mCapNhat.add(CNDDHang = new JMenuItem("Đơn hàng"));
    	mCapNhat.add(CNCTdathang = new JMenuItem("Chi tiết đơn hàng"));
    	
    	
    	mDanhMuc.add(DMNhanVien = new JMenuItem("Nhân viên"));
    	mDanhMuc.add(DMHangHoa = new JMenuItem("Hàng hóa"));
    	mDanhMuc.add(DMKhang = new JMenuItem("Khách hàng"));
    	mDanhMuc.add(DMDDHang = new JMenuItem("Đơn hàng"));
    	mDanhMuc.add(DMCTDonHang = new JMenuItem("Chi tiết đơn hàng"));
    	
    	mTimKiem.add(TKNhanVien = new JMenuItem("Nhân viên"));
    	mTimKiem.add(TKHangHoa = new JMenuItem("Hàng hóa"));
    	mTimKiem.add(TKKHang = new JMenuItem("Khách hàng"));
    	mTimKiem.add(TKDDHang = new JMenuItem("Đơn hàng"));
    	mTimKiem.add(TKCTDonHang = new JMenuItem("Chi tiết đơn hàng"));
    	
    	mThongKe.add(TKLuongNV = new JMenuItem("Lương nhân viên"));
    	mThongKe.add(TKMHBC = new JMenuItem("Mặt hàng bán chạy"));
    	mThongKe.add(TKKHTN = new JMenuItem("Khách hàng tiềm năng"));
    	
    	mBaoCao.add(BCNhanVien = new JMenuItem("Nhân viên"));
    	mBaoCao.add(BCMatHang = new JMenuItem("Mặt hàng"));
    	mBaoCao.add(BCKH = new JMenuItem("Khách hàng"));
    	mBaoCao.add(BCDDHang = new JMenuItem("Đơn hàng"));
    	
    	
    	
    	

    	
    	
    	
    	JPanel psouth = new JPanel();
    	add(psouth,BorderLayout.SOUTH);
    	psouth.setBorder(BorderFactory.createTitledBorder("Tác vụ"));
    	psouth.setBackground(Color.LIGHT_GRAY);
    	psouth.add(Box.createHorizontalStrut(600));
    
    	psouth.add(btnDangXuat = new JButton("Đăng xuất"));
    	
    	
    	
    	JPanel pcenter = new JPanel();
    	BufferedImage picture = null;
    	try {
    		picture = ImageIO.read(new File("././hinh.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	JLabel lblpicture = new JLabel(new ImageIcon(picture));
    	pcenter.add(lblpicture);
    	add(pcenter,BorderLayout.CENTER);
    	setVisible(true);
    	
    	btnDangXuat.addActionListener(this);
    	//Cap nhat
    	CNNhanVien.addActionListener(this);
    	CNKHang.addActionListener(this);
    	CNHangHoa.addActionListener(this);
    	CNDDHang.addActionListener(this);
    	CNCTdathang.addActionListener(this);
    	//Danh muc
    	DMNhanVien.addActionListener(this);
    	DMKhang.addActionListener(this);
    	DMHangHoa.addActionListener(this);
    	DMCTDonHang.addActionListener(this);
    	DMDDHang.addActionListener(this);
    	//Timkiem
    	TKNhanVien.addActionListener(this);
    	TKKHang.addActionListener(this);
    	TKHangHoa.addActionListener(this);
    	TKDDHang.addActionListener(this);
    	TKCTDonHang.addActionListener(this);
    	//ThongKe
    	TKKHTN.addActionListener(this);
    	TKLuongNV.addActionListener(this);
    	TKMHBC.addActionListener(this);
    	//BaoCao
    	BCNhanVien.addActionListener(this);
    	BCDDHang.addActionListener(this);
    	BCMatHang.addActionListener(this);
    	BCKH.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDangXuat)) {
			dispose();
			new DangNhap().setVisible(true);
		}
		//Cập nhật
		if(o == CNNhanVien) {
			new KiemTra().setVisible(true);
		}
		if(o == CNKHang) {
			new FrmKH().setVisible(true);
		}
		
		if(o == CNHangHoa) {
			new FormHang().setVisible(true);
		}
		if(o == CNDDHang) {
			new FrmDonHang().setVisible(true);
		}
		if(o == CNCTdathang) {
			new FrmCTHD().setVisible(true);
		}
		//Danh Mục
		if(o == DMNhanVien) {
			new FrmDanhMucSV().setVisible(true);
		}
		if(o == DMKhang) {
			new DanhSachKhachHang().setVisible(true);
		}
		if(o == DMHangHoa) {
			new FrmDanhMucHang().setVisible(true);
		}
		if(o == DMDDHang) {
			new FrmDSDon().setVisible(true);
		}
		if(o == DMCTDonHang) {
			new FrmDSCT().setVisible(true);
		}
		
		
		
		//Tìm kiếm
		
		if(o == TKNhanVien) {
			new FrmTimNhanVien().setVisible(true);
		}
		if(o == TKKHang) {
			new FrmTimKH().setVisible(true);
		}
		if(o == TKHangHoa) {
			new FrmDsMatHang().setVisible(true);
		}
		if(o == TKDDHang) {
			
			new FrmTimDsDon().setVisible(true);
		}
		if(o == TKCTDonHang) {
			new FrmTimChiTietHD().setVisible(true);
		}
		
		//ThongKe
		if(o == TKKHTN) {
			new ThongKeKhachHang().setVisible(true);
		}
		if(o == TKLuongNV) {
			new ThongKeLuongNhanVien().setVisible(true);
		}
		if(o == TKMHBC) {
			new ThongKeMatHangBanChay().setVisible(true);
		}
		//Baocao
		if(o == BCDDHang) {
			new BaoCaoDonHang().setVisible(true);
		}
		if(o == BCKH) {
			new BaoCaoKhachHang().setVisible(true);
		}
		if(o == BCNhanVien) {
			new BaoCaoNhanVien().setVisible(true);
		}
		if(o == BCMatHang) {
			new BaoCaoMatHang().setVisible(true);
		}
		

	}
	
	public static void main(String[] args) {
		new MeNuDemo();
	}
	
	
}
