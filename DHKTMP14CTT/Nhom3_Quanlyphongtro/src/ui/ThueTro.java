package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
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

import dao.DSNT;
import dao.DSSV;
import database.Database;
import entity.NhaTro;
import entity.SinhVien;

public class ThueTro extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JLabel	lbChon;
	private JButton btnChon, btnChonNT;
	private DefaultTableModel tableModel;
	private DSSV dao;
	private DSNT dsnt;
	private ArrayList<NhaTro> lsnt;
	private List<SinhVien> dssv;
	private SinhVien sv;
	private NhaTro nt;
	//
	private JLabel lbChonSV, lbChonTro, lbTB, lbMaSV, lbHo, lbTen, lbGender, lbBirth, lbQueQuan;
	private JTextField txtMaSV, txtHo, txtTen, txtBirth, txtQueQuan;
	private JComboBox<String> cmbGender, cmbSinhVien, cmbMSSV, cmbTro, cmbPhong, cmbTenTro;
	//
	private JLabel lbTenNT, lbChuTro, lbSdt, lbPhongTrong;
	private JTextField txtTenNT, txtChuTro, txtSdt;
	//
	Menu main, subSV, subNT, subDC;
	MenuBar menuBar;
	MenuItem menuMain, menuDSSV, menuTimSV, menuThemSV, menuXoaSV, menuDSNT, menuTimNT, menuThemDC, menuUDDC, menuThue, menuUpdateDC;
	//
	private Container ctn;
	private JPanel pnNorth, pnlSouth;
	private JScrollPane scroll;
	private JButton btnThue;
	public ThueTro() {
		Database.getInstance().connect();
		dao = new DSSV();
		dsnt = new DSNT();
		setSize(900, 400);
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
        
        Box b = Box.createVerticalBox();
		Box b0 = Box.createHorizontalBox();
		Box bb = Box.createHorizontalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		Box b6 = Box.createHorizontalBox();
		b.add(b0);
		b.add(Box.createVerticalStrut(5));
		b.add(bb);
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
		lbTB = new JLabel("Thuê trọ:");
		lbChon = new JLabel("Chọn sinh viên");
		lbMaSV = new JLabel("Mã sinh viên:");
		lbHo = new JLabel("Họ:");
		lbTen = new JLabel("Tên sinh viên:");
		lbGender = new JLabel("Giới tính:");
		lbBirth = new JLabel("Ngày sinh:");
		lbQueQuan = new JLabel("Quê quán:");
		lbMaSV.setPreferredSize(lbChon.getPreferredSize());
		lbHo.setPreferredSize(lbChon.getPreferredSize());
		lbTen.setPreferredSize(lbChon.getPreferredSize());
		lbGender.setPreferredSize(lbChon.getPreferredSize());
		lbBirth.setPreferredSize(lbChon.getPreferredSize());
		lbQueQuan.setPreferredSize(lbChon.getPreferredSize());
		
		b0.add(lbTB);
		btnChon = new JButton("Chọn");
		dssv = dao.readDB();
		cmbSinhVien = new JComboBox<String>();
		cmbMSSV = new JComboBox<String>();
		for (SinhVien sv : dssv) {
			cmbSinhVien.addItem(sv.getMaSV()+ " - " + sv.getHoSV() + " - " + sv.getTenSV()+ " - " + sv.getGender());
			cmbMSSV.addItem(sv.getMaSV());
		}
		bb.add(lbChon);
		bb.add(cmbSinhVien);
		bb.add(btnChon);
		
		
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
		ctn.add(b, BorderLayout.NORTH);
		btnChon.addActionListener(this);
		
		//
		
		Box a = Box.createVerticalBox();
		Box aa = Box.createHorizontalBox();
		Box a1 = Box.createHorizontalBox();
		Box a2 = Box.createHorizontalBox();
		Box a3 = Box.createHorizontalBox();
		Box a4 = Box.createHorizontalBox();
		a.add(aa);
		a.add(Box.createVerticalStrut(5));
		a.add(a1);
		a.add(Box.createVerticalStrut(5));
		a.add(a2);
		a.add(Box.createVerticalStrut(5));
		a.add(a3);
		a.add(Box.createVerticalStrut(5));
		a.add(a4);
		a.add(Box.createVerticalStrut(5));
		//
		JLabel lbChonNT = new JLabel();
		aa.add(lbChonNT);
		lbChonNT = new JLabel("Chọn nhà trọ");
		btnChonNT = new JButton("Chọn");
		lsnt = dsnt.readDB();
		bb.add(lbChon);
		cmbTro = new JComboBox<String>();
		cmbTenTro = new JComboBox<String>();
		for (NhaTro nt : lsnt) {
			cmbTro.addItem(nt.getTenNT()+ " - " + nt.getChuTro() + " - " + nt.getSoDT()+ " - " + nt.getPhongTrong());
			cmbTenTro.addItem(nt.getTenNT());
		}
		aa.add(cmbTro);
		aa.add(btnChonNT);
		//
		lbTenNT = new JLabel("Tên nhà trọ: ");
		lbChuTro = new JLabel("Chủ trọ: ");
		lbSdt = new JLabel("Phone: ");
		lbPhongTrong = new JLabel("Số phòng trống");
		lbTenNT.setPreferredSize(lbPhongTrong.getPreferredSize());
        lbSdt.setPreferredSize(lbPhongTrong.getPreferredSize());
        lbChuTro.setPreferredSize(lbPhongTrong.getPreferredSize());
		
        txtTenNT = new JTextField();
		a1.add(lbTenNT);
		a1.add(txtTenNT);

		txtChuTro = new JTextField();
		a2.add(lbChuTro);
		a2.add(txtChuTro);

		txtSdt = new JTextField();
		a3.add(lbSdt);
		a3.add(txtSdt);
		
		cmbPhong = new JComboBox<String>();
		for (int i = 0; i < 30; i++) {
			String t = String.valueOf(i);
			cmbPhong.addItem(t);
		}
		a4.add(lbPhongTrong);
		a4.add(cmbPhong);
		ctn.add(a, BorderLayout.CENTER);
		btnThue = new JButton("Thuê");
		ctn.add(btnThue, BorderLayout.SOUTH);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnChon)) {
			String t= (String)cmbMSSV.getSelectedItem();
			sv = findSinhVien(t);
			docvaoTextF();
		} else if (o.equals(btnChonNT)) {
			String t= (String)cmbTenTro.getSelectedItem();
			nt = findNhaTro(t);
			docVaoTextTro();
		}
		
	}
	public NhaTro findNhaTro(String ms) {
		lsnt = dsnt.readDB();
		for (NhaTro nt : lsnt) {
			if (ms.equalsIgnoreCase(nt.getTenNT())) {
				return nt;
			}
		}
		return nt;
	}
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
	public void docVaoTextTro() {
		txtTenNT.setText(nt.getTenNT());
		txtChuTro.setText(nt.getChuTro());
		txtSdt.setText(nt.getSoDT());
		cmbPhong.addItem(String.valueOf(nt.getPhongTrong()));
	}
	public SinhVien findSinhVien (String ms) {
		dssv = dao.readDB();
		for (SinhVien sv : dssv) {
			if (ms.equalsIgnoreCase(sv.getMaSV())) {
				return sv;
			}
		}
		return sv;
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new ThueTro());
	}
}
