package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import enTiTy.CarriageTrip;
import ketNoiSQL.DataBase;
import thucThi.DaoNV_SauDN;

public class NV_XoaTour extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	public JButton btnThoat, btnXoa;
	public JLabel lblTitle; 
	public JTable table;
	public DefaultTableModel tableModel;
	DaoNV_SauDN dstour = new DaoNV_SauDN();
	
	public NV_XoaTour() {
		super("Xóa tour");
		setSize(1000, 600);
		setResizable(false);
		setLocation(100, 30);
		setResizable(false);
		JPanel pNorth = new JPanel();
		pNorth.add(lblTitle = new JLabel("TOUR DU LỊCH"));
		lblTitle.setFont(new Font("Time news Roman",Font.BOLD,20));
		lblTitle.setForeground(Color.BLUE);
		pNorth.setBackground(Color.yellow);
		add(pNorth,BorderLayout.NORTH);

		Box c = Box.createVerticalBox();
		String[] headers = "Mã Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		c.add(scroll);
		add(c,BorderLayout.CENTER);
		c.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));
		
		JPanel pSouth= new JPanel();
		pSouth.add(btnXoa = new JButton("Xóa"));
		btnXoa.setBackground(Color.green);
		pSouth.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(Color.green);
		pSouth.setBackground(Color.LIGHT_GRAY);
		add(pSouth,BorderLayout.SOUTH);
		
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		DataBase.getInstance().connect();
		updataTableData();

	
	}
	private void updataTableData() {
		DaoNV_SauDN nv = new DaoNV_SauDN();
		List<CarriageTrip> ls = nv.docTT();
		for(CarriageTrip c : ls) {
			String []data = {c.getId()+"",c.getName(), c.getCompayid()+"", c.getNgayBatDau(), c.getNgayKetThuc()
					,c.getPlace(), c.getAddress(), c.getDonGia()+""};
			tableModel.addRow(data);
		}
		table.setModel(tableModel);
		
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row != -1) {
				int id = Integer.parseInt((String)table.getValueAt(row, 0));
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa Tour này","Chú ý",JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION) {
					if(dstour.deleteTour(id)) {
						tableModel.removeRow(row);				
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn Tour muốn xóa!");
			}
		}else if(obj.equals(btnThoat)) {
			setVisible(false);
			new Menu().setVisible(true);
		}
	}

	public static void main(String[] args) {
		NV_XoaTour fm = new NV_XoaTour();
		fm.setVisible(true);
	}

}
