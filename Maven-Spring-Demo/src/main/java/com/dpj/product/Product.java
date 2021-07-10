package com.dpj.product;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean,DisposableBean{

    public void init(){
        System.out.println("Product.init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product.afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Product.destroy");
    }

    public void myDestory(){
        System.out.println("Product.myDestory");
    }
}
