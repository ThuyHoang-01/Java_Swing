package sesion11.dom.full;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws Exception {
		ProcessXML xml = new ProcessXML("xml/product.xml");
//		ArrayList<Product> lst = xml.getAllProducts();
//		for (Product p : lst) {
//			System.out.println(p.getId() + "\t" + p.getName());
//		}

//		Suplier sup = new Suplier("Hai lúa", "Việt Nam", "hailua.com");
//		Product p = new Product("246287", "bột giặt OMO", "Unilever",
//				"Bột giặt OMO không còn dấu hieu của tóc", sup, 10);
//		xml.add(p);
//		System.out.println("THEM XONG");

//		if (xml.removeElement("246287")) {			
//			System.out.println("XOA XONG");
//		}
//		else
//			System.out.println("Khong co Element can xoa");
//		
//		xml.save2Disk("xml/product.xml");
		
		Product pr = xml.searchByID("002");
		if (pr != null) {
			pr.setBasePrice(1000d);
			pr.setName("TV nay mua mai hư");
			xml.edit("TV1025", pr);
			xml.printXML();
		}

	}
}
