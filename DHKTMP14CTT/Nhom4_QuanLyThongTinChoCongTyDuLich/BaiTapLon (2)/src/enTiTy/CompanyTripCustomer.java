package enTiTy;

public class CompanyTripCustomer {
	int id, CustomerID, CarriageTripID;
	boolean isByTicket;
	int UserComfirmID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public int getCarriageTripID() {
		return CarriageTripID;
	}
	public void setCarriageTripID(int carriageTripID) {
		CarriageTripID = carriageTripID;
	}
	public boolean isByTicket() {
		return isByTicket;
	}
	public void setByTicket(boolean isByTicket) {
		this.isByTicket = isByTicket;
	}
	public int getUserComfirmID() {
		return UserComfirmID;
	}
	public void setUserComfirmID(int userComfirmID) {
		UserComfirmID = userComfirmID;
	}
	public CompanyTripCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyTripCustomer(int id, int customerID, int carriageTripID, boolean isByTicket, int userComfirmID) {
		super();
		this.id = id;
		CustomerID = customerID;
		CarriageTripID = carriageTripID;
		this.isByTicket = isByTicket;
		UserComfirmID = userComfirmID;
	}
	
	@Override
	public String toString() {
		return "ID" + id + "CustomerID" + CustomerID + "CarriageTripID" +CarriageTripID+
				"IsByTicket" + isByTicket + "UserConfirmID" +UserComfirmID;
	}
}
