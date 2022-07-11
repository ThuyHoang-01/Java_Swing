package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DangNhap_DAO;
import entity.QuanLy;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class DangNhap_GUI extends JFrame implements ActionListener,ItemListener{

	private JPanel contentPane;
	private JTextField txtMaQuanLy;
	private JButton btnThoat;
	private JButton btnDangNhap;
	private DangNhap_DAO dangNhap_Dao = new DangNhap_DAO();
	private JPasswordField txtMatKhau;
	private JCheckBox cbHienMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					DangNhap_GUI frame = new DangNhap_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap_GUI() {
		setTitle("Công Ty Xây Dựng N16");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(400, 200, 558, 322);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(0, 0, 553, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCngTyXy = new JLabel("CÔNG TY XÂY DỰNG N16");
		lblCngTyXy.setBounds(120, 7, 379, 22);
		panel.add(lblCngTyXy);
		lblCngTyXy.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(204, 204, 255));
		lblNewLabel.setBounds(25, 89, 143, 145);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(178, 49, 375, 32);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_1.setBounds(81, 0, 213, 30);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Mã quản lý:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(178, 122, 124, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMtKhu.setBounds(178, 166, 94, 30);
		contentPane.add(lblMtKhu);
		
		txtMaQuanLy = new JTextField();
		txtMaQuanLy.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtMaQuanLy.setBounds(305, 120, 215, 30);
		contentPane.add(txtMaQuanLy);
		txtMaQuanLy.setColumns(10);
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBackground(new Color(204, 153, 204));
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangNhap.setBounds(199, 230, 143, 35);
		contentPane.add(btnDangNhap);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(204, 153, 204));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBounds(365, 230, 107, 35);
		contentPane.add(btnThoat);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtMatKhau.setBounds(305, 163, 215, 30);
		contentPane.add(txtMatKhau);
		
		txtMaQuanLy.setText("QL000000");
		txtMatKhau.setText("12345678");
		txtMaQuanLy.selectAll();
		txtMaQuanLy.requestFocus();
		txtMatKhau.setEchoChar('*');
		
		cbHienMatKhau = new JCheckBox("Hiển thị mật khẩu");
		cbHienMatKhau.setBackground(new Color(255, 240, 245));
		cbHienMatKhau.setBounds(380, 198, 124, 23);
		contentPane.add(cbHienMatKhau);
		
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
		cbHienMatKhau.addItemListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnThoat) {
			System.exit(0);
		}
		if (o == btnDangNhap) {
			QuanLy quanLy = dangNhap_Dao.getQuanLy(txtMaQuanLy.getText());
			if (quanLy!=null && txtMatKhau.getText().equals(quanLy.getMatKhau())) {
				setVisible(false);
				new TrangChu_GUI(quanLy).setVisible(true);
				
			}
			else JOptionPane.showMessageDialog(this,"Mã quản lý hoặc mật khẩu không chính xác");
		}
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (cbHienMatKhau.isSelected()) {
			txtMatKhau.setEchoChar((char)0);
		}
		else
		{
			txtMatKhau.setEchoChar('*');
		}
		
	}
}
