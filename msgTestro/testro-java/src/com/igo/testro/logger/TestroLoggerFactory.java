package com.igo.testro.logger;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.igo.testro.preference.TestroPreference;

/**
 * Tesro logger 생성
 * 
 * @author kangwoo
 * 
 */
public class TestroLoggerFactory {

	private static final String LOG4J_CONFIGURATION = "</log4j:configuration>";
	private static final String LOG_PATH = "LOG_PATH";
	private static final String TESTRO_LOG4J_PATH = "/com/igo/testro/resource/log4j.xml";
	protected static List<String> loggerNameList;

	/**
	 * log4j 설정파일을 읽어드림
	 */
	public static void resourceConfigure() {
		try {

			// 1. tesro 기본 log4j loading
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setIgnoringComments(true);
			dbf.setValidating(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			db.setEntityResolver(new Log4jEntiResolver());
			Document testroDoc = db.parse(TestroLoggerFactory.class
					.getResourceAsStream(TESTRO_LOG4J_PATH));
			testroDoc = stringToDom(domToString(testroDoc));

			// 2. user log4j loading
			db = dbf.newDocumentBuilder();
			db.setEntityResolver(new Log4jEntiResolver());
			TestroPreference instance = TestroPreference.getInstance();
			String configPath = instance.getProperty("CONFIG_PATH", TestroPreference.MASTER);
			String folderName = instance.convConfFolder();
			Document userDoc = db.parse(new FileInputStream(new File(configPath
					+ "/" + folderName + "/log4j.xml")));

			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			XPathExpression expr = xpath.compile("//appender");

			NodeList testroAppenderList = (NodeList) expr.evaluate(testroDoc,
					XPathConstants.NODESET);
			NodeList userAppenderList = (NodeList) expr.evaluate(userDoc,
					XPathConstants.NODESET);

			expr = xpath.compile("//logger");

			NodeList testroLoggerList = (NodeList) expr.evaluate(testroDoc,
					XPathConstants.NODESET);
			NodeList userLoggerList = (NodeList) expr.evaluate(userDoc,
					XPathConstants.NODESET);

			List<Node> appenderNodes = appendNode(testroDoc, testroAppenderList, userAppenderList);
			List<Node> loggerNodes = appendNode(testroDoc, testroLoggerList, userLoggerList);
			
			String domToString = domToString(testroDoc);
			domToString = domToString.replaceAll(LOG4J_CONFIGURATION, "");
			
			String subDomString = "";
			
			for (Node node : appenderNodes) {
				subDomString = subDomString + "\t" + nodeToString(node);
			}
			
			for (Node node : loggerNodes) {
				subDomString = subDomString + "\t" + nodeToString(node);
			}
			
			domToString = domToString + subDomString + LOG4J_CONFIGURATION;
			domToString = domToString.replaceAll("[$]\\{" + LOG_PATH + "\\}", TestroPreference.getInstance().getProperty(LOG_PATH));
			
			System.out.println(domToString);
			Element documentElement = stringToDom(domToString).getDocumentElement();
			
			NodeList elementsByTagName = documentElement.getElementsByTagName("logger");
			
			loggerNameList = new ArrayList<String>();
			for (int i = 0; i < elementsByTagName.getLength(); i++) {
				String loggerName = elementsByTagName.item(i).getAttributes().getNamedItem("name").getNodeValue();
				loggerNameList.add(loggerName);
			}
			
			configure(documentElement);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<Node> appendNode(Document testroDoc, NodeList testroNodeList,
			NodeList userNodeList) {
		List<Node> nodeList = new ArrayList<Node>();
		Node firstChild = testroDoc.getFirstChild();

		for (int i = 0; i < userNodeList.getLength(); i++) {
			Node userNode = userNodeList.item(i);
			Node userAttribute = userNode.getAttributes().getNamedItem("name");
			String userAttributeValue = userAttribute.getNodeValue();
			
			for (int j = 0; j < testroNodeList.getLength(); j++) {
				
				Node testroNode = testroNodeList.item(i);
				Node testroAttribute = testroNode.getAttributes().getNamedItem(
						"name");
				String tesroAttributeValue = testroAttribute.getNodeValue();

				if (tesroAttributeValue.equals(userAttributeValue)) {
					System.out.println(tesroAttributeValue + "|"
							+ userAttributeValue);
					firstChild.removeChild(testroNode);
					break;
				}
			}
			nodeList.add(userNode);
		}
		
		return nodeList;
	}

	public static void configure(Element element) {
		DOMConfigurator.configure(element);
	}

	private static String domToString(Document doc) {
		String output = null;
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
					"yes");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			output = writer.getBuffer().toString();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return output;
	}

	public static String nodeToString(Node node) {
		StringWriter sw = new StringWriter();
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.transform(new DOMSource(node), new StreamResult(sw));
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}

	public static Document stringToDom(String xmlSource) throws SAXException,
			ParserConfigurationException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(new InputSource(new StringReader(xmlSource)));
	}

	public static Node stringToNode(String string) {
		Element node = null;
		try {
			node = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().parse(
							new ByteArrayInputStream(string
									.getBytes())).getDocumentElement();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return node;
	}
	
	static public ITestroLogger getLogger(String name) {
		return new TestroLoggerLog4jImpl(LogManager.getLogger(name));
	}

}

class Log4jEntiResolver implements EntityResolver {

	public InputSource resolveEntity(String publicId, String systemId)
			throws SAXException {
		return getInputSource("com/igo/testro/resource/log4j.dtd");
	}

	private InputSource getInputSource(String path) {
		InputSource source = null;
		if (path != null) {
			InputStream in = null;
			in = TestroLoggerFactory.class.getClassLoader()
					.getResourceAsStream(path);
			source = new InputSource(in);
		}
		return source;
	}
}
