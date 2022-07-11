package Dao;

import Entity.NhaCungCap;
import Entity.NhanVien;
import Entity.PhieuNhap;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DS_PhieuNhap {
    private Connection con ;
    public DS_PhieuNhap(){
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


    public boolean addPhieuNhap(PhieuNhap pn) {
        try {
            PreparedStatement pnAdd = con.prepareStatement("INSERT INTO PNhap VALUES(?,?,?,?)");
            pnAdd.setString(1,pn.getMaPN());
            pnAdd.setString(2,pn.getNhaCC().getMaNCC());
            pnAdd.setString(3,pn.getNhanVien().getMaNV());
            pnAdd.setString(4,pn.getNgayNhap());

            int n = pnAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean deletePhieuNhap(String maPN) {
        try {
            PreparedStatement stmt = con.prepareStatement("delete from PhieuNhap where MaPN = ?");
            stmt.setString(1, maPN);
            int n = stmt.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
//    public boolean updateKhachHang(String maKH, KhachHang kh) {
//        String sql = "update KhachHang set TENKHACHHANG = ?, "
//                + "GIOITINH = ?,DIACHI = ? ,DIENTHOAI = ?,EMAIL = ? where MAKHACHHANG = ?";
//        try {
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1, kh.getTenKH());
//            stmt.setString(2, kh.getGioiTinh());
//            stmt.setString(3, kh.getDiaChi());
//            stmt.setInt(4, kh.getDienThoai());
//            stmt.setString(5, kh.geteMail());
//            stmt.setString(6, maKH);
//
//            int n = stmt.executeUpdate();
//            if(n > 0)
//                return true;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//
    public List<PhieuNhap> getLS() throws Exception {
        List<PhieuNhap> ds = new ArrayList<>();
        try {
            //PreparedStatement stmt = con.prepareStatement("select * from KhachHang");
            ResultSet rs = getResultSet("select_PN");
            while(rs.next()){
                PhieuNhap pn =new PhieuNhap(rs.getString(1),rs.getString(4));
                pn.setNhaCC(new NhaCungCap(rs.getString(2)));
                pn.setNhanVien(new NhanVien(rs.getString(3)));
                ds.add(pn);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }

        return ds;
    }
//    public List<KhachHang> TimKiem(String maKH){
//        List<KhachHang> kh = new ArrayList<>();
//        try{
//            PreparedStatement stmt = con.prepareStatement("select * from KhachHang where MAKHACHHANG = ?");
//            stmt.setString(1,maKH);
//            ResultSet rs = stmt.executeQuery();
//            while(rs.next()) {
//                KhachHang kh1 = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
//                        rs.getInt(5), rs.getString(6));
//                kh.add(kh1);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return kh;
//    }

    public List<PhieuNhap> TimKiem(String maPN){
        List<PhieuNhap> pn = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from PNhap where MAPN = ?");
            stmt.setString(1,maPN);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                PhieuNhap pn1 = new PhieuNhap(rs.getString(1),rs.getString(4));
                pn1.setNhaCC(new NhaCungCap(rs.getString(2)));
                pn1.setNhanVien(new NhanVien(rs.getString(3)));
                pn.add(pn1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pn;
    }
    public PhieuNhap TimKiemPN(String maPN){
        PhieuNhap pn = null;
        DS_NhaCC nccDao = new DS_NhaCC();
        DS_NhanVien nvDao = new DS_NhanVien();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from PNhap where MAPN = ?");
            stmt.setString(1,maPN);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                 pn = new PhieuNhap(rs.getString(1),rs.getString(4));
                pn.setNhaCC(nccDao.TimKiemNCC(rs.getString(2)));
                pn.setNhanVien(nvDao.TimKiemNV(rs.getString(3)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pn;
    }
}
