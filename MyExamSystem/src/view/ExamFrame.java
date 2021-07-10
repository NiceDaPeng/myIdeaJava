package view;

import bean.Question;
import service.QuestionService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExamFrame extends BaseFrame {

    //获取service对象
    private QuestionService question = MySpring.getBean("service.QuestionService");
    //获取一套试卷
    private ArrayList<Question> paper = question.getPaper(5);
    //创建一个存储学生答案的容器,创建一个数组，数组的长度与试卷集合的里的问题个数一致。
    private String[] answers = new String[paper.size()];
    //创建几个变量用来控制message个数的
    private int nowNum = 0;//用来记录当前题目的序号。
    private int totalCount = paper.size();//用来记录试题的总数
    private int answerCount = 0;//记录已经回答的题目数量。
    private int unanswerCount = totalCount;//记录未答的题目数量
    //创建一个线程对象用来控制时间的变化
    TimeControlThread timeControlThread = new TimeControlThread();
    //创建一个变量用来记录整数（以分钟为单位）
    private int time = 60;


    //添加构造方法
    public ExamFrame() {
        this.init();
    }

    public ExamFrame(String title) {
        super(title);
        this.init();
    }

    //添加三个panel 区域的分割
    private JPanel mainPanel = new JPanel();//负责答题主页面展示
    private JPanel messagePanel = new JPanel();//负责右侧信息展示
    private JPanel buttonPanel = new JPanel();//负责下方按钮的展示
    //添加主要答题的组件
    private JTextArea examArea = new JTextArea();//考试文本域 展示题目
    private JScrollPane scrollPane = new JScrollPane(examArea);//滚动条
    //添加右侧信息的组件
    private JLabel pictureLabel = new JLabel();//展示图片信息
    private JLabel nowNumLabel = new JLabel("当前题号：");//提示当前的题号
    private JLabel totalCountLabel = new JLabel("题目总数：");//提示题目的总数
    private JLabel answerCountLabel = new JLabel("已答题数：");//提示已经答过的题目数量
    private JLabel unanswerCountLabel = new JLabel("未答题数：");//提示未答题数量
    private JTextField nowNumField = new JTextField();//展示题号
    private JTextField totalCountField = new JTextField();//展示总数
    private JTextField answerCountField = new JTextField();//展示已答数
    private JTextField unanswerCountField = new JTextField();//展示未答数
    private JLabel timeLabel = new JLabel("剩余答题时间");//提示剩余时间
    private JLabel realTimeLabel = new JLabel("00:00:00");//倒计时真实时间
    //添加下方按钮的组件
    private JButton aButton = new JButton("A");//a按钮
    private JButton bButton = new JButton("B");//b按钮
    private JButton cButton = new JButton("C");//c按钮
    private JButton dButton = new JButton("D");//d按钮
    private JButton prevButton = new JButton("上一题");//previous题
    private JButton nextButton = new JButton("下一题");//next题
    private JButton submitButton = new JButton("提交试卷");//提交按钮

    @Override
    protected void setFontAndSoOn() {
        //设置panel布局管理---->自定义
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.LIGHT_GRAY);
        //设置message区域的位置
        messagePanel.setLayout(null);
        messagePanel.setBounds(680, 10, 300, 550);
        messagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        //设置button区域的位置
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(16, 470, 650, 90);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        //手动设置每一个组件的位置 字体 背景
        scrollPane.setBounds(16, 10, 650, 450);
        examArea.setFont(new Font("黑体", Font.BOLD, 34));

        examArea.setEnabled(false);//文本域中的文字不能编辑
        //设置message区域中的每一个组件位置 大小 颜色
        pictureLabel.setBounds(10, 10, 280, 230);
        pictureLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        //pictureLabel.setIcon(null);//展示图片信息
        nowNumLabel.setBounds(40, 270, 100, 30);
        nowNumLabel.setFont(new Font("黑体", Font.PLAIN, 20));
        nowNumField.setBounds(150, 270, 100, 30);
        nowNumField.setFont(new Font("黑体", Font.BOLD, 20));
        nowNumField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        nowNumField.setEnabled(false);
        nowNumField.setHorizontalAlignment(JTextField.CENTER);

        totalCountLabel.setBounds(40, 310, 100, 30);
        totalCountLabel.setFont(new Font("黑体", Font.PLAIN, 20));
        totalCountField.setBounds(150, 310, 100, 30);
        totalCountField.setFont(new Font("黑体", Font.BOLD, 20));
        totalCountField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        totalCountField.setEnabled(false);
        totalCountField.setHorizontalAlignment(JTextField.CENTER);

        answerCountLabel.setBounds(40, 350, 100, 30);
        answerCountLabel.setFont(new Font("黑体", Font.PLAIN, 20));
        answerCountField.setBounds(150, 350, 100, 30);
        answerCountField.setFont(new Font("黑体", Font.BOLD, 20));
        answerCountField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        answerCountField.setEnabled(false);
        answerCountField.setHorizontalAlignment(JTextField.CENTER);

        unanswerCountLabel.setBounds(40, 390, 100, 30);
        unanswerCountLabel.setFont(new Font("黑体", Font.PLAIN, 20));
        unanswerCountField.setBounds(150, 390, 100, 30);
        unanswerCountField.setFont(new Font("黑体", Font.BOLD, 20));
        unanswerCountField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        unanswerCountField.setEnabled(false);
        unanswerCountField.setHorizontalAlignment(JTextField.CENTER);

        timeLabel.setBounds(90, 460, 150, 30);
        timeLabel.setFont(new Font("黑体", Font.PLAIN, 20));
        timeLabel.setForeground(Color.BLUE);
        realTimeLabel.setBounds(108, 490, 150, 30);
        realTimeLabel.setFont(new Font("黑体", Font.BOLD, 20));
        realTimeLabel.setForeground(Color.BLUE);

        aButton.setBounds(40, 10, 120, 30);
        aButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bButton.setBounds(190, 10, 120, 30);
        bButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cButton.setBounds(340, 10, 120, 30);
        cButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dButton.setBounds(490, 10, 120, 30);
        dButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        prevButton.setBounds(40, 50, 100, 30);
        prevButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nextButton.setBounds(510, 50, 100, 30);
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitButton.setBounds(276, 50, 100, 30);
        submitButton.setForeground(Color.RED);
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//--------------------------------------------------------------------------------------
        //展示第一道题目
        this.showQuestionAndPicture();

        //设置右侧message中的组件值--用变量控制的
        nowNumField.setText(nowNum + 1 + "");
        totalCountField.setText(totalCount + "");
        answerCountField.setText(answerCount + "");
        unanswerCountField.setText(unanswerCount + "");
        realTimeLabel.setText(time+"");
    }
    //--------------------------------------------------------------------------------------


    @Override
    protected void addElement() {
        messagePanel.add(pictureLabel);
        messagePanel.add(nowNumLabel);
        messagePanel.add(nowNumField);
        messagePanel.add(totalCountLabel);
        messagePanel.add(totalCountField);
        messagePanel.add(answerCountLabel);
        messagePanel.add(answerCountField);
        messagePanel.add(unanswerCountLabel);
        messagePanel.add(unanswerCountField);
        messagePanel.add(timeLabel);
        messagePanel.add(realTimeLabel);
        buttonPanel.add(aButton);
        buttonPanel.add(bButton);
        buttonPanel.add(cButton);
        buttonPanel.add(dButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(submitButton);
        mainPanel.add(scrollPane);
        mainPanel.add(messagePanel);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
    }

    @Override
    protected void addListener() {
        //创建一个提交按钮的监听器
        submitButton.addActionListener(new ActionListener() {
            /**
             * @param e
             * 0，显示一个确认框
             * 1，让时间停止--线程来处理
             * 2，让所有按钮失效--
             * 3，最终成绩的计算，展示在中间的文本域中
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出一个确认框：是0，否1，取消2
                int value = JOptionPane.showConfirmDialog(ExamFrame.this,"是否确认提交试卷");
                if (value == 0){
                   // 0，显示一个确认框
//                * 1，让时间停止--线程来处理
                    timeControlThread.stopTimeThread();
//                * 2，让所有按钮失效--
                    ExamFrame.this.setOptionButtonEnable(false);
                    prevButton.setEnabled(false);
                    nextButton.setEnabled(false);

                    //3让按钮颜色恢复本色
                    ExamFrame.this.clearOptionButtonColor();
//                * 4，最终成绩的计算，展示在中间的文本域中
                    float score = ExamFrame.this.checkPaper();
                    examArea.setText("考试结束，您的最终考试成绩为：\n"+score+"");

                }
//
            }
        });

        //创建一个监听器用来监听上一题按钮
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //清楚所有按钮的颜色
                ExamFrame.this.clearOptionButtonColor();
                ExamFrame.this.setOptionButtonEnable(true);
                nextButton.setEnabled(true);
                nowNum--;
                //如果当前题号为0；已经到达第一题，上一题按钮金庸
                if (nowNum == 0) {
                    prevButton.setEnabled(false);
                }
                //还原之前的选项
                ExamFrame.this.restoreButton();
                //显示题目
                ExamFrame.this.showQuestionAndPicture();
                //修改题号
                nowNumField.setText(nowNum + 1 + "");
                answerCountField.setText(--answerCount + "");
                unanswerCountField.setText(++unanswerCount + "");

            }
        });

        //创建一个监听器对象用于下一题按钮
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //先清除所有选项按钮的颜色
                ExamFrame.this.clearOptionButtonColor();
                //当前题目序号增加一个
                nowNum++;
                //判断当前的题目是否到达最后一题
                if (nowNum == totalCount) {//已经到达最后一题了
                    examArea.setText("全部题目已经回答完毕\n请点击下方红色提交按钮");
                    //全部题目回答完毕，让下一个按钮失效
                    nextButton.setEnabled(false);
                    ExamFrame.this.setOptionButtonEnable(false);

                } else {//还没到最后一题，后面还有
                    //调用自己封装的方法显示下一个题目和图片
                    ExamFrame.this.showQuestionAndPicture();
                    //修改右侧的当前题号
                    nowNumField.setText(nowNum + 1 + "");
                }
                //修改右侧已答题和未答题数目
                answerCountField.setText(++answerCount + "");
                unanswerCountField.setText(--unanswerCount + "");

            }
        });
        //创建一个监听器对象用于四个选项按钮
        ActionListener optionListener = new ActionListener() {
            //将这个监听器对象绑定在四个选项按钮上
            @Override
            public void actionPerformed(ActionEvent e) {
                //清楚之前所有选项按钮的颜色
                ExamFrame.this.clearOptionButtonColor();
                //让被选中的按钮颜色变化。
                JButton button = (JButton) e.getSource();//获取到哪一个按钮被点击了。
                //让当前按钮颜色变化
                button.setBackground(Color.YELLOW);
                //将当前按钮的选项存储再answers数组中
                answers[nowNum] = button.getText();
            }
        };
        aButton.addActionListener(optionListener);
        bButton.addActionListener(optionListener);
        cButton.addActionListener(optionListener);
        dButton.addActionListener(optionListener);
    }

    @Override
    protected void setFrameSelf() {
        this.setBounds(260, 130, 1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);//不想让窗体拖拽大小
        this.setVisible(true);//最终展示整个窗体
        //启动自定义线程，进入就绪状态
        timeControlThread.start();
    }

    //================================================================

    //设计一个内部类，作用是为了处理时间倒计时的问题，倒计时跟窗口是并行操作的，所以要弄个单独的线程。
    private class TimeControlThread extends Thread{
        private boolean flag = true;
        public void stopTimeThread(){
            this.flag = false;
        }
        public void run(){
            //在线程启动的时候先把时间进行一个转化 HH：mm：ss
            int hour = time/60;
            int minute = time%60;
            int second = 0;
            while (flag) {
                //操作realTimeLabel来处理时间的显示
                //每次循环将消失分钟秒，三个变量内处理的数字进行拼串处理
                StringBuilder timeString = new StringBuilder();
                //处理小时
                if (hour >= 0 && hour < 10){
                    timeString.append("0");
                }
                timeString.append(hour);
                timeString.append(":");

                //处理分钟
                if (minute >= 0 && minute < 10){
                    timeString.append("0");
                }
                timeString.append(minute);
                timeString.append(":");
                //处理秒
                if (second >= 0 && second < 10){
                    timeString.append("0");
                }
                timeString.append(second);


//                SwingUtilities.invokeLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        realTimeLabel.setText(timeString.toString());
//                    }
//                });
                //展示拼接以后的时间字符串
                realTimeLabel.setText(timeString.toString());
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (second > 0){
                    second--;
                } else {//如果小于0 则说明秒数已经为0 了
                    if (minute > 0){
                        minute--;
                        second = 59;
                    } else {
                        if (hour > 0) {//小时还够用
                            hour--;
                            minute = 59;
                            second = 59;
                        }else {
//                            System.out.println("时间截至");
                            //如果时间不够了 时间显示为红色
                            realTimeLabel.setForeground(Color.RED);
                            ExamFrame.this.setOptionButtonEnable(false);
                            prevButton.setEnabled(false);
                            nextButton.setEnabled(false);
                            //弹出一个消息框，考试结束了请提交试卷
                            JOptionPane.showMessageDialog(ExamFrame.this,"考试结束，请提交试卷");
                            break;
                        }
                    }
                }
            }
        }
    }

    //设计一个方法负责计算最终的成绩
    private float checkPaper(){
        float score = 100;
        int size = paper.size();
        for (int i = 0; i < paper.size(); i++) {//paper是一个集合，每一题是一个Question的对象。里面有正确答案
            Question question = paper.get(i);
            String realAnswer = question.getAnswer();
            if (!realAnswer.equals(answers[i])){
                score -= (100/size);
            }
        }
        return score;
    }

    //设计一个方法负责还原上一题的选项
    private void restoreButton() {
        String answer = answers[nowNum];
        if (answer == null) {
            return;
        }
        switch (answer) {
            case "A":
                aButton.setBackground(Color.YELLOW);
                break;
            case "B":
                bButton.setBackground(Color.YELLOW);
                break;
            case "C":
                cButton.setBackground(Color.YELLOW);
                break;
            case "D":
                dButton.setBackground(Color.YELLOW);
                break;
            default:
                this.clearOptionButtonColor();
                break;
        }
    }

    //设计一个方法，让所有选项按钮失效
    public void setOptionButtonEnable(boolean key) {
        aButton.setEnabled(key);
        bButton.setEnabled(key);
        cButton.setEnabled(key);
        dButton.setEnabled(key);

    }

    //设计一个方法用来清楚所有选项按钮的颜色。、
    public void clearOptionButtonColor() {
        aButton.setBackground(null);
        bButton.setBackground(null);
        cButton.setBackground(null);
        dButton.setBackground(null);
    }


    //设计一个方法用来处理图片展示
    private ImageIcon drawImage(String path) {
        ImageIcon imageIcon = new ImageIcon(path);//通过给定的路径创建一个ImageIcon对象。
        //设置ImageIcon对象内的Image属性。
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(280, 230, Image.SCALE_DEFAULT));
        //将设置好的imageIcon对象返回
        return imageIcon;
    }

    //设计一个方法用来展示一道题目
    private void showQuestionAndPicture() {
        //获取当前的一道题目，从paper中获取
        Question question = paper.get(nowNum);
        //先获取当前Question图片路径
        String picture = question.getPicture();
        if (picture != null) {
            pictureLabel.setIcon(this.drawImage("src/img/" + picture));
        } else {

            pictureLabel.setIcon(null);
        }
        examArea.setText((nowNum + 1) + "." + question.getTitle().replace("<br>", "\n   "));
        //处理题目中的标记<br>用这个来表示换行
    }

}
