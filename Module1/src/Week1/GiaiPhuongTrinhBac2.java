package Week1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GiaiPhuongTrinhBac2 extends JFrame implements ActionListener{
	JLabel lblTitle , lblNhapa , lblNhapb , lblNhapc , lblKq ;
	JTextField txtNhapa , txtNhapb , txtNhapc , txtKq ;
	JButton btnGiai , btnXoaRong , btnThoat ;

	public GiaiPhuongTrinhBac2() {
		super("^_^");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);// khong cho thay doi kich thuoc frame
		addControlls();
		setVisible(true);
	}

	public void addControlls() {
		//pNorth
		JPanel pNorth = new JPanel();
		pNorth.add(lblTitle = new JLabel(" GIAI PHƯƠNG TRÌNH BẬC HAI "));
		Font f = new Font("Time new Roman", Font.BOLD,18);
		lblTitle.setFont(f);
		pNorth.setBackground(Color.YELLOW);
		add(pNorth,BorderLayout.NORTH);
		
		//pCen
		JPanel pCen = new JPanel();
		pCen.add(lblNhapa = new JLabel("Nhập a :"));
		pCen.add(txtNhapa = new JTextField(20));
		
		pCen.add(lblNhapb = new JLabel("Nhập b :"));
		pCen.add(txtNhapb = new JTextField(20));
		
		pCen.add(lblNhapc = new JLabel("Nhập c :"));
		pCen.add(txtNhapc = new JTextField(20));
		
		pCen.add(lblKq = new JLabel(" Kết quả :"));
		pCen.add(txtKq = new JTextField(20));
		txtKq.setEditable(false); // nguoi dung khong duooc chinh sưa trong text
		add(pCen,BorderLayout.CENTER);
		
		//pSouth
		
		JPanel pSou = new JPanel();
		pSou.setBorder(BorderFactory.createTitledBorder(" Chọn tác vụ "));// đường viên xung quanh 
		//
		pSou.add(btnGiai = new JButton("Gỉai"));
		pSou.add(btnThoat = new JButton("Thoát"));
		pSou.add(btnXoaRong = new JButton(" Xóa Rỗng"));
		add(pSou,BorderLayout.SOUTH);
		
		
		btnGiai.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnThoat.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		setVisible(true);
		setResizable(false);// Khong cho doi kich thuoc frame
	
		
			
		
	}
	public static void main(String[] args) {
		new GiaiPhuongTrinhBac2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int a,b,c , denlta;
		double x1,x2,kq;
		
		a = Integer.parseInt(txtNhapa.getText());
		b = Integer.parseInt(txtNhapb.getText());
		c = Integer.parseInt(txtNhapc.getText());
		
		Object source = e.getSource();
		
		if(source.equals(btnGiai)) {
			denlta = (b*b)-(4*a*c);
			
			if(denlta<0) {
				txtKq.setText(" Phương trình vô nghiệm");			
			
				}
			else if (denlta == 0) {
					x1 = x2 = -1.0 * b / (2 * a);
					txtKq.setText(" Phương trình có nghiệm kép là :" + Double.toString(x1));
				}
			
				else {
					x1 = (-1.0 * b + Math.sqrt(denlta) / (2 * a));
					x2 = (-1.0 * b - Math.sqrt(denlta) / (2 * a));
					txtKq.setText("Nghiệm x1 =" + Double.toString(x1) + "  , Nghiệm x2 =" + Double.toString(x2));
				}
	}
		else if (source.equals(btnXoaRong)) {
			txtNhapa.setText("");
			txtNhapb.setText("");
			txtNhapc.setText("");
			txtKq.setText("");
		
		}
		
		else {
			System.exit(0);
		}
	}
}
