package Model;

import Entity.CT_PhieuNhap;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CT_PN_TableModel extends AbstractTableModel {
        private List<CT_PhieuNhap> ds;
        String [] headers = {"Mã Phiếu Nhập","Mã Loại","Tên Loại","Số Lượng Nhập","Thuế","Đơn Giá Nhập"};

        public CT_PN_TableModel(List<CT_PhieuNhap> ds){
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
            CT_PhieuNhap ctpn = ds.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return ctpn.getpNhap().getMaPN();
                case 1:
                    return ctpn.getLoaiXe().getMaLoai();
                case 2:
                    return ctpn.getLoaiXe().getTenLoaiXe();
                case 3:
                    return ctpn.getLoaiXe().getSoLuong();
                case 4:
                    return ctpn.getThue();
                case 5:
                    return ctpn.getLoaiXe().getDonGia();
                default:
                    return ctpn;
            }
        }

}
