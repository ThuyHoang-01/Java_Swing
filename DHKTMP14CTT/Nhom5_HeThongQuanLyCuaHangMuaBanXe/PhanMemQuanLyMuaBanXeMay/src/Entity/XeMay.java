package Entity;


public class XeMay {
    private String maXe;
    private String maLoai;
    private int soKhung;
    private int soMay;
    private String MauXe;
    private double donGia;
    public XeMay() {
        super();
    }
    public XeMay(String maXe){
        this.maXe = maXe;
    }
    public XeMay(String maXe, String maLoai, int soKhung, int soMay, String mauXe, double donGia) {
        super();
        this.maXe = maXe;
        this.maLoai = maLoai;
        this.soKhung = soKhung;
        this.soMay = soMay;
        MauXe = mauXe;
        this.donGia = donGia;
    }
    public String getMaXe() {
        return maXe;
    }
    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }
    public String getMaLoai() {
        return maLoai;
    }
    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
    public int getSoKhung() {
        return soKhung;
    }
    public void setSoKhung(int soKhung) {
        this.soKhung = soKhung;
    }
    public int getSoMay() {
        return soMay;
    }
    public void setSoMay(int soMay) {
        this.soMay = soMay;
    }
    public String getMauXe() {
        return MauXe;
    }
    public void setMauXe(String mauXe) {
        MauXe = mauXe;
    }
    public double getDonGia() {
        return donGia;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    @Override
    public String toString() {
        return "XeMay [maXe=" + maXe + ", maLoai=" + maLoai + ", soKhung=" + soKhung + ", soMay=" + soMay + ", MauXe="
                + MauXe + ", donGia=" + donGia + "]";
    }
}
