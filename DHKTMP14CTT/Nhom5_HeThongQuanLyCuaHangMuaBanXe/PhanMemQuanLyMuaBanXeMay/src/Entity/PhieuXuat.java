package Entity;

public class PhieuXuat {
    private String maPX;
    private String ngayXuat;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    public PhieuXuat(String maPX, String ngayXuat) {
        super();
        this.maPX = maPX;
        this.ngayXuat = ngayXuat;
    }
    public PhieuXuat() {
        super();
    }
    public PhieuXuat(String maPX) {
        super();
        this.maPX = maPX;
    }
    public String getMaPX() {
        return maPX;
    }
    public void setMaPX(String maPX) {
        this.maPX = maPX;
    }
    public String getNgayXuat() {
        return ngayXuat;
    }
    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }
    public KhachHang getKhachHang() {
        return khachHang;
    }
    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
    public NhanVien getNhanVien() {
        return nhanVien;
    }
    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
    @Override
    public String toString() {
        return "PhieuXuat [maPX=" + maPX + ", ngayXuat=" + ngayXuat + ", khachHang=" + khachHang + ", nhanVien="
                + nhanVien + "]";
    }


}
