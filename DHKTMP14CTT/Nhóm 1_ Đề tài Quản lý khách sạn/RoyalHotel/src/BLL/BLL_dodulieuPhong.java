/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import GUI.thongbao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BLL_dodulieuPhong {
    public static void dodulieuPhong(JTable tbl){
        DefaultTableModel tblModel= (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[]=new Object[3];
    ResultSet rs=DAO.Phong.laydulieuPhong();
        try {
            while(rs.next()){
                obj[0]=tblModel.getRowCount();
                obj[1]=rs.getString("tenphong");
                obj[2]=rs.getString("trangthai");
                tblModel.addRow(obj);
            }   } catch (SQLException ex) {
            thongbao.thongbao("lỗi đổ dữ liệu", "thông báo");
        }
    }
}
