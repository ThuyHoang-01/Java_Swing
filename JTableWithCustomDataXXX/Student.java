package sesion05.JTableWithCustomDataXXX;

import java.io.Serializable;

public class Student implements Serializable{
	
	private String MaSV;
	private String HoTen;
	private boolean GioiTinh;
	private String MaLop;

	public Student(String ma, String ht, boolean gt, String ml) {
		MaSV = ma;
		HoTen = ht;
		GioiTinh = gt;
		MaLop = ml;
	}
	public Student(){
		this("","",false,"");
	}
	
	public String getID() {
		return MaSV;
	}
	public void setID(String maSV) {
		MaSV = maSV;
	}
	public String getName() {
		return HoTen;
	}
	public void setName(String hoTen) {
		HoTen = hoTen;
	}
	public boolean getGender() {
		return GioiTinh;
	}
	public void setGender(boolean gt) {
		GioiTinh = gt;
	}
	public String getClassID() {
		return MaLop;
	}
	public void setClassID(String ml) {
		MaLop = ml;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MaSV == null) ? 0 : MaSV.hashCode());
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
		Student other = (Student) obj;
		if (MaSV == null) {
		if (other.MaSV != null)
		return false;
		} else if (!MaSV.equals(other.MaSV))
		return false;
		return true;
	}

	@Override
	public String toString() {
		String gt;
		if (GioiTinh) gt = "Nam";
		else
			gt="Nu";
		return MaSV + " - " + HoTen + " - " + gt + " - " + MaLop;
	}
}