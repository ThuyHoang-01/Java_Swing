package Dao;

import Entity.CT_PhieuNhap;
import Entity.LoaiXe;
import Entity.PhieuNhap;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DS_CT_PhieuNhap {
    private Connection con ;
    public DS_CT_PhieuNhap(){
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


    public boolean addCTPhieuNhap(CT_PhieuNhap ctPN) {
        try {
            PreparedStatement pnAdd = con.prepareStatement("INSERT INTO CTPNhap VALUES(?,?,?,?,?,?)");
            pnAdd.setString(1,ctPN.getpNhap().getMaPN());
            pnAdd.setString(2,ctPN.getLoaiXe().getMaLoai());
            pnAdd.setString(3,ctPN.getLoaiXe().getTenLoaiXe());
            pnAdd.setInt(4,ctPN.getLoaiXe().getSoLuong());
            pnAdd.setDouble(6,ctPN.getLoaiXe().getDonGia());
            pnAdd.setDouble(5,ctPN.getThue());

            int n = pnAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public CT_PhieuNhap TimKiemPN(String maPN){
        CT_PhieuNhap ctpn = null;
        DS_PhieuNhap pnDao = new DS_PhieuNhap();
        DS_LoaiXe lxDao = new DS_LoaiXe();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from CTPNhap where MAPN = ?");
            stmt.setString(1,maPN);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ctpn = new CT_PhieuNhap(rs.getDouble(5));
                ctpn.setpNhap(pnDao.TimKiemPN(rs.getString(1)));
                ctpn.setLoaiXe(lxDao.TimKiemLX(rs.getString(2)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ctpn;
    }
    public List<CT_PhieuNhap> getLS() throws Exception {
        List<CT_PhieuNhap> ds = new ArrayList<>();
        DS_PhieuNhap pnDao =  new DS_PhieuNhap();
        DS_LoaiXe lxDao = new DS_LoaiXe();
        try {
            //PreparedStatement stmt = con.prepareStatement("select * from KhachHang");
            ResultSet rs = getResultSet("select_CTPN");
            while(rs.next()){
                CT_PhieuNhap ctpn = new CT_PhieuNhap(rs.getDouble(5));
                ctpn.setpNhap(pnDao.TimKiemPN(rs.getString(1)));
                ctpn.setLoaiXe(lxDao.TimKiemLX(rs.getString(2)));
                ds.add(ctpn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
}
