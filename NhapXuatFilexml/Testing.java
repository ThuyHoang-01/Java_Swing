package NhapXuatFilexml;

import java.util.Scanner;

public class Testing {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int luaChon;
		ManagerProducts dom = new ManagerProducts();
		boolean flag = true;
		while (flag==true){
			createMenu();
			luaChon = sc.nextInt();
			switch (luaChon) {
			case 1:
				sc.nextLine();
				Products p = createNewProduct();
				dom.addProduct(p);
				break;
			case 2:
				dom.printAll();
				break;
			case 3:
				dom.writeXMLFile();
				break;
			default:
				flag = false;
				break;
			}
		}
	}
	private static Products createNewProduct() {
		System.out.println("Enter Product ID");
		String productID = sc.nextLine();
		System.out.println("Enter Name");
		String productName = sc.nextLine();
		System.out.println("Enter Manufacture");
		String productManufacture = sc.nextLine();
		System.out.println("Enter Description");
		String productDescription = sc.nextLine();
		System.out.println("Enter Supplier");
		Supplier productSupplier= createSupplier();
		System.out.println("Enter Price");
		double productPrice = sc.nextDouble();
		return new Products(productID, productName, productManufacture, productDescription, productSupplier, productPrice);
	}
	private static Supplier createSupplier() {
		System.out.println("Enter Supplier Name");
		String supplierName = sc.nextLine();
		System.out.println("Enter Country");
		String supplierCountry = sc.nextLine();
		System.out.println("Enter Website");
		String supplierWebsite= sc.nextLine();
		return new Supplier(supplierName, supplierCountry, supplierWebsite);
	}
	private static void createMenu() {
		System.out.println("=====MENU=====");
		System.out.println("1. Add product");
		System.out.println("2. Print All");
		System.out.println("3. Write XML File");
		System.out.println("0. Exit");
		System.out.println("Your choice:");
	}
}
