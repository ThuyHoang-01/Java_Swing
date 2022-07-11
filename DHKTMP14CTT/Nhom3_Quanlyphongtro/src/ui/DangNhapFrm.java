package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DangNhapFrm extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JLabel lbUser, lbPass;
	JTextField txtUser;
	JPasswordField txtPass;
	JButton btnLogIn, btnExit;
	JLabel lbTitle;
	public DangNhapFrm() throws IOException {
		setSize(900, 600);
		setVisible(true);
		setTitle("Quản lý thông tin ở trọ của sinh viên");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container ctn = getContentPane();
		JPanel pnNorth = new JPanel();
		lbTitle = new JLabel("ĐĂNG NHẬP ĐỂ XEM THÔNG TIN");
		Font ft = new Font("arial", Font.BOLD, 25);
		lbTitle.setForeground(Color.magenta);
		lbTitle.setFont(ft);
		ctn.add(pnNorth, BorderLayout.NORTH);
		BufferedImage img = ImageIO.read(new File("images/Logo_IUH.png"));
		JLabel pic = new JLabel(new ImageIcon(img));
		pnNorth.add(pic, BorderLayout.NORTH);
		pnNorth.add(lbTitle);
		
		JPanel pnlCenter=new JPanel();
		Box b=Box.createVerticalBox();
		Box b1=Box.createHorizontalBox();
		Box b2=Box.createHorizontalBox();
		JLabel lblUser, lblPass;
		b1.add(lblUser=new JLabel("User name: "));
		b1.add(txtUser=new JTextField(20));
		b2.add(lblPass=new JLabel("Password: "));
		b2.add(txtPass=new JPasswordField(20));
		lblPass.setPreferredSize(lblUser.getPreferredSize());
		b.add(Box.createVerticalStrut(50));
		b.add(b1);
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		pnlCenter.add(b);
		add(pnlCenter,BorderLayout.CENTER);
		
		JPanel pnlSouth=new JPanel();
		pnlSouth.add(btnLogIn=new JButton("Đăng nhập"));
		btnLogIn.setPreferredSize(new Dimension(100, 25));
		pnlSouth.add(btnExit=new JButton("Thoát"));
		btnExit.setPreferredSize(new Dimension(100, 25));
		add(pnlSouth,BorderLayout.SOUTH);
		
		btnLogIn.addActionListener(this);
		btnExit.addActionListener(this);
		txtPass.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if (txtUser.getText().equals("") || txtPass.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin!");
					} else if (txtUser.getText().equals("admin") && txtPass.getText().equalsIgnoreCase("password")) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
						setVisible(false);
						SwingUtilities.invokeLater(() -> {
							try {
								new MenuFrm();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						});
					} else {
						JOptionPane.showMessageDialog(null, "Bạn đã nhập sai thông tin!");
						setVisible(false);
						SwingUtilities.invokeLater(() -> {
							try {
								new DangNhapFrm();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						});
					}
                }   
			}
		});
		txtUser.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if (txtUser.getText().equals("") || txtPass.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin!");
					} else if (txtUser.getText().equals("admin") && txtPass.getText().equalsIgnoreCase("password")) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
						setVisible(false);
						SwingUtilities.invokeLater(() -> {
							try {
								new MenuFrm();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						});
					} else {
						JOptionPane.showMessageDialog(null, "Bạn đã nhập sai thông tin!");
						setVisible(false);
						SwingUtilities.invokeLater(() -> {
							try {
								new DangNhapFrm();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						});
					}
                }   
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLogIn)) {
			try {
				if (txtUser.getText().equals("") || txtPass.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin!");
				} else if (txtUser.getText().equals("admin") && txtPass.getText().equalsIgnoreCase("password")) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
					setVisible(false);
					SwingUtilities.invokeLater(() -> {
						try {
							new MenuFrm();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					});
					
				} else {
					JOptionPane.showMessageDialog(null, "Bạn đã nhập sai thông tin!");
					setVisible(false);
					SwingUtilities.invokeLater(() -> {
						try {
							new DangNhapFrm();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					});
				}
			} catch (Exception v) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai định dạng!");
				v.printStackTrace();
			}
		} else if (o.equals(btnExit)) {
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new DangNhapFrm();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}

}
