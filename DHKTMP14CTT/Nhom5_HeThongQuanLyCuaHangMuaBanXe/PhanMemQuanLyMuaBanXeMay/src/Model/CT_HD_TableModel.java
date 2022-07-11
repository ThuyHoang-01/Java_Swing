package Model;

import Entity.CT_PhieuXuat;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CT_HD_TableModel extends AbstractTableModel {
    private List<CT_PhieuXuat> ds;
    String [] headers = {"Mã Phiếu Xuất","Mã Xe","Thuế","Đơn Giá Xuất"};

    public CT_HD_TableModel(List<CT_PhieuXuat> ds){
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
        CT_PhieuXuat ctpx = ds.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ctpx.getpXuat().getMaPX();
            case 1:
                return ctpx.getXeMay().getMaXe();
            case 2:
                return ctpx.getThue();
            case 3:
                return ctpx.getXeMay().getDonGia();
            default:
                return ctpx;
        }
    }

    }
