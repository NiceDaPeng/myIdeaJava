package com.dpj.study;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class Test02 {
    private static ArrayList<Book > bookList = new ArrayList<>();

    public static void main(String[] args) {

        //创建一个SaxReader对象，用来对XML文件进行读取
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read("src/xml/books.xml");
            //通过document对象获取xml文件中的根元素
            Element rootElement = document.getRootElement();
            //通过根元素获取里面所有的元素
            List<Element> list = rootElement.elements("book");
            for (Element book :
                    list) {
                String sn = book.attributeValue("sn");

                String name = book.elementText("name");
                String author = book.elementText("author");
                String price = book.elementText("price");
                System.out.println(sn+""+name+""+author+""+price);
                bookList.add(new Book(sn,name,author,Double.parseDouble(price)));
            }
            System.out.println(bookList.get(0));
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
