package quanLymuabanXe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NhanVienKyThuat extends JFrame implements ActionListener, MouseListener {
	private JLabel lblTitle, lblTenNV, lblChucVu, lblBacTho, lblSoNamKinhNghiem;
	private JTextField txtTenNV, txtChucVu, txtBacTho, txtSoNamKinhNghiem;
	private DefaultTableModel dtmNVKT;
	private JTable tableNVKT;

	public NhanVienKyThuat() {
		super ("Nhân Viên kĩ Thuật");
		setSize(900, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setNVKTLayout();
	}

	private void setNVKTLayout() {
		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);
		pnNorth.add(lblTitle = new JLabel("Nhân Viên Kỹ thuật"));
		pnNorth.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnNorth.setForeground(Color.BLUE);

		Box b = Box.createVerticalBox();
		Box b1, b2, b3, b4, b5;

		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblTenNV = new JLabel("Mã Nhân Viên: "));
		b1.add(txtTenNV = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblChucVu = new JLabel("Tên Nhân Viên: "));
		b2.add(txtChucVu = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblChucVu = new JLabel("Chức vụ: "));
		b3.add(txtChucVu = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblBacTho = new JLabel("Bậc thợ: "));
		b3.add(txtBacTho = new JTextField());

		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblSoNamKinhNghiem = new JLabel("Số năm kinh nghiệm: "));
		b4.add(txtSoNamKinhNghiem = new JTextField());
		
		lblTenNV.setPreferredSize(lblSoNamKinhNghiem.getPreferredSize());
		lblChucVu.setPreferredSize(lblSoNamKinhNghiem.getPreferredSize());
		lblBacTho.setPreferredSize(lblSoNamKinhNghiem.getPreferredSize());
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		String[] headers = "Mã Nhân Viên,Tên Nhân Viên,Chức vụ,Bậc thợ,Số năm kinh nghiệm".split(",");
		dtmNVKT = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tableNVKT = new JTable(dtmNVKT));
		tableNVKT.setRowHeight(25);
		tableNVKT.setAutoCreateRowSorter(true);
		tableNVKT.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		b5.add(scroll);
		add(b, BorderLayout.CENTER);

		JPanel pnSouth = new JPanel();
		add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setBackground(Color.BLUE);

	}
public static void main(String[] args) {
	new NhanVienKyThuat().setVisible(true);;
}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}
