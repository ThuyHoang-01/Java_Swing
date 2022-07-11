package Model;

import Entity.NhanVien;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class NVTableModel extends AbstractTableModel {

    private List<NhanVien> ds;
    String [] headers = {"Mã Nhân Viên","Tên Nhân Viên","Giới Tính","Số ĐT","Số CMND","Ngày Sinh","Ngày Vào Làm","Chức Vụ","Địa Chỉ","Lương Cơ Bản"};

    public NVTableModel(List<NhanVien> ds){
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
        NhanVien nv = ds.get(rowIndex);
        switch (columnIndex){
            case 0:
                return nv.getMaNV();
            case 1:
                return nv.getTenNV();
            case 2:
                return nv.getGioiTinh();
            case 3:
                return nv.getSoDT();
            case 4:
                return nv.getSoCMND();
            case 5:
                return nv.getNgaySinh();
            case 6:
                return nv.getNgayVaoLam();
            case 7:
                return nv.getChucVu();
            case 8:
                return nv.getDiaChi();
            case 9:
                return nv.getLuongCB();
            default:
                return nv;
        }


    }
}
