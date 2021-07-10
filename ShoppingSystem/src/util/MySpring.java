package util;

import java.util.HashMap;

public class MySpring {

    //单例模式创建对象。
    private static HashMap<String,Object> beanBox = new HashMap<>();
    public static  <T>T getBean(String className){
        T obj = (T)beanBox.get(className);
        if (obj == null){
            try {
                Class<?> clazz = Class.forName(className);
                obj = (T)clazz.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
