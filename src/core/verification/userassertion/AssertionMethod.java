package core.verification.userassertion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.fife.ui.rsyntaxtextarea.parser.XmlParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import core.solver.Z3Runner;

public class AssertionMethod {
	
	public static final String ASSERTION_METHOD_TAG = "AssertionMethod";
	public static final String METHOD_TAG = "Method";
	public static final String PRE_CONDITION_TAG = "PreCondition";
	public static final String POST_CONDITION_TAG = "PostCondition";
	
	
	private String methodName;
	private String preCondition;
	private String postCondition;
	
	public AssertionMethod() {
	}
	
	public AssertionMethod(String methodName, String preCondition, String postCondition) {
		this.methodName = methodName;
		this.preCondition = preCondition;
		this.postCondition = postCondition;
	}

	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * @param methodName the methodName to set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * @return the preCondition
	 */
	public String getPreCondition() {
		return preCondition;
	}

	/**
	 * @param preCondition the preCondition to set
	 */
	public void setPreCondition(String preCondition) {
		this.preCondition = preCondition;
	}

	/**
	 * @return the assertion
	 */
	public String getPostCondition() {
		return postCondition;
	}

	/**
	 * @param assertion the assertion to set
	 */
	public void setPostCondition(String postCondition) {
		this.postCondition = postCondition;
	}
	
	public static List<AssertionMethod> getUserAssertions(File file) {
		List<AssertionMethod> list = new ArrayList<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document doc = builder.parse(file);
	
			Document doc = loadXMLFromFile(file);	
			NodeList nodeList = doc.getElementsByTagName(ASSERTION_METHOD_TAG);
			NodeList nodeListTemp;
			String method = null;
			String preCondition = null;
			String postCondition = null;
			Node node;
			for (int i = 0; i < nodeList.getLength(); i++) {
				node = nodeList.item(i);
				nodeListTemp = node.getChildNodes();
				
				for (int j = 0; j < nodeListTemp.getLength(); j++) {
					Node n = nodeListTemp.item(j);
					if (n.getNodeName().equals(METHOD_TAG)) {
						method = n.getTextContent();
					}
					else if (n.getNodeName().equals(PRE_CONDITION_TAG)) {
						preCondition = n.getTextContent();
					}
					else if (n.getNodeName().equals(POST_CONDITION_TAG)) {
						postCondition = n.getTextContent();
					}
				}
				
				System.out.printf("%s - %s - %s\n", method, preCondition, postCondition);
				
				list.add(new AssertionMethod(method, preCondition, postCondition));
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return list;
	}
	
	
	public static Document loadXMLFromString(String xml) throws Exception
	{
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    InputSource is = new InputSource(new StringReader(xml));
	    return builder.parse(is);
	}
	
	public static Document loadXMLFromFile(File file) throws Exception
	{
		InputStreamReader isp = new InputStreamReader(new FileInputStream(file));
		BufferedReader br = new BufferedReader(isp);
		
		String xml = "";
		String line = br.readLine();
		while (line != null) {
			xml += line;
			line = br.readLine();
		}
		
		xml = xml.replaceAll("&", "&amp;")
				.replace("<", "&lt;")
				.replace("&lt;?xml", "<?xml")
				.replace("&lt;AssertionFile>", "<AssertionFile>")
				.replace("&lt;AssertionMethod>", "<AssertionMethod>")
				.replace("&lt;Method>", "<Method>")
				.replace("&lt;PreCondition>", "<PreCondition>")
				.replace("&lt;PostCondition>", "<PostCondition>")
				.replace("&lt;/", "</");
		
	//	System.out.println(xml);
			
		
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    InputSource is = new InputSource(new StringReader(xml));
	    return builder.parse(is);
	}
	
	public static void main(String[] args) {
		
		File file = new File("TestPP.xml");
		file = new File("TestSpoon.xml");
		getUserAssertions(file);
		
//		String test = "&";
//		test = test.replace("&", "&amp;");
//		System.out.println(test);
	}
	
}
