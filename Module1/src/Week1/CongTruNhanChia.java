package Week1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class CongTruNhanChia extends JFrame implements ActionListener {
	JLabel lbTitle, lbNhapA, lbNhapB, lbKQ;
	JTextField txtNhapA, txtNhapB, txtKQ;
	JRadioButton radCong, radTru, radNhan, radChia;
	JButton btnGiai, btnXoa, btnThoat;

	public void addControls() { // de cho cac lop thong nhat {
		// NORTH 
	// chữ là lable
	// button là nút 
	//  setedit
	// setdimntion
		JPanel pNor = new JPanel();
		pNor.add(lbTitle = new JLabel(" Cộng Trừ Nhân Chia "));
		Font f = new Font("Time new Roman", Font.BOLD,18);
		lbTitle.setFont(f);
		lbTitle.setForeground(Color.BLUE);
		add(pNor, BorderLayout.NORTH);

		// CENTER
		JPanel pCenter = new JPanel();
		Border cenBorder = BorderFactory.createLineBorder(Color.RED);
		pCenter.setBorder(new TitledBorder(cenBorder, "Tính toán "));
		pCenter.add(lbNhapA = new JLabel("Nhập a:"));
		pCenter.add(txtNhapA = new JTextField(20));
		pCenter.add(lbNhapB = new JLabel("Nhập b:"));
		pCenter.add(txtNhapB = new JTextField(20));
		

		JPanel pPhepToan = new JPanel();
		pPhepToan.setLayout(new GridLayout(2, 2));
		pPhepToan.setBorder(BorderFactory.createTitledBorder("Phép toán : "));
		pPhepToan.add(radCong = new JRadioButton("Cộng"));
		pPhepToan.add(radTru = new JRadioButton("Trừ"));
		pPhepToan.add(radNhan = new JRadioButton("Nhân"));
		pPhepToan.add(radChia = new JRadioButton("Chia"));
		ButtonGroup group = new ButtonGroup();
		group.add(radCong);
		group.add(radTru);
		group.add(radNhan);
		group.add(radChia);
		add(pPhepToan, BorderLayout.CENTER);
		pCenter.add(pPhepToan);

		JPanel pKetQua = new JPanel();
		pKetQua.add(lbKQ = new JLabel("Kết quả:"));
		pKetQua.add(txtKQ = new JTextField(20));
		pCenter.add(pKetQua);
		lbNhapA.setPreferredSize(lbKQ.getPreferredSize());
		lbNhapB.setPreferredSize(lbKQ.getPreferredSize());
		txtKQ.setEditable(false);
		add(pCenter, BorderLayout.CENTER);

		// WEST
		JPanel pWest = new JPanel();
		Border westBorder = BorderFactory.createLineBorder(Color.RED);
		pWest.setBorder(new TitledBorder(westBorder, "Chọn tác vụ "));// TitledBorder westTitleBorder = new
																		// TitledBorder(westBorder,"Chá»�n tÃ¡c vá»¥");

		pWest.setLayout(new BoxLayout(pWest, BoxLayout.Y_AXIS));
		pWest.add(btnGiai = new JButton("Giải"));
		pWest.add(Box.createVerticalStrut(10));
		pWest.add(btnXoa = new JButton("Xóa"));
		pWest.add(Box.createVerticalStrut(10));
		pWest.add(btnThoat = new JButton("Thoát"));
		add(pWest, BorderLayout.WEST);
		
		
		//SOU
		JPanel pSou = new JPanel();
		pSou.setBackground(Color.pink);
		add(pSou,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 400, 300);
		setVisible(true);
		setResizable(false);

		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);

	}

	public CongTruNhanChia() {
		super("Cộng - Trừ - Nhân - Chia");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		setVisible(true);
		addControls();
		setResizable(false);
	}

	public static void main(String[] args) {
		new CongTruNhanChia();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int a = 0, b = 0;
		String sA, sB;
		sA = txtNhapA.getText();// lay gia tri nhap trong text
		sB = txtNhapB.getText();
			Object source = e.getSource();
			if (source.equals(btnGiai)) {
				if (radCong.isSelected()) {// ?
					txtKQ.setText(Integer.toString(a + b));//
				} else if (radTru.isSelected()) {
					txtKQ.setText(Integer.toString(a - b));
				} else if (radNhan.isSelected()) {
					txtKQ.setText(Integer.toString(a * b));
				} else {
					txtKQ.setText(Double.toString(1.0 * a / b));
				}
			}

			else if (source.equals(btnXoa)) {
				txtNhapA.setText("");
				txtNhapB.setText("");
			}

			else if (source.equals(btnThoat)) {
				System.exit(0);
				}
			}

	}