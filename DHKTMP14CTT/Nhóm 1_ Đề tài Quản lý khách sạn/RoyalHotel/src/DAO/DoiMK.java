package DAO;

import GUI.thongbao;

public class DoiMK {
	public static void DoiMK(String tenuser, String passmoi) {
        String cautruyvan = "UPDATE [dbo].[user] "
                + "   SET[password] = N'" + passmoi + "' "
                + "      "
                + " WHERE tenuser =N'" + tenuser + "'";
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("Đổi mật khẩu thành công", "thông báo");
        } else {
            thongbao.thongbao("thất bại", "thông báo");
        }
    }

}
