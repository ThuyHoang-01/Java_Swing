package chiTietHoaDon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.crypto.spec.PSource;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DonHang.FrmDonHang;
import KhachHang.FrmKH;
import MatHang.FrmDsMatHang;
import MeNuFrom.FrmHoaDon;



public class FrmCTHD extends JFrame implements ActionListener,MouseListener {

	private JLabel lblMaHD,lblMaHang,lblGiaBan,lblSoLuong,lblMucGiamGia,lblTim;
	private JTextField txtMaHD,txtSoLuong,txtGiaBan,txtTim;
	private JComboBox<String> cboMaHang,cboMucGiamGia;
	private JButton btnThem,btnXoa,btnXoaTrang,btnLuu,btnTim;
	public static JButton btnTrove,btnXuatHD,btnThoat;
	public static DefaultTableModel tableModel;
	private JTable table;
	
	public FrmCTHD() {
		// TODO Auto-generated constructor stub
		super("Chương tình quản lý chi tiết hóa đơn");
		setSize(900,600);
		setResizable(false);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		build();
	}
	private void build() {
		// TODO Auto-generated method stub
		JPanel pNorth = new JPanel();
		add(pNorth,BorderLayout.NORTH);
		pNorth.setPreferredSize(new Dimension(0,230));
		pNorth.setLayout(null);
		
		pNorth.add(lblMaHD = new JLabel("Mã Hóa Đơn"));
		pNorth.add(lblMaHang = new JLabel("Mã mặt hàng"));
		pNorth.add(lblGiaBan = new JLabel("Giá bán"));
		pNorth.add(lblSoLuong = new JLabel("Số lượng"));
		pNorth.add(lblMucGiamGia = new JLabel("Mức giảm giá"));
	
		pNorth.add(txtMaHD = new JTextField());
		pNorth.add(cboMaHang = new JComboBox<String>());
		//cboMaHang.addItem("CPU");
		//cboMaHang.addItem("RAM");
		//cboMaHang.addItem("Tản nhiệt");
		//cboMaHang.addItem("Chuột");
		pNorth.add(txtGiaBan = new JTextField());
		pNorth.add(txtSoLuong= new JTextField());
		pNorth.add(cboMucGiamGia = new JComboBox<String>());
		//cboMucGiamGia.addItem("15%");
		//cboMucGiamGia.addItem("20%");
		//cboMucGiamGia.addItem("30%");
		//cboMucGiamGia.addItem("40%");
		
		int w1= 100, w2=450, h=30;
		lblMaHD.setBounds(20, 20, w1, h);txtMaHD.setBounds(120, 20, w2, h);
		lblMaHang.setBounds(20, 55, w1, h);cboMaHang.setBounds(120, 55, w2, h);	
		lblGiaBan.setBounds(20, 90, w1, h);txtGiaBan.setBounds(120, 90, w2, h);
		lblSoLuong.setBounds(20, 130, w1, h);txtSoLuong.setBounds(120, 130, w2, h);
		lblMucGiamGia.setBounds(20, 170, w1, h);cboMucGiamGia.setBounds(120, 170, w2, h);
		
		JPanel pnCen = new JPanel();
		String[] headers ="MaHD;MaHang;GiaBan;SoLuong;MucGiamGia\n".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll;
		pnCen.add(scroll = new JScrollPane(table = new JTable(tableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.CENTER);
		 table.setRowHeight(20);
		 scroll.setPreferredSize(new Dimension(500, 400));
		 add(pnCen, BorderLayout.CENTER);
	
		
		JPanel pnSouth = new JPanel();
		pnSouth.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		//pnSouth.add(lblTim = new JLabel("Nhập mã cần tìm: "));
		//pnSouth.add(txtTim = new JTextField(15));
		//pnSouth.add(btnTim = new JButton("Tìm"));
		//pnSouth.add(btnThem = new JButton("Thêm"));
		pnSouth.add(btnXoa = new JButton("Xoa"));
		pnSouth.add(btnXoaTrang = new JButton("Xóa trắng"));
		pnSouth.add(btnLuu = new JButton("Lưu"));
		//pnSouth.add(btnTrove = new JButton("Trở về"));
		pnSouth.add(btnXuatHD = new JButton("Xuất HD"));
		pnSouth.add(btnThoat = new JButton("Thoát"));
		add(pnSouth, BorderLayout.SOUTH);
		
		//btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(this);
		//btnTrove.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXuatHD.addActionListener(this);
		

	}
	
	String maHD,maMH1,giaBan,soLuong,mucGiamGia;
	int sl;
	double gia;
	double sale;
	
	public ChiTietHoaDon taoCTHD() {
		maHD=txtMaHD.getText().trim().toString();
		maMH1=cboMaHang.getSelectedItem().toString();
		giaBan=txtGiaBan.getText().trim();
		gia=giaBan.length() ==0 ? 0:Double.parseDouble(giaBan);
		soLuong=txtSoLuong.getText().trim();
		sl= soLuong.length() == 0 ? 0: Integer.parseInt(soLuong);
		mucGiamGia=cboMucGiamGia.getSelectedItem().toString();
		sale=mucGiamGia.length() ==0 ? 0:Double.parseDouble(mucGiamGia);
		ChiTietHoaDon New = new ChiTietHoaDon(maHD,maMH1,gia,sl,sale);
		return New;
	}
/*	private void them() {
		ChiTietHoaDon c = taoCTHD();
		String [] row = {
				maHD,maMH1, Double.toString(gia),
				Integer.toString(sl),Double.toString(sale)
		};
		if(ListCTHHD.themCTHD(c)) {
			tableModel.addRow(row);
			xoaTrang();
			txtMaHD.selectAll();
			txtMaHD.requestFocus();
		}else {
			JOptionPane.showConfirmDialog(this, "Trùng mã");
		}
	}
	
	private void xoa() {
		int row = table.getSelectedColumn();
		if(row != -1) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn chắc muốn xóa ?","Chú ý", JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION) {
				if(ListKH.xoaKH(row)) {
					tableModel.removeRow(row);
					xoaTrang();
				}
			}
		}else
			JOptionPane.showMessageDialog(this, "Bạn cần chọn dòng cần xóa");

	}
	*/
	private void xoaTrang() {
		// TODO Auto-generated method stub
		txtMaHD.setText("");
		cboMaHang.setSelectedIndex(0);
		txtGiaBan.setText("");
		txtSoLuong.setText("");
		cboMucGiamGia.setSelectedIndex(0);
		txtMaHD.requestFocus();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
//		fill(row);
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
		//if(o.equals(btnThem)) {
	//		them();
		 if(o.equals(btnXoa)) {
				//xoa();
		}else if(o.equals(btnXoaTrang)) {
			xoaTrang();
		}
		
		 if(o.equals(btnThoat)){
		 	
			dispose();
		
		//	new FrmDsMatHang().setVisible(true);
			
			
	//	}else if(o.equals(btnTrove)) {
	//		dispose();
	//		new FrmDonHang().setVisible(true);
		}else if(o.equals(btnXuatHD)) {
			new FrmHoaDon().setVisible(true);
		}

	
}
/*	private void fill(int row) {
		if(row !=-1) {
			txtMaHD.setText(table.getValueAt(row, 0).toString());
			//txtTen.setText(table.getValueAt(row, 1).toString());
			if(table.getValueAt(row, 1).toString().equalsIgnoreCase("CPU")) {
				cboMaHang.setSelectedIndex(0);
			}else if(table.getValueAt(row, 2).toString().equalsIgnoreCase("RAM")) {
				cboMaHang.setSelectedIndex(1);			
			}else if(table.getValueAt(row,3 ).toString().equalsIgnoreCase("RAM")) {
				cboMaHang.setSelectedIndex(2);			
			}
			else {
				cboMaHang.setSelectedIndex(3);
			}
			txtGiaBan.setText(table.getValueAt(row, 2).toString());
			txtSoLuong.setText(table.getValueAt(row,3 ).toString());
			if(table.getValueAt(row, 4).toString().equalsIgnoreCase("15%")) {
				cboMucGiamGia.setSelectedIndex(0);
			}else if(table.getValueAt(row, 1).toString().equalsIgnoreCase("20%")) {
				cboMucGiamGia.setSelectedIndex(1);
			}
			else if(table.getValueAt(row, 2).toString().equalsIgnoreCase("30%")) {
				cboMucGiamGia.setSelectedIndex(2);
			}else {
				cboMucGiamGia.setSelectedIndex(3);
			}
		}
		
		
	}*/
	
	public static void main(String[] args) {
		new FrmCTHD().setVisible(true);
	}

}
