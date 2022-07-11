package Entity;


public class NhaCungCap {
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private int dienThoai;
    private String eMail;
    public NhaCungCap() {
        super();
    }
    public NhaCungCap(String maNCC) {
        super();
        this.maNCC = maNCC;
    }
    public NhaCungCap(String maNCC, String tenNCC, String diaChi, int dienThoai, String eMail) {
        super();
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.eMail = eMail;
    }
    public String getMaNCC() {
        return maNCC;
    }
    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }
    public String getTenNCC() {
        return tenNCC;
    }
    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
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
        result = prime * result + ((maNCC == null) ? 0 : maNCC.hashCode());
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
        NhaCungCap other = (NhaCungCap) obj;
        if (maNCC == null) {
            if (other.maNCC != null)
                return false;
        } else if (!maNCC.equals(other.maNCC))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", diaChi=" + diaChi + ", dienThoai=" + dienThoai
                + ", eMail=" + eMail + "]";
    }


}

