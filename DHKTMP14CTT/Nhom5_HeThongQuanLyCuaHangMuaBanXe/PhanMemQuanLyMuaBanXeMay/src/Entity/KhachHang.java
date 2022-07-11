package Entity;


public class KhachHang {
    private String maKH;
    private String tenKH;
    private String gioiTinh;
    private String diaChi;
    private int dienThoai;
    private String eMail;
    public KhachHang() {
        super();
    }
    public KhachHang(String maKH){
        this.maKH = maKH;
    }
    public KhachHang(String maKH, String tenKH, String gioiTinh, String diaChi, int dienThoai, String eMail) {
        super();
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.eMail = eMail;
    }
    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public String getTenKH() {
        return tenKH;
    }
    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.tenKH = gioiTinh;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public int getDienThoai() {
        return dienThoai;
    }
    public void setDienThoai(int dienThoai) {
        this.dienThoai = dienThoai;
    }
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        KhachHang other = (KhachHang) obj;
        if (maKH == null) {
            if (other.maKH != null)
                return false;
        } else if (!maKH.equals(other.maKH))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ",gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", dienThoai=" + dienThoai
                + ", eMail=" + eMail + "]";
    }


}

