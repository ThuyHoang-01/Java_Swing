package DoiTuong;

import java.sql.Date;

public class CongTrinh {
    private String ID,ten,diaDiem;
    private Date ngayKhoiCong,ngayCapPhep,ngayDuKienHT;

    
    
    public CongTrinh(String iD, String ten, String diaDiem, Date ngayKhoiCong, Date ngayCapPhep, Date ngayDuKienHT) {
		super();
		ID = iD;
		this.ten = ten;
		this.diaDiem = diaDiem;
		this.ngayKhoiCong = ngayKhoiCong;
		this.ngayCapPhep = ngayCapPhep;
		this.ngayDuKienHT = ngayDuKienHT;
	}

	public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public Date getNgayKhoiCong() {
        return ngayKhoiCong;
    }

    public void setNgayKhoiCong(Date ngayKhoiCong) {
        this.ngayKhoiCong = ngayKhoiCong;
    }

    public Date getNgayCapPhep() {
        return ngayCapPhep;
    }

    public void setNgayCapPhep(Date ngayCapPhep) {
        this.ngayCapPhep = ngayCapPhep;
    }

    public Date getNgayDuKienHT() {
        return ngayDuKienHT;
    }

    public void setNgayDuKienHT(Date ngayDuKienHT) {
        this.ngayDuKienHT = ngayDuKienHT;
    }

    
}