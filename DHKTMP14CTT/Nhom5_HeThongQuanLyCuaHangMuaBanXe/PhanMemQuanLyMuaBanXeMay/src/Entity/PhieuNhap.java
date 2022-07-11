package Entity;

public class PhieuNhap {
    private String maPN;
    private NhaCungCap nhaCC;
    private NhanVien nhanVien;
    private String ngayNhap;
    public PhieuNhap(String maPN, String ngayNhap) {
        super();
        this.maPN = maPN;
        this.ngayNhap = ngayNhap;
    }
    public PhieuNhap(String maPN) {
        super();
        this.maPN = maPN;
    }
    public PhieuNhap() {
        super();
    }
    public String getMaPN() {
        return maPN;
    }
    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }
    public NhaCungCap getNhaCC() {
        return nhaCC;
    }
    public void setNhaCC(NhaCungCap nhaCC) {
        this.nhaCC = nhaCC;
    }
    public NhanVien getNhanVien() {
        return nhanVien;
    }
    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
    public String getNgayNhap() {
        return ngayNhap;
    }
    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    @Override
    public String toString() {
        return "PhieuNhap [maPN=" + maPN + ", nhaCC=" + nhaCC + ", nhanVien=" + nhanVien + ", ngayNhap=" + ngayNhap
                + "]";
    }

}
