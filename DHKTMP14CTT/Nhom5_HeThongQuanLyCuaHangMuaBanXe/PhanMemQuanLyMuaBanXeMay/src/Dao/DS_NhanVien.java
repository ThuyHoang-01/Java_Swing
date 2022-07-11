package Dao;


import Entity.NhaCungCap;
import Entity.NhanVien;
import com.sun.nio.sctp.NotificationHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DS_NhanVien {
    private Connection con ;

    public DS_NhanVien() {

        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyCuaHangXe", "sa", "hung");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Finished!");
        }

    }


    public ResultSet getResultSet(String StoreName)throws Exception {
        ResultSet rs = null;
        try {
            String callStore;
            callStore = "{Call " + StoreName +"}";
            CallableStatement cs = this.con.prepareCall(callStore);
            cs.executeQuery();
            rs = cs.getResultSet();
        } catch (Exception e) {
            throw new Exception("Error get Store " + e.getMessage());
        }
        return rs;
    }

    public boolean addNhanVien(NhanVien nv) {

        try {
            PreparedStatement nvAdd = con.prepareStatement("INSERT INTO [dbo].[NhanVien] VALUES(?,?,?,?,?,?,?,?,?,?)");
            nvAdd.setString(1,nv.getMaNV());
            nvAdd.setString(2,nv.getTenNV());
            nvAdd.setString(3,nv.getGioiTinh());
            nvAdd.setInt(4,nv.getSoDT());
            nvAdd.setInt(5,nv.getSoCMND());
            nvAdd.setString(6,nv.getNgaySinh());
            nvAdd.setString(7,nv.getNgayVaoLam());
            nvAdd.setString(8,nv.getChucVu());
            nvAdd.setString(9,nv.getDiaChi());
            nvAdd.setDouble(10,nv.getLuongCB());

            int n = nvAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean deleteNV(String maNV) {

        try {
            PreparedStatement stmt = con.prepareStatement("delete from NhanVien where MANHANVIEN = ?");
            stmt.setString(1, maNV);
            int n = stmt.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean updateNhanVien(String maNV, NhanVien nv) {
        String sql = "update NhanVien set TENNHANVIEN = ?, "
                + "GIOITINH = ?,SODT = ? ,SOCMND = ?,NAMSINH = ?,NGAYVAO = ?,CHUCVU = ?,DIACHI = ?,LUONG = ? where MANHANVIEN = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nv.getTenNV());
            stmt.setString(2, nv.getGioiTinh());
            stmt.setInt(3, nv.getSoDT());
            stmt.setInt(4, nv.getSoCMND());
            stmt.setString(5, nv.getNgaySinh());
            stmt.setString(6, nv.getNgayVaoLam());
            stmt.setString(7, nv.getChucVu());
            stmt.setString(8, nv.getDiaChi());
            stmt.setDouble(9, nv.getLuongCB());
            stmt.setString(10, maNV);

            int n = stmt.executeUpdate();
            if(n > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<NhanVien> getLS() {
        List<NhanVien> ds = new ArrayList<>();
        try {
           // PreparedStatement stmt = con.prepareStatement("select * from NhanVien");
            ResultSet rs = getResultSet("select_NV");
            while(rs.next()){
                NhanVien nv =new NhanVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getFloat(10));
                ds.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }
    public List<NhanVien> TimKiem(String maNV){
        List<NhanVien> nv = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from NhanVien where MANHANVIEN = ?");
            stmt.setString(1,maNV);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                NhanVien nv1 = new NhanVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getFloat(10));
                nv.add(nv1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return nv;
    }

    public NhanVien TimKiemNV(String maNV){
        NhanVien nv1 = null;
        try{
            PreparedStatement stmt = con.prepareStatement("select * from NhanVien where MANHANVIEN = ?");
            stmt.setString(1,maNV);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                nv1 = new NhanVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getFloat(10));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return nv1;
    }

    public List<NhanVien> TimKiemTen(String ten){
        List<NhanVien> nv = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from NhanVien where TENNHANVIEN = ?");
            stmt.setString(1,ten);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                NhanVien nv1 = new NhanVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getFloat(10));
                nv.add(nv1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return nv;
    }
    public List<NhanVien> TimKiemGT(String gt){
        List<NhanVien> nv = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from NhanVien where GIOITINH = ?");
            stmt.setString(1,gt);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                NhanVien nv1 = new NhanVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getFloat(10));
                nv.add(nv1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return nv;
    }


}
