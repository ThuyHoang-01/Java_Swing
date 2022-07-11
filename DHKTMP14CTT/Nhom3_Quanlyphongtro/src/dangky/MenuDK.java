package dangky;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MenuDK extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lbTieuDe;
	TitledBorder ttSV, ttNT, ttKhac;
	JButton btnXemDS, btnTim, btnThem, btnXoa, btnCapNhat, btnTimNT, btnUpdate, btnThemDC, btnXoaDC, btnXemTD;
	public MenuDK () {
		setSize(700, 400);
		setVisible(true);
		setTitle("MENU");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Tiêu đề
		Container ctn = getContentPane();
		JPanel pnNorth = new JPanel();
		lbTieuDe = new JLabel("QUẢN LÝ THÔNG TIN NHÀ TRỌ CỦA SINH VIÊN");
		Font ft = new Font("arial", Font.BOLD, 30);
		lbTieuDe.setForeground(Color.magenta);
		pnNorth.setBackground(Color.WHITE);
		lbTieuDe.setFont(ft);
		pnNorth.add(lbTieuDe);
		ctn.add(pnNorth, BorderLayout.NORTH);
		
		//Center	
		JPanel pnlCenter = new JPanel();
		JPanel pnlC1 = new JPanel();
		pnlC1.setPreferredSize(new Dimension(670, 100));
		pnlC1.setLayout(new GridLayout(2, 2, 50, 10));
		Border bd1 = BorderFactory.createLineBorder(Color.ORANGE);
		TitledBorder bdTitle1 = new TitledBorder(bd1, "Chọn tác vụ đối với sinh viên");
		bdTitle1.setTitleColor(Color.GREEN);
		pnlC1.setBorder(bdTitle1);
		pnlC1.setBackground(Color.WHITE);
		btnXemDS = new JButton("Xem danh sách");
		btnTim = new JButton("Tìm sinh viên");
		btnThem = new JButton("Thêm sinh viên");
		btnXoa = new JButton("Xóa sinh viên");
		pnlC1.add(btnXemDS);
		pnlC1.add(btnTim);
		pnlC1.add(btnThem);
		pnlC1.add(btnXoa);
		
		JPanel pnlC2 = new JPanel();
		pnlC2.setPreferredSize(new Dimension(670, 100));
		pnlC2.setLayout(new GridLayout(2, 2, 50, 10));
		Border bd2 = BorderFactory.createLineBorder(Color.ORANGE);
		TitledBorder bdTitle2 = new TitledBorder(bd2, "Chọn tác vụ đối với nhà trọ");
		bdTitle2.setTitleColor(Color.GREEN);
		pnlC2.setBorder(bdTitle2);
		pnlC2.setBackground(Color.WHITE);
		btnTimNT = new JButton("Tìm nhà trọ");
		btnThemDC = new JButton("Thêm địa chỉ nhà trọ");
		btnXoaDC = new JButton("Xóa địa chỉ nhà trọ");
		pnlC2.add(btnTimNT);
		pnlC2.add(btnThemDC);
		pnlC2.add(btnXoaDC);
		
		JPanel pnlC3 = new JPanel();
		pnlC3.setPreferredSize(new Dimension(670, 100));
		//pnlC3.setLayout(new BoxLayout(pnlC3, BoxLayout.Y_AXIS));
		Border bd3 = BorderFactory.createLineBorder(Color.ORANGE);
		TitledBorder bdTitle3 = new TitledBorder(bd3, "Chọn tác vụ khác");
		bdTitle3.setTitleColor(Color.GREEN);
		pnlC3.setBorder(bdTitle3);
		pnlC3.setBackground(Color.WHITE);
		btnXemTD = new JButton("Xem quá trình thay đổi nhà trọ của sinh viên");
		btnXemTD.setPreferredSize(new Dimension(300, 35));
		pnlC3.add(btnXemTD);
		
		
		pnlCenter.add(pnlC1);
		pnlCenter.add(pnlC2);
		pnlCenter.add(pnlC3);
		ctn.add(pnlCenter,BorderLayout.CENTER);
		
		btnXemDS.addActionListener(this);
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTimNT.addActionListener(this);
		btnThemDC.addActionListener(this);
		btnXoaDC.addActionListener(this);
		btnXemTD.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnXemDS))
			//new DanhSachFrm();
		if (o.equals(btnTim))
			//new DanhSachSV();		
		if(o.equals(btnThem))
//			DanhSachTaiKhoan dao = new DanhSachTaiKhoan();
//			new frmDangKy(dao);
			System.out.println("3");
		if(o.equals(btnXoa))
			System.out.println("4");
		if(o.equals(btnTimNT))
			System.out.println("5");
		if(o.equals(btnThemDC))
			System.out.println("6");
		if(o.equals(btnXoaDC))
			System.out.println("7");
		if(o.equals(btnXemTD))
			System.out.println("8");
	}
	
}
