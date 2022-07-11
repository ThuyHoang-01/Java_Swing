package Entity;

public class LoaiXe {
    private String maLoai;
    private String tenLoaiXe;
    private String hangSX;
    private int soLuong;
    private int dungTich;
    private int tocDoTD;
    private double donGia;
    public LoaiXe() {
        super();
    }
    public LoaiXe(String maLoai) {
        super();
        this.maLoai = maLoai;
    }
    public LoaiXe(String maLoai, String tenLoaiXe, String hangSX, int soLuong, int dungTich, int tocDoTD,
                  double donGia) {
        super();
        this.maLoai = maLoai;
        this.tenLoaiXe = tenLoaiXe;
        this.hangSX = hangSX;
        this.soLuong = soLuong;
        this.dungTich = dungTich;
        this.tocDoTD = tocDoTD;
        this.donGia = donGia;
    }
    public String getMaLoai() {
        return maLoai;
    }
    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
    public String getTenLoaiXe() {
        return tenLoaiXe;
    }
    public void setTenLoaiXe(String tenLoaiXe) {
        this.tenLoaiXe = tenLoaiXe;
    }
    public String getHangSX() {
        return hangSX;
    }
    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public int getDungTich() {
        return dungTich;
    }
    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }
    public int getTocDoTD() {
        return tocDoTD;
    }
    public void setTocDoTD(int tocDoTD) {
        this.tocDoTD = tocDoTD;
    }
    public double getDonGia() {
        return donGia;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    @Override
    public String toString() {
        return "LoaiXe [maLoai=" + maLoai + ", tenLoaiXe=" + tenLoaiXe + ", hangSX=" + hangSX + ", soLuong=" + soLuong
                + ", dungTich=" + dungTich + ", tocDoTD=" + tocDoTD + ", donGia=" + donGia + "]";
    }
}
