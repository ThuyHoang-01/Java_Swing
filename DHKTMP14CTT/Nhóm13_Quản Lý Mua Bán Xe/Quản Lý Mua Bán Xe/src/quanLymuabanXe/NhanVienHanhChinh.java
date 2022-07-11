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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NhanVienHanhChinh extends JFrame implements ActionListener, MouseListener {
	private JLabel lblTitle,lblMaNV, lblTenNV, lblChucVu, lblPhongBan, lblTrinhDoHocVan;
	private JTextField txtMaNV,txtTenNV, txtChucVu, txtPhongban, txtTrinhDoHocVan;
	private DefaultTableModel dtmNVHC;
	private JTable tableNVHC;
	private JButton btnTroVe;
	private JButton btnThem, btnXoa;
	DS_NVHC dshc = new DS_NVHC();

	public NhanVienHanhChinh() {
		super("Nhân Viên Hành chính");
		setSize(500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setNVHCLayout();
	}

	private void setNVHCLayout() {
		setTitle("^_^");
		setSize(1000, 580);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		JPanel pNorth = new JPanel();
		JLabel lbltieude = new JLabel("NHÂN VIÊN HÀNH CHÍNH");
		lbltieude.setFont(new Font("Arial", Font.BOLD, 30));
		lbltieude.setForeground(Color.BLUE);
		pNorth.add(lbltieude);
		add(pNorth, BorderLayout.NORTH);

		Box b = Box.createVerticalBox();
		Box b1;
		Box b3;
		Box b2;
		Box b4, b5,b6;
		b.add(Box.createVerticalStrut(40));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(Box.createHorizontalStrut(400));
		b1.add(lblMaNV = new JLabel("Mã Nhân Viên"));
		b1.add(txtMaNV = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTenNV = new JLabel("Tên Nhân Viên "));
		b2.add(txtTenNV = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblChucVu = new JLabel("Chức Vụ"));
		b3.add(txtChucVu = new JTextField());

		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblPhongBan = new JLabel("Phòng ban"));
		b4.add(txtPhongban = new JTextField());

		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b5.add(lblTrinhDoHocVan = new JLabel("Trình độ học vấn"));
		b5.add(txtTrinhDoHocVan = new JTextField());
		lblMaNV.setPreferredSize(lblTrinhDoHocVan.getPreferredSize());
		lblTenNV.setPreferredSize(lblTrinhDoHocVan.getPreferredSize());
		lblPhongBan.setPreferredSize(lblTrinhDoHocVan.getPreferredSize());
		lblChucVu.setPreferredSize(lblTrinhDoHocVan.getPreferredSize());

		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b6.add(btnThem = new JButton("Thêm"));
		b6.add(btnXoa = new JButton("Xóa"));
		

		String[] headers = "Mã Nhân Viên;Tên nhân viên;Chức Vụ;Phòng ban".split(";");
		dtmNVHC = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tableNVHC = new JTable(dtmNVHC));
		tableNVHC.setRowHeight(25);
		tableNVHC.setAutoCreateRowSorter(true);
		tableNVHC.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(split, BorderLayout.CENTER);
		JPanel pnlLeft, pnlRight;
		split.add(pnlLeft = new JPanel());
		split.add(pnlRight = new JPanel());
		pnlLeft.add(b);
		pnlRight.add(scroll);
		JPanel pnTacvukhac = new JPanel();
		add(pnTacvukhac, BorderLayout.SOUTH);
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		DataBase.getInstance().connect();
		updateTableData();
		
	}
	public static void main(String[] args) {
		new NhanVienHanhChinh();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
		Object obj = e.getSource();
		if(obj.equals(btnThem)) {
			dshc.create(Integer.parseInt(txtMaNV.getText()), txtTenNV.getText(), txtChucVu.getText(), txtPhongban.getText(), txtTrinhDoHocVan.getText());
			Object[] rowData = {Integer.parseInt(txtMaNV.getText()), txtTenNV.getText(), txtChucVu.getText(), txtPhongban.getText(), txtTrinhDoHocVan.getText()}; 	
				dtmNVHC.addRow(rowData);
			
		}else if(obj.equals(btnXoa)) {
			int row = tableNVHC.getSelectedRow();
			if(row>=0) {
				int maNV =(int) tableNVHC.getValueAt(row, 0);
				if(dshc.delete(maNV)) {
					dtmNVHC.removeRow(row);
					XoaRong();
				}
			}
		}

	}
	private void updateTableData() {
		DS_NVHC ds = new DS_NVHC();
		ArrayList<NVHC> list = ds.docTuBang();
		for (NVHC s : list) {
			String [] rowData = {s.getMaNV()+"",s.getTenNV(),s.getChucVu(),s.getPhongBan(),
					s.getTrinhDoHV()};
			dtmNVHC.addRow(rowData);
		}
		tableNVHC.setModel(dtmNVHC);
	}

	private void XoaRong() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtChucVu.setText("");
		txtPhongban.setText("");
		txtTrinhDoHocVan.setText("");
		
	}
}

