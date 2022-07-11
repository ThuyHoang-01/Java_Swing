package sesion11.dom.full;

public class Product {
	private String id;
	private String name;
	private String manufacturer;
	private String description;
	private Suplier suplier;
	private double basePrice;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String id, String name, String manufacturer,
			String description, Suplier suplier, double basePrice) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.suplier = suplier;
		this.basePrice = basePrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Suplier getSuplier() {
		return suplier;
	}
	public void setSuplier(Suplier suplier) {
		this.suplier = suplier;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equalsIgnoreCase(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
