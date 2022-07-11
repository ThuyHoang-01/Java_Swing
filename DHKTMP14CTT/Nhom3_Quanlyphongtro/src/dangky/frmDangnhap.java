package dangky;

import javax.swing.*;



import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

import java.awt.Font;
import java.awt.List;
import java.awt.Window;

import javax.swing.text.JTextComponent;

public class frmDangnhap extends JFrame implements ActionListener   {
	DanhSachTaiKhoan dao;  
	public String FILENAME = "dulieu.txt";
	JButton btnLogin, btnReset;
	JTextField txttUser;
	JPasswordField txtPass;
	JLabel lblMessager;

	public frmDangnhap() {

		setTitle("Quản lý Nhà trọ");
		setBounds(100, 100, 312, 287);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);

		JLabel lblNewLabel = new JLabel("Người dùng:");
		lblNewLabel.setBounds(25, 75, 77, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
		lblNewLabel_1.setBounds(25, 113, 71, 14);
		getContentPane().add(lblNewLabel_1);

		txttUser = new JTextField();
		txttUser.setBounds(103, 72, 119, 23);
		getContentPane().add(txttUser);
		txttUser.setColumns(10);



		lblMessager = new JLabel("");
		lblMessager.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessager.setBounds(21, 208, 265, 26);
		getContentPane().add(lblMessager);

		btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(30, 173, 100, 23);
		getContentPane().add(btnLogin);


		JLabel lblLogin = new JLabel("ĐĂNG NHẬP");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLogin.setBounds(90, 11, 568, 40);
		getContentPane().add(lblLogin);

		txtPass = new JPasswordField();
		txtPass.setBounds(103, 110, 119, 23);
		getContentPane().add(txtPass);

		btnReset = new JButton("Nhập lại");
		btnReset.addActionListener(this);
		btnReset.setBounds(160, 173, 100, 23);
		getContentPane().add(btnReset);
		LoadDatabase();


	}


	void LoadDatabase() {
		BufferedReader br = null;
		dao = new DanhSachTaiKhoan();
		try {
			if (new File(FILENAME).exists()) {
				br = new BufferedReader (new FileReader(FILENAME));
				br.readLine();

			}while(br.ready()) 
			{
				String line = br.readLine();
				if(line !=null &&! line.trim().equals("")) {
					String[]a = line.split(";");
					TaiKhoan tk = new TaiKhoan(Integer.parseInt(a[0]),a[1],a[2]);
					dao.themNhanVien(tk);
				}
			}
		}catch(Exception ex ) {
			ex.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnReset)) {
			txttUser.setText("");
			txtPass.setText("");
			lblMessager.setText("");
		}
		if (o.equals(btnLogin)) {
			
			boolean Kq = true;
			Kq = dao.timUserandPass(txttUser.getText(), txtPass.getText());
			//int maTaiKhoan = Integer.parseInt(txttUser.getText());
			//Kq = dao.xoaTaiKhoan(maTaiKhoan );
			if (Kq) {
					if (txttUser.getText().equalsIgnoreCase("admin")&& txtPass.getText().equalsIgnoreCase("123456")) {
						setVisible(false);
						new frmDangKy(dao);
					} 
						else {
							setVisible(false);
							new MenuDK();	}	
			
			} else {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai thông tin!");
				setVisible(false);	}
					}
			}			
	}