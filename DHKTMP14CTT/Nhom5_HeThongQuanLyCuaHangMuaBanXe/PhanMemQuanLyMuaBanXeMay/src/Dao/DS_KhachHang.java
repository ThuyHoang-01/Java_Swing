package Dao;

import Database.Conection_DB;
import Entity.KhachHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DS_KhachHang {
    private Connection con ;
    Conection_DB db = new Conection_DB();

    public DS_KhachHang() {
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


    public boolean addKhachHang(KhachHang kh) {
        try {
            PreparedStatement khAdd = con.prepareStatement("INSERT INTO KhachHang VALUES(?,?,?,?,?,?)");
            khAdd.setString(1,kh.getMaKH());
            khAdd.setString(2,kh.getTenKH());
            khAdd.setString(3,kh.getGioiTinh());
            khAdd.setString(4,kh.getDiaChi());
            khAdd.setInt(5,kh.getDienThoai());
            khAdd.setString(6,kh.geteMail());

            int n = khAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean deleteKH(String maKH) {
        try {
            PreparedStatement stmt = con.prepareStatement("delete from KhachHang where MAKHACHHANG = ?");
            stmt.setString(1, maKH);
            int n = stmt.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean updateKhachHang(String maKH, KhachHang kh) {
        String sql = "update KhachHang set TENKHACHHANG = ?, "
                + "GIOITINH = ?,DIACHI = ? ,DIENTHOAI = ?,EMAIL = ? where MAKHACHHANG = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, kh.getTenKH());
            stmt.setString(2, kh.getGioiTinh());
            stmt.setString(3, kh.getDiaChi());
            stmt.setInt(4, kh.getDienThoai());
            stmt.setString(5, kh.geteMail());
            stmt.setString(6, maKH);

            int n = stmt.executeUpdate();
            if(n > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<KhachHang> getLS() throws Exception {
        List<KhachHang> ds = new ArrayList<>();
        try {
            //PreparedStatement stmt = con.prepareStatement("select * from KhachHang");
            ResultSet rs = getResultSet("select_KH");
            while(rs.next()){
                KhachHang kh =new KhachHang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getInt(5),rs.getString(6));
                ds.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
    public List<KhachHang> TimKiem(String maKH){
        List<KhachHang> kh = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from KhachHang where MAKHACHHANG = ?");
            stmt.setString(1,maKH);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                KhachHang kh1 = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6));
                kh.add(kh1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return kh;
    }
    public KhachHang TimKiemKH(String maKH){
        KhachHang kh1 = null;
        try{

            PreparedStatement stmt = con.prepareStatement("select * from KhachHang where MAKHACHHANG = ?");
            stmt.setString(1,maKH);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                kh1 = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return kh1;
    }

    public List<KhachHang> TimKiemTen(String ten){
        List<KhachHang> kh = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from KhachHang where TENKHACHHANG = ?");
            stmt.setString(1,ten);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                KhachHang kh1 = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6));
                kh.add(kh1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return kh;
    }
    public List<KhachHang> TimKiemGT(String gt){
        List<KhachHang> kh = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from KhachHang where GIOITINH = ?");
            stmt.setString(1,gt);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                KhachHang kh1 = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6));
                kh.add(kh1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return kh;
    }

}
