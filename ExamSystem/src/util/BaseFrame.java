package util;

import javax.swing.*;

public abstract class BaseFrame extends JFrame {

    public BaseFrame(){}
    public BaseFrame(String title){
        super(title);
    }

    public void init(){
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameself();
    }

    //每个窗体都有属性
    //每个窗体都要设计颜色，背景，大小，布局等
    protected abstract void setFontAndSoOn();
    //将属性添加到窗体里
    protected abstract void addElement();
    //添加事件监听
    protected abstract void addListener();
    //设置窗体自身
    protected abstract void setFrameself();
}
