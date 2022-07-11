package baiTapLon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

public class menu extends JFrame implements ActionListener, MouseInputListener {

	 private static DefaultTableModel tableModel;
     private DefaultTableModel dataModel;
     private JMenuBar mn;
     private JMenu m1, m2, m3, m4, m5, m6, m7;
     private JMenuItem mi1, mi2, mi3, mi4, mi5, mi6, mi7, mi8, mi9, mi10, mi11, mi12, mi13, mi14, mi15;
     private JLabel lbltitle;
    private JButton btnThoat;
 
     public menu(){
	 super("MENU");
	setSize(600,500);
	setVisible(true);
		Form();
     }
     
     
	public void Form(){
	
	JPanel pNorth;
	
	
	JMenu m1 = new JMenu();
	JMenu m2 = new JMenu();
	JMenu m3 = new JMenu();
	JMenu m4 = new JMenu();
	

	
	JMenuBar mn = new JMenuBar();
	setJMenuBar(mn);

	m1 = new JMenu("Thêm");
	m1.add(mi1 = new JMenuItem("Khách Hàng"));
	m1.add(mi11 = new JMenuItem());
	m1.add(mi2 = new JMenuItem("Phòng"));
	Font f = new Font("Time New Roman", Font.BOLD,23);
	Font f2 = new Font("Time New Roman", Font.BOLD,18);
	mi1.setBackground(Color.blue);
	mi2.setBackground(Color.blue);
	mi1.setFont(f2);
	mi2.setFont(f2);
	m1.setFont(f);

	m2 = new JMenu("Xóa");
	m2.add(mi3 = new JMenuItem("Khách Hàng"));
	m2.setFont(f);
	

	mi3.setFont(f2);

	
	m3 = new JMenu("Sửa");
	m3.add(mi5 = new JMenuItem("Khách Hàng"));
	m3.add(mi13 = new JMenuItem());
	m3.add(mi6 = new JMenuItem("Phòng"));
	m3.setFont(f);
	mi5.setBackground(Color.blue);
	mi6.setBackground(Color.blue);
	mi5.setFont(f2);
	mi6.setFont(f2);
	
	m4 = new JMenu("Tìm");
	m4.add(mi7 = new JMenuItem("Khách Hàng"));
	m4.add(mi14 = new JMenuItem());
	m4.add(mi8 = new JMenuItem("Phòng"));
	m4.setFont(f);
	mi7.setBackground(Color.blue);
	mi8.setBackground(Color.blue);
	mi7.setFont(f2);
	mi8.setFont(f2);
	
	m6 = new JMenu("Quản Lý");
	m6.add(mi9 = new JMenuItem(" Quản Lý Đặt Phòng"));
	m6.setFont(f);
	mi9.setBackground(Color.blue);

	mi9.setFont(f2);

	
	m6.setFont(f);
	
	mn.add(m1);
	mn.add(m2);
	mn.add(m3);
	mn.add(m4);
	mn.add(m6);

	JLabel lbl = new JLabel();
	add(lbl);
	try {
        BufferedImage image = ImageIO.read(new File("59459-ho-tram-6-700x700.jpg"));
        ImageIcon icon = new ImageIcon(image.getScaledInstance(600,500, image.SCALE_SMOOTH));
        lbl.setIcon(icon);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
	JPanel pSouth = new JPanel();
	
	
	pSouth.setBorder(BorderFactory.createTitledBorder("Nhóm 9"));
	pSouth.add(lbltitle = new JLabel("Trần Cao Tường - Nguyễn Huy Hảo - Bùi Thị Mỹ Duyên"));
	pSouth.add(btnThoat = new JButton("Thoát"));
	btnThoat.setBackground(Color.red);
	add(pSouth, BorderLayout.SOUTH);
	
	btnThoat.addActionListener(this);
	m6.addActionListener(this);
	mi1.addActionListener(this);
	mi2.addActionListener(this);
	mi3.addActionListener(this);

	mi5.addActionListener(this);
	mi6.addActionListener(this);
	mi7.addActionListener(this);
	mi8.addActionListener(this);
	mi9.addActionListener(this);





	
	
	
}
	@Override
	public void mouseClicked(MouseEvent e) {
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
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();
		
		
		
		if(a.equals(mi1)) {
			setVisible(false);
			new FrmThemKH().setVisible(true);
			
		}
		
		
		if(a.equals(mi2)) {
			setVisible(false);
			new FrmThemPhong().setVisible(true);
			
		}
		
		if(a.equals(mi3)) {
			setVisible(false);
			new FrmXoaKH().setVisible(true);
			
		}
		
		
		if(a.equals(mi4)) {
			setVisible(false);
			
			
		}
		
		if(a.equals(mi5)) {
			setVisible(false);
			new FrmSuaKH().setVisible(true);
			
		}
		
		
		if(a.equals(mi6)) {
			setVisible(false);
			new FrmSuaPhong().setVisible(true);
			
		}
		
		if(a.equals(mi7)) {
			setVisible(false);
			new TimKH().setVisible(true);
			
		}
		
		
		if(a.equals(mi8)) {
			setVisible(false);
			new TimPhong().setVisible(true);
			
		}
		
		if(a.equals(mi9)) {
			setVisible(false);
			new DatPhong().setVisible(true);
			
		}
		
		
		if(a.equals(mi10)) {
			setVisible(false);
			new HoaDon().setVisible(true);
			
		}
		
		
		if(a.equals(btnThoat)){
			setVisible(false);
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		menu a = new menu();
		a.setVisible(true);
	}
}

