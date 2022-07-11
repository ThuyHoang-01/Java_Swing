/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import GUI.thongbao;

/**
 *
 * @author ADMIN
 */
public class BLL_KH {

    public static boolean ktKH(Entity.KhachHang kh) {
        if (kh.getTenKH().trim().equals("")) {
            thongbao.thongbao("không để trống tên khách hàng", "thông báo");
            return false;

        }
        if (kh.getTuoi() < 0) {
            thongbao.thongbao("sai tuổi", "thông báo");
            return false;

        }
       String sdttest = "[0-9]{10}";
        String cmndtest = "[0-9]{12}";
        if (!kh.getSdt().matches(sdttest)) {
            thongbao.thongbao("nhập số vào sdt", "thông báo");
            return false;

        }
        if (!kh.getCMND().matches(cmndtest)) {
            thongbao.thongbao("nhập số vào CMND", "thông báo");
            return false;

        }
        if (kh.getSdt().length()!=10) {
            thongbao.thongbao("sdt có 10 số", "thông báo");
            return false;
            
        }
        if (kh.getCMND().length()!=12) {
            thongbao.thongbao("số CMND có 12 số", "thông báo");
            return false;
        }
        return true;

    }
    public static boolean ktLoaiKH(String tenloai,String mota){
        if (tenloai.trim().equals("")) {
            thongbao.thongbao("tên không được để trống", "thông báo");
            return false;
        }
        return true;
    }
}
