package GiaoDien;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import DieuKhien.QuanLyNhanVien;
//import DoiTuong.NhanVien;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class GiaoDienTong extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JMenuItem mntmTaiKhoan, mntmDangXuat, mntmThoat, mnItemNhanVien, mnItemPhongBan,mnItemCongTrinh,
			mnItemPhanCong,mnItemCongTrinh1,mnItemNhanVienKimKiem, mnItemLichLaoDong, mnItemBaoCao , mnItemChiTietCongTrinh,mnItemThongKe;
	private JLabel lblTitle;

	public GiaoDienTong() {
		setTitle("Quản Lý Lao Dong");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000,500);
		setLocationRelativeTo(null);
		setResizable(false);
		Control();
	}
	private void Control() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.LIGHT_GRAY);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		menuBar.setBounds(0, 0, 1360, 32);
		contentPane.add(menuBar);

		JMenu mnHeThong = new JMenu("Hệ Thống  ");
		mnHeThong.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mnHeThong);

		mntmTaiKhoan = new JMenuItem("Đổi Mật Khẩu");
		mntmTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		mnHeThong.add(mntmTaiKhoan);

		mntmDangXuat = new JMenuItem("Đăng Xuất");
		mntmDangXuat.setFont(new Font("Arial", Font.PLAIN, 16));
		mnHeThong.add(mntmDangXuat);
		mntmDangXuat.addActionListener(this);

		mntmThoat = new JMenuItem("Thoát");
		mntmThoat.setFont(new Font("Arial", Font.PLAIN, 16));
		mnHeThong.add(mntmThoat);
		mntmThoat.addActionListener(this);

		JMenu mnQuanLy = new JMenu("Danh Mục ");
		mnQuanLy.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mnQuanLy);

		mnItemCongTrinh1 = new JMenuItem("Công trình");
		mnItemCongTrinh1.setFont(new Font("Arial", Font.PLAIN, 16));
		mnQuanLy.add(mnItemCongTrinh1);
		mnItemCongTrinh1.addActionListener(this);	

		mnItemNhanVien = new JMenuItem("Nhân viên");
		mnItemNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		mnQuanLy.add(mnItemNhanVien);
		mnItemNhanVien.addActionListener(this);

		mnItemPhongBan = new JMenuItem("Phòng ban");
		mnItemPhongBan.setFont(new Font("Arial", Font.PLAIN, 16));
		mnQuanLy.add(mnItemPhongBan);
		mnItemPhongBan.addActionListener(this);

		mnItemChiTietCongTrinh = new JMenuItem("Chi tiết công trình");
		mnItemChiTietCongTrinh.setFont(new Font("Arial", Font.PLAIN, 16));
		mnQuanLy.add(mnItemChiTietCongTrinh);
		mnItemChiTietCongTrinh.addActionListener(this);

		JMenu mnXuLy = new JMenu("Xử Lý ");
		mnXuLy.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mnXuLy);

		mnItemPhanCong = new JMenuItem("Phân Công Nhân Viên");
		mnItemPhanCong.setFont(new Font("Arial", Font.PLAIN, 16));
		mnXuLy.add(mnItemPhanCong);
		mnItemPhanCong.addActionListener(this);

//		mnItemKetThucTG = new JMenuItem("Kết Thúc Tham Gia");
//		mnItemKetThucTG.setFont(new Font("Arial", Font.PLAIN, 16));
//		mnXuLy.add(mnItemKetThucTG);
//		mnItemKetThucTG.addActionListener(this);

		JMenu mnTimKiem = new JMenu("Tìm Kiếm");
		mnTimKiem.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mnTimKiem);

		mnItemLichLaoDong = new JMenuItem("Lịch Lao Động Nhân viên");
		mnItemLichLaoDong.setFont(new Font("Arial", Font.PLAIN, 16));
		mnTimKiem.add(mnItemLichLaoDong);
		mnItemLichLaoDong.addActionListener(this);

		mnItemCongTrinh = new JMenuItem("Công Trình");
		mnItemCongTrinh.setFont(new Font("Arial", Font.PLAIN, 16));
		mnTimKiem.add(mnItemCongTrinh);
		mnItemCongTrinh.addActionListener(this);
		
		mnItemNhanVienKimKiem = new JMenuItem("Nhân Viên");
		mnItemNhanVienKimKiem.setFont(new Font("Arial", Font.PLAIN, 16));
		mnTimKiem.add(mnItemNhanVienKimKiem);
		mnItemNhanVienKimKiem.addActionListener(this);

		JMenu mnThongKe = new JMenu("Thống Kê  / Báo Cáo");
		mnThongKe.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mnThongKe);

		mnItemThongKe = new JMenuItem("Thống Kê");
		mnItemThongKe.setFont(new Font("Arial", Font.PLAIN, 16));
		mnThongKe.add(mnItemThongKe);
		mnItemThongKe.addActionListener(this);

		mnItemBaoCao = new JMenuItem("Báo cáo");
		mnItemBaoCao.setFont(new Font("Arial", Font.PLAIN, 16));
		mnThongKe.add(mnItemBaoCao);
		mnItemBaoCao.addActionListener(this);
		
		lblTitle = new JLabel("QUẢN LÝ LAO ĐỘNG");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitle.setBounds(350, 100, 550, 30);
		contentPane.add(lblTitle);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(mnItemCongTrinh1)) {
			GiaoDienQuanLyCongTrinh ct = new GiaoDienQuanLyCongTrinh();
			ct.setVisible(true);
		} else if (o.equals(mnItemPhongBan)) {
			GiaoDienQuanLyPhongBan ct = new GiaoDienQuanLyPhongBan();
			ct.setVisible(true);
		} else if (o.equals(mnItemNhanVien)) {
			GiaoDienQuanLyNhanVien nv = new GiaoDienQuanLyNhanVien();
			nv.setVisible(true);
		} else if (o.equals(mnItemNhanVienKimKiem)) {
			GiaoDienTimNhanVien ncc = new GiaoDienTimNhanVien();
			ncc.setVisible(true);
		} else if (o.equals(mnItemPhanCong)) {
			GiaoDienPhanCong kh = new GiaoDienPhanCong();
			kh.setVisible(true);
		} else if (o.equals(mnItemLichLaoDong)) {
			GiaoDienXemLichLaoDong bd = new GiaoDienXemLichLaoDong();
			bd.setVisible(true);
		} else if (o.equals(mnItemCongTrinh)) {
			GiaoDienTimCongTrinh hd = new GiaoDienTimCongTrinh();
			hd.setVisible(true);
		} else if (o.equals(mnItemChiTietCongTrinh)) {
			GiaoDienQuanLyCTCongTrinh tl = new GiaoDienQuanLyCTCongTrinh();
			tl.setVisible(true);
		} else if (o.equals(mntmThoat)) {
			setVisible(false);
//		} else if (o.equals(mntmTaiKhoan)) {
//			NV = new QuanLyNhanVien();
//			String maTK = NV.layMaTK(maNV);
//			GiaoDienDoiMatKhau t = new GiaoDienDoiMatKhau(maTK);
//			t.setVisible(true);
//			setVisible(false);
		}
	}
}
