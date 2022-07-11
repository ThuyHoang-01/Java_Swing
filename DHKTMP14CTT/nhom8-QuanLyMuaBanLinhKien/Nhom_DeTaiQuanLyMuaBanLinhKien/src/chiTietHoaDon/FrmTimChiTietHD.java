package chiTietHoaDon;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DonHang.FrmDonHang;
import chiTietHoaDon.ChiTietHoaDon;
import chiTietHoaDon.ListCTHHD;

public class FrmTimChiTietHD extends JFrame implements ActionListener,MouseListener{
	private JTable tabletim;
	public static DefaultTableModel tableModeltim;
	private JTextField txtTimKiem;
	private JLabel lbltimkiem;
	private JButton btnTim,btnThoat,btncapNhat;
	public FrmTimChiTietHD() {
		super("Tìm theo chi tiết hóa đơn");
		setSize(600, 500);
		setLocation(50, 100);
		//setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		Box btim = Box.createVerticalBox();
		Box btim1,btim2;
		
		btim.add(btim1 = Box.createHorizontalBox());
		btim.add(Box.createVerticalStrut(15));
		btim1.add(lbltimkiem = new JLabel("Nhập thông tin chi tiết muốn tìm:"));
		btim1.add(Box.createHorizontalStrut(35));
		btim1.add(txtTimKiem = new JTextField());
		btim1.add(btnTim = new JButton("Tìm"));
		//btim1.add(btncapNhat = new JButton("Cập nhật"));
		btim1.add(btnThoat = new JButton("Thoát"));
		
		btim.add(btim2 = Box.createHorizontalBox());
		btim.add(Box.createVerticalStrut(10));
		
		
		String [] headertim ="Mã HD;Mã MH;Giá Bán;Số Lượng;Mức Giảm Giá".split(";");
		tableModeltim = new DefaultTableModel(headertim,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tabletim = new JTable(tableModeltim));
		tabletim.setRowHeight(25);
		tabletim.setAutoCreateRowSorter(true);
		tabletim.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		btim2.add(scroll);
		btim.setBorder(BorderFactory.createEmptyBorder(20, 20,20, 20));
		add(btim,BorderLayout.CENTER);
		
		btnThoat.addActionListener(this);
		btncapNhat.addActionListener(this);
		//DataBase.getInstance().connect();
		//updateTableData();
		
		
	}
	
	
	/*
	private void updateTableData() {
		ListCTHHD ds = new ListCTHHD();
		ArrayList<ChiTietHoaDon> list = ds.docTuBang();
		for (ChiTietHoaDon hd : list) {
			String [] rowData = {hd.getMaHD(),hd.getMaHang(),hd.getGiaBan()+"",
					hd.getSoLuong()+"",hd.getMucGiamGia()+""};
			tableModeltim.addRow(rowData);
		}
		tabletim.setModel(tableModeltim);
		tabletim.setEnabled(false);
		
	}
	*/
	


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			dispose();
		}
		/*
		if(o.equals(btncapNhat)) {
			new FrmCTHD().setVisible(true);
			FrmCTHD.btnThoat.setEnabled(false);
			FrmCTHD.btnTrove.setEnabled(false);
			FrmCTHD.btnXuatHD.setEnabled(false);
			
		}
		*/
	}
	
	public static void main(String[] args) {
		new FrmTimChiTietHD().setVisible(true);;
	}


	@Override
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


	
}