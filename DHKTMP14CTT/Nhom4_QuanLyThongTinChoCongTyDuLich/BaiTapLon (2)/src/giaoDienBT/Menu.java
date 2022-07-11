package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu menuDangNhap,menuDangKy,menuDatTour,menuThem,menuXoa,menuSua,menuTimKiem,menuBaoBieu;
	private JMenuItem mniDNNV,mniDNKH,
					mniDKKH,
					mniDatTKH,
					mniThemTour,
					mniXoatour,mniXoaKH,mniXoaDatTour,
					mniSuaTour,mniSuaTTCN,
					mniTKten,
					mniBBTour,mniBBTourDaDat,mniBBDSKH;

	public Menu() {
		super("MENU");
		setSize(850, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		
		// Menu
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
//		menuBar.add(menuDangNhap = new JMenu("Đăng Nhập"));
//		menuDangNhap.setFont(new Font("Arial",Font.BOLD,18));
//		menuDangNhap.setForeground(Color.RED);
//		menuDangNhap.add(mniDNNV = new JMenuItem("Nhân Viên"));
//		mniDNNV.setFont(new Font("Arial",Font.BOLD,16));
//		mniDNNV.setForeground(Color.blue);
//		menuDangNhap.add(mniDNKH = new JMenuItem("Khách Hàng"));
//		mniDNKH.setFont(new Font("Arial",Font.BOLD,16));
//		mniDNKH.setForeground(Color.blue);
		
		menuBar.add(menuDangKy = new JMenu("Đăng Ký Tài Khoản"));
		menuDangKy.setFont(new Font("Arial",Font.BOLD,18));
		menuDangKy.setForeground(Color.RED);
		menuDangKy.add(mniDKKH = new JMenuItem("Khách Hàng"));
		mniDKKH.setFont(new Font("Arial",Font.BOLD,16));
		mniDKKH.setForeground(Color.blue);
		
		menuBar.add(menuDatTour = new JMenu("Đặt Tour"));
		menuDatTour.setFont(new Font("Arial",Font.BOLD,18));
		menuDatTour.setForeground(Color.RED);
		menuDatTour.add(mniDatTKH = new JMenuItem("Khách Hàng"));
		mniDatTKH.setFont(new Font("Arial",Font.BOLD,16));
		mniDatTKH.setForeground(Color.blue);
		
		menuBar.add(menuThem = new JMenu("Thêm"));
		menuThem.setFont(new Font("Arial",Font.BOLD,18));
		menuThem.setForeground(Color.RED);
		menuThem.add(mniThemTour = new JMenuItem("Tour"));
		mniThemTour.setFont(new Font("Arial",Font.BOLD,16));
		mniThemTour.setForeground(Color.blue);
		
		menuBar.add(menuXoa = new JMenu("Xóa"));
		menuXoa.setFont(new Font("Arial",Font.BOLD,18));
		menuXoa.setForeground(Color.RED);
		menuXoa.add(mniXoatour = new JMenuItem("Tour"));
		mniXoatour.setFont(new Font("Arial",Font.BOLD,16));
		mniXoatour.setForeground(Color.blue);
		menuXoa.add(mniXoaKH = new JMenuItem("Khách Hàng"));
		mniXoaKH.setFont(new Font("Arial",Font.BOLD,16));
		mniXoaKH.setForeground(Color.blue);
//		menuXoa.add(mniXoaDatTour = new JMenuItem("Đặt Tour"));
//		mniXoaDatTour.setFont(new Font("Arial",Font.BOLD,16));
//		mniXoaDatTour.setForeground(Color.blue);
		
		menuBar.add(menuSua = new JMenu("Chỉnh Sửa"));
		menuSua.setFont(new Font("Arial",Font.BOLD,18));
		menuSua.setForeground(Color.RED);
		menuSua.add(mniSuaTour = new JMenuItem("Tour"));
		mniSuaTour.setFont(new Font("Arial",Font.BOLD,16));
		mniSuaTour.setForeground(Color.blue);
		menuSua.add(mniSuaTTCN = new JMenuItem("Thông Tin Cá Nhân"));
		mniSuaTTCN.setFont(new Font("Arial",Font.BOLD,16));
		mniSuaTTCN.setForeground(Color.blue);
		
		menuBar.add(menuTimKiem = new JMenu("Tìm Kiếm"));
		menuTimKiem.setFont(new Font("Arial",Font.BOLD,18));
		menuTimKiem.setForeground(Color.RED);
		menuTimKiem.add(mniTKten = new JMenuItem("Tỉnh/ThànhPhố"));
		mniTKten.setFont(new Font("Arial",Font.BOLD,16));
		mniTKten.setForeground(Color.blue);

		menuBar.add(menuBaoBieu = new JMenu("Báo Biểu"));
		menuBaoBieu.setFont(new Font("Arial",Font.BOLD,18));
		menuBaoBieu.setForeground(Color.RED);
		menuBaoBieu.add(mniBBTour = new JMenuItem("Tour"));
		mniBBTour.setFont(new Font("Arial",Font.BOLD,16));
		mniBBTour.setForeground(Color.blue);
		menuBaoBieu.add(mniBBDSKH = new JMenuItem("Khách Hàng"));
		mniBBDSKH.setFont(new Font("Arial",Font.BOLD,16));
		mniBBDSKH.setForeground(Color.blue);
		menuBaoBieu.add(mniBBTourDaDat = new JMenuItem("Đã Đặt Tour"));
		mniBBTourDaDat.setFont(new Font("Arial",Font.BOLD,16));
		mniBBTourDaDat.setForeground(Color.blue);
		
		JLabel lbl = new JLabel();
		add(lbl);
		try {
			BufferedImage image = ImageIO.read(new File("hihi.jpg"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(850, 700, java.awt.Image.SCALE_SMOOTH));
			lbl.setIcon(im);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JPanel pnSouth = new JPanel();
		add(pnSouth,BorderLayout.SOUTH);
		pnSouth.setPreferredSize(new Dimension(0, 40));
		JLabel lblTen = new JLabel("Nguyễn Đức Mạnh - Đỗ Thị Thu Diệp - Tống Sỹ Nguyên");
	
		lblTen.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTen.setForeground(Color.blue);
		pnSouth.setBackground(Color.yellow);
		pnSouth.add(lblTen);
		
//		mniDNNV.addActionListener(this);
//		mniDNKH.addActionListener(this);
		mniDKKH.addActionListener(this);
		mniThemTour.addActionListener(this);
		mniXoatour.addActionListener(this);
		mniXoaKH.addActionListener(this);
//		mniXoaDatTour.addActionListener(this);
		mniSuaTour.addActionListener(this);
		mniSuaTTCN.addActionListener(this);
		mniTKten.addActionListener(this);
		mniBBTour.addActionListener(this);
		mniBBTourDaDat.addActionListener(this);
		mniBBDSKH.addActionListener(this);
		mniDatTKH.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		Menu n = new Menu();
		n.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(mniDNKH)) {	
			setVisible(false);
			new KH_DangNhap().setVisible(true);
		}
		if (o.equals(mniDNNV)) {
			setVisible(false);
	  		new NV_DangNhap().setVisible(true); 
		}
		if (o.equals(mniDKKH)) {
			setVisible(false);
	  		new KH_DangKy().setVisible(true); 
		}
		if (o.equals(mniDatTKH)) {
			if(System.getProperty("tour.userId") == null || System.getProperty("tour.userId") == "") {
				KH_DangNhapDT redirectLogin = new KH_DangNhapDT();
				redirectLogin.setVisible(true);			
				return;
			}
			setVisible(false);
	  		new KH_DatTour().setVisible(true);
	  		
		}
		if (o.equals(mniXoatour)) {
			setVisible(false);
	  		new NV_XoaTour().setVisible(true);
		}
		if (o.equals(mniXoaKH)) {
			setVisible(false);
	  		new NV_XoaKH().setVisible(true);
		}
		if (o.equals(mniXoaDatTour)) {
			setVisible(false);
	  		new TimKiem().setVisible(true);
		}
		if (o.equals(mniThemTour)) {
			setVisible(false);
	  		new NV_ThemTour().setVisible(true);
		}
		
		if (o.equals(mniSuaTour)) {
			setVisible(false);
	  		new NV_ChinhSuaTour().setVisible(true);
		}
		if (o.equals(mniSuaTTCN)) {
			 if(System.getProperty("tour.userId") == null || System.getProperty("tour.userId") == "") {
					KH_DangNhapCS redirectLogin = new KH_DangNhapCS();
					redirectLogin.setVisible(true);			;		
					return;
				
				}
			setVisible(false);
	  		new KH_ChinhSuaTTCN().setVisible(true);
		}
		if (o.equals(mniTKten)) {
			setVisible(false);
	  		new TimKiem().setVisible(true);
		}
		if (o.equals(mniBBTour)) {
			//setVisible(false);
			this.dispose();
	  		new DS_Tour().setVisible(true);
		}
		if (o.equals(mniBBTourDaDat)) {
			 if(System.getProperty("tour.userId") == null || System.getProperty("tour.userId") == "") {
					KH_DangNhapDT redirectLogin = new KH_DangNhapDT();
					redirectLogin.setVisible(true);			;		
					return;
				
				}
			setVisible(false);
	  		new KH_XemDatTour().setVisible(true);
		}
		if (o.equals(mniBBDSKH)) {
			setVisible(false);
			new KH_DanhSach().setVisible(true);
		}

	}

}
