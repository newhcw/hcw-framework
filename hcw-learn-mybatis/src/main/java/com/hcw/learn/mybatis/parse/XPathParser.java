package com.hcw.learn.mybatis.parse;

import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class XPathParser {


    private XPath xPath;

    private DocumentBuilder builder;

    public XPathParser(){
        // 1.创建一个XPathFactory的实例
        XPathFactory xPathFactory = XPathFactory.newInstance();
        // 2.通过XPathFactory的实例获取一个XPath实例
        xPath = xPathFactory.newXPath();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }



    public String evalString(String fileUrl,String expression) throws FileNotFoundException, XPathExpressionException {
        return evalString(new FileReader(fileUrl),expression);
    }

    public String evalString(File file,String expression) throws FileNotFoundException, XPathExpressionException {
        return evalString(new FileReader(file),expression);
    }


    public String evalString(FileReader fileReader,String expression) throws FileNotFoundException, XPathExpressionException{
        return evalString(new InputSource(fileReader),expression);
    }

    public String evalString(InputSource inputSource,String expression) throws FileNotFoundException, XPathExpressionException{
        //3.通过XPath实例的evaluate()方法对XML进行查询
        String evaluate = (String) evaluate(inputSource,expression, XPathConstants.STRING);
        return evaluate;
    }

//    public Node evalNode(String fileUrl,String expression) throws IOException, SAXException, XPathExpressionException {
//        return (Node) evaluate(builder.parse(new InputSource(new FileReader(fileUrl))),expression,XPathConstants.NODE);
//    }

    public Node evalNode(String fileUrl,String expression) throws IOException, SAXException, XPathExpressionException {
        return (Node) evaluate(new InputSource(new FileReader(fileUrl)),expression,XPathConstants.NODE);
    }


    public Object evaluate(InputSource inputSource, String expression, QName qName) throws FileNotFoundException, XPathExpressionException{
        return xPath.evaluate(expression, inputSource, qName);
    }

}
