package enTiTy;

public class KhachHang {
	int ID;
	String LastName, Email, Phone, User, Password;
	public int getID() {
		return ID;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public KhachHang(int iD, String lastName, String email, String phone, String user, String password) {
		super();
		ID = iD;
		LastName = lastName;
		Email = email;
		Phone = phone;
		User = user;
		Password = password;
	}
	@Override
	public String toString() {

		return "ID" + ID + "Tên"+ LastName + "Email" + Email + "Phone" + Phone +
				"Password" + Password;
	}
}
