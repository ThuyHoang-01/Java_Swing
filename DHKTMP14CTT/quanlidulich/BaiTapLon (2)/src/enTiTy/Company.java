package enTiTy;

public class Company {
	int id;
	String name, phone, email, diaChi, maSoThue;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMaSoThue() {
		return maSoThue;
	}
	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(int id,  String name, String phone, String email, String diaChi, String maSoThue) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.diaChi = diaChi;
		this.maSoThue = maSoThue;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID" + id +"Name" + name + "Phone" + phone + "Email" + email +"Dia Chi" + diaChi + "Ma so thue" + maSoThue ;
	}
}
