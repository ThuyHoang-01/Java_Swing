package Entity;
public class NhanVien {
    private String maNV;
    private String tenNV;
    private String gioiTinh;
    private int soDT;
    private int soCMND;
    private String ngaySinh;
    private String ngayVaoLam;
    private String chucVu;
    private String diaChi;
    private double luongCB;
    public NhanVien() {
        super();
    }
    public NhanVien(String maNV, String tenNV, String gioiTinh, int soDT, int soCMND, String ngaySinh,
                    String ngayVaoLam, String chucVu, String diaChi, double luongCB) {
        super();
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
        this.soCMND = soCMND;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.chucVu = chucVu;
        this.diaChi = diaChi;
        this.luongCB = luongCB;
    }
    public NhanVien(String maNV) {
        super();
        this.maNV = maNV;
    }
    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public String getTenNV() {
        return tenNV;
    }
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public int getSoDT() {
        return soDT;
    }
    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }
    public int getSoCMND() {
        return soCMND;
    }
    public void setSoCMND(int soCMND) {
        this.soCMND = soCMND;
    }
    public String getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getNgayVaoLam() {
        return ngayVaoLam;
    }
    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
    public String getChucVu() {
        return chucVu;
    }
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public Double getLuongCB() {
        return luongCB;
    }
    public void setLuongCB(double luongCB) {
        this.luongCB = luongCB;
    }
    @Override
    public String toString() {
        return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", soDT=" + soDT + ", soCMND="
                + soCMND + ", ngaySinh=" + ngaySinh + ", ngayVaoLam=" + ngayVaoLam + ", chucVu=" + chucVu + ", diaChi="
                + diaChi + ", luongCB=" + luongCB + "]";
    }


}