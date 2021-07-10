package domain;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class TestDom4j {

    @Test
    public void test() throws DocumentException {
        //创建一个SaxReader输入流，去读取xml文件，生成document对象
        SAXReader sax = new SAXReader();
        //读取xml文件生成document对象
        Document doucument = sax.read("src/books.xml");
        System.out.println(doucument);
    }
    @Test
    public void test2() throws DocumentException {
        //读取books.xml文件生成book类
       //1读取xml文件
        SAXReader sax = new SAXReader();
        //在junit中相对路径是从模块名开始算的。
        Document doc = sax.read("src/books.xml");
        //2通过document对象获取根元素
        Element rootElement = doc.getRootElement();
        System.out.println(rootElement);
        //3通过根元素获取book标签对象
        //element（String）和elements（String）都是通过标签查找子元素,element是查找单个元素
        List<Element> books = rootElement.elements("book");
        //4遍历，处理每个标签内容转换为标签类
        for (Element book :
                books) {
            //saxml是将标签对象转化为标签字符串
//            System.out.println(book.asXML());
            //通过标签名获取标签对象
            Element nameElement = book.element("name");
            //通过标签对象的getText（）方法来获取标签中的内容
            String nameText = nameElement.getText();
//            System.out.println(nameText);
            //直接通过指定标签名来获取标签中的文本内容
            String author = book.elementText("author");
            String price = book.elementText("price");
            //获取标签对象的属性值。
            String sn = book.attributeValue("sn");

            System.out.println(new Book(sn,nameText,author,Double.parseDouble(price)));
        }
    }
}
