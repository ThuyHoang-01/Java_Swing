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

public class FrmBangDiaKhachHang extends JFrame implements ActionListener, MouseListener {

	private JTextField txtMaBangDia;
	private JTextField txtTenBangDia;
	private JTextField txtTheLoai;
	private JTextField txtHangSX;
	private JTextField txtTinhTrang;
	private JTextField txtGhiChu, txtGia;
	private JTextField txtTim;
	private JTextField txtSL;

	private JButton btnAddToCart, btnBack, btnMoCart, btnTim;
	private JTable table;
	private JTextField txtMess;
	private JButton btnXoaRong;

	private Database database;

	public static DefaultTableModel tableModel;
	private JComboBox cboTinhTrang;

	public FrmBangDiaKhachHang() {
		setTitle("Băng đĩa");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
		database.loadDataBaseBDKH();
		
	}

	private void buildUI() {
		JPanel pNorth;
		add(pNorth = new JPanel(), BorderLayout.NORTH);
		pNorth.setPreferredSize(new Dimension(0, 180));
		pNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pNorth.setLayout(null);

		JLabel lblMaBangDia, lblTenBang, lblTheLoai, lblHangSX, lblTinhTrang, lblGhiChu, lblGia, lblTim, lblSL;
		pNorth.add(lblMaBangDia = new JLabel("Mã băng đĩa: "));
		pNorth.add(lblTenBang = new JLabel("Tên băng đĩa: "));
		pNorth.add(lblTheLoai = new JLabel("Thể loại: "));
		pNorth.add(lblHangSX = new JLabel("Hãng sản xuất: "));
		pNorth.add(lblTinhTrang = new JLabel("Tình trạng: "));
		pNorth.add(lblGhiChu = new JLabel("Ghi chú: "));
		pNorth.add(lblGia = new JLabel("Giá thuê: "));
		pNorth.add(lblSL = new JLabel("Số lượng:"));
		pNorth.add(lblTim = new JLabel("Tìm kiếm theo mã: "));

		pNorth.add(txtMaBangDia = new JTextField());
		pNorth.add(txtTenBangDia = new JTextField());
		pNorth.add(txtTheLoai = new JTextField());
		pNorth.add(txtHangSX = new JTextField());
		pNorth.add(cboTinhTrang = new JComboBox<String>());
		cboTinhTrang.addItem("Mới");
		cboTinhTrang.addItem("Cũ");
		pNorth.add(txtGhiChu = new JTextField());
		pNorth.add(txtGia = new JTextField());
		pNorth.add(txtTim = new JTextField());
		pNorth.add(txtSL = new JTextField());

		pNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.RED);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

		int w1 = 100, w2 = 300, h = 20;
		lblMaBangDia.setBounds(20, 20, w1, h);
		txtMaBangDia.setBounds(120, 20, w2, h);
		txtMaBangDia.setEditable(false);

		lblTenBang.setBounds(20, 45, w1, h);
		txtTenBangDia.setBounds(120, 45, w2, h);
		txtTenBangDia.setEditable(false);
		
		lblSL.setBounds(450, 20, w1, h);
		txtSL.setBounds(570, 20, w2, h);
		txtSL.setEditable(false);
		
		lblTheLoai.setBounds(450, 45, w1, h);
		txtTheLoai.setBounds(570, 45, w2, h);
		txtTheLoai.setEditable(false);
		
		lblHangSX.setBounds(20, 70, w1, h);
		txtHangSX.setBounds(120, 70, w2, h);
		txtHangSX.setEditable(false);

		lblTinhTrang.setBounds(450, 70, w1, h);
		cboTinhTrang.setBounds(570, 70, w2, h);
		cboTinhTrang.setEditable(false);

		lblGhiChu.setBounds(20, 95, w1, h);
		txtGhiChu.setBounds(120, 95, w2, h);
		txtGhiChu.setEditable(false);
		lblGia.setBounds(20, 120, w1, h);
		txtGia.setBounds(120, 120, w2, h);
		txtGia.setEditable(false);
		
		lblTim.setBounds(450, 120, w1+10, h);
		txtTim.setBounds(570, 120, w2, h);
		
		txtMess.setBounds(20, 145, 550, 20);

