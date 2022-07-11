package Dao;

import Entity.NhaCungCap;
import Entity.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DS_NhaCC {
    private Connection con ;

    public DS_NhaCC() {

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

    public boolean addNhaCungCap(NhaCungCap ncc) {

        try {
            PreparedStatement nccAdd = con.prepareStatement("INSERT INTO [dbo].[NhaCungCap] VALUES(?,?,?,?,?)");
            nccAdd.setString(1,ncc.getMaNCC());
            nccAdd.setString(2,ncc.getTenNCC());
            nccAdd.setString(3,ncc.getDiaChi());
            nccAdd.setInt(4,ncc.getDienThoai());
            nccAdd.setString(5,ncc.geteMail());

            int n = nccAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean deleteNCC(String maNCC) {

        try {
            PreparedStatement stmt = con.prepareStatement("delete from NhaCungCap where MANHACUNGCAP = ?");
            stmt.setString(1, maNCC);
            int n = stmt.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean updateNCC(String maNCC, NhaCungCap ncc) {
        String sql = "update NhaCungCap set TENNHACUNGCAP = ?, "
                + "DIACHI = ? ,DIENTHOAI = ?,EMAIL = ? where MANHACUNGCAP = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ncc.getTenNCC());
            stmt.setString(2, ncc.getDiaChi());
            stmt.setInt(3, ncc.getDienThoai());
            stmt.setString(4, ncc.geteMail());
            stmt.setString(5, maNCC);

            int n = stmt.executeUpdate();
            if(n > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public List<NhaCungCap> getLS() {
        List<NhaCungCap> ds = new ArrayList<>();
        try {
            //PreparedStatement stmt = con.prepareStatement("select * from NhaCungCap");
            ResultSet rs = getResultSet("select_NCC");
            while(rs.next()){
                NhaCungCap ncc =new NhaCungCap(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getInt(4),rs.getString(5));
                ds.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }
    public List<NhaCungCap> TimKiem(String maNCC){
        List<NhaCungCap> ncc = new ArrayList<>();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from NhaCungCap where MANHACUNGCAP = ?");
            stmt.setString(1,maNCC);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                NhaCungCap ncc1 = new NhaCungCap(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getInt(4),rs.getString(5));
                ncc.add(ncc1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ncc;
    }
    public NhaCungCap TimKiemNCC(String maNCC){
        NhaCungCap ncc1 = null;
        try{
            PreparedStatement stmt = con.prepareStatement("select * from NhaCungCap where MANHACUNGCAP = ?");
            stmt.setString(1,maNCC);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ncc1 = new NhaCungCap(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getInt(4),rs.getString(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ncc1;
    }


}
