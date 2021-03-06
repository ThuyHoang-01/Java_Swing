package tuan7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManageProduct {

	private static String fileName = "product.xml";
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;

	public ManageProduct() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.parse(fileName);
		} catch (ParserConfigurationException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> getAllProduct(){
		ArrayList<Product> list = new ArrayList<Product>();
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("product");
		int pCount = pList.getLength();
		for(int i=0;i<pCount;i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			String name = pNode.getElementsByTagName("name").item(0).getTextContent();
			String manufacture = pNode.getElementsByTagName("manufacture").item(0).getTextContent();
			String description = pNode.getElementsByTagName("description").item(0).getTextContent();
			
			Element sNode = (Element) pNode.getElementsByTagName("supplier").item(0);
			String sName = sNode.getElementsByTagName("name").item(0).getTextContent();
			String country = sNode.getElementsByTagName("country").item(0).getTextContent();
			String website = sNode.getElementsByTagName("website").item(0).getTextContent();
			
			Supplier supplier = new Supplier(sName, country, website);
			
			String sprice = pNode.getElementsByTagName("price").item(0).getTextContent();
			double price = 0.0;
			try {
				price = Double.valueOf(sprice);
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
			Product p = new Product(productID, name, manufacture, description, supplier, price);
			list.add(p);
			
		}
		return list;
	}
	
	public void addProduct(Product p) {
		Element root = document.getDocumentElement();
		
		Element pNode = document.createElement("product");
		
		root.appendChild(pNode);
		pNode.setAttribute("id", p.getProductID());
		
		
	}

}
