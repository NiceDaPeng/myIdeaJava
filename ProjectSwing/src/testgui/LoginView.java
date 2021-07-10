package testgui;

import javax.swing.*;

public class LoginView {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(500,500,500,500);
        JLabel label = new JLabel("在线考试系统");
        JLabel l1 = new JLabel("账户");
        JTextField text1 = new JTextField();
        JTextField text2 = new JTextField();
        JLabel l2 = new JLabel("密码");

        JPanel panel = new JPanel();

        panel.add(label);
        panel.add(l1);
        panel.add(text1);
        panel.add(l2);
        panel.add(text2);
        frame.add(panel);
    }
}
