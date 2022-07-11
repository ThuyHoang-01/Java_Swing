package sesion11.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class WriteXML {
	public static void main(String[] args) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// add elements to Document
			Element rootElement = doc.createElement("Employees");

			// append root element to document
			doc.appendChild(rootElement);

			// append first child element to root element
			rootElement.appendChild(getEmployee(doc, "1", "Pankaj", "29",
					"Java Developer", "Male"));

			// append second child
			rootElement.appendChild(getEmployee(doc, "2", "Lisa", "35",
					"Manager", "Female"));

			// for output to file, console
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// for pretty print
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			transformer.transform(new DOMSource(doc), new StreamResult(
					new File("xml/emps.xml")));

//			transformer.transform(new DOMSource(doc), new StreamResult(
//					System.out));

			System.out.println("DONE");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Node getEmployee(Document doc, String id, String name,
			String age, String role, String gender) {
		Element employee = doc.createElement("Employee");

		// set id attribute
		employee.setAttribute("id", id);

		// create name element
		employee.appendChild(getEmployeeElements(doc, "name", name));

		// create age element
		employee.appendChild(getEmployeeElements(doc, "age", age));

		// create role element
		employee.appendChild(getEmployeeElements(doc, "role", role));

		// create gender element
		employee.appendChild(getEmployeeElements(doc, "gender", gender));

		return employee;
	}

	// utility method to create text node
	private static Node getEmployeeElements(Document doc, String name,
			String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
}
