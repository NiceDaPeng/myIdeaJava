package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SpringSendEmail {

    public static void main(String[] args) throws MessagingException {

        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        JavaMailSender sender = (JavaMailSenderImpl) factory.getBean("sender");
        //利用这个sender来创建一个邮件对象
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo("1632752770@qq.com");
        helper.setSubject("Spring主题");
        helper.setFrom("1632752770@qq.com");
        helper.setText("Spring内容");
        sender.send(message);
        System.out.println("发送成功");

    }
}
