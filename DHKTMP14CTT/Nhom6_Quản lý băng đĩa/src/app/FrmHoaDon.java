package app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmHoaDon extends JFrame implements ActionListener{
	JButton btnTT, btnHuy;
	JLabel lblToT;
	JTextField txtToT, txtTien;
	public FrmHoaDon() {
		setTitle("Hóa Đơn");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pNorth;
		add(pNorth = new JPanel(),BorderLayout.NORTH);
		pNorth.add(lblToT = new JLabel("Tổng tiền:"));
		pNorth.add(txtToT = new JTextField());
		txtToT.setText(QuanLyBDCart.tongTien()+"");
		txtToT.setEditable(false);
		
		JPanel pSourth;
		add(pSourth = new JPanel(), BorderLayout.SOUTH);
		btnTT = new JButton("Thanh toán");
		pSourth.add(btnTT);
		btnHuy = new JButton("Hủy");
		pSourth.add(btnHuy);
		btnTT.addActionListener(this);
		btnHuy.addActionListener(this);
//	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnHuy)) {
			this.setVisible(false);
		}else if(o.equals(btnTT)) {
			this.setVisible(false);
			JOptionPane.showMessageDialog(this, "Thanh toán thành công");
			}
			
		
	}
}
