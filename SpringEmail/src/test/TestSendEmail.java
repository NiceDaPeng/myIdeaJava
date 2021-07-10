package test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class TestSendEmail {
    public static void main(String[] args) throws MessagingException {
        //下载一个mail.jar
        //导包
        //创建一个用于存放配置信息的对象：Properties
        Properties pro = new Properties();
        //设置发送邮件需要的一些信息
        //给一个发送邮件的协议
        pro.put("mail.transport.protocol","smtp");//必须有的
        //设置发送邮件的主机名，基于的是哪个邮箱
        pro.put("mail.smtp.host","smtp.qq.com");//必须的
        //设置发送邮件的端口，默认是25端口，还有110,143,465
//        pro.put("mail.smtp.port","xxx");  不是必须的，默认是25
        //设置发送邮件时，是否需要身份认证  默认是true
//        pro.put("mail.smtp.auth",true);
        //设置是否使用SSL安全链接，默认是使用的
//        pro.put("mail.smtp.ssl.enable",true);

        //创建一个session对象，可以理解为是一个socket，在java和邮箱之间建立一个链接。
        Session session = Session.getDefaultInstance(pro);
        //通过session对象获取一个transport对象，可以理解为是一个流对象，可以做输入输出
        Transport ts = session.getTransport();
        //想要通过邮箱发送邮件，必须得到邮件服务器的认证  user:邮箱的号码比如：xxx@qq.com
        ts.connect("1632752770@qq.com","brszzfmlvlsycdii");
        //发送的是一封邮件，邮件可以看做是一个对象，我们没有邮件对象，所以需要创建一个邮件的映射关系
        //创建邮件本身比较复杂，需要好多信息，所以单独写一个方法
        Message message = createMessage(session);
        //发送邮件，需要message对象，还要知道message对象中的接收人。
        ts.sendMessage(message,message.getAllRecipients());
        //关闭通道
        ts.close();
        System.out.println("发送完毕");
    }

    //设计一个方法用来创建一个邮件对象
    //需要一个参数，session ，操作以后需要返回一个邮件对象，MimeMessage是个映射
    public static Message  createMessage(Session session) throws MessagingException {
        //自己创建一个邮件对象
        Message message = new MimeMessage(session);
        //设置邮件的基本信息
        //1，设置发送人
        message.setFrom(new InternetAddress("1632752770@qq.com"));
        //设置接收人  需要一个接收人的类型；收件人TO、抄送人CC；密送人BCC
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("1632752770@qq.com"));
        //设置发送邮件的时间，因为时间不一定是现在，可以是一个小时以后
        message.setSentDate(new Date());
        //设置发送的主题
        message.setSubject("测试发送邮件");
        //设置发送邮件的正文
        message.setText("我是测试邮件的正文");

        //所有的设置需要保存才能生效。它只是一个映射对象
        message.saveChanges();

        //返回message对象
        return message;
    }
}
