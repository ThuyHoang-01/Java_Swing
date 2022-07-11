package MeNuFrom;

import java.awt.BorderLayout;

import javax.swing.*;

public class FrmHoaDon extends JFrame{
	private JButton btnin,btnLuu;
	private JTextField txtmaKh,txtKH,txtDiaChi,txtSDT,txtTenMH,txtSoLuong,txtGia,txtMaNhanVien,txtNgayGiao;
	public FrmHoaDon() {
		super("Hoa Don");
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		
		JLabel lblTenKh,lblmaKH,lblDiaChi,lblSDT,lblTenMH,lblSoLuong,lblGia,lblmaNhanvien,lblNgayGia,lblTongtien;
		
		JPanel pcenter = new JPanel();
		add(pcenter,BorderLayout.CENTER);
		pcenter.setLayout(null);
		
		pcenter.add(lblmaKH = new JLabel("Mã khách hàng"));
		pcenter.add(lblTenKh = new JLabel("Tên khách hàng"));
		pcenter.add(lblDiaChi = new JLabel("Địa chỉ"));
		pcenter.add(lblSDT = new JLabel("Số điện thoại"));
		pcenter.add(lblTenMH = new JLabel("Tên mặt hàng"));
		pcenter.add(lblSoLuong = new JLabel("Số lượng"));
		pcenter.add(lblGia = new JLabel("Giá bán"));
		pcenter.add(lblmaNhanvien = new JLabel("Mã nhân viên"));
		pcenter.add(lblNgayGia = new JLabel("Ngày giao"));
		pcenter.add(lblTongtien = new JLabel("Tổng tiền"));
		
		
		pcenter.add(txtDiaChi = new JTextField());
		pcenter.add(txtGia = new JTextField());
		pcenter.add(txtKH = new JTextField());
		pcenter.add(txtMaNhanVien = new JTextField());
		pcenter.add(txtNgayGiao = new JTextField());
		pcenter.add(txtSDT = new JTextField());
		pcenter.add(txtSoLuong = new JTextField());
		pcenter.add(txtTenMH = new JTextField());
		pcenter.add(txtmaKh = new JTextField());
		
		
		int x = 20,y = 20,w1 = 100,w2 = 300,h = 30;
		lblmaKH.setBounds(x, y, w1, h);
		y+=30;
		lblTenKh.setBounds(x, y, w1, h);
		y+=30;
		lblDiaChi.setBounds(x, y, w1,h);
		y+=30;
		lblSDT.setBounds(x, y, w1, h);
		y+=30;
		lblTenMH.setBounds(x, y, w1, h);
		y+=30;
		lblSoLuong.setBounds(x, y, w1, h);
		y+=30;
		lblGia.setBounds(x, y, w1, h);
		y+=30;
		lblmaNhanvien.setBounds(x, y, w1, h);
		y+=30;
		lblNgayGia.setBounds(x, y, w1, h);
		y+=30;
		lblTongtien.setBounds(x, y, w1, h);
		
		
		JPanel pnorth = new JPanel();
		add(pnorth,BorderLayout.SOUTH);
		pnorth.add(btnin = new JButton("In"));
		pnorth.add(btnLuu = new JButton("Luu"));
	}
	public static void main(String[] args) {
		new FrmHoaDon().setVisible(true);
	}
}
