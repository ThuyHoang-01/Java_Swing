package thiThuLan1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Layout extends JFrame implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SanPham_Collection listSP;
	private String[] cloHeader= {"Ma SP","Tên Sán phẩm","Số lượng","Loại sản phẩm","Giá sản pham"};
	DefaultTableModel modelSanPham = new DefaultTableModel(cloHeader,0);
	JTable tableSanPham= new JTable(modelSanPham);
	//--
	private JLabel lblMaSP = new JLabel("Ma SP");
	private JLabel lblTenSP = new JLabel("Ten SP");
	private JLabel lblSoLuongSP = new JLabel("So Luong SP");	
	private JLabel lblGiaSP = new JLabel("Gia SP");
	private JLabel lblLoaiSP = new JLabel("Loai SP");
	private JLabel lblTimSP = new JLabel("Tim SP");
	//----
	private JTextField txtMaSP = new JTextField(20);
	private JTextField txtTenSP = new JTextField(20);
	private JTextField txtSoLuongSP = new JTextField(20);	
	private JTextField txtGiaSP = new JTextField(20);
	private JTextField txtLoaiSP = new JTextField(20);
	private JTextField txtTimSP = new JTextField(20);
	//---
	private JButton btnThem = new JButton("Them"); 
	private JButton btnTim = new JButton("Tim"); 
	private JButton btnXoa = new JButton("Xoa"); 
	private JButton btnXoaTrang = new JButton("Xoa Trang"); 
	private JButton btnLuu = new JButton("Luu"); 
	//---
	private JPanel pnlMain = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JPanel pnlNorth = new JPanel();
	private JPanel pnl1 = new JPanel();
	private JPanel pnl2 = new JPanel();
	private JPanel pnl3 = new JPanel();
	//--
	private String[] arr= {"Banh ngot","Nuoc ngot","Keo ngot","XXX"};
	JComboBox jcb = new JComboBox(arr);
	
	
	
	public Layout() {
		// TODO Auto-generated constructor stub
		setTitle("Title");
		setSize(1000, 500);
		setAlwaysOnTop(true);
		setResizable(false);
		pnlMain.setLayout(new BorderLayout());
		pnl1.add(lblMaSP);
		pnl1.add(txtMaSP);
		pnl2.add(lblTenSP);
		pnl2.add(txtTenSP);
		pnl2.add(lblSoLuongSP);
		pnl2.add(txtSoLuongSP);
		pnl3.add(lblLoaiSP);
		pnl3.add(jcb);
		pnl3.add(lblGiaSP);
		pnl3.add(txtGiaSP);
		pnlNorth.setLayout(new BoxLayout(pnlNorth,BoxLayout.Y_AXIS));
		pnlNorth.add(pnl1);
		pnlNorth.add(pnl2);
		pnlNorth.add(pnl3);
		tableSanPham.setRowHeight(30);
		pnlSouth.add(lblTimSP);
		pnlSouth.add(txtTimSP);
		pnlSouth.add(btnTim);
		pnlSouth.add(btnThem);
		pnlSouth.add(btnXoa);
		pnlSouth.add(btnXoaTrang);
		pnlSouth.add(btnLuu);
		
		pnlCenter.add(new JScrollPane(tableSanPham));
		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlCenter,BorderLayout.CENTER);
		pnlMain.add(pnlSouth,BorderLayout.SOUTH);
		this.add(pnlMain);
		//--
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		tableSanPham.addMouseListener(this);
		listSP = new SanPham_Collection();
		LuuTru l = new LuuTru();
		try {
			listSP = (SanPham_Collection) l.DocFile("data/SanPham.txt");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Khong tim thay file");
		}
		DocDLTuFile();
		
	
		
	}
	private void DocDLTuFile() {
		for (int i = 0; i < listSP.getSize(); i++) {
			SanPham sp = listSP.getElement(i);
			modelSanPham.addRow(new Object[] {sp.getMaSP(),sp.getTenSP(),sp.getSoLuongSP(),jcb.getSelectedItem().toString(),sp.getGiaSP()});
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row = tableSanPham.getSelectedRow();
		txtMaSP.setText(modelSanPham.getValueAt(row, 0).toString());
		txtTenSP.setText(modelSanPham.getValueAt(row, 1).toString());
		txtSoLuongSP.setText(modelSanPham.getValueAt(row, 2).toString());
		jcb.setSelectedItem(modelSanPham.getValueAt(row, 3));
		txtGiaSP.setText(modelSanPham.getValueAt(row, 4).toString());
		
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
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			String maSP = txtMaSP.getText();
			 String TenSP= txtTenSP.getText();
			String Loai= txtLoaiSP.getText();
			 int soLuongSP= Integer.parseInt(txtSoLuongSP.getText());
			 float giaSP= Float.parseFloat(txtGiaSP.getText());
			 SanPham sp = new SanPham(maSP, TenSP, Loai, soLuongSP, giaSP);
			 if(listSP.themSP(sp)!=true) JOptionPane.showMessageDialog(this, "TRUNG");
			 else {
				 modelSanPham.addRow(new Object[] {sp.getMaSP(),sp.getTenSP(),sp.getSoLuongSP(),jcb.getSelectedItem().toString(),sp.getGiaSP()});
				
			}
		}
	if(o.equals(btnLuu)) {
		LuuTru luu = new LuuTru();
		try {
			luu.LuuFile(listSP,"data/SanPham.txt");
			JOptionPane.showMessageDialog(this, "Luu Thanh cong");
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	if(o.equals(btnXoa)) {
		int r= tableSanPham.getSelectedRow();
		modelSanPham.removeRow(r);
		SanPham sp= listSP.getElement(r);
		listSP.XoaSP(sp.getMaSP());
	}
	if(o.equals(btnXoaTrang)) {
		txtGiaSP.setText("");
		txtMaSP.setText("");
		txtSoLuongSP.setText("");
		txtTenSP.setText("");
		txtMaSP.requestFocus();
	}
		
		
		
	}
	public static void main(String[] args) {
		new Layout().setVisible(true);
	}
	

}
