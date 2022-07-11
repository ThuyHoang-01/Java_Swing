package BachTanTai_16045821;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.xml.sax.SAXException;

public class Testing {
	public static void createMenu() {
		System.out.println("* - * - * MENU * - * - *");
		System.out.println("1. Add product");
		System.out.println("2. Print all");
		System.out.println("3. Write XML file");
		System.out.println("4. Delete a product");
		System.out.println("5. Update a product");
		System.out.println("0. Exit");
		System.out.println("Your choice: ");
	}
	public static void main(String[] args) throws SAXException, IOException {
		int chon;
		Scanner sc = new Scanner(System.in);
		ManageProduct dom = new ManageProduct();
		dom.printAll();
		boolean flag = true;
		do {
			createMenu();
			chon = sc.nextInt();
			switch (chon) {
			case 0: 
				System.exit(0);
			case 1:
				sc.nextLine();
				Product p = createNewProduct();
				dom.addProduct(p);
				System.out.println("Thêm Thành Công");
				break;
			case 2 :
				dom.printAll();
				break;
			case 3: 
				dom.writeXMLFile();
				System.out.println("Lưu File Thành Công ");
				break;
			case 4:
			{
				String id;
				sc.nextLine();
				System.out.println("Nhập ID Cần Xóa ");
				id = sc.nextLine();
				
				boolean check = dom.deleteProduct(id);
				
				
				if(check) {
					System.out.println("Xóa Thành Công");
				}
				else 
					System.out.println("Không Tìm Thấy ID");
			}
			break;
			case 5: {
				double newPrice;
					
				String pid;
				sc.nextLine();
				System.out.println("Nhập ID Cần Sửa :");
				pid = sc.nextLine();
				
				System.out.println("nháº­p giĂ¡ má»›i: ");
				newPrice = sc.nextDouble();
				
				if(dom.updatePrice(pid, newPrice)) {
					System.out.println("Thành Công");
				}
				else {
					System.out.println("Không Tìm Thấy Product");
				}
			}
				break;
			case 6: {
				System.out.println(dom.getAllProducts());
				
			}
			default:
				flag = false;
				break;
			}
		}while(flag);
		
		
	}
	public static Product createNewProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập productID: ");
		String productID = sc.nextLine();
		
		System.out.println("Nhập nameProduct : ");
		String name = sc.nextLine();
		
		System.out.println("Nhập manufacture");
		String manufacture = sc.nextLine();
		
		System.out.println("Nhập description: ");
		String description = sc.nextLine();
		
		Supplier supplier = createNewSupplier();
		
		System.out.println("Nhập price: ");
		double price = sc.nextDouble();
		
		
		Product p = new Product(productID, name, manufacture, description, supplier, price);
		
		
		return p;
		
		

	}
	public static Supplier createNewSupplier() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập name: ");
		String name = sc.nextLine();
		
		System.out.println("Nhập country: ");
		String country = sc.nextLine();
		
		System.out.println("Nhập website: ");
		String website = sc.nextLine();
		
		Supplier supp = new Supplier(name, country, website);
		
		return supp;
		
	}
}
