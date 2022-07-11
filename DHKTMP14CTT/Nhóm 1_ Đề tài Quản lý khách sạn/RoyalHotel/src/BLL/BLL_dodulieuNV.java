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
public class BLL_dodulieuNV {

    public static void dodulieuNV(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[10];
        ResultSet rs = DAO.NhanVien.laydulieuNV();
        try {
            while(rs.next()){
                obj[0]=tblModel.getRowCount();
                obj[1]=rs.getInt("manhanvien");
                obj[2]=rs.getString("tennhanvien");
                obj[3]=rs.getString("gioitinh");
                obj[4]=rs.getString("ngaysinh");
                obj[5]=rs.getString("sdt");
                obj[6]=rs.getString("ngaylam");
                obj[7]=rs.getInt("luong");
                obj[8]=rs.getString("diachi");
                obj[9]=rs.getString("ghichu");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            thongbao.thongbao("lỗi đổ dữ liệu", "thông báo");
        }
    }
    public static void dodulieuNV_Timkiem(JTable tbl,String tuKhoa){
            DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[10];
        ResultSet rs = DAO.NhanVien.timkiemNV(tuKhoa);
        try {
            while(rs.next()){
                obj[0]=tblModel.getRowCount();
                obj[1]=rs.getInt("manhanvien");
                obj[2]=rs.getString("tennhanvien");
                obj[3]=rs.getString("gioitinh");
                obj[4]=rs.getString("ngaysinh");
                obj[5]=rs.getString("sdt");
                obj[6]=rs.getString("ngaylam");
                obj[7]=rs.getInt("luong");
                obj[8]=rs.getString("diachi");
                obj[9]=rs.getString("ghichu");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            thongbao.thongbao("lỗi đổ dữ liệu", "thông báo");
        }
    
    }
   
}
