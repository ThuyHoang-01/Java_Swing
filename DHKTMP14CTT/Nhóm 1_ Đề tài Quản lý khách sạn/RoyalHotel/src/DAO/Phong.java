package DAO;

import java.sql.ResultSet;

import GUI.thongbao;

public class Phong {
	public static ResultSet laydulieuPhong() {
        String cautruyvan = "SELECT *FROM [dbo].[phong]";
        return connection.Getdata(cautruyvan);
    }

    public static ResultSet laydulieu_Theoten(String tenPhong) {
    	String cautruyvan="SELECT*FROM [dbo].[phong] where tenphong=N'"+tenPhong+"'";
    	return connection.Getdata(cautruyvan);
    }
    public static void themP(Entity.Phong kh, String maphong) {
        String sql = "INSERT INTO [dbo].[phong] "
        		  + "           ([maphong] "
        		  + "           ,[tenphong] "
        		  + "           ,[dientich] "
                  + "           ,[gia] "
                  + "           ,[trangthai]) "
                  + "     VALUES "
                  + "           ( " + maphong + " "
                  + "           ,N'" + kh.getTenPhong() + "' "
                  + "           ,'" + kh.getDientich() + "' "
                  + "           ,'" + kh.getGia() + "' "
                  + "           ,'" + kh.getTrangthai() + "' "
                  + "           )";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("thêm thành công", "thông báo");
        } else {
            thongbao.thongbao("thêm không thành công", "thông báo");
        }
    }

    public static void xoaP(int maphong) {
        String sql = "DELETE FROM [dbo].[phong] "
                + "      WHERE tenphong=" + maphong;
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("xóa thành công", "thông báo");
        } else {
        }
    }

    public static void suaP(Entity.Phong kh_sua, String tenphong) {
        String sql = "UPDATE [dbo].[phong] "
               
                + "      ,[tenphong] = N'" + kh_sua.getTenPhong() + "' "
                
                + "      ,[gioitinh] = N'" + kh_sua.getTrangthai() + "' "
               
                + "      ,[ghichu] = N'' "
                + " WHERE tenphong=" + tenphong;
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("sửa thành công", "thông báo");
        } else {
        }
    }

}