		JPanel pCen;
		add(pCen = new JPanel(), BorderLayout.CENTER);
		pCen.add(btnBack = new JButton("Trở về"));
		pCen.add(btnAddToCart = new JButton("Thêm vào đơn hàng"));
		pCen.add(btnMoCart = new JButton("Mở giỏ hàng"));
		pCen.add(btnTim = new JButton("Tìm kiếm theo mã"));

		JScrollPane scroll;
		String[] headers = "MaCD;TenCD;TheLoai;HangSX;TinhTrang;GhiChu;Gia;SoLuong".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách các băng đĩa"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));

		btnAddToCart.addActionListener(this);
		btnBack.addActionListener(this);
		btnMoCart.addActionListener(this);
		table.addMouseListener(this);
		btnTim.addActionListener(this);

	}

	private void clearTextFields() {
		txtTenBangDia.setText("");
		txtMaBangDia.setText("");
		txtTheLoai.setText("");
		txtHangSX.setText("");
		txtGhiChu.setText("");
		txtGia.setText("");
		txtMaBangDia.setEditable(true);
		txtMaBangDia.requestFocus();
	}

	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}

	String maBD, tenBD, theLoai, hangSX, tinhTrang, ghiChu,gia, sl;
	private BangDia revertCDFromTextFields() {
		maBD = txtMaBangDia.getText().trim();
		tenBD = txtTenBangDia.getText().trim();
		theLoai = txtTheLoai.getText().trim();
		hangSX = txtHangSX.getText().trim();
		tinhTrang = cboTinhTrang.getSelectedItem().toString();
		ghiChu = txtGhiChu.getText().trim();
		gia= txtGia.getText().trim();
		sl = txtSL.getText().trim();
		return new BangDia(maBD, tenBD, theLoai, hangSX, tinhTrang, ghiChu,Double.parseDouble(gia),Integer.parseInt(sl));
	}

	private void fillForm(int row) {
		if (row != -1) {
			String maBD = (String) table.getValueAt(row, 0);
			BangDia cd = new BangDia(maBD);
			ArrayList<BangDia> dsBD = QuanLyBangDia.getDsBangDia();
			if (QuanLyBangDia.getDsBangDia().contains(cd)) {
				cd = dsBD.get(dsBD.indexOf(cd));
				txtMaBangDia.setText(cd.getMaBangDia());
				txtTenBangDia.setText(cd.getTenBangDia());
				txtTheLoai.setText(cd.getTheLoai());
				txtHangSX.setText(cd.getHangSX());
				cboTinhTrang.setSelectedItem(cd.getTinhTrang());;
				txtGhiChu.setText(cd.getGhiChu() + "");
				txtGia.setText(cd.getGia() + "");
				txtSL.setText(cd.getSoLuong()+"");
				txtMaBangDia.setEditable(false);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		fillForm(row);
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
		 if (o.equals(btnTim)) {
			 String maCD = (String) txtTim.getText().trim();
			 BangDia cd = QuanLyBangDia.timKiem(maCD);
			 if (cd != null) {
			 int index = QuanLyBangDia.getDsBangDia().indexOf(cd);
			 fillForm(index);
			 table.getSelectionModel().setSelectionInterval(index, index);
			 table.scrollRectToVisible(table.getCellRect(index, index, true));
			 }
		 }else if(o.equals(btnBack)) {
			new FrmDangNhapTV().setVisible(true);
			this.setVisible(false);
		} else if (o.equals(btnAddToCart)) {
			BangDia cdc = revertCDFromTextFields();
			if (QuanLyBDCart.themBangDiaC(cdc)) {
				int row = table.getSelectedRow();
				if(Integer.parseInt(txtSL.getText())> 0) {
					txtSL.setText(Integer.parseInt(txtSL.getText())-1 + "");
					txtMess.setText("Thêm thành công một cd");
					tableModel.setValueAt(txtSL.getText(), row, 7);
					Database.SaveDatabaseBD_C(QuanLyBDCart.getDsBangDiaC());		
				}else if(Integer.parseInt(txtSL.getText()) == 0){
					JOptionPane.showMessageDialog(this, "Hết đĩa");
				}
				
			} else {
				showMessage("Error: Trùng mã cd", txtMaBangDia);
			}
		}else if(o.equals(btnMoCart)) {
			new FrmDatHang().setVisible(true);
			this.setVisible(false);
		}
	}
}
