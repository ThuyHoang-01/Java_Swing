package Model;

import Entity.XeMay;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class XeTableModel extends AbstractTableModel {

    private List<XeMay> ds;
    String [] headers = {"Mã Xe","Mã Loại","Số Khung","Số Máy","Màu Xe","Đơn Giá"};

    public XeTableModel(List<XeMay> ds){
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
        XeMay xm = ds.get(rowIndex);
        switch (columnIndex){
            case 0:
                return xm.getMaXe();
            case 1:
                return xm.getMaLoai();
            case 2:
                return xm.getSoKhung();
            case 3:
                return xm.getSoMay();
            case 4:
                return xm.getMauXe();
            case 5:
                return xm.getDonGia();
            default:
                return xm;
        }


    }
}
