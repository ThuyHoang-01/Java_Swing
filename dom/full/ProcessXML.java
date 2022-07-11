package sesion11.dom.full;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProcessXML {
	private Document doc;

	public ProcessXML(String xmlPath) throws Exception {
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fac.newDocumentBuilder();
		doc = builder.parse(xmlPath);
	}

	public ArrayList<Product> getAllProducts() throws Exception {
		ArrayList<Product> lst = new ArrayList<Product>();
		NodeList nl = doc.getElementsByTagName("product");

		String id = "", name = "", desc = "", manu = "";
		double price = 0d;
		Suplier sup = null;
		
		for (int i = 0; i < nl.getLength(); i++) {
			Element node = (Element) nl.item(i);
			NodeList child = node.getChildNodes();
			id = node.getAttribute("id").trim();
			for (int j = 0; j < child.getLength(); j++) {
				Node n = child.item(j);
				if (n.getNodeName().equals("name"))
					name = n.getTextContent();
				if (n.getNodeName().equals("manufacture"))
					manu = n.getTextContent();
				if (n.getNodeName().equals("description"))
					desc = n.getTextContent();
				if (n.getNodeName().equals("unitbaseprice"))
					price = Double.parseDouble(n.getTextContent());
				if (n.getNodeName().equals("suplier")) {
					NodeList snl = n.getChildNodes();
					String sn = "", sc = "", sw = "";
					for (int k = 0; k < snl.getLength(); k++) {
						Node ss = snl.item(k);
						if (ss.getNodeName().equals("name"))
							sn = ss.getTextContent();
						if (ss.getNodeName().equals("country"))
							sc = ss.getTextContent();
						if (ss.getNodeName().equals("website"))
							sw = ss.getTextContent();
					}
					sup = new Suplier(sn, sc, sw);
				}
			}
			Product p = new Product(id, name, manu, desc, sup, price);
			lst.add(p);
		}
		return lst;
	}

	/**
	 * @param p
	 * @throws Exception
	 */
	public void add(Product p) throws Exception {
		Element pNode = doc.createElement("product");
		pNode.setAttribute("id", p.getId());
		doc.getDocumentElement().appendChild(pNode);

		Element nNode = doc.createElement("name");
		nNode.setTextContent(p.getName());
		pNode.appendChild(nNode);		

		Element mNode = doc.createElement("manufacture");
		mNode.setTextContent(p.getManufacturer());
		pNode.appendChild(mNode);

		Element dNode = doc.createElement("description");
		dNode.setTextContent(p.getDescription());
		pNode.appendChild(dNode);
		
		Element sNode = doc.createElement("suplier");
		pNode.appendChild(sNode);

		Element snNode = doc.createElement("name");
		snNode.setTextContent(p.getSuplier().getName());
		sNode.appendChild(snNode);
		
		Element scNode = doc.createElement("country");
		scNode.setTextContent(p.getSuplier().getCountry());
		sNode.appendChild(scNode);
		
		Element swNode = doc.createElement("website");
		swNode.setTextContent(p.getSuplier().getWebsite());
		sNode.appendChild(swNode);
		
		Element uNode = doc.createElement("unitbaseprice");
		uNode.setTextContent(p.getBasePrice() + "");
		pNode.appendChild(uNode);		
	}
	
	/**
	 * Xóa 1 phần tử 
	 * @param id
	 * 			là id của phần tử cần xóa
	 * @return
	 * 			trả về true nếu xóa được, ngược lại trả về false
	 * @throws Exception
	 */
	public boolean removeElement(String id) throws Exception {
		XPathFactory xfac = XPathFactory.newInstance();
		XPath xpath = xfac.newXPath();

		XPathExpression exp = xpath.compile("//product[@id='" + id + "']");
		
		Object obj = exp.evaluate(doc, XPathConstants.NODE);
		if (obj != null) {
			Node node = (Node) obj;
			node.getParentNode().removeChild(node);
			return true;
		}
		return false;
	}


	public void printXML() throws Exception {
		TransformerFactory tfac = TransformerFactory.newInstance();
		Transformer trans = tfac.newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.transform(new DOMSource(doc.getDocumentElement()),
				new StreamResult(System.out));
	}

	public void save2Disk(String path) throws Exception {
		TransformerFactory tfac = TransformerFactory.newInstance();
		Transformer trans = tfac.newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.transform(new DOMSource(doc.getDocumentElement()),
				new StreamResult(new FileOutputStream(path)));
	}

	public Product searchByID(String id) throws Exception {
		XPathFactory xfac = XPathFactory.newInstance();
		XPath xpath = xfac.newXPath();
		
		XPathExpression exp = xpath.compile("//product[@id='" + id + "']");
		
		Object obj = exp.evaluate(doc, XPathConstants.NODE);
		if (obj != null) {
			String name = "", desc = "", manu = "";
			double price = 0d;
			Suplier sup = null;
			Node node = (Node) obj;
			NodeList child = node.getChildNodes();
			for (int j = 0; j < child.getLength(); j++) {
				Node n = child.item(j);
				if (n.getNodeName().equals("name"))
					name = n.getTextContent();
				if (n.getNodeName().equals("manufacture"))
					manu = n.getTextContent();
				if (n.getNodeName().equals("description"))
					desc = n.getTextContent();
				if (n.getNodeName().equals("unitbaseprice"))
					price = Double.parseDouble(n.getTextContent());
				if (n.getNodeName().equals("suplier")) {
					NodeList snl = n.getChildNodes();
					String sn = "", sc = "", sw = "";
					for (int k = 0; k < snl.getLength(); k++) {
						Node ss = snl.item(k);
						if (ss.getNodeName().equals("name"))
							sn = ss.getTextContent();
						if (ss.getNodeName().equals("country"))
							sc = ss.getTextContent();
						if (ss.getNodeName().equals("website"))
							sw = ss.getTextContent();
					}
					sup = new Suplier(sn, sc, sw);
				}
			}
			Product p = new Product(id, name, manu, desc, sup, price);
			return p;
		}
		return null;
	}

	/**
	 * Sửa thông tin product
	 * 
	 * @param id
	 *            là ID CỦA PRODUCT CẦN SỬA
	 * @param pNew
	 *            là những thông tin mới cần cập nhật
	 * @throws Exception
	 */
	public void edit(String id, Product pNew) throws Exception {
		XPathFactory xfac = XPathFactory.newInstance();
		XPath xpath = xfac.newXPath();
		
		XPathExpression exp = xpath.compile("//product[@id='" + id + "']");
		
		Object obj = exp.evaluate(doc, XPathConstants.NODE);
		if (obj != null) {
			Node node = (Node) obj;
			NodeList child = node.getChildNodes();
			for (int j = 0; j < child.getLength(); j++) {
				Node n = child.item(j);
				if (n.getNodeName().equals("name"))
					n.setTextContent(pNew.getName());
				if (n.getNodeName().equals("manufacture"))
					n.setTextContent(pNew.getManufacturer());
				if (n.getNodeName().equals("description"))
					n.setTextContent(pNew.getDescription());
				if (n.getNodeName().equals("unitbaseprice"))
					n.setTextContent(pNew.getBasePrice() + "");
				if (n.getNodeName().equals("suplier")) {
					NodeList snl = n.getChildNodes();
					for (int k = 0; k < snl.getLength(); k++) {
						Node ss = snl.item(k);
						if (ss.getNodeName().equals("name"))
							ss.setTextContent(pNew.getSuplier().getName());
						if (ss.getNodeName().equals("country"))
							ss.setTextContent(pNew.getSuplier().getCountry());
						if (ss.getNodeName().equals("website"))
							ss.setTextContent(pNew.getSuplier().getWebsite());
					}
				}
			}
		}
	}
}
