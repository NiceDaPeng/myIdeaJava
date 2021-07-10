package com.dpj.study;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Test extends Exception {
    public static void main(String[] args) {

        //创建一个SAXReader输入流对象，去读取xml配置文件，生成document对象
//        SAXReader saxReader = new SAXReader();
//        try {
//
//            Document document = saxReader.read("src/books.xml");
////            System.out.println(document);
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            test01();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//        try {
//            test01();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
    }

    public static void test01() throws DocumentException {
        //读取books.xml文件生成book类
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");

        //通过Dom对象获取根元素，
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement);
        //遍历处理每个book标签转化为book类
        //然后在通过根元素得到每一个book对象
        List<Element> books = rootElement.elements("book");//element（）和elements（）都是通过标签名查找子元素
        for (Element book :
                books) {
//            book.asXML();//asxml()方法是把标签对象转化为标签字符串
//            Element name = book.element("name");
//            String nameText = name.getText();
//            System.out.println(nameText);
            String nameText = book.elementText("name");
            String priceVal = book.elementText("price");
            System.out.println(priceVal);
            String authorVal = book.elementText("author");
            String snVal = book.attributeValue("sn");
            System.out.println(new Book(snVal, nameText, authorVal, Double.parseDouble(priceVal)));
        }
    }

}
