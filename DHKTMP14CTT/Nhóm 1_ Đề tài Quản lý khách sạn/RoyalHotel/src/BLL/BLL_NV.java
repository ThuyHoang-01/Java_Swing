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
public class BLL_NV {

    public static boolean ktNV(Entity.NhanVien nv) {
        String ktNgay = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";
        String ktNgay2="\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}";
        if (nv.getTen().trim().equals("") || nv.getNgaysinh().trim().equals("") || nv.getNgaylam().trim().equals("")) {
            thongbao.thongbao("không để trống dữ liệu", "thông báo");
            return false;

        }

        if (ChuyenDoi.DinhDangSo(nv.getLuong()).trim().equals("")) {
            thongbao.thongbao("Nhập lương cho nhân viên", "thông báo");
            return false;

        }
        String ktSDT="[0-9]{10}";
        if (!nv.getSdt().matches(ktSDT)) {
            thongbao.thongbao("số điện thoại có 10 số", "thông báo");
            return false;
        }
        if (!nv.getNgaylam().matches(ktNgay)) {
            thongbao.thongbao("Ngày làm sai", "thông báo");
            return false;
        }
        if (!nv.getNgaysinh().matches(ktNgay)) {
            thongbao.thongbao("NGày sinh sai", "thông báo");
            return false;
        }
        if (nv.getTen().length() < 3) {
            thongbao.thongbao("Tên lớn hơn 4 ký tự", "thông báo");
            return false;
        }

        return true;
    }
    public static boolean ktNV_sua(Entity.NhanVien nv_sua){
            String ktNgay = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";
        String ktNgay2="\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}";
        if (nv_sua.getTen().trim().equals("") || nv_sua.getNgaysinh().trim().equals("") || nv_sua.getNgaylam().trim().equals("")) {
            thongbao.thongbao("không để trống dữ liệu", "thông báo");
            return false;

        }

        if (ChuyenDoi.DinhDangSo(nv_sua.getLuong()).trim().equals("")) {
            thongbao.thongbao("Nhập lương cho nhân viên", "thông báo");
            return false;

        }
        String ktSDT="[0-9]{10}";
        if (!nv_sua.getSdt().matches(ktSDT)) {
            thongbao.thongbao("số điện thoại có 10 số", "thông báo");
            return false;
        }
        if (!nv_sua.getNgaylam().matches(ktNgay2)) {
            thongbao.thongbao("Ngày làm sai", "thông báo");
            return false;
        }
        if (!nv_sua.getNgaysinh().matches(ktNgay2)) {
            thongbao.thongbao("NGày sinh sai", "thông báo");
            return false;
        }
        if (nv_sua.getTen().length() < 3) {
            thongbao.thongbao("Tên lớn hơn 4 ký tự", "thông báo");
            return false;
        }

        return true;
    }
}
