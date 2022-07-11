package DonHang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import KhachHang.FrmKH;
import MatHang.FormHang;
import chiTietHoaDon.FrmCTHD;

public class FrmDonHang extends JFrame implements ActionListener,MouseListener{

	private JTextField txtSoHD,txtNgayDH,txtNgayCH,txtNoiGH,txtTim;
	private JButton btnThem,btnTim,btnXoa,btnLuu,btnXoaRong,btnCapnhat,btnThoatra;
	private JTable table;
	private JComboBox<String>cbMaKH,cbMaNV;
	private DefaultComboBoxModel<String> box,box1;
	
	//public static JButton btnThoat,btnBuocTiep;
	
	public static DefaultTableModel dtable;
	
	public FrmDonHang() {
		setTitle("Nhập đơn hàng");
		setSize(1000,450);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		buildUI();
		
	}
	public void buildUI() {
		JLabel lblSoHD,lblMaKH,lblMaNV,lblNgayDH,lblNgayCH,lblNoiGH;
		
		Box b1 = Box.createVerticalBox();
		b1.add(Box.createVerticalStrut(12));
		b1.add(lblSoHD = new JLabel("Số hoá đơn:"));
		b1.add(Box.createVerticalStrut(23));
		
		b1.add(lblMaKH = new JLabel("Mã khách hàng:"));
		b1.add(Box.createVerticalStrut(23));
		
		b1.add(lblMaNV = new JLabel("Mã nhân viên:"));
		b1.add(Box.createVerticalStrut(23));
		
		b1.add(lblNgayDH = new JLabel("Ngày đặt hàng:"));
		b1.add(Box.createVerticalStrut(23));
		
		b1.add(lblNgayCH = new JLabel("Ngày chuyển hàng:"));
		b1.add(Box.createVerticalStrut(23));
		
		b1.add(lblNgayDH = new JLabel("Nơi giao hàng:"));
		b1.add(Box.createVerticalStrut(15));
		
		
		JPanel pWest = new JPanel();
		add(pWest,BorderLayout.WEST);
		pWest.add(b1);
		pWest.setPreferredSize(new Dimension(150,500));
		
		String[] test = {};
		box = new DefaultComboBoxModel<String>(test);
		
		String[] test1 = {};
		box1 = new DefaultComboBoxModel<String>(test1);
		
		Box b2 = Box.createVerticalBox();
		b2.add(Box.createVerticalStrut(18));
		b2.add(txtSoHD = new JTextField(18));
		b2.add(Box.createVerticalStrut(17));
		b2.add(cbMaKH = new JComboBox<String>(box));
		b2.add(Box.createVerticalStrut(17));
		b2.add(cbMaNV = new JComboBox<String>(box1));
		b2.add(Box.createVerticalStrut(17));
		b2.add(txtNgayDH = new JTextField(18));
		b2.add(Box.createVerticalStrut(17));
		b2.add(txtNgayCH = new JTextField(18));
		b2.add(Box.createVerticalStrut(17));
		b2.add(txtNoiGH = new JTextField(18));
		b2.add(Box.createVerticalStrut(17));
		
		JScrollPane scroll;
		String [] headers="SoHD;MaKH;MaNV;NgayDH;NgayCH;NoiGH".split(";");
		dtable= new DefaultTableModel(headers,0);
		
		b2.add(scroll=new JScrollPane(table = new JTable(dtable),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		table.setRowHeight(3);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scroll.setViewportView(table= new JTable(dtable));
		scroll.setPreferredSize(new Dimension(0,110));
		
		
		JPanel pMid = new JPanel(new GridLayout(1,2));
		add(pMid, BorderLayout.CENTER);
		pMid.add(b2);
		pMid.setPreferredSize(new Dimension(750,500));
		
		
		
		Panel pSouth = new Panel();
		Box b = Box.createHorizontalBox() ;
		
		b.add(Box.createHorizontalStrut(20));
		//b.add(txtTim = new JTextField());
		//b.add(Box.createHorizontalStrut(5));
		//b.add(btnTim = new JButton("Tìm"));
		b.add(Box.createHorizontalStrut(300));
		b.add(btnLuu = new JButton("Lưu"));
		b.add(Box.createHorizontalStrut(5));
		b.add(btnXoa = new JButton("Xoá"));
		b.add(Box.createHorizontalStrut(5));
		
		b.add(btnXoaRong = new JButton("Xoá trắng"));
		b.add(Box.createHorizontalStrut(5));
		b.add(btnCapnhat = new JButton("Cập nhật"));
		b.add(Box.createHorizontalStrut(5));
		b.add(btnThoatra = new JButton("Thoát"));
		b.add(Box.createHorizontalStrut(5));
		//b.add(btnThoat = new JButton("Trở về"));
		//b.add(Box.createHorizontalStrut(5));
		//b.add(btnBuocTiep = new JButton("Bước tiếp"));
		
		
	
		pSouth.add(b);
		add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(null);
		b.setBounds(100, 10, 800, 50);
		
		b.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pSouth.setPreferredSize(new Dimension(0, 100));
		pSouth.setBackground(Color.cyan);
		
		cbMaKH.addActionListener(this);
		cbMaKH.addActionListener(this);
		//btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoaRong.addActionListener(this);
		//btnThoat.addActionListener(this);
		//btnBuocTiep.addActionListener(this);
		btnThoatra.addActionListener(this);
		table.addMouseListener(this);


	}
	private void xoaTrangActions() {
		// TODO Auto-generated method stub
		txtSoHD.setText("");
		txtNgayDH.setText("");
		txtNgayCH.setText("");
		txtNoiGH.setText("");
		txtTim.setText("");
		txtSoHD.requestFocus();
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o.equals(btnThoatra)) {
			dispose();
		}
		/*
		if(o.equals(btnThoatra)) {
			dispose();
		}*/
	}
		
	public void XoaTrangActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object o=e.getSource();
			if(o.equals(btnXoaRong))
				xoaTrangActions();	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrmDonHang frm= new FrmDonHang();
		frm.setVisible(true);
	}
	
}
