package com.dpj.testinitializing;

import org.springframework.beans.factory.InitializingBean;

public class TestInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("对象被初始化了");
    }
}
