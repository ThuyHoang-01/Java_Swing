package ui;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.MonHoc_DAO;
import db.Database;
import entity.MonHoc;

public class MonHoc_GUI extends JFrame  implements ActionListener, MouseListener {

	private static final long serialVersionUID = -1554680235689968471L;

	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnKetThuc;

	private DefaultTableModel dataModel;
	private JTable table;

	private JScrollPane scroll;

	private JComboBox<String> cboBoMonChuQuan;
	private JTextField txtMaMonHoc;
	private JTextField txtTenMonHoc;
	private JTextField txtSoTiet;

	private JButton btnLoc;

	public MonHoc_GUI() {
		setTitle("Ôn thi cuối kỳ - TL HSK Java - HK2 (2021-2022)");
		setSize(630, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Box b, b1, b2, b3, b4, b5, b6, b7, b8;
		add(b = Box.createVerticalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b8 = Box.createHorizontalBox());

		b.add(Box.createVerticalStrut(10));
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b8 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		JLabel lblTieuDe, lblMaMH, lblTenMon, lblBMCQ, lblCLB;
		b1.add(lblTieuDe = new JLabel("-THÔNG TIN MÔN HỌC- ", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTieuDe.setForeground(Color.BLUE);

		b2.add(lblMaMH = new JLabel("  Mã môn học:  ", JLabel.RIGHT));
		b2.add(txtMaMonHoc = new JTextField());
		b2.add(Box.createHorizontalStrut(50));
		b3.add(lblTenMon = new JLabel("Tên môn học:  ", JLabel.RIGHT));
		b3.add(txtTenMonHoc = new JTextField());
		b3.add(Box.createHorizontalStrut(50));
		b4.add(lblBMCQ = new JLabel("Bộ Môn Chủ Quản:  ", JLabel.RIGHT));
		b4.add(cboBoMonChuQuan = new JComboBox<String>());
		b4.add(Box.createHorizontalStrut(300));

		b5.add(lblCLB = new JLabel("Số Tiết:  ", JLabel.RIGHT));
		b5.add(txtSoTiet = new JTextField());
		b5.add(Box.createHorizontalStrut(50));

		DefaultComboBoxModel<String> dataModelLop = new DefaultComboBoxModel<String>();
		cboBoMonChuQuan.setModel(dataModelLop);

		
		lblMaMH.setPreferredSize(lblBMCQ.getPreferredSize());
		lblTenMon.setPreferredSize(lblBMCQ.getPreferredSize());
		lblCLB.setPreferredSize(lblBMCQ.getPreferredSize());

		b6.add(Box.createHorizontalStrut(40));
		b6.add(btnThem = new JButton("Thêm Mới "));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(btnLuu = new JButton("Lưu "));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(btnXoa = new JButton("Xóa"));
		b6.add(Box.createHorizontalStrut(50));
		b6.add(btnKetThuc = new JButton("Kết Thúc"));

		String[] tieuDe = { "Mã Môn Học", "Tên Môn Học", "Số Tiết", "Mã Số Bộ Môn Chủ Quản" };
		b7.add(scroll = new JScrollPane(table = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách Môn Học:"));

		JLabel lblName;
		b8.add(lblName = new JLabel("Họ tên sv:Hoàng Thị Tố Thùy massv:19432541"));
		lblName.setFont(new Font("Times", Font.ITALIC, 12));
		lblName.setForeground(Color.RED);
		b8.add(Box.createHorizontalStrut(50));
		b8.add(btnLoc= new JButton("   Lọc danh sách Môn Học theo Bộ Môn Chủ Quản "));
		btnLoc.setFont(new Font("Times New Roman", Font.ITALIC,14 ));
		btnLoc.setForeground(Color.BLUE);
		table.addMouseListener(this);
		btnKetThuc.addActionListener(this);
		btnLoc.addActionListener(this);
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		Database.connect();
		loadDuLieu();

		
	}
	public void loadDuLieu() {
		
		for(MonHoc mh : MonHoc_DAO.getall()) {
			dataModel.addRow(new Object[] { mh.getMaMon(), mh.getTenMon(), mh.getSoTiet(), mh.getBm().getMaBoMonCQ()});
		}

	}
		
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
