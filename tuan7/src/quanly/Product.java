package quanly;

public class Product {

	private String productID;
	private String name;
	private String manufacture;
	private String description;
	private Supplier supplier;
	private double price;

	public Product(String productID, String name, String manufacture, String description, Supplier supplier,
			double price) {
		super();
		this.productID = productID;
		this.name = name;
		this.manufacture = manufacture;
		this.description = description;
		this.supplier = supplier;
		this.price = price;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", manufacture=" + manufacture + ", description="
				+ description + ", supplier=" + supplier + ", price=" + price + "]";
	}

}
