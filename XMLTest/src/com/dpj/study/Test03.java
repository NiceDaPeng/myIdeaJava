package com.dpj.study;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class Test03 {

    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();

        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read("src/books.xml");
            Element rootElement = document.getRootElement();
            List<Element> books = rootElement.elements("book");
            for (Element ele :
                    books) {
                String bsn=ele.attributeValue("sn");
                String bname = ele.elementText("name");
                String bauthor=ele.elementText("author");
                Double bprice=Double.parseDouble(ele.elementText("price"));
                System.out.println(bsn+""+bname+""+bauthor+""+bprice);
                list.add(new Book(bsn,bname,bauthor,bprice));
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getSn());
        }
    }
}
