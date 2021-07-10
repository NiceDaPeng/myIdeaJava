package com.dpj.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {
    static Properties pro = new Properties();
    static {

        try {
            pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("first.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Object getBean(String name){

        Object obj = null;
        try {
            String value = (String) pro.get(name);
            System.out.println(value);
            Class clazz = Class.forName(value);
            obj = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
