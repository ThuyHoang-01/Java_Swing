package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.Insets;
import dao.DSSV;
import database.Database;
import entity.SinhVien;

public class XoaSVFrm extends JFrame implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel tableModel;
	private DSSV dao;
	private List<SinhVien> dssv;
	
	private JButton btnXoa;
	private JLabel lbTB, lbMaSV, lbHo, lbTen, lbGender, lbBirth, lbQueQuan;
	private JTextField txtMaSV, txtHo, txtTen, txtGender, txtBirth, txtQueQuan;
	private JComboBox<String> cmbGender;
	//
	private SinhVien sv, s;
	private String maSV = "", ho = "", ten = "", gender = "", birth = "", queQuan = "";
	//
	Menu main, subSV, subNT, subDC;
	MenuBar menuBar;
	MenuItem menuMain, menuDSSV, menuTimSV, menuThemSV, menuXoaSV, menuDSNT, menuTimNT, menuThemDC, menuUDDC, menuThue, menuUpdateDC;
	public XoaSVFrm (){
		Database.getInstance().connect();
		dao = new DSSV();
		setSize(900, 600);
		setVisible(true);
		setTitle("XÓA SINH VIÊN");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		menuBar = new MenuBar();
		main = new Menu("Menu");
        subSV = new Menu("Tác vụ với sinh viên");
        subNT = new Menu("Tác vụ với nhà trọ");
        subDC = new Menu("Tác vụ khác");
        menuMain = new MenuItem("Quay lại MENU");
        menuDSSV = new MenuItem("Danh sách sinh viên");
        menuTimSV = new MenuItem("Tìm sinh viên");
        menuThemSV = new MenuItem("Thêm sinh viên");
        menuXoaSV = new MenuItem("Xóa sinh viên");
        menuDSNT = new MenuItem("Danh sách nhà trọ");
        menuTimNT = new MenuItem("Tìm nhà trọ");
        menuThemDC = new MenuItem("Thêm địa chỉ nhà trọ");
        menuUDDC = new MenuItem("Cập nhật địa chỉ nhà trọ");
        menuThue = new MenuItem("Thuê trọ");
        menuUpdateDC = new MenuItem("Cập nhật địa chỉ nhà trọ của sinh viên");
        menuBar.add(main);
        menuBar.add(subSV);
        menuBar.add(subNT);
        menuBar.add(subDC);
        main.add(menuMain);
        subSV.add(menuDSSV);
        subSV.add(menuTimSV);
        subSV.add(menuThemSV);
        subSV.add(menuXoaSV);
        subNT.add(menuDSNT);
        subNT.add(menuTimNT);
        subNT.add(menuThemDC);
        subNT.add(menuUDDC);
        subDC.add(menuThue);
        subDC.add(menuUpdateDC);
        Font fnt = new Font("arial", Font.ITALIC, 12);
        menuBar.setFont(fnt);
        setMenuBar(menuBar);
        
        menuUpdateDC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        menuThue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==menuThue) {
					setVisible(false);
					SwingUtilities.invokeLater(() -> new ThueTro());
				}
			}
		});
        menuUDDC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==menuUDDC) {
					setVisible(false);
					SwingUtilities.invokeLater(() -> new UpdateNTroFrm());
				}
			}
		});
        menuThemDC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==menuThemDC) {
					setVisible(false);
					SwingUtilities.invokeLater(() -> new ThemNTFrm());
				}
			}
		});
        menuDSNT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==menuDSNT) {
					setVisible(false);
					SwingUtilities.invokeLater(() -> new DanhSachNhaTroFrm());
				}
			}
		});
        menuTimNT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==menuTimNT) {
					setVisible(false);
					SwingUtilities.invokeLater(() -> new TimNTFrm());
				}
				
			}
		});
        menuMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==menuMain) {
					setVisible(false);
					SwingUtilities.invokeLater(() -> {
						try {
							new MenuFrm();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					});
				}
			}
		});
        menuDSSV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==menuDSSV) {
					setVisible(false);
					SwingUtilities.invokeLater(() -> new DanhSachFrm());
				}	
				
			}
		});
        menuTimSV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==menuTimSV) {
					setVisible(false);
					SwingUtilities.invokeLater(() -> new TimSVFrm());
				}	
			}
		});
        menuThemSV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==menuThemSV) {
					setVisible(false);
					SwingUtilities.invokeLater(() -> new ThemSVFrm());
				}	
			}
		});
        menuXoaSV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==menuXoaSV) {
					setVisible(false);
					SwingUtilities.invokeLater(() -> new XoaSVFrm());
				}
			}
		});
        //
        
        Container ctn = getContentPane();
		//NORTH
		Box b = Box.createVerticalBox();
		Box b0 = Box.createHorizontalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		Box b6 = Box.createHorizontalBox();
		b.add(b0);
		b.add(Box.createVerticalStrut(5));
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		b.add(b5);
		b.add(Box.createVerticalStrut(5));
		lbTB = new JLabel("Xóa sinh viên có:");
		lbMaSV = new JLabel("Mã sinh viên:");
		lbHo = new JLabel("Họ:");
		lbTen = new JLabel("Tên sinh viên:");
		lbGender = new JLabel("Giới tính:");
		lbBirth = new JLabel("Ngày sinh:");
		lbQueQuan = new JLabel("Quê quán:");
		lbHo.setPreferredSize(lbMaSV.getPreferredSize());
		//lbTen.setPreferredSize(lbMaSV.getPreferredSize());
		lbGender.setPreferredSize(lbMaSV.getPreferredSize());
		lbBirth.setPreferredSize(lbMaSV.getPreferredSize());
		lbQueQuan.setPreferredSize(lbMaSV.getPreferredSize());
		
		b0.add(lbTB);
		
		txtMaSV = new JTextField();
		b1.add(lbMaSV);
		b1.add(txtMaSV);

		txtHo = new JTextField();
		txtTen = new JTextField();
		b2.add(lbHo);
		b2.add(txtHo);
		b2.add(lbTen);
		b2.add(txtTen);

		cmbGender = new JComboBox<String>();
		cmbGender.addItem("Nam");
		cmbGender.addItem("Nữ");
		cmbGender.setPreferredSize(new Dimension(100, 20));
		b3.add(lbGender);
		b3.add(cmbGender);
		txtBirth = new JTextField();
		b3.add(lbBirth);
		b3.add(txtBirth);
		
		txtQueQuan = new JTextField();
		b4.add(lbQueQuan);
		b4.add(txtQueQuan);
		
		JPanel pn = new JPanel();
		b.add(pn);
		btnXoa = new JButton("Xóa");
		btnXoa.setPreferredSize(new Dimension(100, 20));
		btnXoa.setMargin(new Insets(0, 15, 0, 15));
		btnXoa.setIcon(new ImageIcon("images/CLEAR.PNG"));
		pn.add(btnXoa);
		ctn.add(b, BorderLayout.NORTH);
		
		//
		JScrollPane scroll;
		String headers[] = {"Mã số sinh viên", "Họ", "Tên", "Giới tính", "Ngày sinh", "Quê quán"};
		tableModel = new DefaultTableModel(headers, 0);
		table = new JTable(tableModel);
		table.addMouseListener(this);
		scroll = new JScrollPane(table, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ctn.add(scroll, BorderLayout.CENTER);
		scroll.setPreferredSize(new Dimension(0, 240));
		docvaotable();
		
		btnXoa.addActionListener(this);
	}
	
	public void docvaotable() {
		List<SinhVien> dssv = dao.readDB();
		for(SinhVien sv : dssv) {
			tableModel.addRow(new Object[] {sv.getMaSV(), sv.getHoSV(), sv.getTenSV(), sv.getGender(), sv.getBirth(), sv.getQueQuan()});
		}
	}
	//Đọc từ table vào TextField
	public void docSV() {
		int row = table.getSelectedRow();
		txtMaSV.setText((String)table.getValueAt(row, 0));
		txtHo.setText((String)table.getValueAt(row, 1));
		txtTen.setText((String)table.getValueAt(row, 2));
		txtGender = new JTextField();
		txtGender.setText((String)table.getValueAt(row, 3));
		txtBirth.setText((String)table.getValueAt(row, 4));
		txtQueQuan.setText((String)table.getValueAt(row, 5));
		maSV = txtMaSV.getText();
		ho = txtHo.getText();
		ten = txtTen.getText();
		gender = txtGender.getText();
		birth = txtBirth.getText();
		queQuan = txtQueQuan.getText();
		sv = new SinhVien(maSV, ho, ten, queQuan, birth, gender);
	}
	//Đọc từ Sinh viên sv vào TextField
	public void docvaoTextF() {
		txtMaSV.setText(sv.getMaSV());
		txtHo.setText(sv.getHoSV());
		txtTen.setText(sv.getTenSV());
		if (sv.getGender().equals("Nam")) {
			cmbGender.setSelectedIndex(0);
		} else {
			cmbGender.setSelectedIndex(1);
		}
		txtBirth.setText(sv.getBirth());
		txtQueQuan.setText(sv.getQueQuan());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoa)) {
			checkText(txtMaSV, maSV);
			checkText(txtHo, ho);
			checkText(txtTen, ten);
			gender = cmbGender.getSelectedItem().toString();
			checkText(txtBirth, birth);
			checkText(txtQueQuan, queQuan);
			dao.deleteMoreInfor(maSV, ho, ten, gender, birth, queQuan);
			setVisible(false);
			SwingUtilities.invokeLater(() -> new XoaSVFrm());
		}
		
	}
	public void checkText(JTextField a, String b) {
		if (a.getText().equals("")) {
			b = "%";
		} else {
			b = a.getText();
		}
	}
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new XoaSVFrm());
	}*/

	@Override
	public void mouseClicked(MouseEvent e) {
		docSV();
		docvaoTextF();
		
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
