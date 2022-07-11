package baiTapLon;

import java.sql.Date;

public class ThongTinDatPhong {
	private int maBooking;
	private Date ngayDen;
	private Date ngayDi;
	private float  gia;
	public int getMaBooking() {
		return maBooking;
	}
	public void setMaBooking(int maBooking) {
		this.maBooking = maBooking;
	}
	public Date getNgayDen() {
		return ngayDen;
	}
	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}
	public Date getNgayDi() {
		return ngayDi;
	}
	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public ThongTinDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThongTinDatPhong(int maBooking, Date ngayDen, Date ngayDi, float gia) {
		super();
		this.maBooking = maBooking;
		this.ngayDen = ngayDen;
		this.ngayDi = ngayDi;
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "ThongTinDatPhong [maBooking=" + maBooking + ", ngayDen=" + ngayDen + ", ngayDi=" + ngayDi + ", gia="
				+ gia + "]";
	}
	
}
