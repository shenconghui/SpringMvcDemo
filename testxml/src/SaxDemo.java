import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**SAX文档解析 */
public class SaxDemo implements XmlDocument {
	public void createXml(String fileName) {
		try {
			
			XMLOutputFactory factory=XMLOutputFactory.newInstance();
			XMLStreamWriter writer=factory.createXMLStreamWriter(new FileOutputStream(fileName));
			writer.writeStartDocument("utf-8", "1.0");
			//writer.writeStartDocument();
			writer.writeStartElement("persons");
			for(int i=0;i<3;i++)
			{
				writer.writeStartElement("person"+i);
				writer.writeAttribute("id", "20");
				writer.writeStartElement("name");
				writer.writeCharacters("rock"+i);
				writer.writeEndElement();
				writer.writeStartElement("age");
				writer.writeCharacters("15");
				writer.writeEndElement();
				writer.writeEndElement();
			
			}
			writer.writeEndDocument();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void parserXml(String fileName) {
		SAXParserFactory saxfac = SAXParserFactory.newInstance();
		try {
			SAXParser saxparser = saxfac.newSAXParser();
			InputStream is = new FileInputStream(fileName);
			saxparser.parse(is, new MySAXHandler());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class MySAXHandler extends DefaultHandler {
	boolean hasAttribute = false;
	Attributes attributes = null;

	public void startDocument() throws SAXException {
		System.out.println("文档开始打印了");
	}

	public void endDocument() throws SAXException {
		System.out.println("文档打印结束了");
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equals("employees")) {
			return;
		}
		if (qName.equals("employee")) {
			System.out.println(qName);
		}
		if (attributes.getLength() > 0) {
			this.attributes = attributes;
			this.hasAttribute = true;
		}
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (hasAttribute && (attributes != null)) {
			for (int i = 0; i < attributes.getLength(); i++)

			{
				System.out.println(attributes.getQName(0)
						+ attributes.getValue(0));
			}
		}
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println(new String(ch, start, length));
	}
}
