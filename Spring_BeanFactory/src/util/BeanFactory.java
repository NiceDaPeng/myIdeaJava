package util;

import java.io.IOException;
import java.util.Properties;

public class BeanFactory {
    private static Properties pro = new Properties();
    static {
        try {
            pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("ApplicationContext.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //工厂类里面有一个方法用来生产类的对象的
    public static Object getBean(String key){
        Object obj = null;
        try {
            Class clazz = Class.forName(pro.getProperty(key));
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
