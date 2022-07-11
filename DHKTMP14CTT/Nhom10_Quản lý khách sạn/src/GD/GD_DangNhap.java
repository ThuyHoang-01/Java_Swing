package GD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GD_DangNhap extends JFrame implements ActionListener {
	private	JTextField	tfUser;	
	private JButton btnLogin;
	private JPasswordField tfpass;
	private JLabel lblTieude;
	 	public GD_DangNhap() {
		setTitle("Đăng Nhập");
		 setSize(350,300);	
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setResizable(false);	
		 setVisible(true);
		 
		 JPanel pNorth = new JPanel();
		 pNorth.setBorder(BorderFactory.createLineBorder(Color.RED));
		 pNorth.add(lblTieude = new JLabel("Đăng Nhập"));
		 lblTieude.setFont(new Font ("Arial", Font.BOLD,25));
		add(pNorth,BorderLayout.NORTH);
		
		
		JPanel pCen = new JPanel();
		pCen.setBorder(BorderFactory.createLineBorder(Color.RED));
	
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		JLabel	lblUser,	lblPass;	
		b1.add(lblUser = new JLabel("User Name:"));
		lblUser.setFont(new Font("Time new Romen",	Font.PLAIN,	15));
		b1.add(tfUser= new JTextField(20));
	
		b2.add(lblPass= new JLabel("Password:"));
		lblPass.setFont(new Font("ime new Romen",	Font.PLAIN,	15));
		b2.add(tfpass = new JPasswordField(20));
		lblPass.setPreferredSize(lblUser.getPreferredSize());
		b3.add(btnLogin= new JButton("Login"));
		b.add(Box.createVerticalStrut(80));
		
		b.add(b1);
		b.add(b2);
		b.add(b3);
		pCen.add(b);
		add(pCen,BorderLayout.CENTER);
		
		tfUser.addActionListener(this);
		tfpass.addActionListener(this);
		btnLogin.addActionListener(this);
	 	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		char[] correctPass= {'t','h','i','n','h'};
		
		if(e.getSource().equals(btnLogin)
				|| e.getSource().equals(tfUser)
				|| e.getSource().equals(tfpass)){
			if(tfUser.getText().equalsIgnoreCase("Thinh")&& 
			Arrays.equals(tfpass.getPassword(),correctPass)){
				//JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
				 new Menu().setVisible(true);
				 this.setVisible(false);
			}else{	
				 JOptionPane.showMessageDialog(null, "Sai username hoặc	 password!");
				 tfUser.requestFocus();	
			}
			}
	}
	 
	public static void main (String[] args) {
		 new GD_DangNhap().setVisible(true);
	 }
	public void display() {
		// TODO Auto-generated method stub
		
	}
	


}
