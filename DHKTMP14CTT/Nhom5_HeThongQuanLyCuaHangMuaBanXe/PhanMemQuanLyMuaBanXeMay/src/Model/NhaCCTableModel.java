package Model;

import Entity.NhaCungCap;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class NhaCCTableModel extends AbstractTableModel {

    private List<NhaCungCap> ds;
    String [] headers = {"Mã Nhà Cung Cấp","Tên Nhà Cung Cấp","Địa Chỉ","Điện Thoại","Email"};

    public NhaCCTableModel(List<NhaCungCap> ds){
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
        NhaCungCap ncc = ds.get(rowIndex);
        switch (columnIndex){
            case 0:
                return ncc.getMaNCC();
            case 1:
                return ncc.getTenNCC();
            case 2:
                return ncc.getDiaChi();
            case 3:
                return ncc.getDienThoai();
            case 4:
                return ncc.geteMail();
            default:
                return ncc;
        }


    }
}
