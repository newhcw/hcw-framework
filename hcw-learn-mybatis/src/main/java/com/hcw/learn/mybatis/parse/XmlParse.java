package com.hcw.learn.mybatis.parse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class XmlParse {

    public static void main(String[] args) {
        new XmlParse().parse();
    }

    public void parse(){
        try {
            File file = new File("D:\\workspace\\hcw-framework\\hcw-learn-mybatis\\src\\main\\java\\com\\hcw\\learn\\mybatis\\parse\\student.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 创建xpath对象
            XPath xPath = XPathFactory.newInstance().newXPath();
            Document document = builder.parse(file);
            // 编写xpath表达式
            String expression = "/students/student";
            NodeList students = (NodeList)xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < students.getLength(); i++){
                Node node = students.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.printf(" Element: %s\n", element.getNodeName());
                    System.out.printf(" Name: %s\n", element.getElementsByTagName("name").item(0).getTextContent());
                    System.out.printf(" Age: %s\n", element.getElementsByTagName("age").item(0).getTextContent());
                    System.out.printf(" Gender: %s\n", element.getElementsByTagName("gender").item(0).getTextContent());
                }
            }
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
