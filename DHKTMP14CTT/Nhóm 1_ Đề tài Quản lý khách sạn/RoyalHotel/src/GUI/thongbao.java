/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class thongbao {
    public static void thongbao(String noidung,String tieude){
        JOptionPane.showMessageDialog(new JOptionPane(),noidung, tieude,JOptionPane.INFORMATION_MESSAGE);
    }
}
