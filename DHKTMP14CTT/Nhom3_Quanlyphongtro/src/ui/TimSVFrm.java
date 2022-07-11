package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
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

import dao.DSSV;
import database.Database;
import entity.SinhVien;

public class TimSVFrm extends JFrame implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel tableModel;
	private DSSV dao;
	private List<SinhVien> dssv = null;
	String old = "";
	JLabel lbTT;
	JComboBox cmbSelect;
	JButton btnTim, btnCapNhat, btnXoa;
	JTextField txtNhap;
	JPanel pn, pnlSouth;
	//
	Menu main, subSV, subNT, subDC;
	MenuBar menuBar;
	MenuItem menuMain, menuDSSV, menuTimSV, menuThemSV, menuXoaSV, menuDSNT, menuTimNT, menuThemDC, menuUDDC, menuThue, menuUpdateDC;
	String headers[] = {"Mã số sinh viên", "Họ", "Tên", "Giới tính", "Ngày sinh", "Quê quán", "Nhà trọ"};
	JScrollPane scroll;
	public TimSVFrm() {
		Database.getInstance().connect();
		dao = new DSSV();
		setSize(900, 600);
		setVisible(true);
		setTitle("TÌM KIẾM SINH VIÊN");
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
		JPanel pn = new JPanel();
		lbTT = new JLabel("Tìm theo:");
		cmbSelect = new JComboBox<String>();
		cmbSelect.addItem("Mã số sinh viên");
		cmbSelect.addItem("Họ");
		cmbSelect.addItem("Tên");
		cmbSelect.addItem("Giới tính");
		cmbSelect.addItem("Ngày sinh");
		cmbSelect.addItem("Quê Quán");
		cmbSelect.addItem("Địa chỉ nhà trọ");
		txtNhap = new JTextField();
		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon("images/TIM.PNG"));
		pn.add(lbTT);
		pn.add(cmbSelect);
		pn.add(txtNhap);
		txtNhap.setPreferredSize(new Dimension(300, 25));
		pn.add(btnTim);
		pn.setLayout(new FlowLayout());
		ctn.add(pn, BorderLayout.NORTH);
		
		//
		
		tableModel = new DefaultTableModel(headers, 0);
		table = new JTable(tableModel);
		table.addMouseListener(this);
		scroll = new JScrollPane(table, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ctn.add(scroll, BorderLayout.CENTER);
		scroll.setPreferredSize(new Dimension(0, 240));
		table.addMouseListener(this);
		btnTim.addActionListener(this);
		//South
		pnlSouth = new JPanel();
		btnXoa = new JButton("Xóa sinh viên");
		btnXoa.setPreferredSize(new Dimension(150, 25));
		btnXoa.setIcon(new ImageIcon("images/CLEAR.PNG"));
		btnCapNhat = new JButton("Cập nhật sinh viên");
		btnCapNhat.setPreferredSize(new Dimension(150, 25));
		btnCapNhat.setIcon(new ImageIcon("images/UPD.PNG"));
		pnlSouth.add(btnXoa);
		pnlSouth.add(btnCapNhat);
		ctn.add(pnlSouth, BorderLayout.SOUTH);
		
		btnXoa.addActionListener(this);
		btnCapNhat.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTim)) {
			if (cmbSelect.getSelectedIndex()==0) {
				String nhap = txtNhap.getText();
				try {
					dssv = dao.findMSSV(nhap);
					for(SinhVien sv : dssv) {
						tableModel.addRow(new Object[] {sv.getMaSV(), sv.getHoSV(), sv.getTenSV(), sv.getGender(), sv.getBirth(), sv.getQueQuan()});
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if (cmbSelect.getSelectedIndex()==1) {
				String nhap = txtNhap.getText();
				try {
					dssv = dao.findHo(nhap);
					for(SinhVien sv : dssv) {
						tableModel.addRow(new Object[] {sv.getMaSV(), sv.getHoSV(), sv.getTenSV(), sv.getGender(), sv.getBirth(), sv.getQueQuan()});
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if (cmbSelect.getSelectedIndex()==2) {
				String nhap = txtNhap.getText();
				try {
					dssv = dao.findTen(nhap);
					for(SinhVien sv : dssv) {
						tableModel.addRow(new Object[] {sv.getMaSV(), sv.getHoSV(), sv.getTenSV(), sv.getGender(), sv.getBirth(), sv.getQueQuan()});
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if (cmbSelect.getSelectedIndex()==3) {
				String nhap = txtNhap.getText();
				try {
					dssv = dao.findGender(nhap);
					for(SinhVien sv : dssv) {
						tableModel.addRow(new Object[] {sv.getMaSV(), sv.getHoSV(), sv.getTenSV(), sv.getGender(), sv.getBirth(), sv.getQueQuan()});
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if (cmbSelect.getSelectedIndex()==4) {
				String nhap = txtNhap.getText();
				try {
					dssv = dao.findBirth(nhap);
					for(SinhVien sv : dssv) {
						tableModel.addRow(new Object[] {sv.getMaSV(), sv.getHoSV(), sv.getTenSV(), sv.getGender(), sv.getBirth(), sv.getQueQuan()});
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if (cmbSelect.getSelectedIndex()==5) {
				String nhap = txtNhap.getText();
				try {
					dssv = dao.findQue(nhap);
					for(SinhVien sv : dssv) {
						tableModel.addRow(new Object[] {sv.getMaSV(), sv.getHoSV(), sv.getTenSV(), sv.getGender(), sv.getBirth(), sv.getQueQuan()});
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setVisible(false);
		SwingUtilities.invokeLater(() -> new TimSVFrm()); 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new TimSVFrm());
	}*/
}