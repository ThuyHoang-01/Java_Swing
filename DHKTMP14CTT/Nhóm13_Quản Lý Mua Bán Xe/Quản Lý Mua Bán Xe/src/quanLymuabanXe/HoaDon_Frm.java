package quanLymuabanXe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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

public class HoaDon_Frm extends JFrame implements ActionListener, MouseListener {
	private JLabel lblTitle, lblMaHD, lblMaXe, lblSolantra, lblmaKH, lblTenNV, lblTenXe, lblngayGD, lbltenKH,
			lblTongtien;
	private JTextField txtMaHD, txtMaXe, txtSolantra, txtmaKH, txtTenNV, txtTenXe, txtngayGD, txttenKH, txtTongtien;
	private DefaultTableModel dtmHoadon;
	private JTable tableHoadon;
	private JButton btnThem, btnSua, btnXoa, btnTim, btnKhachhang, btnXe, btnHoadon, btnNhanVien;
	DanhSachHoaDon dshd = new DanhSachHoaDon();
	JComboBox<String> a ;
	public HoaDon_Frm() {
		setSize(900, 520);
		setVisible(true);
		setTitle("^_^");
		JPanel pnTitle = new JPanel();
		add(pnTitle, BorderLayout.NORTH);
		pnTitle.add(lblTitle = new JLabel("THÔNG TIN HÓA ĐƠN"));
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);

		Box b = Box.createVerticalBox();
		Box b1, b2, b3, b4, b5, b6, b7, b8, b9,b10;

		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaHD = new JLabel("Mã Hóa Đơn: "));
		b1.add(txtMaHD = new JTextField());
		b1.add(lblMaXe = new JLabel("Mã xe: "));
		b1.add(txtMaXe = new JTextField());
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblSolantra = new JLabel("Số lần trả: "));
		b3.add(txtSolantra = new JTextField());
		b3.add(lblmaKH = new JLabel("Mã Khánh Hàng: "));
		b3.add(txtmaKH = new JTextField());
		b3.add(lblTenNV = new JLabel("Tên Nhân Viên : "));
		b3.add(txtTenNV = new JTextField());
		
		//b3.add(lblTenXe= new JLabel("Tên Xe : "));
		//b3.add(txtTenXe = new JTextField());

		
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b5.add(lblngayGD = new JLabel("Ngày giao dịch: "));
		b5.add(txtngayGD = new JTextField());
		
		
		
	//	b.add(b8 = Box.createHorizontalBox());
	//	b.add(Box.createVerticalStrut(10));
	//	b8.add(lbltenKH = new JLabel("Tên Khách Hàng: "));
	//	b8.add(txttenKH = new JTextField());
	//	b8.add(lblTongtien = new JLabel("Tổng tiền: "));
	//	b8.add(txtTongtien = new JTextField(0));
	//	txtTongtien.setEditable(true);
		
		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b7.add(btnThem = new JButton("Thêm"));
		
		

		b.add(b10 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		String[] headers = "hoaDon,  maXe,  soLanTra, maKH,  tenNV,  tenXe,  ngayGD, tongTien".split(",");
		dtmHoadon = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tableHoadon = new JTable(dtmHoadon));
		tableHoadon.setRowHeight(25);
		tableHoadon.setAutoCreateRowSorter(true);
		tableHoadon.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		b10.add(scroll);
		add(b, BorderLayout.CENTER);

		JPanel pnTacvukhac = new JPanel();
		add(pnTacvukhac, BorderLayout.SOUTH);
		pnTacvukhac.setBorder(BorderFactory.createTitledBorder("Tác vụ khác"));
		pnTacvukhac.add(btnXe = new JButton("Xe"));
		pnTacvukhac.add(btnKhachhang = new JButton("Khách hàng"));
		pnTacvukhac.add(btnHoadon = new JButton("Hóa đơn"));
		pnTacvukhac.add(btnNhanVien = new JButton("Nhân Viên"));
		btnThem.addActionListener(this);
		DataBase.getInstance().connect();
		updateTableData();
		
	}
	public static void main(String[] args) {
		new HoaDon_Frm();
	}
	
	private void updateTableData() {
		DanhSachHoaDon ds = new DanhSachHoaDon();
		ArrayList<HoaDon> list = ds.docTuBang();
		for (HoaDon s : list) {
			String [] rowData = {s.getHoaDon()+"", s.getMaXe()+"", s.getSoLanTra()+"", s.getMaKH(), s.getTenNV(), s.getTenXe(), s.getNgayGD(),
					 s.getTongTien()+""};
			dtmHoadon.addRow(rowData);
		}
		tableHoadon.setModel(dtmHoadon);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object sourceEvent = e.getSource();
		if (sourceEvent.equals(btnThem)) {
		dshd.create(Integer.parseInt(txtMaHD.getText()),Integer.parseInt(txtMaXe.getText()),txtmaKH.getText(),txtngayGD.getText(),Integer.parseInt(txtSolantra.getText()),txtTenNV.getText()); 
		DataBase.getInstance().connect();
		
		}

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
	public void LoatDataCBKH() {
		String sql = "Select *FORM KhachHang";
		try {
			Connection con = DataBase.getInstance().getConnection();
			PreparedStatement stml = con.prepareStatement(sql);
			ResultSet rs = stml.executeQuery(sql);
			while(rs.next()){
				this.a.addItem(rs.getString("MaKH"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
