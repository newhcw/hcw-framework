package com.hcw.learn.mybatis.parse;


import org.junit.Test;

import javax.xml.xpath.XPathExpressionException;
import java.io.FileNotFoundException;

public class XPathParserTest {

    XPathParser xPathParser = new XPathParser();

    @Test
    public void testParse() throws FileNotFoundException, XPathExpressionException {
        String parse = xPathParser.parse("D:\\workspace\\hcw-framework\\hcw-learn-mybatis\\src\\main\\resources\\student.xml","//student[@id='456']");
        System.out.println(parse);
    }

    @Test
    public void testMapper() throws FileNotFoundException, XPathExpressionException {
        String parse = xPathParser.parse("D:\\workspace\\hcw-framework\\hcw-learn-mybatis\\src\\main\\resources\\BlogMapper.xml","//select[@id='selectBlogWithPostsUsingSubSelect']");
        System.out.println(parse);
    }

}