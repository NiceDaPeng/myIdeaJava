package testgui;

import javax.swing.*;
import java.awt.*;

public class Test {

    public static void main(String[] args) {

        /*
        * JFrame的管理方式是边界时管理 东西南北  BorderLayout
        * frame.setLayout(new FlowLayout()); 将管理方式设为流式管理
        * Panel的管理方式是流式管理  居中       FlowLayout
        * */
        //窗体的默认效果时隐藏状态
        JFrame frame = new JFrame("这是我的第一个窗体");

        //创建一个面板，一个窗体里面可以放很多面板。是一个无色透明的组件。
        //panel管理组件是流式的。
        JPanel panel = new JPanel();
        //创建一个标签
        JLabel userLabel = new JLabel("账户");
        JLabel passLabel = new JLabel("密码");
        //创建一个文本框
        JTextField text = new JTextField(30);
        //创建一个密码狂
        JPasswordField pass = new JPasswordField(30);
        //创建一个按钮对象
        JButton button = new JButton("Login");
        //创建复选框
        JCheckBox box = new JCheckBox("抽烟");
        JCheckBox box1 = new JCheckBox("喝酒");
        JCheckBox box2 = new JCheckBox("烫头");

        //创建单选按钮
        JRadioButton r1 = new JRadioButton("男");
        JRadioButton r2 = new JRadioButton("女");

        //将两个按钮添加到一个组里面,才能实现单选的效果
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        //创建一个文本域,如果要实现添加滚动条的效果，需要将文本域对象作为参数传递给滚动条对象
        JTextArea area = new JTextArea(5,10);
        JScrollPane pane = new JScrollPane(area);

        //添加菜单条，JMenuBar  默认放在窗口的上面
        // 菜单，JMenu
        // 菜单项 JMenuItem
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("file");
        JMenuItem newItem = new JMenuItem("new");
        menu.add(newItem);
        bar.add(menu);

        //设置按钮的显示内容
//        button.setText();-----
        frame.setJMenuBar(bar);
        panel.add(userLabel);
        panel.add(text);
        panel.add(passLabel);
        panel.add(pass);
        panel.add(box);
        panel.add(box1);
        panel.add(box2);
        panel.add(button);
        panel.add(r1);
        panel.add(r2);
        panel.add(pane);


        //设置不可拖拽大小，位置可以变，大小不让动
        frame.setResizable(false);
        //将按钮添加到窗体中
        frame.add(panel);
        //为窗体设置title
        //frame.setTitle("这是我的第一个窗体");------------
        //要想显示出来就要设置为可见状态
        frame.setVisible(true);
        //设置窗体的关闭方式
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置窗体的位置和宽高
        frame.setBounds(500,250,400,400);
    }
}
