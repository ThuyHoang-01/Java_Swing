package DAO;

import java.sql.ResultSet;

import GUI.thongbao;

public class KhachHang {
	public static ResultSet loaiKH() {
        String cautruyvan = "SELECT [maloaiKH] "
                + "      ,[tenloaiKH] "
                + "      ,[mota] "
                + "  FROM [dbo].[loaiKH]";
        return connection.Getdata(cautruyvan);
    }

    public static ResultSet layloaitheoMa(int maloai) {
        String cautruyvan = "SELECT [maloaiKH] "
                + "      ,[tenloaiKH] "
                + "      ,[mota] "
                + "  FROM [dbo].[loaiKH] "
                + "  where maloaiKH =" + maloai;
        return connection.Getdata(cautruyvan);
    }

    public static ResultSet laydulieuKH() {
        String cautruyvan = "SELECT [maKH] "
                + "      ,[maloaiKH] "
                + "      ,[tenKH] "
                + "      ,[tuoi] "
                + "      ,[gioitinh] "
                + "      ,[sdt] "
                + "      ,[soCMND] "
                + "      ,[ghichu] "
                + "  FROM [dbo].[KH]";
        return connection.Getdata(cautruyvan);

    }

    public static void themKH(Entity.KhachHang kh, String maloaiKH) {
        String cautruyvan = "INSERT INTO [dbo].[KH] "
                + "           ([maloaiKH] "
                + "           ,[tenKH] "
                + "           ,[tuoi] "
                + "           ,[gioitinh] "
                + "           ,[sdt] "
                + "           ,[soCMND] "
                + "          ) "
                + "     VALUES "
                + "           ( " + maloaiKH + " "
                + "           ,N'" + kh.getTenKH() + "' "
                + "           , " + kh.getTuoi()
                + "           ,N'" + kh.getGioitinh() + "' "
                + "           ,'" + kh.getSdt() + "' "
                + "           ,'" + kh.getCMND() + "' "
                + "           )";
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("thêm thành công", "thông báo");
        } else {
            thongbao.thongbao("thêm không thành công", "thông báo");
        }
    }

    public static void xoaKH(int maKH) {
        String cautruyvan = "DELETE FROM [dbo].[KH] "
                + "      WHERE maKH=" + maKH;
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("xóa thành công", "thông báo");
        } else {
        }
    }

    public static void suaKH(Entity.KhachHang kh_sua, String maloaiKH, String maKH) {
        String cautruyvan = "UPDATE [dbo].[KH] "
                + "   SET [maloaiKH] =  " + maloaiKH
                + "      ,[tenKH] = N'" + kh_sua.getTenKH() + "' "
                + "      ,[tuoi] =  " + kh_sua.getTuoi()
                + "      ,[gioitinh] = N'" + kh_sua.getGioitinh() + "' "
                + "      ,[sdt] = '" + kh_sua.getSdt() + "' "
                + "      ,[soCMND] =N'" + kh_sua.getCMND() + "' "
                + "      ,[ghichu] = N'' "
                + " WHERE maKH=" + maKH;
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("sửa thành công", "thông báo");
        } else {
        }
    }

    public static ResultSet timkiemKH(String tukhoa) {
        String cautruyvan = "SELECT [maKH] "
                + "      ,[maloaiKH] "
                + "      ,[tenKH] "
                + "      ,[tuoi] "
                + "      ,[gioitinh] "
                + "      ,[sdt] "
                + "      ,[soCMND] "
                + "      ,[ghichu] "
                + "  FROM [dbo].[KH] "
                + "  where tenKH like N'%" + tukhoa + "%'";
        return connection.Getdata(cautruyvan);
    }
//    ----------------------------------------------------------

    public static ResultSet LoaiKH() {
        String cautruyvan = "SELECT *FROM [dbo].[loaiKH]";
        return connection.Getdata(cautruyvan);
    }

    public static void themLOaiKH(String tenLoai, String mota) {
        String cautruyvan = "INSERT INTO [dbo].[loaiKH] "
                + "           ([tenloaiKH] "
                + "           ,[mota]) "
                + "     VALUES "
                + "           (N'" + tenLoai + "', "
                + "           N'" + mota + "')";
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("thêm thành công", "thông báo");
        } else {
        }
    }

    public static void xoaLoaiKH(int maLOai) {
        String cautruyvan = "DELETE FROM [dbo].[loaiKH] "
                + "      WHERE maloaiKH=" + maLOai;
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("xóa thành công", "thông báo");
        } else {
        }
    }

    public static void updateLoai(int malOai, String tenLoai, String mota) {
        String cautruyvan = "UPDATE [dbo].[loaiKH] "
                + "   SET [tenloaiKH] = N'"+tenLoai+"' "
                + "      ,[mota] =N'"+mota+"' "
                + " WHERE maloaiKH="+malOai;
        int kq=connection.ExecuteTruyVan(cautruyvan);
        if (kq>0) {
            thongbao.thongbao("Sửa thành công", "thông báo");
        }else{
        
        }
    }

}
