package GD;
import java.awt.BorderLayout;
import QuanLy.DSDV;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import Class.DichVu;
	public class GD_DichVu extends JFrame implements ActionListener,MouseListener{
		private JLabel lblDichVu, lblDonGia,lblSoLuong,lblTongTienDV;
		private  JTextField txtDichVu,txtDonGia,txtSoLuong,txtTTDV,txtMess;
		private JButton btnThem, btnXoa, btnXoaRong,btnSua, btnThoat, btnLuu, btnMenu;
		public static DefaultTableModel tableModel;
		private JTable table;
		
		public GD_DichVu() {
			setTitle("Quản lý khách sạn");
			setSize(700, 600);
			setLocationRelativeTo(null);
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			 JPanel pNorth;
				add(pNorth = new JPanel(), BorderLayout.NORTH);
				pNorth.setPreferredSize(new Dimension(0, 160));
				pNorth.setBorder(BorderFactory.createTitledBorder("Form Dịch Vụ"));
				pNorth.setLayout(null);

				pNorth.add(lblDichVu = new JLabel("Dịch Vụ"));
				pNorth.add(lblDonGia = new JLabel("Đơn giá"));
				pNorth.add(lblSoLuong = new JLabel("Số lượng"));
				pNorth.add(txtDichVu = new JTextField());
				pNorth.add(txtDonGia = new JTextField());
				pNorth.add(txtSoLuong= new JTextField());
			
			
				

				pNorth.add(txtMess = new JTextField());
				txtMess.setEditable(false);
				txtMess.setBorder(null);
				txtMess.setForeground(Color.RED);
				txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

				int w1 = 200, w2 = 300, h = 20;
				lblDichVu.setBounds(20, 20, w1, 20);
				txtDichVu.setBounds(220, 20, w2, h);
				
				lblSoLuong.setBounds(20, 45, w1, h);
				txtSoLuong.setBounds(220, 45, w2, h);

				lblDonGia.setBounds(20, 70, w1, h);
				txtDonGia.setBounds(220, 70, w2, h);			
		
				txtMess.setBounds(20, 145, 550, 20);

				JPanel pCen;
				add(pCen = new JPanel(), BorderLayout.CENTER);
				pCen.add(btnThem = new JButton("Thêm"));
				pCen.add(btnXoaRong = new JButton("Xóa rổng"));
				pCen.add(btnLuu = new JButton("Lưu"));
				pCen.add(btnMenu = new JButton("Về menu"));
				JScrollPane scroll;
				String[] headers = "Dịch Vụ;Số lượng;Đơn giá".split(";");
				tableModel = new DefaultTableModel(headers, 0);
				add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
				scroll.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
				table.setRowHeight(20);
				scroll.setPreferredSize(new Dimension(0, 350));
				btnMenu.addActionListener(this);
				btnThem.addActionListener(this);

		}

		private void showMessage(String message, JTextField txt) {
			txt.requestFocus();
			txtMess.setText(message);
		}

		String dichVu,sL,dG,TTDV;
		int soLuong;
		double donGia,tTDichVu;

		private DichVu revertSachFromTextFields() {
			dichVu = txtDichVu.getText().trim();
			sL = txtSoLuong.getText().trim();
			soLuong = sL.length() == 0 ? 0 : Integer.parseInt(sL);
			dG = txtDonGia.getText().trim();
			donGia = dG.equals("") ? 0 : Double.parseDouble(dG);
			
			return new DichVu( dichVu,soLuong,donGia);
		}

		private void fillForm(int row) {
			if (row != -1) {
				String dichVu = (String) table.getValueAt(row, 0);
				DichVu s = new DichVu(dichVu);
				ArrayList<DichVu> dsSach = DSDV.getDsSach();
				if (DSDV.getDsSach().contains(s)) {
					s = dsSach.get(dsSach.indexOf(s));
					txtDichVu.setText(s.getdVu());
					txtSoLuong.setText(s.getsLuong()+"");
					txtDonGia.setText(s.getdGia()+"");
					txtDichVu.setEditable(false);
				}
			}
		}

		
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int row = table.getSelectedRow();
			fillForm(row);
		}
		
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o.equals(btnThem)) {
				DichVu s = revertSachFromTextFields();
				String[] row = { dichVu,Integer.toString(soLuong),
						Double.toString(donGia) ,Double.toString(tTDichVu)+"\n" };
				if (DSDV.themSach(s)) {
					tableModel.addRow(row);
					txtMess.setText("Them thanh cong mot cuon sach");
				} else {
					showMessage("Error: Trung ma sach", txtDichVu);
				}
			
		}
		


			if(e.getSource().equals(btnMenu)) {
				new Menu().setVisible(true);
			this.setVisible(false);
			}
		}
		public static void main(final String[] args) {
			final GD_DichVu frm = new GD_DichVu();
			frm.setVisible(true);
		
	}
	}

