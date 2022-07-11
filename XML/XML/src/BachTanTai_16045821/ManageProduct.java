package BachTanTai_16045821;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

import javax.lang.model.element.Element;
import javax.print.attribute.standard.Sides;
import javax.sound.sampled.Port;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ManageProduct {
	private static String fileName = "product.xml";
//	private static File fileXML = new File("product.xml");
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private org.w3c.dom.Document document;
	
	NodeList nodelist;

	
	public ManageProduct() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			try {
				document = builder.parse(fileName);
				nodelist = document.getElementsByTagName("product");
			
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block 	
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {

		}
		// TODO Auto-generated constructor stub
	}

	public void addProduct(Product p) {
		

		org.w3c.dom.Element nameNode;
		org.w3c.dom.Element nameNode1;
		org.w3c.dom.Element root;
		org.w3c.dom.Element root1;
		org.w3c.dom.Element pNode;
		org.w3c.dom.Element pNode1;

		root = document.getDocumentElement();// tạo 1 nút gốc
		
		
		pNode = document.createElement("product");
		pNode.setAttribute("id", p.getProductID());
		root.appendChild(pNode);

		nameNode = document.createElement("Name");
		nameNode.setTextContent(p.getName());
		pNode.appendChild(nameNode);
		

		nameNode = document.createElement("manufacture");
		nameNode.setTextContent(p.getManufacture());
		pNode.appendChild(nameNode);
		
		nameNode = document.createElement("description");
		nameNode.setTextContent(p.getDescription());
		pNode.appendChild(nameNode);

		// ---- name

		root1 = document.getDocumentElement();
		pNode1 = document.createElement("supplier");
		root1.appendChild(pNode1);

		nameNode1 = document.createElement("name"); // tạo tên tag
		pNode1.appendChild(nameNode1); // add tag vào node
		nameNode1.setTextContent(p.getSupplier().getName());// set giá trị của tag 

		// --- country
		nameNode1 = document.createElement("country");
		pNode1.appendChild(nameNode1);
		nameNode1.setTextContent(p.getSupplier().getCountry());

		// --- country
		nameNode1 = document.createElement("website");
		pNode1.appendChild(nameNode1);
		nameNode1.setTextContent(p.getSupplier().getWebsite());
		
		
		pNode.appendChild(pNode1);
		/////// --------------------

	

		nameNode = document.createElement("price");
		nameNode.setTextContent(Double.toString(p.getPrice()));
		
		
		
		pNode.appendChild(nameNode);
		
		//System.out.println("Node name: " + pNode.getNodeName());
		//System.out.println("pNode: " + pNode.getAttribute("id"));

	}

	public void writeXMLFile() {
		TransformerFactory factory = null;
		Transformer transformer = null;

		try {
			factory = TransformerFactory.newInstance();
			transformer = factory.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "YES");
			
			transformer.transform(new DOMSource(document), new StreamResult(fileName));
			JOptionPane.showMessageDialog(null, "Them thanh cong");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public void printAll() {
		TransformerFactory factory = null;
		Transformer transformer = null;

		try {
			factory = TransformerFactory.newInstance();
			transformer = factory.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "YES");
			//transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			 transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			transformer.transform(new DOMSource(document), new StreamResult(System.out));

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public boolean deleteProduct(String pid)  {
		
		
		org.w3c.dom.Element root = (org.w3c.dom.Element) document.getDocumentElement();
		NodeList pList =  root.getElementsByTagName("product");
		
		
		//System.out.println("***** pid: " + pid);
		
		
		for(int i = 0; i < pList.getLength(); i++) {
			org.w3c.dom.Element pNode=  (org.w3c.dom.Element) pList.item(i);
			String productID =  pNode.getAttribute("id");
			//System.out.println("productL " + productID);
			if(productID.equalsIgnoreCase(pid)) {
				
				pNode.getParentNode().removeChild(pNode);
				
				return true;
			}
		}
		return false;
		
	}
	
	public boolean updatePrice(String pid, double newPrice) {
	
		
	
		org.w3c.dom.Element root = (org.w3c.dom.Element) document.getDocumentElement();
		NodeList pList =  root.getElementsByTagName("product");
		

		for(int i = 0; i < pList.getLength(); i++) {
			org.w3c.dom.Element pNode=  (org.w3c.dom.Element) pList.item(i);
			String productID =  pNode.getAttribute("id");
			if(productID.equalsIgnoreCase(pid)) {
				Node priceNode = pNode.getElementsByTagName("price").item(0);
				priceNode.setTextContent(Double.toString(newPrice) + "");
				
				return true;
				
				
			}
		}
		
		return false;
		
	}
	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> list = new ArrayList<Product>();
		org.w3c.dom.Element root = (org.w3c.dom.Element) document.getDocumentElement();
		NodeList pList =  root.getElementsByTagName("product");
		
		int length = pList.getLength();
		
		for(int i = 0; i < length; i++) {
			org.w3c.dom.Element pNode=  (org.w3c.dom.Element) pList.item(i);
			String productID =  pNode.getAttribute("id");
			String name = pNode.getElementsByTagName("name").item(0).getTextContent();
			String manufacture = pNode.getElementsByTagName("manufacture").item(0).getTextContent();
			String description = pNode.getElementsByTagName("description").item(0).getTextContent();
			
			org.w3c.dom.Element supplierNode =  (org.w3c.dom.Element) pNode.getElementsByTagName("supplier").item(0);
			String nameSupplier = supplierNode.getElementsByTagName("name").item(0).getTextContent();
			String country = supplierNode.getElementsByTagName("country").item(0).getTextContent();
			String website = supplierNode.getElementsByTagName("website").item(0).getTextContent();
			
			String sprice = pNode.getElementsByTagName("price").item(0).getTextContent();
			double price = 0.0;
			try{
				price = Double.valueOf(sprice);
			}catch(NumberFormatException ex){}

			Supplier s = new Supplier(nameSupplier, country, website);
			Product p = new Product(productID, nameSupplier, manufacture, description, s, price);
			
			list.add(p);
			
		}
		
		
		return list;
		
		
	
	}

}
