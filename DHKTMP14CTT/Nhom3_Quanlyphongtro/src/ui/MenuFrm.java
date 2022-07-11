package ui;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MenuFrm extends JFrame implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lbTieuDe;
	TitledBorder ttSV, ttNT, ttKhac;
	JButton btnXemDS, btnTim, btnThem, btnXoa, btnDSNT, btnTimNT, btnUpdate, btnThemDC, btnUDDC, btnXemTD;
	//
	Menu main, subSV, subNT, subDC;
	MenuBar menuBar;
	MenuItem menuMain, menuDSSV, menuTimSV, menuThemSV, menuXoaSV, menuDSNT, menuTimNT, menuThemDC, menuUDDC, menuThue, menuUpdateDC;
	public MenuFrm () throws IOException {
		setSize(900, 600);
		setVisible(true);
		setTitle("MENU");
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
		//Tiêu đề
		Container ctn = getContentPane();
		JPanel pnNorth = new JPanel();
		BufferedImage img = ImageIO.read(new File("images/Logo_IUH.png"));
		JLabel pic = new JLabel(new ImageIcon(img));
		pnNorth.add(pic, BorderLayout.NORTH);
		lbTieuDe = new JLabel("QUẢN LÝ THÔNG TIN NHÀ TRỌ CỦA SINH VIÊN");
		Font ft = new Font("arial", Font.BOLD, 30);
		lbTieuDe.setForeground(Color.magenta);
		//pnNorth.setBackground(Color.WHITE);
		lbTieuDe.setFont(ft);
		pnNorth.add(lbTieuDe);
		ctn.add(pnNorth, BorderLayout.CENTER);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXemDS)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new DanhSachFrm());
		} else if (o.equals(btnTim)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new TimSVFrm());
		} else if (o.equals(btnThem)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new ThemSVFrm());
		} else if (o.equals(btnXoa)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new XoaSVFrm());
		} else if (o.equals(btnDSNT)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new DanhSachNhaTroFrm());
		} else if (o.equals(btnTimNT)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new TimNTFrm());
		} else if (o.equals(btnThemDC)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new ThemNTFrm());
		} else if (o.equals(btnUDDC)) {
			setVisible(false);
			SwingUtilities.invokeLater(() -> new UpdateNTroFrm());
		} else if (o.equals(btnXemTD)) {
			
		} else if (o.equals(btnUpdate)) {
			
		}
	}
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new MenuFrm();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}*/
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
}
