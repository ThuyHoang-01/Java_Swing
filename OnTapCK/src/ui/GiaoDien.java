package ui;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GiaoDien extends JFrame {
	
	private JTable tableNhanVien;
	private DefaultTableModel modelNhanVien;
	JLabel lblMa , lblHo , lblTen , lblTienluong , lblPhongban ;
	JTextField txtMa , txtHo , txtTen , txtTienluong , txtTim ; 
	JButton btnXoa , btnThem , btnXoaRong , btnLuu , btnTim ;
	private JComboBox<String> cboPhongBan;
	
	
	public GiaoDien() {
		super(" Kiểm Tra Cuối Kì ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);// khong cho thay doi kich thuoc frame
		addControlls();
		setVisible(true);
	}
	
	public void addControlls() {
		//pNor
		Box b = Box.createVerticalBox();

		Box b11, b1, b2, b3 , b4 , b5;
		JLabel lblMa,lblTen,lblPhongban, lblHo  = null;

		

		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMa = new JLabel(" Mã nhân viên :   "));
		b1.add(txtMa = new JTextField());
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblHo=new JLabel("Ho: "));
		b2.add(txtHo = new JTextField());
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTen=new JLabel("Tên : "));
		b2.add(txtTen = new JTextField());
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblPhongban =new JLabel(" Phòng ban : "));
		b3.add(cboPhongBan = new JComboBox<String>());
		cboPhongBan.setEditable(true);	

		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTen=new JLabel("Tiền lương : "));
		b2.add(txtTienluong = new JTextField());
		
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);// khong cho thay doi kich thuoc frame
		addControlls();
		setVisible(true);
		
		
	}
	
	
	
	public static void main(String[] args) {
		new GiaoDien();
	}
	

}
