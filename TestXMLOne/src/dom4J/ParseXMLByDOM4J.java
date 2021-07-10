package dom4J;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class ParseXMLByDOM4J {


    public static void main(String[] args) {

        //创建对象
        SAXReader reader = new SAXReader();
        try {
            //生成document对象
            Document document = reader.read(new File("src/parsedom/school.xml"));
            //获取根元素
            Element school = document.getRootElement();
            String sid = school.attributeValue("id");
            String sname = school.attributeValue("name");
            String sloc = school.attributeValue("loc");
            System.out.println(sid+"-"+sname+"-"+sloc);
            List<Element> classList = school.elements("class");
            for (Element classEle :
                    classList) {
                String cid = classEle.attributeValue("id");
                String cname = classEle.attributeValue("name");
                String cloc = classEle.attributeValue("loc");
                Element teacher = classEle.element("teacher");
                String tid = teacher.attributeValue("id");
                String tname = teacher.attributeValue("name");
                Attribute tage = teacher.attribute("age");
                Element sex = teacher.element("sex");
                String tsex = sex.getText();
                System.out.println(tid+"-"+tname+"-"+tage+"-"+tsex);
                List<Element> student = classEle.elements("student");
                for (Element stuEle :
                        student) {
                    String stuid = stuEle.attributeValue("id");
                    String stuname = stuEle.attributeValue("name");
                    String stuage = stuEle.attributeValue("age");
                    //如果子标签只有一个想要获取其中的内容可直接通过如下的方式来获取。
                    String stuSex = stuEle.elementText("sex");

                    System.out.println(stuid+"-"+stuname+"-"+stuage+"-"+stuSex);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
