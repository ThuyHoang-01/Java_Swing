package DoiTuong;

import java.sql.Date;

public class ChiTietCongTrinh {
    private String IDNhanVien,IDCongTrinh;
    private Date NgayBatDau,NgayKetThuc;
    
    public ChiTietCongTrinh(String iDNhanVien, String iDCongTrinh, Date ngayBatDau, Date ngayKetThuc) {
		super();
		IDNhanVien = iDNhanVien;
		IDCongTrinh = iDCongTrinh;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
	}

	public String getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(String iDNhanVien) {
        IDNhanVien = iDNhanVien;
    }

    public String getIDCongTrinh() {
        return IDCongTrinh;
    }

    public void setIDCongTrinh(String iDCongTrinh) {
        IDCongTrinh = iDCongTrinh;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        NgayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        NgayKetThuc = ngayKetThuc;
    }
    
}