package sesion11.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/* temp.xml
<?xml version="1.0"?>
<company>
	<staff id="1001">
		<firstname>yong</firstname>
		<lastname>mook kim</lastname>
		<nickname>mkyong</nickname>
		<salary>100000</salary>
		abc
	</staff>
	<staff id="2001">
		<firstname>low</firstname>
		<lastname>yin fong</lastname>
		<nickname>fong fong</nickname>
		<salary>200000</salary>
		abc
	</staff>
</company>
 */
public class ReadXML01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//		try {
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = fac.newDocumentBuilder();
			Document doc = builder.parse("xml/temp.xml");// productList

			Element root = (Element) doc.getDocumentElement();
			System.out.println("Root name: " + root.getNodeName());
			
			NamedNodeMap nodeMap = root.getAttributes();
			for (int i = 0; i < nodeMap.getLength(); i++) {
				Attr at = (Attr) nodeMap.item(i);
				System.out.println("Name: " + at.getName() + 
								   " Value: " + at.getValue());
			}
			
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		} catch (SAXException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}


	}
}
