package testgui;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class TestGUI {

    /**
     * @param str 方法中传递的参数
     * @throws FileNotFoundException 方法运行中可能会抛出的异常
     * @author dpj
     */
    public void test(String str) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("e");
    }


    public static void main(String[] args) {

        //1,先创建一个窗体
        JFrame frame = new JFrame();
        //创建一个面板
        JPanel panel = new JPanel();

        //添加一个按钮
        JButton button = new JButton("百度一下");
        //创建一个文本框
        JTextField text = new JTextField(20);
        //设置一个密码框
        JPasswordField password = new JPasswordField(20);
        //将按钮添加到窗体中

        panel.add(text);
        panel.add(password);
        panel.add(button);
        frame.add(panel);
        //设置窗体的title
        frame.setTitle("我的第一个窗体");
        //设置窗体出现的位置和宽高
        frame.setBounds(300,200,400,500);
        //设置窗体的属性状态从隐藏变为显示状态
        frame.setVisible(true);
        //设置点击关闭按钮的时候让程序关闭
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
