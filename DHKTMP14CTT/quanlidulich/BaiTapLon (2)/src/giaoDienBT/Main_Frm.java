package giaoDienBT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import enTiTy.CarriageTrip;
import thucThi.DaoNV_SauDN;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class Main_Frm {

	private JFrame frame;
	private JTextField txtCT1;
	private JTextField txtCT2;
	private JTextField txtCT3;
	private JTextField txtCT4;
	private JTextField txtHN1;
	private JTextField txtHN2;
	private JTextField txtHN3;
	private JTextField txtHN4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtNT1;
	private JTextField txtNT2;
	private JTextField txtNT3;
	private JTextField txtNT4;
	private JTextField textField_2;
	private JTextField txtDL1;
	private JTextField txtDL2;
	private JTextField txtDL3;
	private JTextField txtDL4;
	private JTextField txtTN1;
	private JTextField txtTN2;
	private JTextField txtTN3;
	private JTextField txtTN4;
	private JTextField txtAG1;
	private JTextField txtAG2;
	private JTextField txtAG3;
	private JTextField txtAG4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Frm window = new Main_Frm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Frm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 50, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel lblN = new JLabel();
		lblN.setBounds(10, 0, 964, 230);
		frame.getContentPane().add(lblN);
		try {
			BufferedImage image = ImageIO.read(new File("img/mainN.png"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(964, 230, java.awt.Image.SCALE_SMOOTH));
			lblN.setIcon(im);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblS = new JLabel();
		lblS.setBounds(10, 568, 974, 82);
		frame.getContentPane().add(lblS);
		try {
			BufferedImage image = ImageIO.read(new File("img/mainS.png"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(964, 82, java.awt.Image.SCALE_SMOOTH));
			lblS.setIcon(im);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			JButton btnCT = new JButton("");
			btnCT.setBounds(10, 254, 153, 131);
			frame.getContentPane().add(btnCT);
			BufferedImage image = ImageIO.read(new File("img/CanTho.jpg"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(153, 131, java.awt.Image.SCALE_SMOOTH));
			btnCT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					new DangNhap().setVisible(true);
				}
			});
			btnCT.setIcon(im);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			JButton btnHN = new JButton("");
			btnHN.setBounds(352, 254, 153, 131);
			frame.getContentPane().add(btnHN);
			BufferedImage image = ImageIO.read(new File("img/HaNoi.jpg"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(163, 131, java.awt.Image.SCALE_SMOOTH));
			btnHN.setIcon(im);
			btnHN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					new DangNhap().setVisible(true);
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			JButton btnNT = new JButton("");
			btnNT.setBounds(680, 254, 153, 131);
			frame.getContentPane().add(btnNT);
			BufferedImage image = ImageIO.read(new File("img/NhaTrang.png"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(153, 131, java.awt.Image.SCALE_SMOOTH));
			btnNT.setIcon(im);
			btnNT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					new DangNhap().setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			JButton btnDL = new JButton();
			btnDL.setBounds(10, 418, 153, 131);
			frame.getContentPane().add(btnDL);
			BufferedImage image = ImageIO.read(new File("img/DakLak.jpg"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(163, 131, java.awt.Image.SCALE_SMOOTH));
			btnDL.setIcon(im);
			btnDL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					new DangNhap().setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			JButton btnTN = new JButton("");
			btnTN.setBounds(352, 418, 153, 131);
			frame.getContentPane().add(btnTN);
			BufferedImage image = ImageIO.read(new File("img/TayNinh.png"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(153, 131, java.awt.Image.SCALE_SMOOTH));
			btnTN.setIcon(im);
			btnTN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					new DangNhap().setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			JButton btnAG = new JButton("");
			btnAG.setBounds(680, 418, 153, 131);
			frame.getContentPane().add(btnAG);
			BufferedImage image = ImageIO.read(new File("img/AnGiang.jpg"));
			ImageIcon im = new ImageIcon(image.getScaledInstance(153, 131, java.awt.Image.SCALE_SMOOTH));
			btnAG.setIcon(im);
			btnAG.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					new DangNhap().setVisible(true);
				}
			});
			{
				JButton btnNewButton = new JButton("Đăng Nhập");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame.setVisible(false);
						new DangNhap().setVisible(true);
					}
				});
				btnNewButton.setBounds(20, 23, 109, 23);
				frame.getContentPane().add(btnNewButton);
			}
			{
				JButton btnngK = new JButton("Đăng Ký");
				btnngK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
						new KH_DangKy().setVisible(true);
					}
				});
				btnngK.setBounds(139, 23, 109, 23);
				frame.getContentPane().add(btnngK);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		DaoNV_SauDN nv = new DaoNV_SauDN();
		List<CarriageTrip> ls = nv.docTT();
		for (CarriageTrip c : ls) {
			if (c.getId() == 5) {

				txtCT1 = new JTextField();
				txtCT1.setBounds(173, 256, 140, 20);
				frame.getContentPane().add(txtCT1);
				txtCT1.setColumns(10);
				txtCT1.setText("" + c.getAddress());
				txtCT1.setEditable(false);txtCT1.setForeground(Color.black);

				txtCT2 = new JTextField();
				txtCT2.setBounds(173, 290, 140, 20);
				frame.getContentPane().add(txtCT2);
				txtCT2.setColumns(10);
				txtCT2.setText("Ngày đi : " + c.getNgayBatDau());
				txtCT2.setEditable(false);txtCT2.setForeground(Color.black);

				txtCT3 = new JTextField();
				txtCT3.setBounds(173, 327, 140, 20);
				frame.getContentPane().add(txtCT3);
				txtCT3.setColumns(10);
				txtCT3.setText("Ngày về : " + c.getNgayKetThuc());
				txtCT3.setEditable(false);txtCT3.setForeground(Color.black);

				txtCT4 = new JTextField();
				txtCT4.setBounds(173, 365, 140, 20);
				frame.getContentPane().add(txtCT4);
				txtCT4.setColumns(10);
				txtCT4.setText("Giá : " + c.getDonGia());
				txtCT4.setEditable(false);txtCT4.setForeground(Color.black);
			}
			if(c.getId()==2)
			{
				txtHN1 = new JTextField();
				txtHN1.setBounds(510, 256, 140, 20);
				frame.getContentPane().add(txtHN1);
				txtHN1.setColumns(10);
				txtHN1.setText("" + c.getAddress());
				txtHN1.setEditable(false);txtHN1.setForeground(Color.black);
			
				txtHN2 = new JTextField();
				txtHN2.setBounds(510, 290, 140, 20);
				frame.getContentPane().add(txtHN2);
				txtHN2.setColumns(10);
				txtHN2.setText("Ngày đi : " + c.getNgayBatDau());
				txtHN2.setEditable(false);txtHN2.setForeground(Color.black);
			
				txtHN3 = new JTextField();
				txtHN3.setBounds(510, 327, 140, 20);
				frame.getContentPane().add(txtHN3);
				txtHN3.setColumns(10);
				txtHN3.setText("Ngày về : " + c.getNgayKetThuc());
				txtHN3.setEditable(false);txtHN3.setForeground(Color.black);
			
				txtHN4 = new JTextField();
				txtHN4.setBounds(510, 365, 140, 20);
				frame.getContentPane().add(txtHN4);
				txtHN4.setColumns(10);
				txtHN4.setText("Giá : " + c.getDonGia());
				txtHN4.setEditable(false);txtHN4.setForeground(Color.black);
			}
			if(c.getId()==3)
			{
				txtNT1 = new JTextField();
				txtNT1.setBounds(840, 256, 140, 20);
				frame.getContentPane().add(txtNT1);
				txtNT1.setColumns(10);
				txtNT1.setText("" + c.getAddress());
				txtNT1.setEditable(false);txtNT1.setForeground(Color.black);
			
				txtNT2 = new JTextField();
				txtNT2.setBounds(840, 290, 140, 20);
				frame.getContentPane().add(txtNT2);
				txtNT2.setColumns(10);
				txtNT2.setText("Ngày đi : " + c.getNgayBatDau());
				txtNT2.setEditable(false);txtNT2.setForeground(Color.black);
			
				txtNT3 = new JTextField();
				txtNT3.setBounds(840, 327, 140, 20);
				frame.getContentPane().add(txtNT3);
				txtNT3.setColumns(10);
				txtNT3.setText("Ngày về : " + c.getNgayKetThuc());
				txtNT3.setEditable(false);txtNT3.setForeground(Color.black);
			
				txtNT4 = new JTextField();
				txtNT4.setBounds(840, 365, 140, 20);
				frame.getContentPane().add(txtNT4);
				txtNT4.setColumns(10);
				txtNT4.setText("Giá : " + c.getDonGia());
				txtNT4.setEditable(false);txtNT4.setForeground(Color.black);
			}
			if(c.getId()==1)
			{
				txtDL1 = new JTextField();
				txtDL1.setBounds(173, 418, 140, 20);
				frame.getContentPane().add(txtDL1);
				txtDL1.setColumns(10);
				txtDL1.setText("" + c.getAddress());
				txtDL1.setEditable(false);txtDL1.setForeground(Color.black);
				
				txtDL2 = new JTextField();
				txtDL2.setBounds(173, 452, 140, 20);
				frame.getContentPane().add(txtDL2);
				txtDL2.setColumns(10);
				txtDL2.setText("Ngày đi : " + c.getNgayBatDau());
				txtDL2.setEditable(false);txtDL2.setForeground(Color.black);
			
				txtDL3 = new JTextField();
				txtDL3.setBounds(173, 491, 140, 20);
				frame.getContentPane().add(txtDL3);
				txtDL3.setColumns(10);
				txtDL3.setText("Ngày về : " + c.getNgayKetThuc());
				txtDL3.setEditable(false);txtDL3.setForeground(Color.black);
			
				txtDL4 = new JTextField();
				txtDL4.setBounds(173, 529, 140, 20);
				frame.getContentPane().add(txtDL4);
				txtDL4.setColumns(10);
				txtDL4.setText("Giá : " + c.getDonGia());
				txtDL4.setEditable(false);txtDL4.setForeground(Color.black);
				
			}
			if(c.getId()==4)
			{
				txtTN1 = new JTextField();
				txtTN1.setBounds(510, 418, 140, 20);
				frame.getContentPane().add(txtTN1);
				txtTN1.setColumns(10);
				txtTN1.setText("" + c.getAddress());
				txtTN1.setEditable(false);txtTN1.setForeground(Color.black);
				
				txtTN2 = new JTextField();
				txtTN2.setBounds(510, 452, 140, 20);
				frame.getContentPane().add(txtTN2);
				txtTN2.setColumns(10);
				txtTN2.setText("Ngày đi : " + c.getNgayBatDau());
				txtTN2.setEditable(false);txtTN2.setForeground(Color.black);
			
				txtTN3 = new JTextField();
				txtTN3.setBounds(510, 491, 140, 20);
				frame.getContentPane().add(txtTN3);
				txtTN3.setColumns(10);
				txtTN3.setText("Ngày về : " + c.getNgayKetThuc());
				txtTN3.setEditable(false);txtTN3.setForeground(Color.black);
			
				txtTN4 = new JTextField();
				txtTN4.setBounds(510, 529, 140, 20);
				frame.getContentPane().add(txtTN4);
				txtDL4.setColumns(10);
				txtTN4.setText("Giá : " + c.getDonGia());
				txtTN4.setEditable(false);txtTN4.setForeground(Color.black);
				
			}
			if(c.getId()==6)
			{
				txtAG1 = new JTextField();
				txtAG1.setBounds(840, 418, 140, 20);
				frame.getContentPane().add(txtAG1);
				txtAG1.setColumns(10);
				txtAG1.setText("" + c.getAddress());
				txtAG1.setEditable(false);txtAG1.setForeground(Color.black);
				
				txtAG2 = new JTextField();
				txtAG2.setBounds(840, 452, 140, 20);
				frame.getContentPane().add(txtAG2);
				txtAG2.setColumns(10);
				txtAG2.setText("Ngày đi : " + c.getNgayBatDau());
				txtAG2.setEditable(false);txtAG2.setForeground(Color.black);
			
				txtAG3 = new JTextField();
				txtAG3.setBounds(840, 491, 140, 20);
				frame.getContentPane().add(txtAG3);
				txtAG3.setColumns(10);
				txtAG3.setText("Ngày về : " + c.getNgayKetThuc());
				txtAG3.setEditable(false);txtAG3.setForeground(Color.black);
			
				txtAG4 = new JTextField();
				txtAG4.setBounds(840, 529, 140, 20);
				frame.getContentPane().add(txtAG4);
				txtAG4.setColumns(10);
				txtAG4.setText("Giá : " + c.getDonGia());
				txtAG4.setEditable(false);txtAG4.setForeground(Color.black);
				
			}
		}
		
		

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	
}
