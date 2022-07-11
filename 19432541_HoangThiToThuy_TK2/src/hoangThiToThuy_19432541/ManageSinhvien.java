package hoangThiToThuy_19432541;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ManageSinhvien {

	private static String fileName = "sinhvien.xml";
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;

	public ManageSinhvien() {
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

	public ArrayList<Sinhvien> getAllProduct() {
		ArrayList<Sinhvien> list = new ArrayList<Sinhvien>();
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("sinhvien");
		int pCount = pList.getLength();
		for (int i = 0; i < pCount; i++) {
			Element pNode = (Element) pList.item(i);
			String id = pNode.getAttribute("id");
			String ten = pNode.getElementsByTagName("hoten").item(0).getTextContent();
			String lop = pNode.getElementsByTagName("lop").item(0).getTextContent();
			String noisinh = pNode.getElementsByTagName("noisinh").item(0).getTextContent();
			String monhoc = pNode.getElementsByTagName("monhoc").item(0).getTextContent();

			Sinhvien sv = new Sinhvien(id, ten, lop, noisinh, monhoc);
			list.add(sv);

		}
		return list;
	}

	public void addProduct(Sinhvien p) {
		Element root = document.getDocumentElement();

		Element pNode = document.createElement("sinhvien");

		root.appendChild(pNode);
		pNode.setAttribute("id", p.getId());

		Node nameNode0 = document.createElement("hoten");
		pNode.appendChild(nameNode0);
		nameNode0.setTextContent(p.getTen());

		Node nameNode1 = document.createElement("lop");
		pNode.appendChild(nameNode1);
		nameNode1.setTextContent(p.getLop());

		Node nameNode2 = document.createElement("noisinh");
		pNode.appendChild(nameNode2);
		nameNode2.setTextContent(p.getNoisinh());


		Node nameNode3 = document.createElement("monhoc");
		pNode.appendChild(nameNode3);
		nameNode3.setTextContent(p.getMonhoc());

	}

	public void deleteProduct(String pid) {
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("sinhvien");
		for (int i = 0; i < pList.getLength(); i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			if (productID.equals(pid)) {
				pNode.getParentNode().removeChild(pNode);
				break;
			}
		}
	}

	public void updatePrice(String pid, String lop) {
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("sinhvien");
		for (int i = 0; i < pList.getLength(); i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			if (productID.equalsIgnoreCase(pid)) {
				Node priceNode = pNode.getElementsByTagName("lop").item(0);
				priceNode.setTextContent(lop);
				break;
			}

		}
	}

	public void writeXMLFile() {
		TransformerFactory factory = TransformerFactory.newDefaultInstance();
		Transformer transformer = null;
		try {
			transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(fileName));
			
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
