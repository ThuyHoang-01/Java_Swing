package Dao;
import Entity.XeMay;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DS_XeMay {
    private Connection con ;

    public DS_XeMay() {

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

    public boolean addXeMay(XeMay xe) {

        try {
            PreparedStatement xeAdd = con.prepareStatement("INSERT INTO [dbo].[XeMay] VALUES(?,?,?,?,?,?)");
            xeAdd.setString(1,xe.getMaXe());
            xeAdd.setString(2,xe.getMaLoai());
            xeAdd.setInt(3,xe.getSoKhung());
            xeAdd.setInt(4,xe.getSoMay());
            xeAdd.setString(5,xe.getMauXe());
            xeAdd.setDouble(6,xe.getDonGia());

            int n = xeAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean deleteXe(String maXe) {

        try {
            PreparedStatement stmt = con.prepareStatement("delete from XeMay where MAXE = ?");
            stmt.setString(1, maXe);
            int n = stmt.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean updateXeMay(String maXe, XeMay xm) {
        String sql = "update XeMay set MALOAI = ?, "
                + "SOKHUNG = ? ,SOMAY = ?,MAUXE = ? ,DONGIA = ? where MAXE = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,xm.getMaLoai());
            stmt.setInt(2,xm.getSoKhung());
            stmt.setInt(3,xm.getSoMay());
            stmt.setString(4,xm.getMauXe());
            stmt.setDouble(5,xm.getDonGia());
            stmt.setString(6, maXe);

            int n = stmt.executeUpdate();
            if(n > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public List<XeMay> getLS() {
        List<XeMay> ds = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("select * from XeMay");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                XeMay xe =new XeMay(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
                        rs.getString(5),rs.getDouble(6));
                ds.add(xe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
    public List<XeMay> TimKiem(String maXe){
        List<XeMay> xe = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from XeMay where MAXE = ?");
            stmt.setString(1,maXe);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                XeMay xe1 = new XeMay(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
                        rs.getString(5),rs.getDouble(6));
                xe.add(xe1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return xe;
    }

    public XeMay TimKiemXe(String maXe){
        XeMay xe1 = null;
        try{
            PreparedStatement stmt = con.prepareStatement("select * from XeMay where MAXE = ?");
            stmt.setString(1,maXe);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                xe1 = new XeMay(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
                        rs.getString(5),rs.getDouble(6));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return xe1;
    }

}
