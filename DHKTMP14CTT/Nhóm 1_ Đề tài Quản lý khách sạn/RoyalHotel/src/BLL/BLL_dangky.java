/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.connection;
import GUI.thongbao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BLL_dangky {

    public static String pass2;
    public static String setEmail = "\\w+@\\w+(\\.\\w+){1,2}";

    public static boolean KTra_DK(Entity.User DN1, String nhailai_mk) {

        ResultSet rs = DAO.DangNhap.Ktra_trung();
        try {
            while (rs.next()) {
                if (DN1.getTendangnhap().equals(rs.getString("tenuser"))) {
                    thongbao.thongbao("tên đăng nhập đã sử dụng", "thông báo");
                    return false;

                }
                if (DN1.getEmail().equals(rs.getString("email"))) {
                    thongbao.thongbao("email đã sử dụng", "thông báo");
                    return false;
                }
            }
        } catch (SQLException ex) {

        }
        if (DN1.getHovaten().trim().equals("") || DN1.getTendangnhap().trim().equals("") || DN1.getEmail().trim().equals("") || DN1.getMk().trim().equals("") || nhailai_mk.trim().equals("")) {
            thongbao.thongbao("không để trống dữ liệu", "thông báo");
            return false;
        }
        if (!DN1.getMk().matches(nhailai_mk)) {
            thongbao.thongbao("nhập lại mk không chính xác", "thông báo");
            return false;
        }
        if (!DN1.getEmail().matches(setEmail)) {
            thongbao.thongbao("email lỗi", "thông báo");
            return false;
        }
        if (DN1.getHovaten().length() < 3) {
            thongbao.thongbao("họ và tên phải lớn hơn 3 ký tự", "thông báo");
            return false;
        }
        if (DN1.getTendangnhap().length() < 6) {
            thongbao.thongbao("tên đăng nhập lớn hơn 6 ký tự", "thông báo");
            return false;
        }
        if (DN1.getMk().length() < 6) {
            thongbao.thongbao("mật khẩu lớn hơn 6 ký tự", "thông báo");
            return false;
        }
        DAO.DangKy.DangKy(DN1);
        return true;
    }

    public static boolean kt_SuaTK(String pass, String quyen, String email, String hovaten) {
        ResultSet rs = DAO.User.layUser();
        if (!email.matches(setEmail)) {
            thongbao.thongbao("lỗi email", "thông báo");
            return false;
        }
        if (hovaten.length() < 3) {
            thongbao.thongbao("họ và tên lớn hơn 3 ký tự", "thông báo");
            return false;

        }
        try {
            while (rs.next()) {
                if (!rs.getString("tenuser").equals(GUI.GUI_taikhoan.tendangnhap)) {
                    if (rs.getString("email").equals(email)) {
                        thongbao.thongbao("email đã dùng", "thông báo");
                        return false;
                    }
                }
            }
        } catch (SQLException ex) {
            thongbao.thongbao("lỗi", "thông báo");
        }
        if (!pass.isEmpty()) {
            if (pass.length() < 6) {
                thongbao.thongbao("mật khẩu lớn hơn 6 ký tự", "thông báo");
                return false;
            }
            pass2 = pass;
        } else {
            pass2 = GUI.GUI_suataikhoan.passtheoten;
        }
        DAO.User.UPdateuser(GUI.GUI_taikhoan.tendangnhap, hovaten, pass2, email, quyen);
        return true;
    }
}
