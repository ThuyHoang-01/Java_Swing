package Table.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DemoTable extends JFrame implements ActionListener,MouseListener {
	
	private JLabel lMa, lHo, lTen, lTuoi, lPhai, lTien, lNhap;
	private JTextField txMa, txHo, txTen, txTuoi, txTien, txNhap;
	private JRadioButton rbNu;
	private JButton btTim, btThem, btXoaT, btXoa, btLuu;
	private DefaultTableModel dtm;
	private JTable table;
	DanhSachNhanVien dsNV;
	
	public DemoTable() {
		super("^-^");
		setSize(800,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout()); 
		//North
		JPanel pnN = new JPanel();
		JLabel lbN = new JLabel("THÔNG TIN NHÂN VIÊN");
		lbN.setForeground(Color.blue);
		lbN.setFont(new Font("Serif",Font.BOLD,20));
		pnN.add(lbN);
		//Center
		JPanel pnC = new JPanel();
		//Box
		Box box = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		//Box1
		lMa = new JLabel("Mã nhân viên:");
		txMa = new JTextField(50);
		b1.add(lMa);
		b1.add(txMa);
		//Box2
		lHo = new JLabel("Họ:");
		lTen = new JLabel("Tên nhân viên:");
		txHo = new JTextField(20);
		txTen = new JTextField(20);
		b2.add(lHo);
		b2.add(Box.createHorizontalStrut(59));
		b2.add(txHo);
		b2.add(lTen);
		b2.add(txTen);
		//Box3
		lTuoi = new JLabel("Tuổi:");
		lPhai = new JLabel("Phái:");
		txTuoi = new JTextField(40);
		rbNu = new JRadioButton("Nữ");
		b3.add(lTuoi);
		b3.add(Box.createHorizontalStrut(51));
		b3.add(txTuoi);
		b3.add(lPhai);
		b3.add(Box.createHorizontalStrut(20));
		b3.add(rbNu);
		//Box4
		lTien = new JLabel("Tiền lương:");
		txTien = new JTextField(50);
		b4.add(lTien);
		b4.add(Box.createHorizontalStrut(13));
		b4.add(txTien);
		//Box Chung
		box.add(b1);
		box.add(Box.createRigidArea(new Dimension(10,10)));
		box.add(b2);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		box.add(b3);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		box.add(b4);
		//Table
		String []name = {"Mã NV","Họ","Tên","Phái","Tuổi","Tiền lương"};
		dtm = new DefaultTableModel(name,0);
		table = new JTable(dtm);
		JScrollPane sp = new JScrollPane(table);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		box.add(sp);
		pnC.add(box);
		//South
		JPanel pnS = new JPanel();
		JPanel pnTrai = new JPanel();
		JPanel pnPhai = new JPanel();
		//Panel Trai
		lNhap = new JLabel("Nhập mã số cần tìm:");
		txNhap = new JTextField(10);
		btTim = new JButton("Tìm");
		pnTrai.add(lNhap);
		pnTrai.add(txNhap);
		pnTrai.add(btTim);
		//Panel Phai
		btThem = new JButton("Thêm");
		btXoaT = new JButton("Xoá trắng");
		btXoa = new JButton("Xoá");
		btLuu = new JButton("Lưu");
		pnPhai.add(btThem);
		pnPhai.add(btXoaT);
		pnPhai.add(btXoa);
		pnPhai.add(btLuu);
		JSplitPane spl = new JSplitPane();
		spl.setLeftComponent(pnTrai);
		spl.setRightComponent(pnPhai);
		pnS.add(spl);
		//
		add(pnN,BorderLayout.NORTH);
		add(pnC,BorderLayout.CENTER);
		add(pnS,BorderLayout.SOUTH);
		//
		dsNV = new DanhSachNhanVien();
		LuuTru l = new LuuTru();
		try {
			dsNV = (DanhSachNhanVien) l.DocFile("data/NhanVien.txt");
			//System.out.println(dsNV.getSize());
			for(int i = 0; i < dsNV.getSize(); i++)
			{
				NhanVien nv = dsNV.getElement(i);						
				dtm.addRow(new Object[] {
						nv.getMa(),nv.getHo(),nv.getTen(),nv.getTuoi(),nv.getPhai(),nv.getLuong()});
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy file.");
			e.printStackTrace();
		}
		//DocDuLieu();
		//Action
		btLuu.addActionListener(this);
		btThem.addActionListener(this);
		btTim.addActionListener(this);
		btXoa.addActionListener(this);
		btXoaT.addActionListener(this);
		table.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		new DemoTable().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btThem)) {
			int ma = Integer.parseInt(txMa.getText());
			String ho = txHo.getText();
			String ten = txTen.getText();
			int tuoi = Integer.parseInt(txTuoi.getText());
			boolean phai = rbNu.isSelected();
			double luong = Double.parseDouble(txTien.getText());
			NhanVien nv = new NhanVien(ho, ten, ma, phai, tuoi, luong);
			if(!dsNV.themNV(nv)) {
				JOptionPane.showMessageDialog(this, "Trùng");
			}else {
				dtm.addRow(new Object[] {nv.getMa(),nv.getHo(),nv.getTen(),nv.getTuoi(),nv.getPhai(),nv.getLuong()});
			}
		}  if (o.equals(btTim)) {
			timTheoMa();
		}  if(o.equals(btLuu)) {
			LuuTru l = new LuuTru();
			try {
				l.LuuFile(dsNV, "data/NhanVien.txt");
				System.out.println( "Lưu thành công.");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}  if(o.equals(btXoa)) {
			int n = table.getSelectedRow();
			dtm.removeRow(n);
			NhanVien nv = dsNV.getElement(n);
			dsNV.xoaNV(nv.getMa());
		}  if(o.equals(btXoaT)) {
			txHo.setText("");
			txMa.setText("");
			txTen.setText("");
			txTuoi.setText("");
			txTien.setText("");
			txMa.requestFocus();
		}  if(o.equals(btTim)) {
			timTheoMa();
		}
	}
//	public void DocDuLieu() {
//		for (int i = 0; i < dsNV.getSize();i++ ) {
//			NhanVien nv = dsNV.getElement(i);
//			dtm.addRow(new Object [] {nv.getMa(),nv.getHo(),nv.getTen(),nv.getTuoi(),nv.getPhai(),nv.getLuong()});
//		}
//	}
	private void XoaSachDuLieu() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}

	
	public void timTheoMa() {
		String tim = txNhap.getText();
		if (tim != null && tim.trim().length() > 0) {
			try {
				int ma = Integer.parseInt(tim);
				NhanVien nv = dsNV.timKiem(ma);
				if(nv != null ) {
					XoaSachDuLieu();
					dtm.addRow(new Object [] {nv.getMa(),nv.getHo(),nv.getTen(),nv.getTuoi(),nv.getPhai(),nv.getLuong()} );
				} else {
					JOptionPane.showConfirmDialog(null, "Không tìm thấy.");
					return;
				}
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "Dữ liệu không hợp lệ.");
				txNhap.selectAll();
				txNhap.requestFocus();
			}
		} else {
			XoaSachDuLieu();
		}
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txMa.setText(dtm.getValueAt(row	, 0).toString());
		txHo.setText(dtm.getValueAt(row	, 1).toString());
		txTen.setText(dtm.getValueAt(row	, 2).toString());
		txTuoi.setText(dtm.getValueAt(row	, 3).toString());
		rbNu.setSelected(dtm.getValueAt(row	, 4).toString() == "True" ? true:false);
		txTien.setText(dtm.getValueAt(row	, 5).toString());
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
