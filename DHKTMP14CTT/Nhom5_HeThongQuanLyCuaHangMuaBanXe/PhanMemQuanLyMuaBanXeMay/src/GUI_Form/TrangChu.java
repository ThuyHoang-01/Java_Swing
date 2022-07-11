package GUI_Form;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TrangChu extends JPanel{
    public TrangChu(){
        doShow();
    }
    public void doShow(){
        this.setBorder(new TitledBorder("Trang Chủ"));
        JLabel lblTieuDe = new JLabel("PHẦN MỀM QUẢN LÝ CỬA HÀNG MUA BÁN XE MÁY");
        lblTieuDe.setFont(new Font("Arial",Font.BOLD,27));
        lblTieuDe.setForeground(Color.BLUE);
        JLabel imgLabel = new JLabel(new ImageIcon(getClass().getResource("/images/trangchu.png")));
        imgLabel.setPreferredSize(new Dimension(1000,600));
        this.add(lblTieuDe);
        this.add(imgLabel);
    }
}
