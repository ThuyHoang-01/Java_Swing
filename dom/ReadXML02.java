package sesion11.dom;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
/* staff.xml
<?xml version="1.0"?>
<company>
	<staff id="1001">
		<firstname>yong</firstname>
		<lastname>mook kim</lastname>
		<nickname>mkyong</nickname>
		<salary>100000</salary>
	</staff>
	<staff id="2001">
		<firstname>low</firstname>
		<lastname>yin fong</lastname>
		<nickname>fong fong</nickname>
		<salary>200000</salary>
	</staff>
</company>
 */
public class ReadXML02 {

	public static void main(String argv[]) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("xml/staff.xml");

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			// doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("staff");

			System.out.println("----------------------------");

			for (int i = 0; i < nList.getLength(); i++) {

				Node nNode = nList.item(i);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Staff id : "
							+ eElement.getAttribute("id"));
					System.out.println("First Name : "
							+ eElement.getElementsByTagName("firstname")
									.item(0).getTextContent());
					System.out.println("Last Name : "
							+ eElement.getElementsByTagName("lastname").item(0)
									.getTextContent());
					System.out.println("Nick Name : "
							+ eElement.getElementsByTagName("nickname").item(0)
									.getTextContent());
					System.out.println("Salary : "
							+ eElement.getElementsByTagName("salary").item(0)
									.getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}