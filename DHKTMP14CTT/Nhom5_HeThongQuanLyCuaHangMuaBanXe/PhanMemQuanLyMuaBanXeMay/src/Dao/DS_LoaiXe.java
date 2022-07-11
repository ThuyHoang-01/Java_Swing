package Dao;

import Entity.LoaiXe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DS_LoaiXe {
    private Connection con ;

    public DS_LoaiXe() {

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

    public boolean addLoaiXe(LoaiXe lx) {

        try {
            PreparedStatement LoaiXeAdd = con.prepareStatement("INSERT INTO [dbo].[LoaiXe] VALUES(?,?,?,?,?,?,?)");
            LoaiXeAdd.setString(1,lx.getMaLoai());
            LoaiXeAdd.setString(2,lx.getTenLoaiXe());
            LoaiXeAdd.setString(3,lx.getHangSX());
            LoaiXeAdd.setInt(4,lx.getSoLuong());
            LoaiXeAdd.setInt(5,lx.getDungTich());
            LoaiXeAdd.setInt(6,lx.getTocDoTD());
            LoaiXeAdd.setDouble(7,lx.getDonGia());

            int n = LoaiXeAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean deleteXe(String maLoai) {

        try {
            PreparedStatement stmt = con.prepareStatement("delete from LoaiXe where MALOAI = ?");
            stmt.setString(1, maLoai);
            int n = stmt.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean updateLoaiXe(String maLoai, LoaiXe lx) {
        String sql = "update LoaiXe set TENLOAIXE = ?, "
                + "HANGSX = ? ,SOLUONG = ?,DUNGTICH = ? ,TOCDOTOIDA = ?, DONGIA = ? where MALOAI = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,lx.getTenLoaiXe());
            stmt.setString(2,lx.getHangSX());
            stmt.setInt(3,lx.getSoLuong());
            stmt.setInt(4,lx.getDungTich());
            stmt.setInt(5,lx.getTocDoTD());
            stmt.setDouble(6,lx.getDonGia());
            stmt.setString(7, maLoai);

            int n = stmt.executeUpdate();
            if(n > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public List<LoaiXe> getLS() {
        List<LoaiXe> ds = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("select * from LOAIXE");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                LoaiXe lx =new LoaiXe(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),
                        rs.getInt(5),rs.getInt(6),rs.getDouble(7));
                ds.add(lx);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
    public List<LoaiXe> TimKiem(String maLoai){
        List<LoaiXe> lx = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from LOAIXE where MALOAI = ?");
            stmt.setString(1,maLoai);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                LoaiXe lx1 = new LoaiXe(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),
                        rs.getInt(5),rs.getInt(6),rs.getDouble(7));
                lx.add(lx1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lx;
    }
    public LoaiXe TimKiemLX(String maLoai){
        LoaiXe lx1 = null;
        try{
            PreparedStatement stmt = con.prepareStatement("select * from LOAIXE where MALOAI = ?");
            stmt.setString(1,maLoai);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                lx1 = new LoaiXe(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),
                        rs.getInt(5),rs.getInt(6),rs.getDouble(7));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lx1;
    }
}
