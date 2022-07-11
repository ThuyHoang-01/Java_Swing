package GD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import GD.GD_HoaDon;
import GD.GD_NhanPhong;
import GD.GD_DichVu;
import GD.GD_TraPhong;
import GD.GD_DangKy;
import GD.GD_Phong;
 
 
public class Menu extends JFrame implements MenuListener,ActionListener,KeyListener {
	private JLabel lblTieDe, lblFooter;
	private JMenu menuFile,menuFile2,menuFile3;
	private JMenuItem DSItem,traItem,nhanItem,XTTDV,HoaDonItem;
    public Menu() {
         
    
 
        JMenuBar menubar = new JMenuBar();
        JMenuItem DKItem = new JMenuItem("Đăng ký Phòng");
       // JMenuItem newItem = new JMenuItem("New");
       // JMenuItem openItem = new JMenuItem("Open");
        //JMenuItem exitItem = new JMenuItem("Exit");
        
  
        //JMenu saveMenu = new JMenu("Save");
        //JMenuItem saveItem = new JMenuItem("Save");
       // JMenuItem saveAsItem = new JMenuItem("Save as...");
       // saveMenu.add(saveItem);
        //saveMenu.add(saveAsItem);
       // menuFile.add(newItem);
        //menuFile.add(openItem);
        //menuFile.add(saveMenu);
       // menuFile.addSeparator();
       // menuFile.add(exitItem)
        //
      JMenu   menuFile1 = new JMenu("Phòng");
        JMenuItem DSItem = new JMenuItem("Danh sách Phòng");
        JMenuItem traItem = new JMenuItem("Trả Phòng");
        JMenuItem nhanItem = new JMenuItem("Nhận Phòng");
        menuFile1.add(DKItem);
        menuFile1.add(DSItem);
        menuFile1.add(traItem);
        menuFile1.add(nhanItem);
        menubar.add(menuFile1);
        //
        JMenu menuFile2 = new JMenu("Dịch vụ");
        menubar.add(menuFile2);
        JMenuItem XTTDV = new JMenuItem("Xem thông tin dịch vụ");
        menuFile2.add(XTTDV);
        JMenu menuFile3 = new JMenu("Thanh toán");
        menubar.add(menuFile3);
        JMenuItem HoaDonItem= new JMenuItem("Hoá đơn");
        menuFile3.add(HoaDonItem);
        JMenu menuFile4 = new JMenu("Tìm kiếm");
        JMenuItem HoTenITem = new JMenuItem("Họ tên");
        JMenuItem CMNDItem = new JMenuItem("CMND");
        menuFile4.add(CMNDItem);
        menuFile4.add(HoTenITem);
        menubar.add(menuFile4);
        JMenu menuFile5 = new JMenu("Tổng doanh thu");
        menubar.add(menuFile5);
      /* exitItem.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e)
        {
           System.exit(0);
        }
        });*/
        setJMenuBar(menubar);
  /////////////////////////////////////////////
        setTitle("Menu quản lý khách sạn");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);     
        
        JPanel pNorth = new JPanel();
        pNorth.add(lblTieDe= new JLabel("QUẢN LÝ KHÁCH SẠN"));
        lblTieDe.setFont(new Font("Arail",Font.BOLD,30) );
        lblTieDe.setForeground(Color.RED);
        pNorth.setBackground(Color.LIGHT_GRAY);
		add(pNorth,BorderLayout.NORTH);
		
		JPanel pCen = new JPanel();
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("C:\\Users\\hphhuyen\\eclipse-workspace\\QLKhachSan\\ks.jpg"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		pCen.add(picLabel);
		add(pCen,BorderLayout.CENTER);
		JPanel pSouth= new JPanel();
		pSouth.add(lblFooter = new JLabel("Mọi chi tiết xin liên hệ: 0928644923 Hoặc liên hệ qua gmail: nguyenphucthinh1422@gmail.com"));
		lblFooter.setFont(new Font("Arail", Font.BOLD,12));
		lblFooter.setForeground(Color.BLUE);
		add(pSouth,BorderLayout.SOUTH);
		 DKItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(DKItem))
					{
						
						 new GD_DangKy().setVisible(true);
					}
				}
			 });
		 traItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(traItem))
					{
						
						 new GD_TraPhong().setVisible(true);
					}
				}
			 });
		 DSItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(DSItem))
					{
						
						 new GD_Phong().setVisible(true);
					}
				}
			 });
		 nhanItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(nhanItem))
				{
					
					 new GD_NhanPhong().setVisible(true);
				}
			}
		 });
		 XTTDV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(XTTDV))
					{
						
						 new GD_DichVu().setVisible(true);
					}
				}
			 });
		 HoaDonItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(HoaDonItem))
					{
						
						 new GD_HoaDon().setVisible(true);
					}
				}
			 });
    }
    
    
 
	   
 


	
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	 public static void main(String[] args) {
         
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                 
	            	Menu ex = new Menu();
	                ex.setVisible(true);
	            } });
	        }







	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
    