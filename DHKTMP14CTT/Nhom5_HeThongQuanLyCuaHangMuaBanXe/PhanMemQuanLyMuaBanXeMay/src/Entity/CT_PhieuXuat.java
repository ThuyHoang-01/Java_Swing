package Entity;

public class CT_PhieuXuat {
    private PhieuXuat pXuat;
    private XeMay xeMay;
    private double thue;
    public CT_PhieuXuat(double thue) {
        super();
        this.thue = thue;
    }
    public CT_PhieuXuat() {
        super();
    }
    public PhieuXuat getpXuat() {
        return pXuat;
    }
    public void setpXuat(PhieuXuat pXuat) {
        this.pXuat = pXuat;
    }
    public XeMay getXeMay() {
        return xeMay;
    }
    public void setXeMay(XeMay xeMay) {
        this.xeMay = xeMay;
    }
    public double getThue() {
        return thue;
    }
    public void setThue(double thue) {
        this.thue = thue;
    }
    @Override
    public String toString() {
        return "CT_PhieuXuat [pXuat=" + pXuat + ", xeMay=" + xeMay + ", thue=" + thue + "]";
    }

}
