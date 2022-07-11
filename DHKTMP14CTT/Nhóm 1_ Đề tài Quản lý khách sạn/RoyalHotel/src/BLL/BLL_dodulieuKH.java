
package BLL;

import DAO.connection;
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
public class BLL_dodulieuKH {

    public static void dodulieuKH(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[8];
        ResultSet rs = DAO.KhachHang.laydulieuKH();
        try {
            while (rs.next()) {
                obj[0] = tblModel.getRowCount();
                obj[1] = rs.getInt("maKH");
                int maloai = rs.getInt("maloaiKH");                                              
                ResultSet rsLoai=DAO.KhachHang.layloaitheoMa(maloai);
                if (rsLoai.next()) {
                    obj[2]=rsLoai.getString("tenloaiKH");
                }

                obj[3]=rs.getString("tenKH");
                obj[4]=rs.getInt("tuoi");
                obj[5]=rs.getString("gioitinh");
                obj[6]=rs.getString("sdt");
                obj[7]=rs.getString("soCMND");
                
                 tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            thongbao.thongbao("không đổ được dữ liệu", "");
        }
    }
    public static void dodulieuTimKiem(JTable tbl,String tuKhoa){
    DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[8];
        ResultSet rs = DAO.KhachHang.timkiemKH(tuKhoa);
        try {
            while (rs.next()) {
                obj[0] = tblModel.getRowCount();
                obj[1] = rs.getInt("maKH");
                int maloai = rs.getInt("maloaiKH");                                              
                ResultSet rsLoai=DAO.KhachHang.layloaitheoMa(maloai);
                if (rsLoai.next()) {
                    obj[2]=rsLoai.getString("tenloaiKH");
                }

                obj[3]=rs.getString("tenKH");
                obj[4]=rs.getInt("tuoi");
                obj[5]=rs.getString("gioitinh");
                obj[6]=rs.getString("sdt");
                obj[7]=rs.getString("soCMND");
                
                 tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            thongbao.thongbao("không đổ được dữ liệu", "");
        }
    }
}
