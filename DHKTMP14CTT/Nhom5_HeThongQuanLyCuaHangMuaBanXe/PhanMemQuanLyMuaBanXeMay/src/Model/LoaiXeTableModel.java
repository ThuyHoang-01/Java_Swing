package Model;

import Entity.LoaiXe;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LoaiXeTableModel extends AbstractTableModel {

    private List<LoaiXe> ds;
    String [] headers = {"Mã Loại Xe","Tên Loại Xe","Hãng Sản Xuất","Số Lượng","Dung Tích","Tốc Độ Tối Đa","Đơn Giá"};

    public LoaiXeTableModel(List<LoaiXe> ds){
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
        LoaiXe lx = ds.get(rowIndex);
        switch (columnIndex){
            case 0:
                return lx.getMaLoai();
            case 1:
                return lx.getTenLoaiXe();
            case 2:
                return lx.getHangSX();
            case 3:
                return lx.getSoLuong();
            case 4:
                return lx.getDungTich();
            case 5:
                return lx.getTocDoTD();
            case 6:
                return lx.getDonGia();
            default:
                return lx;
        }


    }
}
