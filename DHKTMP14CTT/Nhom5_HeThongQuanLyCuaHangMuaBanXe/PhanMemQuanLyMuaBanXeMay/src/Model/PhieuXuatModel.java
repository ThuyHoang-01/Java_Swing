package Model;

import Entity.PhieuXuat;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PhieuXuatModel extends AbstractTableModel {
    private List<PhieuXuat> ds;
    String [] headers = {"Mã Phiếu Xuất","Ngày Xuất","Mã Khách Hàng","Mã Nhân Viên"};

    public PhieuXuatModel(List<PhieuXuat> ds){
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
        PhieuXuat px = ds.get(rowIndex);
        switch (columnIndex){
            case 0:
                return px.getMaPX();
            case 1:
                return px.getNgayXuat();
            case 2:
                return px.getKhachHang().getMaKH();
            case 3:
                return px.getNhanVien().getMaNV();
            default:
                return px;
        }


    }
}
