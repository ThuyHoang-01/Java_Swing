package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import dao.DSNT;
import database.Database;
import entity.NhaTro;

public class DanhSachNhaTroFrm extends JFrame implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnTim, btnThem, btnXoa, btnXem;
	private DefaultTableModel tableModel;
	private DSNT dao;
	private List<NhaTro> dsnt;
	private JComboBox<String> cmbDS;
	private String tenNT = null;
	//
	Menu main, subSV, subNT, subDC;
	MenuBar menuBar;
	MenuItem menuMain, menuDSSV, menuTimSV, menuThemSV, menuXoaSV, menuDSNT, menuTimNT, menuThemDC, menuUDDC, menuThue, menuUpdateDC;
	public DanhSachNhaTroFrm() {
		Database.getInstance().connect();
		dao = new DSNT();
		setSize(900, 600);
		setVisible(true);
		setTitle("DANH SÁCH NHÀ TRỌ");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container ctn = getContentPane();
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
		JPanel pnNorth = new JPanel();
		cmbDS = new JComboBox<String>();
		cmbDS.addItem("Còn trống");
		cmbDS.addItem("Không còn trống");
		cmbDS.addItem("Cả hai");
		btnXem = new JButton("Xem");
		pnNorth.add(cmbDS);
		pnNorth.add(btnXem);
		ctn.add(pnNorth, BorderLayout.NORTH);
		//
		JScrollPane scroll;
		String headers[] = {"Tên nhà trọ", "Chủ nhà trọ", "Số điện thoại", "Số phòng trống"};
		tableModel = new DefaultTableModel(headers, 0);
		table = new JTable(tableModel);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				tenNT = (String)table.getValueAt(row, 0);
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
		scroll = new JScrollPane(table, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ctn.add(scroll, BorderLayout.CENTER);
		scroll.setPreferredSize(new Dimension(0, 240));
		
		//
		JPanel pnlSouth = new JPanel();
		btnTim = new JButton("Tìm nhà trọ");
		btnTim.setPreferredSize(new Dimension(150, 25));
		btnThem = new JButton("Thêm nhà trọ");
		btnThem.setPreferredSize(new Dimension(150, 25));
		btnXoa = new JButton("Xóa nhà trọ");
		btnXoa.setPreferredSize(new Dimension(200, 25));
		pnlSouth.add(btnTim);
		pnlSouth.add(btnThem);
		pnlSouth.add(btnXoa);
		ctn.add(pnlSouth, BorderLayout.SOUTH);
		
		btnXem.addActionListener(this);
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		cmbDS.addMouseListener(this);
	}
	public void docvaotable() {
		if (cmbDS.getSelectedIndex()==0) {
			List<NhaTro> dsnt = dao.readTrong();
			for(NhaTro nt : dsnt) {
				tableModel.addRow(new Object[] {nt.getTenNT(), nt.getChuTro(), nt.getSoDT(), nt.getPhongTrong()});
			}
		} else if (cmbDS.getSelectedIndex()==1) {
			List<NhaTro> dsnt = dao.readKTrong();
			for(NhaTro nt : dsnt) {
				tableModel.addRow(new Object[] {nt.getTenNT(), nt.getChuTro(), nt.getSoDT(), nt.getPhongTrong()});
			}
		} else if (cmbDS.getSelectedIndex()==2) {
			List<NhaTro> dsnt = dao.readDB();
			for(NhaTro nt : dsnt) {
				tableModel.addRow(new Object[] {nt.getTenNT(), nt.getChuTro(), nt.getSoDT(), nt.getPhongTrong()});
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXem)) {
			docvaotable();
		} else if (o.equals(btnTim)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new TimNTFrm());
		} else if (o.equals(btnThem)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new ThemNTFrm());
		} else if (o.equals(btnXoa)) {
			if (tenNT == null) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn đối tượng!");
			} else {
					dao.delete(tenNT);
					setVisible(false);
					SwingUtilities.invokeLater(() -> new DanhSachNhaTroFrm());
			}
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		setVisible(false);
		SwingUtilities.invokeLater(() -> new DanhSachNhaTroFrm());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new DanhSachNhaTroFrm());
	}*/
}
