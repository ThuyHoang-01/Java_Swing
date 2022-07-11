package app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

public class FrmMenu extends JFrame implements ActionListener{
	 private static DefaultTableModel tableModel;
     private DefaultTableModel dataModel;
     private JMenuBar mn;
     private JMenu m1, m2, m3, m4;
     private JMenuItem mi1, mi2, mi3, mi4;
     private JLabel lbltitle;
	public FrmMenu() {
		setTitle("Menu");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pNorth, pSouth, pCen = new JPanel();
		
		JMenu m1 = new JMenu();
		JMenu m2 = new JMenu();
		JMenu m3 = new JMenu();
		JMenu m4 = new JMenu();
		

		
		JMenuBar mn = new JMenuBar();
		setJMenuBar(mn);

		m1 = new JMenu("Khách hàng");
		m1.add(mi1 = new JMenuItem("Đăng nhập"));
		m1.add(mi2 = new JMenuItem("Đăng ký"));
	
		m2 = new JMenu("Nhân viên");
		m2.add(mi3 = new JMenuItem("Quản lý nhân viên"));

		m3 = new JMenu("Băng đĩa");
		m3.add(mi4 = new JMenuItem("Quản lý băng đĩa"));
		
		mn.add(m1);
		mn.add(m2);
		mn.add(m3);		
		
		BufferedImage myPic = null;
		try {
			myPic= ImageIO.read(new File("hinhnen.jpg"));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPic));
		pCen.add(picLabel);
		add(pCen,BorderLayout.CENTER);
		
		pSouth = new JPanel();
		add(pSouth, BorderLayout.SOUTH);
		pSouth.add(lbltitle = new JLabel("Cho thuê băng đĩa"));
		Font fp = new Font("Time New Roman", Font.BOLD, 50);
		lbltitle.setFont(fp);
		pSouth.setBackground(Color.LIGHT_GRAY);
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
	}
	public static void main(String[] args) {
		new FrmMenu().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(mi1)) {
			this.setVisible(false);
			new FrmDangNhapTV().setVisible(true);
		}else if(o.equals(mi2)) {
			this.setVisible(false);
			new FrmDangKyTV().setVisible(true);
		}else if(o.equals(mi3)) {
			this.setVisible(false);
			new FrmNhanVien().setVisible(true);
		}else if(o.equals(mi4)) {
			this.setVisible(false);
			new FrmDanhMucBangDia().setVisible(true);
		}
		
	}
}
