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
public class BLL_DoiMK {
    public static boolean DoiMK(String passcu,String passmoi,String nhailaipass){
        String mk=BLL.BLL_dangnhap.Doi_MK.getMk();
        if (!passcu.equals(mk)) {
            thongbao.thongbao("mật khẩu cũ sai", "thông báo");
            return false;
            
        }
        if (!passmoi.equals(nhailaipass)) {
            thongbao.thongbao("nhập lại mật khẩu sau", "thông báo");
            return false;
        }
        if (passmoi.length()<6) {
            thongbao.thongbao("mật khẩu dài hơn 6 ký tự", "thông báo");
            return false;
        }
        DAO.DoiMK.DoiMK(BLL.BLL_dangnhap.Doi_MK.getTendangnhap(),passmoi);
        return true;
    }
}
