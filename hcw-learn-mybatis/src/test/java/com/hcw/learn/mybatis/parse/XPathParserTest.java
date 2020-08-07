package com.hcw.learn.mybatis.parse;


import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.xpath.XPathExpressionException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XPathParserTest {

    XPathParser xPathParser = new XPathParser();

    @Test
    public void testParse() throws FileNotFoundException, XPathExpressionException {
        String parse = xPathParser.evalString("D:\\workspace\\hcw-framework\\hcw-learn-mybatis\\src\\main\\resources\\student.xml","//student[@id='456']");
        System.out.println(parse);
    }

    @Test
    public void testMapper() throws FileNotFoundException, XPathExpressionException {
        String parse = xPathParser.evalString("D:\\workspace\\hcw-framework\\hcw-learn-mybatis\\src\\main\\resources\\BlogMapper.xml","//select[@id='selectBlogWithPostsUsingSubSelect']");
        System.out.println(parse);
    }
    @Test
    public void testEvalNode() throws IOException, XPathExpressionException, SAXException {
        Node node =  xPathParser.evalNode("D:\\workspace\\hcw-framework\\hcw-learn-mybatis\\src\\main\\resources\\BlogMapper.xml","/mapper/select");
        if (node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                System.out.println(childNodes.item(i).getTextContent());
            }
        }
    }

}