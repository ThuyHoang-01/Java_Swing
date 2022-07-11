package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
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

import dao.DSSV;
import database.Database;
import entity.SinhVien;

public class DanhSachFrm extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JLabel	lbTitle;
	private JButton btnTim, btnThem, btnCapNhat, btnXoa;
	private DefaultTableModel tableModel;
	private DSSV dao;
	private List<SinhVien> dssv;
	//
	private String maSV = "", ho = "", ten = "", gender = "", birth = "", queQuan = "";
	private SinhVien sv, svk, svu;
	//
	private Container ctn;
	private JPanel pnNorth, pnlSouth;
	private JScrollPane scroll;
	//
	private JButton btnUpdate, btnQuayLai;
	private JLabel lbTB, lbMaSV, lbHo, lbTen, lbGender, lbBirth, lbQueQuan;
	private JTextField txtMaSV, txtHo, txtTen, txtBirth, txtQueQuan;
	private JComboBox<String> cmbGender;
	//
	Menu main, subSV, subNT, subDC;
	MenuBar menuBar;
	MenuItem menuMain, menuDSSV, menuTimSV, menuThemSV, menuXoaSV, menuDSNT, menuTimNT, menuThemDC, menuUDDC, menuThue, menuUpdateDC;
	public DanhSachFrm() {
		Database.getInstance().connect();
		dao = new DSSV();
		setSize(900, 600);
		setVisible(true);
		setTitle("DANH SÁCH SINH VIÊN");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ctn = getContentPane();
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
		pnNorth = new JPanel();
		lbTitle = new JLabel("Danh sách sinh viên");
		Font ft = new Font("arial", Font.BOLD, 25);
		lbTitle.setForeground(Color.magenta);
		lbTitle.setFont(ft);
		ctn.add(pnNorth, BorderLayout.NORTH);
		pnNorth.add(lbTitle);
		//
		
		pnlSouth = new JPanel();
		btnTim = new JButton("Tìm sinh viên");
		btnTim.setPreferredSize(new Dimension(150, 25));
		btnTim.setIcon(new ImageIcon("images/TIM.PNG"));
		btnThem = new JButton("Thêm sinh viên");
		btnThem.setIcon(new ImageIcon("images/THEM.PNG"));
		btnThem.setPreferredSize(new Dimension(150, 25));
		btnXoa = new JButton("Xóa sinh viên");
		btnXoa.setIcon(new ImageIcon("images/XOA.PNG"));
		btnXoa.setPreferredSize(new Dimension(150, 25));
		btnCapNhat = new JButton("Cập nhật sinh viên");
		btnCapNhat.setPreferredSize(new Dimension(170, 25));
		btnCapNhat.setIcon(new ImageIcon("images/SUA.PNG"));
		pnlSouth.add(btnTim);
		pnlSouth.add(btnThem);
		pnlSouth.add(btnXoa);
		pnlSouth.add(btnCapNhat);
		btnXoa.setEnabled(false);
		btnCapNhat.setEnabled(false);
		ctn.add(pnlSouth, BorderLayout.CENTER);
	
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnCapNhat.addActionListener(this);
		//
		String headers[] = {"Mã số sinh viên", "Họ", "Tên", "Giới tính", "Ngày sinh", "Quê quán"};
		tableModel = new DefaultTableModel(headers, 0);
		table = new JTable(tableModel);
		
		scroll = new JScrollPane(table, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ctn.add(scroll, BorderLayout.SOUTH);
		scroll.setPreferredSize(new Dimension(0, 240));
		docvaotable();
		
		//
		//
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnTim.setEnabled(false);
				btnThem.setEnabled(false);
				btnXoa.setEnabled(true);
				btnCapNhat.setEnabled(true);
				//
				docSV();
		
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void docvaotable() {
		List<SinhVien> dssv = dao.readDB();
		for(SinhVien sv : dssv) {
			tableModel.addRow(new Object[] {sv.getMaSV(), sv.getHoSV(), sv.getTenSV(), sv.getGender(), sv.getBirth(), sv.getQueQuan()});
		}
	}		

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTim)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new TimSVFrm());
		} else if (o.equals(btnThem)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new ThemSVFrm());
		} else if (o.equals(btnXoa)) {
			dao.delete(maSV);
			setVisible(false);
			SwingUtilities.invokeLater(() -> new DanhSachFrm());
		} else if (o.equals(btnCapNhat)) {
			lbTitle.setVisible(false);
			pnNorth.setVisible(false);
			pnlSouth.setVisible(false);
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
			lbTB = new JLabel("Cập nhật sinh viên:");
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
			btnQuayLai = new JButton("Quay lại");
			btnQuayLai.setPreferredSize(new Dimension(150, 20));
			btnQuayLai.setMargin(new Insets(0, 15, 0, 15));
			btnQuayLai.setIcon(new ImageIcon("images/BACK.PNG"));
			pn.add(btnQuayLai);
			btnUpdate = new JButton("Cập nhật");
			btnUpdate.setPreferredSize(new Dimension(150, 20));
			btnUpdate.setMargin(new Insets(0, 15, 0, 15));
			btnUpdate.setIcon(new ImageIcon("images/UPD.PNG"));
			pn.add(btnUpdate);
			ctn.add(b, BorderLayout.NORTH);
			ctn.add(scroll, BorderLayout.CENTER);
			docvaoTextF();
			txtMaSV.setEditable(false);
			
			btnQuayLai.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					SwingUtilities.invokeLater(() -> new DanhSachFrm());
					
				}
			});
			btnUpdate.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					docTextF();
					dao.update(svu.getMaSV(), svu.getHoSV(), svu.getTenSV(), svu.getGender(), svu.getBirth(), svu.getQueQuan());
					setVisible(false);
					SwingUtilities.invokeLater(() -> new DanhSachFrm());
				}
			});
		}
		
	}
	//Đọc từ TextField vào Sinh Vien
	public void docTextF (){
		maSV = txtMaSV.getText();
		ho = txtHo.getText();
		ten = txtTen.getText();
		gender = cmbGender.getSelectedItem().toString();
		birth = txtBirth.getText();
		queQuan = txtQueQuan.getText();
		svu = new SinhVien(maSV, ho, ten, queQuan, birth, gender);
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
	//Đọc từ table vào TextField gán cho Sinh viên sv
	public void docSV() {
		int row = table.getSelectedRow();
		JTextField txtMaSV, txtHo, txtTen, txtGender, txtBirth, txtQueQuan;
		txtMaSV = new JTextField();
		txtHo = new JTextField();
		txtTen = new JTextField();
		txtGender = new JTextField();
		txtBirth = new JTextField();
		txtQueQuan = new JTextField();
		txtMaSV.setText((String)table.getValueAt(row, 0));
		txtHo.setText((String)table.getValueAt(row, 1));
		txtTen.setText((String)table.getValueAt(row, 2));
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
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new DanhSachFrm());
	}
}

