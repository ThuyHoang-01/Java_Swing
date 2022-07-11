package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

public class FrmDatHang extends JFrame implements ActionListener, MouseListener {


	private JTable table;
	private JTextField txtMess;
	private JTextField txtCMND;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtTongTien;
	private Database database;

	public static DefaultTableModel tableModel;
	private JButton btnBack, btnThanhToan, btnXoa;
	public FrmDatHang() {
		setTitle("Cart");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		database.loadDataBaseTV();
		buildUI();
		database.loadDataBaseBD_C();
	}

	private void buildUI() {
		ThanhVien tv = QuanLyThanhVien.getTV(QuanLyBDCart.GetKhachHang());
		JPanel pNorth;
		add(pNorth = new JPanel(), BorderLayout.NORTH);
		pNorth.setPreferredSize(new Dimension(0, 180));
		pNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pNorth.setLayout(null);
		JLabel lblCMND, lblTen, lblSDT, lblTongTien, lblDiaChi;
		
		pNorth.add(lblCMND = new JLabel("CMND: "));
		pNorth.add(lblTen = new JLabel("Tên: "));
		pNorth.add(lblSDT = new JLabel("SDT: "));
		pNorth.add(lblTongTien = new JLabel("Tổng tiền: "));
		pNorth.add(lblDiaChi = new JLabel("Địa chỉ: "));

		pNorth.add(txtTongTien = new JTextField());
		pNorth.add(txtCMND = new JTextField());
		pNorth.add(txtTen = new JTextField());
		pNorth.add(txtSDT = new JTextField());
		pNorth.add(txtDiaChi = new JTextField());


		pNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.RED);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));
		int w1 = 100, w2 = 300, h = 20;
		lblCMND.setBounds(20, 20, w1, h);
		txtCMND.setBounds(120, 20, w2, h);
		txtCMND.setEditable(false);
		txtCMND.setText(tv.getCmnd());

		lblTen.setBounds(20, 45, w1, h);
		txtTen.setBounds(120, 45, w2, h);
		txtTen.setEditable(false);
		txtTen.setText(tv.getHoTen());
		
		lblSDT.setBounds(450, 45, w1, h);
		txtSDT.setBounds(570, 45, w2, h);
		txtSDT.setEditable(false);
		txtSDT.setText(tv.getsDT());
		
		lblTongTien.setBounds(450, 70, w1, h);
		txtTongTien.setBounds(570, 70, w2, h);
		txtTongTien.setEditable(false);
		txtTongTien.setText(QuanLyBDCart.tongTien()+"");

		lblDiaChi.setBounds(20, 70, w1, h);
		txtDiaChi.setBounds(120, 70, w2, h);
		txtDiaChi.setEditable(false);
		txtDiaChi.setText(tv.getDiaChi());

		txtMess.setBounds(20, 145, 550, 20);


		JPanel pCen;
		add(pCen = new JPanel(), BorderLayout.CENTER);
		pCen.add(btnXoa = new JButton("Xóa"));
		pCen.add(btnThanhToan = new JButton("Thanh toán"));
		pCen.add(btnBack = new JButton("Trở về"));
		
		JScrollPane scroll;
		String[] headers = "MaCD;TenCD;TheLoai;HangSX;TinhTrang;GhiChu;Gia;SoLuong".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách các băng đĩa"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));


		btnBack.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnXoa.addActionListener(this);
		table.addMouseListener(this);
}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		 if (o.equals(btnBack)) {
		 new FrmDangNhapTV().setVisible(true);;
		 this.setVisible(false);
		 }else if(o.equals(btnThanhToan)) {
			 new FrmHoaDon().setVisible(true);
		 }else if(o.equals(btnXoa)) {
			 int row = table.getSelectedRow();
				if (row != -1) {
					int hoinhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không?", "Chú ý",
							JOptionPane.YES_NO_OPTION);
					if (hoinhac == JOptionPane.YES_OPTION) {
						if (QuanLyBDCart.xoaBangDiaC(row)) {
							tableModel.removeRow(row);
							Database.SaveDatabaseBD_C(QuanLyBDCart.getDsBangDiaC());
							txtMess.setText("Đã xóa");
						}
					}
		        }
	    }
		}
	}

