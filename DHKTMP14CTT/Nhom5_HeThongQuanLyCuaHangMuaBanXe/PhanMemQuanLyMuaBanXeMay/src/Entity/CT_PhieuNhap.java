package Entity;

public class CT_PhieuNhap {
    private PhieuNhap pNhap;
    private LoaiXe loaiXe;
    private double thue;
    public CT_PhieuNhap(double thue) {
        super();
        this.thue = thue;
    }
    public CT_PhieuNhap() {
        super();
    }
    public PhieuNhap getpNhap() {
        return pNhap;
    }
    public void setpNhap(PhieuNhap pNhap) {
        this.pNhap = pNhap;
    }
    public LoaiXe getLoaiXe() {
        return loaiXe;
    }
    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }
    public double getThue() {
        return thue;
    }
    public void setThue(double thue) {
        this.thue = thue;
    }
    @Override
    public String toString() {
        return "CT_PhieuNhap [pNhap=" + pNhap + ", loaiXe=" + loaiXe + ", thue=" + thue + "]";
    }

}
