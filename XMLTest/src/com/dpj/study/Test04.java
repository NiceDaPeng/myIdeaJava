package com.dpj.study;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Test04 {

    public static void main(String[] args) {

        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read("src/lib/books.xml");
            Element rootEle = document.getRootElement();
            List<Element> list = rootEle.elements();
            for (Element ele :
                    list) {
                String sn = ele.attributeValue("sn");
                String name = ele.elementText("name");
                String author = ele.elementText("author");
                Double price = Double.parseDouble(ele.elementText("price"));

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
