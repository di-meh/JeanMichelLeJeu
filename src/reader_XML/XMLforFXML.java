package reader_XML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
//import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLforFXML { //Non autorisé pour projet, mais à utiliser pour tester

	public static void main(String args[]) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder builder = factory.newDocumentBuilder();

			File fileXML = new File("./Ressources/tilemap_1st_collisionTest_2calques.xml");

			Document xml = builder.parse(fileXML);

			Element root = xml.getDocumentElement();

			XPathFactory xpf = XPathFactory.newInstance();

			XPath path = xpf.newXPath();

			String expression = "/map/layer/data";

			String str = (String)path.evaluate(expression, root);

			System.out.println(str);

			//System.out.println("-------------------------------------");



		} catch (ParserConfigurationException e) {

			e.printStackTrace();

		} catch (SAXException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (XPathExpressionException e) {

			e.printStackTrace();

		}
	}
}
