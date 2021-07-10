package view;

import Service.UserService;
import util.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends BaseFrame {
    public LoginFrame(){
        this.init();
    }
    public LoginFrame(String title){
        super(title);
        this.init();
    }

    private JPanel panel = new JPanel();
    private JLabel titleLabel = new JLabel("在 线 考 试 系 统");
    private JLabel accountLabel = new JLabel("账 户");
    private JLabel passLabel = new JLabel("密 码");
    private JTextField accountField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("登 录");
    private JButton exitButton = new JButton("退 出");

    //设置每一个组件的位置和大小
    protected void setFontAndSoOn(){
        panel.setLayout(null);
        titleLabel.setBounds(120,40,340,35);
        titleLabel.setFont(new Font("黑体", Font.BOLD,34));

        accountLabel.setBounds(94,124,90,30);
        accountLabel.setFont(new Font("黑体",Font.BOLD,24));

        accountField.setBounds(204,124,260,30);
        accountField.setFont(new Font("黑体",Font.BOLD,24));

        passLabel.setBounds(94,174,90,30);
        passLabel.setFont(new Font("黑体",Font.BOLD,24));

        passwordField.setBounds(204,174,260,30);
        passwordField.setFont(new Font("黑体",Font.BOLD,24));

        loginButton.setBounds(154,232,100,30);
        loginButton.setFont(new Font("黑体",Font.BOLD,22));

        exitButton.setBounds(304,232,100,30);
        exitButton.setFont(new Font("黑体",Font.BOLD,22));
    }

    //将所有的组件添加再窗体上
    protected void addElement(){
        panel.add(titleLabel);
        panel.add(accountLabel);
        panel.add(accountField);
        panel.add(passLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(exitButton);
        this.add(panel);
    }

    //绑定事件监听
    protected void addListener(){

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText();
                char[] password = passwordField.getPassword();
                UserService service = new UserService();
                String password1 = new String(password);
                String result = service.login(account,password1);
                if (result.equals("登录成功")){
                    //将登录窗口隐藏
                    LoginFrame.this.setVisible(false);
                    //弹出一个新的页面
                    new ExamFrame("考试窗口"+account);
                        System.out.println(result);
                }else {
                    //弹出一个框
                    JOptionPane.showMessageDialog(LoginFrame.this,result);
                    //登录失败设置密码狂为null
                    accountField.setText("");
                    passwordField.setText("");
                    System.out.println(result);
                }
            }
        });
    }

    protected void setFrameself(){
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(400,200,560,340);
        this.setResizable(false);
    }
}
