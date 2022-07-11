package NhapXuatFilexml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;

public class ManagerProducts {
	private static String filename="product.xml";
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private org.w3c.dom.Document document;
	
	public ManagerProducts() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			try {
				document = builder.parse(filename);
			} catch (org.xml.sax.SAXException e) {
				e.printStackTrace();
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addProduct(Products p) {
		org.w3c.dom.Element nameNode;
		org.w3c.dom.Element nameNode1;
		org.w3c.dom.Element root;
		org.w3c.dom.Element root1;
		org.w3c.dom.Element pNode;
		org.w3c.dom.Element pNode1;
		
		root =  document.getDocumentElement();
		pNode = document.createElement("product");
		root.appendChild(pNode);
		pNode.setAttribute("id", p.getProductID());
		
		nameNode = document.createElement("name");
		pNode.appendChild(nameNode);
		nameNode.setTextContent(p.getName());
		
		nameNode = document.createElement("manufacture");
		pNode.appendChild(nameNode);
		
		nameNode.setTextContent(p.getManufacture());
		nameNode = document.createElement("description");
		pNode.appendChild(nameNode);
		
		nameNode.setTextContent(p.getDescription());
		root1 = document.getDocumentElement();
		pNode1 = document.createElement("supplier");
		root1.appendChild(pNode1);
		
		nameNode1 = document.createElement("name");
		pNode1.appendChild(nameNode1);
		nameNode1.setTextContent(p.getSupplier().getName());
		
		nameNode1 = document.createElement("country");
		pNode1.appendChild(nameNode1);
		nameNode1.setTextContent(p.getSupplier().getCountry());
		
		nameNode1 = document.createElement("website");
		pNode1.appendChild(nameNode1);
		nameNode1.setTextContent(p.getSupplier().getWebsite());
		//////////////////////////////
		pNode.appendChild(pNode1);
		
		nameNode = document.createElement("price");
		pNode.appendChild(nameNode);
		nameNode.setTextContent(Double.toString(p.getPrice()));	
	}
	public void writeXMLFile() {
		TransformerFactory factory = null;
		Transformer transformer = null;
		try {
			factory = TransformerFactory.newInstance();
			transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void printAll(){
		TransformerFactory factory = null;
		Transformer transformer = null;
		try {
			factory = TransformerFactory.newInstance();
			transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(System.out));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
