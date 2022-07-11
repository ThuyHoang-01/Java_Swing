package quanLymuabanXe;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class NhanVien_form extends JFrame implements ActionListener,MouseListener {
	private JLabel lblMaNV,lblVaiTro,lblTenNV,lblChucVu,lblPhongBan,lblTrinhDoHV,lblBacTho,lblKinhNghiem;
	private JTextField txtMaNV,txtTenNV,txtChucVu,txtPhongBan,txtTrinhDoHV,txtBacTho,txtKinhNghiem;
	private JRadioButton radNVHanhCHinh,radNVKythuat;
	private JButton btnThem, btnSua, btnXoa, btnLuu, btnXe, btnKhachhang, btnHoadon,btnNhanVien;
	public static DefaultTableModel dtmNV;
	private JTable tableNV;
	public NhanVien_form() {
		super ("Nhân Viên");
		setSize(900, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setNhanVienform();
	}
	private void setNhanVienform() {
		JPanel pnNhapthongtin = new JPanel();
		add(pnNhapthongtin, BorderLayout.NORTH);
		pnNhapthongtin.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pnNhapthongtin.setPreferredSize( new Dimension(0, 250));
		pnNhapthongtin.setLayout(null);
		
		radNVHanhCHinh = new JRadioButton("Nhân viên Hành chính");
		radNVKythuat = new JRadioButton("Nhân viên kỹ thuật");
		ButtonGroup group = new ButtonGroup();
		group.add(radNVHanhCHinh);
		group.add(radNVKythuat);
		pnNhapthongtin.add(radNVHanhCHinh);
		pnNhapthongtin.add(radNVKythuat);
		
		pnNhapthongtin.add(lblMaNV = new JLabel("Mã Nhân Viên:"));
		pnNhapthongtin.add(lblTenNV = new JLabel("Tên Nhân viên:"));
		pnNhapthongtin.add(lblChucVu = new JLabel("Chức vụ"));
		pnNhapthongtin.add(lblPhongBan = new JLabel("Phòng ban"));
		lblPhongBan.setVisible(false);
		pnNhapthongtin.add(lblTrinhDoHV = new JLabel("Trình độ học vấn"));
		lblTrinhDoHV.setVisible(false);
		pnNhapthongtin.add(lblBacTho = new JLabel("Bậc thợ"));
		lblBacTho.setVisible(false);
		pnNhapthongtin.add(lblKinhNghiem = new JLabel("Số năm kinh nghiệm"));
		lblKinhNghiem.setVisible(false);
		
		pnNhapthongtin.add(txtMaNV = new JTextField());
		pnNhapthongtin.add(txtTenNV = new JTextField());
		pnNhapthongtin.add(txtChucVu= new JTextField());
		pnNhapthongtin.add(txtPhongBan = new JTextField());
		txtPhongBan.setVisible(false);
		pnNhapthongtin.add(txtTrinhDoHV = new JTextField());
		txtTrinhDoHV.setVisible(false);
		pnNhapthongtin.add(txtBacTho = new JTextField());
		txtBacTho.setVisible(false);
		pnNhapthongtin.add(txtKinhNghiem = new JTextField());
		txtKinhNghiem.setVisible(false);
		radNVHanhCHinh.setBounds(20, 20, 150, 20);
		radNVKythuat.setBounds(180,20, 150, 20);
		
		lblMaNV.setBounds(20, 45, 150, 20);
		lblTenNV.setBounds(20, 70, 150, 20);
		lblChucVu.setBounds(20, 95, 150, 20);
		lblPhongBan.setBounds(20, 120, 150, 20);
		lblTrinhDoHV.setBounds(20, 145, 150, 20);
		lblBacTho.setBounds(20, 120, 150, 20);
		lblKinhNghiem.setBounds(20, 140, 150, 20);

		txtMaNV.setBounds(180,45 , 300, 20);
		txtTenNV.setBounds(180,70 , 300, 20);
		txtChucVu.setBounds(180,95 , 300, 20);
		txtPhongBan.setBounds(180,120 , 300, 20);
		txtTrinhDoHV.setBounds(180,145 , 300, 20);
		txtBacTho.setBounds(180,120 , 300, 20);
		txtKinhNghiem.setBounds(180,145 , 300, 20);
		
		radNVHanhCHinh.addActionListener(this);
		radNVKythuat.addActionListener(this);
		
		JScrollPane spTableNVHC;
		String[] headers = "Mã Nhân Viên, Tên Nhân Viên, Chức vụ,Phòng ban,Trình độ học vấn,Bậc thợ,Số năm kinh nghiệm".split(",");
		dtmNV = new DefaultTableModel(headers, 0);
		add(spTableNVHC = new JScrollPane(tableNV = new JTable(dtmNV), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		tableNV.setRowHeight(20);
		spTableNVHC.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
		spTableNVHC.setPreferredSize(new Dimension(0, 180));
		
		JPanel pnTacvukhac = new JPanel();
		add(pnTacvukhac, BorderLayout.SOUTH);
		pnTacvukhac.setBorder(BorderFactory.createTitledBorder("Tác vụ khác"));
		pnTacvukhac.add(btnXe = new JButton("Xe"));
		pnTacvukhac.add(btnKhachhang = new JButton("Khách hàng"));
		pnTacvukhac.add(btnHoadon = new JButton("Hóa đơn"));
		pnTacvukhac.add(btnNhanVien = new JButton("Nhân Viên"));
		
		btnHoadon.addActionListener(this);
		btnKhachhang.addActionListener(this);
		btnXe.addActionListener(this);
		btnNhanVien.addActionListener(this);
	
	}
	public static void main(String[] args) {
		new NhanVien_form();
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
		
		if(radNVHanhCHinh.isSelected()) {
			handleNVHanhChinh();
		}
		if(radNVKythuat.isSelected()) {
			handleNVKythuat();
		}
		Object sourceEvent = e.getSource();
		if (sourceEvent.equals(btnXe)) {
			handleXe();
		}
		
		if (sourceEvent.equals(btnKhachhang)) {
			handleKhachHang();
		}
	}

	private void handleNVKythuat() {
		lblBacTho.setVisible(true);
		txtBacTho.setVisible(true);
		lblKinhNghiem.setVisible(true);
		txtKinhNghiem.setVisible(true);
		lblPhongBan.setVisible(false);
		txtPhongBan.setVisible(false);
		lblTrinhDoHV.setVisible(false);
		txtTrinhDoHV.setVisible(false);
		
	}
	private void handleNVHanhChinh() {
		lblPhongBan.setVisible(true);
		txtPhongBan.setVisible(true);
		lblTrinhDoHV.setVisible(true);
		txtTrinhDoHV.setVisible(true);
		lblBacTho.setVisible(false);
		txtBacTho.setVisible(false);
		lblKinhNghiem.setVisible(false);
		txtKinhNghiem.setVisible(false);
		
	}
private void handleKhachHang() {
	setVisible(false);
	new KhachHang_Form().setVisible(true);
	
}

private void handleXe() {
	setVisible(false);
	new Xe_Form().setVisible(true);
}

}
