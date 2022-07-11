package MatHang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
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

import NhanVien.DanhSachNV;
import NhanVien.DataBase;
import NhanVien.NhanVien;

public class FormHang extends JFrame implements ActionListener,MouseListener{
	
	private JTextField txtMa,txtTen,txtNhaCC,txtGia,txtSoLuong;
	private JButton btnLuu,btnSua,btnXoa,btnXoaRong,btnThoat;
	private JTable table;
	private ListHang listHang = new ListHang();
	
	public static DefaultTableModel htable;
	
	public FormHang() {
		setTitle("Nhập mặt hàng");
		setSize(800,450);
		setLocation(0, 50);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
		
	}
	
	public void buildUI() {
		JLabel lblMa,lblTen,lblNhaCC,lblGia,lblSoLuong;
		
		Box b1 = Box.createVerticalBox();
		b1.add(Box.createVerticalStrut(23));
		b1.add(lblMa = new JLabel("Mã hàng:"));
		b1.add(Box.createVerticalStrut(23));
		b1.add(lblTen = new JLabel("Tên hàng:"));
		b1.add(Box.createVerticalStrut(23));
		b1.add(lblNhaCC = new JLabel("Nhà cung cấp:"));
		b1.add(Box.createVerticalStrut(23));
		b1.add(lblGia = new JLabel("Giá bán:"));
		b1.add(Box.createVerticalStrut(23));
		b1.add(lblSoLuong = new JLabel("Số sản phẩm:"));
		b1.add(Box.createVerticalStrut(15));
		
		JPanel pWest = new JPanel();
		add(pWest,BorderLayout.WEST);
		pWest.add(b1);
		pWest.setPreferredSize(new Dimension(150,500));
		
		Box b2 = Box.createVerticalBox();
		b2.add(Box.createVerticalStrut(25));
		b2.add(txtMa = new JTextField(40));
		b2.add(Box.createVerticalStrut(20));
		b2.add(txtTen = new JTextField(20));
		b2.add(Box.createVerticalStrut(20));
		b2.add(txtNhaCC = new JTextField(20));
		b2.add(Box.createVerticalStrut(20));
		b2.add(txtGia = new JTextField(20));
		b2.add(Box.createVerticalStrut(20));
		b2.add(txtSoLuong = new JTextField(20));
		b2.add(Box.createVerticalStrut(20));
		
		JScrollPane scroll;
		String [] headers="Mã hàng;Tên hàng;Nhà cung cấp;Giá;Số lượng".split(";");
		htable= new DefaultTableModel(headers,0);
		
		b2.add(scroll=new JScrollPane(table = new JTable(htable),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		table.setRowHeight(3);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scroll.setViewportView(table= new JTable(htable));
		scroll.setPreferredSize(new Dimension(0,110));
		
		
		JPanel pMid = new JPanel(new GridLayout(1,2));
		add(pMid, BorderLayout.CENTER);
		pMid.add(b2);
		pMid.setPreferredSize(new Dimension(750,500));
		
		
		Panel pSouth = new Panel();
		Box b = Box.createHorizontalBox() ;
		
		b.add(Box.createHorizontalStrut(60));
		b.add(btnLuu = new JButton("Lưu mặt hàng"));
		b.add(Box.createHorizontalStrut(10));
		b.add(btnSua = new JButton("Sửa mặt hàng"));
		b.add(Box.createHorizontalStrut(10));
		b.add(btnXoa = new JButton("Xoá"));
		b.add(Box.createHorizontalStrut(10));
		b.add(btnXoaRong = new JButton("Xoá rỗng"));
		b.add(Box.createHorizontalStrut(10));
		b.add(btnThoat = new JButton("Thoát"));
		b.add(Box.createHorizontalStrut(10));
		
	
		pSouth.add(b);
		add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(null);
		b.setBounds(100, 10, 650, 50);
		
		b.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pSouth.setPreferredSize(new Dimension(0, 100));
		pSouth.setBackground(Color.cyan);
		
		
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnThoat.addActionListener(this);
		
		table.addMouseListener(this);
		DataBase.getInstance().connect();
		updateTableDatatim();
	}
	private void XoaRong() {
		txtMa.setText("");
		txtTen.setText("");
		txtNhaCC.setText("");
		txtGia.setText("");
		txtSoLuong.setText("");
		txtMa.requestFocus();
	}
	private void updateTableDatatim() {
		ListHang ds = new ListHang();
		ArrayList<MatHang> list = ds.docTuBang();
		for (MatHang mh : list) {
			String [] rowData = {mh.getMaH(),mh.getTenH(),mh.getNhaCC(),mh.getGia()+"",mh.getSoLuong()+""};
			htable.addRow(rowData);
		}
		table.setModel(htable);	
	}
	
	String maH,tenH,nhaCC,gia,soLuong;
	float giaBan;
	int soLuongH;
	
	private MatHang kiemTraDL() {
		maH = txtTen.getText().trim();
		tenH = txtTen.getText().trim();
		nhaCC = txtNhaCC.getText().trim();
		gia = txtGia.getText().trim();
		giaBan = gia.length()==0 ? 0 : Float.parseFloat(gia);
		soLuong = txtSoLuong.getText().trim();
		soLuongH = soLuong.length()==0 ? 0 : Integer.parseInt(soLuong);
		return new MatHang(maH,tenH,nhaCC,giaBan,soLuongH);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMa.setText(table.getValueAt(row, 0).toString());
		txtMa.setEditable(false);
		txtTen.setText(table.getValueAt(row, 1).toString());
		txtNhaCC.setText(table.getValueAt(row, 2).toString());
		txtGia.setText(table.getValueAt(row, 3).toString());
		txtSoLuong.setText(table.getValueAt(row, 4).toString());
		
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
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			dispose();
		}
		if(o.equals(btnXoaRong)) {
			XoaRong();
			txtMa.setEditable(true);
		}
		if(o.equals(btnLuu)) {
			MatHang nv = kiemTraDL();
			try {
				Float.parseFloat(txtGia.getText().trim());
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Giá bán phải là số");
				return;
			}
			try {
				Integer.parseInt(txtSoLuong.getText().trim());
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Số lượng phải là số");
				return;
			}
			if(!(maH.length()>0)) {
				JOptionPane.showMessageDialog(null,"Không được để trống mã");
				return;
			}else if(!(tenH.length()>0)) {
				JOptionPane.showMessageDialog(null, "Không được để trống tên");
				return;
			}else if(!(nhaCC.length()>0)){
				JOptionPane.showMessageDialog(null, "Không được để trống nhà cung cấp");
				return;
			}else {
				if(listHang.create(txtMa.getText(), txtTen.getText(),txtNhaCC.getText(),Float.parseFloat(txtGia.getText()),Integer.parseInt(txtSoLuong.getText()))) {
					Object []rowData = {txtMa.getText(),txtTen.getText(),txtNhaCC.getText(),txtGia.getText(),txtSoLuong.getText()+""};
					htable.addRow(rowData);
					JOptionPane.showMessageDialog(null, "Lưu thành công");
					
				}else {
					JOptionPane.showMessageDialog(null, "Trùng mã");
					txtMa.selectAll();
					txtMa.requestFocus();
				}
			}
			
			
		}
		
		if(o.equals(btnSua)) {
			int row = table.getSelectedRow();
			if(row>=0) {
				int loinhac = JOptionPane.showConfirmDialog(null,"Bạn có chắc không","Chú ý", JOptionPane.YES_NO_OPTION);
				if(loinhac == JOptionPane.YES_OPTION) {
					if(listHang.update(txtMa.getText(), txtTen.getText(),txtNhaCC.getText(), Float.parseFloat(txtGia.getText()),Integer.parseInt(txtSoLuong.getText()))) {
						table.setValueAt(txtTen.getText(), row,1);
						table.setValueAt(txtNhaCC.getText(), row,2);
						table.setValueAt(Float.parseFloat(txtGia.getText()), row, 3);
						table.setValueAt(Integer.parseInt(txtSoLuong.getText()), row, 4);
						JOptionPane.showMessageDialog(null,"Đã sửa thành công");
				}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Bạn cần chọn mặt hàng muốn sửa muốn sửa");
			}
		}
		
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row >=0 ) {
				int loinhac = JOptionPane.showConfirmDialog(null,"Bạn có chắc không","Chú ý",JOptionPane.YES_NO_OPTION);
				if(loinhac == JOptionPane.YES_OPTION) {
					String maH = (String) table.getValueAt(row,0);
					if(listHang.delete(maH)) {
						htable.removeRow(row);
						XoaRong();
				}
				JOptionPane.showMessageDialog(null,"Đã xóa thành công");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Bạn cần chọn mặt hàng muốn xóa");
			}
		}
		
	}
	public static void main(String[] args) {
		new FormHang().setVisible(true);
	}
}
