package Entity;

public class Login {
    private String ho;
    private String ten;
    private String taiKhoan;
    private String mail;
    private String matKhau;
    private String gioiTinh;
    public Login() {
        super();
    }
    public Login(String ho, String ten, String taiKhoan, String mail, String matKhau, String gioiTinh) {
        super();
        this.ho = ho;
        this.ten = ten;
        this.taiKhoan = taiKhoan;
        this.mail = mail;
        this.matKhau = matKhau;
        this.gioiTinh = gioiTinh;
    }
    public String getHo() {
        return ho;
    }
    public void setHo(String ho) {
        this.ho = ho;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getTaiKhoan() {
        return taiKhoan;
    }
    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    @Override
    public String toString() {
        return "Login [ho=" + ho + ", ten=" + ten + ", taiKhoan=" + taiKhoan + ", mail=" + mail + ", matKhau=" + matKhau
                + ", gioiTinh=" + gioiTinh + "]";
    }



}
