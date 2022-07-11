package quanLymuabanXe;

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
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Xe_Form extends JFrame implements ActionListener {
	private JLabel lblTitle, lblMaxe, lblTenxe, lblNuocSX, lblLoaixe, lblSoPK, lblSoKhung,lblSoLuong, lblMauXe,lblGia;
	private JTextField txtMaxe, txtTenxe, txtNuocSx, txtLoaixe, txtSoPK, txtSoKhung,txtSoluong, txtMauXe,txtGia;
	private DefaultTableModel dtmXe;
	private JTable tableXe;
	private JButton btnThem, btnSua, btnXoa, btnTim,btnKhachhang,btnXe ,btnHoadon,btnNhanVien;
	DanhSachXe dsxe = new DanhSachXe();
	public Xe_Form() {
			setSize(900, 520);
			setVisible(true);
			setTitle("^_^");
			JPanel pnTitle = new JPanel();
			add(pnTitle, BorderLayout.NORTH);
			pnTitle.add(lblTitle = new JLabel("THÔNG TIN XE"));
			lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblTitle.setForeground(Color.BLUE);

			Box b = Box.createVerticalBox();
			Box b1, b2, b3, b4, b5, b6, b7, b8, b9,b10;

			b.add(b1 = Box.createHorizontalBox());
			b.add(Box.createVerticalStrut(10));
			b1.add(lblMaxe = new JLabel("Mã Xe: "));
			b1.add(txtMaxe = new JTextField());
			b1.add(lblTenxe = new JLabel("Tên Xe: "));
			b1.add(txtTenxe = new JTextField());
			
			b.add(b3 = Box.createHorizontalBox());
			b.add(Box.createVerticalStrut(10));
			b3.add(lblNuocSX = new JLabel("Nước sản xuất: "));
			b3.add(txtNuocSx = new JTextField());
			b3.add(lblLoaixe = new JLabel("Loại xe: "));
			b3.add(txtLoaixe = new JTextField());
			b3.add(lblSoPK = new JLabel("Số PK: "));
			b3.add(txtSoPK = new JTextField());
			b3.add(lblSoLuong = new JLabel("Số Luong: "));
			b3.add(txtSoluong = new JTextField());

			
			
			b.add(b5 = Box.createHorizontalBox());
			b.add(Box.createVerticalStrut(10));
			b5.add(lblSoKhung = new JLabel("Số Khung: "));
			b5.add(txtSoKhung = new JTextField());
			
			
			
			b.add(b8 = Box.createHorizontalBox());
			b.add(Box.createVerticalStrut(10));
			b8.add(lblMauXe = new JLabel("Màu Xe: "));
			b8.add(txtMauXe = new JTextField());
			b8.add(lblGia = new JLabel("Giá xe: "));
			b8.add(txtGia = new JTextField());
			
			b.add(b7 = Box.createHorizontalBox());
			b.add(Box.createHorizontalStrut(10));
			b7.add(btnThem = new JButton("Thêm"));
			b7.add(btnXoa = new JButton("Xoa"));
			
			lblMaxe.setPreferredSize(lblNuocSX.getPreferredSize());
			lblSoKhung.setPreferredSize(lblNuocSX.getPreferredSize());
			lblMauXe.setPreferredSize(lblNuocSX.getPreferredSize());
		

			b.add(b10 = Box.createHorizontalBox());
			b.add(Box.createHorizontalStrut(10));
			String[] headers = "Mã Xe;Tên Xe;Nước sản xuất;Loại xe;Số PK;Số Khung;Số Luong;Màu xe;Gia Xe".split(";");
			dtmXe = new DefaultTableModel(headers, 0);
			JScrollPane scroll = new JScrollPane();
			scroll.setViewportView(tableXe = new JTable(dtmXe));
			tableXe.setRowHeight(25);
			tableXe.setAutoCreateRowSorter(true);
			tableXe.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
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
			btnXoa.addActionListener(this);
			DataBase.getInstance().connect();
			updateTableData();
			
			
	}
	public static void main(String[] args) {
		new Xe_Form();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object sourceEvent = e.getSource();
		
		if(sourceEvent.equals(btnThem)) {
			dsxe.create(Integer.parseInt(txtMaxe.getText()),txtTenxe.getText(),txtNuocSx.getText(),txtLoaixe.getText()
					,Integer.parseInt(txtSoPK.getText()),Integer.parseInt(txtSoKhung.getText()),Integer.parseInt(txtSoluong.getText())
					,txtMauXe.getText(),Double.parseDouble(txtGia.getText())); 
			Object []rowData = {Integer.parseInt(txtMaxe.getText()),txtTenxe.getText(),txtNuocSx.getText(),txtLoaixe.getText()
					,Integer.parseInt(txtSoPK.getText()),Integer.parseInt(txtSoKhung.getText()),Integer.parseInt(txtSoluong.getText())
					,txtMauXe.getText(),Double.parseDouble(txtGia.getText())};
			dtmXe.addRow(rowData);	
		}
		if(sourceEvent.equals(btnXoa)) {
			int row = tableXe.getSelectedRow();
			if(row >= 0) {
				int maXe = Integer.parseInt((String)tableXe.getModel().getValueAt(row, 0));
				if(dsxe.delete(maXe)) {
					dtmXe.removeRow(row);
				}
			}
		}
	
	}
	private void updateTableData() {
		DanhSachXe ds = new DanhSachXe();
		ArrayList<Xe> list = ds.docTuBang();
		for (Xe s : list) {
			String [] rowData = {s.getMaXe()+"",s.getTenXe(),s.getNuocSX(),s.getLoaiXe(),
					s.getSoPK()+"",s.getSoKhung()+"",s.getSoLuong()+"",s.getMauXe(),s.getDonGia()+""};
			dtmXe.addRow(rowData);
		}
		tableXe.setModel(dtmXe);
	}

}
	