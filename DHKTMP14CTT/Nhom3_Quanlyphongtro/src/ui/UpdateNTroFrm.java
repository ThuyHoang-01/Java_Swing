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
import java.awt.Insets;

import dao.DSNT;
import database.Database;
import entity.NhaTro;

public class UpdateNTroFrm extends JFrame implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel tableModel;
	private DSNT dao;
	private List<NhaTro> dsnt;
	
	private JButton btnTim, btnUpdate, btnReload;
	private JLabel lbTenNT, lbChuTro, lbSdt, lbPhongTrong;
	private JTextField txtTenNT, txtChuTro, txtSdt;
	private JComboBox<String> cmbPhongTrong;
	//
	private String tenNT = "", chuTro = "", soDT = "";
	private int phongTrong;
	private NhaTro nt;
	//
	Menu main, subSV, subNT, subDC;
	MenuBar menuBar;
	MenuItem menuMain, menuDSSV, menuTimSV, menuThemSV, menuXoaSV, menuDSNT, menuTimNT, menuThemDC, menuUDDC, menuThue, menuUpdateDC;
	public UpdateNTroFrm (){
		Database.getInstance().connect();
		dao = new DSNT();
		setSize(900, 600);
		setVisible(true);
		setTitle("CẬP NHẬT THÔNG TIN NHÀ TRỌ");
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
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));

		lbTenNT = new JLabel("Tên nhà trọ: ");
		lbChuTro = new JLabel("Chủ trọ: ");
		lbSdt = new JLabel("Phone: ");
		lbPhongTrong = new JLabel("Số phòng trống: ");
		lbChuTro.setPreferredSize(lbTenNT.getPreferredSize());
        lbSdt.setPreferredSize(lbTenNT.getPreferredSize());
		
        txtTenNT = new JTextField();
		b1.add(lbTenNT);
		b1.add(txtTenNT);
		txtTenNT.addMouseListener(new MouseListener() {
			
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
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				txtTenNT.setEditable(true);
			}
		});

		txtChuTro = new JTextField();
		b2.add(lbChuTro);
		b2.add(txtChuTro);

		txtSdt = new JTextField();
		b3.add(lbSdt);
		b3.add(txtSdt);
		
		cmbPhongTrong = new JComboBox<String>();
		for (int i = 0; i < 30; i++) {
			String t = String.valueOf(i);
			cmbPhongTrong.addItem(t);
		}
		b4.add(lbPhongTrong);
		b4.add(cmbPhongTrong);

		JPanel pn = new JPanel();
		b.add(pn);
		btnTim = new JButton("Tìm");
		btnTim.setPreferredSize(new Dimension(150, 20));
		btnTim.setMargin(new Insets(0, 15, 0, 15));
		btnUpdate = new JButton("Cập nhật");
		btnUpdate.setPreferredSize(new Dimension(150, 20));
		btnUpdate.setMargin(new Insets(0, 15, 0, 15));
		btnReload = new JButton("Reload Table");
		btnReload.setPreferredSize(new Dimension(150, 20));
		btnReload.setMargin(new Insets(0, 15, 0, 15));
		pn.add(btnTim);
		pn.add(btnUpdate);
		pn.add(btnReload);
		btnUpdate.setEnabled(false);
		ctn.add(b, BorderLayout.NORTH);
		
		//
		JScrollPane scroll;
		String headers[] = {"Địa chỉ", "Chủ nhà trọ", "Số điện thoại", "Số phòng trống"};
		tableModel = new DefaultTableModel(headers, 0);
		table = new JTable(tableModel);
		table.addMouseListener(this);
		scroll = new JScrollPane(table, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ctn.add(scroll, BorderLayout.CENTER);
		scroll.setPreferredSize(new Dimension(0, 240));	
		//
		btnTim.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnReload.addActionListener(this);
	}
	
	//Đọc từ TextField vào NhaTro
	public void docText() {
		tenNT = txtTenNT.getText();
		chuTro = txtChuTro.getText();
	    soDT = txtSdt.getText();
	    String t = cmbPhongTrong.getSelectedItem().toString();
	    phongTrong = Integer.parseInt(t);
		nt = new NhaTro(tenNT, chuTro, soDT, phongTrong);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnUpdate)) {
			try {
				docText();
				dao.update(nt.getTenNT(), nt.getChuTro(), nt.getSoDT(), nt.getPhongTrong());
				setVisible(false);
				SwingUtilities.invokeLater(() -> new UpdateNTroFrm());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (o.equals(btnReload)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new UpdateNTroFrm());
		} else if (o.equals(btnTim)) {
			try {
				if (txtTenNT.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
				} else {
					docText();
					dsnt = dao.findMoreInfor(nt.getTenNT(), nt.getChuTro(), nt.getSoDT(), nt.getPhongTrong());
					for(NhaTro nt : dsnt) {
						tableModel.addRow(new Object[] {nt.getTenNT(), nt.getChuTro(), nt.getSoDT(), nt.getPhongTrong()});
					}
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}	

	}
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new UpdateNTroFrm());
	}*/

	@Override
	public void mouseClicked(MouseEvent e) {
		txtTenNT.setEditable(false);
		int row = table.getSelectedRow();
		btnUpdate.setEnabled(true);
		txtTenNT.setText((String)table.getValueAt(row, 0));
		txtChuTro.setText((String)table.getValueAt(row, 1));
		txtSdt.setText((String)table.getValueAt(row, 2));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
