package Dao;

import Entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DS_CT_PhieuXuat {
    private Connection con ;
    public DS_CT_PhieuXuat(){
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


    public boolean addPhieuXuat(CT_PhieuXuat ctPX) {
        try {
            PreparedStatement pnAdd = con.prepareStatement("INSERT INTO CTPXuat VALUES(?,?,?,?)");
            pnAdd.setString(1,ctPX.getpXuat().getMaPX());
            pnAdd.setString(2,ctPX.getXeMay().getMaXe());
            pnAdd.setDouble(3,ctPX.getThue());
            pnAdd.setDouble(4,ctPX.getXeMay().getDonGia());

            int n = pnAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public CT_PhieuXuat TimKiemPX(String maPX){
        CT_PhieuXuat ctpx = null;
        DS_PhieuXuat pxDao = new DS_PhieuXuat();
        DS_XeMay xeDao = new DS_XeMay();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from CTPXuat where MAPX = ?");
            stmt.setString(1,maPX);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ctpx = new CT_PhieuXuat(rs.getDouble(3));
                ctpx.setpXuat(pxDao.TimKiemPX(rs.getString(1)));
                ctpx.setXeMay(xeDao.TimKiemXe(rs.getString(2)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ctpx;
    }

    public List<CT_PhieuXuat> getLS() throws Exception {
        List<CT_PhieuXuat> ds = new ArrayList<>();
        DS_PhieuXuat pxDao =  new DS_PhieuXuat();
        DS_XeMay xeDao = new DS_XeMay();
        try {
            //PreparedStatement stmt = con.prepareStatement("select * from KhachHang");
            ResultSet rs = getResultSet("select_CTPX");
            while(rs.next()){
                CT_PhieuXuat ctpx =new CT_PhieuXuat(rs.getDouble(3));
                ctpx.setpXuat(pxDao.TimKiemPX(rs.getString(1)));
                ctpx.setXeMay(xeDao.TimKiemXe(rs.getString(2)));
                ds.add(ctpx);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
    public List<CT_PhieuXuat> TimKiem(String maPX){
        DS_PhieuXuat pxDao = new DS_PhieuXuat();
        DS_XeMay xeDao = new DS_XeMay();
        List<CT_PhieuXuat> ls = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from CTPXuat where MAPX = ?");
            stmt.setString(1,maPX);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                CT_PhieuXuat ctpx = new CT_PhieuXuat(rs.getDouble(3));
                ctpx.setpXuat(pxDao.TimKiemPX(rs.getString(1)));
                ctpx.setXeMay(xeDao.TimKiemXe(rs.getString(2)));
                ls.add(ctpx);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ls;
    }
}
