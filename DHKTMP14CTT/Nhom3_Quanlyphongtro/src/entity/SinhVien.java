package entity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SinhVien {
	private String maSV, hoSV, tenSV, queQuan;
	private String birth;
	private String gender;
	//
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
	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoSV=" + hoSV + ", tenSV=" + tenSV + ", queQuan=" + queQuan + ", birth="
				+ birth + ", gender=" + gender + "]";
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SinhVien(String maSV, String hoSV, String tenSV, String queQuan, String birth, String gender) {
		super();
		this.maSV = maSV;
		this.hoSV = hoSV;
		this.tenSV = tenSV;
		this.queQuan = queQuan;
		this.birth = birth;
		this.gender = gender;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSV == null) ? 0 : maSV.hashCode());
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
		SinhVien other = (SinhVien) obj;
		if (maSV == null) {
			if (other.maSV != null)
				return false;
		} else if (!maSV.equals(other.maSV))
			return false;
		return true;
	}
	
	
}

