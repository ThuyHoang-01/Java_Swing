package DAO;

import GUI.thongbao;

public class PhieuThue {
	public static void them(Entity.PhieuThue pt) {
        String cautruyvan = "INSERT INTO [dbo].[phieuthue] "
                + "           ([maphong] "
                + "           ,[tenphong] "
                + "           ,[tennhanvien]      "
                + "           ,[giaPhong] "
                + "           ,[tenKH] "
                + "           ,[tuoi] "
                + "           ,[sdt] "
                + "           ,[soCMND] "
                + "           ,[ngaythue]) "
                + "     VALUES "
                + "           ( "+pt.getMaphong()
                + "           ,N'"+pt.getTenphong()+"' "
                + "           ,N'"+pt.getTenuser()+"'      "
                + "           , "+pt.getGiaphong()
                + "           ,N'"+pt.getTenKH()+"' "
                + "           , "+pt.getTuoi()
                + "           ,'"+pt.getSdt()+"' "
                + "           ,'"+pt.getCMND()+"' "
                + "           ,'"+pt.getNgaythue()+"')";
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("ok", "");
        } else {
            thongbao.thongbao("NOT ok", "");
        }
    }

}
