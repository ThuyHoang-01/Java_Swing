package BaoCao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BaoCaoNhanVien extends JFrame implements ActionListener {

	
	private JButton btnThoat;
	private DefaultTableModel tablemodel;
	private JTable table;

	public BaoCaoNhanVien() {
		// TODO Auto-generated constructor stub
		 super("Báo cáo nhân viên");
		 setSize(800,600);
		 setResizable(false);
		 //setDefaultCloseOperation(EXIT_ON_CLOSE);
		 control();
	}
	
	private void control() {
		// TODO Auto-generated method stub
		
		JPanel pnCen = new JPanel();
		String[] headers ="Mã NV;Tên NV;Sản phẩm bán được\n".split(";");
		tablemodel = new DefaultTableModel(headers,0);
		JScrollPane scroll;
		pnCen.add(scroll = new JScrollPane(table = new JTable(tablemodel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.CENTER);
		 table.setRowHeight(20);
		 scroll.setPreferredSize(new Dimension(600, 400));
		 add(pnCen, BorderLayout.CENTER);
	
		 JPanel psouth = new JPanel();
		 add(psouth,BorderLayout.SOUTH);
		 psouth.add(Box.createHorizontalStrut(400));
		 psouth.add(btnThoat = new JButton("Thoát"));
		 
		 btnThoat.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			dispose();
		}
	}
	public static void main(String[] args) {
		new BaoCaoNhanVien().setVisible(true);
	}

}
