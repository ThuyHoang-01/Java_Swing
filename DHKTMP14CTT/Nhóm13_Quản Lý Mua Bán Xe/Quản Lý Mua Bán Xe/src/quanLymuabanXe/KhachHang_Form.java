package quanLymuabanXe;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.Option;



import quanLymuabanXe.NhanVien_form;
import quanLymuabanXe.Xe_Form;



public class KhachHang_Form extends JFrame implements ActionListener,MouseListener {

	private JTextField txtMaKH,txtTenKH,txtDiaChi,txtSoDienThoai;
	private JLabel	lblMaKH,lblTenKH,lblDiaChi,lblSDT;
	private JButton btnThem, btnSua, btnXoa, btnLuu, btnXe, btnKhachhang, btnHoadon,btnNhanVien;
	public static DefaultTableModel DTMKhachhang;
	private JTable tableKhachhang;
	
	DanhSachKhachHang dskh = new DanhSachKhachHang();
	public KhachHang_Form() {
		setTitle("^_^");
		setSize(1000,580);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		JPanel pNorth =new JPanel();
		JLabel lbltieude =new JLabel("QUAN LY KHACH HANG");
		lbltieude.setFont(new Font("Arial",Font.BOLD,30));
		lbltieude.setForeground(Color.BLUE);
		pNorth.add(lbltieude);
		add(pNorth,BorderLayout.NORTH);
		
		Box b=Box.createVerticalBox();
		Box b1; Box b3;
		Box b2; Box b4,b5;
		b.add(Box.createVerticalStrut(50));
		b.add(b1=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(Box.createHorizontalStrut(430));
		b1.add(lblMaKH=new JLabel("Ma Khach hang"));
		b1.add(txtMaKH=new JTextField());
		
		b.add(b2=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTenKH=new JLabel("Ten Khach Hang"));
		b2.add(txtTenKH=new JTextField());
		
		
		b.add(b3=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblDiaChi=new JLabel("Dia CHi"));
		b3.add(txtDiaChi=new JTextField());
		
		
		
		b.add(b4=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblSDT=new JLabel("So Dien Thoai"));
		b4.add(txtSoDienThoai=new JTextField());
		
		lblMaKH.setPreferredSize(lblMaKH.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMaKH.getPreferredSize());
		lblSDT.setPreferredSize(lblDiaChi.getPreferredSize());
		lblTenKH.setPreferredSize(lblSDT.getPreferredSize());
		
		b.add(Box.createVerticalStrut(30));
		b.add(b5=Box.createHorizontalBox());
		
		b5.add(btnThem = new JButton("Thêm"));
		b5.add(btnSua = new JButton("Sửa"));
		b5.add(btnXoa = new JButton("Xóa"));

		
		String [] headers = "Ma Khach Hang;Ten Khach Hang;Dia Chi;So Dien Thoai". split(";");
		DTMKhachhang=new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane();
		scroll. setViewportView(tableKhachhang = new JTable(DTMKhachhang));
		tableKhachhang. setRowHeight(25);
		tableKhachhang. setAutoCreateRowSorter(true);
		tableKhachhang. setAutoResizeMode(JTable. AUTO_RESIZE_NEXT_COLUMN);
		
		JSplitPane split = new JSplitPane(JSplitPane. HORIZONTAL_SPLIT);
		add(split, BorderLayout.CENTER);
		JPanel pnlLeft, pnlRight;
		split. add(pnlLeft = new JPanel());
		split. add(pnlRight = new JPanel());
		pnlLeft.add(b);
		pnlRight.add(scroll);
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

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		tableKhachhang.addMouseListener(this);
		DataBase.getInstance().connect();
		updateTableData();
		
	}
	


	public static void main(String[] args) {

		new KhachHang_Form();
	}
	String maKH,tenKH,dc;
	int sdt; 
	
	private KhachHang KiemtraDulieu() {
		maKH = txtMaKH.getText().trim();
		tenKH = txtTenKH.getText().trim();
		dc = txtDiaChi.getText().trim();
		
		return new KhachHang(maKH, tenKH, dc,sdt);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object sourceEvent = e.getSource();
		if (sourceEvent.equals(btnXe)) {
			handleXe();
		}
		
		if (sourceEvent.equals(btnNhanVien)) {
			handleNhanVien();
		}
		if(sourceEvent.equals(btnThem)) {
			txtMaKH.setEditable(true);
			KhachHang kt = KiemtraDulieu();
			if(!(maKH.length()>0)) {
				JOptionPane.showMessageDialog(null, "Khong duoc de trong ma Khach");
				return;
			}else if(!(tenKH.length()>0)) {
				JOptionPane.showMessageDialog(null,"Khong duoc de trong ten Khac Hang");
				return;
			}else if(!(dc.length()>0)) {
				JOptionPane.showMessageDialog(null,"Khong duoc de trong Dia Chi");
				return;
			}
			else {
				if(dskh.create(txtMaKH.getText(), txtTenKH.getText(), txtDiaChi.getText(),Integer.parseInt(txtSoDienThoai.getText()))); {
					Object []rowData = {txtMaKH.getText(),txtTenKH.getText(),txtDiaChi.getText(),Integer.parseInt(txtSoDienThoai.getText())};
					DTMKhachhang.addRow(rowData);
				}
			}
			xoaRongTextfields();
		}
		if(sourceEvent.equals(btnSua)) {
			int row = tableKhachhang.getSelectedRow();
			if(row>=0) {
				if(dskh.update(txtMaKH.getText(), txtTenKH.getText(), txtDiaChi.getText(),Integer.parseInt(txtSoDienThoai.getText()) )) {
					tableKhachhang.setValueAt(txtTenKH.getText(), row, 1);
					tableKhachhang.setValueAt(txtDiaChi.getText(), row, 2);
					tableKhachhang.setValueAt(txtSoDienThoai.getText(), row, 3);
					
				}
				
			}
		}
		if(sourceEvent.equals(btnXoa)) {
			int row = tableKhachhang.getSelectedRow();
			if(row >= 0) {
				String maKH = (String) tableKhachhang.getValueAt(row, 0);
				if(dskh.delete(maKH)) {
					DTMKhachhang.removeRow(row);
					xoaRongTextfields();
				}
			}
		}
	}
	public void mouseClicked(MouseEvent e) {
		int row = tableKhachhang.getSelectedRow();
		txtMaKH.setText(tableKhachhang.getValueAt(row, 0).toString());
		txtTenKH.setText(tableKhachhang.getValueAt(row, 1).toString());
		txtDiaChi.setText(tableKhachhang.getValueAt(row, 2).toString());
		txtSoDienThoai.setText(tableKhachhang.getValueAt(row, 3).toString());
	}

	private void handleNhanVien() {
		setVisible(false);
		new NhanVien_form().setVisible(true);
		
	}


	private void handleXe() {
		setVisible(false);
		new Xe_Form().setVisible(true);
	}
	
	private void xoaRongTextfields() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtSoDienThoai.setText("");
		txtDiaChi.setText("");
		txtMaKH.requestFocus();
		
		
	}
	
	private void updateTableData() {
		DanhSachKhachHang ds = new DanhSachKhachHang();
		ArrayList<KhachHang> list = ds.docTuBang();
		for (KhachHang s : list) {
			String [] rowData = {s.getMaKH(),s.getTenKH(),s.getDiaChi(),s.getSoDienThoai()+""};
			DTMKhachhang.addRow(rowData);
		}
		tableKhachhang.setModel(DTMKhachhang);
		
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

