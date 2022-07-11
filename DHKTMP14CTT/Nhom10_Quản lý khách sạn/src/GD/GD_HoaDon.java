package GD;
import java.awt.BorderLayout;
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
import GD.GD_TraPhong;
import GD.GD_DichVu;	
public class GD_HoaDon extends JFrame implements ActionListener{
		private JLabel lblHoTen, lblSLphong,lbltgtra,lbldVu,lblLoaiPhong,lbltgden,lblDonGiaP,lblSLDV,lblDonGiaDV;
		private  JTextField txtHoTen, txtSLphong,txttgtra,txtdVu,txttgden,txtDonGiaP,txtSLDV,txtDonGiaDV,txtMess;
		private JComboBox cboLoaiPhong;
		private JButton btnThem, btnXoa, btnXoaRong,btnSua, btnThoat, btnLuu, btnMenu;
		public static DefaultTableModel tableModel;
		private JTable table;
		
		public GD_HoaDon() {
			setTitle("Quản lý khách sạn");
			setSize(1000, 700);
			setLocationRelativeTo(null);
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			 JPanel pNorth;
				add(pNorth = new JPanel(), BorderLayout.NORTH);
				pNorth.setPreferredSize(new Dimension(0, 250));
				pNorth.setBorder(BorderFactory.createTitledBorder("Form Dịch Vụ"));
				pNorth.setLayout(null);

				pNorth.add(lblHoTen = new JLabel("Họ tên"));
				pNorth.add(lblSLphong = new JLabel("Số lượng phòng"));
				pNorth.add(lblLoaiPhong = new JLabel("Loại Phòng"));
				pNorth.add(lbltgden = new JLabel("Ngày đến:"));
				pNorth.add(lbltgtra = new JLabel("Ngày đi: "));
				pNorth.add(lblDonGiaP = new JLabel("Đơn giá phòng:"));
				pNorth.add(lbldVu = new JLabel("Tên dịch vụ"));
				pNorth.add(lblSLDV = new JLabel("Số lượng dv từng loại"));
				pNorth.add(lblDonGiaDV = new JLabel("Đơn giá dịch vụ"));
				pNorth.add(txtHoTen = new JTextField());
				pNorth.add(txtSLphong = new JTextField());
				 DefaultComboBoxModel<String> select = new DefaultComboBoxModel();
				select.addElement("Thường đơn");
				select.addElement("Thường đôi");
				select.addElement("Vip đơn");
				select.addElement("Vip đôi");
				pNorth.add(cboLoaiPhong = new JComboBox(select));
				pNorth.add(txtDonGiaP = new JTextField());
				pNorth.add(txttgden = new JTextField());
				pNorth.add(txttgtra = new JTextField());
				pNorth.add(txtdVu = new JTextField());
				pNorth.add(txtSLDV= new JTextField());
				pNorth.add(txtDonGiaDV = new JTextField());
			
				

				pNorth.add(txtMess = new JTextField());
				txtMess.setEditable(false);
				txtMess.setBorder(null);
				txtMess.setForeground(Color.RED);
				txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

				int w1 = 200, w2 = 300, h = 20;
				lblHoTen.setBounds(20, 20, w1, 20);
				txtHoTen.setBounds(220, 20, w2, h);
				
				lblSLphong.setBounds(20, 45, w1, h);
				txtSLphong.setBounds(220, 45, w2, h);

				lblLoaiPhong.setBounds(20, 70, w1, h);
				cboLoaiPhong.setBounds(220, 70, w2, h);

				lbltgden.setBounds(20, 95, w1, h);
				txttgden.setBounds(220, 95, w2, h);

				lbltgtra.setBounds(20, 120, w1, h);
				txttgtra.setBounds(220, 120, w2, h);
				
				lblDonGiaP.setBounds(20, 145, w1, h);
				txtDonGiaP.setBounds(220, 145, w2, h);

				lbldVu.setBounds(20, 170, w1, h);
				txtdVu.setBounds(220, 170, w2, h);

				lblSLDV.setBounds(20, 195, w1, h);
				txtSLDV.setBounds(220, 195, w2, h);

				lblDonGiaDV.setBounds(20, 220, w1, h);
				txtDonGiaDV.setBounds(220, 220, w2, h);

				JPanel pCen;
				add(pCen = new JPanel(), BorderLayout.CENTER);
				pCen.add(btnThem = new JButton("Thêm"));
				pCen.add(btnXoaRong = new JButton("Xóa rổng"));
				pCen.add(btnLuu = new JButton("Lưu"));
				pCen.add(btnMenu = new JButton("Về menu"));
				JScrollPane scroll;
				String[] headers = "Họ tên;Số lượng Phòng;Loại Phòng  ;Đơn giá phòng;Tên dịch vụ;Số lượng;Đơn giá ;Tổng tiền phòng ;Tổng tiền dịch vụ ;Tổng tiền thanh toán".split(";");
				tableModel = new DefaultTableModel(headers, 0);
				add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
				scroll.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
				table.setRowHeight(20);
				scroll.setPreferredSize(new Dimension(0,350));
				btnMenu.addActionListener(this);

		}
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		

	
		 if(e.getSource().equals(btnMenu)) {
				new Menu().setVisible(true);
				this.setVisible(false);
			}
		}
		public static void main(final String[] args) {
			final GD_HoaDon frm = new GD_HoaDon();
			frm.setVisible(true);
		
	}
	}