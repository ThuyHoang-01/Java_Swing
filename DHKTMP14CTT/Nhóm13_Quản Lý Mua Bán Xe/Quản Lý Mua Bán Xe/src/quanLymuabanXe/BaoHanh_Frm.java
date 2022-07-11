package quanLymuabanXe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BaoHanh_Frm extends JFrame implements ActionListener {
	private JLabel lbltieude,lblMaKhachHang,lblNguoiKiemTra,lblLinhKien,lblGiatien,lblMaBaoHanh,lblLido;
	private JComboBox<String> cbboxlido;
	private JTextField txtNguoiKiemTra,txtMaKhachHang,txtLinhKien,txtGiaTien,txtMaBaoHanh;
	private JButton btnThem, btnSua, btnXoa, btnLuu, btnXe, btnKhachhang, btnHoadon,btnNhanVien;
	public static DefaultTableModel tablemolde;
	private JTable table;
	
	public BaoHanh_Frm() {
		setSize(950, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		BaoHanh();
	}
	private void  BaoHanh() {
		
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(null);
		pnNorth.setPreferredSize(new Dimension(0,180));
		add(pnNorth, BorderLayout.NORTH);
		
		pnNorth.add(lblMaBaoHanh = new JLabel("Mã bảo hành:"));
		pnNorth.add(lblNguoiKiemTra = new JLabel("Người kiểm tra:"));
		pnNorth.add(lblMaKhachHang = new JLabel("Mã Khách Hàng:"));
		pnNorth.add(lblLido = new JLabel("Lí Do"));
		pnNorth.add(lblLinhKien = new JLabel("linh Kiện:"));
		pnNorth.add(lblGiatien = new JLabel("Giá tiền:"));
		
		
		pnNorth.add(txtMaBaoHanh = new JTextField());
		pnNorth.add(txtNguoiKiemTra = new JTextField());
		pnNorth.add(txtMaKhachHang = new JTextField());
		String[] Lido = { "Lỗi do khách hàng", "Lỗi do mặt hàng"};
		pnNorth.add(cbboxlido= new JComboBox<String>(Lido));
		
		pnNorth.add(txtLinhKien = new JTextField());
		pnNorth.add(txtGiaTien = new JTextField());


		pnNorth.add(btnThem = new JButton("Thêm"));
		pnNorth.add(btnSua = new JButton("Sửa"));
		pnNorth.add(btnXoa = new JButton("Xóa"));
		pnNorth.add(btnLuu = new JButton("Lưu"));
		
		lblMaBaoHanh.setBounds(20, 20, 150, 20);
		lblLido.setBounds(490, 20, 150, 20);
		lblMaKhachHang.setBounds(20, 45, 150, 20);
		lblNguoiKiemTra.setBounds(490, 45, 150, 20);
		lblLinhKien.setBounds(20, 70, 150, 20);
		lblGiatien.setBounds(490, 70, 150, 20);

		txtMaBaoHanh.setBounds(120, 20, 300, 20);
		cbboxlido.setBounds(600, 20, 300, 20);
		txtMaKhachHang.setBounds(120, 45, 300, 20);
		txtNguoiKiemTra.setBounds(600, 45, 300, 20);
		txtLinhKien.setBounds(120, 70, 300, 20);
		txtGiaTien.setBounds(600, 70, 300, 20);

		btnThem.setBounds(200, 110, 100, 20);
		btnSua.setBounds(320, 110, 100, 20);
		btnXoa.setBounds(440, 110, 100, 20);
		btnLuu.setBounds(560, 110, 100, 20);
		JScrollPane scroll;
		String[] headers = "Mã Bảo Hành, Người kiểm tra,Mã Khách Hàng,Lí Do,linh Kiện,Giá tiền".split(",");
		tablemolde = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tablemolde), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.CENTER);
		
		table.setRowHeight(20);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
		scroll.setPreferredSize(new Dimension(0, 180));
		
		JPanel pnTacvukhac = new JPanel();
		add(pnTacvukhac, BorderLayout.SOUTH);
		pnTacvukhac.setBorder(BorderFactory.createTitledBorder("Tác vụ khác"));
		pnTacvukhac.add(btnXe = new JButton("Xe"));
		pnTacvukhac.add(btnKhachhang = new JButton("Khách hàng"));
		pnTacvukhac.add(btnHoadon = new JButton("Hóa đơn"));
		pnTacvukhac.add(btnNhanVien = new JButton("Nhân Viên"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new BaoHanh_Frm();
	}
}
