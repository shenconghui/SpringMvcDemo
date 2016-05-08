/**
 * 四种xml解析方式,包括dom,sax,dom4j,jdom等方式
 *
 * @author Administrator
 *
 */
public class MainTest {

	public static void main(String[] args) {

		XmlDocument jDomDemo = new JDomDemo();
		jDomDemo.createXml("jdom.xml");
		jDomDemo.parserXml("jdom.xml");

		XmlDocument domDemo = new DomDemo();
		domDemo.createXml("dom.xml");
		domDemo.parserXml("dom.xml");

		XmlDocument dom4jDemo = new Dom4jDemo();
		dom4jDemo.createXml("dom4j.xml");
		dom4jDemo.parserXml("dom4j.xml");

		XmlDocument saxDemo = new SaxDemo();
		saxDemo.createXml("sax.xml");
		saxDemo.parserXml("sax.xml");

	}

}
