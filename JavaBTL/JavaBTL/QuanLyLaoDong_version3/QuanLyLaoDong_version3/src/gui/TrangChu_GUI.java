package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.PhanCongLaoDong_DAO;
import entity.QuanLy;

import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TrangChu_GUI extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private JButton btnDangXuat;
	private PhanCongLaoDong_GUI phanCongLaoDong;
	private LichLamViec_GUI lichLamViec;
	private JTabbedPane tabbedPane;

	
	/**
	 * Create the frame.
	 */
	public TrangChu_GUI(QuanLy quanLy){
		setTitle("Quản Lý Lao Động");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1293, 691);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(0, 80, 1294, 591);
		contentPane.add(tabbedPane);
		
		QuanLyCongTrinh_GUI quanLyCongTrinh = new QuanLyCongTrinh_GUI();
		quanLyCongTrinh.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("Quản lý công trình",quanLyCongTrinh);
		tabbedPane.setEnabledAt(0, true);
		QuanLyLaoDong_GUI  quanLyLaoDong = new QuanLyLaoDong_GUI();
		tabbedPane.addTab("Quản lý lao động", quanLyLaoDong);
		phanCongLaoDong = new PhanCongLaoDong_GUI(quanLy);
		lichLamViec = new LichLamViec_GUI();
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(1014, 33, 64, 64);
		contentPane.add(lblNewLabel_1);
		
		JLabel nameAdmin = new JLabel(quanLy.getTenQuanLy());
		nameAdmin.setForeground(new Color(0, 255, 255));
		nameAdmin.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameAdmin.setBounds(1088, 33, 196, 24);
		contentPane.add(nameAdmin);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(204, 153, 204));
		btnDangXuat.setForeground(new Color(0, 51, 102));
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDangXuat.setBounds(1088, 60, 117, 29);
		contentPane.add(btnDangXuat);
		
		JLabel lblNewLabel = new JLabel("CÔNG TY XÂY DỰNG THĂNG LONG");
		lblNewLabel.setBounds(309, 12, 682, 47);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(0, 255, 255));
		
		btnDangXuat.addActionListener(this);
		tabbedPane.addMouseListener(this);
	}


@Override
public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if (o == btnDangXuat) {
		setVisible(false);
		new DangNhap_GUI().setVisible(true);
	}
	
}


@Override
public void mouseClicked(MouseEvent e) {
	int index = tabbedPane.getSelectedIndex();
	if (index == 2)
		phanCongLaoDong.reload();
	if (index == 3)
		lichLamViec.reload();
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
