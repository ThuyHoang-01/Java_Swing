package Model;

import Entity.PhieuNhap;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PhieuNhapModel extends AbstractTableModel {
    private List<PhieuNhap> ds;
    String [] headers = {"Mã Phiếu Nhập","Mã Nhà Cung Cấp","Mã Nhân Viên","Ngày Nhập"};

    public PhieuNhapModel(List<PhieuNhap> ds){
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
        PhieuNhap pn = ds.get(rowIndex);
        switch (columnIndex){
            case 0:
                return pn.getMaPN();
            case 1:
                return pn.getNhaCC().getMaNCC();
            case 2:
                return pn.getNhanVien().getMaNV();
            case 3:
                return pn.getNgayNhap();
            default:
                return pn;
        }


    }
}
