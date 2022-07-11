package DAO;

import GUI.thongbao;

public class DangKy {
	public static int DangKy(Entity.User DN1) {
        String cautruyvan = "INSERT INTO [dbo].[user] "
                + "           ([tenuser] "
                + "           ,[password] "
                + "		   ,[hovaten] "
                + "           ,[email]) "
                + "     VALUES "
                + "           (N'" + DN1.getTendangnhap() + "' "
                + "           ,N'" + DN1.getMk() + "' "
                + "		   ,N'" + DN1.getHovaten() + "' "
                + "           ,N'" + DN1.getEmail() + "')";
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("đăng ký thành công", "thông báo");
        } else {
            thongbao.thongbao("đăng ký không thành công", "thông báo");
        }
        return kq;

    }

}
