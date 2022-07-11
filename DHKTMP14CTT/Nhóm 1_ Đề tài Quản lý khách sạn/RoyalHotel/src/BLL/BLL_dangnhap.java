/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Entity.User;
import GUI.thongbao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BLL_dangnhap {

    public static Entity.User Doi_MK = new Entity.User();
public static String hovaten;
    public static boolean Ktra_DN(Entity.User DN) {

        if (DN.getTendangnhap().trim().equals("") || DN.getMk().trim().equals("")) {//kt nhập trống dữ liệu
            thongbao.thongbao("vui lòng nhập đủ thông tin ", "thông báo");
            return false;
        }
        ResultSet rs = DAO.DangNhap.Dangnhap(DN.getTendangnhap());
        try {
            if (!rs.next()) {//ktra tên dn nhập vào và mk
                thongbao.thongbao("tên đăng nhập không tồn tại", "thông báo");
                return false;
            } else if (rs.getString("password").equals(DN.getMk())) {//dăng nhập thành công
                Doi_MK.setHovaten(rs.getString("hovaten"));
                Doi_MK.setMk(rs.getString("password"));
                Doi_MK.setTendangnhap(rs.getString("tenuser"));
                GUI.GUI_dangnhap.quyen = rs.getString("role");
                hovaten=rs.getString("hovaten");
            } else {
                thongbao.thongbao("mật khẩu không chính xác", "thông báo");
                return false;
            }
        } catch (SQLException ex) {

        }
        
        
        return true;
    }
}
