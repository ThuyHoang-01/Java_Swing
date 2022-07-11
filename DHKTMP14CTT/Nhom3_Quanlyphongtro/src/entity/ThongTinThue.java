package entity;

public class ThongTinThue {
	private String maSV, hoSV, tenSV, queQuan;
	private String birth;
	private String gender;
	private String tenNT, chuTro, soDT;
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoSV() {
		return hoSV;
	}
	public void setHoSV(String hoSV) {
		this.hoSV = hoSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTenNT() {
		return tenNT;
	}
	public void setTenNT(String tenNT) {
		this.tenNT = tenNT;
	}
	public String getChuTro() {
		return chuTro;
	}
	public void setChuTro(String chuTro) {
		this.chuTro = chuTro;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public ThongTinThue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThongTinThue(String maSV, String hoSV, String tenSV, String queQuan, String birth, String gender,
			String tenNT, String chuTro, String soDT) {
		super();
		this.maSV = maSV;
		this.hoSV = hoSV;
		this.tenSV = tenSV;
		this.queQuan = queQuan;
		this.birth = birth;
		this.gender = gender;
		this.tenNT = tenNT;
		this.chuTro = chuTro;
		this.soDT = soDT;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSV == null) ? 0 : maSV.hashCode());
		result = prime * result + ((tenNT == null) ? 0 : tenNT.hashCode());
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
		ThongTinThue other = (ThongTinThue) obj;
		if (maSV == null) {
			if (other.maSV != null)
				return false;
		} else if (!maSV.equals(other.maSV))
			return false;
		if (tenNT == null) {
			if (other.tenNT != null)
				return false;
		} else if (!tenNT.equals(other.tenNT))
			return false;
		return true;
	}
	
}
