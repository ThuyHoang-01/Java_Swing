package giaoDienBT;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main_Frm extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar mnubar;
	private JMenu menutour, menuThem, menuTimKiem;
	private JMenuItem mnuNV, mnuKH, mnuThemTour, mnuNhanVien, mnuKhachHang,mnuSuaKH,mnuXoaNV;

	
	public Main_Frm() {
		super(" Quản lí thông tin ");
		setSize(900,500);
		setLocation(300,50);
		setResizable(false);
		
		control();
		setVisible(true);
	}
	public void control() {
		mnubar = new JMenuBar();
		setJMenuBar(mnubar);
		
		menutour = new JMenu("Người dùng");
		menutour.add(mnuNV = new JMenuItem("Nhân Viên")); 
		
//		mnuNV.setIcon(new javax.swing.ImageIcon((getClass().getResource("1.jpg"))));
		mnuNV.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menutour.add(mnuKH = new JMenuItem("Khách hàng")); 
		mnuKH.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menutour.addSeparator();
		mnubar.add(menutour);
		
		menuThem = new JMenu("Chức năng Thêm");
		menuThem.add(mnuThemTour = new JMenuItem("Thêm Tour"));
		mnubar.add(menuThem);
		
		menuThem = new JMenu("Tìm Kiếm");
		menuThem.add(mnuKhachHang = new JMenuItem("Khách Hàng"));
		menuThem.add(mnuNhanVien = new JMenuItem("Nhân Viên"));
	// 	mnubar.add(menuTimKiem);
		
		
		JLabel lbl = new JLabel();
		add(lbl);
		try {
			BufferedImage image = ImageIO.read(new File("47.jpg"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(900, 370, java.awt.Image.SCALE_SMOOTH));
			lbl.setIcon(im);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JPanel pnSouth = new JPanel();
		add(pnSouth,BorderLayout.SOUTH);
		pnSouth.setPreferredSize(new Dimension(0, 50));
		JLabel lblTen = new JLabel("Quan Ly Du Lich");
	
		lblTen.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTen.setForeground(Color.red);
		pnSouth.setBackground(Color.cyan);
		pnSouth.add(lblTen);
		
		
		mnuNV.addActionListener(this);
		mnuKH.addActionListener(this);
	}
	public static void main(String[] args) {
		new Main_Frm();

	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == mnuNV) {
  		  setVisible(false);
  		  new NV_DangNhap().setVisible(true); 
  	  }else if(o == mnuKH) {
  		setVisible(false);
		  new KH_Main_Frm().setVisible(true); 
  	  }
		
	}

}