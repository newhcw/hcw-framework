package com.hcw.learn.mybatis.parse;

import org.xml.sax.InputSource;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XPathParser {


    private XPathFactory xPathFactory;
    private XPath xPath;

    public XPathParser() {
        // 1.创建一个XPathFactory的实例
        xPathFactory = XPathFactory.newInstance();
        // 2.通过XPathFactory的实例获取一个XPath实例
        xPath = xPathFactory.newXPath();
    }



    public String parse(String fileUrl,String expression) throws FileNotFoundException, XPathExpressionException {
        return parse(new FileReader(fileUrl),expression);
    }

    public String parse(File file,String expression) throws FileNotFoundException, XPathExpressionException {
        return parse(new FileReader(file),expression);
    }


    public String parse(FileReader fileReader,String expression) throws FileNotFoundException, XPathExpressionException{
        return parse(new InputSource(fileReader),expression);
    }

    public String parse(InputSource inputSource,String expression) throws FileNotFoundException, XPathExpressionException{
        //3.通过XPath实例的evaluate()方法对XML进行查询
        String evaluate = (String) parse(inputSource,expression, XPathConstants.STRING);
        return evaluate;
    }

    public Object parse(InputSource inputSource, String expression, QName qName) throws FileNotFoundException, XPathExpressionException{
        return xPath.evaluate(expression, inputSource, qName);
    }
}
