package dangKi;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.TitledBorder;

import phongTro.DSPhongTro;
import phongTro.PhongTroForm;
import sinhVien.DSSinhVien;
import sinhVien.SinhVien;



public class DangKyForm extends JFrame implements ActionListener,MouseListener{
	private JLabel lbTitle3;
	private JLabel lbMaSVdk;
	private JLabel lbTendk;
	private JTextField txtMaSVdk;
	private JTextField txtTendk;
	private JLabel lbLopdk;
	private JTextField txtLopdk;
	private JLabel lbQuedk;
	private JTextField txtQuedk;
	private JLabel lbKhoadk;
	private JTextField txtKhoadk;
	private JLabel lbMaPhongdk;
	private JComboBox cbTimPTDK;
	private JLabel lbSDTdk;
	private DSPhongTro dsphongtro = new DSPhongTro();
	private DSSinhVien dssinhvien = new DSSinhVien();
	private JTextField txtSDTdk;
	private JLabel lbDCdk;
	private JTextField txtDCdk;
	private JLabel lbchuNhaDK;
	private JTextField txtchuNhaDK;
	private JLabel lbDcChuNhadk;
	private JTextField txtDcChuNhadk;
	private JLabel lbltientrodk;
	private JTextField txttientrodk;
	private JButton btnDangKy;
	private Object btnthem;
	private Object btnxoa;
	private Object btnsua;
	private Object btntimsv;
	private Object btntimpt;
	private Object btncapnhatpt;
	private AbstractButton tableSV;
	private AbstractButton txtMaSV;
	private AbstractButton txtTen;
	private AbstractButton txtLop;
	private AbstractButton txtKhoa;
	private AbstractButton txtQue;
	private JComboBox cbmaphong;
	private AbstractButton txtNhap;
	private JTextField txtMaPhong;

