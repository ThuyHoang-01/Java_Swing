package Model;

import Entity.KhachHang;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class KHTableModel extends AbstractTableModel {

    private List<KhachHang> ds;
    String [] headers = {"Mã Khách Hàng","Tên Khách Hàng","Giới Tính","Địa Chỉ","Điện Thoại","Email"};

    public KHTableModel(List<KhachHang> ds){
        super();
        this.ds = ds;
    }
    public String getColumnName(int column){
        return headers[column];
    }
    @Override
    public int getRowCount() {
        return ds.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KhachHang kh = ds.get(rowIndex);
        switch (columnIndex){
            case 0:
                return kh.getMaKH();
            case 1:
                return kh.getTenKH();
            case 2:
                return kh.getGioiTinh();
            case 3:
                return kh.getDiaChi();
            case 4:
                return kh.getDienThoai();
            case 5:
                return kh.geteMail();
            default:
                return kh;
        }


    }
}
