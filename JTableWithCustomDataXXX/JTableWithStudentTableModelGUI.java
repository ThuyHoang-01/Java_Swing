package sesion05.JTableWithCustomDataXXX;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableWithStudentTableModelGUI extends JFrame implements
		ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private JTable studentTable;
	private StudentTableModel studentModel;

	private StudentCollection collection = new StudentCollection();

	JButton b1, b2, b3;

	public JTableWithStudentTableModelGUI() {

		JPanel p = new JPanel();

		p.add(b1 = new JButton("Thêm"));
		p.add(b3 = new JButton("Xóa"));
		p.add(b2 = new JButton("Đóng"));
		add(p, BorderLayout.SOUTH);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		LuuTru l = new LuuTru();
		try {
			collection = (StudentCollection) l
					.deserialObject("data/SaveCustomTable.dat");
		} catch (Exception e) {
			e.printStackTrace();
		}

		studentModel = new StudentTableModel(collection);
		studentTable = new JTable(studentModel);
		add(new JScrollPane(studentTable));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(400, 200);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(b1)) {
			String ma = JOptionPane.showInputDialog("Nhập mã: ");
			String ten = JOptionPane.showInputDialog("Nhập tên: ");
			String phai = JOptionPane.showInputDialog("Nhập phái: ");
			String lop = JOptionPane.showInputDialog("Nhập lớp: ");
			Student t = new Student(ma, ten, Boolean.parseBoolean(phai), lop);
			if (!collection.addStudent(t))
				JOptionPane.showMessageDialog(this, "Trùng");
			studentTable.revalidate();
		}
		if (arg0.getSource().equals(b2)) {
			LuuTru l = new LuuTru();
			try {
				l.serialObject(collection, "data/SaveCustomTable.dat");
				// System.out.println("Thành công");
				System.exit(0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (arg0.getSource().equals(b3)) {
			int r = studentTable.getSelectedRow();
			collection.removeStudent(r);
			studentTable.revalidate();
		}
	}

	public static void main(String[] args) {
		new JTableWithStudentTableModelGUI();
	}
}
