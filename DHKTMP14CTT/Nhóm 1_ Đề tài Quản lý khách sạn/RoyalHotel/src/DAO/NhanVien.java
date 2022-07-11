package DAO;

import java.sql.ResultSet;

import GUI.thongbao;

public class NhanVien {
	public static ResultSet laydulieuNV() {
        String cautruyvan = "SELECT [manhanvien] "
                + "      ,[tennhanvien] "
                + "      ,[gioitinh] "
                + "      ,[ngaysinh] "
                + "      ,[sdt] "
                + "      ,[ngaylam] "
                + "      ,[luong] "
                + "      ,[diachi] "
                + "      ,[ghichu] "
                + "  FROM [dbo].[nhanvien]";
        return connection.Getdata(cautruyvan);
    }

    public static void themNV(Entity.NhanVien nv) {
        String cautruyvan = "INSERT INTO [dbo].[nhanvien] "
                + "           ([tennhanvien] "
                + "           ,[gioitinh] "
                + "           ,[ngaysinh] "
                + "           ,[sdt] "
                + "           ,[ngaylam] "
                + "           ,[luong] "
                + "           ,[diachi] "
                + "           ,[ghichu]) "
                + "     VALUES "
                + "           (N'" + nv.getTen() + "' "
                + "           ,N'" + nv.getGioitinh() + "' "
                + "           ,'" + nv.getNgaysinh() + "' "
                + "           ,'" + nv.getSdt() + "' "
                + "           ,'" + nv.getNgaylam() + "' "
                + "           , " + nv.getLuong()
                + "           ,N'" + nv.getDiachi() + "' "
                + "           ,N'" + nv.getGhichu() + "')";
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("THêm thành công", "thông báo");
        } else {
            thongbao.thongbao("THêm  KHÔNG thành công", "thông báo");
        }

    }

    public static void xoaNV(int maNV) {
        String cautruyvan = "DELETE FROM [dbo].[nhanvien]  "
                + "      WHERE manhanvien=" + maNV;
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("Xóa thành công", "thông báo");
        }
    }

    public static void suaNV(Entity.NhanVien nv_sua, String maNV) {
        String cautruyvan = "set dateformat dmy "
                + "UPDATE [dbo].[nhanvien] "
                + "   SET [tennhanvien] = N'" + nv_sua.getTen() + "' "
                + "      ,[gioitinh] = N'" + nv_sua.getGioitinh() + "' "
                + "      ,[ngaysinh] = N'" + nv_sua.getNgaysinh() + "' "
                + "      ,[sdt] = '" + nv_sua.getSdt() + "' "
                + "      ,[ngaylam] ='" + nv_sua.getNgaylam() + "' "
                + "      ,[luong] = " + nv_sua.getLuong()
                + "      ,[diachi] = N'" + nv_sua.getDiachi() + "' "
                + "      ,[ghichu] = N'" + nv_sua.getGhichu() + "' "
                + " WHERE manhanvien=" + maNV + "";
        int kq = connection.ExecuteTruyVan(cautruyvan);
        if (kq > 0) {
            thongbao.thongbao("sửa thành công", "thông báo");
        } else {
        }
    }

    public static ResultSet timkiemNV(String tuKhoa) {
        String cautruyvan = "SELECT [manhanvien] "
                + "      ,[tennhanvien] "
                + "      ,[gioitinh] "
                + "      ,[ngaysinh] "
                + "      ,[sdt] "
                + "      ,[ngaylam] "
                + "      ,[luong] "
                + "      ,[diachi] "
                + "      ,[ghichu] "
                + "  FROM [dbo].[nhanvien] "
                + "  where tennhanvien like N'%"+tuKhoa+"%' "
                + "  or sdt like '%"+tuKhoa+"%' "
                + "  or diachi like N'%"+tuKhoa+"%'";
        return connection.Getdata(cautruyvan);
    }

}
