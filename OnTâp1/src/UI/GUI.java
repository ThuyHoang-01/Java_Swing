package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.DanhSachNhanVien;
import entity.NhanVien;

public class GUI extends JFrame implements ActionListener {
	//Ui -> entity -> xoa trang -> them -> danh sach -> 10d keke
	JLabel lbMaNV, lbHoNV, lbTenNV,lbHeader;
	JTextField txtMaNV, txtHoNV, txtTenNV;
	JButton btnXoa, btnThem, btnXoaTrang, btnLuu, btnTimKiem;
	JComboBox comboBox;
	JPanel pnCenTer, pnBottom, pnBorder, pnTop;
	DefaultTableModel dfModel;
	JTable bangJTable;
	private JTextField txtTimKiem;

	// private DanhSachNhanVien ds = new DanhSachNhanVien();
	public GUI() {
		setTitle("Quan Ly");
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		giaoDien();
	}

	public void giaoDien() {

		pnBorder = new JPanel(new BorderLayout());
		pnCenTer = new JPanel();
		pnTop = new JPanel();
		add(pnBorder);
		lbHeader = new JLabel("Thong Tin Nhan Vien");
		lbHeader.setForeground(Color.BLUE);
		Font font = new Font("Arial", Font.BOLD, 25);
		lbHeader.setFont(font);
		pnTop.add(lbHeader);

		pnBorder.add(pnTop, BorderLayout.NORTH);
		// top

		pnTop.setLayout((LayoutManager) new BoxLayout(pnTop, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();

		b.add(b1);
		b.add(Box.createVerticalStrut(7));
		b.add(b2);
		b.add(Box.createVerticalStrut(7));
		b.add(b3);
		b.add(Box.createVerticalStrut(7));
		b.add(b4);
		b.add(Box.createVerticalStrut(7));
		b.add(b5);
		b.add(Box.createVerticalStrut(7));

		pnTop.add(b);
		pnTop.add(Box.createVerticalStrut(5));

		lbMaNV = new JLabel("Ma Nhan Vien: ");
		lbHoNV = new JLabel("Ho Nhan Vien: ");
		lbTenNV = new JLabel("Ten Nhan Vien: ");

		txtMaNV = new JTextField();
		b1.add(lbMaNV);
		b1.add(txtMaNV);
		lbMaNV.setPreferredSize(lbTenNV.getPreferredSize());

		txtHoNV = new JTextField();
		b2.add(lbHoNV);
		b2.add(txtHoNV);
		lbHoNV.setPreferredSize(lbTenNV.getPreferredSize());

		txtTenNV = new JTextField();
		b3.add(lbTenNV);
		b3.add(txtTenNV);
		lbTenNV.setPreferredSize(lbTenNV.getPreferredSize());

		createTable();

		pnBorder.add(pnCenTer, BorderLayout.CENTER);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		pnBorder.add(splitPane, BorderLayout.SOUTH);
		splitPane.setResizeWeight(0.5);

		JPanel pnChucNang = new JPanel();
		btnLuu = new JButton("Luu");
		btnXoa = new JButton("Xoa");
		btnThem = new JButton("Them");
		btnXoaTrang = new JButton("Cap nhat");
		pnChucNang.add(btnXoa);
		pnChucNang.add(btnLuu);
		pnChucNang.add(btnThem);
		pnChucNang.add(btnXoaTrang);

		splitPane.add(pnChucNang);

		JPanel pnTimKiem = new JPanel();
		JLabel lbTimKiem = new JLabel("Tim Kiem Nhan Vien");
		txtTimKiem = new JTextField(10);
		btnTimKiem = new JButton("Tim Kiem");
		pnTimKiem.add(lbTimKiem);
		pnTimKiem.add(txtTimKiem);
		pnTimKiem.add(btnTimKiem);
		splitPane.add(pnTimKiem);

		btnTimKiem.addActionListener((ActionListener) this);
		btnXoa.addActionListener((ActionListener) this);
		btnLuu.addActionListener((ActionListener) this);
		btnThem.addActionListener((ActionListener) this);
		btnXoaTrang.addActionListener((ActionListener) this);

	}

	public void createTable() {
		dfModel = new DefaultTableModel();
		bangJTable = new JTable(dfModel);
		dfModel.addColumn("MaNV");
		dfModel.addColumn("HoNV");
		dfModel.addColumn("TenNV");
		TableColumn column = new TableColumn();
		column.setPreferredWidth(100);
		DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
		rightRender.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		JScrollPane sp = new JScrollPane(bangJTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(750, 250));
		pnCenTer.add(sp);

	}
	// được r á

	public static void main(String[] args) {
		new GUI().setVisible(true);
	}

	private double Double(String tienLuong) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int Tim() {
		// duyệt hết cái bảng
		for (int i = 0; i < dfModel.getRowCount(); i++) {
			if (txtTimKiem.getText().equals(dfModel.getValueAt(i, 0))) {
				// trả về vị trí nếu tìm thấy
				return i;
			}
		} // nếu không tìm thấy .
		return -1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		// tao dôi tương
		Object object = e.getSource();
		if (object.equals(btnXoaTrang)) {
			txtHoNV.setText("");
			txtMaNV.setText(""); 
			txtTenNV.setText("");
		} else if (object.equals(btnThem)) {
		if (txtMaNV.getText().equals("") || txtHoNV.getText().equals("")||  txtTenNV.getText().equals("")) {
				JOptionPane.showMessageDialog(null, " Bạn chưa nhập dữ liệu");
			} else {
				int Ma = Integer.parseInt(txtMaNV.getText());// Lấy dữ liệu trong ô gán vào cho biến -> đối tượng -> ktra ds
				String Ho = (txtHoNV.getText());
				String Ten = (txtTenNV.getText());			
				// Truyền dl vào trong dòng -> sau đó truyền dòng vào bảng
				String row[] = { txtMaNV.getText(), Ho, Ten,  };
				NhanVien nhanVien = new NhanVien(Ma, Ho, Ten );
				if (new DanhSachNhanVien().addNV(nhanVien) == true) {
					dfModel.addRow(row);
					JOptionPane.showMessageDialog(null, " Bạn đã thêm thành công ");
				} else {
					JOptionPane.showMessageDialog(null, " Trùng id !!!");
				}
			}

		} else if (object.equals(btnTimKiem)) {

			bangJTable.clearSelection();
			if (Tim() == -1) {
				JOptionPane.showInternalMessageDialog(null, "Không tìm thấy nhân viên.");
			} else {
				JOptionPane.showInternalMessageDialog(null, "Đã tìm thấy nhân viên.");
				bangJTable.addRowSelectionInterval(Tim(), Tim());
			}

		}

		else if (object.equals(btnXoa)) {
			// kiểm tra cái bảng đã nhấn chọn chưa
			if (bangJTable.getSelectedRow() != -1) {

				int index = bangJTable.getSelectedRow(); // lấy ra vị trí cần xóa .
				int id = Integer.parseInt((String) dfModel.getValueAt(index, 0));// lấy ra cái id cần xóa.

				dfModel.removeRow(index); // xóa dòng trong bảng

				if (new DanhSachNhanVien().xoaNV(id)) // xóa dòng trong danh sách
					JOptionPane.showMessageDialog(null, "Xóa không thành công ");
				else {
					JOptionPane.showMessageDialog(null, " Xóa không thành công");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Chọn 1 dòng để xóa");
			}
		} else if (object.equals(btnLuu)) {
			String link = "output.txt";

			File file = new File(link);
			OutputStream outputStream;

			try {
				outputStream = new FileOutputStream(file);
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

				for (NhanVien nv : new DanhSachNhanVien().getDS()) {
					outputStreamWriter.write(nv.toString());
					// Dùng để xuống hàng
					outputStreamWriter.write("\n");
				}

				// đóng file
				outputStreamWriter.flush();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}// thôi bỏ đi
	

}