	public DangKyForm() {
		super("Thông Tin Phòng Trọ");
		setSize(900,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		control();
		
	}

	private void control() {
		Box BoxDK = Box.createVerticalBox();
		Box BoxDKSV = Box.createVerticalBox();
		Box BoxDKPT = Box.createVerticalBox();
		Box boxdk0 = Box.createHorizontalBox();
		Box boxdksv1 = Box.createHorizontalBox();
		Box boxdksv2 = Box.createHorizontalBox();
		Box boxdksv3 = Box.createHorizontalBox();

		Box boxdkpt1 = Box.createHorizontalBox();
		Box boxdkpt2 = Box.createHorizontalBox();
		Box boxdkpt3 = Box.createHorizontalBox();

		boxdk0.add(lbTitle3 = new JLabel("ĐĂNG KÝ PHÒNG TRỌ"));
		lbTitle3.setFont(new java.awt.Font("Tahoma", 1, 40));
		lbTitle3.setForeground(new java.awt.Color(255, 0, 153));

		BoxDK.add(Box.createVerticalStrut(5));
		BoxDK.add(boxdk0);
		BoxDK.add(Box.createVerticalStrut(5));
		BoxDK.add(BoxDKSV);
		BoxDK.add(Box.createVerticalStrut(5));
		BoxDK.add(BoxDKPT);

		TitledBorder title6 = new TitledBorder("Thông tin sinh viên");
		title6.setTitleFont(new java.awt.Font("Tahoma", 1, 11));
		title6.setTitleColor(new java.awt.Color(255, 0, 153));
		BoxDKSV.setBorder(new TitledBorder(title6));
		TitledBorder title7 = new TitledBorder("Thông tin phòng trọ");
		title7.setTitleFont(new java.awt.Font("Tahoma", 1, 11));
		title7.setTitleColor(new java.awt.Color(255, 0, 153));
		BoxDKPT.setBorder(new TitledBorder(title7));

		BoxDKSV.add(Box.createVerticalStrut(32));
		BoxDKSV.add(boxdksv1);
		BoxDKSV.add(Box.createVerticalStrut(10));
		BoxDKSV.add(boxdksv2);
		BoxDKSV.add(Box.createVerticalStrut(10));
		BoxDKSV.add(boxdksv3);
		BoxDKSV.add(Box.createVerticalStrut(32));

		BoxDKPT.add(Box.createVerticalStrut(32));
		BoxDKPT.add(boxdkpt1);
		BoxDKPT.add(Box.createVerticalStrut(10));
		BoxDKPT.add(boxdkpt2);
		BoxDKPT.add(Box.createVerticalStrut(10));
		BoxDKPT.add(boxdkpt3);
		BoxDKPT.add(Box.createVerticalStrut(32));

		boxdksv1.add(Box.createHorizontalStrut(50));
		boxdksv1.add(lbMaSVdk = new JLabel("Mã SV: "));
		boxdksv1.add(txtMaSVdk = new JTextField(10));
		boxdksv1.add(Box.createHorizontalStrut(50));
		boxdksv1.add(lbTendk = new JLabel("Họ Tên: "));
		boxdksv1.add(txtTendk = new JTextField(10));
		boxdksv1.add(Box.createHorizontalStrut(50));

		boxdksv2.add(Box.createHorizontalStrut(50));
		boxdksv2.add(lbLopdk = new JLabel("Lớp: "));
		boxdksv2.add(txtLopdk = new JTextField(10));
		boxdksv2.add(Box.createHorizontalStrut(50));
		boxdksv2.add(lbQuedk = new JLabel("Quê Quán: "));
		boxdksv2.add(txtQuedk = new JTextField(10));
		boxdksv2.add(Box.createHorizontalStrut(50));

		boxdksv3.add(Box.createHorizontalStrut(50));
		boxdksv3.add(lbKhoadk = new JLabel("Khoa: "));
		boxdksv3.add(txtKhoadk = new JTextField(10));
		boxdksv3.add(Box.createHorizontalStrut(490));
		boxdkpt1.add(Box.createHorizontalStrut(50));
		boxdkpt1.add(lbMaPhongdk = new JLabel("Mã Phòng: "));
		boxdkpt1.add(txtMaPhong = new JTextField(100));
		
		boxdkpt1.add(Box.createHorizontalStrut(345));
		boxdkpt1.add(lbSDTdk = new JLabel("Số Điện Thoại: "));
		boxdkpt1.add(Box.createHorizontalStrut(5));
		boxdkpt1.add(txtSDTdk = new JTextField(100));
		boxdkpt1.add(Box.createHorizontalStrut(40));

		boxdkpt2.add(Box.createHorizontalStrut(50));
		boxdkpt2.add(lbDCdk = new JLabel("Địa Chỉ: "));
		boxdkpt2.add(txtDCdk = new JTextField(20));
		boxdkpt2.add(Box.createHorizontalStrut(10));
		boxdkpt2.add(lbchuNhaDK = new JLabel("Chủ Nhà: "));
		boxdkpt2.add(txtchuNhaDK = new JTextField(10));
		boxdkpt2.add(Box.createHorizontalStrut(40));

		boxdkpt3.add(Box.createHorizontalStrut(50));
		boxdkpt3.add(lbDcChuNhadk = new JLabel("Đ/c Chủ Nhà: "));
		boxdkpt3.add(txtDcChuNhadk = new JTextField(10));
		boxdkpt3.add(Box.createHorizontalStrut(10));
		boxdkpt3.add(lbltientrodk=new JLabel("Tiền Trọ:"));
		boxdkpt3.add(txttientrodk=new JTextField());
		boxdkpt3.add(Box.createHorizontalStrut(40));

		lbLopdk.setPreferredSize(lbDcChuNhadk.getPreferredSize());
		lbMaSVdk.setPreferredSize(lbDcChuNhadk.getPreferredSize());
		lbKhoadk.setPreferredSize(lbDcChuNhadk.getPreferredSize());
		lbMaPhongdk.setPreferredSize(lbDcChuNhadk.getPreferredSize());
		lbDCdk.setPreferredSize(lbDcChuNhadk.getPreferredSize());

		lbTendk.setPreferredSize(lbSDTdk.getPreferredSize());
		lbQuedk.setPreferredSize(lbSDTdk.getPreferredSize());
		lbchuNhaDK.setPreferredSize(lbSDTdk.getPreferredSize());
		lbltientrodk.setPreferredSize(lbSDTdk.getPreferredSize());
		getContentPane().add(BoxDK, BorderLayout.NORTH);
		JPanel panelDangKy = new JPanel();
		panelDangKy.add(btnDangKy = new JButton("Đăng Ký"));
		btnDangKy.setMargin(new Insets(4, 45, 4, 45));
		btnDangKy.setMnemonic(KeyEvent.VK_D);
		TitledBorder title8 = new TitledBorder("Đăng ký");
		title8.setTitleFont(new java.awt.Font("Tahoma", 1, 11));
		title8.setTitleColor(new java.awt.Color(255, 0, 153));
		panelDangKy.setBorder(new TitledBorder(title8));
		getContentPane().add(panelDangKy, BorderLayout.SOUTH);
		
		addkeyevent(txtKhoadk, btnDangKy);

		// LoadDatasv();
		//updateTableDataSV();
		

		setSize(1000, 650);
		setTitle("QL_Phong_Tro");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void addkeyevent(JTextField txtKhoadk2, JButton btnDangKy2) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String []args) {
		DangKyForm dao=new DangKyForm();
		new DangKyForm().setVisible(true);
	}

	public JButton createButton(String btnname, String url) {
		JButton btn = new JButton(btnname, new ImageIcon(url));
		btn.addActionListener(this);
		btn.setBackground(new java.awt.Color(51, 153, 255));
		btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		btn.setForeground(new java.awt.Color(255, 255, 255));
		return btn;
	}
	
	
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	}


