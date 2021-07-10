package parsedom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Dom {


    public static void main(String[] args) {

        //采用DOM的方式解析XML  那么就需要获取document对象


        try {
            //1，先需要一个工厂，提供工人
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //2,利用工厂创建工人 会产生异常。
            DocumentBuilder builder = factory.newDocumentBuilder();
            //3，工人创建Document对象，需要一张图纸
            Document document = builder.parse(new File("src/parsedom/school.xml"));
            //4,获取根标签对象 方式一
            Element school = document.getDocumentElement();
            //获取根标签对象：方式二
//            Element huangpujunxiao = document.getElementById("huangpujunxiao");
            //获取根标签 方式三：
//            NodeList rootList = document.getElementsByTagName("school");
//            Element item = (Element) rootList.item(0);
            //5,获取school标签中的属性
            String schoolId = school.getAttribute("id");
            String schoolName = school.getAttribute("name");
            String schoolLoc = school.getAttribute("loc");
            System.out.println(schoolId+"--"+schoolName+"--"+schoolLoc);
            NodeList classList = school.getElementsByTagName("class");
            for (int i = 0; i < classList.getLength(); i++) {
                Element  classEle= (Element)classList.item(i);
                String classid = classEle.getAttribute("id");
                String className = classEle.getAttribute("name");
                String classLoc = classEle.getAttribute("loc");
                System.out.println("\t\t"+classid+"--"+className+"--"+classLoc);

                NodeList teacherList = classEle.getElementsByTagName("teacher");
                Element teacherEle = (Element) teacherList.item(0);
                String teaId = teacherEle.getAttribute("id");
                String teaName = teacherEle.getAttribute("name");
                String teaAge = teacherEle.getAttribute("age");
                Element teaSex = (Element) teacherEle.getElementsByTagName("sex").item(0);
                System.out.println("\t\t\t\t"+teaId+"--" + teaName+"--" + teaAge+"--"+teaSex.getTextContent());

                NodeList stuList = classEle.getElementsByTagName("student");
                for (int j = 0; j < stuList.getLength(); j++) {
                    Element stuEle = (Element) stuList.item(j);
                    String stuId = stuEle.getAttribute("id");
                    String stuName = stuEle.getAttribute("name");
                    String stuAge = stuEle.getAttribute("age");
                    NodeList sexList = stuEle.getElementsByTagName("sex");
                    Element sexEle = (Element) sexList.item(0);
                    System.out.println("\t\t\t\t"+stuId+"--"+stuName+"--"+stuAge+"--"+sexEle.getTextContent());
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
