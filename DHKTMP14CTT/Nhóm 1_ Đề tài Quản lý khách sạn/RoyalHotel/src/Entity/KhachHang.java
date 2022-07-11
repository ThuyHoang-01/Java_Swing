package Entity;

public class KhachHang {
	String tenKH;
	int maLoaiKH;
    int tuoi;
    String gioitinh;
    String sdt;
    String CMND;
    
    
    public int getMaLoaiKH() {
		return maLoaiKH;
	}

	public void setMaLoaiKH(int maLoaiKH) {
		this.maLoaiKH = maLoaiKH;
	}

	public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

}
