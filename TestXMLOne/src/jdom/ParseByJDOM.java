package jdom;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParseByJDOM {

    public static void main(String[] args) {


        try {
            //想要通过JDOM解析需要获取一个builder对象
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(new File("src/parsedom/school.xml"));
            Element school = document.getRootElement();
            String sid = school.getAttributeValue("id");
            String sname = school.getAttributeValue("name");
            String loc = school.getAttributeValue("loc");
            System.out.println(sid+"--"+sname+"-"+loc);
//            Element classEle = school.getChild("class");
            //获取所有的子标签
            List<Element> children = school.getChildren("class");
            for (Element element :
                    children) {
                String classId = element.getAttributeValue("id");
                String className = element.getAttributeValue("name");
                String classLoc = element.getAttributeValue("loc");
                System.out.println("\t\t"+classId+"-"+className+"-"+classLoc);
                Element teacher = element.getChild("teacher");
                String teaId = teacher.getAttributeValue("id");
                String teaName = teacher.getAttributeValue("name");
                String teaAge = teacher.getAttributeValue("age");
                Element sex = teacher.getChild("sex");
                String teaSex = sex.getText();
                System.out.println("\t\t\t\t"+teaId+"-"+teaName+"-"+teaAge+"-"+teaSex);
                List<Element> student = element.getChildren("student");
                for (Element stuEle :
                        student) {
                    String stuId = stuEle.getAttributeValue("id");
                    String stuName = stuEle.getAttributeValue("name");
                    String stuAge = stuEle.getAttributeValue("age");
                    //如果只有一个子标签，我们可以通过如下的方式直接来获取里面的文字内容
                    String stuSex = stuEle.getChildText("sex");
//                    Element sex1 = stuEle.getChild("sex");
//                    String stuSex = sexEle.getText();
                    System.out.println("\t\t\t\t"+stuId+"-"+stuName+"-"+stuAge+"-"+stuSex);
                }
            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
