package Module2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ThongTinNhanVien extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lbltitle, lblManv, lblHo, lblTen, lblTuoi, lblTienluong, lblTimkiem, lblPhai;
	JTextField txtManv, txtHo, txtTuoi, txtTen, txtPhai, txtTienluong, txtTiemkiem;
	JRadioButton radPhai;
	JButton btnTim, btnthem, btnXoatrang, btnXoa, btnLuu;
	DefaultTableModel defaultTableModel;
	JTable jtable;
	TableColumn gioitinh;
	JComboBox<Object> cboxPhai;
	private JButton btnTiemkiem;
	private JButton btnThem;

	private void addControll() {
		// titile

		JPanel pNorth = new JPanel();
		pNorth.add(lbltitle = new JLabel(" Thông Tin Nhân Viên "));
		pNorth.setBackground(Color.BLUE);
		add(pNorth, BorderLayout.NORTH);

		// pCen Nhập và Jlist
		int height = 30;
		JPanel pCen = new JPanel();
		// dòng 1
		pCen.add(lblManv = new JLabel(" Mã nhân viên :"));
		lblManv.setBounds(15, 15, 90, height);

		pCen.add(txtManv = new JTextField());
		txtManv.setBounds(100, 15, 400, height);

		// dòng 2
		pCen.add(lblHo = new JLabel("H�?:"));
		// y+= 35;
		lblHo.setBounds(15, 50, 30, height);

		pCen.add(txtHo = new JTextField());
		txtHo.setBounds(100, 50, 110, height);

		pCen.add(lblTen = new JLabel("Tên:"));
		lblTen.setBounds(230, 50, 50, height);
		pCen.add(txtTen = new JTextField());
		txtTen.setBounds(290, 50, 210, height);

		// dòng 3
		// y+35
		pCen.add(lblTuoi = new JLabel("Tuổi:"));
		lblTuoi.setBounds(15, 85, 30, height);
		pCen.add(txtTuoi = new JTextField());
		txtTuoi.setBounds(100, 85, 110, height);

		pCen.add(lblPhai = new JLabel("Phái:"));
		lblPhai.setBounds(230, 85, 70, height);
		pCen.add(radPhai = new JRadioButton("Nữ"));
		radPhai.setBounds(280, 85, 70, height);

		// dòng 4
		pCen.add(lblTienluong = new JLabel("TI�?n lương:"));
		lblTienluong.setBounds(15, 120, 90, height);

		pCen.add(txtTienluong = new JTextField());
		txtTienluong.setBounds(100, 120, 400, height);

		// Phần jtable
		// tên mục
		String[] cols = { "Mã NV", "H�?", "Tên", "Phái", "Tuổi", "Ti�?n Lương" };

		defaultTableModel = new DefaultTableModel(cols, 0);
		jtable = new JTable(defaultTableModel);

		// Thêm combobox vào column
		cboxPhai = new JComboBox<Object>(new Object[] { "Nam", "Nu" });

		DefaultCellEditor cellEditor = new DefaultCellEditor(cboxPhai);

		jtable.getColumnModel().getColumn(3).setCellEditor(cellEditor);
		jtable.setRowHeight(20);
		JScrollPane pane = new JScrollPane(jtable);
		pCen.add(pane);
		pane.setBounds(10, 160, 550, 200);

		add(pCen, BorderLayout.CENTER);
		pCen.setLayout(null);
		// kết thúc pCen

		// trái
		JPanel pleft = new JPanel();
		pleft.add(lblTimkiem = new JLabel("Nhập mã nv:"));
		pleft.add(txtTiemkiem = new JTextField(8));
		pleft.add(btnTiemkiem = new JButton("Tìm"));

		// phải
		JPanel pRight = new JPanel();
		pRight.add(btnThem = new JButton("Thêm"));
		pRight.add(btnXoatrang = new JButton("Xóa trắng"));
		pRight.add(btnXoa = new JButton("Xóa"));
		pRight.add(btnLuu = new JButton("Lưu"));

		// south
		JSplitPane psouth = new JSplitPane(SwingConstants.VERTICAL, pleft, pRight);
		add(psouth, BorderLayout.SOUTH);

		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);
		btnTiemkiem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoatrang.addActionListener(this);
		// jtable.addMouseListener(new MouseListener() {

	}

	public ThongTinNhanVien() {
		setTitle("Thông tin nhân viên");
		// setFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addControll();
		setSize(600, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ThongTinNhanVien();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();// khao báo
		
		if (obj.equals(btnXoatrang)) {
			txtHo.setText("");
			txtManv.setText("");
			txtTen.setText("");
			txtTienluong.setText("");
			txtTuoi.setText("");
			radPhai.setSelected(false);

		} else if (obj.equals(btnThem)) {

			// get dữ liệu
			int manv = Integer.parseInt(txtManv.getText().trim()); //mã 
			String ho = txtHo.getText().trim();
			String ten = txtTen.getText().trim();
			// nếu phái check là nữ, không check là nam
			String phai;
			if (radPhai.isSelected()) { // nếu ch�?n
				phai = "Nu";
			} else {
				phai = "Nam";
			}

			int tuoi =  Integer.parseInt(txtTuoi.getText().trim()); // chuyển kiểu dl
			// nếu phái check là nữ, không check là nam
			float tienluong = Float.parseFloat(txtTienluong.getText().trim());

			defaultTableModel.addRow(new Object[] {
					manv,ho,ten,phai,tuoi,tienluong+"$"
			});
			
			
			
			
//			// tạo đối tượng nhân viên 
//			Nhanvien nvtemp = new Nhanvien(manv, ho, ten, phai, tuoi, tienluong);
//			if (!ds.themNV(nvtemp)) {
//				JOptionPane.showMessageDialog(null, "Mã nhân viên này có rồi nhé.");
//			} else {
//				defaultTableModel.addRow(new Object[] { nvtemp.getManv(), nvtemp.getHo(), nvtemp.getTen(), phai,
//						nvtemp.getTuoi(), nvtemp.getTienluong() });
//			}

		}
		else if (obj.equals(btnXoa)) {	
			if(jtable.getSelectedRow() != -1) {
				
				  // remove selected row from the model
				int index = jtable.getSelectedRow();// lấy dòng đã ch�?n
				
               defaultTableModel.removeRow(index);// xóa
               
               
	            }
			else {
				JOptionPane.showMessageDialog(null, "Ch�?n 1 dòng để xóa.");
			}
			
		}
		else if (obj.equals(btnTiemkiem)) {
			
			
			
			
		}

	}

}
