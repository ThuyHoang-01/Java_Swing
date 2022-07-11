/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

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
public class BLL_dodulieu_TaiKhoan {

    public static void dodulieu(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[4];
        ResultSet rs = DAO.User.layUser();
        try {
            while(rs.next()){
                obj[0]=tblModel.getRowCount();
                obj[1]=rs.getString("tenuser");
                obj[2]=rs.getString("hovaten");
                obj[3]=rs.getString("email");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
           
        }
    }
}
